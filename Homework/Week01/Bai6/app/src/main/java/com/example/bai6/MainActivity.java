package com.example.bai6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView daysorandom, ketqua, min, max, demsnt, tongsnt;
    Button taoso, xuatxuoi, xuatnguoc, sapthutu;

    int a0, a1, a2, a3, a4, a5, a6, a7, a8, a9;
    int b0, b1, b2, b3, b4, b5, b6, b7, b8;
    int somax, somin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        daysorandom = findViewById(R.id.textView3_daysongaunhien);
        ketqua = findViewById(R.id.textView5_ketqua);
        min = findViewById(R.id.textView6_min);
        max = findViewById(R.id.textView7_max);
        demsnt = findViewById(R.id.textView8_demsnt);
        tongsnt = findViewById(R.id.textView9_tongsnt);

        //Button
        taoso = findViewById(R.id.button_tao);
        xuatxuoi = findViewById(R.id.button2_xuatxuoi);
        xuatnguoc = findViewById(R.id.button3_xuatnguoc);
        sapthutu = findViewById(R.id.button5_sapthutu);

        taoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ketqua.setText("-> ");

                //Random Numbers
                Random rd = new Random();
                int iNewNumber = 0, iPrevious = -1;
                for (int i = 0; i < 10; ){
                    iNewNumber = rd.nextInt(10);
                    if(iNewNumber != iPrevious){
                        iPrevious = iNewNumber;
                        if(i == 0)
                            a0 = iNewNumber;
                        if(i == 1)
                            a1 = iNewNumber;
                        if(i == 2)
                            a2 = iNewNumber;
                        if(i == 3)
                            a3 = iNewNumber;
                        if(i == 4)
                            a4 = iNewNumber;
                        if(i == 5)
                            a5 = iNewNumber;
                        if(i == 6)
                            a6 = iNewNumber;
                        if(i == 7)
                            a7 = iNewNumber;
                        if(i == 8)
                            a8 = iNewNumber;
                        if(i == 9)
                            a9 = iNewNumber;
                        i++;
                    }
                }
                daysorandom.setText("-> " + a0 + " " + a1 + " " + a2 + " " + a3 + " " + a4 + " " + a5 + " " + a6 + " " + a7 + " " + a8 + " " + a9);

                //Xuất xuôi
                xuatxuoi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ketqua.setText("-> " + a0 + " " + a1 + " " + a2 + " " + a3 + " " + a4 + " " + a5 + " " + a6 + " " + a7 + " " + a8 + " " + a9);
                    }
                });

                //Xuất ngược
                xuatnguoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ketqua.setText("-> " + a9 + " " + a8 + " " + a7 + " " + a6 + " " + a5 + " " + a4 + " " + a3 + " " + a2 + " " + a1 + " " + a0);
                    }
                });

                //Sort up
                sapthutu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int[] numbers = new int[]{a0, a1, a2, a3, a4, a5, a6, a7, a8, a9};
                        int temp = numbers[0];
                        for (int i = 0; i < numbers.length - 1; i++){
                            for (int j = i + 1; j < numbers.length; j++){
                                if(numbers[i] > numbers[j]){
                                    temp = numbers[j];
                                    numbers[j] = numbers[i];
                                    numbers[i] = temp;
                                    if(i == 0)
                                        b0 = numbers[i];
                                    if(i == 1)
                                        b1 = numbers[i];
                                    if(i == 2)
                                        b2 = numbers[i];
                                    if(i == 3)
                                        b3 = numbers[i];
                                    if(i == 4)
                                        b4 = numbers[i];
                                    if(i == 5)
                                        b5 = numbers[i];
                                    if(i == 6)
                                        b6 = numbers[i];
                                    if(i == 7)
                                        b7 = numbers[i];
                                    if(i == 8)
                                        b8 = numbers[i];
                                }
                                else{
                                    if(i == 0)
                                        b0 = numbers[i];
                                    if(i == 1)
                                        b1 = numbers[i];
                                    if(i == 2)
                                        b2 = numbers[i];
                                    if(i == 3)
                                        b3 = numbers[i];
                                    if(i == 4)
                                        b4 = numbers[i];
                                    if(i == 5)
                                        b5 = numbers[i];
                                    if(i == 6)
                                        b6 = numbers[i];
                                    if(i == 7)
                                        b7 = numbers[i];
                                    if(i == 8)
                                        b8 = numbers[i];
                                }
                            }
                        }
                        ketqua.setText("-> " + b0 + " " + b1 + " " + b2 + " " + b3 + " " + b4 + " " + b5 + " " + b6 + " " + b7 + " " + b8 + " " + somax);
                    }
                });

                //Min & Max
                int[] numbers = new int[]{a0, a1, a2, a3, a4, a5, a6, a7, a8, a9};
                somin = numbers[0];
                somax = numbers[0];

                for (int i = 0; i < numbers.length; i++){
                    if(numbers[i] < somin){
                        somin = numbers[i];
                    }
                    if(numbers[i] > somax){
                       somax = numbers[i];
                    }
                }
                min.setText("Min : " + somin);
                max.setText("Max : " + somax);

                //Prime Number
                int countsnt = 0;
                int sumsnt = 0;
                for (int i = 0; i < numbers.length; i++){
                    if(isPrimeNumber(numbers[i])){
                        countsnt+=1;
                        sumsnt+=numbers[i];
                    }
                }
                demsnt.setText("Đếm SNT : " + countsnt);
                tongsnt.setText("Tổng SNT : " + sumsnt);
            }
        });
    }

    public static boolean isPrimeNumber(int n){
        if(n < 2){
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }


}
