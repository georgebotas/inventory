package com.georgebotas.inventory;

public interface IMenu {
    void select();

    void reSelect();

    void edit(Long userID);

    void sort();

    void validate_int(int userInt);

    void validate_string(String userString);

}
