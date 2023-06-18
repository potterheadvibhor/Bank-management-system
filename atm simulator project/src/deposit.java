import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

class deposit extends JFrame implements ActionListener,KeyListener


{
        
   
    JLabel backgroundImage,EnterAmount;
ImageIcon mainframe1;
JButton DEPOSIT,BACK;
JTextField depositTextField;
Font f1=new Font("Arial Black",Font.BOLD,13);
String pinnumber;
    deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;
System.out.println("Deposit A"+pinnumber);
    setLayout(null);
    setTitle("Cash Deposit");

mainframe1=new ImageIcon("atm.jpg");
Image reset1=mainframe1.getImage();
reset1=reset1.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
mainframe1=new ImageIcon(reset1);
backgroundImage=new JLabel(mainframe1);
backgroundImage.setBounds(1, 1, 700, 700);
add(backgroundImage);

EnterAmount=new JLabel("Enter amount you want to deposit");
EnterAmount.setBounds(124,220,290,30);
EnterAmount.setForeground(Color.WHITE);
EnterAmount.setFont(f1);
backgroundImage.add(EnterAmount);

depositTextField=new JTextField("Enter amount",10);
depositTextField.setBounds(124,260, 280, 20);
depositTextField.setBackground(Color.WHITE);
depositTextField.setForeground(Color.BLACK);
depositTextField.setFont(f1);
depositTextField.setBorder(new EmptyBorder(0,0 , 0,0));
backgroundImage.add(depositTextField);
DEPOSIT=new JButton("Deposit");
DEPOSIT.setBounds(285, 375, 120, 28);
DEPOSIT.setBackground(Color.BLACK);
DEPOSIT.setForeground(Color.WHITE);
backgroundImage.add(DEPOSIT);
BACK=new JButton("Exit");
BACK.setBounds(285, 405, 120, 28);
BACK.setBackground(Color.BLACK);
BACK.setForeground(Color.WHITE);
backgroundImage.add(BACK);


BACK.addActionListener(this);
DEPOSIT.addActionListener(this);


      setBounds(400,100,700,700);
setResizable(false);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);

depositTextField.addKeyListener(this);     
   
    }

    public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==BACK)
    {
        dispose();
        new mainframe(pinnumber).setVisible(true);
    }
    if(e.getSource()==DEPOSIT)
    {
    try
    {
       
        Date date=new Date();
        String cashdeposited=depositTextField.getText();
        conn c=new conn();
        String q="insert into bank values('"+pinnumber+"','"+date+"','Deposite','"+cashdeposited+"')";
        c.s.executeUpdate(q);
        JOptionPane.showMessageDialog(null, cashdeposited+" Amount Deposited");
depositTextField.setText("Enter amount");
    }catch(Exception ex)
{

JOptionPane.showMessageDialog(null, "Please enter an Amount or Login Again");
depositTextField.setText("Enter amount");
System.out.println(ex);
}
    }
}

public void keyPressed(KeyEvent e)
{
    if(depositTextField.isFocusOwner())
    {
        String s=depositTextField.getText().trim();
        if(s.equals("Enter amount"))
        {
depositTextField.setText("");
        }
    }
}
public void keyReleased(KeyEvent e)
{
if(depositTextField.isFocusOwner())
    {
        String s=depositTextField.getText().trim();
        if(s.equals(""))
        {
depositTextField.setText("Enter amount");
        }
}}
public void keyTyped(KeyEvent e){}


    public static void main(String []args)
    {
      deposit d=new deposit("");
  
    }}
    
