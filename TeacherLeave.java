
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class TeacherLeave extends JFrame implements ActionListener{
    Choice cempid,time;
    JDateChooser jdate;
    JButton submit,cancel;
    TeacherLeave()
    {
        
        setLayout(null);
        setSize(500,500);
        setLocation(400,100);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Teacher Leave");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel search=new JLabel("Search by Employee ID");
        search.setBounds(60,70,300,20);
        add(search);
        
        cempid=new Choice();
        cempid.setBounds(60,90,200,20);
        add(cempid);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher3");
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
                
        JLabel date=new JLabel("Date");
        date.setBounds(60,150,200,20);
        date.setFont(new Font("tahoma",Font.BOLD,20));
        add(date);
        
        jdate=new JDateChooser();
        jdate.setBounds(60,180,200,20);
        add(jdate);
        
        JLabel td=new JLabel("Time Duration");
        td.setBounds(60,240,200,20);
        td.setFont(new Font("tahoma",Font.BOLD,20));
        add(td);
        
        time=new Choice();
        time.setBounds(60,280,200,20);
        time.setFont(new Font("tahoma",Font.BOLD,20));
        time.add("Half day");
        time.add("Full day");
        add(time);
        
        submit =new JButton("Submit");
        submit.setBounds(80,320,120,30);
        submit.setFont(new Font("tahoma",Font.BOLD,20));
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(220,320,120,30);
        cancel.setFont(new Font("tahoma",Font.BOLD,20));
        cancel.addActionListener(this);
        add(cancel);
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String empid=cempid.getSelectedItem();
            String date=((JTextField)jdate.getDateEditor().getUiComponent()).getText();
            String duration=time.getSelectedItem();
            
            String query="insert into teacherleave values('"+empid+"','"+date+"','"+duration+"')";
            
            try
            {
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"teacher leave  conformed");
                setVisible(false);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
       new TeacherLeave();
        
    }
}
