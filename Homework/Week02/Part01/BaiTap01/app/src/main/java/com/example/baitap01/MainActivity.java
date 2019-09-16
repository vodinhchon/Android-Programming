package com.example.baitap01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_soa, edt_sob;
    TextView tvw_kq;
    Button btn_tong, btn_hieu, btn_tich, btn_thuong, btn_uocchung, btn_boichung, btn_thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFindViewByID();
        eventClick();

    }

    public void createFindViewByID(){
        //EditText
        edt_soa = (EditText) findViewById(R.id.editText_soa);
        edt_sob = (EditText) findViewById(R.id.editText_sob);
        //TextView
        tvw_kq = (TextView) findViewById(R.id.textView_ketqua);
        //Button
        btn_tong = (Button) findViewById(R.id.button_tong);
        btn_hieu = (Button) findViewById(R.id.button_hieu);
        btn_tich = (Button) findViewById(R.id.button_tich);
        btn_thuong = (Button) findViewById(R.id.button_thuong);
        btn_uocchung = (Button) findViewById(R.id.button_uocchung);
        btn_boichung = (Button) findViewById(R.id.button_boichung);
        btn_thoat = (Button) findViewById(R.id.button_thoat);
    }

    public void eventClick(){
        btn_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float soa = Float.parseFloat(edt_soa.getText().toString());
                float sob = Float.parseFloat(edt_sob.getText().toString());
                Number number = new Number(soa, sob);
                tvw_kq.setText("Kết quả :            " + number.tinhTong());
            }
        });

        btn_hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float soa = Float.parseFloat(edt_soa.getText().toString());
                float sob = Float.parseFloat(edt_sob.getText().toString());
                Number number = new Number(soa, sob);
                tvw_kq.setText("Kết quả :            " + number.tinhHieu());
            }
        });

        btn_tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float soa = Float.parseFloat(edt_soa.getText().toString());
                float sob = Float.parseFloat(edt_sob.getText().toString());
                Number number = new Number(soa, sob);
                tvw_kq.setText("Kết quả :            " + number.tinhTich());
            }
        });

        btn_thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float soa = Float.parseFloat(edt_soa.getText().toString());
                float sob = Float.parseFloat(edt_sob.getText().toString());
                Number number = new Number(soa, sob);
                tvw_kq.setText("Kết quả :            " + number.tinhThuong());
            }
        });

        btn_uocchung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float soa = Float.parseFloat(edt_soa.getText().toString());
                float sob = Float.parseFloat(edt_sob.getText().toString());
                Number number = new Number(soa, sob);
                if(soa <= 0 || sob <= 0){
                    Toast.makeText(getApplicationContext(), "Số A và số B phải > 0",Toast.LENGTH_SHORT).show();
                    tvw_kq.setText("Kết quả :            ");
                }
                else{
                    tvw_kq.setText("Kết quả :            " + number.tinhUSCLN());
                }
            }
        });

        btn_boichung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float soa = Float.parseFloat(edt_soa.getText().toString());
                float sob = Float.parseFloat(edt_sob.getText().toString());
                Number number = new Number(soa, sob);
                if(soa <= 0 || sob <= 0){
                    Toast.makeText(getApplicationContext(), "Số A và số B phải > 0",Toast.LENGTH_SHORT).show();
                    tvw_kq.setText("Kết quả :            ");
                }
                else{
                    tvw_kq.setText("Kết quả :            " + number.tinhBSCNN());
                }
            }
        });

        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
