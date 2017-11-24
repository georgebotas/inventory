package com.georgebotas.inventory;

public class Print {
    static String mainMenu = ("THE INVETORY: PLEASE CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n\n" +
            "1. SHOW INVENTORY\n2. ADD TO STOCK\n3. REMOVE FROM STOCK\n4. CREATE A NEW PRODUCT\n5. EDIT A PRODUCT\n6. DELETE A PRODUCT\n7. SORT PRODUCTS\n8. EXIT");

    static String createName = ("ENTER THE PRODUCT'S NAME");
    static String createType = ("ENTER THE PRODUCT'S TYPE");
    static String createPrice = ("ENTER THE PRODUCT'S PRICE");

    static String editMenu = ("CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n 1. EDIT NAME\n 2. EDIT TYPE\n 3. EDIT PRICE");
    static String editName = ("ENTER THE NEW NAME FOR THE SELECTED PRODUCT:");
    static String editType = ("ENTER THE NEW TYPE FOR THE SELECTED PRODUCT:");
    static String editPrice =("ENTER THE NEW PRICE FOR THE SELECTED PRODUCT:");

    static String productSelect = ("SELECT A PRODUCT BY ENTERING IT'S ID:");
    static String productDelete = ("SELECT A PRODUCT YOU'D LIKE TO DELETE BY ENTERING IT'S ID:");
    static String invalidNumber = ("PLEASE ENTER A VALID NUMBER:");
    static String invalidString = ("PLEASE ENTER A VALID NAME:");
    static String invalidID = ("THE ID YOU HAVE ENTERED DOES NOT EXIST IN THE DATABASE.");
    static String emptyInventory = ("THE INVENTORY IS EMPTY. PLEASE ADD SOME PRODUCTS AND TRY AGAIN.");
    static String negativeStock = ("THE NEW STOCK WOULD BE NEGATIVE! PLEASE REMOVE QUANTITY THAT EXISTS IN STOCK.");

    static String addStock = ("ENTER THE AMMOUNT YOU'D LIKE TO ADD:");
    static String removeStock= ("ENTER THE AMMOUNT YOU'D LIKE TO REMOVE: ");

    static String sortMenu = ("CHOOSE THE TYPE OF SORTING:\n 1. SORT BY NAME\n 2. SORT BY TYPE\n 3. SORT BY PRICE\n 4. SORT BY STOCK");
    static String sortedName = ("THE INVENTORY SORTED BY NAME:");
    static String sortedType = ("THE INVENTORY SORTED BY TYPE:");
    static String sortedPrice = ("THE INVENTORY SORTED BY PRICE:");
    static String sortedStock = ("THE INVENTORY SORTED BY STOCK:");
}
