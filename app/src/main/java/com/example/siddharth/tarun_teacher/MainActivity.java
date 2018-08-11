package com.example.siddharth.tarun_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.daimajia.swipe.SwipeLayout;
import com.eightbitlab.bottomnavigationbar.BottomBarItem;
import com.eightbitlab.bottomnavigationbar.BottomNavigationBar;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mancj.materialsearchbar.MaterialSearchBar;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import java.net.URL;
import java.util.Objects;

import me.drakeet.materialdialog.MaterialDialog;

public class MainActivity extends AppCompatActivity {
    LayoutInflater inflater; //recycler view booking
    Integer countOfName = 0;
    RecyclerView recyclerVie;
    Boolean donecounter = false;
    DatabaseReference building;
    DatabaseReference userdata;

    // BottomSheetBehavior variable
    private BottomSheetBehavior bottomSheetBehavior;

    // TextView variable
    private TextView bottomSheetHeading;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viepager);

        Bundle data = getIntent().getExtras();

        String userid = data.getString("userid", "user1");
        final ViewPager viewPager = findViewById(R.id.vp);


        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        userdata = firebaseDatabase.getReference("users").child(userid);
        building = userdata.child("institute").child("building");
        DatabaseReference review = userdata.child("institute").child("review");

//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bnve);
//        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
//        for (int i = 0; i < menuView.getChildCount(); i++) {
//            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
//            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
//            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
//            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
//            iconView.setLayoutParams(layoutParams);
//        }



        // loadData();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                switch (i) {
                    default:
                        Log.d("vp", "onPageSelected: i");
                        break;
                    case 0:

                        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                        setSupportActionBar(toolbar);
//                        final ConstraintLayout layout = findViewById(R.id.cl);
//                        layout.bringChildToFront(findViewById(R.id.sc1));
//                        SwipeLayout sample3 = (SwipeLayout) findViewById(R.id.sample3);
//                        //given id here in second parameter is id of view you want to show when reveling not by default
//                        //everything else is visible by itself
//                        sample3.addDrag(SwipeLayout.DragEdge.Right, sample3.findViewWithTag("Bottom2"));
//
//                        sample3.addDrag(SwipeLayout.DragEdge.Bottom, sample3.findViewWithTag("Bottom3"));
//                        sample3.addRevealListener(R.id.llsv_d, new SwipeLayout.OnRevealListener() {
//                            @Override
//                            public void onReveal(View child, SwipeLayout.DragEdge edge, float fraction, int distance) {
//                                layout.bringChildToFront(findViewById(R.id.sample3));
//
//                                if (fraction == 1)
//                                    layout.bringChildToFront(findViewById(R.id.sample3));
//                                else
//                                    layout.bringChildToFront(findViewById(R.id.sc1));
//
//                            }
//                        });

                        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));
                        bottomSheetHeading = (TextView) findViewById(R.id.bottomSheetHeading);
                        final Float rating = 2.5f;
                        final RatingBar rate_bar = findViewById(R.id.rating_homepage);
                        rate_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                                rate_bar.setRating(rating);
                            }
                        });
                        rate_bar.setRating(rating);
//                        final BottomNavigationView navigationView = findViewById(R.id.bnve);
//
//                        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                            @Override
//                            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                                View layout1 = findViewById(R.id.tab1);
//                                View layout2 = findViewById(R.id.tab2);
//                                View layout3 = findViewById(R.id.tab3);
//                                Menu menu2 = navigationView.getMenu();
//                                MenuItem item11 = menu2.getItem(0);
//                                MenuItem item12 = menu2.getItem(1);
//                                MenuItem item13 = menu2.getItem(2);
//
//                                switch (menuItem.getItemId()) {
//                                    case R.id.menuprofile:
//
//                                        layout1.setVisibility(View.VISIBLE);
//                                        layout2.setVisibility(View.GONE);
//                                        layout3.setVisibility(View.GONE);
//                                        item11.setIcon(R.drawable.profileownerfilled);
//                                        item12.setIcon(R.mipmap.ic_launcher_foreground_institute_new);
//                                        item13.setIcon(R.mipmap.ic_launcher_foreground_info_newz);
//                                        return true;
//                                    case R.id.menubuild:
//                                        Log.d("mn", "onNavigationItemSelected: 2");
//                                        layout1.setVisibility(View.GONE);
//                                        layout2.setVisibility(View.VISIBLE);
//                                        layout3.setVisibility(View.GONE);
//                                        item12.setIcon(R.drawable.institutefilled);
//                                        item11.setIcon(R.drawable.icon_selector_home1);
//                                        item13.setIcon(R.mipmap.ic_launcher_foreground_info_newz);
//
//                                        final Switch myswitch2 = findViewById(R.id.building_switch_direct);
//
//                                        final Switch myswitch1 = findViewById(R.id.building_switch_entrance_based);
//                                        myswitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                                                if (isChecked) {
//                                                    myswitch2.setChecked(false);
//                                                }
//                                                // true if the switch is in the On position
//                                            }
//                                        });
//                                        myswitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                                                if (isChecked) {
//                                                    myswitch1.setChecked(false);
//                                                }
//                                                // true if the switch is in the On position
//                                            }
//                                        });
//                                        final Switch myswitch4 = findViewById(R.id.building_switch_hom_tuition);
//
//                                        final Switch myswitch3 = findViewById(R.id.building_switch_grp_tuition);
//                                        myswitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                                                if (isChecked) {
//                                                    myswitch4.setChecked(false);
//                                                }
//                                                // true if the switch is in the On position
//                                            }
//                                        });
//                                        myswitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                                                if (isChecked) {
//                                                    myswitch3.setChecked(false);
//                                                }
//                                                // true if the switch is in the On position
//                                            }
//                                        });
//                                        return true;
//                                    case R.id.menuinfo:
//
//                                        layout1.setVisibility(View.GONE);
//                                        layout2.setVisibility(View.GONE);
//                                        layout3.setVisibility(View.VISIBLE);
//                                        item13.setIcon(R.drawable.infofilled);
//                                        item11.setIcon(R.drawable.icon_selector_home1);
//                                        item12.setIcon(R.mipmap.ic_launcher_foreground_institute_new);
//
//                                        return true;
//                                }
//                                return true;
//                            }
//                        });
//                        donecounter = true;


//                        recyclerVie = findViewById(R.id.rv);
//                        recyclerVie.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                        recyclerVie.setAdapter(new RecyclerView.Adapter() {
//                            @NonNull
//                            @Override
//                            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                                return new RecyclerView.ViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.homepage_holder, parent, false)) {
//                                    @Override
//                                    public String toString() {
//                                        return super.toString();
//                                    }
//                                };
//                            }
//
//                            @Override
//                            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//                            }
//
//                            @Override
//                            public int getItemCount() {
//                                return countOfName;
//                            }
//                        });

                        break;
                    case 1:

                        MaterialSearchBar materialSearchBar = findViewById(R.id.searchBar);
                        materialSearchBar.inflateMenu(R.menu.bottombar_menu_4items);

                        RecyclerView recyclerView = findViewById(R.id.linearLayout);
                        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                        inflater = LayoutInflater.from(MainActivity.this);

                        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
                            @NonNull
                            @Override
                            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                                View view;
                                view = inflater.inflate(R.layout.booking_holder, viewGroup, false);
//                                RippleView rippleView;
//                                rippleView = findViewById(R.id.rplview);
//                                rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
//
//                                    @Override
//                                    public void onComplete(RippleView rippleView) {
//                                        Log.d("Sample", "Ripple completed");
//                                    }
//
//                                });
                                final RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view) {
                                    @Override
                                    public String toString() {
                                        return super.toString();
                                    }
                                };
                                return viewHolder;
                            }

                            @Override
                            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//                                RippleView rippleView;
//                                rippleView = findViewById(R.id.rplview);
//                                rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
//
//                                    @Override
//                                    public void onComplete(RippleView rippleView) {
//                                        Log.d("Sample", "Ripple completed");
//                                    }
//
//                                });
                            }

                            @Override
                            public int getItemCount() {
                                return 5;
                            }
                        };
                        recyclerView.setLayoutManager(manager);
                        recyclerView.setAdapter(adapter);


                        break;
                    case 2:

                        ValueLineChart mCubicValueLineChart = (ValueLineChart) findViewById(R.id.cubiclinechart);

                        ValueLineSeries series = new ValueLineSeries();
                        series.setColor(0xFF54876c);

                        series.addPoint(new ValueLinePoint("Jan", 2.4f));
                        series.addPoint(new ValueLinePoint("Feb", 3.4f));
                        series.addPoint(new ValueLinePoint("Mar", .4f));
                        series.addPoint(new ValueLinePoint("Apr", 1.2f));
                        series.addPoint(new ValueLinePoint("May", 2.6f));
                        series.addPoint(new ValueLinePoint("Jun", 1.0f));
                        series.addPoint(new ValueLinePoint("Jul", 3.5f));
                        series.addPoint(new ValueLinePoint("Aug", 2.4f));
                        series.addPoint(new ValueLinePoint("Sep", 2.4f));
                        series.addPoint(new ValueLinePoint("Oct", 3.4f));
                        series.addPoint(new ValueLinePoint("Nov", .4f));
                        series.addPoint(new ValueLinePoint("Dec", 1.3f));


                        mCubicValueLineChart.addSeries(series);
                        mCubicValueLineChart.startAnimation();

                        ValueLineChart mCubicValueLineChart2 = (ValueLineChart) findViewById(R.id.cubiclinechart2);
                        ValueLineSeries series2 = new ValueLineSeries();
                        series2.setColor(0xFF56B7F1);

                        series2.addPoint(new ValueLinePoint("d", 2.4f));
                        series2.addPoint(new ValueLinePoint("M", 3.4f));
                        series2.addPoint(new ValueLinePoint("T", .4f));
                        series2.addPoint(new ValueLinePoint("W", 1.2f));
                        series2.addPoint(new ValueLinePoint("T", 2.6f));
                        series2.addPoint(new ValueLinePoint("F", 1.0f));
                        series2.addPoint(new ValueLinePoint("S", 3.5f));
                        series2.addPoint(new ValueLinePoint("S", .4f));
                        series2.addPoint(new ValueLinePoint("Dec", 1.3f));

                        mCubicValueLineChart2.addSeries(series2);
                        mCubicValueLineChart2.startAnimation();

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.setAdapter(new vpAdapte(getSupportFragmentManager()));

        BottomBarItem item1 = new BottomBarItem(R.mipmap.accountsetting_foreground);
        BottomBarItem item2 = new BottomBarItem(R.mipmap.bookingandchat_foreground);
        BottomBarItem item3 = new BottomBarItem(R.mipmap.insight_foreground);

        BottomNavigationBar bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.addTab(item1);
        bottomBar.addTab(item2);
        bottomBar.addTab(item3);

        bottomBar.setOnSelectListener(new BottomNavigationBar.OnSelectListener() {
            @Override
            public void onSelect(int position) {
                viewPager.setCurrentItem(position);
            }
        });
        Runnable dirtyHack = new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(1);
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(dirtyHack, 100);

    }

    Displaystructure d;

    void loadData() {
        userdata.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                d.tv_ins_name = Objects.requireNonNull(dataSnapshot.child("building").child("institutename").getValue()).toString();
                d.tv_owner_1 = dataSnapshot.child("building").child("ownername").getValue().toString();
                d.tv_owner_2 = dataSnapshot.child("building").child("ownername").getValue().toString();
                d.ratingbar_homepage = Integer.valueOf(dataSnapshot.child("building").child("rating").getValue().toString());
                d.r1.ins_name = dataSnapshot.child("liveranks").child("rank1").getValue().toString();
                d.r2.ins_name = dataSnapshot.child("liveranks").child("rank2").getValue().toString();
                d.r1.rating = Integer.valueOf(dataSnapshot.child("liveranks").child("rank1").getValue().toString());
                d.r2.rating = Integer.valueOf(dataSnapshot.child("liveranks").child("rank2").getValue().toString());
                d.r1.position = Integer.valueOf(dataSnapshot.child("liveranks").child("rank1").getValue().toString());
                d.r2.position = Integer.valueOf(dataSnapshot.child("liveranks").child("rank2").getValue().toString());
                d.graphdata.v1 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("jan").getValue().toString());
                d.graphdata.v2 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("feb").getValue().toString());
                d.graphdata.v3 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("mar").getValue().toString());
                d.graphdata.v4 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("apr").getValue().toString());
                d.graphdata.v5 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("may").getValue().toString());
                d.graphdata.v6 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("jun").getValue().toString());
                d.graphdata.v7 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("jul").getValue().toString());
                d.graphdata.v8 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("aug").getValue().toString());
                d.graphdata.v9 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("sep").getValue().toString());
                d.graphdata.v10 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("oct").getValue().toString());
                d.graphdata.v11 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("nov").getValue().toString());
                d.graphdata.v12 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("monthlyoverview").child("dec").getValue().toString());

                d.graphdata.w1 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("interaction").child("mon").getValue().toString());
                d.graphdata.w2 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("interaction").child("tue").getValue().toString());
                d.graphdata.w3 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("interaction").child("wed").getValue().toString());
                d.graphdata.w4 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("interaction").child("thu").getValue().toString());
                d.graphdata.w5 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("interaction").child("fri").getValue().toString());
                d.graphdata.w6 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("interaction").child("sat").getValue().toString());
                d.graphdata.w7 = Integer.valueOf(dataSnapshot.child("institute").child("graph").child("interaction").child("sun").getValue().toString());

                d.review1.name = dataSnapshot.child("institute").child("review").child("review1").child("name").getValue().toString();
                d.review1.comment = dataSnapshot.child("institute").child("review").child("review1").child("comment").getValue().toString();
                d.review1.subject = dataSnapshot.child("institute").child("review").child("review1").child("subject").getValue().toString();
                d.review1.ratebar = Integer.valueOf(dataSnapshot.child("institute").child("review").child("review1").child("comment").getValue().toString());

                d.review2.name = dataSnapshot.child("institute").child("review").child("review2").child("name").getValue().toString();
                d.review2.comment = dataSnapshot.child("institute").child("review").child("review2").child("comment").getValue().toString();
                d.review2.subject = dataSnapshot.child("institute").child("review").child("review2").child("subject").getValue().toString();
                d.review2.ratebar = Integer.valueOf(dataSnapshot.child("institute").child("review").child("review2").child("comment").getValue().toString());

                d.building.ins_name = dataSnapshot.child("institute").child("building").child("institutename").getValue().toString();
                d.building.about = dataSnapshot.child("institute").child("building").child("about").getValue().toString();
                d.building.office_num = dataSnapshot.child("institute").child("building").child("officenumber").getValue().toString();
                //  d.building.website=dataSnapshot.child("institute").child("building").child("website").getValue().toString();

                //todo add arraylist subjects and class subjects

//                d.infoabout.url1=dataSnapshot.child("devinfo").child("about").child("link1").getValue().toString();
//                d.infoabout.url1=dataSnapshot.child("devinfo").child("about").child("link2").getValue().toString();
//                d.infoabout.url1=dataSnapshot.child("devinfo").child("about").child("link3").getValue().toString();
//                d.infoabout.url1=dataSnapshot.child("devinfo").child("about").child("link4").getValue().toString();

//            d.infofeedback.u1=dataSnapshot.child("devinfo").child("feedback").child("link1").getValue().toString();
//                d.infofeedback.u2=dataSnapshot.child("devinfo").child("feedback").child("link2").getValue().toString();
//                d.infofeedback.u3=dataSnapshot.child("devinfo").child("feedback").child("link3").getValue().toString();
//                d.infofeedback.u4=dataSnapshot.child("devinfo").child("feedback").child("link4").getValue().toString();

//               d.inforateus.u=dataSnapshot.child("devinfo").child("rateus").child("link1").getValue().toString();
                d.inforateus.num_stars = Integer.valueOf(dataSnapshot.child("devinfo").child("rateus").child("stars").getValue().toString());

                d.infocontact1.location = dataSnapshot.child("devinfo").child("contactus").child("state1").getValue().toString();
                d.infocontact2.location = dataSnapshot.child("devinfo").child("contactus").child("state2").getValue().toString();
                d.infocontact3.location = dataSnapshot.child("devinfo").child("contactus").child("state3").getValue().toString();
                d.infocontact4.location = dataSnapshot.child("devinfo").child("contactus").child("state4").getValue().toString();
                d.infocontact1.phnum = dataSnapshot.child("devinfo").child("contactus").child("phone1").getValue().toString();
                d.infocontact2.phnum = dataSnapshot.child("devinfo").child("contactus").child("phone2").getValue().toString();
                d.infocontact3.phnum = dataSnapshot.child("devinfo").child("contactus").child("phone3").getValue().toString();
                d.infocontact4.phnum = dataSnapshot.child("devinfo").child("contactus").child("phone4").getValue().toString();

                d.promotedisplay.area = dataSnapshot.child("institute").child("promote").child("promotepage1").child("area").getValue().toString();
                d.promotedisplay.radius = Integer.valueOf(dataSnapshot.child("institute").child("promote").child("promotepage1").child("radius").getValue().toString());
                d.promotedisplay.duration = Integer.valueOf(dataSnapshot.child("institute").child("promote").child("promotepage1").child("duration").getValue().toString());

//todo postpromotion
//todo notification


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        userdata.child("institute").child("promote").child("promotepage2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postPromotionModel : dataSnapshot.getChildren()) {

                    d.promotedisplay.pstprom.add(new Postpromotion(
                                    postPromotionModel.child("link").getValue().toString(),
                                    postPromotionModel.child("description").getValue().toString(),
                                    postPromotionModel.child("photo").getValue().toString()
                            )
                    );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        userdata.child("institute").child("building").child("subjects").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot subjects : dataSnapshot.getChildren()) {
                    d.subjectArrayList.add(new Subject(subjects.getKey(), subjects.getValue().toString()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void expandable(View view) {
        ExpandableRelativeLayout expandableLayout = findViewById(R.id.expandableLayout);
        expandableLayout.toggle();
    }

    public void expandable_two(View view) {
        ExpandableRelativeLayout expandableLayout2 = findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle();
    }

    public void addother(View view) {
        countOfName++;
        recyclerVie.getAdapter().notifyDataSetChanged();
    }

    public void openpromote(View view) {
        startActivity(new Intent(this, promote.class));
    }

    public void openabout(View view) {


        View view1 = LayoutInflater.from(this).inflate(R.layout.about, null, false);

        final MaterialDialog mMaterialDialog = new MaterialDialog(this).setView(view1);

        mMaterialDialog.setNegativeButton("cancel", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMaterialDialog.dismiss();
            }
        });
        mMaterialDialog.show();

        // startActivity(new Intent(this, about.class));
    }

    public void opencontactus(View view) {
        Log.d("in", "opencontactus: in");
        startActivity(new Intent(MainActivity.this, contactus.class));
        Log.d("in", "opencontactus: out");
    }

    public void openfeedback(View view) {
        startActivity(new Intent(this, feedback.class));
    }

    public void openrateus(View view) {
        startActivity(new Intent(this, rateus.class));
    }

    public void whatdoesoverview(View view) {
        Toast.makeText(this, "shwhsdvwvdvd", Toast.LENGTH_SHORT).show();
    }

    public void whatdoesinteraction(View view) {
        Toast.makeText(this, "dshdvgsd dsgsvd", Toast.LENGTH_SHORT).show();
    }

    public void clickit(View view) {
        TextView clickz = findViewById(R.id.textView3);
        if (clickz.getVisibility() == clickz.VISIBLE) {
            clickz.setVisibility(View.INVISIBLE);
        } else if (clickz.getVisibility() == clickz.INVISIBLE) {
            clickz.setVisibility(View.VISIBLE);
            ScrollView scrollView = findViewById(R.id.scrollview_graph);
            scrollView.scrollTo(0, 1500);
        }

    }

    public void buildingSave(View view) {
        EditText et_institute = findViewById(R.id.buildind_et_ins_name);
        EditText et_about = findViewById(R.id.buildind_et_about);
        Spinner sp_subject1 = findViewById(R.id.buildind_sp_subject1);
        Spinner sp_subject2 = findViewById(R.id.buildind_sp_subject2);
        Spinner sp_subject3 = findViewById(R.id.buildind_sp_subject3);
        EditText et_teacher1 = findViewById(R.id.buildind_et_teacher1);
        EditText et_teacher2 = findViewById(R.id.buildind_et_teacher2);
        EditText et_teacher3 = findViewById(R.id.buildind_et_teacher3);
        Switch sw_grp_tuition = findViewById(R.id.building_switch_grp_tuition);
        Switch sw_hom_tuition = findViewById(R.id.building_switch_hom_tuition);
        Switch sw_entr_based = findViewById(R.id.building_switch_entrance_based);
        Switch sw_direct = findViewById(R.id.building_switch_direct);
        EditText et_address = findViewById(R.id.building_et_address);
        EditText et_office_num = findViewById(R.id.building_et_office_num);
        EditText et_website = findViewById(R.id.building_et_website);

        if (checkEdittext(et_institute) && checkEdittext(et_about) && checkEdittext(et_teacher1)
                && checkEdittext(et_teacher2) && checkEdittext(et_teacher3) && checkEdittext(et_address) && checkEdittext(et_office_num)
                && checkEdittext(et_website) && checkSwitch(sw_grp_tuition, sw_hom_tuition) && checkSwitch(sw_direct, sw_entr_based)) {
            building.child("institutename").setValue(et_institute.getText());
        }
    }

    boolean checkEdittext(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.setError("fill this");
            return false;
        } else
            return true;
    }

    boolean checkSwitch(Switch switch1, Switch switch2) {
        if (switch1.isChecked() == switch2.isChecked())
            return false;
        else return true;
    }

    public void openSeeMore(View view) {
        startActivity(new Intent(this, Reviews_full.class));
    }

    class vpAdapte extends FragmentPagerAdapter {
        vpAdapte(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                default:
                    return new homepage();
                case 0:
                    return new homepage();
                case 1:
                    return new settingpage();
                case 2:
                    return new graphpage();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public static class homepage extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.homepage, container, false);
        }
    }

    public static class settingpage extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.booking, container, false);
        }
    }

    public static class graphpage extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.graph_pre, container, false);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_booking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }
}