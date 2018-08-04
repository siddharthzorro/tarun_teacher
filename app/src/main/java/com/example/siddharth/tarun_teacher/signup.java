package com.example.siddharth.tarun_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class signup extends AppCompatActivity {
    View signuplay;
    View ekyclay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_main);
        ekyclay=findViewById(R.id.ekycid);
        ekyclay.setVisibility(View.INVISIBLE);
    }



    public void opensignup(View view) {
        signuplay = findViewById(R.id.signupid);
        ekyclay=findViewById(R.id.ekycid);

        signuplay.setVisibility(View.VISIBLE);
        ekyclay.setVisibility(View.INVISIBLE);

    }

    public void ekyc(View view) {
        ekyclay=findViewById(R.id.ekycid);
        signuplay = findViewById(R.id.signupid);

        ekyclay.setVisibility(View.VISIBLE);
        signuplay.setVisibility((View.INVISIBLE));


    }

    public void mainpage(View view) {

        startActivity(new Intent(this,MainActivity.class));
    }
}
