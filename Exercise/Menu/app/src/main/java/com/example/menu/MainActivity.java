package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_menu = (Button) findViewById(R.id.button_menu);
        btn_menu.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        createMenu(menu);
    }

    private void createMenu(ContextMenu menu) {
        menu.add(0, 1, 1, "Item 1");
        menu.add(0, 2, 2, "Item 2");
        menu.add(0, 3, 3, "Item 3");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu_example, menu);
        super.onCreateOptionsMenu(menu);
        createMenu((ContextMenu) menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnxemds:
                Toast.makeText(this, "Xem danh sách", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnxemdssv:
                Toast.makeText(this, "Xem danh sách sinh viên", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnxemdslh:
                Toast.makeText(this, "Xem danh sách lớp học", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnsuads:
                Toast.makeText(this, "Sửa danh sách", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnxoads:
                Toast.makeText(this, "Xóa danh sách", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mninds:
                Toast.makeText(this, "In danh sách", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnthemds:
                Toast.makeText(this, "Thêm danh sách", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnthemdssv:
                Toast.makeText(this, "Thêm danh sách sinh viên", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnthemdslh:
                Toast.makeText(this, "Thêm danh sách lớp học", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
