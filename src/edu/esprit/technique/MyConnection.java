package edu.esprit.technique;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


 
public class MyConnection {

     public static Connection myinstance=null;
     String url;
     String username;
     String password;
     Properties prop;
    
    private MyConnection()
  {
   prop=new Properties();
       try {
           prop.load(new FileInputStream("Config.properties"));
           url =prop.getProperty("url");
           username=prop.getProperty("username");
           password=prop.getProperty("password");
          
       } catch (IOException ex) {
           Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
         try {
             myinstance=DriverManager.getConnection(url, username, password);
             System.out.println("Connexion etablie");
         } catch (SQLException ex) {
             Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
         }

  }
  
  public static Connection getInstance(){
      if(myinstance==null)
     new MyConnection();
      return myinstance;
  }
  
}
