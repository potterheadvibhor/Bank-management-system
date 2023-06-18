import java.sql.*;
import java.util.Scanner;
class createdb
{
    public static void main(String []args)
    {
       Scanner sc=new Scanner(System.in);
System.out.println("enter name");
        String s1=sc.nextLine();
       Scanner sc2=new Scanner(System.in);
System.out.println("enter rollno");
       String s2=sc2.nextLine();
       
        try{
Class.forName("com.mysql.cj.jdbc.Driver");

String db_url="jdbc:mysql://localhost:3306/hello1?allowPublicKeyRetrieval=true";
String db_uname="root";
String db_upass="root";

Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);

Statement st=con.createStatement();
String q="insert into h1 values('"+s1+"','"+s2+"')";
st.executeUpdate(q);
System.out.println("data inserted....");

con.close();


        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}