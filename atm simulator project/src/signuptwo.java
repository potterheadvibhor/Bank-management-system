import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.Scanner;

class signuptwo extends JFrame implements KeyListener,ActionListener
{
    JLabel lg,FORMNO,AFN,RELIGION,CATEGORY,INCOME,EDUCATIONAL,QUALIFICATION,OCCUPATION,PANNUMBER,AADHARNUMBER,SENIORCITIZEN,EXISTINGACCOUNT;
    ImageIcon logo;
    Font f=new Font("Arial Black",Font.BOLD,25);
    Font f1=new Font("Arial Narrow",Font.BOLD,17);
    Font f2=new Font("Arial Narrow",Font.BOLD,15);
    JComboBox rt,gt,nt,ngt,st;
    JTextField pt,at;
    JRadioButton sy,sn,ey,en;
    ButtonGroup bg=new ButtonGroup();
    ButtonGroup bg2=new ButtonGroup();
    Color c=new Color(0,102,102);
    JButton NEXT,CANCEL,CLEAR;
    String formno,fno;
    int forminput;
    signuptwo(String formno)
    {
       
      this.fno=formno;
              
              System.out.println("A"+fno);

setLayout(null);
setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
logo=new ImageIcon("logo.png");
Image reset=logo.getImage();
reset=reset.getScaledInstance(50, 90, java.awt.Image.SCALE_SMOOTH);
logo =new ImageIcon(reset);
lg= new JLabel(logo);
lg.setBounds(60, 10, 120, 100);
add(lg);


FORMNO=new JLabel("Form No:"+formno);
FORMNO.setBounds(530, 8, 300, 30);
FORMNO.setFont(f1);
FORMNO.setForeground(Color.BLACK);
add(FORMNO);
        AFN=new JLabel("Page 2:APPLICATION Details");
        AFN.setBounds(150, 10, 700, 90);
AFN.setFont(f);
AFN.setForeground(Color.BLACK);
add(AFN);

RELIGION=new JLabel("Religion:");
RELIGION.setBounds(150, 120, 180, 30);
RELIGION.setFont(f1);
RELIGION.setForeground(Color.BLACK);
add(RELIGION);
CATEGORY=new JLabel("Category:");
CATEGORY.setBounds(150, 160, 180, 30);
CATEGORY.setFont(f1);
CATEGORY.setForeground(Color.BLACK);
add(CATEGORY);
INCOME=new JLabel("Income:");
INCOME.setBounds(150, 200, 180, 30);
INCOME.setFont(f1);
INCOME.setForeground(Color.BLACK);
add(INCOME);
EDUCATIONAL=new JLabel("Educational");
EDUCATIONAL.setBounds(150, 240, 180, 30);
EDUCATIONAL.setFont(f1);
EDUCATIONAL.setForeground(Color.BLACK);
add(EDUCATIONAL);
QUALIFICATION=new JLabel("Qualification:");
QUALIFICATION.setBounds(150, 255, 180, 30);
QUALIFICATION.setFont(f1);
QUALIFICATION.setForeground(Color.BLACK);
add(QUALIFICATION);

OCCUPATION=new JLabel("Occupation:");
OCCUPATION.setBounds(150, 280, 180, 30);
OCCUPATION.setFont(f1);
OCCUPATION.setForeground(Color.BLACK);
add(OCCUPATION);
PANNUMBER=new JLabel("PAN Number:");
PANNUMBER.setBounds(150, 320, 180, 30);
PANNUMBER.setFont(f1);
PANNUMBER.setForeground(Color.BLACK);
add(PANNUMBER);
AADHARNUMBER=new JLabel("Aadhar Number:");
AADHARNUMBER.setBounds(150, 360, 180, 30);
AADHARNUMBER.setFont(f1);
AADHARNUMBER.setForeground(Color.BLACK);
add(AADHARNUMBER);
SENIORCITIZEN=new JLabel("Senior Citizen:");
SENIORCITIZEN.setBounds(150, 400, 180, 30);
SENIORCITIZEN.setFont(f1);
SENIORCITIZEN.setForeground(Color.BLACK);
add(SENIORCITIZEN);
EXISTINGACCOUNT=new JLabel("Existing Account:");
EXISTINGACCOUNT.setBounds(150, 440, 180, 30);
EXISTINGACCOUNT.setFont(f1);
EXISTINGACCOUNT.setForeground(Color.BLACK);
add(EXISTINGACCOUNT);

rt=new JComboBox();
rt.setBounds(290,120, 300, 25);
rt.setBackground(Color.GRAY);
rt.setForeground(Color.BLACK);
rt.setFont(f2);
rt.addItem("Hindu");
rt.addItem("Muslim");
rt.addItem("Sikh");
rt.addItem("Christian");
rt.addItem("Jain");
rt.addItem("Other");
add(rt);
gt=new JComboBox();
gt.setBounds(290,165, 300, 25);
gt.setBackground(Color.GRAY);
gt.setForeground(Color.BLACK);
gt.setFont(f2);
gt.addItem("General");
gt.addItem("OBC");
gt.addItem("SC");
gt.addItem("ST");
gt.addItem("Outher");
add(gt);
nt=new JComboBox();
nt.setBounds(290,210, 300, 25);
nt.setBackground(Color.GRAY);
nt.setForeground(Color.black);
nt.setFont(f2);
nt.addItem("NULL");
nt.addItem("<1,50,000");
nt.addItem("<2,50,000");
nt.addItem("<5,50,000");
nt.addItem("Above 10,50,000");
add(nt);
ngt =new JComboBox();
ngt.setBounds(290,245, 300, 25);
ngt.setForeground(Color.BLACK);
ngt.setFont(f2);
ngt.setBackground(Color.GRAY);
ngt.addItem("NON-GRADUATE");
ngt.addItem("POST-GRADUATE");
ngt.addItem("GRADUATE");
ngt.addItem("Doctrait");
ngt.addItem("Other");
add(ngt);
st=new JComboBox();
st.setBounds(290,285, 300, 25);
st.setForeground(Color.BLACK);
st.setFont(f2);
st.setBackground(Color.GRAY);
st.addItem("Salaried");
st.addItem("NON-Salaried");
st.addItem("Self Employed");
st.addItem("Business");
st.addItem("Student");
st.addItem("Other");
add(st);

pt=new JTextField("PAN NO",10);
pt.setBounds(290,325, 300, 25);
pt.setBackground(Color.GRAY);
pt.setForeground(Color.BLACK);
pt.setFont(f2);
pt.setBorder(new EmptyBorder(0,0,0,0));
add(pt);
at=new JTextField("Aadhar NO",10);
at.setBounds(290,365, 300, 25);
at.setBackground(Color.GRAY);
at.setForeground(Color.BLACK);
at.setFont(f2);
at.setBorder(new EmptyBorder(0,0,0,0));
add(at);
sy =new JRadioButton("Yes",false);
sy.setBounds(290,405, 90, 25);
sy.setForeground(Color.BLACK);
sy.setFont(f2);
sy.setBackground(c);
bg.add(sy);
add(sy);
sn =new JRadioButton("No",false);
sn.setBounds(400,405, 90, 25);
sn.setForeground(Color.BLACK);
sn.setFont(f2);
sn.setBackground(c);
bg.add(sn);
add(sn);
ey =new JRadioButton("Yes",false);
ey.setBounds(290,450, 90, 25);
ey.setForeground(Color.BLACK);
ey.setFont(f2);
ey.setBackground(c);
bg2.add(ey);
add(ey);
en =new JRadioButton("No",false);
en.setBounds(400,450, 90, 25);
en.setForeground(Color.BLACK);
en.setFont(f2);
en.setBackground(c);
bg2.add(en);
add(en);

NEXT = new JButton("Next");
NEXT.setBounds(380, 510, 70, 30);
NEXT.setBackground(Color.BLACK);
NEXT.setForeground(Color.WHITE);
add(NEXT);
CLEAR = new JButton("Clear");
CLEAR.setBounds(600, 555, 70, 30);
CLEAR.setBackground(Color.BLACK);
CLEAR.setForeground(Color.WHITE);
add(CLEAR);
CANCEL = new JButton("Cancel");
CANCEL.setBounds(30, 555, 120, 30);
CANCEL.setBackground(Color.BLACK);
CANCEL.setForeground(Color.WHITE);
add(CANCEL);

pt.addKeyListener(this);
at.addKeyListener(this);
NEXT.addActionListener(this);
CANCEL.addActionListener(this);
CLEAR.addActionListener(this);
rt.addActionListener(this);
gt.addActionListener(this);
nt.addActionListener(this);
ngt.addActionListener(this);
st.addActionListener(this);
sy.addActionListener(this);
sn.addActionListener(this);
ey.addActionListener(this);
en.addActionListener(this);


 getContentPane().setBackground(c);
        setVisible(true);
        setBounds(400,100,700,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
public void actionPerformed(ActionEvent e)
{
String religion,category,income,Education_qualification,occupation,pan_no,aadhar_no,senior_citizen="",existing_account="";
    if(e.getSource()== NEXT)
    {

          // fno=formno;
    
     religion=rt.getSelectedItem().toString();
     category=gt.getSelectedItem().toString();
     income=nt.getSelectedItem().toString();
     Education_qualification=ngt.getSelectedItem().toString();
     occupation=st.getSelectedItem().toString();
     pan_no=pt.getText();
     int mandatory=0;
    aadhar_no=at.getText();

     if(pan_no.equals("PAN NO"))
     {
       mandatory=1;
     }
      if(aadhar_no.equals("Aadhar No"))
     {
        mandatory=1;
     }
     if(sy.isSelected())
     {
        senior_citizen="yes";
     }
     if(sn.isSelected())
     {
        senior_citizen="no";
     }
     if(ey.isSelected())
     {
        existing_account="yes";
     }
     if(en.isSelected())
     {
        existing_account="no";
     }
     if(mandatory==1)
     {        
                JOptionPane.showMessageDialog(null,"All fields are mandatory");
                mandatory=0;

}
 if(pan_no.length()!=10 || aadhar_no.length() != 12)
 {
        JOptionPane.showMessageDialog(null,"Please Check Aadhar NO(12) and PAN No(10)");

 } 
     else{
        try{
        
conn c=new conn();
              System.out.println("B"+fno);

String q="insert into signuptwo values('"+fno+"','"+religion+"','"+category+"','"+income+"','"+Education_qualification+"','"+occupation+"','"+pan_no+"','"+aadhar_no+"','"+senior_citizen+"','"+existing_account+"') ";
c.s.executeUpdate(q);
dispose();
System.out.println(fno);
new signupthree(fno).setVisible(true);



}
catch(Exception exc)
{
JOptionPane.showMessageDialog(null, "Please reacheck your details ");
System.out.println(exc);
}
    }}
    
if(e.getSource()==CLEAR)
{
    pt.setText("PAN NO");
    at.setText("Aadhar No");
}
if(e.getSource()==CANCEL)
{
    dispose();
    try{
        conn c=new conn();
        String q="delete from signupone where FORM_no='"+fno+"' ";
        c.s.executeUpdate(q);

    }catch(Exception exc)
    {
System.out.println(exc);

    }
    new logingpage().setVisible(true);

}


}
public void keyPressed(KeyEvent e)
{
    if(pt.isFocusOwner())
    {
        String s1=pt.getText();
        if(s1.equals("PAN NO"))
        {
            pt.setText("");
        }
    }
    if(at.isFocusOwner())
    {
        String s1=at.getText();
        if(s1.equals("Aadhar NO"))
        {
            at.setText("");
        }
    }
}
public void keyTyped(KeyEvent e){}
public void keyReleased(KeyEvent e)
{
    String s1=pt.getText().trim();
        if(s1.equals(""))
        {
            pt.setText("PAN NO");
        }
    
    
         s1=at.getText().trim();
        if(s1.equals(""))
        {
            at.setText("Aadhar NO");
        }
}
    public static void main(String []args)
    {
        new signuptwo("");
        
        
    }
}