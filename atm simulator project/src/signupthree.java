import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.plaf.ColorUIResource;
class signupthree extends JFrame implements ActionListener
{
    Font f=new Font("Arial Black",Font.BOLD,25);
    Font f1=new Font("Arial Narrow",Font.BOLD,17);
    Font f2=new Font("Arial Narrow",Font.BOLD,15);
    Font f3=new Font("Arial Narrow",Font.BOLD,13);
    JLabel FORMNO,Account_Details,Account_type,card_no,pin,services_reqired,logo;
    JButton submit,cancel;
    ImageIcon lg;
     Color c=new Color(0,102,102);
    JRadioButton savings_account,fixed_account,current_account,recuring_account;
    ButtonGroup bg=new ButtonGroup();
    String cardnumber,pinno,facility="";
    int for_declaration=1,forminput;
    String formno;
    JCheckBox atm_card,internet_banking,mobile_banking,email_alerts,cheque_book,estatement,declaration;
    signupthree(String formno)
    {
        System.out.println("A"+formno);
        this.formno=formno;
setLayout(null);
setTitle("NEW ACCOUNT APPLICATION FORM PAGE 3");
lg=new ImageIcon("logo.png");
Image reset=lg.getImage();
reset=reset.getScaledInstance(50, 90, java.awt.Image.SCALE_SMOOTH);
lg=new ImageIcon(reset);  
logo=new JLabel(lg);
logo.setBounds(80, 10, 120, 100);
add(logo);



FORMNO=new JLabel("Form No: "+formno);
FORMNO.setBounds(530, 8, 300, 30);
FORMNO.setFont(f1);
FORMNO.setForeground(Color.BLACK);
add(FORMNO);
Account_Details=new JLabel("Page 3:Account Details");
Account_Details.setBounds(180, 10, 700, 90);
Account_Details.setFont(f);
Account_Details.setForeground(Color.BLACK);
add(Account_Details);
Account_type=new JLabel("Account Type:");
Account_type.setBounds(80, 120, 180, 30);
Account_type.setFont(f1);
Account_type.setForeground(Color.BLACK);
add(Account_type);
savings_account=new JRadioButton("Saving Account");
savings_account.setBounds(90, 150, 180, 30);
savings_account.setFont(f2);
savings_account.setForeground(Color.BLACK);
savings_account.setBackground(c);
bg.add(savings_account);
add(savings_account);
fixed_account=new JRadioButton("Fixed Deposit Account");
fixed_account.setBounds(300, 150, 180, 30);
fixed_account.setFont(f2);
fixed_account.setForeground(Color.BLACK);
bg.add(fixed_account);
fixed_account.setBackground(c);
add(fixed_account);
current_account=new JRadioButton("Current Account");
current_account.setBounds(90, 180, 180, 30);
current_account.setFont(f2);
current_account.setForeground(Color.BLACK);
bg.add(current_account);
current_account.setBackground(c);
add(current_account);
recuring_account=new JRadioButton("Recurring Deposit Account");
recuring_account.setBounds(300, 180, 240, 30);
recuring_account.setFont(f2);
recuring_account.setForeground(Color.BLACK);
bg.add(recuring_account);
recuring_account.setBackground(c);
add(recuring_account);
card_no=new JLabel("Card Number:");
card_no.setBounds(80, 230, 180, 30);
card_no.setFont(f1);
card_no.setForeground(Color.BLACK);
add(card_no);
card_no=new JLabel("xxxx-xxxx-xxxx-4184");
card_no.setBounds(300, 230, 240, 30);
card_no.setFont(f1);
card_no.setForeground(Color.BLACK);
add(card_no);
card_no=new JLabel("(Your 16-digit Card number)");
card_no.setBounds(80, 255, 250, 20);
card_no.setFont(f3);
card_no.setForeground(Color.BLACK);
add(card_no);
card_no=new JLabel("(It would appear on ATM Card/Cheque Book and Statement)");
card_no.setBounds(300, 255, 300, 20);
card_no.setFont(f3);
card_no.setForeground(Color.BLACK);
add(card_no);
pin=new JLabel("Pin:");
pin.setBounds(80, 285, 180, 30);
pin.setFont(f1);
pin.setForeground(Color.BLACK);
add(pin);
pin=new JLabel("xxxx");
pin.setBounds(300, 285, 180, 30);
pin.setFont(f1);
pin.setForeground(Color.BLACK);
add(pin);
pin=new JLabel("(4-digit password)");
pin.setBounds(80, 310, 250, 20);
pin.setFont(f3);
pin.setForeground(Color.BLACK);
add(pin);
services_reqired=new JLabel("Service Required:");
services_reqired.setBounds(80, 350, 180, 30);
services_reqired.setFont(f1);
services_reqired.setForeground(Color.BLACK);
add(services_reqired);
atm_card=new JCheckBox("ATM Card");
atm_card.setBounds(90, 390, 180, 30);
atm_card.setFont(f2);
atm_card.setForeground(Color.BLACK);
atm_card.setBackground(c);
add(atm_card);

mobile_banking=new JCheckBox("Mobile Banking");
mobile_banking.setBounds(90, 420, 180, 30);
mobile_banking.setFont(f2);
mobile_banking.setForeground(Color.BLACK);
mobile_banking.setBackground(c);
add(mobile_banking);
internet_banking=new JCheckBox("Internet Banking");
internet_banking.setBounds(300, 390, 180, 30);
internet_banking.setFont(f2);
internet_banking.setForeground(Color.BLACK);
internet_banking.setBackground(c);
add(internet_banking);
email_alerts=new JCheckBox("Email Alerts");
email_alerts.setBounds(300, 420, 180, 30);
email_alerts.setFont(f2);
email_alerts.setForeground(Color.BLACK);
email_alerts.setBackground(c);
add(email_alerts);
cheque_book=new JCheckBox("Checque Book");
cheque_book.setBounds(90, 450, 180, 30);
cheque_book.setFont(f2);
cheque_book.setForeground(Color.BLACK);
cheque_book.setBackground(c);
add(cheque_book);
estatement=new JCheckBox("E-Statements");
estatement.setBounds(300, 450, 180, 30);
estatement.setFont(f2);
estatement.setForeground(Color.BLACK);
estatement.setBackground(c);
add(estatement);
declaration=new JCheckBox("I hereby declares that the above entered details correct to best of my knowledge.");
declaration.setBounds(90, 525, 600, 30);
declaration.setFont(f3);
declaration.setForeground(Color.BLACK);
declaration.setBackground(c);
add(declaration);
submit = new JButton("Submit");
submit.setBounds(220, 560, 100, 30);
submit.setBackground(Color.BLACK);
submit.setForeground(Color.WHITE);
add(submit);
cancel = new JButton("cancel");
cancel.setBounds(340, 560, 100, 30);
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
add(cancel);
submit.addActionListener(this);
cancel.addActionListener(this);
savings_account.addActionListener(this);
fixed_account.addActionListener(this);
current_account.addActionListener(this);
recuring_account.addActionListener(this);

getContentPane().setBackground(c);
        setVisible(true);
        setBounds(400,100,700,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


public void actionPerformed(ActionEvent e)
{
  //  int form_no=0;
String account_type="";
    if(e.getSource()==submit){
        try{
        if(savings_account.isSelected())
        {
account_type="Saving Account";
        }
        if(fixed_account.isSelected())
        {
account_type="Fixed Deposit Account";
        }
        if(current_account.isSelected())
        {
account_type="Currernt Account";
        }
        if(recuring_account.isSelected())
        {
account_type="Recurring Depist Account";
        }
              
            
     if(atm_card.isSelected())
    {
facility=facility + "ATM Card,\n";

    }
    if(internet_banking.isSelected())
    {
facility=facility + "Internet Banking,\n";
    }
	
 if(mobile_banking.isSelected())
    {
facility=facility + "Mobile banking,\n";
}
if(email_alerts.isSelected())
    {
facility=facility + "Email Alerts,\n";
}
if(cheque_book.isSelected())
    {
facility=facility + "Cheque Book,\n";
}
if(estatement.isSelected())
    {
facility=facility + "E-Statement\n";
}
   System.out.println(facility);
   

if(account_type.equals(""))
{
   
    // if(account_type.equals(""))
        JOptionPane.showMessageDialog(null, "Account Type Required");

}
    if(declaration.isSelected())
{
            System.out.println("s3"+formno);

    int max1=99999999;                       // cardno
int min1=10000000;
    long cn=(long)(Math.random()*(max1-min1)+min1);
    cn=cn+5040936000000000l;
    cardnumber=""+cn;

     int max=9999;                          //pin
     int min=1000;
     int p=(int)(Math.random()*(max-min)+min);
    pinno="" +p;
	JOptionPane.showMessageDialog(null, "Card no:"+cardnumber+"\nPIN:"+pinno);
   conn c=new conn();
  String q="insert into signupthree values('"+formno+"','"+account_type+"','"+cardnumber+"','"+pinno+"','"+facility+"')";
  String q1="insert into login values('"+formno+"','"+cardnumber+"','"+pinno+"')";
c.s.executeUpdate(q);
c.s.executeUpdate(q1);
 dispose();
   logingpage.main(null);
}
 else{
    	JOptionPane.showMessageDialog(null, "Please Select the Declaration");
}}
catch(Exception exc)
{      
    System.out.println(exc);
    JOptionPane.showMessageDialog(null, "Please recheck ");
}
    }

if(e.getSource()==cancel)
{
dispose();
try{
        conn c=new conn();
        String q="delete from signupone where FORM_no='"+formno+"' ";
        String q1="delete from signuptwo where Formno='"+formno+"' ";
        c.s.executeUpdate(q);
        c.s.executeUpdate(q1);

    }catch(Exception exc)
    {
System.out.println(exc);

    }
    new logingpage().setVisible(true);
}
}

    public static void main(String []args)
    {
 new signupthree("");
        


    }
}