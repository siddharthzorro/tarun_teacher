package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class makeStructure extends AppCompatActivity {
     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.signup);
          FirebaseDatabase reference= FirebaseDatabase.getInstance();
          DatabaseReference users=reference.getReference("users");
          DatabaseReference live=reference.getReference("liveranks");
          DatabaseReference devinfo=reference.getReference("devinfo");


          live.child("rank1").setValue("rank1");
          live.child("rank2").setValue("rank2");
          live.child("rank3").setValue("rank3");
         live.child("rank4").setValue("rahhftyrfytnk3");

         devinfo.child("about").child("message").setValue("asyuhsdfsadhgfashklfdh");
          devinfo.child("about").child("link").setValue("https//asyuhsdfsadhgfashklfdh");

         devinfo.child("contactus").child("state1").setValue("9958442265");
         devinfo.child("contactus").child("state2").setValue("9958442265");
         devinfo.child("contactus").child("state3").setValue("9958442265");
         devinfo.child("contactus").child("state4").setValue("9958442265");

         devinfo.child("feedback").child("link1").setValue("socialmedia1");
         devinfo.child("feedback").child("link2").setValue("socialmedia2");
         devinfo.child("feedback").child("link3").setValue("socialmedia3");
         devinfo.child("feedback").child("link4").setValue("socialmedia4");

         devinfo.child("rateus").child("stars").setValue("3");

         users.child("user1").child("institute").child("building").child("institutename").setValue("FiitJee");
         users.child("user1").child("institute").child("building").child("about").setValue("we are 6s");
         users.child("user1").child("institute").child("building").child("subject1").setValue("teacher1");
         users.child("user1").child("institute").child("building").child("subject2").setValue("teacher2");
         users.child("user1").child("institute").child("building").child("subject3").setValue("teacher3");
         users.child("user1").child("institute").child("building").child("subject4").setValue("teacher4");
         users.child("user1").child("institute").child("building").child("subject5").setValue("teacher5");
         users.child("user1").child("institute").child("building").child("address").setValue("janakpuri");
         users.child("user1").child("institute").child("building").child("officenumber").setValue("48484885");
         users.child("user1").child("institute").child("building").child("website").setValue("http//..");
         users.child("user1").child("institute").child("building").child("tuitiontype").setValue("0");
         users.child("user1").child("institute").child("building").child("admissiontype").setValue("0");
         users.child("user1").child("institute").child("building").child("ownername").child("owner1").setValue("name1");
         users.child("user1").child("institute").child("building").child("ownername").child("owner2").setValue("name2");
         users.child("user1").child("institute").child("building").child("rating").setValue("3");

         users.child("user1").child("institute").child("review").child("review1").child("name").setValue("name1");
         users.child("user1").child("institute").child("review").child("review1").child("rating").setValue("3");
         users.child("user1").child("institute").child("review").child("review1").child("comment").setValue("yo yo");

         users.child("user1").child("institute").child("review").child("review2").child("name").setValue("name1");
         users.child("user1").child("institute").child("review").child("review2").child("rating").setValue("3");
         users.child("user1").child("institute").child("review").child("review2").child("comment").setValue("yo yo");

         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("jan").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("feb").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("mar").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("apr").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("jun").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("jul").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("aug").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("sep").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("oct").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("nov").setValue("2");
         users.child("user1").child("institute").child("graph").child("monthlyoverview").child("dec").setValue("2");

         users.child("user1").child("institute").child("graph").child("interaction").child("mon").setValue("2");
         users.child("user1").child("institute").child("graph").child("interaction").child("tue").setValue("2");
         users.child("user1").child("institute").child("graph").child("interaction").child("wed").setValue("2");
         users.child("user1").child("institute").child("graph").child("interaction").child("thu").setValue("2");
         users.child("user1").child("institute").child("graph").child("interaction").child("fri").setValue("2");
         users.child("user1").child("institute").child("graph").child("interaction").child("sat").setValue("2");
         users.child("user1").child("institute").child("graph").child("interaction").child("sun").setValue("2");

         users.child("user1").child("institute").child("promote").child("promotepage1").child("radius").setValue("2");
         users.child("user1").child("institute").child("promote").child("promotepage1").child("duration").setValue("2");
         users.child("user1").child("institute").child("promote").child("promotepage1").child("area").setValue("2");

         users.child("user1").child("institute").child("promote").child("promotepage2").child("postpromotion1").child("link").setValue("https//");
         users.child("user1").child("institute").child("promote").child("promotepage2").child("postpromotion1").child("description").setValue("shbhd");
         users.child("user1").child("institute").child("promote").child("promotepage2").child("postpromotion1").child("photo").setValue("2");

         users.child("user1").child("institute").child("promote").child("promotepage2").child("postpromotion2").child("link").setValue("https//");
         users.child("user1").child("institute").child("promote").child("promotepage2").child("postpromotion2").child("description").setValue("shbhd");
         users.child("user1").child("institute").child("promote").child("promotepage2").child("postpromotion2").child("photo").setValue("2");
         Toast.makeText(this,"endddddddddd live data",Toast.LENGTH_SHORT).show();

     }

}
