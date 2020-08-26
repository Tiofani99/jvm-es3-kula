package com.magang.jvm_es3_kula.ui.listproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.magang.jvm_es3_kula.R;

public class ListProductActivity extends AppCompatActivity {

    public static final String EXTRA_ID_CATEGORY = "extra_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        String id = getIntent().getStringExtra(EXTRA_ID_CATEGORY);
        Log.d("Coba","ID Kategori "+id);

    }
}