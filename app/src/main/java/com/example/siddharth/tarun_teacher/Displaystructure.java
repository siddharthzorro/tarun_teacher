package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Displaystructure {
        TextView tv_ins_name;
        TextView tv_owner_1;
        TextView getTv_owner_2;
        Integer ratingbar_homepage;
        Rank r1,r2,r3,r4,r5,r6,r7;
        Graphdata graphdata;



}
  class Rank {
      String ins_name;
      Integer rating;
      Integer position;

  }
  class Graphdata{
     Integer v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12;
     Integer w1,w2,w3,w4,w5,w6,w7;
  }
  class Review{
    String comment1,subject1,comeent2,subject2;


  }