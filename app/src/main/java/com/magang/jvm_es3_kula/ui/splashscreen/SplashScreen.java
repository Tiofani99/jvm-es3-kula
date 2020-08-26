package com.magang.jvm_es3_kula.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.magang.jvm_es3_kula.R;
import com.magang.jvm_es3_kula.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_title_splash)
    TextView tvTitleSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setSplash();


    }

    private void setSplash(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        ivLogo.startAnimation(animation);
        tvTitleSplash.startAnimation(animation);

        Thread thread = new Thread(){
            public void run (){
                try{
                    //1000=1 detik
                    sleep(3000);
                }catch (InterruptedException ignored) {
                }finally {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}