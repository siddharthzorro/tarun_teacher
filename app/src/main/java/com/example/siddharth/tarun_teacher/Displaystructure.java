package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

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
        ArrayList<Subject> subjectArrayList;
        Devinnfo devinnfo;

}

 class Devinnfo{

    String message,link;
    Integer Rateing;
    ArrayList<String> about_Photo_links,feedback,state,phone;
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
    String comment,subject,name;
    Integer ratebar;

  }
  class Building{
    String ins_name,about,office_num,address,website;
    ArrayList<Subject> subjects;
    Boolean switch1,switch2;
//  todo attach google maps
  }
  class Subject{
      public Subject(String subject, String teacher) {
          this.subject = subject;
          this.teacher = teacher;
      }

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
      public Postpromotion(String link, String description, String photolink) {
          this.link = link;
          this.description = description;
          this.photolink = photolink;
      }

      String link;
   String description,photolink;
  }
  class Notification{
    String time,body,header;
  }