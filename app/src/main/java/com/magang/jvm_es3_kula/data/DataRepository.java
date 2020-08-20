package com.magang.jvm_es3_kula.data;

import androidx.lifecycle.LiveData;

import com.magang.jvm_es3_kula.data.rest.api.ApiCall;
import com.magang.jvm_es3_kula.data.rest.response.ProductResponse;

import java.util.List;

public class DataRepository implements DataSource{

    private volatile static DataRepository INSTANCE = null;
    private ApiCall apiCall;

    public DataRepository(ApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public static DataRepository getInstance(ApiCall apiCall){
        if(INSTANCE == null){
            synchronized (DataRepository.class){
                if (INSTANCE == null){
                    INSTANCE = new DataRepository(apiCall);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<ProductResponse>> getAllProducts() {
        return apiCall.getAllProduct();
    }
}
