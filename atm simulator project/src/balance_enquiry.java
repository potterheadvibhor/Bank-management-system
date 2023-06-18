import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.*;

class balance_enquiry extends JFrame implements ActionListener


{
        
   
    JLabel backgroundImage,BALANCE_AVALABEL;
ImageIcon mainframe1;
JButton DEPOSIT,BACK;
JTextField depositTextField;
Font f2=new Font("Arial Black",Font.BOLD,10);
String pinnumber;
int balance =0;
    balance_enquiry(String pinnumber)
    {

        this.pinnumber=pinnumber; 
System.out.println("Balance Enquiry A"+pinnumber);
    setLayout(null);
    setTitle("Balance Enquiry");

mainframe1=new ImageIcon("atm.jpg");
Image reset1=mainframe1.getImage();
reset1=reset1.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
mainframe1=new ImageIcon(reset1);
backgroundImage=new JLabel(mainframe1);
backgroundImage.setBounds(1, 1, 700, 700);
add(backgroundImage);

    try{
    conn c=new conn();
    ResultSet rs=c.s.executeQuery("Select * from bank where PIN_NUMBER='"+pinnumber+"' ");

while(rs.next())
{
if(rs.getString("TYPE_of_Transaction").equals("Deposite"))
{
    balance +=Integer.parseInt(rs.getString("AMOUNT"));  
    System.out.println(balance);

}
else {
        balance -=Integer.parseInt(rs.getString("AMOUNT"));  
            System.out.println(balance);

}
}}catch(Exception exc)
{
    System.out.println(exc);
}
System.out.println("Final Balance " +balance);

BALANCE_AVALABEL=new JLabel("Balance Available in your Account " +balance);
BALANCE_AVALABEL.setBounds(124,220,290,30);
BALANCE_AVALABEL.setForeground(Color.WHITE);
BALANCE_AVALABEL.setFont(f2);
backgroundImage.add(BALANCE_AVALABEL);


BACK=new JButton("Exit");
BACK.setBounds(285, 405, 120, 28);
BACK.setBackground(Color.BLACK);
BACK.setForeground(Color.WHITE);
add(BACK);


BACK.addActionListener(this);




      setBounds(400,100,700,700);
setResizable(false);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
      public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==BACK)
    {
        dispose();
        new mainframe(pinnumber).setVisible(true);
    }}

    public static void main(String []args)
    {
      balance_enquiry be=new balance_enquiry("");
  
    }}