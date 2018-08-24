package com.example.siddharth.tarun_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.Objects;

import github.chenupt.springindicator.SpringIndicator;

public class promote extends AppCompatActivity {
    ViewPager x;
    String TAG = "promote";
    FirebaseDatabase firebaseDatabase;
    DatabaseReference promotedisplay;
    DatabaseReference postpromotiion;
    DatabaseReference userdata;
    DatabaseReference promote;


    Integer radius=2;
    Integer duration=3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prmt_pager);
        final Bundle bundle=getIntent().getExtras();
        String userid;
        userid=bundle.get("userid").toString();
        firebaseDatabase=FirebaseDatabase.getInstance();
        userdata = firebaseDatabase.getReference("users").child(userid);
        promote = userdata.child("institute");


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        int ar[]={R.layout.promote, R.layout.promote11, R.layout.promote12};
        x = findViewById(R.id.vp_prmt);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(promote.this,MainActivity.class));
//            }
//        });
        x.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                View left = findViewById(R.id.prmt_leftarrow);
                View right = findViewById(R.id.prmt_right_arrow);
                View pay = findViewById(R.id.prmt_pay);
                View centerArrow = findViewById(R.id.prmt_center_arrow);

                switch (position) {
                    case 0:
                        Log.d(TAG, "onPageSelected: " + position);
                        left.setVisibility(View.INVISIBLE);
                        right.setVisibility(View.INVISIBLE);
                        pay.setVisibility(View.INVISIBLE);
                        centerArrow.setVisibility(View.VISIBLE);
                        DiscreteSeekBar discreteSeekBa1=findViewById(R.id.radius_seekbar);
                        DiscreteSeekBar discreteSeekBar2= findViewById(R.id.duration_seekbar);
                        discreteSeekBa1.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
                            @Override
                            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                            }

                            @Override
                            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

                            }

                            @Override
                            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
                                radius =seekBar.getProgress();


                            }
                        });
                        discreteSeekBar2.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
                            @Override
                            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {

                            }

                            @Override
                            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

                            }

                            @Override
                            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
                                duration= seekBar.getProgress();
                            }
                        });
                        break;
                    case 1:


                        Log.d(TAG, "onPageSelected: " + position);
                        left.setVisibility(View.VISIBLE);
                        right.setVisibility(View.VISIBLE);
                        pay.setVisibility(View.INVISIBLE);
                        centerArrow.setVisibility(View.INVISIBLE);
                        final Switch myswitch6 = findViewById(R.id.switch5);

                        final Switch myswitch5 = findViewById(R.id.switch6);
                        myswitch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(isChecked){
                                    myswitch6.setChecked(false);
                                }
                                // true if the switch is in the On position
                            }
                        });
                        myswitch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(isChecked){
                                    myswitch5.setChecked(false);
                                }
                                // true if the switch is in the On position
                            }
                        });
                        RecyclerViewX viewX=findViewById(R.id.rvx_post_promotion);
                        viewX.addAdapter(5,R.layout.post_promotion_holder,promote.this, LinearLayoutManager.HORIZONTAL);
                        break;


                    case 2:

                        Log.d(TAG, "onPageSelected: " + position);
                        left.setVisibility(View.INVISIBLE);
                        right.setVisibility(View.INVISIBLE);
                        pay.setVisibility(View.VISIBLE);
                        final TextView textView_radius=findViewById(R.id.tv_radius);
                        final TextView textView_duration=findViewById(R.id.tv_duration);
                        textView_radius.setText(String.valueOf(radius));
                        textView_duration.setText(String.valueOf(duration));
                        centerArrow.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        Log.d(TAG, "onPageSelected: " + position);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        x.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new page1();
                    case 1:
                        return new page2();
                    case 2:
                        return new page3();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        SpringIndicator springIndicator=findViewById(R.id.indicator);
        springIndicator.setViewPager(x);
    }

    public  void addPostPromotion(View view){
        RecyclerViewX viewX=findViewById(R.id.rvx_post_promotion);
        viewX.addAdapter(viewX.getAdapter().getItemCount()+1,R.layout.post_promotion_holder,promote.this, LinearLayoutManager.HORIZONTAL);
    }
    public void goleft(View view) {
        if (x.getCurrentItem() != 0) {
            x.setCurrentItem(0);
        }
    }

    public void goright(View view) {
        x.setCurrentItem(x.getCurrentItem() + 1);
    }

    public static class page1 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.promote, container, false);
        }
    }

    public static class page2 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.promote11, container, false);
        }
    }

    public static class page3 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.promote12, container, false);
        }
    }

   Displaystructure d;

    void loaddata() {
        userdata.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d.promotedisplay.radius = Integer.valueOf(dataSnapshot.child("institute").child("promote").child("postpromotion1").child("radius").getValue().toString());
                d.promotedisplay.duration = Integer.valueOf(dataSnapshot.child("institute").child("promote").child("postpromotion1").child("duration").getValue().toString());
                d.promotedisplay.area = dataSnapshot.child("institute").child("promote").child("postpromotion1").child("area").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
        void loaddatainpromote()
        {
            TextView duration= findViewById(R.id.tv_duration);
            duration.setText(d.promotedisplay.duration);
            TextView radius=findViewById(R.id.tv_website);
            radius.setText(d.promotedisplay.radius);
        }

}
