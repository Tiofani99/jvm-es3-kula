package com.magang.jvm_es3_kula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread = new Thread(){
            public void run (){
                try{
                    //1000=1 detik
                    sleep(3000);
                }catch (InterruptedException e) {
                }finally {
                    startActivity(new Intent(SplashScreen.this, HomeFragment.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}