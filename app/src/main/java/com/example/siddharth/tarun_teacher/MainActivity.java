package com.example.siddharth.tarun_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.eightbitlab.bottomnavigationbar.BottomBarItem;
import com.eightbitlab.bottomnavigationbar.BottomNavigationBar;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mancj.materialsearchbar.MaterialSearchBar;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

public class MainActivity extends AppCompatActivity {
    LayoutInflater inflater; //recycler view booking
    Integer countOfName = 0;
    RecyclerView recyclerVie;
    Boolean donecounter = false;
    DatabaseReference building;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viepager);
        final ViewPager viewPager = findViewById(R.id.vp);

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        building = firebaseDatabase.getReference("institute").child("building");

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
                        final ConstraintLayout layout = findViewById(R.id.cl);
                        layout.bringChildToFront(findViewById(R.id.sc1));
                        SwipeLayout sample3 = (SwipeLayout) findViewById(R.id.sample3);
                        //given id here in second parameter is id of view you want to show when reveling not by default
                        //everything else is visible by itself
                        sample3.addDrag(SwipeLayout.DragEdge.Right, sample3.findViewWithTag("Bottom2"));

                        sample3.addDrag(SwipeLayout.DragEdge.Bottom, sample3.findViewWithTag("Bottom3"));
                        sample3.addRevealListener(R.id.llsv_d, new SwipeLayout.OnRevealListener() {
                            @Override
                            public void onReveal(View child, SwipeLayout.DragEdge edge, float fraction, int distance) {
                                layout.bringChildToFront(findViewById(R.id.sample3));

                                if (fraction == 1)
                                    layout.bringChildToFront(findViewById(R.id.sample3));
                                else
                                    layout.bringChildToFront(findViewById(R.id.sc1));

                            }
                        });
                        final Float rating = 2.5f;
                        final RatingBar rate_bar = findViewById(R.id.rating_homepage);
                        rate_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                                rate_bar.setRating(rating);
                            }
                        });
                        rate_bar.setRating(rating);
                        final BottomNavigationView navigationView = findViewById(R.id.bnve);

                        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                            @Override
                            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                                View layout1 = findViewById(R.id.tab1);
                                View layout2 = findViewById(R.id.tab2);
                                View layout3 = findViewById(R.id.tab3);
                                Menu menu2 = navigationView.getMenu();
                                MenuItem item11 = menu2.getItem(0);
                                MenuItem item12 = menu2.getItem(1);
                                MenuItem item13 = menu2.getItem(2);

                                switch (menuItem.getItemId()) {
                                    case R.id.menuprofile:

                                        layout1.setVisibility(View.VISIBLE);
                                        layout2.setVisibility(View.GONE);
                                        layout3.setVisibility(View.GONE);
                                        item11.setIcon(R.drawable.profileownerfilled);
                                        item12.setIcon(R.mipmap.ic_launcher_foreground_institute_new);
                                        item13.setIcon(R.mipmap.ic_launcher_foreground_info_newz);
                                        return true;
                                    case R.id.menubuild:
                                        Log.d("mn", "onNavigationItemSelected: 2");
                                        layout1.setVisibility(View.GONE);
                                        layout2.setVisibility(View.VISIBLE);
                                        layout3.setVisibility(View.GONE);
                                        item12.setIcon(R.drawable.institutefilled);
                                        item11.setIcon(R.drawable.icon_selector_home1);
                                        item13.setIcon(R.mipmap.ic_launcher_foreground_info_newz);

                                        final Switch myswitch2 = findViewById(R.id.building_switch_direct);

                                        final Switch myswitch1 = findViewById(R.id.building_switch_entrance_based);
                                        myswitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked) {
                                                    myswitch2.setChecked(false);
                                                }
                                                // true if the switch is in the On position
                                            }
                                        });
                                        myswitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked) {
                                                    myswitch1.setChecked(false);
                                                }
                                                // true if the switch is in the On position
                                            }
                                        });
                                        final Switch myswitch4 = findViewById(R.id.building_switch_hom_tuition);

                                        final Switch myswitch3 = findViewById(R.id.building_switch_grp_tuition);
                                        myswitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked) {
                                                    myswitch4.setChecked(false);
                                                }
                                                // true if the switch is in the On position
                                            }
                                        });
                                        myswitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                if (isChecked) {
                                                    myswitch3.setChecked(false);
                                                }
                                                // true if the switch is in the On position
                                            }
                                        });
                                        return true;
                                    case R.id.menuinfo:

                                        layout1.setVisibility(View.GONE);
                                        layout2.setVisibility(View.GONE);
                                        layout3.setVisibility(View.VISIBLE);
                                        item13.setIcon(R.drawable.infofilled);
                                        item11.setIcon(R.drawable.icon_selector_home1);
                                        item12.setIcon(R.mipmap.ic_launcher_foreground_institute_new);

                                        return true;
                                }
                                return true;
                            }
                        });
                        donecounter = true;


                        recyclerVie = findViewById(R.id.rv);
                        recyclerVie.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerVie.setAdapter(new RecyclerView.Adapter() {
                            @NonNull
                            @Override
                            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                                return new RecyclerView.ViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.homepage_holder, parent, false)) {
                                    @Override
                                    public String toString() {
                                        return super.toString();
                                    }
                                };
                            }

                            @Override
                            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

                            }

                            @Override
                            public int getItemCount() {
                                return countOfName;
                            }
                        });

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
                                view.setOnLongClickListener(new View.OnLongClickListener() {
                                    @Override
                                    public boolean onLongClick(View view) {
                                        Log.d("ijhj", "onLongClick: jhg");
                                        return true;
                                    }
                                });
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
//        viewPager.setOffscreenPageLimit(2);

//        final BottomNavigationViewEx bnve = findViewById(R.id.bottomNavigationView);
//        bnve.enableAnimation(false);
//        bnve.enableItemShiftingMode(true);
//        bnve.setTextVisibility(false);
//
//        bnve.setIconSize(30, 30);
//        bnve.setupWithViewPager(viewPager);
//        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Menu menu = bnve.getMenu();
//            MenuItem item1=menu.getItem(0);
//            MenuItem item2=menu.getItem(1);
//            MenuItem item3=menu.getItem(2);
//
//            switch (item.getItemId()){
//                case 0:
//                    item1.setIcon(R.drawable.accountsettingfilled);
//                    item2.setIcon(R.mipmap.bookingandchat_foreground);
//                    item3.setIcon(R.mipmap.insight_foreground);
//                case 1:
//                    item2.setIcon(R.drawable.bookingfilled);
//                    item1.setIcon(R.mipmap.accountsetting_foreground);
//                    item3.setIcon(R.mipmap.insight_foreground);
//
//                case 2:
//                    item3.setIcon(R.drawable.insightfilled);
//                    item1.setIcon(R.mipmap.accountsetting_foreground);
//                    item2.setIcon(R.mipmap.bookingandchat_foreground);
//
//            }
//                return  true;
//            }
//        });

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
        startActivity(new Intent(this, about.class));
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

        if(checkEdittext(et_institute)&&checkEdittext(et_about)&&checkEdittext(et_teacher1)
                &&checkEdittext(et_teacher2)&&checkEdittext(et_teacher3)&&checkEdittext(et_address)&&checkEdittext(et_office_num)
                &&checkEdittext(et_website)&&checkSwitch(sw_grp_tuition,sw_hom_tuition)&&checkSwitch(sw_direct,sw_entr_based))
        {
                 building.child("institutename").setValue(et_institute.getText());
        }
    }
    boolean checkEdittext(EditText editText){
        if (editText.getText().toString().isEmpty()){
            editText.setError("fill this");
            return false;
        }
        else
            return true;
    }
    boolean checkSwitch(Switch switch1,Switch switch2){
        if(switch1.isChecked()==switch2.isChecked())
            return  false;
        else return true;
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