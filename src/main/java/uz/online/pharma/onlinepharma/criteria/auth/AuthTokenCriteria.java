package uz.online.pharma.onlinepharma.criteria.auth;

import lombok.*;
import uz.online.pharma.onlinepharma.criteria.GenericCriteria;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthTokenCriteria extends GenericCriteria {
    private String token;
    private LocalDateTime expiresAt;

}
