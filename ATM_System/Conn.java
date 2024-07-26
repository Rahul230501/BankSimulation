package ATM_System;
import java.sql.*;

public class Conn { //class to conect jdbc
    //steps
    //1.Register the Driver
    //2.Create connection
    //3.Create Statement
    //4.Execute Query
    //5.Close Connection

    Connection c; // globally initialization of variable
    Statement s;
    public Conn(){
        try{

            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root" ,"root");  // Creating connection
            s=c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
