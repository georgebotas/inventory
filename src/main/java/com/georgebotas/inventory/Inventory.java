package com.georgebotas.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Component
public class Inventory implements IInventory {

    @Autowired
    IDbOps idbops;

    public Inventory() {
    }

    @Override
    public void validateID(Long product_ID) {
        idbops.validateID(product_ID);
    }

    @Override
    public void validateStock(Long product_id, int userRemove){
        idbops.validateStock(product_id, userRemove);
    }

    @Override
    public void showInventory() {
        ArrayList<Product> products = idbops.productList();
        int count = 0;
        System.out.printf("%-10s %-21s %-21s %-21s %-21s \n", "   ID:", "NAME:", "TYPE:", "PRICE:", "STOCK");
        try {
            for (Product product : products) {
                System.out.printf("%d. %-7s %-21s %-21s %-21s %s \n", count + 1, product.getProduct_id(), product.getName(), product.getType(),
                        product.getPrice(), product.getStock());
                count++;
            }
            System.out.println();
        } catch (NullPointerException ne) {
            System.out.println(Print.emptyInventory);
        }
    }

    @Override
    public void addToStock(Long product_ID, int userAdd) {
        idbops.addToStock(product_ID, userAdd);
    }

    @Override
    public void removeFromStock(Long product_ID, int userRemove) {
        idbops.removeFromStock(product_ID, userRemove);
    }

    @Override
    public void createProduct(String name, String type, int price) {
        idbops.createProduct(name, type, price);
    }

    @Override
    public void editName(Long product_ID, String name) {
        idbops.editName(product_ID, name);
    }

    @Override
    public void editType(Long product_ID, String type) {
        idbops.editType(product_ID, type);
    }

    @Override
    public void editPrice(Long product_ID, int price) { idbops.editPrice(product_ID, price); }

    @Override
    public void deleteProduct(Long product_ID) {
        idbops.deleteProduct(product_ID);
    }

    @Override
    public void sortProductsName() {

        ArrayList<Product> products = idbops.productList();
        int count = 0;
        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s %-21s \n", "   ID:", "NAME:", "TYPE:", "PRICE:", "STOCK");
        for (Product product : products) {
            System.out.printf("%d. %-7s %-21s %-21s %-21s %s \n", count + 1, product.getProduct_id(), product.getName(), product.getType(),
                    product.getPrice(), product.getStock());
            count++;
        }
        System.out.println();
    }

    @Override
    public void sortProductsType() {

        ArrayList<Product> products = idbops.productList();
        int count = 0;
        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p1.getType().compareTo(p2.getType());
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s %-21s \n", "   ID:", "NAME:", "TYPE:", "PRICE:", "STOCK");
        for (Product product : products) {
            System.out.printf("%d. %-7s %-21s %-21s %-21s %s \n", count + 1, product.getProduct_id(), product.getName(), product.getType(),
                    product.getPrice(), product.getStock());
            count++;
        }
        System.out.println();
    }

    @Override
    public void sortProductsPrice() {

        ArrayList<Product> products = idbops.productList();
        int count = 0;
        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p1.getPrice() - p2.getPrice();
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s %-21s \n", "   ID:", "NAME:", "TYPE:", "PRICE:", "STOCK");
        for (Product product : products) {
            System.out.printf("%d. %-7s %-21s %-21s %-21s %s \n", count + 1, product.getProduct_id(), product.getName(), product.getType(),
                    product.getPrice(), product.getStock());
            count++;
        }
        System.out.println();
    }

    @Override
    public void sortProductsStock() {

        ArrayList<Product> products = idbops.productList();
        int count = 0;
        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p2.getStock() - p1.getStock();
            }
        });
        System.out.printf("%-10s %-21s %-21s %-21s %-21s \n", "   ID:", "NAME:", "TYPE:", "PRICE:", "STOCK");
        for (Product product : products) {
            System.out.printf("%d. %-7s %-21s %-21s %-21s %s \n", count + 1, product.getProduct_id(), product.getName(), product.getType(),
                    product.getPrice(), product.getStock());
            count++;
        }
        System.out.println();
    }


}
