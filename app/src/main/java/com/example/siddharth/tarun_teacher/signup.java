package com.example.siddharth.tarun_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    View signuplay;
    View ekyclay;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_main);
        ekyclay=findViewById(R.id.ekycid);
        ekyclay.setVisibility(View.INVISIBLE);
    }



    public void opensignup(View view) {
        signuplay = findViewById(R.id.signupid);
        ekyclay=findViewById(R.id.ekycid);

        signuplay.setVisibility(View.VISIBLE);
        ekyclay.setVisibility(View.INVISIBLE);

    }

    public void ekyc(View view) {
        ekyclay=findViewById(R.id.ekycid);
        signuplay = findViewById(R.id.signupid);

        ekyclay.setVisibility(View.VISIBLE);
        signuplay.setVisibility((View.INVISIBLE));


    }

    public void mainpage(View view) {

        startActivity(new Intent(this,MainActivity.class));
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
                                    Toast.makeText(signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        }

    }

}
