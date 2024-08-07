package ra.sonnguyen.md3_sesion19.repository;

import ra.sonnguyen.md3_sesion19.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    boolean save(Student student);
}
