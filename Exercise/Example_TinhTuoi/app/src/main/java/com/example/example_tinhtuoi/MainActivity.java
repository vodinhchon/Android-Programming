package com.example.example_tinhtuoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText hoten, namsinh;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoten = (EditText) findViewById(R.id.editText_ten);
        namsinh = (EditText) findViewById(R.id.editText_namsinh);
        submit = (Button) findViewById(R.id.button_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("hoten", new String(hoten.getText().toString()));
                intent.putExtra("namsinh", new String(namsinh.getText().toString()));
                startActivity(intent);
            }
        });

    }
}
