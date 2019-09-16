package com.example.bai05_week2_part2;

import androidx.annotation.NonNull;

public abstract class Employee {
    private String id;
    private String name;

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

    public abstract double tinhLuong();

    @Override
    public String toString() {
        return this.id + " - " + this.name;
    }
}
