package com.magang.jvm_es3_kula.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.magang.jvm_es3_kula.CategoryAdapter;
import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.kategori;
import com.magang.jvm_es3_kula.viewmodel.ViewModelFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvktgori;
    private ArrayList<kategori> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvktgori = findViewById(R.id.rv_home);
        rvktgori.setHasFixedSize(true);
        list.addAll(ZdkData.getListData());
        showRecycleList();

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        ProductViewModel viewModel = new ViewModelProvider(this, factory).get(ProductViewModel.class);

        viewModel.getAllProduct().observe(this, productResponses -> {
            Log.d("Coba", "List Product : " + productResponses.size());
        });
    }

    private void showRecycleList() {
        rvktgori.setLayoutManager(new LinearLayoutManager(this));
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, list);
        rvktgori.setAdapter(categoryAdapter);
    }
}