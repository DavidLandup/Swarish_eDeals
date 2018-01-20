package com.eDeals.DAO.impl;

import com.eDeals.DAO.ProductDao;
import com.eDeals.Model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {


    @Autowired
    private SessionFactory sessionFactory;

    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }

    public List<Product> getProductByPage(int page) {
        int perpage = 5;
        Session session = sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("from Product p order by p.productName").setFirstResult(page * perpage).setMaxResults(perpage).list();
        return productList;
    }

    public Long pages() {
        Long result = ((Double) Math.ceil((Long) sessionFactory.getCurrentSession().createQuery("select count(id) from Product").uniqueResult() / 5.0)).longValue();

        return result;
    }

    public Long pagesByCat(String categoryName) {
        Long result = ((Double) Math.ceil((Long) sessionFactory.getCurrentSession().createQuery("select count(p.id) from Product p where p.productSubCategory = " + "'" + categoryName + "'").uniqueResult() / 5.0)).longValue();

        return result;
    }

    public List<Product> getProductByCategory(String categoryName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from Product p where p.productCategory = " + "'" + categoryName + "'" + "order by p.productName ");
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    public List<Product> getProductByCategoryByPage(String categoryName, int page) {
        int perpage = 5;
        Session session = sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("select p from Product p where p.productCategory = " + "'" + categoryName + "'" + "order by p.productName ").setFirstResult(page * perpage).setMaxResults(perpage).list();
        return productList;
    }

    public List<Product> getAllProductsForUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from Product p where p.productOwner = " + "'" + username + "'");
        List<Product> productList = query.list();
        session.flush();
        return productList;
    }


    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product p order by p.productName");
        List<Product> productList = query.list();
        session.flush();
        return productList;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();

    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();

    }

    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();

    }

    public List<Product> blurrySearch(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from Product p where p.productName LIKE :title order by p.productName ");
        query.setParameter("title", "%" + title + "%");
        List<Product> productList = query.list();
        session.flush();
        return productList;
    }

}
