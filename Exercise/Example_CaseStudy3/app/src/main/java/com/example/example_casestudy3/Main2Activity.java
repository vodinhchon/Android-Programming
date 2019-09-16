package com.example.example_casestudy3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText hoten, namsinh;
    Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        hoten = (EditText) findViewById(R.id.nhapten);
        namsinh = (EditText) findViewById(R.id.nhapnamsinh);
        apply = (Button) findViewById(R.id.apply);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ht = hoten.getText().toString();
                String ns = namsinh.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("return_hoten", new String(ht));
                intent.putExtra("return_namsinh", new String(ns));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
