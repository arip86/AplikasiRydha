package com.example.akhmadarip.zakat.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.akhmadarip.zakat.BerandaActivity;
import com.example.akhmadarip.zakat.Holder.ActivityHolder;
import com.example.akhmadarip.zakat.MainActivity;
import com.example.akhmadarip.zakat.Model.Activity;
import com.example.akhmadarip.zakat.R;

import java.util.List;

/**
 * Created by ole on 1/1/19.
 */

public class ActivityAdapter extends RecyclerView.Adapter<ActivityHolder> {
    private List<Activity> activitys;

    public ActivityAdapter(List<Activity> activitys) {
        this.activitys = activitys;
    }

    public ActivityAdapter() {

    }

    @Override
    public ActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ActivityHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity,null));
    }

    @Override
    public void onBindViewHolder(ActivityHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.gambar.setImageResource(activitys.get(position).getGambar());
        holder.txtJudul.setText(activitys.get(position).getJudul());
        holder.cardActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                switch (position){
                    case 0:
                        i = new Intent(v.getContext(), MainActivity.class);
                        break;
                    case 1:
                        i = new Intent(v.getContext(), BerandaActivity.class);
                        break;

                }
                v.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return activitys.size();
    }


}
