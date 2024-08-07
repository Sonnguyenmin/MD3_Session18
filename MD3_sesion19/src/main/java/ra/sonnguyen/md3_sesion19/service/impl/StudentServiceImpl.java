package ra.sonnguyen.md3_sesion19.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.sonnguyen.md3_sesion19.entity.Student;
import ra.sonnguyen.md3_sesion19.repository.StudentRepository;
import ra.sonnguyen.md3_sesion19.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }
}
