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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class signupform extends AppCompatActivity {
    ViewPager x;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    String TAG = "Signup Form";
    DatabaseReference building;
    DatabaseReference userdata;
    FirebaseDatabase firebaseDatabase;
    String email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_starting);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
//                View left = findViewById(R.id.prmt_leftarrow);
//                View right = findViewById(R.id.prmt_right_arrow);
//                View pay = findViewById(R.id.prmt_pay);
//                View centerArrow = findViewById(R.id.prmt_center_arrow);

                switch (position) {
                    case 0:
                        Log.d(TAG, "onPageSelected: " + position);
//                        left.setVisibility(View.INVISIBLE);
//                        right.setVisibility(View.INVISIBLE);
//                        pay.setVisibility(View.INVISIBLE);
//                        centerArrow.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        Log.d(TAG, "onPageSelected: " + position);
//                        left.setVisibility(View.VISIBLE);
//                        right.setVisibility(View.VISIBLE);
//                        pay.setVisibility(View.INVISIBLE);
//                        centerArrow.setVisibility(View.INVISIBLE);
//                        final Switch myswitch6 = findViewById(R.id.switch5);
//
//                        final Switch myswitch5 = findViewById(R.id.switch6);
//                        myswitch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                                if(isChecked){
//                                    myswitch6.setChecked(false);
//                                }
//                                // true if the switch is in the On position
//                            }
//                        });
//                        myswitch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                                if(isChecked){
//                                    myswitch5.setChecked(false);
//                                }
//                                // true if the switch is in the On position
//                            }
//                        });
//                        RecyclerViewX viewX=findViewById(R.id.rvx_post_promotion);
//                        viewX.addAdapter(5,R.layout.post_promotion_holder,signupform.this, LinearLayoutManager.HORIZONTAL);
//                        break;


                    case 2:
                        Log.d(TAG, "onPageSelected: " + position);
//                        left.setVisibility(View.INVISIBLE);
//                        right.setVisibility(View.INVISIBLE);
//                        pay.setVisibility(View.VISIBLE);
//                        centerArrow.setVisibility(View.INVISIBLE);
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

    }

    public  void addPostPromotion(View view){
        RecyclerViewX viewX=findViewById(R.id.rvx_post_promotion);
        viewX.addAdapter(viewX.getAdapter().getItemCount()+1,R.layout.post_promotion_holder,signupform.this, LinearLayoutManager.HORIZONTAL);
    }
//    public void goleft(View view) {
//        if (x.getCurrentItem() != 0) {
//            x.setCurrentItem(0);
//        }
//    }
//
//    public void goright(View view) {
//        x.setCurrentItem(x.getCurrentItem() + 1);
//    }

    public static class page1 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.signupform, container, false);
        }
    }

    public static class page2 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.building1, container, false);
        }
    }

    public static class page3 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.alldone, container, false);
        }
    }

    public void buildingSave(View view) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        userdata = firebaseDatabase.getReference("users").child(email);
        building = userdata.child("institute").child("building");
        DatabaseReference review = userdata.child("institute").child("review");


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
            gohome();
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
    void gohome() {
        currentUser = mAuth.getCurrentUser();
        currentUser=mAuth.getCurrentUser();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userid", currentUser.getEmail());
        Toast.makeText(this,currentUser.getEmail()+ "your id is ",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
   
    public void adduser(View view) {
        mAuth = FirebaseAuth.getInstance();
        EditText et_name = (EditText) findViewById(R.id.et_s_username);
        EditText et_pass = (EditText) findViewById(R.id.et_s_pass);

        if (et_name.getText().toString().isEmpty())
            et_name.setError("fill this");
        else {
            if (et_pass.getText().toString().isEmpty())
                et_pass.setError("fill this");
            else {

                email = et_name.getText().toString();
                //email = email.replaceAll("[^a-zA-Z0-9]", "");

                mAuth.createUserWithEmailAndPassword(email, et_pass.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("ds", "createUserWithEmail:success");
                                    MakeStructure.makestruct(mAuth.getUid());
                                    mAuth = FirebaseAuth.getInstance();
//                                    gohome();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("sd", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(signupform.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        }

    }
}
