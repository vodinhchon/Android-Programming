package com.example.bai04_week2_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private TextView tvw_kq;
    private Button btn_nhap;
    private EditText edt_ten;
    private ArrayList<String> mylist;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFindViewByID();
        eventNotifyDataListView();
        eventClickButton();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String p = "Position : " + position;
        String value = "value = " + (String) getListAdapter().getItem(position);
        tvw_kq.setText(p + "; " + value + "");
    }

    private void eventClickButton() {
        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edt_ten.getText().toString();
                if(checkEmpty(ten)){
                    mylist.add(ten + "");
                    adapter.notifyDataSetChanged();
                    edt_ten.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "Tên không được để trống !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void eventNotifyDataListView() {
        mylist = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylist);
        setListAdapter(adapter);
    }

    private void createFindViewByID() {
        tvw_kq = (TextView) findViewById(R.id.textView_kq);
        btn_nhap = (Button) findViewById(R.id.button_nhap);
        edt_ten = (EditText) findViewById(R.id.editText_ten);
    }

    public boolean checkEmpty(String name){
        if(name.isEmpty())
            return false;
        return true;
    }
}
