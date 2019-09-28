package com.example.timeselection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button_1);
        btn2 = (Button) findViewById(R.id.button_2);
        btn3 = (Button) findViewById(R.id.button_3);
        btn4 = (Button) findViewById(R.id.button_4);
        textView = (TextView) findViewById(R.id.textView);

        eventCleck();
    }

    private void eventCleck() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalogClock analogClock = new AnalogClock(MainActivity.this);
                ((LinearLayout) findViewById(R.id.mylayout)).addView(analogClock);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chronometer chronometer = new Chronometer(MainActivity.this);
                ((LinearLayout) findViewById(R.id.mylayout)).addView(chronometer);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        ((TextView) findViewById(R.id.textView)).setText(i + " - " + i1 + "@@@" +
                                                                        timePicker.getCurrentHour() + " - " +
                                                                        timePicker.getCurrentMinute());
                    }
                };
                TimePickerDialog time = new TimePickerDialog(MainActivity.this, callback, 12, 30, true);
                time.show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        ((TextView) findViewById(R.id.textView)).setText((i2 + 1) + "/" + (i1 + 1) + "/" + i);
                    }
                };
                DatePickerDialog pic = new DatePickerDialog(MainActivity.this, callback, 2012, 11, 30);
                pic.setTitle("My Datetime picker");
                pic.show();
            }
        });
    }
}
