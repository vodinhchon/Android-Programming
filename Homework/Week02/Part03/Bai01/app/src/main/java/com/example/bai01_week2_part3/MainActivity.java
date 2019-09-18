package com.example.bai01_week2_part3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> nhanVienArrayList = null;
    MyArrayAdapter myArrayAdapter = null;
    ListView listView_nv = null;
    Button btn_nhap;
    ImageButton btn_xoa;
    EditText edt_ma, edt_ten;
    RadioGroup rad_gender;
    RadioButton rad_nam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFindViewByID();
        eventClickInputNV();
        eventClickDelete();
    }

    private void eventClickDelete() {
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = listView_nv.getChildCount() - 1; i >= 0; i--){
                    View v = listView_nv.getChildAt(i);
                    CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBox_item);
                    if(checkBox.isChecked()){
                        nhanVienArrayList.remove(i);
                    }
                }

                myArrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void eventClickInputNV() {
        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = edt_ma.getText().toString();
                String ten = edt_ten.getText().toString();
                boolean gt = false;
                if(checkEmpty(ma, ten)){
                    if(rad_gender.getCheckedRadioButtonId() == R.id.radioButton_nam){
                        gt = true;
                    }
                    NhanVien nv = new NhanVien();
                    nv.setId(ma);
                    nv.setName(ten);
                    nv.setGender(gt);

                    nhanVienArrayList.add(nv);
                    myArrayAdapter.notifyDataSetChanged();

                    edt_ma.setText("");
                    edt_ten.setText("");
                    rad_nam.setChecked(true);
                    edt_ma.requestFocus();
                }
                else{
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createFindViewByID() {
        btn_nhap = (Button) findViewById(R.id.button_nhapnv);
        btn_xoa = (ImageButton) findViewById(R.id.button_xoa);
        edt_ma = (EditText) findViewById(R.id.editText_manv);
        edt_ten = (EditText) findViewById(R.id.editText_tennv);
        rad_gender = (RadioGroup) findViewById(R.id.radioGroup_gt);
        rad_nam = (RadioButton) findViewById(R.id.radioButton_nam);
        listView_nv = (ListView) findViewById(R.id.listView_ds);

        nhanVienArrayList = new ArrayList<NhanVien>();
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.my_item, nhanVienArrayList);
        listView_nv.setAdapter(myArrayAdapter);
    }

    public boolean checkEmpty(String id, String name){
        if(id.isEmpty() || name.isEmpty()){
            return false;
        }
        return true;
    }
}
