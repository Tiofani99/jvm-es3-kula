package com.magang.jvm_es3_kula.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.data.rest.response.CategoryResponse;
import com.magang.jvm_es3_kula.viewmodel.ViewModelFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvktgori;
    private ArrayList<CategoryResponse> list = new ArrayList<>();
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvktgori = findViewById(R.id.rv_home);
        rvktgori.setHasFixedSize(true);
//        showRecycleList();
        initAdapter();

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        ProductViewModel viewModel = new ViewModelProvider(this, factory).get(ProductViewModel.class);

        viewModel.getAllProduct().observe(this, productResponses -> {
            Log.d("Coba", "List Product : " + productResponses.size());
        });

        viewModel.getAllCategory().observe(this, categoryResponses -> {
            Log.d("Coba", "List Category : " + categoryResponses.size());
            categoryAdapter.setListktgori((ArrayList<CategoryResponse>) categoryResponses);
            rvktgori.setAdapter(categoryAdapter);
        });


    }

//    private void showRecycleList() {
//        rvktgori.setLayoutManager(new LinearLayoutManager(this));
//        CategoryAdapter categoryAdapter = new CategoryAdapter(this, list);
//        rvktgori.setAdapter(categoryAdapter);
//    }

    private void initAdapter() {
        rvktgori.setLayoutManager(new LinearLayoutManager(this));
        categoryAdapter = new CategoryAdapter(MainActivity.this);
        categoryAdapter.notifyDataSetChanged();
    }
}