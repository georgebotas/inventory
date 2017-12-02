package com.georgebotas.inventory;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

@Component
public class DbOps implements IDbOps {
    EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Inventory");
    private EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    private EntityTransaction transaction;


    @Override
    public boolean validateID(Long product_ID) {

        //transaction = manager.getTransaction();
        //transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        if (product == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validateStock(Long product_ID, int productRemove) {

        Product product = manager.find(Product.class, product_ID);
        if (product.getStock() - productRemove < 0) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Product> productList() throws Exception {
        ArrayList<Product> products = null;
        transaction = manager.getTransaction();
        transaction.begin();
        products = (ArrayList<Product>) manager.createQuery("SELECT c FROM Product c", Product.class).getResultList();
        transaction.commit();
        return products;
    }

    @Override
    public void addToStock(Long product_ID, int productAdd) throws Exception {
        transaction = manager.getTransaction();
        transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        product.setStock(product.getStock() + productAdd);
        manager.persist(product);
        transaction.commit();
    }

    @Override
    public void removeFromStock(Long product_ID, int productRemove) throws Exception {
        transaction = manager.getTransaction();
        transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        product.setStock(product.getStock() - productRemove);
        manager.persist(product);
        transaction.commit();
    }

    @Override
    public void createProduct(String name, String type, int price) throws Exception {
        transaction = manager.getTransaction();
        transaction.begin();
        Product product = new Product();
        product.setName(name);
        product.setType(type);
        product.setPrice(price);
        product.setStock(0);
        manager.persist(product);
        transaction.commit();
    }

    @Override
    public void editName(Long product_ID, String name) throws Exception {
        transaction = manager.getTransaction();
        transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        product.setName(name);
        manager.persist(product);
        transaction.commit();
    }

    @Override
    public void editType(Long product_ID, String type) throws Exception {
        transaction = manager.getTransaction();
        transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        product.setType(type);
        manager.persist(product);
        transaction.commit();
    }

    @Override
    public void editPrice(Long product_ID, int price) throws Exception {
        transaction = manager.getTransaction();
        transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        product.setPrice(price);
        manager.persist(product);
        transaction.commit();
    }

    @Override
    public void deleteProduct(Long product_ID) throws Exception {
        transaction = manager.getTransaction();
        transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        manager.remove(product);
        transaction.commit();
    }

}
