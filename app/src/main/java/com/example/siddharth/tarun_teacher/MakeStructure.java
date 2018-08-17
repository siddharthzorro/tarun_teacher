package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;


 public abstract class MakeStructure  {
    static FirebaseDatabase reference;

     static boolean makestruct(String userid){
         reference = FirebaseDatabase.getInstance();
         DatabaseReference users=reference.getReference("users");
         DatabaseReference live=reference.getReference("liveranks");
         DatabaseReference devinfo=reference.getReference("devinfo");


         //todo: comment all devinfo section since it is same for all
         live.child("rank1").setValue("rank1");
         live.child("rank2").setValue("rank2");
         live.child("rank3").setValue("rank3");
         live.child("rank4").setValue("rahhftyrfytnk3");
         live.child("rank5").setValue("rank5");
         live.child("rank6").setValue("rank6");
         live.child("rank7").setValue("rank7");

         devinfo.child("about").child("message").setValue("asyuhsdfsadhgfashklfdh");
         devinfo.child("about").child("link1").setValue("https//asyuhsdfsadhgfashklfdh");
         devinfo.child("about").child("link2").setValue("https//asyuhsdfsadhgfashklfdh");
         devinfo.child("about").child("link3").setValue("https//asyuhsdfsadhgfashklfdh");
         devinfo.child("about").child("link4").setValue("https//asyuhsdfsadhgfashklfdh");


         devinfo.child("contactus").child("state1").setValue("delhi");
         devinfo.child("contactus").child("state2").setValue("delhi");
         devinfo.child("contactus").child("state3").setValue("delhi");
         devinfo.child("contactus").child("state4").setValue("delhi");
         devinfo.child("contactus").child("phone1").setValue("delhi");
         devinfo.child("contactus").child("phone2").setValue("delhi");
         devinfo.child("contactus").child("phone3").setValue("delhi");
         devinfo.child("contactus").child("phone4").setValue("delhi");


         devinfo.child("feedback").child("link1").setValue("socialmedia1");
         devinfo.child("feedback").child("link2").setValue("socialmedia2");
         devinfo.child("feedback").child("link3").setValue("socialmedia3");
         devinfo.child("feedback").child("link4").setValue("socialmedia4");

         devinfo.child("rateus").child("stars").setValue("3");
         devinfo.child("rateus").child("link").setValue("https//efhdf");

         users.child(userid).child("institute").child("building").child("ranking").setValue("1");

         users.child(userid).child("institute").child("building").child("photo").setValue("https//vrtr");

         users.child(userid).child("institute").child("building").child("institutename").setValue("FiitJee");
         users.child(userid).child("institute").child("building").child("about").setValue("we are 6s");
         users.child(userid).child("institute").child("building").child("subjects").child("subject1").setValue("teacher1");
         users.child(userid).child("institute").child("building").child("subjects").child("subject2").setValue("teacher2");
         users.child(userid).child("institute").child("building").child("subjects").child("subject3").setValue("teacher3");
         users.child(userid).child("institute").child("building").child("subjects").child("subject4").setValue("teacher4");
         users.child(userid).child("institute").child("building").child("subjects").child("subject5").setValue("teacher5");
         users.child(userid).child("institute").child("building").child("address").setValue("janakpuri");
         users.child(userid).child("institute").child("building").child("officenumber").setValue("48484885");
         users.child(userid).child("institute").child("building").child("website").setValue("http//..");
         users.child(userid).child("institute").child("building").child("tuitiontype").setValue("0");
         users.child(userid).child("institute").child("building").child("admissiontype").setValue("0");
         users.child(userid).child("institute").child("building").child("ownername").child("owner1").setValue("name1");
         users.child(userid).child("institute").child("building").child("ownername").child("owner2").setValue("name2");
         users.child(userid).child("institute").child("building").child("rating").setValue("3");

         users.child(userid).child("institute").child("review").child("review1").child("name").setValue("name1");
         users.child(userid).child("institute").child("review").child("review1").child("rating").setValue("3");
         users.child(userid).child("institute").child("review").child("review1").child("comment").setValue("yo yo");
         users.child(userid).child("institute").child("review").child("review1").child("subject").setValue("yo yocdnjdj");


         users.child(userid).child("institute").child("review").child("review2").child("name").setValue("name1");
         users.child(userid).child("institute").child("review").child("review2").child("rating").setValue("3");
         users.child(userid).child("institute").child("review").child("review2").child("comment").setValue("yo yo");
         users.child(userid).child("institute").child("review").child("review2").child("subject").setValue("asvxgs");


         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("jan").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("feb").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("mar").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("apr").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("jun").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("jul").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("aug").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("sep").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("oct").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("nov").setValue("2");
         users.child(userid).child("institute").child("graph").child("monthlyoverview").child("dec").setValue("2");

         users.child(userid).child("institute").child("graph").child("interaction").child("mon").setValue("2");
         users.child(userid).child("institute").child("graph").child("interaction").child("tue").setValue("2");
         users.child(userid).child("institute").child("graph").child("interaction").child("wed").setValue("2");
         users.child(userid).child("institute").child("graph").child("interaction").child("thu").setValue("2");
         users.child(userid).child("institute").child("graph").child("interaction").child("fri").setValue("2");
         users.child(userid).child("institute").child("graph").child("interaction").child("sat").setValue("2");
         users.child(userid).child("institute").child("graph").child("interaction").child("sun").setValue("2");

         users.child(userid).child("institute").child("promote").child("promotepage1").child("radius").setValue("2");
         users.child(userid).child("institute").child("promote").child("promotepage1").child("duration").setValue("2");
         users.child(userid).child("institute").child("promote").child("promotepage1").child("area").setValue("2");

         users.child(userid).child("institute").child("promote").child("promotepage2").child("postpromotion1").child("link").setValue("https//");
         users.child(userid).child("institute").child("promote").child("promotepage2").child("postpromotion1").child("description").setValue("shbhd");
         users.child(userid).child("institute").child("promote").child("promotepage2").child("postpromotion1").child("photo").setValue("2");

         users.child(userid).child("institute").child("promote").child("promotepage2").child("postpromotion2").child("link").setValue("https//");
         users.child(userid).child("institute").child("promote").child("promotepage2").child("postpromotion2").child("description").setValue("shbhd");
         users.child(userid).child("institute").child("promote").child("promotepage2").child("postpromotion2").child("photo").setValue("2");
       //  Toast.makeText(MakeStructure.this,"endddddddddd live data",Toast.LENGTH_SHORT).show();

         return true;
     }

}
