package com.example.bai03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText na, nb;
    Button tinh;
    TextView kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        na = findViewById(R.id.editText_nhapa);
        nb = findViewById(R.id.editText_nhapb);
        tinh = findViewById(R.id.button_tinh);
        kq = findViewById(R.id.textView4_ketqua);

        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(na.getText().toString());
                int b = Integer.parseInt(nb.getText().toString());

                switch (a){
                    case 0:{
                        if(b == 0){
                            kq.setText("Kết quả : " + "Phương trình vô số nghiệm");
                            break;
                        }
                        else{
                            kq.setText("Kết quả : " + "Phương trình vô nghiệm");
                            break;
                        }
                    }
                    default:{
                        kq.setText("Kết quả : " + "x = " + (-b/a));
                        break;
                    }
                }
            }
        });
    }
}
