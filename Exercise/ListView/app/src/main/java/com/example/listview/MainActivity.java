package com.example.listview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

//    String[] presidents = {
//      "Dwight D. Eisenhover",
//      "John F. Kennedy",
//      "Lyndon B. Johnson",
//      "Richard Nixon",
//      "Gerald Ford",
//      "Jimmy Carter",
//      "Ronald Reagan",
//      "George H. W. Bush",
//      "Bill Clinton",
//      "George W. Bush",
//      "Barack Obama"
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, presidents));
//    }
//
//    //position de lay vi tri cham tay vao item trong danh sach item
//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        String p = presidents[position];
//        Toast.makeText(this, "You have selected " + p, Toast.LENGTH_SHORT).show();
//    }

    //---------------------------------------------------------//

    String[] presidensts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);

        presidensts = getResources().getStringArray(R.array.president_array);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, presidensts));
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
