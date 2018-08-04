package com.example.siddharth.tarun_teacher;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * created by AYUSH on __Date__
 * use this class to reduce time on setting up regular viewpager
 * just place the xml element in xml file and find view by id in java and call method @link addAdapter
 */

public class ViewPagerX extends ViewPager {
  static int resid[];
  Context context;

    public ViewPagerX(@NonNull Context context, int resid[]) {
        super(context);
    }

    public ViewPagerX(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param resid this is integer array that contains resId of layout to be inflate
     * @param manager pass this getSupportFragmentManager() from calling AppCompact activity
     */
    void addAdapter(final int resid[], FragmentManager manager){
        this.resid=resid;
        FragmentPagerAdapter adapter=new FragmentPagerAdapter(manager) {

            @Override
            public Fragment getItem(int position) {
                return frag.newInstance(position);
            }

            @Override
            public int getCount() {
                return resid.length;
            }
        };
        setAdapter(adapter);
    }

    public static class frag extends Fragment {
       public frag(){}
       public static Fragment newInstance(int sectionNumber) {
            frag fragment = new frag();
            Bundle args = new Bundle();
            args.putInt("pos", sectionNumber);
            fragment.setArguments(args);
            return fragment;
       }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(resid[getArguments().getInt("pos")], container, false);
        }

    }
}
