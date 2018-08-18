package com.example.siddharth.tarun_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import me.drakeet.materialdialog.MaterialDialog;

public class MainActivity extends AppCompatActivity {
    LayoutInflater inflater; //recycler view booking
    Integer countOfName = 0;
    RecyclerView recyclerVie;
    Boolean donecounter = false;
    DatabaseReference building;
    DatabaseReference userdata;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference devinfo;


    // BottomSheetBehavior variable
    private BottomSheetBehavior bottomSheetBehavior;

    // TextView variable
    private TextView bottomSheetHeading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viepager);

        Bundle data = getIntent().getExtras();

        d = new Displaystructure();

        String userid = data.getString("userid", "user1");
        userid = userid.replaceAll("[^a-zA-Z0-9]", "");

        //          String userid="user1";
          final ViewPager viewPager = findViewById(R.id.vp);


        firebaseDatabase = FirebaseDatabase.getInstance();
        devinfo = firebaseDatabase.getReference("devinfo");
        userdata = firebaseDatabase.getReference("users").child(userid);
        System.out.println(userdata);
        building = userdata.child("institute").child("building");
        DatabaseReference review = userdata.child("institute").child("review");


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
                        loaddatainhomepage();
                        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));
                        bottomSheetHeading =  findViewById(R.id.bottomSheetHeading);
                        final Float rating = 2.5f;
                        final RatingBar rate_bar = findViewById(R.id.rating_homepage);
                        rate_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                                rate_bar.setRating(rating);
                            }
                        });
                        rate_bar.setRating(rating);

                        break;
                    case 1: MaterialSearchBar materialSearchBar = findViewById(R.id.searchBar);
                       materialSearchBar.inflateMenu(R.menu.bottombar_menu_4items);

                        RecyclerView recyclerView = findViewById(R.id.linearLayout);
                        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                        inflater = LayoutInflater.from(MainActivity.this);

                        final Integer notificationCount=0;
                        if(notificationCount==0){
                            findViewById(R.id.tv_norevies).setVisibility(View.VISIBLE);
                        }
                        else
                            findViewById(R.id.tv_norevies).setVisibility(View.INVISIBLE);

                        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
                            @NonNull
                            @Override
                            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                                View view;
                                view = inflater.inflate(R.layout.booking_holder, viewGroup, false);
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
                                return notificationCount;
                            }
                        };
                        recyclerView.setLayoutManager(manager);
                        recyclerView.setAdapter(adapter);


                        break;
                    case 2:

                        ValueLineChart mCubicValueLineChart = (ValueLineChart) findViewById(R.id.cubiclinechart);

                        ValueLineSeries series = new ValueLineSeries();
                        series.setColor(0xFF008080);

                        HashMap<String,Float> monthGraph =new HashMap<>();
                        HashMap<String,Float> weekdayGraph;
                        weekdayGraph = new HashMap<>();
                        monthGraph.put("Jan",Float.valueOf(d.graphdata.v1));
                        monthGraph.put("Feb",Float.valueOf(d.graphdata.v2));
                        monthGraph.put("Mar",Float.valueOf(d.graphdata.v3));
                        monthGraph.put("Apr",Float.valueOf(d.graphdata.v4));
                        monthGraph.put("May",Float.valueOf(d.graphdata.v5));
                        monthGraph.put("Jun",Float.valueOf(d.graphdata.v6));
                        monthGraph.put("Jul",Float.valueOf(d.graphdata.v7));
                        monthGraph.put("Aug",Float.valueOf(d.graphdata.v8));
                        monthGraph.put("Sep",Float.valueOf(d.graphdata.v9));
                        monthGraph.put("Oct",Float.valueOf(d.graphdata.v10));
                        monthGraph.put("Nov",Float.valueOf(d.graphdata.v11));
                        monthGraph.put("Dec",Float.valueOf(d.graphdata.v12));


                        weekdayGraph.put("M", Float.valueOf(d.graphdata.w1));
                        weekdayGraph.put("T", Float.valueOf(d.graphdata.w1));
                        weekdayGraph.put("W", Float.valueOf(d.graphdata.w1));
                        weekdayGraph.put("Th", Float.valueOf(d.graphdata.w1));
                        weekdayGraph.put("F", Float.valueOf(d.graphdata.w1));
                        weekdayGraph.put("S", Float.valueOf(d.graphdata.w1));
                        weekdayGraph.put("Su", Float.valueOf(d.graphdata.w1));

                        series.addPoint(new ValueLinePoint("Jan", monthGraph.get("Jan")));
                        series.addPoint(new ValueLinePoint("Feb", monthGraph.get("Feb")));
                        series.addPoint(new ValueLinePoint("Mar", monthGraph.get("Mar")));
                        series.addPoint(new ValueLinePoint("Apr", monthGraph.get("Apr")));
                        series.addPoint(new ValueLinePoint("May", monthGraph.get("May")));
                        series.addPoint(new ValueLinePoint("Jun", monthGraph.get("Jun")));
                        series.addPoint(new ValueLinePoint("Jul", monthGraph.get("Jul")));
                        series.addPoint(new ValueLinePoint("Aug", monthGraph.get("Aug")));
                        series.addPoint(new ValueLinePoint("Sep", monthGraph.get("Sep")));
                        series.addPoint(new ValueLinePoint("Oct", monthGraph.get("Oct")));
                        series.addPoint(new ValueLinePoint("Nov", monthGraph.get("Nov")));
                        series.addPoint(new ValueLinePoint("Dec", monthGraph.get("Dec")));


                        mCubicValueLineChart.addSeries(series);
                        mCubicValueLineChart.startAnimation();

                        ValueLineChart mCubicValueLineChart2 = (ValueLineChart) findViewById(R.id.cubiclinechart2);
                        ValueLineSeries series2 = new ValueLineSeries();
                        series2.setColor(0xFF008080);
                        series2.setColor(0xFF56B7F1);



                        series2.addPoint(new ValueLinePoint("d", weekdayGraph.get("M")));
                        series2.addPoint(new ValueLinePoint("M", weekdayGraph.get("M")));
                        series2.addPoint(new ValueLinePoint("T", weekdayGraph.get("T")));
                        series2.addPoint(new ValueLinePoint("W", weekdayGraph.get("W")));
                        series2.addPoint(new ValueLinePoint("T", weekdayGraph.get("Th")));
                        series2.addPoint(new ValueLinePoint("F", weekdayGraph.get("F")));
                        series2.addPoint(new ValueLinePoint("S", weekdayGraph.get("S")));
                        series2.addPoint(new ValueLinePoint("S", weekdayGraph.get("Su")));
                        series2.addPoint(new ValueLinePoint("Dec", weekdayGraph.get("M")));

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
                loadData();

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
                       System.out.println(dataSnapshot);

                d.tv_ins_name = dataSnapshot.child("institute").child("building").child("institutename").getValue().toString();
                d.ratingbar_homepage = Integer.valueOf(dataSnapshot.child("institute").child("building").child("rating").getValue().toString());
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
               // d.review1.ratebar = Integer.valueOf(dataSnapshot.child("institute").child("review").child("review1").child("rating").getValue().toString());

                d.review2.name = dataSnapshot.child("institute").child("review").child("review2").child("name").getValue().toString();
                d.review2.comment = dataSnapshot.child("institute").child("review").child("review2").child("comment").getValue().toString();
                d.review2.subject = dataSnapshot.child("institute").child("review").child("review2").child("subject").getValue().toString();
               // d.review2.ratebar = Integer.valueOf(dataSnapshot.child("institute").child("review").child("review2").child("rating").getValue().toString());

                d.building.ins_name = dataSnapshot.child("institute").child("building").child("institutename").getValue().toString();
                d.building.about = dataSnapshot.child("institute").child("building").child("about").getValue().toString();
                d.building.office_num = dataSnapshot.child("institute").child("building").child("officenumber").getValue().toString();
                d.building.address = dataSnapshot.child("institute").child("building").child("address").getValue().toString();
                d.building.website = dataSnapshot.child("institute").child("building").child("website").getValue().toString();

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
//                d.inforateus.num_stars = Integer.valueOf(dataSnapshot.child("devinfo").child("rateus").child("stars").getValue().toString());

//                d.infocontact1.location = dataSnapshot.child("devinfo").child("contactus").child("state1").getValue().toString();
//                d.infocontact2.location = dataSnapshot.child("devinfo").child("contactus").child("state2").getValue().toString();
//                d.infocontact3.location = dataSnapshot.child("devinfo").child("contactus").child("state3").getValue().toString();
//                d.infocontact4.location = dataSnapshot.child("devinfo").child("contactus").child("state4").getValue().toString();
//                d.infocontact1.phnum = dataSnapshot.child("devinfo").child("contactus").child("phone1").getValue().toString();
//                d.infocontact2.phnum = dataSnapshot.child("devinfo").child("contactus").child("phone2").getValue().toString();
//                d.infocontact3.phnum = dataSnapshot.child("devinfo").child("contactus").child("phone3").getValue().toString();
//                d.infocontact4.phnum = dataSnapshot.child("devinfo").child("contactus").child("phone4").getValue().toString();

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
        devinfo.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                d.devinnfo.message = (dataSnapshot.child("about").child("message").getValue().toString());
                d.devinnfo.about_Photo_links.add(dataSnapshot.child("about").child("link1").getValue().toString());
                d.devinnfo.about_Photo_links.add(dataSnapshot.child("about").child("link2").getValue().toString());
                d.devinnfo.about_Photo_links.add(dataSnapshot.child("about").child("link4").getValue().toString());
                d.devinnfo.about_Photo_links.add(dataSnapshot.child("about").child("link3").getValue().toString());

                d.devinnfo.state.add(dataSnapshot.child("contactus").child("state1").getValue().toString());
                d.devinnfo.phone.add(dataSnapshot.child("contactus").child("phone1").getValue().toString());
                d.devinnfo.state.add(dataSnapshot.child("contactus").child("state2").getValue().toString());
                d.devinnfo.phone.add(dataSnapshot.child("contactus").child("phone2").getValue().toString());
                d.devinnfo.state.add(dataSnapshot.child("contactus").child("state3").getValue().toString());
                d.devinnfo.phone.add(dataSnapshot.child("contactus").child("phone3").getValue().toString());
                d.devinnfo.state.add(dataSnapshot.child("contactus").child("state4").getValue().toString());
                d.devinnfo.phone.add(dataSnapshot.child("contactus").child("phone4").getValue().toString());

                d.devinnfo.feedback.add(dataSnapshot.child("feedback").child("link1").getValue().toString());
                d.devinnfo.feedback.add(dataSnapshot.child("feedback").child("link2").getValue().toString());
                d.devinnfo.feedback.add(dataSnapshot.child("feedback").child("link3").getValue().toString());
                d.devinnfo.feedback.add(dataSnapshot.child("feedback").child("link4").getValue().toString());

                d.devinnfo.Rateing = Integer.valueOf(dataSnapshot.child("rateus").child("stars").getValue().toString());
                d.devinnfo.link = dataSnapshot.child("rateus").child("link").getValue().toString();
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
        View view1 = LayoutInflater.from(this).inflate(R.layout.contact1, null, false);

        TextView state1 = view1.findViewById(R.id.state1_contacts);
        state1.setText(d.devinnfo.state.get(0));
        TextView state2 = view1.findViewById(R.id.state2_contacts);
        state2.setText(d.devinnfo.state.get(1));
        TextView state3 = view1.findViewById(R.id.state3_contacts);
        state3.setText(d.devinnfo.state.get(2));
        TextView state4 = view1.findViewById(R.id.state4_contacts);
        state4.setText(d.devinnfo.state.get(3));


        TextView phone1 = view1.findViewById(R.id.phone1_contact);
        phone1.setText(d.devinnfo.phone.get(0));
        TextView phone2 = view1.findViewById(R.id.phone2_contact);
        phone2.setText(d.devinnfo.phone.get(1));
        TextView phone3 = view1.findViewById(R.id.phone3_contact);
        phone3.setText(d.devinnfo.phone.get(2));
        TextView phone4 = view1.findViewById(R.id.phone4_contact);
        phone4.setText(d.devinnfo.phone.get(3));

        final MaterialDialog mMaterialDialog = new MaterialDialog(this).setView(view1);

        mMaterialDialog.setNegativeButton("cancel", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMaterialDialog.dismiss();
            }
        });
        mMaterialDialog.show();
        //startActivity(new Intent(MainActivity.this, contactus.class));
        Log.d("in", "opencontactus: out");
    }

    void loadDataInBuilding(){
        EditText et_institute = findViewById(R.id.buildind_et_ins_name);
        et_institute.setText(d.tv_ins_name);
        EditText et_about = findViewById(R.id.buildind_et_about);
        et_about.setText(d.building.about);
        Spinner sp_subject1 = findViewById(R.id.buildind_sp_subject1);
        //todo : do something with spinner
        Spinner sp_subject2 = findViewById(R.id.buildind_sp_subject2);
        Spinner sp_subject3 = findViewById(R.id.buildind_sp_subject3);
        EditText et_teacher1 = findViewById(R.id.buildind_et_teacher1);
        et_teacher1.setText(d.building.subjects.get(0).teacher);
        EditText et_teacher2 = findViewById(R.id.buildind_et_teacher2);
        et_teacher2.setText(d.building.subjects.get(1).teacher);
        EditText et_teacher3 = findViewById(R.id.buildind_et_teacher3);
        et_teacher3.setText(d.building.subjects.get(2).teacher);
     Switch sw_grp_tuition = findViewById(R.id.building_switch_grp_tuition);
        Switch sw_hom_tuition = findViewById(R.id.building_switch_hom_tuition);
        if (d.building.switch1) {
            sw_grp_tuition.setChecked(true);
            sw_hom_tuition.setChecked(false);
        }
        else {
            sw_grp_tuition.setChecked(false);
            sw_hom_tuition.setChecked(true);
        }
        Switch sw_entr_based = findViewById(R.id.building_switch_entrance_based);
        Switch sw_direct = findViewById(R.id.building_switch_direct);
        if (d.building.switch2) {
            sw_entr_based.setChecked(true);
            sw_direct.setChecked(false);
        }
        else {
            sw_entr_based.setChecked(false);
            sw_direct.setChecked(true);
        }
        EditText et_address = findViewById(R.id.building_et_address);
        et_address.setText(d.building.address);
        EditText et_office_num = findViewById(R.id.building_et_office_num);
        et_office_num.setText(d.building.office_num);
        EditText et_website = findViewById(R.id.building_et_website);
        et_website.setText(d.building.website);
    }
   void loaddatainhomepage(){
        TextView tv_ins_name= findViewById(R.id.institute_name);
        tv_ins_name.setText(d.building.ins_name);
        TextView tv_ceo_name=findViewById(R.id.owner_name1);
        tv_ceo_name.setText(d.building.ceo);
   }
    void loadDataInGraphs(){

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
        EditText et_ceo=findViewById(R.id.building_et_ceo);

        if (checkEdittext(et_institute) && checkEdittext(et_about) && checkEdittext(et_teacher1)
                && checkEdittext(et_teacher2) && checkEdittext(et_teacher3) && checkEdittext(et_address) && checkEdittext(et_office_num)
                && checkEdittext(et_website) && checkSwitch(sw_grp_tuition, sw_hom_tuition) && checkSwitch(sw_direct, sw_entr_based))
        {
            building.child("institutename").setValue(et_institute.getText());
            building.child("about").setValue(et_about.getText());
            building.child("subjects").child("subject1").setValue(et_teacher1);
            building.child("subjects").child("subject2").setValue(et_teacher2);
            building.child("subjects").child("subject3").setValue(et_teacher3);
//            building.child("subjects").child("subject4").setValue(et_teacher4");
//            building.child("subjects").child("subject5").setValue(et_teacher5);
            building.child("address").setValue(et_address);
            building.child("officenumber").setValue(et_office_num);
            building.child("website").setValue(et_website);
            if(sw_grp_tuition.isChecked()) {
                building.child("tuitiontype").setValue("1");
            }else building.child("tuitiontype").setValue("0");
            if(sw_entr_based.isChecked())
                building.child("admissiontype").setValue("1");
            else
                building.child("admissiontype").setValue("0");

            building.child("ownername").child("owner1").setValue(et_ceo);
            building.child("rating").setValue("3");
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

    public void open_layout(View view){
//        Intent intent=new Intent(this, MenuHomepage.class);
          switch (view.getId())
        {
            case R.id.homepage_profile: setContentView(R.layout.layout);
            break;
            case R.id.homepage_building: setContentView(R.layout.building1);
            loadDataInBuilding();
            break;
            case R.id.homepage_info:setContentView(R.layout.tab3);
            break;
        }
//        startActivity(intent);

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