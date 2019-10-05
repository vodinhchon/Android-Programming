package com.example.onthigk;

public class Student extends Person{

    private double cost;

    @Override
    public double charged(int amount, boolean member) {
        cost = 8.000 * amount; //1 book 8.000
        if(member){
            cost = cost * 0.9;
        }
        return cost;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Student : " + cost + " VND";
    }
}
