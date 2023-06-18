import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

class change_pin extends JFrame implements ActionListener,KeyListener


{
        
   
    JLabel backgroundImage,Enter_4_digit_pin,Enter_new_pin,Re_enter;
ImageIcon mainframe1;
JButton CHANGE,BACK;
JTextField NEW_PIN,RE_ENTER_NEW_PIN;
Font f1=new Font("Arial Black",Font.BOLD,13);
Font f2=new Font("Arial Black",Font.BOLD,10);
Color c=new Color(0,102, 102);
String pinnumber;

    change_pin(String pinnumber){
this.pinnumber=pinnumber;
System.out.println("changepin "+pinnumber);
    setLayout(null);
    setTitle("Change Pin");

    mainframe1=new ImageIcon("atm.jpg");
Image reset1=mainframe1.getImage();
reset1=reset1.getScaledInstance(700, 700, Image.SCALE_DEFAULT);
mainframe1=new ImageIcon(reset1);
backgroundImage=new JLabel(mainframe1);
backgroundImage.setBounds(1, 1, 700, 700);
add(backgroundImage);

Enter_4_digit_pin=new JLabel("Enter An Four Digit PIN");
Enter_4_digit_pin.setBounds(135,220,290,30);
Enter_4_digit_pin.setForeground(Color.WHITE);
Enter_4_digit_pin.setFont(f1);
backgroundImage.add(Enter_4_digit_pin);

Enter_new_pin=new JLabel("New PIN");
Enter_new_pin.setBounds(124,250,70,30);
Enter_new_pin.setForeground(Color.WHITE);
Enter_new_pin.setFont(f1);
backgroundImage.add(Enter_new_pin);

Re_enter=new JLabel("Re-Enter");
Re_enter.setBounds(124,280,70,30);
Re_enter.setForeground(Color.WHITE);
Re_enter.setFont(f1);
backgroundImage.add(Re_enter);

NEW_PIN=new JTextField("4-Digit",10);
NEW_PIN.setBounds(230,255, 120, 20);
NEW_PIN.setBackground(Color.WHITE);
NEW_PIN.setForeground(Color.BLACK);
NEW_PIN.setFont(f2);
NEW_PIN.setBorder(new EmptyBorder(0,0 , 0,0));
add(NEW_PIN);

RE_ENTER_NEW_PIN=new JTextField("4-Digit",10);
RE_ENTER_NEW_PIN.setBounds(230,285, 120, 20);
RE_ENTER_NEW_PIN.setBackground(Color.WHITE);
RE_ENTER_NEW_PIN.setForeground(Color.BLACK);
RE_ENTER_NEW_PIN.setFont(f2);
RE_ENTER_NEW_PIN.setBorder(new EmptyBorder(0,0 , 0,0));
add(RE_ENTER_NEW_PIN);

CHANGE=new JButton("Change");
CHANGE.setBounds(285, 375, 120, 28);
CHANGE.setBackground(Color.BLACK);
CHANGE.setForeground(Color.WHITE);
backgroundImage.add(CHANGE);
BACK=new JButton("Exit");
BACK.setBounds(285, 405, 120, 28);
BACK.setBackground(Color.BLACK);
BACK.setForeground(Color.WHITE);
backgroundImage.add(BACK);

BACK.addActionListener(this);
CHANGE.addActionListener(this);
NEW_PIN.addKeyListener(this);
RE_ENTER_NEW_PIN.addKeyListener(this);





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
    else
    {
        String  s1=NEW_PIN.getText();
        String  s2=RE_ENTER_NEW_PIN.getText();
        if(s1.length()==4 &&  s1.equals(s2) && s2.length()==4 )
        {
            try{
            conn c=new conn();
            String q="update login set PIN_NUMBER='"+s1+"' where PIN_NUMBER ='"+pinnumber+"' ";
            String q1="update bank set PIN_NUMBER='"+s1+"' where PIN_NUMBER ='"+pinnumber+"' ";
            String q2="update signupthree set PIN_NUMBER='"+s1+"' where PIN_NUMBER ='"+pinnumber+"' ";
            c.s.executeUpdate(q);
            c.s.executeUpdate(q1);
            c.s.executeUpdate(q2);
            dispose();
            JOptionPane.showMessageDialog(null, "Pin Change Sussefully");  
            new logingpage().setVisible(true);
             
            }
            catch(Exception exc)
            {
            JOptionPane.showMessageDialog(null, "Please recheck");   
            NEW_PIN.setText("4-Digit");
            RE_ENTER_NEW_PIN.setText("4-Digit");
            System.out.println(exc); 
            
            }

        }
else
{
    JOptionPane.showMessageDialog(null, "Please recheck");
  NEW_PIN.setText("4-Digit");
            RE_ENTER_NEW_PIN.setText("4-Digit");
}
    }
}
public void keyPressed(KeyEvent e)
{
    if(NEW_PIN.isFocusOwner())
    {
        if(NEW_PIN.getText().equals("4-Digit"))
        {
            NEW_PIN.setText("");
        }
    }
    if(RE_ENTER_NEW_PIN.isFocusOwner())
    {
        if(RE_ENTER_NEW_PIN.getText().equals("4-Digit"))
        {
            RE_ENTER_NEW_PIN.setText("");
        }
    }

}
public void keyReleased(KeyEvent e)
{
    if(NEW_PIN.getText().trim().equals(""))
        {
            NEW_PIN.setText("4-Digit");
        }
    
    if(RE_ENTER_NEW_PIN.isFocusOwner())
    {
        if(RE_ENTER_NEW_PIN.getText().trim().equals(""))
        {
            RE_ENTER_NEW_PIN.setText("4-Digit");
        }
    }
}
public void keyTyped(KeyEvent e){}

 public static void main(String []args)
    {
      change_pin cp=new change_pin("");
        
    }
    
}
