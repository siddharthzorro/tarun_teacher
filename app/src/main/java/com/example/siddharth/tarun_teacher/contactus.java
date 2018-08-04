package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class contactus extends AppCompatActivity {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("you cant get it", "onResume() returned: " + "its done by ");
    }
}
