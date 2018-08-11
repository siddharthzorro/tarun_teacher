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

public class singnin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Boolean isUserPresent;
    FirebaseUser currentUser;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.teacher_sign_in);


    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
        if (currentUser != null)
            gohome();
    }

    void gohome() {
        currentUser=mAuth.getCurrentUser();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userid", currentUser.getUid());
        Toast.makeText(this,currentUser.getEmail()+ "your id is ",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void login(View view) {
        EditText et_username = findViewById(R.id.editText14);
        EditText et_password = findViewById(R.id.editText15);
        if (et_username.getText().toString().isEmpty()) {
            et_username.setError("Empty field");


        } else {
            if (et_password.getText().toString().isEmpty()) {
                et_password.setError("Empty field");

            } else {

                String email=et_username.getText().toString();
                email = email.replaceAll("[^a-zA-Z0-9]", "");

                mAuth.signInWithEmailAndPassword(email, et_password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("sd", "signInWithEmail:success");
                                    mAuth = FirebaseAuth.getInstance();
                                    gohome();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("sd", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(singnin.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }

        }

    }

    public void opensignup(View view) {
        setContentView(R.layout.signupform);

    }

    public void adduser(View view) {
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
                                    Toast.makeText(singnin.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        }

    }
}
