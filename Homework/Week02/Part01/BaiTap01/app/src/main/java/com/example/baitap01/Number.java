package com.example.baitap01;

public class Number {
    private float soa;
    private float sob;

    public Number(float soa, float sob){
        this.soa = soa;
        this.sob = sob;
    }

    public float tinhTong(){
        return soa + sob;
    }

    public float tinhHieu(){
        return soa - sob;
    }

    public float tinhTich(){
        return soa * sob;
    }

    public double tinhThuong(){
        return soa / sob;
    }

    public float tinhUSCLN(){
        float uscln, temp1, temp2;
        temp1 = soa;
        temp2 = sob;
        while (temp1 != temp2) {
            if (temp1 > temp2) {
                temp1 -= temp2;
            } else {
                temp2 -= temp1;
            }
        }
        uscln = temp1;
        return uscln;
    }

    public float tinhBSCNN(){
        float uscln, temp1, temp2;
        temp1 = soa;
        temp2 = sob;
        while (temp1 != temp2) {
            if (temp1 > temp2) {
                temp1 -= temp2;
            } else {
                temp2 -= temp1;
            }
        }
        uscln = temp1;
        return (soa * sob) / uscln;
    }
}
