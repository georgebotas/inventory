package com.georgebotas.inventory;

import java.util.ArrayList;

public interface IDbOps {

    void validateID(Long product_ID);

    void validateStock(Long product_ID, int userRemove);

    ArrayList<Product> productList();

    void addToStock(Long product_ID, int userAdd);

    void removeFromStock(Long product_ID, int userRemove);

    void createProduct(String name, String type, int price);

    void editName(Long product_ID, String name);

    void editType(Long product_ID, String type);

    void editPrice(Long product_ID, int price);

    void deleteProduct(Long product_ID);
}
