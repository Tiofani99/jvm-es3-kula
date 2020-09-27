package com.magang.jvm_es3_kula.data.rest.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductResponse implements Parcelable {

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


    protected ProductResponse(Parcel in) {
        id = in.readInt();
        categoryId = in.readInt();
        productName = in.readString();
        productDesc = in.readString();
        if (in.readByte() == 0) {
            productPrice = null;
        } else {
            productPrice = in.readLong();
        }
        productStock = in.readInt();
        productImage = in.readString();
        list = in.createTypedArrayList(ProductResponse.CREATOR);
    }

    public static final Creator<ProductResponse> CREATOR = new Creator<ProductResponse>() {
        @Override
        public ProductResponse createFromParcel(Parcel in) {
            return new ProductResponse(in);
        }

        @Override
        public ProductResponse[] newArray(int size) {
            return new ProductResponse[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(categoryId);
        parcel.writeString(productName);
        parcel.writeString(productDesc);
        if (productPrice == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(productPrice);
        }
        parcel.writeInt(productStock);
        parcel.writeString(productImage);
        parcel.writeTypedList(list);
    }
}
