package com.georgebotas.inventory;

public class UserInputValidator {

    public static boolean validateUserString(String userName) {
        return !userName.trim().isEmpty();
    }

    public static boolean validateUserInt() { return Menu.SCAN.hasNextInt(); }

}
