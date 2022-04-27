package uz.online.pharma.onlinepharma.dto.auth;

import lombok.*;
import uz.online.pharma.onlinepharma.dto.BaseDTO;
import uz.online.pharma.onlinepharma.enums.auth.TokenType;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenCreateDTO implements BaseDTO {
    private String token;
    private Date expiresAt;
    private Date issuedAt;
    private TokenType tokenType;
    private Long createdBy;
}
