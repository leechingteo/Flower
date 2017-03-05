package com.example.lisa.flower;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;



    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mHueArray.length;

    }

    public Object getItem(int position) {
        return mHueArray[position];
    }

    public long getItemId(int position) {
        return position;
    }



    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;

        if (convertView == null) {
            grid = new View(mContext);
            //LayoutInflater inflater = getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            grid = inflater.inflate(R.layout.cellgrid, parent, false);

        } else {
            grid = (View) convertView;
        }
            ImageView imageView = (ImageView) grid.findViewById(R.id.imagepart);
            TextView textView = (TextView) grid.findViewById(R.id.textpart);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageResource(mThumbIds[position]);
            textView.setText(mHueArray[position]);



        return grid;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.calla, R.drawable.carnation,R.drawable.dahlia,
            R.drawable.daisy,R.drawable.gerbera, R.drawable.iris,R.drawable.statice

    };
    private String[] mHueArray = {
            "Calla", "Carnation","Dahlia", "Daisy","Gerbera", "Iris","Statice"

    };



}