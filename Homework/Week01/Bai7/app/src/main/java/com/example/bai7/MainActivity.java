package com.example.bai7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imglabai;
    Button btnrutbai, btnbobai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imglabai = (ImageView) findViewById(R.id.imageView_labai);
        btnrutbai = (Button) findViewById(R.id.button_rutbai);
        btnbobai = (Button) findViewById(R.id.button_bobai);

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

                //Random la bai
                Random rd = new Random();
                int i = rd.nextInt(mangLaBai.size());

                imglabai.setImageResource(mangLaBai.get(i));
            }
        });

        btnbobai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imglabai.setImageResource(R.drawable.b1fv);
            }
        });
    }
}
