package com.example.onthigk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.layout.simple_spinner_item;

public class MainActivity extends AppCompatActivity {

    Button button_save;
    EditText editText_id, editText_name, editText_amount;
    RadioGroup radioGroup_job;
    RadioButton radioButton_student;
    Spinner spinner_city;
    CheckBox checkBox_vip;
    ListView listView_listCus;
    ArrayList<Person> personArrayList;
    ArrayAdapter<Person> personArrayAdapter;
    Person person;
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mappingView();
        createArrayListPerson();
        eventClickSpinnerCity();
        eventClickSave();
    }

    private void eventClickSave() {
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editText_id.getText().toString();
                String name = editText_name.getText().toString();
                int amount = Integer.parseInt(editText_amount.getText().toString());
                boolean member = false;
                int rad = radioGroup_job.getCheckedRadioButtonId();
                if(checkEmpty(id, name)){

                    if(rad == R.id.radioButton_student){
                        person = new Student();
                    }
                    else{
                        person = new Teacher();
                    }
                    if(checkBox_vip.isChecked()){
                        member = true;
                    }
                    person.setId(id);
                    person.setName(name);
                    person.setCity(city);
                    person.charged(amount, member);
                    personArrayList.add(person);
                    personArrayAdapter.notifyDataSetChanged();
                    noticeSaveSuccess();
                    clear();
                }
                else{
                    editText_id.requestFocus();
                    noticeErrorEmpty();
                }
            }
        });
    }

    private void noticeErrorEmpty() {
        Toast.makeText(MainActivity.this, "Error. Please enter full information !", Toast.LENGTH_SHORT).show();
    }

    private void noticeSaveSuccess() {
        Toast.makeText(MainActivity.this, "Save customer Successfully !", Toast.LENGTH_SHORT).show();
    }

    private void clear() {
        editText_id.setText("");
        editText_name.setText("");
        editText_amount.setText("1");
        radioButton_student.setChecked(true);
        checkBox_vip.setChecked(false);
        editText_id.requestFocus();
    }

    private void eventClickSpinnerCity() {
        final String[] arrayCity = getResources().getStringArray(R.array.arrayCity);
        ArrayAdapter<String> arrayAdapterCity = new ArrayAdapter<String>(MainActivity.this,
                simple_spinner_item, arrayCity);
        spinner_city.setAdapter(arrayAdapterCity);
        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index = adapterView.getSelectedItemPosition();
                city = arrayCity[index];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void createArrayListPerson() {
        personArrayList = new ArrayList<Person>();
        personArrayAdapter = new ArrayAdapter<Person>(MainActivity.this,
                android.R.layout.simple_list_item_1, personArrayList);
        listView_listCus.setAdapter(personArrayAdapter);
    }

    private void mappingView() {
        button_save = (Button) findViewById(R.id.button_save);
        editText_id = (EditText) findViewById(R.id.editText_id);
        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_amount = (EditText) findViewById(R.id.editText_amount);
        radioGroup_job = (RadioGroup) findViewById(R.id.radioGroup_job);
        radioButton_student = (RadioButton) findViewById(R.id.radioButton_student);
        spinner_city = (Spinner) findViewById(R.id.spinner_city);
        checkBox_vip = (CheckBox) findViewById(R.id.checkBox_member);
        listView_listCus = (ListView) findViewById(R.id.listView_listCus);
        editText_id.requestFocus();
    }

    public boolean checkEmpty(String id, String name){
        if(id.isEmpty() || name.isEmpty()){
            return false;
        }
        return true;
    }

//    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_item, menu);
    }

    //show menu on activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

        @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_saveFile:{
                saveFile();
                return true;
            }
            case R.id.menu_showListView:{
                showListView();
                return true;
            }
            case R.id.menu_showGridView:{
                showGridView();
                return true;
            }
            case R.id.menu_exit:{
                finish();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showGridView() {
        Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
        startActivity(intent);
    }

    private void showListView() {
        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(intent);
    }

    private void saveFile() {
        String cus = "";
        Intent intent = new Intent(MainActivity.this, SaveFileActivity.class);
        for (Person p : personArrayList){
            cus += p.toString() + "\n";
        }
        intent.putExtra("customer", cus);
        startActivity(intent);
    }
}
