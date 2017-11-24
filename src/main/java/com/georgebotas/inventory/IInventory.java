package com.georgebotas.inventory;

public interface IInventory {
    void validateID(Long product_ID);

    void validateStock(Long product_id, int userRemove);

    void showInventory();

    void addToStock(Long product_ID, int userAdd);

    void removeFromStock(Long product_ID, int userRemove);

    void createProduct(String name, String type, int price);

    void editName(Long product_ID, String name);

    void editType(Long product_ID, String type);

    void editPrice(Long product_ID, int price);

    void deleteProduct(Long product_ID);

    void sortProductsName();

    void sortProductsType();

    void sortProductsPrice();

    void sortProductsStock();
}
