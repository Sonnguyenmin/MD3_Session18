package ra.sonnguyen.demo_jv240408_md3.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "acount")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="fullName", length = 100, nullable = false)
    private String fullName;
    @Column(name ="email", length = 50, unique = true, nullable = false)
    private String email;
    @Column(name = "password", length = 8, nullable = false)
    private String password;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "status")
    private Boolean status;
}
