
package javaapplication9;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener
{
    String rollno;
    JButton cancel;
   Marks(String rollno)
   {
       this.rollno=rollno;
       
       getContentPane().setBackground(Color.WHITE);
       
       JLabel heading=new JLabel("Pune University");
       heading.setBounds(140,10,400,25);
       heading.setFont(new Font("tahoma",Font.BOLD,20));
       add(heading);
       
       JLabel subheading=new JLabel("Result of Examination 2023");
       subheading.setBounds(100,50,300,20);
       subheading.setFont(new Font("tahoma",Font.BOLD,18));
       add(subheading);
       
       JLabel jrollno=new JLabel("Roll Number -  "+rollno);
       jrollno.setBounds(50,90,200,20);
       jrollno.setFont(new Font("tahoma",Font.PLAIN,18));
       add(jrollno);
       
       JLabel jsem=new JLabel();
       jsem.setBounds(50,120,200,20);
       jsem.setFont(new Font("tahoma",Font.PLAIN,18));
       add(jsem);
       
       JLabel jsub1=new JLabel();
       jsub1.setBounds(50,150,150,20);
       add(jsub1);
       
       JLabel jsub2=new JLabel();
       jsub2.setBounds(50,180,150,20);
       add(jsub2);
       
       JLabel jsub3=new JLabel();
       jsub3.setBounds(50,210,150,20);
       add(jsub3);
       
       JLabel jsub4=new JLabel();
       jsub4.setBounds(50,240,150,20);
       add(jsub4);
       
       JLabel jmarks1=new JLabel();
       jmarks1.setBounds(230,150,150,20);
       add(jmarks1);
       
       JLabel jmarks2=new JLabel();
       jmarks2.setBounds(230,180,150,20);
       add(jmarks2);
       
       JLabel jmarks3=new JLabel();
       jmarks3.setBounds(230,210,150,20);
       add(jmarks3);
       
       JLabel jmarks4=new JLabel();
       jmarks4.setBounds(230,240,150,20);
       add(jmarks4);
       
       
       cancel=new JButton("Cancel");
       cancel.setBounds(300,300,100,25);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       add(cancel);
       
       
       try
       {
           Conn c=new Conn();
           ResultSet rs1=c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
           while(rs1.next())
           {
               jsub1.setText(rs1.getString("subject1"));
               jsub2.setText(rs1.getString("subject2"));
               jsub3.setText(rs1.getString("subject3"));
               jsub4.setText(rs1.getString("subject4"));
 
           }
           ResultSet rs2=c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
           while(rs2.next())
           {
               jmarks1.setText(rs2.getString("marks1"));
               jmarks2.setText(rs2.getString("marks2"));
               jmarks3.setText(rs2.getString("marks3"));
               jmarks4.setText(rs2.getString("marks4"));
               jsem.setText(rs2.getString("semister"));
               
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       
       
       
       
       
       setLayout(null);
       setSize(500,600);
       setLocation(400,70);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==cancel)
       {
           setVisible(false);
       }
   }
    
    public static void main(String args[])
    {
        new Marks("");
    }
}
