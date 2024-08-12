
package javaapplication9;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class StudentLeave extends JFrame implements ActionListener{
    Choice choice ,time;
    JDateChooser tdate;
    JButton submit,cancel;
    StudentLeave()
    {
        setLayout(null);
        setSize(500,500);
        setLocation(400,100);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("Apply Leave Student");
        heading.setBounds(30,10,500,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel search=new JLabel("Search by roll Number");
        search.setBounds(50,60,400,20);
        add(search);
        
        choice=new Choice();
        choice.setBounds(50,80,200,20);
        add(choice);
        
        try
        {
            Conn con=new Conn();
            ResultSet rs=con.s.executeQuery("select * from student ");
            while(rs.next())
            {
                choice.add(rs.getString("rollno"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel dd=new JLabel("Date");
        dd.setBounds(50,130,100,20);
        dd.setFont(new Font("tahoma",Font.BOLD,20));
        add(dd);
        
        tdate=new JDateChooser();
        tdate.setBounds(50,155,200,20);
        add(tdate);
        
        JLabel td=new JLabel("Time Duration");
        td.setBounds(50,195,200,20);
        td.setFont(new Font("tahoma",Font.BOLD,20));
        add(td);
        
        time=new Choice();
        time.setBounds(50,250,200,15);
        time.setFont(new Font("tahoma",Font.BOLD,15));
        time.add("Half Day");
        time.add("Full Day");
        add(time);
        
        submit=new JButton("Submit");
        submit.setBounds(50,300,150,30);
        submit.setFont(new Font("tahoma",Font.BOLD,20));
        submit.addActionListener(this);
        add(submit);
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(250,300,150,30);
        cancel.setFont(new Font("tahoma",Font.BOLD,20));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String rollno=choice.getSelectedItem();
            String date=((JTextField) tdate.getDateEditor().getUiComponent()).getText();
            String duration=time.getSelectedItem();
            
            String query="insert into studentleave values('"+rollno+"','"+date+"','"+duration+"')";
            
         try
         {
             Conn c=new Conn();
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Leave Confirmed");
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
        new StudentLeave();
    }
}
