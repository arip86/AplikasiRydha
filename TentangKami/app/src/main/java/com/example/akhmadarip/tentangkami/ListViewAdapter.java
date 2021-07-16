package com.example.akhmadarip.tentangkami;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



/**
 * Created by Akhmad arip on 4/19/2019.
 */

public class ListViewAdapter extends ArrayAdapter<Menubar> {

    public ListViewAdapter(Context context, int resource, List<Menubar> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (null == v) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }
            Menubar menubar = getItem(position);
            ImageView img = (ImageView) v.findViewById(R.id.imageView);
            TextView txtTitle = (TextView) v.findViewById(R.id.txtTitle);
            TextView txtDescription = (TextView) v.findViewById(R.id.txtDescription);

        img.setImageResource(menubar.getImageId());
        txtTitle.setText(menubar.getTitle());
        txtDescription.setText(menubar.getDescription());

        return v;


        }



}

