package com.example.siddharth.tarun_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import github.chenupt.springindicator.SpringIndicator;

public class intro extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        SpringIndicator springIndicator=findViewById(R.id.indicator);
        ViewPagerX viewPager=findViewById(R.id.vpx);
        int arr[]={R.layout.step1, R.layout.step3, R.layout.step3,R.layout.step4};
        viewPager.addAdapter(arr,getSupportFragmentManager());
        springIndicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void openSignupform(View view){
        startActivity(new Intent(this,signup.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }
}
