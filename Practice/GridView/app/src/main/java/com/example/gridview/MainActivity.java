package com.example.gridview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String arr[] = {"Ipad", "Iphone", "New Ipad", "Samsung", "Nokia", "Sony Ericson", "LG",
                    "Q-Mobile", "HTC", "Blackberry", "G Phone", "FPT - Phone", "HK Phone"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView selection = (TextView) findViewById(R.id.textView_selection);
        final GridView gv = (GridView) findViewById(R.id.gridView_items);
        ArrayAdapter<String> da = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        gv.setAdapter(da);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(arr[i]);
            }
        });
    }
}
