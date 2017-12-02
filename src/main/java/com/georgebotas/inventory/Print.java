package com.georgebotas.inventory;

public class Print {
    private static String smainMenu = ("THE INVETORY: PLEASE CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n\n" +
            "1. SHOW INVENTORY\n2. ADD TO STOCK\n3. REMOVE FROM STOCK\n4. CREATE A NEW PRODUCT\n5. EDIT A PRODUCT\n6. DELETE A PRODUCT\n7. SORT PRODUCTS\n8. EXIT");

    private static String screateName = ("ENTER THE PRODUCT'S NAME");
    private static String screateType = ("ENTER THE PRODUCT'S TYPE");
    private static String screatePrice = ("ENTER THE PRODUCT'S PRICE");

    private static String seditMenu = ("CHOOSE AN OPTION BY ENTERING THE CORESPONDING NUMBER:\n 1. EDIT NAME\n 2. EDIT TYPE\n 3. EDIT PRICE");
    private static String seditName = ("ENTER THE NEW NAME FOR THE SELECTED PRODUCT:");
    private static String seditType = ("ENTER THE NEW TYPE FOR THE SELECTED PRODUCT:");
    private static String seditPrice =("ENTER THE NEW PRICE FOR THE SELECTED PRODUCT:");

    private static String sproductSelect = ("SELECT A PRODUCT BY ENTERING IT'S ID:");
    private static String sproductDelete = ("SELECT A PRODUCT YOU'D LIKE TO DELETE BY ENTERING IT'S ID:");
    private static String sinvalidNumber = ("PLEASE ENTER A VALID NUMBER:");
    private static String sinvalidString = ("PLEASE ENTER A VALID NAME:");
    private static String sinvalidID = ("THE ID YOU HAVE ENTERED DOES NOT EXIST IN THE DATABASE. TRY ENTERING A VALID ID:");
    private static String semptyInventory = ("THE INVENTORY IS EMPTY. PLEASE ADD SOME PRODUCTS AND TRY AGAIN.");
    private static String snegativeStock = ("THE NEW STOCK WOULD BE NEGATIVE! PLEASE REMOVE ONLY QUANTITY THAT EXISTS IN STOCK:");

    private static String saddStock = ("ENTER THE AMMOUNT YOU'D LIKE TO ADD:");
    private static String sremoveStock= ("ENTER THE AMMOUNT YOU'D LIKE TO REMOVE: ");

    private static String ssortMenu = ("CHOOSE THE TYPE OF SORTING:\n 1. SORT BY NAME\n 2. SORT BY TYPE\n 3. SORT BY PRICE\n 4. SORT BY STOCK");
    private static String ssortedName = ("THE INVENTORY SORTED BY NAME:");
    private static String ssortedType = ("THE INVENTORY SORTED BY TYPE:");
    private static String ssortedPrice = ("THE INVENTORY SORTED BY PRICE:");
    private static String ssortedStock = ("THE INVENTORY SORTED BY STOCK:");
    private static String sexception = "AN EXCEPTION OCCURED. THE PROGRAM HAS SHUT DOWN.";

    public static void mainMenu(){
        System.out.println(smainMenu);
    }

    public static void createName(){
        System.out.println(screateName);
    }
    public static void createType(){
        System.out.println(screateType);
    }
    public static void createPrice(){
        System.out.println(screatePrice);
    }
    public static void editMenu(){
        System.out.println(seditMenu);
    }
    public static void editName(){
        System.out.println(seditName);
    }
    public static void editType(){
        System.out.println(seditType);
    }
    public static void editPrice(){
        System.out.println(seditPrice);
    }
    public static void productSelect(){
        System.out.println(sproductSelect);
    }
    public static void productDelete(){
        System.out.println(sproductDelete);
    }
    public static void invalidNumber(){
        System.out.println(sinvalidNumber);
    }
    public static void invalidString(){
        System.out.println(sinvalidString);
    }
    public static void invalidID(){
        System.out.println(sinvalidID);
    }
    public static void emptyInventory(){
        System.out.println(semptyInventory);
    }
    public static void negativeStock(){
        System.out.println(snegativeStock);
    }
    public static void addStock(){
        System.out.println(saddStock);
    }
    public static void removeStock(){
        System.out.println(sremoveStock);
    }
    public static void sortMenu(){
        System.out.println(ssortMenu);
    }
    public static void sortName(){
        System.out.println(ssortedName);
    }
    public static void sortType(){
        System.out.println(ssortedType);
    }
    public static void sortPrice(){
        System.out.println(ssortedPrice);
    }
    public static void sortStock(){
        System.out.println(ssortedStock);
    }
    public static void exception(){ System.out.println(sexception); }
}
