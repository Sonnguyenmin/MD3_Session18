package ra.sonnguyen.demo_jv240408_md3.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.sonnguyen.demo_jv240408_md3.dao.IAccountDao;
import ra.sonnguyen.demo_jv240408_md3.model.entity.Account;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IAccountDaoImpl implements IAccountDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<Account> findAll() {
        Session session = sessionFactory.openSession();
        try {
//            return session.createQuery("select a from Account a", Account.class).getResultList();
            List accountsList = session.createQuery("from Account ").list();
            return accountsList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public Account getAccountById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            Account account = session.get(Account.class, id);
            return account;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean saveAccount(Account account) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(account);
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

    @Override
    public Boolean updateAccount(Account account) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(account);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Boolean deleteAccount(Long id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(getAccountById(id));
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

    @Override
    public List<Account> getAccountByName(String accountName) {
        Session session = sessionFactory.openSession();
        try {
            if (accountName == null || accountName.isEmpty()) {
                accountName = "%";
            }
            else {
                accountName = "%" + accountName + "%";
            }
            List list = session.createQuery("from Account where fullName like: accountName").setParameter("accountName", accountName).list();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
}
