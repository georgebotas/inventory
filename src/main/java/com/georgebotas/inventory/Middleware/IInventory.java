package com.georgebotas.inventory.Middleware;

public interface IInventory {

    boolean validateID(Long product_ID);

    boolean validateStock(Long product_id, int productRemove);

    void showInventory() throws Exception;

    void addToStock(Long product_ID, int productAdd) throws Exception;

    void removeFromStock(Long product_ID, int productRemove) throws Exception;

    void createProduct(String name, String type, int price) throws Exception;

    void editName(Long product_ID, String name) throws Exception;

    void editType(Long product_ID, String type) throws Exception;

    void editPrice(Long product_ID, int price) throws Exception;

    void deleteProduct(Long product_ID) throws Exception;

    void sortProductsName() throws Exception;

    void sortProductsType() throws Exception;

    void sortProductsPrice() throws Exception;

    void sortProductsStock() throws Exception;
}
