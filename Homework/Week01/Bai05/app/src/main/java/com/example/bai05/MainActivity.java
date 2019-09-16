package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText hoten;
    TextView ho, tendem, ten;
    Button xuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoten = findViewById(R.id.editText_hoten);
        ho = findViewById(R.id.textView3_ho);
        ten = findViewById(R.id.textView5_ten);
        xuat = findViewById(R.id.button_xuat);

        xuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = hoten.getText().toString();

                int k = s.lastIndexOf(' ');

                String hokq = s.substring(0, k);
                String tenkq = s.substring(k + 1);

                ho.setText("Họ : " + hokq);
                ten.setText("Tên : " + tenkq);
            }
        });
    }
}
