package com.example.baitap03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_namduong;
    Button btn_chuyendoi;
    TextView tvw_ketqua;
    String can = "", chi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFindViewByID();
        eventClick();
    }

    private void eventClick() {
        btn_chuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = Integer.parseInt(edt_namduong.getText().toString());
                if(year >= 1900){
                    switch (year % 10){
                        case 0:
                            can = "Canh";
                            break;
                        case 1:
                            can = "Tân";
                            break;
                        case 2:
                            can = "Nhâm";
                            break;
                        case 3:
                            can = "Quý";
                            break;
                        case 4:
                            can = "Giáp";
                            break;
                        case 5:
                            can = "Ất";
                            break;
                        case 6:
                            can = "Bính";
                            break;
                        case 7:
                            can = "Đinh";
                            break;
                        case 8:
                            can = "Mậu";
                            break;
                        case 9:
                            can = "Kỷ";
                            break;
                    }

                    switch (year % 12) {
                        case 0:
                            chi = "Thân";
                            break;
                        case 1:
                            chi = "Dậu";
                            break;
                        case 2:
                            chi = "Tuất";
                            break;
                        case 3:
                            chi = "Hợi";
                            break;
                        case 4:
                            chi = "Tý";
                            break;
                        case 5:
                            chi = "Sửu";
                            break;
                        case 6:
                            chi = "Dần";
                            break;
                        case 7:
                            chi = "Mẹo";
                            break;
                        case 8:
                            chi = "Thìn";
                            break;
                        case 9:
                            chi = "Tỵ";
                            break;
                        case 10:
                            chi = "Ngọ";
                            break;
                        case 11:
                            chi = "Mùi";
                            break;
                    }
                    tvw_ketqua.setText("" + (can + " " + chi));
                }
                else{
                    tvw_ketqua.setText("");
                    Toast.makeText(getApplicationContext(), "Năm dương lịch chỉ được nhập số >= 1900 ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createFindViewByID() {
        edt_namduong = (EditText) findViewById(R.id.editText_namduong);
        btn_chuyendoi = (Button) findViewById(R.id.button_chuyendoi);
        tvw_ketqua = (TextView) findViewById(R.id.textView_ketqua);
    }
}
