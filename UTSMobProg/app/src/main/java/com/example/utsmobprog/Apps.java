package com.example.utsmobprog;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Apps extends Application {

    private static List<DrinkType> drinkTypeList = new ArrayList<DrinkType>();
    private static int nextId = 0;

    public static List<DrinkType> getDrinkTypeList() {
        return drinkTypeList;
    }

    public static void setDrinkTypeList(List<DrinkType> drinkTypeList) {
        Apps.drinkTypeList = drinkTypeList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Apps.nextId = nextId;
    }
}
