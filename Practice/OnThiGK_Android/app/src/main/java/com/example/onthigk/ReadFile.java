package com.example.onthigk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ReadFile extends AppCompatActivity {
    EditText editText_filename, editText_content;
    Button button_open, button_exit;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        mappingView();
        loadIntent();
        eventClickOpen();
        eventClickExit();
    }

    private void eventClickExit() {
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void eventClickOpen() {
        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Internal Storage
                StringBuffer buffer = new StringBuffer();
                String line = null;
                try{
                    FileInputStream fin = openFileInput(fileName);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while((line = br.readLine()) != null){
                        buffer.append(line).append("\n");
                    }
                    editText_content.setText(buffer);
                    Toast.makeText(ReadFile.this, "Open file successfully !", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(ReadFile.this, "Error open file !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadIntent() {
        Intent intent = new Intent();
        fileName = getIntent().getExtras().getString("fileName");
        editText_filename.setText("" + fileName);
    }

    private void mappingView() {
        editText_filename = (EditText) findViewById(R.id.edit_filename);
        editText_content = (EditText) findViewById(R.id.edit_content);
        button_open = (Button) findViewById(R.id.button_open);
        button_exit = (Button) findViewById(R.id.button_exit);
    }
}
