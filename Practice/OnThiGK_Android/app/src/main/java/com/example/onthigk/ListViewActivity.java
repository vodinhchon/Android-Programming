package com.example.onthigk;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity {

    Button button_exit;
    String[] presidensts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        eventClickExit();
        createListView();
    }

    private void createListView() {
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        presidensts = getResources().getStringArray(R.array.president_array);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, presidensts));
    }

    private void eventClickExit() {
        button_exit = (Button) findViewById(R.id.button_exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, "You have selected " + presidensts[position], Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        ListView listView = getListView();
        String itemSelected = "Selected items: \n";
        for (int i = 0; i < listView.getCount(); i++){
            if(listView.isItemChecked(i)){
                itemSelected += listView.getItemAtPosition(i) + "\n";
            }
        }
        Toast.makeText(this, itemSelected, Toast.LENGTH_LONG).show();
    }
}