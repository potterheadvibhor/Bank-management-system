import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
class fast_cash extends JFrame implements ActionListener
{
     Font f=new Font("Arial Black",Font.BOLD,15);
     Font f1=new Font("Arial Black",Font.BOLD,10);
    JLabel backgroundImage,Select_Withdrawl_amount;
    ImageIcon mainframe1;
    JButton Hundred,fivehundred,onethousands,twothousand,fivethousands,tenthoushand,EXIT,ABOUT_US;   
String pinnumber;
String fastcashdeposited;
int valid=0;
fast_cash(String pinnumber)
{
    this.pinnumber=pinnumber;
         System.out.println("Fast cash A"+pinnumber);

     setLayout(null);
    setTitle("Fast Cash");
   
 mainframe1=new ImageIcon("atm.jpg");
Image reset1=mainframe1.getImage();
reset1=reset1.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
mainframe1=new ImageIcon(reset1);
backgroundImage=new JLabel(mainframe1);
backgroundImage.setBounds(1, 1, 700, 700);
add(backgroundImage);

Select_Withdrawl_amount=new JLabel("Select The Withdrawl Amount");
Select_Withdrawl_amount.setBounds(130,220,290,30);
Select_Withdrawl_amount.setForeground(Color.WHITE);
Select_Withdrawl_amount.setFont(f);
backgroundImage.add(Select_Withdrawl_amount);

Hundred=new JButton("100");
Hundred.setBounds(120, 315, 120, 28);
Hundred.setBackground(Color.BLACK);
Hundred.setForeground(Color.WHITE);
backgroundImage.add(Hundred);
fivehundred=new JButton("500");
fivehundred.setBounds(120, 345, 120, 28);
fivehundred.setBackground(Color.BLACK);
fivehundred.setForeground(Color.WHITE);
backgroundImage.add(fivehundred);
onethousands=new JButton("1000");
onethousands.setBounds(120, 375, 120, 28);
onethousands.setBackground(Color.BLACK);
onethousands.setForeground(Color.WHITE);
backgroundImage.add(onethousands);
twothousand=new JButton("2000");
twothousand.setBounds(120, 405, 120, 28);
twothousand.setBackground(Color.BLACK);
twothousand.setForeground(Color.WHITE);
twothousand.setFont(f1);
backgroundImage.add(twothousand);
fivethousands=new JButton("5000");
fivethousands.setBounds(285, 315, 120, 28);
fivethousands.setBackground(Color.BLACK);
fivethousands.setForeground(Color.WHITE);
backgroundImage.add(fivethousands);
tenthoushand=new JButton("10000");
tenthoushand.setBounds(285, 345, 120, 28);
tenthoushand.setBackground(Color.BLACK);
tenthoushand.setForeground(Color.WHITE);
backgroundImage.add(tenthoushand);
EXIT=new JButton("EXIT");
EXIT.setBounds(285, 375, 120, 28);
EXIT.setBackground(Color.BLACK);
EXIT.setForeground(Color.WHITE);
backgroundImage.add(EXIT);


EXIT.addActionListener(this);
Hundred.addActionListener(this);
fivehundred.addActionListener(this);
onethousands.addActionListener(this);
twothousand.addActionListener(this);
fivethousands.addActionListener(this);
tenthoushand.addActionListener(this);


 setVisible(true);


   setBounds(400,100,700,700);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);

}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==EXIT)
    {
        dispose();
                new mainframe(pinnumber).setVisible(true);

    }

    else{
String amount =((JButton)e.getSource()).getText();
System.out.println(amount);
try{
    conn c=new conn();
    ResultSet rs=c.s.executeQuery("Select * from bank where PIN_NUMBER='"+pinnumber+"' ");
int balance =0;
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
}
System.out.println("Final Balance " +balance);
if(e.getSource() != EXIT && balance<Integer.parseInt(amount))
{
    JOptionPane.showMessageDialog(null,"Insufficent Balance");
    return;
}
Date date=new Date();
String q="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
c.s.executeUpdate(q);
    JOptionPane.showMessageDialog(null,amount +" Withdrawl Succesfully");
dispose();
new mainframe(pinnumber).setVisible(true);
}catch(Exception exc)
{
System.out.println(exc);
}
    }
}
public static void main(String []args)
{
 
fast_cash fc=new fast_cash("");

}    
}
