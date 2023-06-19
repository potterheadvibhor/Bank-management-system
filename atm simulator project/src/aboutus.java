import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aboutus extends JFrame implements ActionListener
{
    JLabel aboutus1;
    Font f=new Font("Arial Black",Font.BOLD,10);
    Font f1=new Font("Arial Black",Font.BOLD,15);
JButton EXIT;
    aboutus()
    {
setTitle("ABOUT US");
setLayout(null);
setVisible(true);
setBackground(Color.WHITE);
setForeground(Color.BLACK);
setBounds(20,80,350,500);
setResizable(false);

aboutus1=new JLabel("vibhorjain460@gmail.com");
aboutus1.setBounds(60, 80, 270, 30);
aboutus1.setFont(f1);
add(aboutus1);

EXIT=new JButton("EXIT");
EXIT.setBounds(130,400, 70, 30);
EXIT.setFont(f);
EXIT.setBackground(Color.BLACK);
EXIT.setForeground(Color.WHITE);
EXIT.setBorderPainted(false);
add(EXIT);
EXIT.addActionListener(this);
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
new aboutus();
    }
}