import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

class cashwidrawl extends JFrame implements ActionListener,KeyListener


{
        
   
    JLabel backgroundImage,EnterAmount;
ImageIcon mainframe1;
JButton WITHDRAW,BACK;
JTextField withdrawTextField;
Font f1=new Font("Arial Black",Font.BOLD,13);
Font f2=new Font("Arial Black",Font.BOLD,10);
Color c=new Color(0,102, 102);
String pinnumber;

    cashwidrawl(String pinnumber){
this.pinnumber=pinnumber;
System.out.println("Withdrawl A"+pinnumber);
    setLayout(null);
    setTitle("Cash Withdrawl");

    mainframe1=new ImageIcon("atm.jpg");
Image reset1=mainframe1.getImage();
reset1=reset1.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);
mainframe1=new ImageIcon(reset1);
backgroundImage=new JLabel(mainframe1);
backgroundImage.setBounds(1, 1, 700, 700);
add(backgroundImage);

EnterAmount=new JLabel("Enter amount you want to Withdraw");
EnterAmount.setBounds(124,220,290,30);
EnterAmount.setForeground(Color.WHITE);
EnterAmount.setFont(f1);
backgroundImage.add(EnterAmount);

withdrawTextField=new JTextField("Minimun 1000",10);
withdrawTextField.setBounds(124,260, 280, 20);
withdrawTextField.setBackground(Color.WHITE);
withdrawTextField.setForeground(Color.BLACK);
withdrawTextField.setFont(f2);
withdrawTextField.setBorder(new EmptyBorder(0,0 , 0,0));
backgroundImage.add(withdrawTextField);
WITHDRAW=new JButton("Withdraw");
WITHDRAW.setBounds(285, 375, 120, 28);
WITHDRAW.setBackground(Color.BLACK);
WITHDRAW.setForeground(Color.WHITE);
backgroundImage.add(WITHDRAW);
BACK=new JButton("Exit");
BACK.setBounds(285, 405, 120, 28);
BACK.setBackground(Color.BLACK);
BACK.setForeground(Color.WHITE);
backgroundImage.add(BACK);

BACK.addActionListener(this);
WITHDRAW.addActionListener(this);
withdrawTextField.addKeyListener(this);





setBounds(400,100,700,700);
setResizable(false);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
//setBackground(c);
 }
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==BACK)
    {
        dispose();
        new mainframe(pinnumber).setVisible(true);
    }
    if(e.getSource()==WITHDRAW)
    {
 try
    {
    System.out.println("Withdrawl A"+pinnumber);

        //pinnumber="1234";
        Date date=new Date();
        //  String cashdeposited =Integer.parseInt(depositTextField.getText());
        String cashwithdrawl=withdrawTextField.getText();
        conn c=new conn();
        String q="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+cashwithdrawl+"')";
        c.s.executeUpdate(q);
        JOptionPane.showMessageDialog(null, "Amount Withdrawl");
withdrawTextField.setText("Minimun 1000");
    }catch(Exception ex)
{

JOptionPane.showMessageDialog(null, "Please enter an Amount");
withdrawTextField.setText("Minimun 1000");
System.out.println(ex);
}
    }
}
public void keyPressed(KeyEvent e)
{
    if(withdrawTextField.isFocusOwner())
    {
        String s=withdrawTextField.getText().trim();
        if(s.equals("Minimun 1000"))
        {
withdrawTextField.setText("");
        }
    }
}
public void keyReleased(KeyEvent e)
{
if(withdrawTextField.isFocusOwner())
    {
        String s=withdrawTextField.getText().trim();
        if(s.equals(""))
        {
withdrawTextField.setText("Minimun 1000");
        }
}}
public void keyTyped(KeyEvent e){}


//}
//class cashwidrawl{
    public static void main(String []args)
    {
      cashwidrawl cw=new cashwidrawl("");
        
    }
    
}
