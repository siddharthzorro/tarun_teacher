package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Displaystructure {
        String tv_ins_name="fjdj";
        String tv_owner_1="dbfhd";
        String tv_owner_2= "asdj";
        Integer ratingbar_homepage=1;
        Rank r1=  new Rank(),r2= new Rank();
        Graphdata graphdata= new Graphdata();
        Review review1= new Review(),review2= new Review();
        Building building= new Building();
        Infoabout infoabout= new Infoabout();
        Infofeedback infofeedback= new Infofeedback();
        Inforateus inforateus= new Inforateus();
        Infocontact infocontact1= new Infocontact(),infocontact2= new Infocontact(),infocontact3= new Infocontact(),infocontact4= new Infocontact();
        Promotedisplay promotedisplay= new Promotedisplay();
        ArrayList<Notification> notifications= new ArrayList<>();
        ArrayList<Subject> subjectArrayList= new ArrayList<>();
        Devinnfo devinnfo= new Devinnfo();
        Ranking ranking= new Ranking();
        Imageins pic= new Imageins();

    public Displaystructure() {
    }
}

 class Devinnfo{

    String message="dbfhd",link="dbfhd";
    Integer Rateing=1;
    ArrayList<String> about_Photo_links=new ArrayList<>(),feedback= new ArrayList<>(),state= new ArrayList<>(),phone= new ArrayList<>();

     public Devinnfo() {
     }
 }
class Imageins {
    String ins_image="dbfhd";

    public Imageins() {
    }
}
class Ranking{
    Integer ins_rank=1;

    public Ranking() {
    }
}
  class Rank {
      String ins_name="dbfhd";
      Integer rating=1;
      Integer position=1;

      public Rank() {
      }
  }
  class Graphdata{
     Integer v1=1,v2=1,v3=2,v4=2,v5=3,v6=3,v7=3,v8=3,v9=4,v10=4,v11=4,v12=4;
     Integer w1=0,w2=0,w3=0,w4=1,w5=1,w6=2,w7=0;

      public Graphdata() {
      }
  }
  class Review{
    String comment="dbfhd",subject="dbfhd",name="dbfhd";
    Integer ratebar=1;

      public Review() {
      }
  }
  class Building{
    String ins_name="dbfhd",about="dbfhd",office_num="dbfhd",address="dbfhd",website="dbfhd",ceo="dbfhd";
    ArrayList<Subject> subjects= new ArrayList<>();
    Boolean switch1=false,switch2=false;
//  todo attach google maps

      public Building() {
      }
  }
  class Subject{
      public Subject(String subject, String teacher) {
          this.subject = subject;
          this.teacher = teacher;
      }

      public Subject() {
      }

      String subject,teacher;
  }
  class Infoabout{
    String url1="dbfhd",url2="dbfhd",url3="dbfhd",url4="dbfhd";

      public Infoabout() {
      }
  }
  class Infocontact{
    String location="dbfhd",phnum="dbfhd";

      public Infocontact() {
      }
  }
  class Infofeedback{
    String u1="dbfhd",u2="dbfhd",u3="dbfhd",u4="dbfhd";

      public Infofeedback() {
      }
  }
  class Inforateus{
    String u="dbfhd";
    Integer num_stars=1;

      public Inforateus() {
      }
  }
  class Promotedisplay{
   Integer radius=0,duration=0;
   String area="dbfhd";
   Boolean postpromotion=false,profilepromotion=false;
   ArrayList<Postpromotion> pstprom=new ArrayList<>();

      public Promotedisplay() {
      }
  }
  class Postpromotion{
      public Postpromotion(String link, String description, String photolink) {
          this.link = link;
          this.description = description;
          this.photolink = photolink;
      }

      String link="dbfhd";
      String description="dbfhd",photolink="dbfhd";

      public Postpromotion() {
      }
  }
  class Notification{
      public Notification() {
      }

      String time="dbfhd",body="dbfhd",header="dbfhd";
  }