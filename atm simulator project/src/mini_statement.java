import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


class mini_statement extends JFrame implements ActionListener
{
JLabel bank_name,card_number,transactions,thanks;
JButton EXIT;
Font f=new Font("Arial Black",Font.BOLD,15);
Font f1=new Font("Arial Black",Font.BOLD,13);
Font f2=new Font("Arial Black",Font.BOLD,10);
String pinnumber;
int y=160;
int count=0;
mini_statement (String pinnumber)
{
    this.pinnumber=pinnumber;
    setTitle("MINI Statement");
setLayout(null);
setVisible(true);
setBackground(Color.WHITE);
setForeground(Color.BLACK);
setBounds(20,80,350,500);
setResizable(false);

bank_name=new JLabel("WIZCRAFT BANK");
bank_name.setBounds(100, 20, 160, 30);
bank_name.setFont(f);
add(bank_name);

thanks=new JLabel("Thanks for banking with us");
thanks.setBounds(60,350, 350, 30);
thanks.setFont(f1);
add(thanks);

EXIT=new JButton("EXIT");
EXIT.setBounds(130,400, 70, 30);
EXIT.setFont(f1);
EXIT.setBackground(Color.BLACK);
EXIT.setForeground(Color.WHITE);
EXIT.setBorderPainted(false);
add(EXIT);
EXIT.addActionListener(this);

try{
conn c=new conn();
String q="select * from login where PIN_NUMBER='"+pinnumber+"' ";
ResultSet rs=c.s.executeQuery(q);
while(rs.next())
{
System.out.println(rs.getString("card_number"));
card_number=new JLabel("Card No:    XXXX-XXXX-XXXX-"+rs.getString("card_number").substring(12));
card_number.setBounds(20, 80, 270, 30);
card_number.setFont(f1);
add(card_number);
}

}
catch(Exception exc)
{
System.out.println(exc);
}
try{

conn c=new conn();
String q1="select * from bank where PIN_NUMBER='"+pinnumber+"' ";
ResultSet rs1=c.s.executeQuery(q1);

while(rs1.next())
{
System.out.println(rs1.getString("DATE")+"  "+rs1.getString("TYPE_of_Transaction")+"  "
     +rs1.getString("AMOUNT"));
transactions=new JLabel("- "+rs1.getString("DATE")+"  "+rs1.getString("TYPE_of_Transaction")+"  "
    +rs1.getString("AMOUNT"));
transactions.setBounds(20, y, 350, 30);
transactions.setFont(f2);
add(transactions);
y=y+20;
count++;

if(count==4)
{
break;
}
}
}
catch(Exception exc)
{
System.out.println(exc);
}
}
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==EXIT)
    {
        dispose();
    }
}
    public static void main(String []args)
    {
new mini_statement("");
    }
}