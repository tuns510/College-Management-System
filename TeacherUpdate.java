
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class TeacherUpdate extends JFrame implements ActionListener
{
    
    Choice cempid;
    JLabel srono;
    JTextField taddr,tphone,jfemail,tqualification,tdepartment;
    JButton update,cancel;
    
    TeacherUpdate()
    {   
        setLayout(null);
        
        JLabel heading=new JLabel("Update Teacher Details");
        heading.setBounds(10,10,400,40);
        heading.setFont(new Font("tahoma",Font.ITALIC,30));
        add(heading);
        
        //select roll no
        srono=new JLabel("Select Employee ID");
        srono.setBounds(10,70,200,20);
        srono.setFont(new Font("serif",Font.PLAIN,20));
        add(srono);
                
        cempid=new Choice();
        cempid.setBounds(220,70,150,20);
        add(cempid);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher3 ");
            while(rs.next())
            {
               cempid.add(rs.getString("empid")); 
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
       //end rollno
       //name
       
       JLabel jname=new JLabel("Name");
       jname.setBounds(10,110,150,20);
       jname.setFont(new Font("serif",Font.BOLD,20));
       add(jname);
       
       JLabel jjname=new JLabel();
       jjname.setBounds(170,110,150,20);
       jjname.setFont(new Font("serif",Font.BOLD,20));
       add(jjname);
       
        //end name
        //Fathers name
        
        JLabel jfname=new JLabel("Father's Name");
        jfname.setBounds(400,110,150,20);
        jfname.setFont(new Font("serif",Font.BOLD,20));
        add(jfname);
        
        JLabel jjfname=new JLabel();
        jjfname.setBounds(560,110,150,20);
        jjfname.setFont(new Font("serif",Font.BOLD,20));
        add(jjfname);
        
        //end farhers name
        //rollno
        
        JLabel jempid=new JLabel("Employee ID");
        jempid.setBounds(10,150,150,20);
        jempid.setFont(new Font("serif",Font.BOLD,20));
        add(jempid);
        
        JLabel jjempid=new JLabel();
        jjempid.setBounds(170,150,150,20);
        jjempid.setFont(new Font("serif",Font.BOLD,20));
        add(jjempid);
        
        //end rollno
        //date of birth
        
        JLabel jdob=new JLabel("Date of Birth");
        jdob.setBounds(400,150,150,20);
        jdob.setFont(new Font("serif",Font.BOLD,20));
        add(jdob);
        
        JLabel jjdob=new JLabel();
        jjdob.setBounds(560,150,150,20);
        jjdob.setFont(new Font("serif",Font.BOLD,20));
        add(jjdob);
        
        //end date of birth
        //address
        
        JLabel jaddr=new JLabel("Address");
        jaddr.setBounds(10,190,150,20);
        jaddr.setFont(new Font("serif",Font.BOLD,20));
        add(jaddr);
        
        taddr=new JTextField();
        taddr.setBounds(170,190,150,25);
        add(taddr);
        
        //end address
        //phone
        
        JLabel jphone=new JLabel("Phone");
        jphone.setBounds(400,190,150,20);
         jphone.setFont(new Font("serif",Font.BOLD,20));       
        add(jphone);
        
        tphone=new JTextField();
        tphone.setBounds(560,190,150,20);
        add(tphone);
        
        //end phone
        //email
        
        JLabel jemail=new JLabel("Email");
        jemail.setBounds(10,230,150,20);
        jemail.setFont(new Font("serif",Font.BOLD,20));
        add(jemail);
        
        jfemail = new JTextField();
        jfemail.setBounds(170,230,150,20);
        add(jfemail);
        
        //end email
        //adhar
        
        JLabel jadhar=new JLabel("Adhar");
        jadhar.setBounds(400,230,150,20);
        jadhar.setFont(new Font("serif",Font.BOLD,20));
        add(jadhar);
        
        JLabel jjadhar=new JLabel();
        jjadhar.setBounds(560,230,150,20);
        jjadhar.setFont(new Font("serif",Font.BOLD,20));
        add(jjadhar);
        
        //end adhar
        //class x
        
        JLabel jclassx=new JLabel("Class X(%)");
        jclassx.setBounds(10,270,150,20);
        jclassx.setFont(new Font("serif",Font.BOLD,20));
        add(jclassx);
        
        JLabel jjclassx=new JLabel();
        jjclassx.setBounds(170,270,150,20);
        jjclassx.setFont(new Font("serif",Font.BOLD,20));
        add(jjclassx); 
        
        //end class x
        //class xii
        
        JLabel jclassxii=new JLabel("Class XII(&)");
        jclassxii.setBounds(400,270,150,20);
        jclassxii.setFont(new Font("serif",Font.BOLD,20));
        add(jclassxii);
        
        JLabel jjclassxii=new JLabel();
        jjclassxii.setBounds(560,270,150,20);
        jclassxii.setFont(new Font("serif",Font.BOLD,20));
        add(jjclassxii);
        
        //end class xii
        //cource
        
        JLabel jcource=new JLabel("Qualification");
        jcource.setBounds(10,310,150,20);
        jcource.setFont(new Font("serif",Font.BOLD,20));
        add(jcource);
        
        tqualification=new JTextField();
        tqualification.setBounds(170,310,150,20);
        add(tqualification);
        
        //end cource
        //branch
        
        JLabel jbranch=new JLabel("Department");
        jbranch.setBounds(400,310,150,20);
        jbranch.setFont(new Font("serif",Font.BOLD,20));
        add(jbranch);
        
        tdepartment=new JTextField();
        tdepartment.setBounds(560,310,150,20);
        add(tdepartment);
        
        
        try
            {
                Conn c=new Conn();
                String query="select * from Teacher3 where empid='"+cempid.getSelectedItem()+"'";
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    jjname.setText(rs.getString("name"));
                    jjfname.setText(rs.getString("fname"));
                    jjempid.setText(rs.getString("empid"));
                    jjdob.setText(rs.getString("dob"));
                    jjadhar.setText(rs.getString("adhar"));
                    jjclassx.setText(rs.getString("xm"));
                    jjclassxii.setText(rs.getString("xim"));
                    taddr.setText(rs.getString("addr"));
                    tphone.setText(rs.getString("phone"));
                    jfemail.setText(rs.getString("email"));
                    tqualification.setText(rs.getString("quali"));
                    tdepartment.setText(rs.getString("dapar"));
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
 
            cempid.addItemListener(new ItemListener()
            {
                public void itemStateChanged(ItemEvent ie)
                {
                    
                
             try
            {
                Conn c=new Conn();
                String query="select * from Teacher3 where empid='"+cempid.getSelectedItem()+"'";
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    jjname.setText(rs.getString("name"));
                    jjfname.setText(rs.getString("fname"));
                    jjempid.setText(rs.getString("empid"));
                    jjdob.setText(rs.getString("dob"));
                    jjadhar.setText(rs.getString("adhar"));
                    jjclassx.setText(rs.getString("xm"));
                    jjclassxii.setText(rs.getString("xim"));
                    taddr.setText(rs.getString("addr"));
                    tphone.setText(rs.getString("phone"));
                    jfemail.setText(rs.getString("email"));
                    tqualification.setText(rs.getString("quali"));
                    tdepartment.setText(rs.getString("dapar"));
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
                }
            });
            
        
        //buttons
        
        update=new JButton("Update");
        update.setBounds(150,370,150,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("serif",Font.BOLD,25));
        update.addActionListener(this);
        add(update);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(450,370,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,25));
        cancel.addActionListener(this);
        add(cancel);
        
         
        setSize(800,600);
        setLocation(100,50);
        setVisible(true);        
    }
    
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==update)
         {
             String empid=cempid.getSelectedItem();
             String addr=taddr.getText();
             String phone=tphone.getText();
             String email=jfemail.getText();
             String quali=tqualification.getText();
             String depar=tdepartment.getText();
             
             try
             {
                 String query="update Teacher3 set addr='"+addr+"',phone='"+phone+"',email='"+email+"',quali='"+quali+"',depar='"+depar+"'";
                 Conn c=new Conn();
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Teacher Details Updated Successesfuly");
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
        new TeacherUpdate();
    }
}
