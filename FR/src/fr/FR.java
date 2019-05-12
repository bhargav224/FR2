package fr;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class FR {

    public static void main(String[] args) {

        Transaction tx = null;

        try {

            SessionFactory sf = new Configuration().configure().buildSessionFactory();

            Session session = null;

            Scanner sc = new Scanner(System.in);
//
////            tx=session.beginTransaction();
//
////
////       Recipes r=new Recipes();
////       r.setAmount(100);
////       r.setCalories_per_servings(70);
////       r.setChef_id(201);
////       r.setCook_time(15);
////       r.setDescription("my_recipe");
////       r.setPrep_time(5);
////       r.setRating(5);
////       r.setReady_in(20);
////       r.setTitle("my_sweet");
////       r.setYields(2);
////       r.setRecipe_id("2228");
////
////
////
////       Levels l=new Levels();
////
////       l.setActive(true);
////       l.setDescription("first level");
////
////
////       List<Recipes> list=new ArrayList<Recipes>();
////
////       list.add(r);
////
////       l.setRecipes(list);
////
////
////       r.set
//
//
//
////       tx.commit();
////           System.out.println("data inserted.");
//
//
//
//
//
//
////tx=session.beginTransaction();
//////
//////
//////     Address address=new Address();
//////
//////     address.setCity("vadodara");
//////     address.setCountry("india");
//////     address.setState("gujrat");
//////     address.setStreet_name("new vip");
//////    address.setZip_code(390001);
//////
//////
//////
//////    Grocery_Store gs=new Grocery_Store();
//////
//////    gs.setActive(true);
//////
//////    gs.setName("dmart");
//////
//////
//////      gs.setAddress(address);
//////      address.setGroceryStore(gs);
//////
//////
//////
//////      session.save(address);
//////
//////      tx.commit();
//////
//////           System.out.println("data inserted");
////
////
////
////
////
////
//////            Address add=(Address)session.get(Address.class,2);
//////            System.out.println("...1....");
//////         if(add!=null)
//////         {
//////
//////             tx=session.beginTransaction();
//////
//////              session.delete(add);
//////
//////             tx.commit();
//////
//////             System.out.println("....2.....");
//////         }
//////
//////
////Scanner sc=new Scanner(System.in);
////   int flag=0;
////
////         do {
////
////            System.out.println("select  your option");
////            System.out.println("1)insert  2)update  3) print  4)delete  5)search");
////
////            int choice=sc.nextInt();
////
////            int rid;
////
////            switch(choice)
////            {
////
////                case 1:
////
////
////                          Recipes re=new Recipes();
////
////                          System.out.println("enter recipe_id:");
////                          String id=new Scanner(System.in).next();
////
////                          System.out.println("enter title:");
////                          String tit=new Scanner(System.in).nextLine();
////
////                          System.out.println("enter description:");
////                          String desc=new Scanner(System.in).nextLine();
////
////                          System.out.println("enter prep time:");
////                          int ptime=sc.nextInt();
////
////                          System.out.println("enter cook time:");
////                          int ctime=sc.nextInt();
////
////                          System.out.println("enter ready in:");
////                          int ready=sc.nextInt();
////
////                          System.out.println("enter yields: ");
////                          int yields=sc.nextInt();
////
////                          System.out.println("enter calories:");
////                          int cal=sc.nextInt();
////
////                          System.out.println("enter chef id:");
////                          int cid=sc.nextInt();
////
////                          System.out.println("enter rating: ");
////                          int rating=sc.nextInt();
////
////                          System.out.println("enter amount: ");
////                          double amount=sc.nextDouble();
////
////
////
////
////
////                          tx=session.beginTransaction();
////
////
////
////                          re.setAmount(amount);
////                          re.setCalories_per_servings(cal);
////                          re.setChef_id(cid);
////                          re.setCook_time(ctime);
////                          re.setDescription(desc);
////                          re.setPrep_time(ptime);
////                          re.setRating(rating);
////                          re.setTitle(tit);
////                          re.setYields(yields);
////                          re.setRecipe_id(id);
////
////
////
////
////
////                        Levels level=new Levels();
////
////                         System.out.println("enter desc for level");
////                          String des=sc.next();
////
////                          System.out.println("enter active status for level");
////                          boolean active=sc.nextBoolean();
////
////
////                          level.setActive(active);
////                          level.setDescription(des);
////
////
////
////
////                          System.out.println("....FROM WHICH SIDE YOU WANT TO INSERT DATA.....");
////                          System.out.println("press 0 for MASTER: ");
////                          System.out.println("press 1 for SLAVE: ");
////                          int ch=sc.nextInt();
////
////                          switch(ch)
////                          {
////                              case 0:
////                                         List<Recipes> alist=new ArrayList<Recipes>();
////                                         re.setLevels(level);
////                                         alist.add(re);
////
////
////
////                                         level.setRecipes(alist);
////
////                                       //  session.persist(re);
////
////                                         session.save(level);
////                                           tx.commit();
////                                        System.out.println("data inserted");
////                                        break;
////
////
////
////
////                              case 1:
////                                         re.setLevels(level);
////
////                                        // session.persist(level);
////
////                                         session.save(re);
////                                        tx.commit();
////                                        System.out.println("data inserted");
////                                        break;
////
////                          }
////
//////
//////                          re.setLevels(level);
//////
//////                            session.save(re);
////
////
////
////
////
////                         break;
////
////                case 2:
////
////                    System.out.println("....FROM WHICH SIDE YOU WANT TO UPDATE DATA.....");
////                          System.out.println("press 0 for MASTER: ");
////                          System.out.println("press 1 for SLAVE: ");
////
////
////                          int ch4=sc.nextInt();
////
////                          switch(ch4)
////                          {
////                              case 0:
////                                   try{
////                                       System.out.println("enter level id you want to update data");
////                                       int leid=sc.nextInt();
////
////                                       System.out.println("enter new desc for level: ");
////                                       String ndesc=new Scanner(System.in).nextLine();
////
////                                       Levels l2=(Levels)session.get(Levels.class, leid);
////
////                                       if(l2!=null)
////                                       {
////                                           tx=session.beginTransaction();
////
////                                           l2.setDescription(ndesc);
////
////
////
////                                           tx.commit();
////
////                                           System.out.println("desc updated.");
////                                       }
////
////
////                                      break;
////
////                                   }catch(Exception e){System.out.println("...error in print case 0.."+e.getMessage());}
////
////
////                              case 1:
////                                  try{
////                                       System.out.println("enter recipe_id you want to update data");
////                                    String rcid=new Scanner(System.in).nextLine();
////
////                                System.out.println("enter recipe title for update");
////                                 String title=new Scanner(System.in).nextLine();
////
////                                      System.out.println("enter level_id");
////                                      int lev2=sc.nextInt();
////
////
////
////
////                                         Recipes r=(Recipes)session.get(Recipes.class, rcid);
////
////                                     if(r!=null)
////                                         {
////
////                                            Levels lsobj=(Levels)session.get(Levels.class, lev2);
////
////                                            if(lsobj!=null)
////                                            {
////                                                tx=session.beginTransaction();
////                                        r.setLevels(lsobj);
////                                        r.setTitle(title);
////
////                                           tx.commit();
////
////                                          System.out.println("title updated.");
////                                            }
////                                            else
////                                                 System.out.println("not any level_id in levels table that you want to make fk in recipes");
////
////
////                                            }
////                                     else
////                                          System.out.println("not present data at given key.");
////
////                                      break;
////
////                                  }
////                                   catch(Exception e){System.out.println("...error in print case 0.."+e.getMessage());}
////
////
////                         }
////
////
////
////
////                         break;
////
////
////
////                case 3:
////
////                        System.out.println("....FROM WHICH SIDE YOU WANT TO PRINT DATA.....");
////                          System.out.println("press 0 for MASTER: ");
////                          System.out.println("press 1 for SLAVE: ");
////
////
////                        int ch3=sc.nextInt();
////
////                        switch(ch3)
////                        {
////
////                            case 0:
////
////
////                                    try{
////                                        String hql0="from Levels";
////                                       Query q0=session.createQuery(hql0);
////
////                                    ArrayList<Levels> list=(ArrayList<Levels>)q0.list();
////
////                                    if(list!=null)
////                                    {
////
////                                        for (int i = 0; i < list.size(); i++) {
////                                            System.out.println(list.get(i));
////                                        }
////
////                                    }
////                                     else
////                                        System.out.println("empty table");
////                                } catch(Exception e){System.out.println("...error in print case 0.."+e.getMessage());}
////                                    break;
////
////                            case 1:
////
////
////                                   try{
////                                       System.out.println(".....printing data.........");
////
////                                   String hql="from Recipes";
////                                   Query q=session.createQuery(hql);
////
////                                 ArrayList<Recipes> alist=(ArrayList<Recipes>)q.list();
////
////                                 if(alist!=null)
////                                 {          tx=session.beginTransaction();
////
////                                     for(int i=0;i<alist.size();i++)
////                                        {
////
////                                            Recipes rec=alist.get(i);
////
////                                              System.out.println(rec);
////
////
////
////                                        }
////
////                                               tx.commit();
////
////                                 }
////                                 else
////                                      System.out.println("empty table");
////                                  }
////                                   catch(Exception e){System.out.println("...error in print case 1........."+e.getMessage());}
////                                    break;
////
////                        }
////
////
////
////
////                         break;
////
////
////                case 4:
////
////
////                              System.out.println("....FROM WHICH SIDE YOU WANT TO DELETE  DATA.....");
////                          System.out.println("press 0 for MASTER: ");
////                          System.out.println("press 1 for SLAVE: ");
////                          int ch2=sc.nextInt();
////
////                        switch(ch2)
////                        {
////                      case 0: System.out.println("enter levels id for delete: ");
////                            int lid=sc.nextInt();
////
////                            Levels lev=(Levels)session.get(Levels.class, lid);
////
////                            if(lev!=null)
////                            {
////                                  tx=session.beginTransaction();
////
////                                   lev.preRemove();
////
////                                  session.delete(lev);
////
////                            tx.commit();
////                              System.out.println(lid +" data deleted ");
////                            }
////                            break;
////
////                      case 1:
////                              System.out.println("enter recipe id for delete record");
////                          String rsid=sc.next();
////
////
////                          Recipes r1=(Recipes)session.get(Recipes.class, rsid);
////
////
////                          if(r1!=null){
////                               tx=session.beginTransaction();
////                            session.delete(r1);
////
////                            tx.commit();
////                              System.out.println(rsid +" data deleted ");
////                          }
////                           break;
////
////                        }
////
////
////
////
////                          break;
////
////                case 5:
////
////                         System.out.println("....FROM WHICH SIDE YOU WANT TO  SEARCH  DATA.....");
////                          System.out.println("press 0 for MASTER: ");
////                          System.out.println("press 1 for SLAVE: ");
////                          int ch6=sc.nextInt();
////
////                       switch(ch6)
////                       {
////                           case 0:
////                                      System.out.println("enter level id");
////                                      int levid=sc.nextInt();
////
////                                      Levels ls=(Levels)session.get(Levels.class, levid);
////
////                                      if(ls!=null)
////                                           System.out.println(ls);
////                                      else
////                                          System.out.println("no data available");
////                                      break;
////
////                           case 1:
////                                               System.out.println("enter recipe id for printdata");
////                                            String ris=sc.next();
////
////                                         Recipes rc2=(Recipes)session.get(Recipes.class, ris);
////
////                                         if(rc2!=null)
////                                             System.out.println(rc2);
////                                         else
////                                            System.out.println("no data available");
////                                          break;
////                       }
////
////
////                          break;
////
////
////
////
////
////
////
////            }//master switch
////
////
////             System.out.println(" DO YOU WANT TO CONTINUE");
////             System.out.println("press 1 for YES");
////             System.out.println("press 0 for NO");
////             flag=sc.nextInt();
////
////       }while(flag!=0);
//
//
//
//
//
//int opt=0;
//
//do{
//
//      System.out.println("select  your option");
//   System.out.println("1)insert  2) print 3)update  4)delete  5)search");
//
//   int choice=sc.nextInt();
//
//
//   switch(choice)
//   {
//       case 1:
//
//
//                             System.out.println("enter street_name:  ");
//                             String sn=new Scanner(System.in).nextLine();
//
//                             System.out.println("enter city: ");
//                             String city=new Scanner(System.in).nextLine();
//
//                             System.out.println("enter zip_code: ");
//                             int zip=new Scanner(System.in).nextInt();
//
//                             System.out.println("enter state: ");
//                             String state=new Scanner(System.in).nextLine();
//
//                             System.out.println("enter country: ");
//                             String con=new Scanner(System.in).nextLine();
//
//                             Address address=new Address();
//
//                             address.setStreet_name(sn);
//                             address.setCity(city);
//                             address.setCountry(con);
//                             address.setZip_code(zip);
//                             address.setState(state);
//
//
//
//                             System.out.println("enter grocery name:  ");
//                             String gn=new Scanner(System.in).nextLine();
//
//                             System.out.println("enter active status: ");
//                             boolean active=new Scanner(System.in).nextBoolean();
//
//                             Grocery_Store gs=new Grocery_Store();
//
//                             gs.setActive(active);
//                             gs.setName(gn);
//
//
//
//
//
//
//
//
//                 System.out.println("....FROM WHICH SIDE YOU WANT TO INSERT DATA.....");
//                 System.out.println("press 0 for MASTER: ");
//                 System.out.println("press 1 for SLAVE: ");
//                 int ch=sc.nextInt();
//
//
//                 switch(ch)
//                 {
//                     case 0:
//                               address.setGroceryStore(gs);
//                               gs.setAddress(address);
//
//                              tx=session.beginTransaction();
//
//                              session.save(address);
//
//                              tx.commit();
//                              System.out.println("*********...........data inserted.......***************");
//                              break;
//
//                     case 1:
//                               address.setGroceryStore(gs);
//                               gs.setAddress(address);
//
//                              tx=session.beginTransaction();
//
//                              session.save(gs);
//
//                              tx.commit();
//                              System.out.println("*********...........data inserted.......***************");
//                              break;
//
//                 }
//
//
//                   break;
//       case 2:
//                 System.out.println("....FROM WHICH SIDE YOU WANT TO PRINT DATA.....");
//                 System.out.println("press 0 for MASTER: ");
//                 System.out.println("press 1 for SLAVE: ");
//
//
//               int ch2=sc.nextInt();
//
//
//               switch(ch2)
//               {
//                   case 0:
//                           System.out.println("...********.....printing data...........*********....");
//                           String hqlx="from Address";
//                           Query qx=session.createQuery(hqlx);
//                           ArrayList<Address> alistx=(ArrayList<Address>)qx.list();
//
//                           for (int i = 0; i <alistx.size(); i++)
//                           {
//                               System.out.println(alistx.get(i));
//
//                           }
//                           break;
//
//
//                   case 1:
//                           System.out.println("...********.....printing data...........*********....");
//                           String hql2="from Grocery_Store";
//
//                           Query q2=session.createQuery(hql2);
//                           ArrayList<Address> alist2=(ArrayList<Address>)q2.list();
//
//                           for (int i = 0; i <alist2.size(); i++)
//                           {
//                               System.out.println(alist2.get(i));
//
//                           }
//                           break;
//
//
//
//               }
//                   break;
//
//       case 3:
//                 System.out.println("....FROM WHICH SIDE YOU WANT TO UPDATE DATA.....");
//                 System.out.println("press 0 for MASTER: ");
//                 System.out.println("press 1 for SLAVE: ");
//
//                 int ch3=sc.nextInt();
//
//                 switch(ch3)
//                 {
//                     case 0:
//                              System.out.println("enter address id for update data: ");
//                              int aid=sc.nextInt();
//
//                              System.out.println("enter new city name: ");
//                              String cty=new Scanner(System.in).nextLine();
//
//
//
//
//
//                              Address add=(Address)session.get(Address.class, aid);
//
//
//
//
//                              if(add!=null)
//                              {
//                                  tx=session.beginTransaction();
//
//
//                                  add.setCity(cty);
//
//
//
//                                  tx.commit();
//                                  System.out.println("*************........data updated.......**********");
//
//                              }
//                              else System.out.println("********......no data prasent.......*******");
//                              break;
//
//                     case 1:
//                              System.out.println("enter grocery id: ");
//                              int gsid=new Scanner(System.in).nextInt();
//
//
//                              System.out.println("enter new name for store: ");
//                               String gsname=new Scanner(System.in).nextLine();
//
//
//                                System.out.println("enter new address id for update data: ");
//                              int adid=sc.nextInt();
//
//                               Grocery_Store gstore=(Grocery_Store)session.get(Grocery_Store.class, gsid);
//
//
//
//                                Address addr=(Address)session.get(Address.class, adid);
//
//
//                               if(gstore!=null)
//                               {
//                                   if(addr!=null)
//                                   {
//                                   tx=session.beginTransaction();
//
//                                       gstore.setName(gsname);
//                                        gstore.setAddress(addr);
//
//
//
//                                  tx.commit();
//                                   System.out.println("*************........data updated.......**********");
//
//                                   }
//                                   else     System.out.println("*******......no data available........*********");
//                               }
//                               else System.out.println("*******......no data available........*********");
//
//                               break;
//
//
//                 }
//                       break;
//
//       case 4:
//                  System.out.println("....FROM WHICH SIDE YOU WANT TO DELETE DATA.....");
//                 System.out.println("press 0 for MASTER: ");
//                 System.out.println("press 1 for SLAVE: ");
//
//                 int ch4=sc.nextInt();
//
//
//                 switch(ch4)
//                 {
//                     case 0:
//                              System.out.println("enter address id for delete data: ");
//
//                              int adsid=sc.nextInt();
//
//                              Address addrs=(Address)session.get(Address.class, adsid);
//
//                              if(addrs!=null)
//                              {
//                                  tx=session.beginTransaction();
//
//
//                                  addrs.preRemove();
//
//                                  session.delete(addrs);
//
//                                  tx.commit();
//                                  System.out.println("********......data deleted.......********");
//                              }
//                              else
//                                  System.out.println("***********......no data available.....*******");
//                              break;
//
//
//                     case 1:
//                            System.out.println("enter grocery_store id for delete: ");
//                            int gsid=sc.nextInt();
//
//                                Grocery_Store gstore=(Grocery_Store)session.get(Grocery_Store.class, gsid);
//
//                                if(gstore!=null)
//                                {
//                                     tx=session.beginTransaction();
//
//                                  session.delete(gstore);
//
//                                  tx.commit();
//                                   System.out.println("********......data deleted.......********");
//                                }
//                                else
//                                    System.out.println("***********......no data available.....*******");
//                                 break;
//                 }
//
//
//                   break;
//
//
//       case 5:
//                    System.out.println("....FROM WHICH SIDE YOU WANT TO SEARCH DATA.....");
//                 System.out.println("press 0 for MASTER: ");
//                 System.out.println("press 1 for SLAVE: ");
//
//                 int ch5=sc.nextInt();
//
//
//                 switch(ch5)
//                 {
//                     case 0:
//                                    System.out.println("enter address id for search: ");
//                                    int addid=sc.nextInt();
//
//                                     Address addrs=(Address)session.get(Address.class, addid);
//
//                              if(addrs!=null)
//                              {
//                                  System.out.println(addrs);
//                              }
//                              else System.out.println("*******.......no data present........********");
//                              break;
//
//
//                     case 1:
//                               System.out.println("enter grocery id for search:  ");
//                               int grid=sc.nextInt();
//
//                                Grocery_Store gstore=(Grocery_Store)session.get(Grocery_Store.class, grid);
//
//                                if(gstore!=null)
//                                {
//                                    System.out.println(gstore);
//                                }
//
//                               break;
//
//                 }
//                  break;
//
//   }//master switch
//
//
//
//
//
//
//
//
//
//     System.out.println(" DO YOU WANT TO CONTINUE");
//    System.out.println("press 1 for YES");
//    System.out.println("press 0 for NO");
//    opt=sc.nextInt();
//
//}while(opt!=0);

//session=sf.openSession();
//int option=0;
//do{
//               System.out.println("select  your option");
//            System.out.println("1)insert  2)update  3) print  4)delete  ");
//
//            int choice=sc.nextInt();
//            
//            
//            
//        switch(choice)
//        {
//            case 1:     
//                         Recipes res=new Recipes();
//
//                          System.out.println("enter recipe_id:");
//                          String id=new Scanner(System.in).next();
//
//                          System.out.println("enter title:");
//                          String tit=new Scanner(System.in).nextLine();
//
//                          System.out.println("enter description:");
//                          String desc=new Scanner(System.in).nextLine();
//
//                          System.out.println("enter prep time:");
//                          int ptime=sc.nextInt();
//
//                          System.out.println("enter cook time:");
//                          int ctime=sc.nextInt();
//
//                          System.out.println("enter ready in:");
//                          int ready=sc.nextInt();
//
//                          System.out.println("enter yields: ");
//                          int yields=sc.nextInt();
//
//                          System.out.println("enter calories:");
//                          int cal=sc.nextInt();
//
//                          System.out.println("enter chef id:");
//                          int cid=sc.nextInt();
//
//                          System.out.println("enter rating: ");
//                          int rating=sc.nextInt();
//
//                          System.out.println("enter amount: ");
//                          double amount=sc.nextDouble();
//                          
//                          
//                          
//                         // tx=session.beginTransaction();
//
//                          res.setAmount(amount);
//                          res.setCalories_per_servings(cal);
//                          res.setChef_id(cid);
//                          res.setCook_time(ctime);
//                          res.setDescription(desc);
//                          res.setPrep_time(ptime);
//                          res.setRating(rating);
//                          res.setTitle(tit);
//                          res.setYields(yields);
//                          res.setRecipe_id(id);
//                          
//                          
//                          Recipe_Step rsatep=new Recipe_Step();
//                          
//                          System.out.println("enter recipe step name:  ");
//                          String stname=new Scanner(System.in).nextLine();
//                          
//                           System.out.println("enter recipe step instruction:  ");
//                          String ins=new Scanner(System.in).nextLine();
//                          
//                          
//                           System.out.println("enter recipe step image path:  ");
//                          String pathx=new Scanner(System.in).nextLine();
//                          
//                          
//                          rsatep.setInstruction(ins);
//                          rsatep.setName(stname);
//                          rsatep.setPath(pathx);
//                         
//                          
//                         System.out.println("....FROM WHICH SIDE YOU WANT TO INSERT DATA.....");
//                        System.out.println("press 0 for MASTER(Recipe_Step): ");
//                        System.out.println("press 1 for MASTER(Recipes): "); 
//                         System.out.println("press 2 for MIDDLE(Recipe_Steps): "); 
//                         
//                         int op=sc.nextInt();
//                         
//                         switch(op)
//                         {
//                             case 0: 
//                                       session=sf.openSession();
//                                     tx=session.beginTransaction();
//                                      ArrayList<Recipe_Steps> list=new ArrayList<Recipe_Steps>();
//                                     
//                                     Recipe_Steps rss=new Recipe_Steps();
//                                    
//                                     list.add(rss);
//                                     
//                                     rss.setRecipes(res);
//                                     rss.setRecipe_step(rsatep);
//                                     
//                                     
//                                     
//                                       rsatep.setRecipe_steps(list);
//                                       
//                                       session.save(rsatep);
//                                       
//                                       tx.commit();
//                                       session.close();
//                                        System.out.println("*******......data inserted......******");
//                                       break;
//                             case 1: 
//                                    session=sf.openSession();
//                                      tx=session.beginTransaction();
//                                       ArrayList<Recipe_Steps> list1=new ArrayList<Recipe_Steps>();
//                                     
//                                     Recipe_Steps rss1=new Recipe_Steps();
//                                      
//                                     rss1.setRecipe_step(rsatep);
//                                     rss1.setRecipes(res);
//                                     
//                                     res.setRecipe_steps(list1);
//                                      
//                                     session.save(res);
//                                      
//                                      tx.commit();
//                                          session.close();                                
//                                      System.out.println("*******......data inserted......******");
//                                      break;
//                                      
//                                      
//                             case 2:
//                                    session=sf.openSession();
//                                    tx=session.beginTransaction();
//                                    
//                                     Recipe_Steps rss2=new Recipe_Steps();
//                                     
//                                     rss2.setRecipe_step(rsatep);
//                                     rss2.setRecipes(res);
//                                     
//                                     session.save(rss2);
//                                    
//                                    
//                                    tx.commit();
//                                     session.close();
//                                    System.out.println("*******......data inserted......******");
//                                    break;
//                         }
//                         
//                          break;
//                          
//                          
//                          
//            case 2:
//                
//                      System.out.println("....FROM WHICH SIDE YOU WANT TO UPDATE DATA.....");
//                        System.out.println("press 0 for MASTER(Recipe_Step): ");
//                        System.out.println("press 1 for MASTER(Recipes): "); 
//                         System.out.println("press 2 for MIDDLE(Recipe_Steps): "); 
//                         
//                         int op2=sc.nextInt();
//                     
//                         switch(op2)
//                         {
//                             case 0:
//                                 
//                                    System.out.println("enter recipe_step id for update: ");
//                                    int nid=sc.nextInt();
//                                 
//                                     System.out.println("enter new name for recipe_step: ");
//                                     String nn=new Scanner(System.in).nextLine();
//                                     
//                                     session=sf.openSession();
//                                     tx=session.beginTransaction();
//                                     
//                                     
//                                     Recipe_Step rst=(Recipe_Step)session.get(Recipe_Step.class, nid);
//                                     
//                                     if(rst!=null)
//                                     {
//                                         rst.setName(nn); 
//                                     
//                                     tx.commit();
//                                     session.close();
//                                     System.out.println("**********......data updated........********");
//                                     }
//                                     break;
//                                     
//                           case 1:
//                                    System.out.println("enter recipe_id for update: ");
//                                    String nid2=new Scanner(System.in).nextLine();
//                                   
//                                    System.out.println("enter new title for recipes: ");
//                                     String nn2=new Scanner(System.in).nextLine();
//                                     
//                                       session=sf.openSession();
//                                     
//                                     Recipes rcip=(Recipes)session.get(Recipes.class, nid2);
//                                     
//                                     if(rcip!=null)
//                                     {
//                                        
//                                         tx=session.beginTransaction();
//                                         rcip.setTitle(nn2);
//                                         
//                                         tx.commit();
//                                         session.close();
//                                     System.out.println("**********......data updated........********");
//                                     }
//             
//                                     
//                                     break;
//                                     
//                                     
//                           case 2:
//                               
//                                      System.out.println("enter recipe_steps id: ");
//                                      int rssid=sc.nextInt();
//                                      
//                                       session=sf.openSession();
//                                      
//                                      Recipe_Steps rsts=(Recipe_Steps)session.get(Recipe_Steps.class, rssid);
//                                   
//                                     System.out.println("enter new recipe_id: ");
//                                     String nn3=new Scanner(System.in).nextLine();
//                                     
//                                     System.out.println("enter new recipe_step_id: ");
//                                     int nn4=sc.nextInt();
//                                     
//                                     
//                                     
//                                     
//                                     Recipe_Step rstap3=(Recipe_Step)session.get(Recipe_Step.class, nn4);
//                                     Recipes rps=(Recipes)session.get(Recipes.class, nn3);
//                                     
//                                     if(rsts!=null)
//                                     { 
//                                     if(rstap3!=null && rps!=null)
//                                     {
//                                        
//                                          tx=session.beginTransaction();
//                            
//                                           rsts.setRecipe_step(rstap3);
//                                           rsts.setRecipes(rps);
//                                           
//                                           tx.commit();
//                                           session.close();
//                                         System.out.println("**********......data updated........********");
//                                         
//                                     }
//                                     }
//                                     break;
//                                   
//                                     
//                         }
//                         
//                         
//                       break;
//                       
//                       
//            case 3:
//                      System.out.println("**********........printin data..........**************");
//                       session=sf.openSession();
//                      
//                      String hq="from Recipes";
//                      String hq2="from Recipe_Step";
//                      String hq3="from Recipe_Steps";
//                      
//                      Query q=session.createQuery(hq);
//                      ArrayList<Recipes> rlist=(ArrayList<Recipes>)q.list();
//                      
//                      
//                      Query q2=session.createQuery(hq2);
//                      ArrayList<Recipe_Step> rslist=(ArrayList<Recipe_Step>)q2.list();
//                      
//                      Query q3=session.createQuery(hq3);
//                      ArrayList<Recipe_Steps> rsslist=(ArrayList<Recipe_Steps>)q3.list();
//                      
//                      System.out.println("**********.......Recipes data......*************");
//                      for(int i=0;i<rlist.size();i++)
//                      {
//                            System.out.println(rlist.get(i));
//                      }
//                      
//                       System.out.println("**********.......Recipe_Step data......*************");
//                      for(int i=0;i<rslist.size();i++)
//                      {
//                            System.out.println(rslist.get(i));
//                      }
//                      
//                       System.out.println("**********.......Recipe_Steps data......*************");
//                      for(int i=0;i<rsslist.size();i++)
//                      {
//                            System.out.println(rsslist.get(i));
//                      }
//                      
//                      
//                      session.close();
//                       break;
//                       
//                       
//                       
//            case 4:
//                         System.out.println("....FROM WHICH SIDE YOU WANT TO DELETE DATA.....");
//                        System.out.println("press 0 for MASTER(Recipe_Step): ");
//                        System.out.println("press 1 for MASTER(Recipes): "); 
//                         System.out.println("press 2 for MIDDLE(Recipe_Steps): ");
//                         
//                         int op5=sc.nextInt();
//                         
//                         switch(op5)
//                         {
//                             case 0:
//                                     System.out.println("enter recipe_step_id for delete: ");
//                                     int repid=sc.nextInt();
//                                     
//                                       session=sf.openSession();
//                                      Recipe_Step rstap3=(Recipe_Step)session.get(Recipe_Step.class, repid);
//                                      
//                                      if(rstap3!=null)
//                                      {
//                                          
//                                        
//                                          tx=session.beginTransaction();
//                                          
//                                          rstap3.preRemove();
//                                          session.delete(rstap3);
//                                          tx.commit();
//                                         
//                                          session.close();
//                                          System.out.println("******.......data deleted....*******");
//                                      }
//                                      break;
//                                   
//                             case 1:
//                                 try{
//                                     System.out.println("enter recipe_id for delete: ");
//                                      String recpid=new Scanner(System.in).nextLine();
//                                     
//                                     session=sf.openSession();
//                                     
//                                      Recipes rs3=(Recipes)session.get(Recipes.class, recpid);
//                                      System.out.println(".....1......."+rs3);
//                                      if(rs3!=null)
//                                      {
//                                          tx=session.beginTransaction();
//                                          System.out.println(".....10....");
//                                          rs3.preRemove();
//                                          System.out.println(".......2.....");
//                                          session.delete(rs3);
//                                          System.out.println("....3.......");
//                                          tx.commit();
//                                        
//                                          session.close();
//                                          System.out.println("******.......data deleted....*******");
//                                      }
//                                 }catch (Exception ex) {
//                                     System.out.println("......errror...."+ex.getMessage());
//                                 } 
//                                      break;
//                                      
//                                      
//                             case 2:
//                                     System.out.println("enter recipe_step_id: ");
//                                     int rsepid=sc.nextInt();
//                                      session=sf.openSession();
//                                     Recipe_Steps ris=(Recipe_Steps)session.get(Recipe_Steps.class, rsepid);
//                                     
//                                     if(ris!=null)
//                                     {
//                                          tx=session.beginTransaction();
//                                          
//                                          session.delete(ris);
//                                          tx.commit();
//                                          
//                                          session.close();
//                                          System.out.println("******.......data deleted....*******");
//                                     }
//                                      break;
//                         }
//                         break;
//        }
//            
//            
//            
//            
//            
//            
//            
//            
//            
//            
//            
//    
//    
//    
//    
//     System.out.println(" DO YOU WANT TO CONTINUE");
//    System.out.println("press 1 for YES");
//    System.out.println("press 0 for NO");
//    option=sc.nextInt();
//}while(option!=0);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
            //   session.close();
            sf.close();

        } catch (Exception ex) {
            System.out.println("..................");
            System.out.println("....error....." + ex.getMessage());
            System.out.println(".................");
        }

    }

}
