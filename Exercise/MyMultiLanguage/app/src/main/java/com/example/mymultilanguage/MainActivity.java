package com.example.mymultilanguage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity<loadlocale> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadLocale();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        Button btn_change = (Button) findViewById(R.id.button_change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"English", "French", "Vietnam", "Italian"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose Language ...");
        builder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:{
                        setLocale("en");
                        recreate();
                        Toast.makeText(MainActivity.this, R.string.notechange, Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 1:{
                        setLocale("fr");
                        recreate();
                        Toast.makeText(MainActivity.this, R.string.notechange, Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 2:{
                        setLocale("vi");
                        recreate();
                        Toast.makeText(MainActivity.this, R.string.notechange, Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 3:{
                        setLocale("it");
                        recreate();
                        Toast.makeText(MainActivity.this, R.string.notechange, Toast.LENGTH_LONG).show();
                        break;
                    }
                    default:dialogInterface.dismiss();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Setting", MODE_PRIVATE).edit();
        editor.putString("My_Language", language);
        editor.apply();
    }

    private void loadLocale() {
        SharedPreferences pref = getSharedPreferences("Setting", Activity.MODE_PRIVATE);
        String language = pref.getString("My_Language", "");
        setLocale(language);
    }
}
