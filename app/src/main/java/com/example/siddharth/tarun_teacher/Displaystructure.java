package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

public class Displaystructure {
        String tv_ins_name;
        String tv_owner_1;
        String tv_owner_2;
        Integer ratingbar_homepage;
        Rank r1,r2;
        Graphdata graphdata;
        Review review1,review2;
        Building building;
        Infoabout infoabout;
        Infofeedback infofeedback;
        Inforateus inforateus;
        Infocontact infocontact1,infocontact2,infocontact3,infocontact4;
        Promotedisplay promotedisplay;
        ArrayList<Notification> notifications;

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
    String comment,subject;
    Integer ratebar;

  }
  class Building{
    String ins_name,about,office_num,website;
    ArrayList<Subject> subjects;
    Boolean switch1,switch2;
//  todo attach google maps
  }
  class Subject{
    String subject,teacher;
  }
  class Infoabout{
    URL url1,url2,url3,url4;
  }
  class Infocontact{
    String location,phnum;
  }
  class Infofeedback{
    URL u1,u2,u3,u4;
  }
  class Inforateus{
    URL u;
    Integer num_stars;
  }
  class Promotedisplay{
   Integer radius,duration;
   String area;
   Boolean postpromotion,profilepromotion;
   ArrayList<Postpromotion> pstprom;
  }
  class Postpromotion{
   URL link;
   String description,photolink;
  }
  class Notification{
    String time,body,header;
  }