package com.magang.jvm_es3_kula.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.viewmodel.ViewModelFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        ProductViewModel viewModel = new ViewModelProvider(this,factory).get(ProductViewModel.class);

        viewModel.getAllProduct().observe(this,productResponses ->{
            Log.d("Coba","List Product : "+ productResponses.size());
        });
    }
}