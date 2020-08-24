package com.magang.jvm_es3_kula.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.magang.jvm_es3_kula.data.DataRepository;
import com.magang.jvm_es3_kula.data.rest.response.CategoryResponse;
import com.magang.jvm_es3_kula.data.rest.response.ProductResponse;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private DataRepository dataRepository;

    public ProductViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public LiveData<List<ProductResponse>> getAllProduct(){
        return dataRepository.getAllProducts();
    }

    public LiveData<List<CategoryResponse>> getAllCategory(){
        return dataRepository.getAllCategory();
    }
}
