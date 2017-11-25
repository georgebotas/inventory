package com.georgebotas.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu implements IMenu {

    @Autowired
    IInventory iinventory;

    public Menu() { }

    int userSelect;
    static final Scanner SCAN = new Scanner(System.in);

    @Override
    public void select() {

        String userName;
        String userType;
        int userPrice;
        int userAdd;
        int userRemove;
        Long userID;

        userSelect = SCAN.nextInt();
        SCAN.nextLine();

        switch (userSelect) {
            case 1:
                iinventory.showInventory();
                reSelect();
                break;
            case 2:
                System.out.println(Print.productSelect);
                userID = SCAN.nextLong();
                iinventory.validateID(userID);
                System.out.println(Print.addStock);
                userAdd = SCAN.nextInt();
                SCAN.nextLine();
                iinventory.addToStock(userID, userAdd);
                reSelect();
                break;
            case 3:
                System.out.println(Print.productSelect);
                userID = SCAN.nextLong();
                iinventory.validateID(userID);
                System.out.println(Print.removeStock);
                userRemove = SCAN.nextInt();
                SCAN.nextLine();
                iinventory.validateStock(userID, userRemove);
                iinventory.removeFromStock(userID, userRemove);
                reSelect();
                break;
            case 4:
                System.out.println(Print.createName);
                userName = SCAN.nextLine();
                validate_string(userName);
                System.out.println(Print.createType);
                userType = SCAN.nextLine();
                validate_string(userType);
                System.out.println(Print.createPrice);
                userPrice = SCAN.nextInt();
                SCAN.nextLine();
                iinventory.createProduct(userName, userType, userPrice);
                reSelect();
                break;
            case 5:
                System.out.println(Print.productSelect);
                userID = SCAN.nextLong();
                iinventory.validateID(userID);
                edit(userID);
                reSelect();
                break;
            case 6:
                System.out.println(Print.productDelete);
                userID = SCAN.nextLong();
                iinventory.validateID(userID);
                iinventory.deleteProduct(userID);
                reSelect();
                break;
            case 7:
                sort();
                reSelect();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println(Print.invalidNumber);
                reSelect();
                break;
        }
    }

    @Override
    public void reSelect() {
        System.out.println(Print.mainMenu);
        select();
    }

    @Override
    public void edit(Long userID) {
        String userString;
        int userInt;
        System.out.println(Print.editMenu);
        userSelect = SCAN.nextInt();
        switch (userSelect) {
            case 1:
                System.out.println(Print.editName);
                SCAN.nextLine();
                userString = SCAN.nextLine();
                validate_string(userString);
                iinventory.editName(userID, userString);
                break;
            case 2:
                System.out.println(Print.editType);
                SCAN.nextLine();
                userString = SCAN.nextLine();
                validate_string(userString);
                iinventory.editType(userID, userString);
                break;
            case 3:
                System.out.println(Print.editPrice);
                userInt = SCAN.nextInt();
                SCAN.nextLine();
                iinventory.editPrice(userID, userInt);
                break;
            default:
                System.out.println(Print.invalidNumber);
                edit(userID);
                break;
        }
    }

    @Override
    public void sort() {
        System.out.println(Print.sortMenu);
        userSelect = SCAN.nextInt();
        switch (userSelect) {
            case 1:
                System.out.println(Print.sortedName);
                iinventory.sortProductsName();
                break;
            case 2:
                System.out.println(Print.sortedType);
                iinventory.sortProductsType();
                break;
            case 3:
                System.out.println(Print.sortedPrice);
                iinventory.sortProductsPrice();
                break;
            case 4:
                System.out.println(Print.sortedStock);
                iinventory.sortProductsStock();
                break;
            default:
                System.out.println(Print.invalidNumber);
                sort();
                break;
        }
    }

    @Override
    public void validate_int(int userInt) {
        while (!UserInputValidator.validateUserInt(userInt)) {
            System.out.println(Print.invalidNumber);
            userInt = SCAN.nextInt();
        }
    }

    @Override
    public void validate_string(String userString) {
        while (!UserInputValidator.validateUserString(userString)) {
            System.out.println(Print.invalidString);
            userString = SCAN.nextLine();
        }
    }
}
