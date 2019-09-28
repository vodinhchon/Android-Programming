package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvw_ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Message");
        mydialog.setIcon(R.drawable.android);
        tvw_ketqua = (TextView) findViewById(R.id.textView_ketqua);

        //---------------------//

//        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                tvw_ketqua.setText("You choice yes.");
//            }
//        });
//        mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
//            }
//        });
//        mydialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
//            }
//        });

        //---------------------//

//        final CharSequence[] items = {"Red", "Yellow", "Orange"};
//        mydialog.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                tvw_ketqua.setText(items[i].toString());
//            }
//        });

        //---------------------//

//        final CharSequence[] items = {"Red", "Yellow", "Orange"};
//        final boolean[] arraycheck = {false, false, false};
//        mydialog.setMultiChoiceItems(items, arraycheck, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                        arraycheck[i] = b;
//                    }
//        });
//        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                String st = "";
//                for (int j = 0; j <items.length; j++){
//                    if(arraycheck[j])
//                        st += items[j].toString() + "\n";
//                    tvw_ketqua.setText("My colors : \n" + st);
//                }
//            }
//        });

        //---------------------//

        AlertDialog alertDialog = mydialog.create();
        alertDialog.show();
    }
}
