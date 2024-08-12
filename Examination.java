
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class Examination extends JFrame implements ActionListener
{
    Choice crollno;
    JTextField search;
    JButton jresult,jback;
    JTable jtable;
    
  Examination()
  {
      setLayout(null);
      
      getContentPane().setBackground(Color.WHITE);
      
      JLabel heading=new JLabel("Check Result");
      heading.setBounds(20,20,400,30);
      heading.setFont(new Font("serif",Font.BOLD,25));
      add(heading);
      
      search=new JTextField();
      search.setBounds(20,80,150,30);
      add(search);
      
      //buttons
      
      jresult=new JButton("Result");
      jresult.setBounds(180,80,100,25);
      jresult.setBackground(Color.BLACK);
      jresult.setForeground(Color.WHITE);
      jresult.addActionListener(this);
      add(jresult);
      
      jback=new JButton("Back");
      jback.setBounds(290,80,100,25);
      jback.setBackground(Color.BLACK);
      jback.setForeground(Color.WHITE);
      jback.addActionListener(this);
      add(jback);
      
      jtable=new JTable();
      jtable.setFont(new Font("tahoma",Font.PLAIN,15));
      
      JScrollPane jsp=new JScrollPane(jtable);
      jsp.setBounds(0,120,1000,300);
      add(jsp);
      
      try
      {
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery("select * from student");
          jtable.setModel(DbUtils.resultSetToTableModel(rs));
          
          
          
      }catch(Exception e)
      {
          e.printStackTrace();
      }
      
      jtable.addMouseListener(new MouseAdapter()  {
          public void mouseClicked(MouseEvent me)
          {
              int row=jtable.getSelectedRow();
              search.setText(jtable.getModel().getValueAt(row, 2).toString());
          }
      });
      
      setSize(1050,500);
      setLocation(100,50);
      setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
      if(ae.getSource()==jresult)
      {
          setVisible(false);
          new Marks(search.getText());
      }else
      {
          setVisible(false);
      }
  }
  public static void main(String args[])
  {
      new Examination();
  }
}
