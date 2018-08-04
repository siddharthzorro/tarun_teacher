package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;

public class swipe extends AppCompatActivity {
    SwipeLayout sample3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_layout);
        sample3 = (SwipeLayout) findViewById(R.id.sample3);
        //given id here in second parameter is id of view you want to show when reveling not by default
        //everything else is visible by itself
        sample3.addDrag(SwipeLayout.DragEdge.Bottom, sample3.findViewWithTag("Bottom3"));
        sample3.addRevealListener(R.id.tv2, new SwipeLayout.OnRevealListener() {
            @Override
            public void onReveal(View child, SwipeLayout.DragEdge edge, float fraction, int distance) {
                ConstraintLayout layout = findViewById(R.id.cl);
                if (fraction == 1) {
                    layout.bringChildToFront(findViewById(R.id.sample3));
                }
                if (fraction < 1) {
                    layout.bringChildToFront(findViewById(R.id.textView19));
                }
            }
        });

    }

    public void toast(View view) {
        Toast.makeText(this, "asd", Toast.LENGTH_SHORT).show();
    }
}
