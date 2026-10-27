package com.example.mrm_oreo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView gambarmenu;
    TextView nameView,keteranganView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        gambarmenu = itemView.findViewById(R.id.gambarmenu);
        nameView = itemView.findViewById(R.id.name);
        keteranganView = itemView.findViewById(R.id.keterangan);
    }
}
