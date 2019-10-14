package com.example.bai02_week3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnshow = (Button) findViewById(R.id.button_show);
        registerForContextMenu(btnshow);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itemRed:
                btnshow.setTextColor(getResources().getColor(R.color.red));
                break;
            case R.id.itemGreen:
                btnshow.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.itemBlue:
                btnshow.setTextColor(getResources().getColor(R.color.blue));
                break;
            default:
                btnshow.setTextColor(getResources().getColor(R.color.red));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
