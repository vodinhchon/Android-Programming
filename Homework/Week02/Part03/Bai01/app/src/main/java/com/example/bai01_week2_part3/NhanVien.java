package com.example.bai01_week2_part3;

public class NhanVien {
    private String id;
    private String name;
    private boolean gender;

    public NhanVien() {
    }

    public NhanVien(String id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        String gt = "";
        if(gender == true){
            gt = "Nam";
        }
        else{
            gt = "Nữ";
        }
        return " " + this.id + " - " + this.name + " - " + gt;
    }
}
