package com.example.siddharth.tarun_teacher;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Ayush on __Date__
 * advance version of Regular Recycler view doing all the setup
 * call method @Link addAdapter to complete setup
 */
public class RecyclerViewX extends RecyclerView {

    public RecyclerViewX(Context context) {
        super(context);
    }

    public RecyclerViewX(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerViewX(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     *
     * @param count total no of holder to be displayed
     * @param vhResId layout resource id of view Holder
     * @param context pass this pointer from calling class
     */
    public void addAdapter(final int count, final int vhResId, final Context context){
        Adapter adapter= new Adapter() {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(context).inflate(vhResId,parent,false)) {
                    @Override
                    public String toString() {
                        return super.toString();
                    }
                };
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return count;
            }
        } ;
        setLayoutManager(new LinearLayoutManager(context));
        setAdapter(adapter);
    }
    public void addAdapter(final int count, final int vhResId, final Context context,int orientation){
        Adapter adapter= new Adapter() {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(context).inflate(vhResId,parent,false)) {
                    @Override
                    public String toString() {
                        return super.toString();
                    }
                };
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return count;
            }
        } ;
        setLayoutManager(new LinearLayoutManager(context,orientation,true));
        setAdapter(adapter);
    }
}
