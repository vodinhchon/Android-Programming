package com.example.bai05_week2_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_nhapnv;
    EditText edt_manv, edt_tennv;
    RadioGroup radgr_loainv;
    ListView listView;
    ArrayAdapter<Employee> adapter;
    ArrayList<Employee> employeeArrayList;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFindViewByID();
        createListView();
        eventClick();
    }

    private void eventClick() {
        btn_nhapnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radg = radgr_loainv.getCheckedRadioButtonId();
                String id = edt_manv.getText().toString();
                String name = edt_tennv.getText().toString();
                if(checkID(id)){
                    if(checkName(name)){
                        if(radg == R.id.radioButton_chinhthuc){
                            employee = new EmployeeFullTime();
                        }
                        else{
                            employee = new EmployeePartTime();
                        }
                        employee.setId(id);
                        employee.setName(name);
                        employeeArrayList.add(employee);
                        adapter.notifyDataSetChanged();
                        edt_manv.setText("");
                        edt_tennv.setText("");
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Tên nhân viên không được trống !", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Mã nhân viên không được trống !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void createListView() {
        employeeArrayList = new ArrayList<Employee>();
        adapter = new ArrayAdapter<Employee>(MainActivity.this,
                android.R.layout.simple_list_item_1, employeeArrayList);
        listView.setAdapter(adapter);
    }

    private void createFindViewByID() {
        btn_nhapnv = (Button) findViewById(R.id.button_nhapnv);
        edt_manv = (EditText) findViewById(R.id.editText_manv);
        edt_tennv = (EditText) findViewById(R.id.editText_tennv);
        radgr_loainv = (RadioGroup) findViewById(R.id.radioGroup_loainv);
        listView = (ListView) findViewById(R.id.listView_ds);
    }

    public boolean checkID(String id){
        if(id.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean checkName(String name){
        if(name.isEmpty()){
            return false;
        }
        return true;
    }
}
