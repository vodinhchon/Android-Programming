package com.example.baitap04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvw_hoten, tvw_cmnd, tvw_bangcap, tvw_sothich, tvw_thongtin;
    Button btn_trove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        createFindViewByID();
        showInfo();
        eventClick();
    }

    private void eventClick() {
        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void showInfo() {
        String hoten = getIntent().getExtras().getString("hoten");
        String cmnd = getIntent().getExtras().getString("cmnd");
        String bangcap = getIntent().getExtras().getString("bangcap");
        String thongtin = getIntent().getExtras().getString("thongtin");
        String docbao = getIntent().getExtras().getString("docbao");
        String docsach = getIntent().getExtras().getString("docsach");
        String doccoding = getIntent().getExtras().getString("doccoding");

        if(docbao == null){
            docbao = "";
        }
        if(docsach == null){
            docsach = "";
        }
        if(doccoding == null){
            doccoding = "";
        }

        tvw_sothich.setText("" + docbao + " " + docsach + " " + doccoding);
        tvw_hoten.setText("" + hoten);
        tvw_cmnd.setText("" + cmnd);
        tvw_bangcap.setText("" + bangcap);
        tvw_thongtin.setText("" + thongtin);
    }

    private void createFindViewByID() {
        tvw_hoten = (TextView) findViewById(R.id.textView_hoten);
        tvw_cmnd = (TextView) findViewById(R.id.textView_cmnd);
        tvw_bangcap = (TextView) findViewById(R.id.textView_bangcap);
        tvw_sothich = (TextView) findViewById(R.id.textView_sothich);
        tvw_thongtin = (TextView) findViewById(R.id.textView_thongtin);

        btn_trove = (Button) findViewById(R.id.button_trove);
    }
}
