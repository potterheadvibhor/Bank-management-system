import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
public class helppage extends JFrame implements ActionListener,KeyListener,ItemListener
{
     String pinno,card_no,formno;
     ImageIcon logo;
      JTextField cd,fd;
    JPasswordField p;
    JCheckBox SHOW_PIN;
    JLabel cardno,pin,wtm,lg,Form_no;
    JButton Block_card,BACK,UNBlock_card;
    Color c=new Color(0,102,102);
     Font f=new Font("Arial Black",Font.BOLD,20);
    Font f1=new Font("Arial Black",Font.BOLD,17);
    Font f2=new Font("Arial Narrow",Font.BOLD,15);
    Font f3=new Font("Arial Narrow",Font.BOLD,10);
   
    helppage()
    {

        setTitle("Block card");
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

Form_no=new JLabel("Form No:");
Form_no.setBounds(150, 100, 100, 30);
Form_no.setForeground(Color.BLACK);
Form_no.setFont(f1);
add(Form_no);

cardno=new JLabel("Card No:");
cardno.setBounds(150, 140, 100, 30);
cardno.setForeground(Color.BLACK);
cardno.setFont(f1);
add(cardno);

pin=new JLabel("Pin:");
pin.setBounds(150, 180, 80, 30);
pin.setForeground(Color.BLACK);
pin.setFont(f1);
add(pin);

fd=new JTextField("Enter Form No",10);
fd.setBounds(270,100, 160, 25);
fd.setBackground(Color.GRAY);
fd.setForeground(Color.BLACK);
fd.setFont(f2);
fd.setBorder(new EmptyBorder(0, 0, 0, 0));
add(fd);

cd=new JTextField("Enter Card No",10);
cd.setBounds(270,145, 160, 25);
cd.setBackground(Color.GRAY);
cd.setForeground(Color.BLACK);
cd.setFont(f2);
cd.setBorder(new EmptyBorder(0, 0, 0, 0));
add(cd);

p=new JPasswordField("Enter PIN",10);
p.setBounds(270,185, 160, 25);
p.setBackground(Color.GRAY);
p.setForeground(Color.BLACK);
p.setFont(f2);
p.setEchoChar((char)0);
p.setBorder(new EmptyBorder(0, 0, 0, 0));
add(p);

SHOW_PIN=new JCheckBox("SHOW PIN");
SHOW_PIN.setBounds(430,190, 100, 25);
SHOW_PIN.setFont(f3);
SHOW_PIN.setBackground(c);
SHOW_PIN.setForeground(Color.BLACK);
add(SHOW_PIN);


Block_card = new JButton("BLOCK CARD");
Block_card.setBounds(270,225, 160, 25);
Block_card.setBackground(Color.BLACK);
Block_card.setForeground(Color.white);
Block_card.setFont(f3);
add(Block_card);

UNBlock_card = new JButton("UNBLOCK CARD");
UNBlock_card.setBounds(270,265, 160, 25);
UNBlock_card.setBackground(Color.BLACK);
UNBlock_card.setForeground(Color.white);
UNBlock_card.setFont(f3);
add(UNBlock_card);

BACK = new JButton("Back");
BACK.setBounds(30, 300, 70, 30);
BACK.setBackground(Color.BLACK);
BACK.setForeground(Color.WHITE);
add(BACK);

BACK.addActionListener(this);
cd.addKeyListener(this);
fd.addKeyListener(this);
p.addKeyListener(this);
SHOW_PIN.addItemListener(this);
Block_card.addActionListener(this);
UNBlock_card.addActionListener(this);

setLayout(null);
setBounds(400,100,600,400);
        getContentPane().setBackground(c);
setVisible(true);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==BACK)
{
  
  dispose();
    new logingpage().setVisible(true);
}

if(e.getSource()==Block_card)
{
  formno=fd.getText();
     card_no=cd.getText();
     pinno=p.getText();
    conn c=new conn();
    String q="select * from login where formno='"+formno+"' and card_number='"+card_no+"' and PIN_NUMBER='"+pinno+"'";
      
    try{
    ResultSet rs=c.s.executeQuery(q);
    if(rs.next())
    {
        String q1="insert into block values('"+formno+"','"+card_no+"','"+pinno+"')";
        c.s.executeUpdate(q1);
        String q2="Delete from login where formno='"+formno+"' and card_number='"+card_no+"' and PIN_NUMBER='"+pinno+"'";
        c.s.executeUpdate(q2);
        JOptionPane.showMessageDialog(null,"Your Card has been blocked!!");
       dispose();
        new logingpage().setVisible(true);
   
    }
    else{
        JOptionPane.showMessageDialog(null,"PIN or CRAD_NO incorrect!!");
        fd.setText("Enter Form No");
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
if(e.getSource()==UNBlock_card)
{
formno=fd.getText();
     card_no=cd.getText();
     pinno=p.getText();
    conn c=new conn();
    String q="select * from block where formno='"+formno+"' and card_number='"+card_no+"' and PIN_NUMBER='"+pinno+"'";

 try{
    ResultSet rs=c.s.executeQuery(q);
    if(rs.next())
    {
        String q1="insert into login values('"+formno+"','"+card_no+"','"+pinno+"')";
        c.s.executeUpdate(q1);
        String q2="Delete from block where formno='"+formno+"' and card_number='"+card_no+"' and PIN_NUMBER='"+pinno+"'";
        c.s.executeUpdate(q2);
        JOptionPane.showMessageDialog(null,"Your Card has been Unblocked!!");
       dispose();
        new logingpage().setVisible(true);
   
    }
    else{
        JOptionPane.showMessageDialog(null,"PIN or CRAD_NO incorrect!!");
        fd.setText("Enter Form No");
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
    if(fd.isFocusOwner())
    {
        String s1=fd.getText().trim();
        if(s1.equals("Enter Form No"))
        {
            
            fd.setText("");
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
    String s3=fd.getText().trim();
    if(s3.equals(""))
    {
        fd.setText("Enter Form No");
    }


    String s2=p.getText().trim();
    if(s2.equals(""))
    {
       p.setEchoChar((char)0);
        p.setText("Enter PIN");
    }

}
public void keyTyped(KeyEvent e){};
public void itemStateChanged(ItemEvent ie) 
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
    new helppage();
   } 
}
