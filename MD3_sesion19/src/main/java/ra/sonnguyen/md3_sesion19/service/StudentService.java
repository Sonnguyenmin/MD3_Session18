package ra.sonnguyen.md3_sesion19.service;

import ra.sonnguyen.md3_sesion19.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    boolean save(Student student);
}
