package com.example.baitap06;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    TextView tvw_kq;
    String presidents[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setTextFilterEnabled(true);

        presidents = getResources().getStringArray(R.array.president_array);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, presidents));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        tvw_kq = (TextView) findViewById(R.id.textView_kq);
        tvw_kq.setText("Position : " + position + ", value = " + presidents[position]);
    }
}
