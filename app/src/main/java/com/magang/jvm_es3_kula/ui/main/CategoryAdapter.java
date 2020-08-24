package com.magang.jvm_es3_kula.ui.main;

import android.content.Context;
import android.util.Log;
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
import com.magang.jvm_es3_kula.BuildConfig;
import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.data.rest.response.CategoryResponse;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ListViewHolder> {
    private ArrayList<CategoryResponse> listktgori = new ArrayList<>();
    private Context context;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setListktgori(ArrayList<CategoryResponse> items){
        listktgori.clear();
        listktgori.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final CategoryResponse zdk = listktgori.get(position);
        Glide.with(holder.itemView.getContext())
                .load(BuildConfig.LINK_CATEGORY_IMAGE+zdk.getCategoryImage())
//                .apply(new RequestOptions().centerCrop())
                .into(holder.imgPhoto);
        holder.tvName.setText(zdk.getCategoryName());
        holder.tvDesc.setText(zdk.getCategoryName());
        Log.d("Coba","Link gambar : "+BuildConfig.LINK_CATEGORY_IMAGE+zdk.getCategoryImage());

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

