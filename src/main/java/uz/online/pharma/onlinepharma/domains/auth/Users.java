
package uz.online.pharma.onlinepharma.domains.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.online.pharma.onlinepharma.domains.Auditable;
import uz.online.pharma.onlinepharma.enums.Language;
import uz.online.pharma.onlinepharma.enums.auth.UserStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_users")
public class Users extends Auditable {

    @Column(unique = true, nullable = false)
    private String principal;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(unique = true)
    private String chatId;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDateTime lastLoginAt;

    private int loginTryCount;

    @ManyToMany
    @JoinTable(
            name = "auth_user_roles",
            joinColumns = @JoinColumn(name = "auth_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;

}
