package com.example.myfile2mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    EditText et_filename;
    EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et_filename = (EditText) findViewById(R.id.edit_filename);
        et_content = (EditText) findViewById(R.id.edit_content);

        Intent intent = new Intent();
        final ArrayList<String> filenamelist = getIntent().getExtras().getStringArrayList("filenamelist");

        final Spinner sp_filename = (Spinner) findViewById(R.id.spinner_files);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, filenamelist);
        sp_filename.setAdapter(adapter);
        sp_filename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                et_filename.setText(filenamelist.get(i).toString());

                //SelectItem show content, no need click button open
                String filename = et_filename.getText().toString();
                SharedPreferences pref = getApplicationContext().getSharedPreferences(filename, 0);
                SharedPreferences.Editor editor = pref.edit();
                try {
                    //Shared Preferences
                    String ct = pref.getString(filename, null);

                    et_content.setText(ct);
                    Toast.makeText(Main2Activity.this, "Open file successfully !", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(Main2Activity.this, "Error open file !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Main2Activity.this, "Item nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        Button bt_open = (Button) findViewById(R.id.button_open);
        bt_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = et_filename.getText().toString();

                //Internal Storage
//                StringBuffer buffer = new StringBuffer();
//                String line = null;

                //Shared Preferences
                SharedPreferences pref = getApplicationContext().getSharedPreferences(filename, 0);
                SharedPreferences.Editor editor = pref.edit();
                try {
                    //Internal Storage
//                    FileInputStream fin = openFileInput(filename);
//                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
//                    while((line = br.readLine()) != null){
//                        buffer.append(line).append("\n");
//                    }

                    //Shared Preferences
                    String ct = pref.getString(filename, null);

                    et_content.setText(ct);
                    Toast.makeText(Main2Activity.this, "Open file successfully !", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(Main2Activity.this, "Error open file !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button bt_return = (Button) findViewById(R.id.button_return);
        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clearText(){
        et_filename.setText("");
        et_content.setText("");
        et_filename.requestFocus();
    }

}