package com.ra.springorm_hibernate.repository.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ra.springorm_hibernate.model.entity.Category;
import com.ra.springorm_hibernate.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        try{
            List list = session.createQuery("from Category").list();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(Category category) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(category);
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
    public boolean update(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(category);
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
    public boolean delete(Integer categoryId) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(getCategoryById(categoryId));
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        Session session = sessionFactory.openSession();
        try{
            Category category = session.get(Category.class, categoryId);
            return category;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
