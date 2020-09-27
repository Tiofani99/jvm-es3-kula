package com.magang.jvm_es3_kula.ui.listproduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.ui.category.KategoriFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListProductActivity extends AppCompatActivity {

    public static final String EXTRA_ID_CATEGORY = "extra_id";

    @BindView(R.id.smart_tab_layout)
    SmartTabLayout smartTabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        ButterKnife.bind(this);

        int id = getIntent().getIntExtra(EXTRA_ID_CATEGORY, 0);
        Log.d("Coba","ID Kategori "+id);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.app_name, KategoriFragment.class)
                .add(R.string.app_name, KategoriFragment.class)
                .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

        if(getSupportActionBar() != null){
            getSupportActionBar().setElevation(0);
        }


    }
}