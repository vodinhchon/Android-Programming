package com.example.example_casestudy3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnnhap, btnthoat;
    TextView ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ketqua = (TextView) findViewById(R.id.kq);
        btnnhap = (Button) findViewById(R.id.btnnhap);
        btnthoat = (Button) findViewById(R.id.btnthoat);

        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, 9999);
            }
        });

        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 9999 && resultCode == RESULT_OK){
            String ht = data.getStringExtra("return_hoten").toString();
            int ns = Integer.parseInt(data.getStringExtra("return_namsinh").toString());
            Calendar calendar = Calendar.getInstance();
            int tuoi = (calendar.getTime().getYear() + 1900) - ns;

            ketqua.setText("Kết quả" + '\n' + "Họ và tên : " + ht + '\n' + "Năm sinh : " + ns + '\n' + "Tuổi : " + tuoi);

        }

    }

}
