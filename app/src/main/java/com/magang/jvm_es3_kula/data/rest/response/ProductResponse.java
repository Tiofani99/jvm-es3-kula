package com.magang.jvm_es3_kula.data.rest.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("category_id")
    private int categoryId;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("product_desc")
    private String productDesc;

    @SerializedName("product_price")
    private Long productPrice;

    @SerializedName("product_stock")
    private int productStock;

    @SerializedName("product_image")
    private String productImage;

    @SerializedName("data")
    private ArrayList<ProductResponse> list;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public ArrayList<ProductResponse> getList() {
        return list;
    }

    public void setList(ArrayList<ProductResponse> list) {
        this.list = list;
    }
}
