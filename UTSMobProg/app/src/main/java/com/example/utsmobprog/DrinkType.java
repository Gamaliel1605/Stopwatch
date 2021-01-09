package com.example.utsmobprog;

public class DrinkType {
    private String nameDrink;
    private int quantityDrink;
    private int priceDrink;

    public DrinkType(String nameDrink, int quantityDrink, int priceDrink) {
        this.nameDrink = nameDrink;
        this.quantityDrink = quantityDrink;
        this.priceDrink = priceDrink;
    }

    @Override
    public String toString() {
        return "DrinkType{" +
                "nameDrink='" + nameDrink + '\'' +
                ", quantityDrink=" + quantityDrink +
                ", priceDrink=" + priceDrink +
                '}';
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public int getQuantityDrink() {
        return quantityDrink;
    }

    public void setQuantityDrink(int quantityDrink) {
        this.quantityDrink = quantityDrink;
    }

    public int getPriceDrink() {
        return priceDrink;
    }

    public void setPriceDrink(int priceDrink) {
        this.priceDrink = priceDrink;
    }
}
