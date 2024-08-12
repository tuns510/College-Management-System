
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener
{
    Choice crollno;
    JComboBox jbcource,jbbranch, jbsem;
    JLabel jpay;
    JButton update,pay,back;
    StudentFeeForm()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(400,0,450,300);
        add(img);
        
        JLabel jrollno=new JLabel("Select Roll Number");
        jrollno.setBounds(10,50,150,20);
        jrollno.setFont(new Font("serif",Font.PLAIN,18));
        add(jrollno);
        
        crollno=new Choice();
        crollno.setBounds(180,50,150,20);
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
        
        JLabel jname=new JLabel("Name");
        jname.setBounds(10,90,150,20);
        jname.setFont(new Font("serif",Font.BOLD,18));
        add(jname);
        
        JLabel jjname=new JLabel();
        jjname.setBounds(180,90,150,20);
        add(jjname);
        
        JLabel jfname=new JLabel("Father's Name");
        jfname.setBounds(10,130,150,20);
        jfname.setFont(new Font("serif",Font.BOLD,18));
        add(jfname);
        
        JLabel jjfname=new JLabel();
        jjfname.setBounds(180,130,150,20);
        add(jjfname);
        
        try
        {
         Conn c=new Conn();
         String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
         ResultSet rs=c.s.executeQuery(query);
         while(rs.next())
         {
             jjname.setText(rs.getString("name"));
             jjfname.setText(rs.getString("fname"));
         }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
               try
               {
                   Conn c=new Conn();
                   String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
                   ResultSet rs=c.s.executeQuery(query);
                   while(rs.next())
                   {
                       jjname.setText(rs.getString("name"));
                       jjfname.setText(rs.getString("fname"));
                   }
               }catch(Exception e)
               {
                   e.printStackTrace();
               }
            }
        });
        
        JLabel jcource=new JLabel("Cource");
        jcource.setBounds(10,170,150,20);
        jcource.setFont(new Font("serif",Font.BOLD,18));
        add(jcource);
        
        String cource[]={"B-TECH","M-TECH","BCA","BBA","MBA","MCA","Bsc","Msc"};
        jbcource=new JComboBox(cource);
        jbcource.setBounds(180,170,150,20);
        jbcource.setBackground(Color.WHITE);
        add(jbcource);
        
        
        JLabel jbranch=new JLabel("Branch");
        jbranch.setBounds(10,210,150,20);
        jbranch.setFont(new Font("serif",Font.BOLD,18));
        add(jbranch);
        
        String branch[]={"Computer Science","Electionics","Mechanical","IT","Civil"};
        
        jbbranch=new JComboBox(branch);
        jbbranch.setBounds(180,210,150,20);
        jbbranch.setBackground(Color.WHITE);
        add(jbbranch);
        
        JLabel jsem=new JLabel("Semister");
        jsem.setBounds(10,250,150,20);
        jsem.setFont(new Font("serif",Font.BOLD,18));
        add(jsem);
        
        
        String semister[]={"semister1","semister2","semister3","semister4","semister5","semister6"};
        
        jbsem=new JComboBox(semister);
        jbsem.setBounds(180,250,150,20);
        jbsem.setBackground(Color.WHITE);
        add(jbsem);
        
        JLabel total=new JLabel("Total Payable");
        total.setBounds(10,290,150,20);
        total.setFont(new Font("serif",Font.BOLD,18));
        add(total);
        
        jpay=new JLabel();
        jpay.setBounds(180,290,150,20);
        add(jpay);
        
        
        
        
        update=new JButton("Update");
        update.setBounds(10,340,100,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        
        pay=new JButton("Pay Fee");
        pay.setBounds(120,340,100,20);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);
        
        back=new JButton("Back");
        back.setBounds(230,340,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setSize(800,500);
        setLocation(250,80);
        setVisible(true);        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            String cource=(String) jbcource.getSelectedItem();
            String semister=(String) jbsem.getSelectedItem();
            
            try
            {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from fee where cource='"+jbcource.getSelectedItem()+"' ");
                while (rs.next())
                {
                    jpay.setText(rs.getString(semister));
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==pay)
        {
            String rollno=crollno.getSelectedItem();
            String cource=(String)jbcource.getSelectedItem();
            String semister=(String)jbsem.getSelectedItem();
            String branch=(String) jbbranch.getSelectedItem();
            String total=jpay.getText();
            
            try
            {
                Conn c=new Conn();
                String query="insert into collegefee values='"+rollno+"','"+cource+"','"+branch+"','"+semister+"','"+total+"'";
                
                JOptionPane.showMessageDialog(null,"Collage fee submited succsessfuly");
                c.s.executeUpdate(query);
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
        new StudentFeeForm();
    }
}
