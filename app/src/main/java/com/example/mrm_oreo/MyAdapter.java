package com.example.mrm_oreo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<ItemMenu> itemMenus;

    public MyAdapter(Context context, List<ItemMenu> itemMenus) {
        this.context = context;
        this.itemMenus = itemMenus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameView.setText(itemMenus.get(position).getName());
        holder.keteranganView.setText(itemMenus.get(position).getKeterangan());
        holder.gambarmenu.setImageResource(itemMenus.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return itemMenus.size();
    }
}
