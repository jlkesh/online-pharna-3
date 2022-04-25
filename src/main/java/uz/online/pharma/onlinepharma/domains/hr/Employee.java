package uz.online.pharma.onlinepharma.domains.hr;

import lombok.*;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String fullName;

    private String profileImage;

    @OneToOne
    private Position position;


}
