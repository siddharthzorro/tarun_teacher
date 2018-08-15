package com.example.siddharth.tarun_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

//import com.example.siddharth.tarun_teacher.MainActivity.*;
import me.drakeet.materialdialog.MaterialDialog;

public class MenuHomepage extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
         int vlaur=(int) bundle.get("key");
         switch(vlaur){
             case 0: setContentView(R.layout.layout);
             break;
             case 1:setContentView(R.layout.tab2);
             break;
             case 2:setContentView(R.layout.tab3);
             break;
         }
    }



}
