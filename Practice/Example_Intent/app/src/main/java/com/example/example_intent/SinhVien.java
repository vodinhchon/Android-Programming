package com.example.example_intent;

import java.util.Calendar;

public class SinhVien {
    private String yearOfBirth;

    public SinhVien(String yearOfBirth){
        this.yearOfBirth = yearOfBirth;
    }

    public int tinhTuoi(){
        Calendar calendar = Calendar.getInstance();
        int ns = Integer.parseInt(yearOfBirth);
        return (calendar.getTime().getYear() + 1900) - ns;
    }
}
