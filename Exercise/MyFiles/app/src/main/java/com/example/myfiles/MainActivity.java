package com.example.myfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
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

public class MainActivity extends AppCompatActivity {

    EditText et_filename;
    EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_filename = (EditText) findViewById(R.id.edit_filename);
        et_content = (EditText) findViewById(R.id.edit_content);

        Button bt_new = (Button) findViewById(R.id.button_clear);
        bt_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearText();
            }
        });

        final ArrayList<String> filenamelist = new ArrayList<String>();
        filenamelist.add("Hello");
        final Spinner sp_filename = (Spinner) findViewById(R.id.spinner_files);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, filenamelist);
        sp_filename.setAdapter(adapter);
        sp_filename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                et_filename.setText(filenamelist.get(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Item nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        Button bt_save = (Button)findViewById(R.id.button_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = et_filename.getText().toString();
                String content = et_content.getText().toString();
                filenamelist.add(filename);
                try {
                    //Internal Storage
//                    FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
//                    fout.write(et_content.getText().toString().getBytes());
//                    fout.close();

                    //Shared Preferences
                    SharedPreferences pref = getApplicationContext().getSharedPreferences(filename, 0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString(filename, content);
                    editor.commit();

                    clearText();
                    Toast.makeText(MainActivity.this, "Save file successfully!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error save file !", Toast.LENGTH_SHORT).show();
                }
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
                    Toast.makeText(MainActivity.this, "Open file successfully !", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error open file !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void clearText(){
        et_filename.setText("");
        et_content.setText("");
        et_filename.requestFocus();
    }

}
