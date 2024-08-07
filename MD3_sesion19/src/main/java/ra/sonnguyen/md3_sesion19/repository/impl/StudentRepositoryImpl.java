package ra.sonnguyen.md3_sesion19.repository.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ra.sonnguyen.md3_sesion19.entity.Student;
import ra.sonnguyen.md3_sesion19.repository.StudentRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        try {
            List list = session.createQuery("from Student").list();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return false;
    }
}
