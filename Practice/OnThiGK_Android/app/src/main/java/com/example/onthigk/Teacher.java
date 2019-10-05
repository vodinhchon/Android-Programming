package com.example.onthigk;

public class Teacher extends Person{

    private double cost;

    @Override
    public double charged(int amount, boolean member) {
        cost = 10.000 * amount; //1 book 10.000
        if(member){
            cost = cost * 0.9;
        }
        return cost;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Teacher : " + cost + " VND";
    }
}
