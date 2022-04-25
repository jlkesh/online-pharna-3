package uz.online.pharma.onlinepharma.domains.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.online.pharma.onlinepharma.domains.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Permission extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

}