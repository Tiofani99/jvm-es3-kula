package com.magang.jvm_es3_kula.data.rest.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoryResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("category_name")
    private String categoryName;

    @SerializedName("category_image")
    private String categoryImage;

    @SerializedName("data")
    private ArrayList<CategoryResponse> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public ArrayList<CategoryResponse> getList() {
        return list;
    }

    public void setList(ArrayList<CategoryResponse> list) {
        this.list = list;
    }
}
