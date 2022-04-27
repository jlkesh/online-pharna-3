package uz.online.pharma.onlinepharma.config.security.filters;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import uz.online.pharma.onlinepharma.config.security.JWTUtils;
import uz.online.pharma.onlinepharma.domains.auth.Users;
import uz.online.pharma.onlinepharma.dto.auth.LoginDTO;
import uz.online.pharma.onlinepharma.dto.auth.SessionDTO;
import uz.online.pharma.onlinepharma.dto.auth.TokenCreateDTO;
import uz.online.pharma.onlinepharma.dto.response.DataDto;
import uz.online.pharma.onlinepharma.enums.auth.TokenType;
import uz.online.pharma.onlinepharma.service.auth.AuthService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    private final ObjectMapper mapper;

    public CustomAuthenticationFilter(AuthenticationManager manager, AuthService authService, ObjectMapper mapper) {
        this.authenticationManager = manager;
        this.authService = authService;
        this.mapper = mapper;
        super.setFilterProcessesUrl("/api/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            LoginDTO loginDto = new ObjectMapper().readValue(request.getReader(), LoginDTO.class);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getPrincipal(), loginDto.getPassword());
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new BadCredentialsException(e.getMessage(), e.getCause());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authentication) throws IOException, ServletException, IOException {

        Users user = (Users) authentication.getPrincipal();

        Date expiryForAccessToken = JWTUtils.getExpiry();

        Date expiryForRefreshToken = JWTUtils.getExpiryForRefreshToken();

        Date issuedAt = new Date();

        String accessToken = JWT.create()
                .withSubject("" + user.getId())
                .withClaim("authorities", getAuthorities(user))
                .withExpiresAt(expiryForAccessToken)
                .withIssuer(request.getRequestURL().toString())
                .withIssuedAt(issuedAt)
                .sign(JWTUtils.getAlgorithm());


        String refreshToken = JWT.create()
                .withSubject("" + user.getId())
                .withExpiresAt(expiryForRefreshToken)
                .withIssuer(request.getRequestURL().toString())
                .withIssuedAt(issuedAt)
                .sign(JWTUtils.getAlgorithm());

        SessionDTO sessionDto = SessionDTO.builder()
                .accessToken(accessToken)
                .accessTokenExpiry(expiryForAccessToken.getTime())
                .refreshToken(refreshToken)
                .refreshTokenExpiry(expiryForRefreshToken.getTime())
                .issuedAt(System.currentTimeMillis())
                .build();

        authService.storeToken(TokenCreateDTO.builder()
                .token(accessToken)
                .tokenType(TokenType.ACCESS)
                .expiresAt(expiryForAccessToken)
                .issuedAt(issuedAt)
                .createdBy(user.getId())
                .build());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getOutputStream(), new DataDto<>(sessionDto));
    }

    @NotNull
    private List<SimpleGrantedAuthority> getAuthorities(Users user) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            authorities.addAll(role.getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getAuthority())).toList());
        });
        return authorities;
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        // TODO: 27/04/22 update login try count
        super.unsuccessfulAuthentication(request, response, failed);
    }
}