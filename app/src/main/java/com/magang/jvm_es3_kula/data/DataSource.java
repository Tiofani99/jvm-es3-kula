package com.magang.jvm_es3_kula.data;

import androidx.lifecycle.LiveData;

import com.magang.jvm_es3_kula.data.rest.response.ProductResponse;

import java.util.List;

public interface DataSource {
    LiveData<List<ProductResponse>> getAllProducts();
}
