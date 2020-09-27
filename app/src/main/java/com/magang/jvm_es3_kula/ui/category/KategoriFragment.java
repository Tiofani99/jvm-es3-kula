package com.magang.jvm_es3_kula.ui.category;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.data.rest.response.ProductResponse;
import com.magang.jvm_es3_kula.ui.main.GridProdukAdapter;
import com.magang.jvm_es3_kula.ui.main.ProductViewModel;
import com.magang.jvm_es3_kula.viewmodel.ViewModelFactory;

import java.util.ArrayList;


public class KategoriFragment extends Fragment {

    private GridProdukAdapter gridProdukAdapter;
    private RecyclerView rvProduct;


    public KategoriFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kategori, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvProduct = view.findViewById(R.id.rv_product);
        initAdapter();

        ViewModelFactory factory = ViewModelFactory.getInstance(requireActivity());
        ProductViewModel viewModel = new ViewModelProvider(this, factory).get(ProductViewModel.class);

        viewModel.getAllProduct().observe(requireActivity(), productResponses -> {
            Log.d("Coba", "List Product : " + productResponses.size());
            gridProdukAdapter.setListProduk((ArrayList<ProductResponse>) productResponses);
            rvProduct.setAdapter(gridProdukAdapter);
        });
    }

    private void initAdapter() {
        rvProduct.setLayoutManager(new GridLayoutManager(requireActivity(), 2));
        gridProdukAdapter = new GridProdukAdapter(requireActivity());
        gridProdukAdapter.notifyDataSetChanged();
    }
}