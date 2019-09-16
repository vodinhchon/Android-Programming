package com.example.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText cd, cr;
    Button tinh;
    TextView cv, dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cd = findViewById(R.id.chieudai);
        cr = findViewById(R.id.chieurong);
        tinh = findViewById(R.id.btntinh);
        cv = findViewById(R.id.chuvi);
        dt = findViewById(R.id.dientich);

        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dai = Integer.parseInt(cd.getText().toString());
                int rong = Integer.parseInt(cr.getText().toString());
                cv.setText("Chu vi : " + ((dai + rong) * 2));
                dt.setText("Diện tích : " + (dai * rong));
            }
        });
    }
}
