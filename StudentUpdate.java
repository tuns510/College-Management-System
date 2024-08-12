
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentUpdate extends JFrame implements ActionListener {
    
    Choice crollno;
    JTextField taddr,tphone,tfemail,tcource,tbranch;
    JButton update,cancel;
    JLabel srno;
    StudentUpdate()
    {
        setLayout(null);
        
        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(10,10,500,40);
        heading.setFont(new Font("tahoma",Font.ITALIC,30));
        add(heading);
        
        srno=new JLabel("Select Roll Number");
        srno.setBounds(10,70,150,20);
        srno.setFont(new Font("serif",Font.PLAIN,15));
        add(srno);
        
        crollno=new Choice();
        crollno.setBounds(160,70,150,20);
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
        
  //name
        
        JLabel jname=new JLabel("Name");
        jname.setBounds(10,110,100,20);
        jname.setFont(new Font("serif",Font.BOLD,20));
        add(jname);
        
        JLabel jtname=new JLabel();
        jtname.setBounds(170,110,100,25);
        jtname.setFont(new Font("serif",Font.PLAIN,15));
        add(jtname);
        
        

//name end
//fathers name        
        JLabel jfname=new JLabel("Father's Name");
        jfname.setBounds(400,110,150,20);
        jfname.setFont(new Font("serif",Font.BOLD,20));
        add(jfname);
        
        JLabel jffname=new JLabel();
        jffname.setBounds(560,110,150,20);
        jffname.setFont(new Font("serif",Font.PLAIN,15));
        add(jffname);
        
        
        
//end Fathers name
//roll number

        JLabel jrno=new JLabel("Roll Number");
        jrno.setBounds(10,150,150,20);
        jrno.setFont(new Font("serif",Font.BOLD,20));
        add(jrno);
        
        JLabel jrono=new JLabel();
        jrono.setBounds(170,150,150,20);
        jrono.setFont(new Font("serif",Font.PLAIN,15));
        add(jrono);
        
        
 //end roll number
 // date of birth
 
           JLabel jdob=new JLabel("Date of Birth");
           jdob.setBounds(400,150,150,20);
           jdob.setFont(new Font("serif",Font.BOLD,20));
           add(jdob);
           
           JLabel jldob=new JLabel();
           jldob.setBounds(560,150,150,20);
           jldob.setFont(new Font("serif",Font.PLAIN,15));
           add(jldob);
           
           
 //end date of birth
 //address
 
            JLabel jadd=new JLabel("Address");
            jadd.setBounds(10,190,150,20);
            jadd.setFont(new Font("serif",Font.BOLD,20));
            add(jadd);
            
            taddr=new JTextField();
            taddr.setBounds(170,190,150,25);
            add(taddr);
            
//end address 
//Phone

            JLabel jphone=new JLabel("Phone");
            jphone.setBounds(400,190,150,20);
            jphone.setFont(new Font("serif",Font.BOLD,20));
            add(jphone);
            
            tphone=new JTextField();
            tphone.setBounds(560,190,150,25);
            add(tphone);
            
 //end Phone           
 //Email id
 
              JLabel jemail=new JLabel("Email Id");
              jemail.setBounds(10,240,150,20);
              jemail.setFont(new Font("serif",Font.BOLD,20));
              add(jemail);
 
              tfemail=new JTextField();
              tfemail.setBounds(170,240,150,25);
              add(tfemail);
              
 //end email id
 //adhar no
 
              JLabel jadhar=new JLabel("Adhar Number");
              jadhar.setBounds(400,240,150,20);
              jadhar.setFont(new Font("serif",Font.BOLD,20));
              add(jadhar);
              
              JLabel jladhar=new JLabel();
              jladhar.setBounds(560,240,150,20);
              jladhar.setFont(new Font("serif",Font.PLAIN,15));
              add(jladhar);
              
 //end adhar             
 
 //Class x
            
              JLabel jclass=new JLabel("Class x(%)");
              jclass.setBounds(10,280,150,20);
              jclass.setFont(new Font("serif",Font.BOLD,20));
              add(jclass);
              
              JLabel jlclass=new JLabel();
              jlclass.setBounds(170,280,150,20);
              jlclass.setFont(new Font("serif",Font.PLAIN,15));
              add(jlclass);
 
//end  class x
//class xii

              JLabel jxii=new JLabel("Class XII(%)");
              jxii.setBounds(400,280,150,20);
              jxii.setFont(new Font("serif",Font.BOLD,20));
              add(jxii);
              
              JLabel jlxii=new JLabel();
              jlxii.setBounds(560,280,150,20);
              jlxii.setFont(new Font("serif",Font.PLAIN,15));
              add(jlxii);
 //class xii             
 //cource
             JLabel jcource=new JLabel("Cource");
             jcource.setBounds(10,320,150,20);
             jcource.setFont(new Font("serif",Font.BOLD,20));
             add(jcource);
             
             tcource=new JTextField();
             tcource.setBounds(170,320,150,25);
             add(tcource);
             
 //end cource
 //Branch
             
             JLabel jbranch=new JLabel("Branch");
             jbranch.setBounds(400,320,150,20);
             jbranch.setFont(new Font("serif",Font.BOLD,20));
             add(jbranch);
                
             tbranch=new JTextField();
             tbranch.setBounds(560,320,150,25);
             add(tbranch);
             
 //end Branch            
               
            try
            {
                Conn c=new Conn();
                String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    jtname.setText(rs.getString("name"));
                    jffname.setText(rs.getString("fname"));
                    jrono.setText(rs.getString("rollno"));
                    jldob.setText(rs.getString("dofb"));
                    jladhar.setText(rs.getString("an"));
                    jlclass.setText(rs.getString("cx"));
                    jlxii.setText(rs.getString("cxii"));
                    taddr.setText(rs.getString("addr"));
                    tphone.setText(rs.getString("phn"));
                    tfemail.setText(rs.getString("temail"));
                    tcource.setText(rs.getString("co"));
                    tbranch.setText(rs.getString("br"));
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
                    jtname.setText(rs.getString("name"));
                    jffname.setText(rs.getString("fname"));
                    jrono.setText(rs.getString("rollno"));
                    jldob.setText(rs.getString("dofb"));
                    jladhar.setText(rs.getString("an"));
                    jlclass.setText(rs.getString("cx"));
                    jlxii.setText(rs.getString("cxii"));
                    taddr.setText(rs.getString("addr"));
                    tphone.setText(rs.getString("phn"));
                    tfemail.setText(rs.getString("temail"));
                    tcource.setText(rs.getString("co"));
                    tbranch.setText(rs.getString("br"));
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
                }
            });
            
           
 // buttons
 
           update=new JButton("Update");
           update.setBounds(200,380,150,25);
           update.setForeground(Color.WHITE);
           update.setBackground(Color.BLACK);
           update.addActionListener(this);
           add(update);
           
           cancel=new JButton("Cancel");
           cancel.setBounds(450,380,150,25);
           cancel.setForeground(Color.WHITE);
           cancel.setBackground(Color.BLACK);
           cancel.addActionListener(this);
           add(cancel);
 
        setSize(800,600);
        setLocation(270,70);
        setVisible(true);
        
    }

    
  
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            String rollno=crollno.getSelectedItem();
            String addr=taddr.getText();
            String temail=tfemail.getText();
            String phn=tphone.getText();
            String co=tcource.getText();
            String br=tbranch.getText();
            
            
            try
            {
                String query="update student set addr='"+addr+"',phn='"+phn+"',temail='"+temail+"',co='"+co+"',br='"+br+"'";
                Conn c=new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Student Details Updated successesfuly");
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
        new StudentUpdate();
    }


       
    }

