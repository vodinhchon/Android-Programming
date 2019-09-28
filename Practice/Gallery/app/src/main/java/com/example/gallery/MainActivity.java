package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(R.layout.activity_main);
        list.add(R.drawable.h1);
        list.add(R.drawable.h2);
        list.add(R.drawable.h3);
        list.add(R.drawable.h4);
        list.add(R.drawable.h5);
        list.add(R.drawable.h6);
        list.add(R.drawable.h7);

        final ImageView imageView = (ImageView) findViewById(R.id.image_car);
        Gallery gallery = (Gallery) findViewById(R.id.gallery_car);
        MyAdapter adapter = new MyAdapter(list, MainActivity.this);

        gallery.setAdapter(adapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(list.get(i));
            }
        });
    }
}
