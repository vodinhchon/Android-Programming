package com.example.onthigk;

public abstract class Person {
    private String id;
    private String name;
    private String city;

    public Person() {
    }

    public Person(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name + " - " + this.city;
    }

    public abstract double charged(int amount, boolean member);
}
