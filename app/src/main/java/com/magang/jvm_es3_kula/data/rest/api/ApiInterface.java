package com.magang.jvm_es3_kula.data.rest.api;

import com.magang.jvm_es3_kula.data.rest.response.CategoryResponse;
import com.magang.jvm_es3_kula.data.rest.response.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/product")
    Call<ProductResponse> getAllProduct();

    @GET("api/category")
    Call<CategoryResponse> getAllCategory();


}
