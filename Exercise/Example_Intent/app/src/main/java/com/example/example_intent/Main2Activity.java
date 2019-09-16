package com.example.example_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Button btn_submit;
    EditText edt_name, edt_yearofbirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_submit = (Button) findViewById(R.id.button_submit);
        edt_name = (EditText) findViewById(R.id.editText_name);
        edt_yearofbirth = (EditText) findViewById(R.id.editText_yearofbirth);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_name.getText().toString();
                String yearofbirth = edt_yearofbirth.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("yearofbirth", yearofbirth);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
