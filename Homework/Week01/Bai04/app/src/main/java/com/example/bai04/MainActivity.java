package com.example.bai04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nn;
    Button in;
    TextView kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nn = findViewById(R.id.editText_nhapN);
        in = findViewById(R.id.button_in);
        kq = findViewById(R.id.textView4_kq);

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(nn.getText().toString());
                if(n > 0 && n < 10){
                    kq.setText( n + " x 1" + " = " + (n * 1) + '\n' +
                                n + " x 2" + " = " + (n * 2) + '\n' +
                                n + " x 3" + " = " + (n * 3) + '\n' +
                                n + " x 4" + " = " + (n * 4) + '\n' +
                                n + " x 5" + " = " + (n * 5) + '\n' +
                                n + " x 6" + " = " + (n * 6) + '\n' +
                                n + " x 7" + " = " + (n * 7) + '\n' +
                                n + " x 8" + " = " + (n * 8) + '\n' +
                                n + " x 9" + " = " + (n * 9) + '\n' +
                                n + " x 10"+ " = " + (n * 10));
                }
                else{
                    kq.setText("N chỉ từ 1 -> 9. Mời bạn nhập lại");
                }
            }
        });
    }
}
