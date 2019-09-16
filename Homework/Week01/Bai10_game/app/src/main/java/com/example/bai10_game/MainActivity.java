package com.example.bai10_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    ImageView imgla1nc1, imgla2nc1, imgla3nc1, imgla1nc2, imgla2nc2, imgla3nc2;
    Button btnrut1, btnrut2, btnchoilai, btnbatdau;
    TextView txtvdiem1, txtvdiem2;
    ArrayList<Integer> mangLaBai;
    ArrayList<Integer> diemLaBai;
    int diemnc1, diemnc2;
    int la1, la2, la3, la4, la5, la6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFindViewByIDs();

        start();

        playCards();

        createArrayList();

        eventPlayer2();

        playAgain();
    }

    public void createFindViewByIDs(){
        btnchoilai = (Button) findViewById(R.id.button_choilai);
        btnbatdau = (Button) findViewById((R.id.button_batdau));

        //Nguoi choi 1
        imgla1nc1 = (ImageView) findViewById(R.id.imageView_la1_nc1);
        imgla2nc1 = (ImageView) findViewById(R.id.imageView_la2_nc1);
        imgla3nc1 = (ImageView) findViewById(R.id.imageView_la3_nc1);
        txtvdiem1 = (TextView) findViewById(R.id.textView_diem1);
        btnrut1 = (Button) findViewById(R.id.button_rutbai1);

        //Nguoi choi 2
        imgla1nc2 = (ImageView) findViewById(R.id.imageView_la1_nc2);
        imgla2nc2 = (ImageView) findViewById(R.id.imageView_la2_nc2);
        imgla3nc2 = (ImageView) findViewById(R.id.imageView_la3_nc2);
        txtvdiem2 = (TextView) findViewById(R.id.textView_diem2);
        btnrut2 = (Button) findViewById(R.id.button_rutbai2);
    }

    public void createArrayList(){
        //Khoi tao mang la bai
        mangLaBai = new ArrayList<Integer>();

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

        //Chuon
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

        //Khoi tao diem la bai
        diemLaBai = new ArrayList<Integer>();

        //Bich
        diemLaBai.add(1);
        diemLaBai.add(2);
        diemLaBai.add(3);
        diemLaBai.add(4);
        diemLaBai.add(5);
        diemLaBai.add(6);
        diemLaBai.add(7);
        diemLaBai.add(8);
        diemLaBai.add(9);
        diemLaBai.add(10);
        diemLaBai.add(0);
        diemLaBai.add(0);
        diemLaBai.add(0);

        //Chuong
        diemLaBai.add(1);
        diemLaBai.add(2);
        diemLaBai.add(3);
        diemLaBai.add(4);
        diemLaBai.add(5);
        diemLaBai.add(6);
        diemLaBai.add(7);
        diemLaBai.add(8);
        diemLaBai.add(9);
        diemLaBai.add(10);
        diemLaBai.add(0);
        diemLaBai.add(0);
        diemLaBai.add(0);

        //Ro
        diemLaBai.add(1);
        diemLaBai.add(2);
        diemLaBai.add(3);
        diemLaBai.add(4);
        diemLaBai.add(5);
        diemLaBai.add(6);
        diemLaBai.add(7);
        diemLaBai.add(8);
        diemLaBai.add(9);
        diemLaBai.add(10);
        diemLaBai.add(0);
        diemLaBai.add(0);
        diemLaBai.add(0);

        //Co
        diemLaBai.add(1);
        diemLaBai.add(2);
        diemLaBai.add(3);
        diemLaBai.add(4);
        diemLaBai.add(5);
        diemLaBai.add(6);
        diemLaBai.add(7);
        diemLaBai.add(8);
        diemLaBai.add(9);
        diemLaBai.add(10);
        diemLaBai.add(0);
        diemLaBai.add(0);
        diemLaBai.add(0);
    }

    public void eventPlayer1(){
        //Random 3 la bai
        Random rd = new Random();

        //random la 1
        la1 = rd.nextInt(mangLaBai.size());
        imgla1nc1.setImageResource(mangLaBai.get(la1));

        //random la 2
        do{
            la2 = rd.nextInt(mangLaBai.size());
        }while (la2 == la1);
        imgla2nc1.setImageResource(mangLaBai.get(la2));

        //random la 3
        do{
            la3 = rd.nextInt(mangLaBai.size());
        }while (la3 == la1 || la3 == la2);
        imgla3nc1.setImageResource(mangLaBai.get(la3));

        //Tinh diem
        if(diemLaBai.get(la1) == 0 && diemLaBai.get(la2) == 0 && diemLaBai.get(la3) == 0){
            txtvdiem1.setText("Điểm : 3 Tây");
            diemnc1 = -1;
        }
        else{
            diemnc1 = (diemLaBai.get(la1) + diemLaBai.get(la2) + diemLaBai.get(la3));
            checkPointPlayer1();
        }
    }

    public void eventPlayer2(){
        //Su kien nguoi choi 2
        btnrut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Random 3 la bai
                Random rd = new Random();

                //random la 1
                do{
                    la4 = rd.nextInt(mangLaBai.size());
                }while(la4 == la1 || la4 == la2 || la4 == la3);
                imgla1nc2.setImageResource(mangLaBai.get(la4));

                //random la 2
                do{
                    la5 = rd.nextInt(mangLaBai.size());
                }while (la5 == la1 || la5 == la2 || la5 == la3 || la5 == la4);
                imgla2nc2.setImageResource(mangLaBai.get(la5));

                //random la 3
                do{
                    la6 = rd.nextInt(mangLaBai.size());
                }while (la6 == la1 || la6 == la2 || la6 == la3 || la6 == la4 || la6 == la5);
                imgla3nc2.setImageResource(mangLaBai.get(la6));

                //Tinh diem
                if(diemLaBai.get(la4) == 0 && diemLaBai.get(la5) == 0 && diemLaBai.get(la6) == 0){
                    txtvdiem2.setText("Điểm : 3 Tây");
                    diemnc2 = -1;
                }
                else{
                    diemnc2 = (diemLaBai.get(la4) + diemLaBai.get(la5) + diemLaBai.get(la6));
                    checkPointPlayer2();
                }

                whoIsWon();
            }
        });
    }

    public void playAgain(){
        //Su kien nut choi lai
        btnchoilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
                txtvdiem1.setText("Điểm : ");
                txtvdiem2.setText("Điểm : ");
                imgla1nc1.setImageResource(R.color.colorWhite);
                imgla2nc1.setImageResource(R.color.colorWhite);
                imgla3nc1.setImageResource(R.color.colorWhite);
                imgla1nc2.setImageResource(R.color.colorWhite);
                imgla2nc2.setImageResource(R.color.colorWhite);
                imgla3nc2.setImageResource(R.color.colorWhite);
            }
        });
    }

    public void playCards(){
        btnbatdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgla1nc1.setImageResource(R.drawable.b2fv);
                imgla2nc1.setImageResource(R.drawable.b2fv);
                imgla3nc1.setImageResource(R.drawable.b2fv);
                imgla1nc2.setImageResource(R.drawable.b2fv);
                imgla2nc2.setImageResource(R.drawable.b2fv);
                imgla3nc2.setImageResource(R.drawable.b2fv);

                newGame();
            }
        });
    }

    public void start(){
        btnbatdau.setEnabled(true);
        btnchoilai.setEnabled(false);
        btnrut1.setEnabled(false);
        btnrut2.setEnabled(false);
    }

    public void newGame(){
        btnrut1.setEnabled(false);
        btnrut2.setEnabled(true);
        btnchoilai.setEnabled(true);
        btnbatdau.setEnabled(false);
        eventPlayer1();
    }

    public void endGame(){
        btnrut1.setEnabled(false);
        btnrut2.setEnabled(false);
    }

    public void checkPointPlayer1(){
//Xu ly diem nc1
        if (diemnc1 == 10){
            diemnc1 = 0;
        }
        if (diemnc1 == 11){
            diemnc1 = 1;
        }
        if (diemnc1 == 12){
            diemnc1 = 2;
        }
        if (diemnc1 == 13){
            diemnc1 = 3;
        }
        if (diemnc1 == 14){
            diemnc1 = 4;
        }
        if (diemnc1 == 15){
            diemnc1 = 5;
        }
        if (diemnc1 == 16){
            diemnc1 = 6;
        }
        if (diemnc1 == 17){
            diemnc1 = 7;
        }
        if (diemnc1 == 18){
            diemnc1 = 8;
        }
        if (diemnc1 == 19){
            diemnc1 = 9;
        }
        if (diemnc1 == 20){
            diemnc1 = 0;
        }
        if (diemnc1 == 21){
            diemnc1 = 1;
        }
        if (diemnc1 == 22){
            diemnc1 = 2;
        }
        if (diemnc1 == 23){
            diemnc1 = 3;
        }
        if (diemnc1 == 24){
            diemnc1 = 4;
        }
        if (diemnc1 == 25){
            diemnc1 = 5;
        }
        if (diemnc1 == 26){
            diemnc1 = 6;
        }
        if (diemnc1 == 27){
            diemnc1 = 7;
        }
        if (diemnc1 == 28){
            diemnc1 = 8;
        }
        if (diemnc1 == 29){
            diemnc1 = 9;
        }
        txtvdiem1.setText("Điểm : " + diemnc1);
    }

    public void checkPointPlayer2(){
//Xu ly diem nc2
        if (diemnc2 == 10){
            diemnc2 = 0;
        }
        if (diemnc2 == 11){
            diemnc2 = 1;
        }
        if (diemnc2 == 12){
            diemnc2 = 2;
        }
        if (diemnc2 == 13){
            diemnc2 = 3;
        }
        if (diemnc2 == 14){
            diemnc2 = 4;
        }
        if (diemnc2 == 15){
            diemnc2 = 5;
        }
        if (diemnc2 == 16){
            diemnc2 = 6;
        }
        if (diemnc2 == 17){
            diemnc2 = 7;
        }
        if (diemnc2 == 18){
            diemnc2 = 8;
        }
        if (diemnc2 == 19){
            diemnc2 = 9;
        }
        if (diemnc2 == 20){
            diemnc2 = 0;
        }
        if (diemnc2 == 21){
            diemnc2 = 1;
        }
        if (diemnc2 == 22){
            diemnc2 = 2;
        }
        if (diemnc2 == 23){
            diemnc2 = 3;
        }
        if (diemnc2 == 24){
            diemnc2 = 4;
        }
        if (diemnc2 == 25){
            diemnc2 = 5;
        }
        if (diemnc2 == 26){
            diemnc2 = 6;
        }
        if (diemnc2 == 27){
            diemnc2 = 7;
        }
        if (diemnc2 == 28){
            diemnc2 = 8;
        }
        if (diemnc2 == 29){
            diemnc2 = 9;
        }
        txtvdiem2.setText("Điểm : " + diemnc2);
    }

    public void whoIsWon(){
        //So sanh diem 2 nguoi choi
        if(diemnc1 == -1 && diemnc2 == -1){
            Toast.makeText(getApplicationContext(), "HÒA", Toast.LENGTH_SHORT).show();
            endGame();
        }
        else if(diemnc1 == -1 && diemnc2 != -1){
            Toast.makeText(getApplicationContext(), "MÁY CHIẾN THẮNG !", Toast.LENGTH_SHORT).show();
            endGame();
        }
        else if(diemnc1 != -1 && diemnc2 == -1){
            Toast.makeText(getApplicationContext(), "NGƯỜI CHƠI CHIẾN THẮNG !", Toast.LENGTH_SHORT).show();
            endGame();
        }
        else if(diemnc1 == diemnc2){
            Toast.makeText(getApplicationContext(), "HÒA", Toast.LENGTH_SHORT).show();
            endGame();
        }
        else if(diemnc1 > diemnc2){
            Toast.makeText(getApplicationContext(), "MÁY CHIẾN THẮNG !", Toast.LENGTH_SHORT).show();
            endGame();
        }
        else{
            Toast.makeText(getApplicationContext(), "NGƯỜI CHƠI CHIẾN THẮNG !", Toast.LENGTH_SHORT).show();
            endGame();
        }
    }

}
