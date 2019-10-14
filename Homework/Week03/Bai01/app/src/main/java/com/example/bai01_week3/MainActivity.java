package com.example.bai01_week3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //cách 1
//        getMenuInflater().inflate(R.menu.menu, menu);
        //cách 2 runtime
        int itemID = 001;
        menu.add(0, itemID, 0, "Xem danh sách sinh viên");
        SubMenu sub2 = menu.addSubMenu("Xem danh sách lớp");
        itemID = 002;
        sub2.add(0, itemID, 0, "Đại học Tin Học 1A");
        itemID = 003;
        sub2.add(0, itemID, 0, "Đại học Tin Học 1B");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //cách 1
//        switch (id){
//            case R.id.menu_xemdssv:{
//                Toast.makeText(getApplicationContext(), "Xem danh sách sinh viên", Toast.LENGTH_LONG).show();
//                break;
//            }
//            case R.id.menu_1a:{
//                Toast.makeText(getApplicationContext(), "Đại học Tin Học 1A", Toast.LENGTH_LONG).show();
//                break;
//            }
//            case R.id.menu_1b:{
//                Toast.makeText(getApplicationContext(), "Đại học Tin Học 1B", Toast.LENGTH_LONG).show();
//                break;
//            }
//        }
        //cách 2 runtime
        switch (id){
            case 001:{
                Toast.makeText(getApplicationContext(), "Xem danh sách sinh viên", Toast.LENGTH_LONG).show();
                break;
            }
            case 002:{
                Toast.makeText(getApplicationContext(), "Đại học Tin Học 1A", Toast.LENGTH_LONG).show();
                break;
            }
            case 003:{
                Toast.makeText(getApplicationContext(), "Đại học Tin Học 1B", Toast.LENGTH_LONG).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
