package com.example.bai01_week2_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_long, btn_short;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_long = (Button) findViewById(R.id.button_long);
        btn_short = (Button) findViewById(R.id.button_short);

        final Toast toast_long = Toast.makeText(this, "Hello toast long !", Toast.LENGTH_LONG);
        final Toast toast_short = Toast.makeText(this, "Hello toast short !", Toast.LENGTH_SHORT);

        btn_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast_long.show();
            }
        });

        btn_short.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast_short.show();
            }
        });
    }
}
