package com.magang.jvm_es3_kula.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.data.rest.response.ProductResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridProdukAdapter extends RecyclerView.Adapter<GridProdukAdapter.GridViewHolder> {
    private ArrayList<ProductResponse> listProduk;

    public GridProdukAdapter(ArrayList<ProductResponse> list) {
        this.listProduk = list;
    }

    @NonNull
    @Override
    public GridProdukAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_grid_kategori, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridProdukAdapter.GridViewHolder holder, int position) {
        final ProductResponse product = listProduk.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.img_item_photo)
        ImageView imgPhoto;
        @BindView(R.id.tv_nama_barang)
        TextView nameProduct;
        @BindView(R.id.tv_harga_barang)
        TextView hargaProduct;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(ProductResponse product) {
            Glide.with(itemView.getContext())
                    .load(product.getProductImage())
                    .apply(new RequestOptions().override(350, 550))
                    .into(imgPhoto);
            nameProduct.setText(product.getProductName(),hargaProduct.setText(product.getProductPrice();
        }

    }
}
