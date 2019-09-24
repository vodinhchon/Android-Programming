package com.example.bai02;

public class Product extends Goods{
    private Catolog Dmuc;

    public Product() {
    }

    public Product(Catolog dmuc) {
        Dmuc = dmuc;
    }

    public Product(String id, String name, Catolog dmuc) {
        super(id, name);
        Dmuc = dmuc;
    }

    public Catolog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catolog dmuc) {
        Dmuc = dmuc;
    }
}
