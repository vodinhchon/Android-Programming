package com.example.bai01_week2_part3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;

    public MyArrayAdapter(@NonNull Activity context, int textViewResourceId, ArrayList<NhanVien> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.layoutId = textViewResourceId;
        this.myArray = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);

        if(myArray.size() > 0 && position >= 0){
            TextView tvw_Display = (TextView) convertView.findViewById(R.id.textView_item);
            NhanVien nv = myArray.get(position);
            tvw_Display.setText(nv.toString());
            ImageView img_item = (ImageView) convertView.findViewById(R.id.imageView_item);
            if(nv.isGender()){
                img_item.setImageResource(R.drawable.men);
            }
            else{
                img_item.setImageResource(R.drawable.women);
            }
        }
        return convertView;
    }
}
