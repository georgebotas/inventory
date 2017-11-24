package com.georgebotas.inventory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class DbOps implements IDbOps {
    EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Inventory");
    private EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    private EntityTransaction transaction;

    @Override
    public void validateID(Long product_ID) {

        transaction = manager.getTransaction();
        transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        if (product == null) {
            System.out.println(Print.invalidID);
            System.exit(0);
        }
    }

    @Override
    public void validateStock(Long product_ID, int userRemove) {
       // transaction = manager.getTransaction();
       // transaction.begin();
        Product product = manager.find(Product.class, product_ID);
        if (product.getStock() - userRemove < 0) {
            System.out.println(Print.negativeStock);
            System.exit(0);
        }
    }

    @Override
    public ArrayList<Product> productList() {
        ArrayList<Product> products = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            products = (ArrayList<Product>) manager.createQuery("SELECT c FROM Product c", Product.class).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return products;
    }

    @Override
    public void addToStock(Long product_ID, int userAdd) {
        try {
            Product product = manager.find(Product.class, product_ID);
            product.setStock(product.getStock() + userAdd);
            manager.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void removeFromStock(Long product_ID, int userRemove) {
        try {
            Product product = manager.find(Product.class, product_ID);
            product.setStock(product.getStock() - userRemove);
            manager.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void createProduct(String name, String type, int price) {
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Product product = new Product();
            product.setName(name);
            product.setType(type);
            product.setPrice(price);
            product.setStock(0);
            manager.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void editName(Long product_ID, String name) {
        try {
            Product product = manager.find(Product.class, product_ID);
            product.setName(name);
            manager.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void editType(Long product_ID, String type) {
        try {
            Product product = manager.find(Product.class, product_ID);
            product.setType(type);
            manager.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void editPrice(Long product_ID, int price) {
        try {
            Product product = manager.find(Product.class, product_ID);
            product.setPrice(price);
            manager.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Long product_ID) {
        try {

            Product product = manager.find(Product.class, product_ID);
            manager.remove(product);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

}
