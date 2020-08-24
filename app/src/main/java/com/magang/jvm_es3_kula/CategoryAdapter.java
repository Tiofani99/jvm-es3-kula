package com.magang.jvm_es3_kula;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ListViewHolder> {
    private ArrayList<kategori> listktgori;
    private Context context;
    public CategoryAdapter(Context context, ArrayList<kategori> listZdk){
        this.listktgori = listktgori;
        this.context = context;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position)
    {
        final kategori zdk = listktgori.get(position);
        Glide.with(holder.itemView.getContext())
                .load(zdk.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);
        holder.tvName.setText(zdk.getName());
        holder.tvDesc.setText(zdk.getDescription());

        }

    @Override
    public int getItemCount() {
        return listktgori.size();
    }
    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_produk);
            tvName = itemView.findViewById(R.id.name_produk);
            tvDesc = itemView.findViewById(R.id.desc_produk);
            cv = itemView.findViewById(R.id.cardview_item_home);
        }
    }
}

