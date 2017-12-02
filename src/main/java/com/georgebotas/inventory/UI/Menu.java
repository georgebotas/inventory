package com.georgebotas.inventory.UI;


import com.georgebotas.inventory.Middleware.IInventory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu implements IMenu {

    @Autowired
    IInventory iinventory;

    private final Logger logger = LogManager.getLogger();
    private Long productID;

    public Menu() {
    }

    private int userSelect;
    private static final Scanner SCAN = new Scanner(System.in);

    @Override
    public void select() {

        Print.mainMenu();
        userSelect = SCAN.nextInt();
        SCAN.nextLine();

        switch (userSelect) {
            case 1:
                showInventory();
                break;
            case 2:
                addStock();
                break;
            case 3:
                removeStock();
                break;
            case 4:
                create();
                break;
            case 5:
                editProduct();
                break;
            case 6:
                delete();
                break;
            case 7:
                sort();
                select();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                Print.invalidNumber();
                select();
                break;
        }
    }

    private void editProduct() {
        Print.productSelect();
        productID = SCAN.nextLong();
        SCAN.nextLine();
        while (!iinventory.validateID(productID)) {
            Print.invalidID();
            productID = SCAN.nextLong();
            SCAN.nextLine();
        }
        logger.info("THE PRODUCT WITH THE ID '" + productID + "' HAS BEEN SELECTED FOR EDITING.");
        edit(productID);
        select();
    }

    private void edit(Long productID) {
        try {
            String userString;
            int userInt;
            Print.editMenu();
            userSelect = SCAN.nextInt();
            switch (userSelect) {
                case 1:
                    Print.editName();
                    SCAN.nextLine();
                    userString = SCAN.nextLine();
                    validate_string(userString);
                    iinventory.editName(productID, userString);
                    logger.info("THE PRODUCT'S NAME WITH THE ID '" + productID + "' HAS CHANGED TO '" + userString+"'.");
                    break;
                case 2:
                    Print.editType();
                    SCAN.nextLine();
                    userString = SCAN.nextLine();
                    validate_string(userString);
                    iinventory.editType(productID, userString);
                    logger.info("THE PRODUCT'S TYPE WITH THE ID '" + productID + "' HAS CHANGED TO '" + userString+"'.");
                    break;
                case 3:
                    Print.editPrice();
                    userInt = SCAN.nextInt();
                    SCAN.nextLine();
                    iinventory.editPrice(productID, userInt);
                    logger.info("THE PRODUCT'S PRICE WITH THE ID '" + productID + "HAS CHANGED TO '" + userInt+"'.");
                    break;
                default:
                    Print.invalidNumber();
                    edit(productID);
                    break;
            }
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            Print.exception();
        }
    }

    private void sort() {
        try {
            Print.sortMenu();
            userSelect = SCAN.nextInt();
            switch (userSelect) {
                case 1:
                    Print.sortName();
                    logger.info("ATTEMPTING TO SORT AND LIST ALL INVENTORY BY NAME.");
                    iinventory.sortProductsName();
                    logger.info("SORTING SUCCESSFUL");
                    break;
                case 2:
                    Print.sortType();
                    logger.info("ATTEMPTING TO SORT AND LIST ALL INVENTORY BY TYPE.");
                    iinventory.sortProductsType();
                    logger.info("SORTING SUCCESSFUL");
                    break;
                case 3:
                    Print.sortPrice();
                    logger.info("ATTEMPTING TO SORT AND LIST ALL INVENTORY BY PRICE.");
                    iinventory.sortProductsPrice();
                    logger.info("SORTING SUCCESSFUL");
                    break;
                case 4:
                    Print.sortStock();
                    logger.info("ATTEMPTING TO SORT AND LIST ALL INVENTORY BY STOCK.");
                    iinventory.sortProductsStock();
                    logger.info("SORTING SUCCESSFUL.");
                    break;
                default:
                    Print.invalidNumber();
                    sort();
                    break;
            }
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            Print.exception();
        }
    }

    private void validate_int(int userInt) {
        while (!UserInputValidator.validateUserInt(userInt)) {
            Print.invalidNumber();
            userInt = SCAN.nextInt();
            SCAN.nextLine();
        }
    }

    private void validate_string(String userString) {
        while (!UserInputValidator.validateUserString(userString)) {
            Print.invalidString();
            userString = SCAN.nextLine();
        }
    }

    /*private void validate_ID(Long product_ID) {
        while (!iinventory.validateID(product_ID)) {
            Print.invalidID();
            product_ID = SCAN.nextLong();
            SCAN.nextLine();
        }
    }

    private void validate_Stock(Long product_ID, int productRemove) {
        while (!iinventory.validateStock(product_ID, productRemove)) {
            Print.negativeStock();
            productRemove = SCAN.nextInt();
            SCAN.nextLine();
        }
    }*/

    private void showInventory() {
        try {
            logger.info("ATTEMPTING TO LIST ALL INVENTORY.");
            iinventory.showInventory();
            logger.info("LIST INVENTORY SUCCESSFUL.");
            select();
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            Print.exception();
        }
    }

    private void addStock() {
        try {
            Print.productSelect();
            productID = SCAN.nextLong();
            while (!iinventory.validateID(productID)) {
                Print.invalidID();
                productID = SCAN.nextLong();
                SCAN.nextLine();
            }
            logger.info("THE PRODUCT WITH THE ID '" + productID + "' HAS BEEN SELECTED FOR STOCK INCREMENTAL.");
            Print.addStock();
            Integer productAdd = SCAN.nextInt();
            SCAN.nextLine();
            iinventory.addToStock(productID, productAdd);
            logger.info("THE PRODUCT'S STOCK WITH THE ID '" + productID + "' HAS INCREASED BY '"+productAdd+"'.");
            select();
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            Print.exception();
        }
    }

    private void removeStock() {
        try {
            Print.productSelect();
            productID = SCAN.nextLong();
            while (!iinventory.validateID(productID)) {
                Print.invalidID();
                productID = SCAN.nextLong();
                SCAN.nextLine();
            }
            logger.info("THE PRODUCT WITH THE ID '" + productID + "' HAS BEEN SELECTED FOR STOCK DECREMENTAL.");
            Print.removeStock();
            int productRemove = SCAN.nextInt();
            SCAN.nextLine();
            while (!iinventory.validateStock(productID, productRemove)) {
                Print.negativeStock();
                productRemove = SCAN.nextInt();
                SCAN.nextLine();
            }
            iinventory.removeFromStock(productID, productRemove);
            logger.info("THE PRODUCT'S STOCK WITH THE ID '" + productID + "' HAS DECREASED BY '"+productRemove+"'.");
            select();
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            Print.exception();
        }
    }

    private void create() {
        try {
            String productName;
            String productType;
            int productPrice;
            logger.info("ATTEMPTING PRODUCT CREATION. USER INPUT EXPECTED.");
            Print.createName();
            productName = SCAN.nextLine();
            validate_string(productName);
            Print.createType();
            productType = SCAN.nextLine();
            validate_string(productType);
            Print.createPrice();
            productPrice = SCAN.nextInt();
            SCAN.nextLine();
            iinventory.createProduct(productName, productType, productPrice);
            logger.info("PRODUCT WITH THE NAME '" + productName + "', TYPE '" + productType + "' AND PRICE '" + productPrice + "' HAS BEEN SUCCESSFULLY CREATED.");
            select();
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            Print.exception();
        }
    }

    private void delete() {
        try {
            Print.productDelete();
            productID = SCAN.nextLong();
            while (!iinventory.validateID(productID)) {
                Print.invalidID();
                productID = SCAN.nextLong();
                SCAN.nextLine();
            }
            logger.info("THE PRODUCT WITH THE ID '" + productID + "' HAS BEEN SELECTED FOR REMOVAL.");
            iinventory.deleteProduct(productID);
            logger.info("THE PRODUCT WITH THE ID '" + productID + "' HAS BEEN SUCCESSFULLY REMOVED.");
            select();
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            Print.exception();
        }
    }
}
