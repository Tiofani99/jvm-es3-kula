package com.magang.jvm_es3_kula.ui.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.magang.jvm_es3_kula.BuildConfig;
import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.data.rest.response.ProductResponse;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PRODUCT = "extra product";

    @BindView(R.id.iv_poster_detail)
    ImageView ivPhotoDetail;
    @BindView(R.id.tv_detail_nama)
    TextView tvNameDetail;
    @BindView(R.id.tv_detail_harga)
    TextView tvDetailCost;
    @BindView(R.id.tv_story_detail)
    TextView tvDesc;
    @BindView(R.id.tv_title)
    TextView tvTitleCollapse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setData();


    }

    private void initTitle(String title){
        if (getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
        }
    }

    private void setData(){
        ProductResponse productResponse = getIntent().getParcelableExtra(EXTRA_PRODUCT);
        assert productResponse != null;
        initTitle(productResponse.getProductName());
        tvNameDetail.setText(productResponse.getProductName());
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        tvDetailCost.setText(formatRupiah.format(Double.parseDouble(String.valueOf(productResponse.getProductPrice()))));
        tvDesc.setText(productResponse.getProductDesc());
        Glide.with(this)
                .load(BuildConfig.LINK_PRODUCT_IMAGE+productResponse.getProductImage())
                .into(ivPhotoDetail);
        setCollapsing(productResponse.getProductName());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setCollapsing(final String title) {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        tvTitleCollapse.setText(" ");
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {

            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + i == 0) {
                    collapsingToolbarLayout.setTitle(title);
                    tvTitleCollapse.setText(title);

                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    tvTitleCollapse.setText(" ");
                    isShow = false;
                }
            }
        });
    }
}