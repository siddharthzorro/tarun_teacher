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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class signupform extends AppCompatActivity {
    ViewPager x;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    String TAG = "Signup Form";

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
                        break;
                    case 1:
                        Log.d(TAG, "onPageSelected: " + position);
                        left.setVisibility(View.VISIBLE);
                        right.setVisibility(View.VISIBLE);
                        pay.setVisibility(View.INVISIBLE);
                        centerArrow.setVisibility(View.INVISIBLE);
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
                        left.setVisibility(View.INVISIBLE);
                        right.setVisibility(View.INVISIBLE);
                        pay.setVisibility(View.VISIBLE);
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

    }

    public  void addPostPromotion(View view){
        RecyclerViewX viewX=findViewById(R.id.rvx_post_promotion);
        viewX.addAdapter(viewX.getAdapter().getItemCount()+1,R.layout.post_promotion_holder,signupform.this, LinearLayoutManager.HORIZONTAL);
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
            return inflater.inflate(R.layout.signupform, container, false);
        }
    }

    public static class page2 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.building2, container, false);
        }
    }

    public static class page3 extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.alldone, container, false);
        }
    }


    void gohome() {
        currentUser = mAuth.getCurrentUser();
        currentUser=mAuth.getCurrentUser();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userid", currentUser.getUid());
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

                String email=et_name.getText().toString();
                email = email.replaceAll("[^a-zA-Z0-9]", "");

                mAuth.createUserWithEmailAndPassword(email, et_pass.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("ds", "createUserWithEmail:success");
                                    MakeStructure.makestruct(mAuth.getUid());
                                    mAuth = FirebaseAuth.getInstance();
                                    gohome();
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
