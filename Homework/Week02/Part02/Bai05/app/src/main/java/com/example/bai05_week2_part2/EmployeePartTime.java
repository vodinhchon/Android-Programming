package com.example.bai05_week2_part2;

public class EmployeePartTime extends Employee{

    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Part time = " + tinhLuong();
    }
}
