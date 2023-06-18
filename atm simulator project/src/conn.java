import java.sql.*;
class conn
{
    Connection con;
       Statement s;
   conn()
    {
        try{
Class.forName("com.mysql.cj.jdbc.Driver");

String db_url="jdbc:mysql://localhost:3306/bankmanagementsystem?allowPublicKeyRetrieval=true";
String db_uname="root";
String db_upass="root";

 con=DriverManager.getConnection(db_url,db_uname,db_upass);

 s=con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}