import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
class mainframe extends JFrame implements ActionListener
{
     Font f=new Font("Arial Black",Font.BOLD,25);
     Font f1=new Font("Arial Black",Font.BOLD,10);
    JLabel backgroundImage,WELCOME;
    ImageIcon mainframe1;
    JButton DPEOSIT,FAST_CASH,PIN_CHANGE,CASH_WITHDRAWL,MIN_STAEMENT,BALANCE_ENQUIRY,EXIT
    ,ABOUT_US;
String pinnumber;

mainframe(String pinnumber){
    this.pinnumber=pinnumber;
         System.out.println("Mainframe A"+pinnumber);

     setLayout(null);
    setTitle("Welcome to Wizcraft ATM");
   
    mainframe1=new ImageIcon("atm.jpg");
Image reset1=mainframe1.getImage();
reset1=reset1.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
mainframe1=new ImageIcon(reset1);
backgroundImage=new JLabel(mainframe1);
backgroundImage.setBounds(1, 1, 700, 700);
add(backgroundImage);


WELCOME=new JLabel("Welcome");
WELCOME.setBounds(205,230,190,30);
WELCOME.setForeground(Color.WHITE);
WELCOME.setFont(f);
backgroundImage.add(WELCOME);

DPEOSIT=new JButton("Deposit");
DPEOSIT.setBounds(120, 315, 120, 28);
DPEOSIT.setBackground(Color.BLACK);
DPEOSIT.setForeground(Color.WHITE);
backgroundImage.add(DPEOSIT);
FAST_CASH=new JButton("Fast Cash");
FAST_CASH.setBounds(120, 345, 120, 28);
FAST_CASH.setBackground(Color.BLACK);
FAST_CASH.setForeground(Color.WHITE);
backgroundImage.add(FAST_CASH);
PIN_CHANGE=new JButton("PIN Change");
PIN_CHANGE.setBounds(120, 375, 120, 28);
PIN_CHANGE.setBackground(Color.BLACK);
PIN_CHANGE.setForeground(Color.WHITE);
backgroundImage.add(PIN_CHANGE);
CASH_WITHDRAWL=new JButton("Cash Withdrawl");
CASH_WITHDRAWL.setBounds(120, 405, 120, 28);
CASH_WITHDRAWL.setBackground(Color.BLACK);
CASH_WITHDRAWL.setForeground(Color.WHITE);
CASH_WITHDRAWL.setFont(f1);
backgroundImage.add(CASH_WITHDRAWL);
MIN_STAEMENT=new JButton("MINI Statement");
MIN_STAEMENT.setBounds(285, 315, 120, 28);
MIN_STAEMENT.setBackground(Color.BLACK);
MIN_STAEMENT.setForeground(Color.WHITE);
backgroundImage.add(MIN_STAEMENT);
BALANCE_ENQUIRY=new JButton("Balance Enq");
BALANCE_ENQUIRY.setBounds(285, 345, 120, 28);
BALANCE_ENQUIRY.setBackground(Color.BLACK);
BALANCE_ENQUIRY.setForeground(Color.WHITE);
backgroundImage.add(BALANCE_ENQUIRY);
EXIT=new JButton("EXIT");
EXIT.setBounds(285, 375, 120, 28);
EXIT.setBackground(Color.BLACK);
EXIT.setForeground(Color.WHITE);
backgroundImage.add(EXIT);
ABOUT_US=new JButton("About us");
ABOUT_US.setBounds(285, 405, 120, 28);
ABOUT_US.setBackground(Color.BLACK);
ABOUT_US.setForeground(Color.WHITE);
backgroundImage.add(ABOUT_US);


EXIT.addActionListener(this);
DPEOSIT.addActionListener(this);
CASH_WITHDRAWL.addActionListener(this);
FAST_CASH.addActionListener(this);
PIN_CHANGE.addActionListener(this);
BALANCE_ENQUIRY.addActionListener(this);
MIN_STAEMENT.addActionListener(this);

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
    logingpage.main(null);
}

else if(e.getSource()==DPEOSIT)
{
    setVisible(false);
    System.out.println("Mainframe Deposit "+pinnumber);

 new deposit(pinnumber).setVisible(true);
   
}
if(e.getSource()==CASH_WITHDRAWL)
{
    dispose();
    System.out.println("Mainframe Withdrawl "+pinnumber);
    new cashwidrawl(pinnumber).setVisible(true);
}
if(e.getSource()==FAST_CASH)
{
    dispose();
    System.out.println("Mainframe fastcash "+pinnumber);
    new fast_cash(pinnumber).setVisible(true);
}
if(e.getSource()==PIN_CHANGE)
{
    dispose();
    System.out.println("Mainframe pinchanhge "+pinnumber);
    new change_pin(pinnumber).setVisible(true);
}
if(e.getSource()==BALANCE_ENQUIRY)
{
    dispose();
    System.out.println("Mainframe pinchanhge "+pinnumber);
    new balance_enquiry(pinnumber).setVisible(true);
}
if(e.getSource()==MIN_STAEMENT)
{
    
    System.out.println("Mainframe MIN_STATEMENT "+pinnumber);
    new mini_statement(pinnumber).setVisible(true);
}

}
public static void main(String []args)
{
 
mainframe mf=new mainframe("");

}    
}
