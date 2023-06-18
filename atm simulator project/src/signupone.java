import javax.net.ssl.TrustManager;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.sql.*;
import java.time.Year;

class signupone extends JFrame implements KeyListener,ActionListener
{
    JLabel  lg,AFN,PD,NAME,FNAME,DOB,GENDER,EMAILADDRESS,MARITIALSTATUS,ADDRESS,CITY,PINCODE,STATE;
    Font f=new Font("Arial Black",Font.BOLD,25);
    Font f1=new Font("Arial Narrow",Font.BOLD,17);
    Font f2=new Font("Arial Narrow",Font.BOLD,15);
    ImageIcon logo;
    JButton NEXT,CLEAR,CANCEL;
    JTextField nt,ft,et,at,ct,pt,st;
    JRadioButton GMALE,GFEMALE,MARRIED,UNMARRIED,OUTHER;
    JComboBox date,month,year;
    int mandatory=0;
    Color c=new Color(0,102,102);
    String formno;

    int max=9000,min=6000,random;
    signupone(String formno)
    {
        ButtonGroup bg=new ButtonGroup();
        ButtonGroup bg2=new ButtonGroup();
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 1");
        setLayout(null);

        logo=new ImageIcon("logo.png");
Image reset=logo.getImage();
reset=reset.getScaledInstance(50, 90, java.awt.Image.SCALE_SMOOTH);
logo =new ImageIcon(reset);
lg= new JLabel(logo);
lg.setBounds(60, 10, 120, 100);
add(lg);
random=(int)(Math.random()*(max-min)+min);
//System.out.println(fno);
        AFN=new JLabel("APPLICATION FORM NO."+random);
        AFN.setBounds(150, 10, 700, 90);
AFN.setFont(f);
AFN.setForeground(Color.BLACK);
add(AFN);
        PD=new JLabel("Page 1:Personal Details");
        PD.setBounds(260, 50, 700, 90);
PD.setFont(f1);
PD.setForeground(Color.BLACK);
add(PD);
        NAME=new JLabel("Name:");
        NAME.setBounds(150, 120, 180, 30);
        NAME.setFont(f1);
        NAME.setForeground(Color.BLACK);
add(NAME);
        FNAME=new JLabel("Father's Name:");
        FNAME.setBounds(150, 160, 180, 30);
        FNAME.setFont(f1);
        FNAME.setForeground(Color.BLACK);
add(FNAME);
        DOB=new JLabel("Date of Birth:");
        DOB.setBounds(150, 200, 180, 30);
        DOB.setFont(f1);
        DOB.setForeground(Color.BLACK);
add(DOB);
        GENDER=new JLabel("Gender:");
        GENDER.setBounds(150, 240, 180, 30);
        GENDER.setFont(f1);
        GENDER.setForeground(Color.BLACK);
add(GENDER);
       
        EMAILADDRESS=new JLabel("Email Address:");
        EMAILADDRESS.setBounds(150, 280, 180, 30);
        EMAILADDRESS.setFont(f1);
        EMAILADDRESS.setForeground(Color.BLACK);
add(EMAILADDRESS);
MARITIALSTATUS=new JLabel("Marital Status:");
MARITIALSTATUS.setBounds(150, 320, 180, 30);
MARITIALSTATUS.setFont(f1);
MARITIALSTATUS.setForeground(Color.BLACK);
add(MARITIALSTATUS);
ADDRESS=new JLabel("Address:");
ADDRESS.setBounds(150, 360, 180, 30);
ADDRESS.setFont(f1);
ADDRESS.setForeground(Color.BLACK);
add(ADDRESS);
CITY=new JLabel("City:");
CITY.setBounds(150, 400, 180, 30);
CITY.setFont(f1);
CITY.setForeground(Color.BLACK);
add(CITY);
PINCODE=new JLabel("Pin Code:");
PINCODE.setBounds(150, 440, 180, 30);
PINCODE.setFont(f1);
PINCODE.setForeground(Color.BLACK);
add(PINCODE);
STATE=new JLabel("State:");
STATE.setBounds(150, 480, 180, 30);
STATE.setFont(f1);
STATE.setForeground(Color.BLACK);
add(STATE);
nt=new JTextField("Enter Name",10);
nt.setBounds(290,120, 300, 25);
nt.setBackground(Color.GRAY);
nt.setForeground(Color.BLACK);
nt.setFont(f2);
nt.setBorder(new EmptyBorder(0,0,0,0));
add(nt);
ft=new JTextField("Enter Father's Name",10);
ft.setBounds(290,165, 300, 25);
ft.setBackground(Color.GRAY);
ft.setForeground(Color.BLACK);
ft.setFont(f2);
ft.setBorder(new EmptyBorder(0,0,0,0));
add(ft);


date=new JComboBox();
date.setBounds(290,210, 90, 25);
date.setBackground(Color.GRAY);
date.setForeground(Color.black);
date.setFont(f2);
for(int j=1;j<=31;j++)
{
    date.addItem(""+j);
    add(date);
}

month=new JComboBox();
month.setBounds(400,210, 90, 25);
month.setBackground(Color.GRAY);
month.setForeground(Color.black);
month.setFont(f2);
for(int j=1;j<=12;j++)
{
    month.addItem(""+j);
    add(month);
}
year=new JComboBox();
year.setBounds(500,210, 90, 25);
year.setBackground(Color.GRAY);
year.setForeground(Color.black);
year.setFont(f2);
for(int j=1950;j<=2005;j++)
{
    year.addItem(""+j);
    add(year);
}

GMALE =new JRadioButton("Male",false);
GMALE.setBounds(290,245, 90, 25);
GMALE.setForeground(Color.BLACK);
GMALE.setFont(f2);
bg.add(GMALE);
GMALE.setBackground(c);
add(GMALE);
GFEMALE =new JRadioButton("Female",false);
GFEMALE.setBounds(450,245, 90, 25);
GFEMALE.setForeground(Color.BLACK);
GFEMALE.setBackground(c);
GFEMALE.setFont(f2);
bg.add(GFEMALE);
add(GFEMALE);

et=new JTextField("Email address",10);
et.setBounds(290,285, 300, 25);
et.setBackground(Color.GRAY);
et.setForeground(Color.BLACK);
et.setFont(f2);
et.setBorder(new EmptyBorder(0,0,0,0));
add(et);

MARRIED =new JRadioButton("Married",false);
MARRIED.setBounds(290,325, 90, 25);
MARRIED.setForeground(Color.BLACK);
MARRIED.setFont(f2);
MARRIED.setBackground(c);
bg2.add(MARRIED);
add(MARRIED);
UNMARRIED =new JRadioButton("Unmarried",false);
UNMARRIED.setBounds(400,325, 90, 25);
UNMARRIED.setForeground(Color.BLACK);
UNMARRIED.setFont(f2);
UNMARRIED.setBackground(c);
bg2.add(UNMARRIED);
add(UNMARRIED);
OUTHER =new JRadioButton("Other",false);
OUTHER.setBounds(520,325, 90, 25);
OUTHER.setForeground(Color.BLACK);
OUTHER.setFont(f2);
OUTHER.setBackground(c);
bg2.add(OUTHER);
add(OUTHER);

at=new JTextField("Full address",10);
at.setBounds(290,365, 300, 25);
at.setBackground(Color.GRAY);
at.setForeground(Color.BLACK);
at.setFont(f2);
at.setBorder(new EmptyBorder(0,0,0,0));
add(at);
ct=new JTextField("City",10);
ct.setBounds(290,405, 300, 25);
ct.setBackground(Color.GRAY);
ct.setForeground(Color.BLACK);
ct.setFont(f2);
ct.setBorder(new EmptyBorder(0,0,0,0));
add(ct);
pt=new JTextField("Pin code",10);
pt.setBounds(290,450, 300, 25);
pt.setBackground(Color.GRAY);
pt.setForeground(Color.BLACK);
pt.setFont(f2);
pt.setBorder(new EmptyBorder(0,0,0,0));
add(pt);
st=new JTextField("State",10);
st.setBounds(290,495, 300, 25);
st.setBackground(Color.GRAY);
st.setForeground(Color.BLACK);
st.setFont(f2);
st.setBorder(new EmptyBorder(0,0,0,0));
add(st);

NEXT = new JButton("Next");
NEXT.setBounds(360, 555, 70, 30);
NEXT.setBackground(Color.BLACK);
NEXT.setForeground(Color.WHITE);
add(NEXT);

CLEAR = new JButton("Clear");
CLEAR.setBounds(600, 555, 70, 30);
CLEAR.setBackground(Color.BLACK);
CLEAR.setForeground(Color.WHITE);
add(CLEAR);
CANCEL = new JButton("Cancel");
CANCEL.setBounds(30, 555, 90, 30);
CANCEL.setBackground(Color.BLACK);
CANCEL.setForeground(Color.WHITE);
add(CANCEL);
nt.addKeyListener(this);
ft.addKeyListener(this);
et.addKeyListener(this);
at.addKeyListener(this);
ct.addKeyListener(this);
pt.addKeyListener(this);
st.addKeyListener(this);
GFEMALE.addActionListener(this);
GMALE.addActionListener(this);
MARRIED.addActionListener(this);
UNMARRIED.addActionListener(this);
OUTHER.addActionListener(this);
date.addActionListener(this);
month.addActionListener(this);
year.addActionListener(this);
CLEAR.addActionListener(this);
CANCEL.addActionListener(this);
NEXT.addActionListener(this);

 getContentPane().setBackground(c);
        setVisible(true);
        setBounds(400,100,700,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
       // String fno;
        if(e.getSource()==NEXT)
        {
            try{
            String maritialn="",gn="";
      formno=""+random;
        System.out.println("A"+formno);
        String n=nt.getText();
        String f=ft.getText();
        String en=et.getText();
        String an=at.getText();
        String cn=ct.getText();
        String pn=pt.getText();
        String sn=st.getText();
         if(n.equals("Enter Name"))
        {
            mandatory=1;
        }
        
          if(f.equals("Enter Father's Name"))
        {
            mandatory=1;
        }
        String dn=date.getSelectedItem().toString();
        String mn=month.getSelectedItem().toString();
        String Yn=year.getSelectedItem().toString();
        String dateful=dn+"/"+mn+"/"+"/"+Yn;
        
        if(GMALE.isSelected())
        {
            gn="Male";
        }
        if(GFEMALE.isSelected())
        {
             gn="Female";
        }
        
        if(en.equals("Email address"))
        {
            mandatory=1;
        }
        
        if(MARRIED.isSelected())
        {
             maritialn="Married";
        }
        if(UNMARRIED.isSelected())
        {
             maritialn="Unmarried";
        }
        if(OUTHER.isSelected())
        {
             maritialn="other";
        }
          if(an.equals("Full address"))
        {
            mandatory=1;
        }
         if(cn.equals("City"))
        {
            mandatory=1;
        }
        if(pn.equals("Pin code"))
        {
            mandatory=1;
        }
        
        if(sn.equals("State"))
        {
            mandatory=1;
        }
       if(mandatory==1 || pn.length()!=6 )
        {
        JOptionPane.showMessageDialog(null,"All fields are Mandatory or Enter correct pincode");
mandatory=0;
        }
        else{

                    System.out.println("B"+formno);
                    
conn c=new conn();
String q="insert into signupone values('"+formno+"','"+n+"','"+f+"','"+dateful+"','"+gn+"','"+en+"','"+maritialn+"','"+an+"','"+cn+"','"+pn+"','"+sn+"')";
c.s.executeUpdate(q);
System.out.println(""+formno);
dispose();
new signuptwo(formno).setVisible(true);
        
        }}
    catch(Exception exc){

 JOptionPane.showMessageDialog(null,"please recheck your details");
  System.out.println(exc);
    }
        

        }
        if(e.getSource()==CLEAR)
        {
            nt.setText("Enter Name");
            ft.setText("Enter Father's Name");
            et.setText("Email address");
            at.setText("Full address");
            ct.setText("City");
            pt.setText("Pin code");
            st.setText("State");
        }
        if(e.getSource()==CANCEL)
        {
dispose();
new logingpage().setVisible(true);;
        }}
        
    
public void keyPressed(KeyEvent e)
{
    if(nt.isFocusOwner())
    {
        String s1=nt.getText();
        if(s1.equals("Enter Name"))
        {
            nt.setText("");
        }
 }
    if(ft.isFocusOwner())
    {
        String s1=ft.getText();
        if(s1.equals("Enter Father's Name"))
        {
            ft.setText("");
        }
 }
    if(et.isFocusOwner())
    {
        String s1=et.getText();
        if(s1.equals("Email address"))
        {
            et.setText("");
        }
 }
    if(at.isFocusOwner())
    {
        String s1=at.getText();
        if(s1.equals("Full address"))
        {
            at.setText("");
        }
 }
    if(ct.isFocusOwner())
    {
        String s1=ct.getText();
        if(s1.equals("City"))
        {
            ct.setText("");
        }
 }
    if(pt.isFocusOwner())
    {
        String s1=pt.getText();
        if(s1.equals("Pin code"))
        {
            pt.setText("");
        }
 }
    if(st.isFocusOwner())
    {
        String s1=st.getText();
        if(s1.equals("State"))
        {
            st.setText("");
        }
 }
}
public void keyTyped(KeyEvent e){}
public void keyReleased(KeyEvent e)
{
    String s1=nt.getText().trim();
    if(s1.equals(""))
    {
        nt.setText("Enter Name");
    }
     s1=ft.getText().trim();
    if(s1.equals(""))
    {
        ft.setText("Enter Father's Name");
    }
    s1=et.getText().trim();
    if(s1.equals(""))
    {
        et.setText("Email address");
    }
    s1=at.getText().trim();
    if(s1.equals(""))
    {
        at.setText("Full address");
    }
    s1=ct.getText().trim();
    if(s1.equals(""))
    {
        ct.setText("City");
    }
    s1=pt.getText().trim();
    if(s1.equals(""))
    {
        pt.setText("Pin code");
    }

    s1=st.getText().trim();
    if(s1.equals(""))
    {
        st.setText("State");
    }
}

    public static void main(String []args)
    {
        new signupone("");
        

    }
}