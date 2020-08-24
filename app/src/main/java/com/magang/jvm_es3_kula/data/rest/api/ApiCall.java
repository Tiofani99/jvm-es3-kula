package com.magang.jvm_es3_kula.data.rest.api;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.test.espresso.IdlingResource;

import com.magang.jvm_es3_kula.data.rest.response.CategoryResponse;
import com.magang.jvm_es3_kula.data.rest.response.ProductResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCall {
    private static ApiCall INSTANCE;
    private static ApiInterface apiClient= ApiClient.getClient().create(ApiInterface.class);
    private static final String TAG = ApiCall.class.getSimpleName();

    private Context context;

    public ApiCall(Context context) {
        this.context = context;
    }

    public static ApiCall getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ApiCall(context);
        }

        return INSTANCE;
    }

    public LiveData<List<ProductResponse>> getAllProduct(){
        MutableLiveData<List<ProductResponse>> listProducts = new MutableLiveData<>();
        Call<ProductResponse> productCall = apiClient.getAllProduct();
        productCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.body()!=null){
                    listProducts.postValue(response.body().getList());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Log.d(TAG,"data kosong");
            }
        });

        return listProducts;
    }

    public LiveData<List<CategoryResponse>> getAllCategory(){
        MutableLiveData<List<CategoryResponse>> listCategory = new MutableLiveData<>();
        Call<CategoryResponse> productCall = apiClient.getAllCategory();
        productCall.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if(response.body()!=null){
                    listCategory.postValue(response.body().getList());
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Log.d(TAG,"data kosong");
            }
        });

        return listCategory;
    }
}
