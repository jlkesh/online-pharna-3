package uz.online.pharma.onlinepharma.config.security.filters;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.online.pharma.onlinepharma.config.security.JWTUtils;
import uz.online.pharma.onlinepharma.domains.auth.Users;
import uz.online.pharma.onlinepharma.dto.response.AppErrorDto;
import uz.online.pharma.onlinepharma.dto.response.DataDto;
import uz.online.pharma.onlinepharma.repository.auth.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final ObjectMapper mapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getServletPath().equals("/access/token") || request.getServletPath().equals("/refresh/token")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String token = authorizationHeader.substring("Bearer ".length());
                // TODO: 27/04/22 check if token exists in our db if not raise exception
                Users users = null;

                DecodedJWT decodedJWT = JWTUtils.getVerifier().verify(token);

                List<SimpleGrantedAuthority> authorities = decodedJWT.getClaim("authorities").asList(SimpleGrantedAuthority.class);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(users.getPrincipal(), null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                filterChain.doFilter(request, response);

            } catch (Exception exception) {
                SecurityContextHolder.clearContext();
                log.error("Error logging in: {}", exception.getMessage());
                response.setHeader("error", exception.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());


                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                mapper.writeValue(response.getOutputStream(),
                        new DataDto<>(new AppErrorDto(HttpStatus.FORBIDDEN,
                                exception.getLocalizedMessage(),
                                request.getRequestURI())));
            }
            return;
        }
        filterChain.doFilter(request, response);
    }
}
