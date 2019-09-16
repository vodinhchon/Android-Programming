package com.example.example_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_enter, btn_exit;
    TextView tvw_name, tvw_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_enter = (Button) findViewById(R.id.button_enter);
        btn_exit = (Button) findViewById(R.id.button_exit);
        tvw_name = (TextView) findViewById(R.id.textView_name);
        tvw_age = (TextView) findViewById(R.id.textView_age);

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, 999);
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999 && resultCode == RESULT_OK){
            String name = data.getStringExtra("name").toString();
            String yearofbirth = data.getStringExtra("yearofbirth").toString();

            SinhVien sv = new SinhVien(yearofbirth);

            tvw_name.setText("Name : " + name);
            tvw_age.setText("Age : " + sv.tinhTuoi());
        }
    }
}
