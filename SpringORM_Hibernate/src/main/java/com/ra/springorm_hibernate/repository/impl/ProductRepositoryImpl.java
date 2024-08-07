package com.ra.springorm_hibernate.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ra.springorm_hibernate.model.entity.Product;
import com.ra.springorm_hibernate.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createCriteria(Product.class).list();
            return list;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public Product getProductById(Integer productId) {
        Session session = sessionFactory.openSession();
        try{
            Product product = session.get(Product.class, productId);
            return product;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(product);
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
    public boolean update(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(product);
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
    public boolean delete(Integer productId) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(getProductById(productId));
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
    public List<Product> findByName(String productName) {
        Session session = sessionFactory.openSession();
        try{
            if(productName==null || productName.isEmpty())
                productName = "%";
            else
                productName = "%"+productName+"%";
            List list = session.createQuery("from Product where productName like :productName")
                    .setParameter("productName",productName)
                    .list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
