package com.example.akhmadarip.zakat.Holder;

/**
 * Created by ole on 1/1/19.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.akhmadarip.zakat.R;

public class ActivityHolder extends RecyclerView.ViewHolder {
    public ImageView gambar;
    public TextView txtJudul;
    public View cardActivity;
    public ActivityHolder(View itemView) {
        super(itemView);
        gambar = itemView.findViewById(R.id.gbr);
        cardActivity=itemView.findViewById(R.id.card_activity);
        txtJudul=itemView.findViewById(R.id.txt_activity);
    }
}
