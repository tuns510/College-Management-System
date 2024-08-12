
package javaapplication9;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame
{
  About()
  {
      
      getContentPane().setBackground(Color.WHITE);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/about.jpg"));
      Image i2=i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel img=new JLabel(i3);
      img.setBounds(370,20,400,300);
      add(img);
      
      
      
      JLabel heading =new JLabel("<html>Uiversity<br>Management Sysytem</html>");
      heading.setBounds(70,20,300,140);
      heading.setFont(new Font("hahoma",Font.BOLD,30));
      add(heading);
      
      JLabel name=new JLabel("Developed by Funnn");
      name.setBounds(20,250,500,40);
      name.setFont(new Font("tahoma",Font.PLAIN,35));
      add(name);
      
      JLabel rollno=new JLabel("Roll Number:- 12341231");
      rollno.setBounds(20,300,400,30);
      rollno.setFont(new Font("tahoma",Font.PLAIN,25));
      add(rollno);
      
      JLabel email=new JLabel("Email:- funn@gmail.com");
      email.setBounds(20,350,400,30);
      email.setFont(new Font("tahoma",Font.PLAIN,25));
      add(email);
      
      
      
      setLayout(null);
      setSize(750,500);
      setLocation(150,50);
      setVisible(true);
      
  }
    public static void main(String args[])
    {
        new About();
    }
}
