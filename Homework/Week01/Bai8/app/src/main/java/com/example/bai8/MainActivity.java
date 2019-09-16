package com.example.bai8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgla1, imgla2, imgla3;
    Button btnrutbai, btnbobai;
    int la1, la2, la3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgla1 = (ImageView) findViewById(R.id.imageView_la1);
        imgla2 = (ImageView) findViewById(R.id.imageView_la2);
        imgla3 = (ImageView) findViewById(R.id.imageView_la3);

        btnrutbai = (Button) findViewById(R.id.button_rutbai);
        btnbobai = (Button) findViewById(R.id.button2_bobai);

        btnbobai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgla1.setImageResource(R.drawable.b2fv);
                imgla2.setImageResource(R.drawable.b2fv);
                imgla3.setImageResource(R.drawable.b2fv);
            }
        });

        btnrutbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> mangLaBai = new ArrayList<Integer>();

                //Bich
                mangLaBai.add(R.drawable.s1);
                mangLaBai.add(R.drawable.s2);
                mangLaBai.add(R.drawable.s3);
                mangLaBai.add(R.drawable.s4);
                mangLaBai.add(R.drawable.s5);
                mangLaBai.add(R.drawable.s6);
                mangLaBai.add(R.drawable.s7);
                mangLaBai.add(R.drawable.s8);
                mangLaBai.add(R.drawable.s9);
                mangLaBai.add(R.drawable.s10);
                mangLaBai.add(R.drawable.sj);
                mangLaBai.add(R.drawable.sq);
                mangLaBai.add(R.drawable.sk);

                //Chuong
                mangLaBai.add(R.drawable.c1);
                mangLaBai.add(R.drawable.c2);
                mangLaBai.add(R.drawable.c3);
                mangLaBai.add(R.drawable.c4);
                mangLaBai.add(R.drawable.c5);
                mangLaBai.add(R.drawable.c6);
                mangLaBai.add(R.drawable.c7);
                mangLaBai.add(R.drawable.c8);
                mangLaBai.add(R.drawable.c9);
                mangLaBai.add(R.drawable.c10);
                mangLaBai.add(R.drawable.cj);
                mangLaBai.add(R.drawable.cq);
                mangLaBai.add(R.drawable.ck);

                //Ro
                mangLaBai.add(R.drawable.d1);
                mangLaBai.add(R.drawable.d2);
                mangLaBai.add(R.drawable.d3);
                mangLaBai.add(R.drawable.d4);
                mangLaBai.add(R.drawable.d5);
                mangLaBai.add(R.drawable.d6);
                mangLaBai.add(R.drawable.d7);
                mangLaBai.add(R.drawable.d8);
                mangLaBai.add(R.drawable.d9);
                mangLaBai.add(R.drawable.d10);
                mangLaBai.add(R.drawable.dj);
                mangLaBai.add(R.drawable.dq);
                mangLaBai.add(R.drawable.dk);

                //Co
                mangLaBai.add(R.drawable.h1);
                mangLaBai.add(R.drawable.h2);
                mangLaBai.add(R.drawable.h3);
                mangLaBai.add(R.drawable.h4);
                mangLaBai.add(R.drawable.h5);
                mangLaBai.add(R.drawable.h6);
                mangLaBai.add(R.drawable.h7);
                mangLaBai.add(R.drawable.h8);
                mangLaBai.add(R.drawable.h9);
                mangLaBai.add(R.drawable.h10);
                mangLaBai.add(R.drawable.hj);
                mangLaBai.add(R.drawable.hq);
                mangLaBai.add(R.drawable.hk);

                //Random 3 la bai
                Random rd = new Random();

                //random la 1
                la1 = rd.nextInt(mangLaBai.size());
                imgla1.setImageResource(mangLaBai.get(la1));

                //random la 2
                do{
                    la2 = rd.nextInt(mangLaBai.size());
                }while (la2 == la1);
                imgla2.setImageResource(mangLaBai.get(la2));

                //random la 3
                do{
                    la3 = rd.nextInt(mangLaBai.size());
                }while (la3 == la1 || la3 == la2);
                imgla3.setImageResource(mangLaBai.get(la3));
            }
        });
    }
}
