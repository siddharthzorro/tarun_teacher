package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class Reviews_full extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_reviews);
        RecyclerViewX viewX=findViewById(R.id.recyclerViewX);

        viewX.addAdapter(5,R.layout.review_holder,this);
    }

}
