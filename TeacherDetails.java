
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice cempid;
    JTable table;
    JButton search,update,add,print,cancel;
    
    TeacherDetails()
    {
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel heading=new JLabel("Search by Employee ID");
     heading.setBounds(10,10,200,20);
     add(heading);
     
     cempid=new Choice();
     cempid.setBounds(240,10,200,20);
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
     
     table=new JTable();
     
     try
     {
         Conn c=new Conn();
         ResultSet rs=c.s.executeQuery("select * from teacher3");
         table.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(Exception e)
     {
         e.printStackTrace();
     }
     
     JScrollPane jsp=new JScrollPane(table);
     jsp.setBounds(0,100,1300,600);
     add(jsp);
     
     //buttons
     
     search=new JButton("Scarch");
     search.setBounds(30,60,95,20);
     search.setFont(new Font("serif",Font.BOLD,20));
     search.addActionListener(this);
     add(search);
     
     print=new JButton("Print");
     print.setBounds(135,60,85,20);
     print.setFont(new Font("serif",Font.BOLD,20));
     print.addActionListener(this);
     add(print);
     
     update=new JButton("Update");
     update.setBounds(230,60,100,20);
     update.setFont(new Font("serif",Font.BOLD,20));
     update.addActionListener(this);
     add(update);
     
     add = new JButton("Add");
     add.setBounds(340,60,80,20);
     add.setFont(new Font("serif",Font.BOLD,20));
     add.addActionListener(this);
     add(add);
     
     cancel=new JButton("Cancel");
     cancel.setBounds(430,60,95,20);
     cancel.setFont(new Font("serif",Font.BOLD,20));
     cancel.addActionListener(this);
     add(cancel);
     
     setSize(1300,700);
     setLocation(10,10);
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==search)
     {
         String query="select * from teacher3 where empid ='"+cempid.getSelectedItem()+"'";
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
         
     }else if(ae.getSource()==update)
     {
      setVisible(true);
       new TeacherUpdate();
         
     }else if(ae.getSource()==add)
     {
         setVisible(true);
         new AddTeacher();    
     }else
     {
         setVisible(false);
     }
        
    }
    
    public static void main(String args[])
    {
        new TeacherDetails();
    }
}
