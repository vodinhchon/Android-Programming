package com.example.example_tinhtuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    TextView ketqua;
    Button thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ketqua = (TextView) findViewById(R.id.textView_kq);
        thoat = (Button) findViewById(R.id.button_thoat);

        String ht = getIntent().getExtras().getString("hoten");
        int ns = Integer.parseInt(getIntent().getExtras().getString("namsinh"));

        Calendar calendar = Calendar.getInstance();

        int tuoi = (calendar.getTime().getYear() + 1900) - ns;

        ketqua.setText("Kết quả" + '\n' + "Họ tên : " + ht + '\n' + "Năm sinh : " + ns + '\n' + "Tuổi : " + tuoi);

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
