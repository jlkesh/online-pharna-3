package uz.online.pharma.onlinepharma.domains.auth;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.online.pharma.onlinepharma.domains.Auditable;
import uz.online.pharma.onlinepharma.enums.auth.TokenType;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_token")
public class AuthToken extends Auditable {

    @Column(unique = true, nullable = false)
    private String token;

    @Column(nullable = false)
    private Date expiresAt;

    @Column(nullable = false)
    private Date issuedAt;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.ACCESS;

}
