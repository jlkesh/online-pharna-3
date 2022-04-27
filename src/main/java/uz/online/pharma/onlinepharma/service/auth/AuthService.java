package uz.online.pharma.onlinepharma.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.online.pharma.onlinepharma.criteria.auth.UserCriteria;
import uz.online.pharma.onlinepharma.domains.auth.AuthToken;
import uz.online.pharma.onlinepharma.domains.auth.Users;
import uz.online.pharma.onlinepharma.dto.auth.TokenCreateDTO;
import uz.online.pharma.onlinepharma.dto.auth.UserDetails;
import uz.online.pharma.onlinepharma.repository.auth.AuthTokenRepository;
import uz.online.pharma.onlinepharma.repository.auth.UserRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthTokenRepository authTokenRepository;


    @Override
    public UserDetails loadUserByUsername(String principal) throws UsernameNotFoundException {
        Users users = userRepository.find(UserCriteria.childBuilder().principal(principal).build());
        if (Objects.isNull(users))
            throw new RuntimeException("User not found with principal '%s'.".formatted(principal));
        return new UserDetails(users);
    }

    public void storeToken(TokenCreateDTO dto) {
        AuthToken authToken = new AuthToken();
        authToken.setTokenType(dto.getTokenType());
        authToken.setExpiresAt(dto.getExpiresAt());
        authToken.setIssuedAt(dto.getIssuedAt());
        authToken.setCreatedBy(dto.getCreatedBy());
        authTokenRepository.save(authToken);
    }
}
