
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame
{
    FeeStructure()
    {
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading =new JLabel("Fee Structure");
        heading.setBounds(10,10,400,30);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        JTable jtable=new JTable();
        try
        {
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery("select * from fee");
          jtable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(jtable);
        jsp.setBounds(0,70,1000,500);
        add(jsp);
        
        setSize(1000,600);
        setLocation(150,50);
        setVisible(true);
        
    }

  public static void main(String args[])
  {
      new FeeStructure();
  }         
}
