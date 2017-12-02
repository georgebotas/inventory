package com.georgebotas.inventory.DB;

import com.georgebotas.inventory.model.Product;

import java.util.ArrayList;

public interface IDbOps {

    boolean validateID(Long product_ID);

    boolean validateStock(Long product_ID, int productRemove);

    ArrayList<Product> productList() throws Exception;

    void addToStock(Long product_ID, int productAdd) throws Exception;

    void removeFromStock(Long product_ID, int productRemove) throws Exception;

    void createProduct(String name, String type, int price) throws Exception;

    void editName(Long product_ID, String name) throws Exception;

    void editType(Long product_ID, String type) throws Exception;

    void editPrice(Long product_ID, int price) throws Exception;

    void deleteProduct(Long product_ID) throws Exception;
}
