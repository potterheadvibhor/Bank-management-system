import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.time.format.SignStyle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
class logingpage extends JFrame implements KeyListener,ActionListener,ItemListener
{
    JLabel cardno,pin,wtm,lg;
    JTextField cd;
    JPasswordField p;
    JCheckBox SHOW_PIN;
    JButton signin,clear,signup,BACK;
    Font f=new Font("Arial Black",Font.BOLD,20);
    Font f1=new Font("Arial Black",Font.BOLD,17);
    Font f2=new Font("Arial Narrow",Font.BOLD,15);
    Font f3=new Font("Arial Narrow",Font.BOLD,10);
    Color c=new Color(0,102,102);
     String pinno,card_no;
    ImageIcon logo;
    
   
    
    logingpage()
    {
        setLayout(null);
        setTitle("LogIn");

logo=new ImageIcon("logo.png");
Image reset=logo.getImage();
reset=reset.getScaledInstance(50, 90, java.awt.Image.SCALE_SMOOTH);
logo =new ImageIcon(reset);
lg= new JLabel(logo);
lg.setBounds(100, 10, 120, 100);
add(lg);
wtm=new JLabel("WIZCRAFT ATM");
wtm.setBounds(200, 10, 190, 90);
wtm.setFont(f);
wtm.setForeground(Color.BLACK);
add(wtm);

cardno=new JLabel("Card no:");
cardno.setBounds(150, 100, 80, 30);
cardno.setForeground(Color.BLACK);
cardno.setFont(f1);
add(cardno);

pin=new JLabel("Pin:");
pin.setBounds(150, 140, 80, 30);
pin.setForeground(Color.BLACK);
pin.setFont(f1);
add(pin);

cd=new JTextField("Enter Card No",10);
cd.setBounds(270,105, 160, 25);
cd.setBackground(Color.GRAY);
cd.setForeground(Color.BLACK);
cd.setFont(f2);
cd.setBorder(new EmptyBorder(0, 0, 0, 0));
add(cd);

p=new JPasswordField("Enter PIN",10);
p.setBounds(270,145, 160, 25);
p.setBackground(Color.GRAY);
p.setForeground(Color.BLACK);
p.setFont(f2);
p.setEchoChar((char)0);
p.setBorder(new EmptyBorder(0, 0, 0, 0));
add(p);

SHOW_PIN=new JCheckBox("SHOW PIN");
SHOW_PIN.setBounds(430,150, 100, 25);
SHOW_PIN.setFont(f3);
SHOW_PIN.setBackground(c);
SHOW_PIN.setForeground(Color.BLACK);
add(SHOW_PIN);


signin = new JButton("SIGN IN");
signin.setBounds(270, 190, 75, 25);
signin.setBackground(Color.BLACK);
signin.setForeground(Color.white);
signin.setFont(f3);
add(signin);

clear = new JButton("CLEAR");
clear.setBounds(355, 190, 75, 25);
clear.setBackground(Color.BLACK);
clear.setForeground(Color.white);
clear.setFont(f3);
add(clear);

signup = new JButton("SIGN UP");
signup.setBounds(270,225, 160, 25);
signup.setBackground(Color.BLACK);
signup.setForeground(Color.white);
signup.setFont(f3);
add(signup);

BACK = new JButton("Back");
BACK.setBounds(30, 300, 70, 30);
BACK.setBackground(Color.BLACK);
BACK.setForeground(Color.WHITE);
add(BACK);

signin.addActionListener(this);
signup.addActionListener(this);
clear.addActionListener(this);
cd.addKeyListener(this);
p.addKeyListener(this);
SHOW_PIN.addItemListener(this);

setBounds(400,100,600,400);
        getContentPane().setBackground(c);
setVisible(true);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
if(e.getSource()==clear)
{
    cd.setText("Enter Card No");
    p.setEchoChar((char)0);
    p.setText("Enter PIN");
}
if(e.getSource()==signup)
{
  
  dispose();
    new signupone("").setVisible(true);
}
if(e.getSource()==signin)
{
    int mandatory=0;
     card_no=cd.getText();
     pinno=p.getText();
     System.out.println("login A"+pinno);
    conn c=new conn();
    String q="select * from login where card_number='"+card_no+"' and PIN_NUMBER='"+pinno+"'";
System.out.println("Login B"+pinno);
    try{
    ResultSet rs=c.s.executeQuery(q);
    if(rs.next())
    {
       dispose();
        System.out.println("Login c"+pinno);
        new mainframe(pinno).setVisible(true);
   
    }
    else{
        JOptionPane.showMessageDialog(null,"PIN or CRAD_NO incorrect!!");
        cd.setText("Enter Card No");
            p.setEchoChar((char)0);
        p.setText("Enter PIN");
    }

}catch(Exception exc)
{
    System.out.println(exc);
    JOptionPane.showMessageDialog(null,"exception");
    cd.setText("Enter Card No");
        p.setEchoChar((char)0);
        p.setText("Enter PIN");
}
    
    
}

    }
public void keyPressed(KeyEvent e)
{
    if(cd.isFocusOwner())
    {
        String s1=cd.getText().trim();
        if(s1.equals("Enter Card No"))
        {
            cd.setText("");
        }
    }
    if(p.isFocusOwner())
    {
        String s1=p.getText().trim();
        if(s1.equals("Enter PIN"))
        {
            p.setEchoChar('#');
            p.setText("");
        }
    }

}
public void keyReleased(KeyEvent e)
{

    String s1=cd.getText().trim();
    if(s1.equals(""))
    {
        cd.setText("Enter Card No");
    }


    String s2=p.getText().trim();
    if(s2.equals(""))
    {
       p.setEchoChar((char)0);
        p.setText("Enter PIN");
    }

}
public void keyTyped(KeyEvent e){}
public void itemStateChanged(ItemEvent e) 
{
    if(SHOW_PIN.isSelected())
{
 p.setEchoChar((char)0);
}
else{
  p.setEchoChar('#');
}
}
    public static void main(String []args)
    {
       new logingpage();
      
       
    }
}