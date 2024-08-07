package ra.sonnguyen.md3_sesion19.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table (name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long studentId;

    @Column(name = "full_Name", length = 100)
    @NotBlank(message = "Họ và tên không được để trống")
    private String fullName;

    @Column(name = "gender")
    @NotNull(message = "Giới tính Không được để trống" )
    private Boolean gender;

    @Column(name = "birthday")
    @NotNull(message = "Ngày sinh Không được để trống")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Past(message = "Ngày sinh không hợp lệ")
    private Date birthday;

    @Column(name = "address" , length = 200)
    @NotBlank(message = "Địa chỉ là không được để trống")
    private String address;


    @Column(name = "className" , length = 100)
    @NotBlank(message = "Tên lớp không được để trống")
    private String className;

    @Column(name = "avatar", length = 250)
    private String avatar;
}
