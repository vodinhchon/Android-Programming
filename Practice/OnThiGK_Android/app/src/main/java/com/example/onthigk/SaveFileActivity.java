package com.example.onthigk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class SaveFileActivity extends AppCompatActivity {

    EditText editText_filename, editText_content;
    Button button_save, button_view, button_exit;
    String cus;
    String filename, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_file);

        mappingView();
        loadIntent();
        eventClickSaveFile();
        eventClickViewFile();
        eventClickExit();
    }

    private void eventClickViewFile() {
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaveFileActivity.this, ReadFile.class);
                intent.putExtra("fileName", filename);
                startActivity(intent);
            }
        });
    }

    private void eventClickSaveFile() {
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filename = editText_filename.getText().toString();
                content = editText_content.getText().toString();
                try{
                    //Internal Storage
                    FileOutputStream fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    fileOutputStream.write(content.getBytes());
                    fileOutputStream.close();
                    clear();
                    Toast.makeText(SaveFileActivity.this, "Save file successfully!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(SaveFileActivity.this, "Error save file !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void eventClickExit() {
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void clear() {
        editText_filename.setText("");
        editText_content.setText("");
        editText_filename.requestFocus();
    }

    private void loadIntent() {
        Intent intent = new Intent();
        cus = getIntent().getExtras().getString("customer");
        editText_content.setText("" + cus);
    }

    private void mappingView() {
        editText_filename = (EditText) findViewById(R.id.editText_filename);
        editText_content = (EditText) findViewById(R.id.editText_content);
        button_save = (Button) findViewById(R.id.button_save);
        button_view = (Button) findViewById(R.id.button_view);
        button_exit = (Button) findViewById(R.id.button_exit);
    }
}
