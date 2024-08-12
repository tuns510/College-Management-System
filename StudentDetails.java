
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame //implements ActionListener
{
    
    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentDetails()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("search by roll number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno=new Choice();
        crollno.setBounds(180,20,200,20);
        add(crollno);
        
        try{
            
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
         
        //table dispaling
        
        
        table=new JTable();
        
        try
        {
         Conn c=new Conn();
         ResultSet rs=c.s.executeQuery("select * from student");
         table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1300,650);
        add(jsp);
        
        //tabel end
        //search button
        
        search=new JButton("Search");
        search.setBounds(50,70,95,20);
        search.setFont(new Font("serif",Font.BOLD,20));
      //  search.addActionListener(this);
        add(search);
        
        //search end
        //print button
        
        print=new JButton("Print");
        print.setBounds(155,70,90,20);
        print.setFont(new Font("serif",Font.BOLD,20));
      //  print.addActionListener(this);
        add(print);
        
        //end print
        //update button
        
        update=new JButton("Update");
        update.setBounds(255,70,100,20);
        update.setFont(new Font("serif",Font.BOLD,20));
      //  update.addActionListener(this);
        add(update);
        
        //end update
        //add button
        
        add=new JButton("Add");
        add.setBounds(365,70,80,20);
        add.setFont(new Font("serif",Font.BOLD,20));
       // add.addActionListener(this);
        add(add);
        
        //end add
        //cancel button
        
        cancel=new JButton("Cancel");
        cancel.setBounds(455,70,100,20);
        cancel.setFont(new Font("serif",Font.BOLD,20));
      //  cancel.addActionListener(this);
        add(cancel);
        
        setSize(1500,700); 
       setLocation(10,10);
        setVisible(true);
    }
    
   /* public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==search)
        {
            String query="select * from student where rollno ='"+crollno.getSelectedItem()+"'";
          try
          {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
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
        }else if(ae.getSource()==add)
        {
            setVisible(true);
            new AddStudent();
        }else if(ae.getSource()==update)
        {
            setVisible(true);
            new StudentUpdate();
        }else
        {
            setVisible(false);
        }
    }*/
    
    public static void main(String args[])
    {
        new StudentDetails();
    }
}
