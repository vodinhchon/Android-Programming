package com.example.bai02;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinDm;
    EditText editma, editten;
    Button btnNhap;
    ListView lvSp;

    ArrayList<Catolog> arraySpinner = new ArrayList<Catolog>();
    ArrayAdapter<Catolog> adapterSpinner = null;

    ArrayList<Product> arrayListview = new ArrayList<Product>();
    ArrayAdapter<Product> adapterListview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetControl();
        fakeDataCatalog();
        addEventsForFormWidgets();
    }

    private void getWidgetControl() {
        spinDm = (Spinner) findViewById(R.id.spinner_dm);
        editma = (EditText) findViewById(R.id.editText_masp);
        editten = (EditText) findViewById(R.id.editText_tensp);
        btnNhap = (Button) findViewById(R.id.button_nhap);
        lvSp = (ListView) findViewById(R.id.listView_ds);

        adapterSpinner = new ArrayAdapter<Catolog>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDm.setAdapter(adapterSpinner);

        adapterListview = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, arrayListview);
        lvSp.setAdapter(adapterListview);
    }

    private void fakeDataCatalog() {
        Catolog cat1 = new Catolog("1", "Samsung");
        Catolog cat2 = new Catolog("2", "IPhone");
        Catolog cat3 = new Catolog("3", "IPad");
        Catolog cat4 = new Catolog("4", "Asus");
        Catolog cat5 = new Catolog("5", "Nokia");
        arraySpinner.add(cat1);
        arraySpinner.add(cat2);
        arraySpinner.add(cat3);
        arraySpinner.add(cat4);
        arraySpinner.add(cat5);
        adapterSpinner.notifyDataSetChanged();
    }

    private void addEventsForFormWidgets() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProductForCatalog();
            }
        });
        spinDm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadListProductByCatalog(arraySpinner.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addProductForCatalog() {
        Product p = new Product();
        String id = editma.getText().toString();
        String name = editten.getText().toString();
        if (checkEmpty(id, name)){
            p.setId(id);
            p.setName(name);
            Catolog c = (Catolog) spinDm.getSelectedItem();
            boolean b = c.addProduct(p);
            if(b){
                Toast.makeText(MainActivity.this, "Thêm sản phẩm mới thành công !", Toast.LENGTH_SHORT).show();
                loadListProductByCatalog(c);
            }
            else{
                Toast.makeText(MainActivity.this, "Mã sản phẩm đã tồn tại !", Toast.LENGTH_SHORT).show();
                editma.requestFocus();
            }
        }
        else{
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadListProductByCatalog(Catolog catolog) {
        editma.setText("");
        editten.setText("");
        editma.requestFocus();
        arrayListview.clear();
        arrayListview.addAll(catolog.getListProduct());
        adapterListview.notifyDataSetChanged();
    }

    public boolean checkEmpty(String id, String name){
        if(id.isEmpty() || name.isEmpty()){
            return false;
        }
        return true;
    }

}