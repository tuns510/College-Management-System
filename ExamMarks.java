
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ExamMarks extends JFrame implements ActionListener
{
    Choice crollno;
    JComboBox jcbox;
    JTextField jtext1,jtext2,jtext3,jtext4,jmarks1,jmarks2,jmarks3,jmarks4;
    JButton jsubmit,jback;
    
    ExamMarks()
    {
        setLayout(null);
       
       
       
       getContentPane().setBackground(Color.WHITE);
       
       //Image adding
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/exam.jpg"));
       Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(440,60,400,300);
       add(image);
       
       
       //heading
       
       JLabel heading=new JLabel("Enter Marks Of Student");
       heading.setBounds(30,10,500,30);
       heading.setFont(new Font("serif",Font.BOLD,25));
       add(heading);
       
       //end heading
       //roll no
       
        JLabel jrollno=new JLabel("Select Roll Number");
        jrollno.setBounds(30,70,200,20);
        add(jrollno);
        
        crollno=new Choice();
        crollno.setBounds(250,70,150,20);
        add(crollno);
        
        try
        {
         Conn c=new Conn();
         ResultSet rs=c.s.executeQuery("select * from student");
         while(rs.next())
         {
             crollno.add(rs.getString("rollno"));
         }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        //end rollno
        //selsect semister
        
        JLabel jsem=new JLabel("Select Semister");
        jsem.setBounds(30,110,150,20);
        add(jsem);
        
        
        String sem[]={"1st Semister","2nd Semister","3rd Semister","4th Semister","5th Semister","6th Semister"};
        jcbox=new JComboBox(sem);
        jcbox.setBounds(250,110,150,20);
        jcbox.setBackground(Color.WHITE);
        add(jcbox);
        
        //end select semister
        //enter subject and marks label
        
        JLabel jsubject=new JLabel("Enter Subject");
        jsubject.setBounds(130,150,150,20);
        add(jsubject);
        
        JLabel jmarks=new JLabel("Enter Marks");
        jmarks.setBounds(300,150,150,20);
        add(jmarks);
        
        //end enter subject and marks label
        //adding textfields for subjet and marks
        
        jtext1=new JTextField();
        jtext1.setBounds(100,190,150,20);
        add(jtext1);
        
        jtext2=new JTextField();
        jtext2.setBounds(100,215,150,20);
        add(jtext2);
        
        jtext3=new JTextField();
        jtext3.setBounds(100,240,150,20);
        add(jtext3);
        
        jtext4=new JTextField();
        jtext4.setBounds(100,265,150,20);
        add(jtext4);
        
        
        jmarks1=new JTextField();
        jmarks1.setBounds(255,190,150,20);
        add(jmarks1);
        
        jmarks2=new JTextField();
        jmarks2.setBounds(255,215,150,20);
        add(jmarks2);
        
        jmarks3=new JTextField();
        jmarks3.setBounds(255,240,150,20);
        add(jmarks3);
        
        jmarks4=new JTextField();
        jmarks4.setBounds(255,265,150,20);
        add(jmarks4);
        
        //end adding textfields for subjet and marks
        // add Buttons
        
        jsubmit=new JButton("Submit");
        jsubmit.setBounds(120,295,100,20);
        jsubmit.setForeground(Color.WHITE);
        jsubmit.setBackground(Color.BLACK);
        jsubmit.addActionListener(this);
        add(jsubmit);
        
        jback=new JButton("Back");
        jback.setBounds(280,295,100,20);
        jback.setForeground(Color.WHITE);
        jback.setBackground(Color.BLACK);
        jback.addActionListener(this);
        add(jback);
        
        //end buttons
        
        setSize(880,450);
       setLocation(180,40);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==jsubmit)
        {
            try
            {
                Conn c=new Conn();
                 
                String query1 = "INSERT INTO subject VALUES ('" + crollno.getSelectedItem() + "','" + jcbox.getSelectedItem() + "','" + jtext1.getText() + "','" + jtext2.getText() + "','" + jtext3.getText() + "','" + jtext4.getText() + "')";
                String query2 = "INSERT INTO marks VALUES ('" + crollno.getSelectedItem() + "','" + jcbox.getSelectedItem() + "','" + jmarks1.getText() + "','" + jmarks2.getText() + "','" + jmarks3.getText() + "','" + jmarks4.getText() + "')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Marks inserted succssesfuly");
                setVisible(false); 
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
        
    }
    
    public static void main(String args[])
    {
        new ExamMarks();
    }
}
