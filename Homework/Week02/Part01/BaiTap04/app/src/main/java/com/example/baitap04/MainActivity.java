package com.example.baitap04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_gui;
    EditText edt_hoten, edt_cmnd, edt_thongtin;
    RadioGroup radgr_bangcap;
    CheckBox cbox_docbao, cbox_docsach, cbox_doccoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFIndViewByID();
        eventClick();
    }

    private void eventClick() {
        btn_gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                String hoten = edt_hoten.getText().toString();
                String cmnd = edt_cmnd.getText().toString();
                String docbao = cbox_docbao.getText().toString();
                String docsach = cbox_docsach.getText().toString();
                String doccoding = cbox_doccoding.getText().toString();
                String thongtin = edt_thongtin.getText().toString();
                String bangcap = ((RadioButton) findViewById(radgr_bangcap.getCheckedRadioButtonId())).getText().toString();

                if(!checkName(hoten)){
                    Toast.makeText(getApplicationContext(), "Họ tên không được để trống và phải có ít nhất 3 ký tự", Toast.LENGTH_LONG).show();
                }
                else if(!checkCMND(cmnd)){
                    Toast.makeText(getApplicationContext(), "CMND phải có đúng 9 chữ số", Toast.LENGTH_LONG).show();
                }
                else if(!checkHobby(cbox_docbao, cbox_docsach, cbox_doccoding)){
                    Toast.makeText(getApplicationContext(), "Sở thích phải lựa chọn ít nhất 1", Toast.LENGTH_LONG).show();
                }
                else{
                    if(cbox_docbao.isChecked()){
                        intent.putExtra("docbao", new String(docbao));
                    }
                    if(cbox_docsach.isChecked()){
                        intent.putExtra("docsach", new String(docsach));
                    }
                    if(cbox_doccoding.isChecked()){
                        intent.putExtra("doccoding", new String(doccoding));
                    }
                    intent.putExtra("hoten", new String(hoten));
                    intent.putExtra("cmnd", new String(cmnd));
                    intent.putExtra("bangcap", new String(bangcap));
                    intent.putExtra("thongtin", new String(thongtin));
                    startActivity(intent);
                }

            }
        });
    }

    public boolean checkName(String name){
        if(!name.isEmpty() && name.length() >= 3){
            return true;
        }
        return false;
    }

    public boolean checkCMND(String cmnd){
        if(cmnd.matches("[0-9]{9}")){
            return true;
        }
        return false;
    }

    public boolean checkHobby(CheckBox h1, CheckBox h2, CheckBox h3){
        if(!h1.isChecked() && !h2.isChecked() && !h3.isChecked()){
            return false;
        }
        return true;
    }

    private void createFIndViewByID() {
        //Button
        btn_gui = (Button) findViewById(R.id.button_gui);
        //editText
        edt_hoten = (EditText) findViewById(R.id.editText_hoten);
        edt_cmnd = (EditText) findViewById(R.id.editText_cmnd);
        edt_thongtin = (EditText) findViewById(R.id.editText_thongtin);
        //Radio
        radgr_bangcap = (RadioGroup) findViewById(R.id.radioGroup_bangcap);
        //Checkbox
        cbox_docbao = (CheckBox) findViewById(R.id.checkBox_docbao);
        cbox_docsach = (CheckBox) findViewById(R.id.checkBox_docsach);
        cbox_doccoding = (CheckBox) findViewById(R.id.checkBox_doccoding);
    }
}
