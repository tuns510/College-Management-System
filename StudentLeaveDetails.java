
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentLeaveDetails extends JFrame implements ActionListener{
    Choice crollno;
    JTable table;
    JButton search,print,cancel;
    StudentLeaveDetails()
    {
        setLayout(null);
        
        JLabel heading=new JLabel("Search by Roll number");
        heading.setBounds(50,20,150,20);
        add(heading);
        
        crollno=new Choice();
        crollno.setBounds(210,20,200,20);
        add(crollno);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from studentleave");
            while(rs.next())
            {
             crollno.add(rs.getString("rollno"));
             
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        table=new JTable();
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1000,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(30,60,100,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(140,60,100,20);
        print.addActionListener(this);
        add(print);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250,60,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(1000,700);
        setLocation(50,50);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
            String query="select *from studentleave where rollno='"+crollno.getSelectedItem()+"'";
            
            try
            {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==print)
        {
            try
            {
                table.print();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            setVisible(false);
        }
    }
    
    public static  void main(String[] args)
    {
        new StudentLeaveDetails();
    }
    
}
