package com.example.myapplication;

public class Model {

    private int coffeePrice = 1800;
    private int count = 0;

    public void add() {
        count ++;
    }

    public void subtract() {
        if(count > 0) count --;
    }

    public int getTotalPrice() {
        return count * coffeePrice;
    }

    public int getCount() {
        return count;
    }
}
