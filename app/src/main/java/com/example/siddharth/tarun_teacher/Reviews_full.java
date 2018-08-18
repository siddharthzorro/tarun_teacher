package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;

public class Reviews_full extends AppCompatActivity {

    Integer totalReviewCounter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_reviews);
        //RecyclerViewX viewX=findViewById(R.id.recyclerViewX);


        totalReviewCounter=5;
        //viewX.addAdapter(5,R.layout.review_holder,this);

        RecyclerView recyclerView= findViewById(R.id.recyclerViewX);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(new ReviewAdapter());

    }



    class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder>{



        public class ReviewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            ExpandableLayout expandableLayout;

            public ReviewHolder(View itemView) {
                super(itemView);
                expandableLayout = findViewById(R.id.expandableLayout);
                textView=itemView.findViewById(R.id.unexpanded_text_review);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        expandableLayout.toggle();
                    }
                });
            }

        }

        @NonNull
        @Override
        public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(Reviews_full.this).inflate(R.layout.review_holder,parent,false);
            return new ReviewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ReviewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return totalReviewCounter;
        }
    }


}
