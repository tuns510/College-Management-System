
package javaapplication9;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherLeavedetails extends JFrame implements ActionListener{
    
    JButton search,print,cancle;
    Choice cempid;
    JTable table;
    
    TeacherLeavedetails()
    {
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JLabel heading=new JLabel("Search by Employee ID");
        heading.setBounds(10,10,150,20);
        add(heading);
        
        cempid=new Choice();
        cempid.setBounds(170,10,150,20);
        add(cempid);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacherleave");
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        table=new JTable();
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(50,100,500,500);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(50,60,100,25);
        search.addActionListener(this);
        add(search);
        
        
        print=new JButton("Print");
        print.setBounds(170,60,100,25);
        print.addActionListener(this);
        add(print);
        
        cancle=new JButton("Cancel");
        cancle.setBounds(290,60,100,25);
        cancle.addActionListener(this);
        add(cancle);
        
        
        setSize(1000,700);
        setLocation(150,30);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
            String query="select * from teacherleave where empid ='"+cempid.getSelectedItem()+"'";
            
            try
            {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception  e)
            {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==print)
        {
            try {
                table.print();
            } catch (Exception e) 
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
        new TeacherLeavedetails();
    }
}
