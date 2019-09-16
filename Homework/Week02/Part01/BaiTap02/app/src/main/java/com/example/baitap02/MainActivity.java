package com.example.baitap02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_clear, btn_cel, btn_fah;
    EditText edt_fah, edt_cel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFindViewByID();
        eventClick();
    }

    private void eventClick() {
        btn_cel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float fah = Float.parseFloat(edt_fah.getText().toString());
                edt_cel.setText("" + ((fah - 32) * 5/9));
            }
        });

        btn_fah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float cel = Float.parseFloat(edt_cel.getText().toString());
                edt_fah.setText("" + (cel * 9/5 + 32));
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_cel.setText("");
                edt_fah.setText("");
            }
        });
    }

    private void createFindViewByID(){
        //Button
        btn_cel = (Button) findViewById(R.id.button_cel);
        btn_fah = (Button) findViewById(R.id.button_fah);
        btn_clear = (Button) findViewById(R.id.button_clear);
        //EditText
        edt_cel = (EditText) findViewById(R.id.editText_cel);
        edt_fah = (EditText) findViewById(R.id.editText_fah);
    }
}
