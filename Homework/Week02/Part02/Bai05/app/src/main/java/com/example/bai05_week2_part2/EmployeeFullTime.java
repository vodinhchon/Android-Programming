package com.example.bai05_week2_part2;

public class EmployeeFullTime extends Employee{

    @Override
    public double tinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Full time = " + tinhLuong();
    }
}
