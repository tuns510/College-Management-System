
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tname,tfname,taddrs,tphone,temail,tadhar,xi,xii;
    JLabel empId;
    JDateChooser tdate;
    JButton submit,cancel;
    JComboBox tquli,tdepart;
    
    Random ran=new Random();
    long first4=Math.abs(ran.nextLong()%9000L)+1000L;
     AddTeacher()
     
{         setSize(900,600);
         setLocation(170,70);
         setLayout(null);
         
         //heading
         
         JLabel heading=new JLabel("new Teacher Information");
         heading.setBounds(300,20,500,50);
         heading.setFont(new Font("serif",Font.BOLD,30));
         add(heading);
     
         //end heading
         //name
         
         JLabel name=new JLabel("Name");
         name.setBounds(50,80,150,30);
         name.setFont(new Font("serif",Font.BOLD,20));
         add(name);
         
         tname=new JTextField();
         tname.setBounds(200,80,200,30);
         add(tname);
         
         //name end
         //father name
         
         JLabel fn=new JLabel("Fathers Name");
         fn.setBounds(450,80,200,30);
         fn.setFont(new Font("serif",Font.BOLD,20));
         add(fn);
         
         tfname=new JTextField();
         tfname.setBounds(600,80,200,30);
         add(tfname);
         
         //fathers name end
         //employe id
         
         JLabel empid=new JLabel("Employee ID");
         empid.setBounds(50,130,150,30);
         empid.setFont(new Font("serif",Font.BOLD,20));
         add(empid);
         
         empId=new JLabel("1001"+first4);
         empId.setBounds(200,130,150,30);
         empId.setFont(new Font("serif",Font.BOLD,20));
         add(empId);
         
         //employee id end
         //date of birth
         
         JLabel dob=new JLabel("Date Of Birth");
         dob.setBounds(450,130,150,30);
         dob.setFont(new Font("serif",Font.BOLD,20));
         add(dob); 
         
         tdate=new JDateChooser();
         tdate.setBounds(600,130,200,30);
         add(tdate);
         
         //end date of birth
         //address
         
         JLabel  ad=new JLabel("Address");
         ad.setBounds(50,180,200,30);
         ad.setFont(new Font("serif",Font.BOLD,20));
         add(ad);
         
         taddrs=new JTextField();
         taddrs.setBounds(200,180,200,30);
         add(taddrs);
         
         //address end
         //Phone
         
         JLabel ph=new JLabel("Phone");
         ph.setBounds(450,180,200,30);
         ph.setFont(new Font("serif",Font.BOLD,20));
         add(ph);
         
         tphone=new JTextField();
         tphone.setBounds(600,180,200,30);
         add(tphone);
         
         //end phone
         //email
         
         JLabel em=new JLabel("Email");
         em.setBounds(50,230,200,30);
         em.setFont(new Font("serif",Font.BOLD,20));
         add(em);
         
         temail=new JTextField();
         temail.setBounds(200,230,200,30);
         add(temail);
         
         //end email
         //Adhar
       
         JLabel adhar=new JLabel("Adhar");
         adhar.setBounds(450,230,200,30);
         adhar.setFont(new Font("serif",Font.BOLD,20));
         add(adhar);
         
         tadhar=new JTextField();
         tadhar.setBounds(600,230,200,30);
         add(tadhar);
         
         //end adhar
         //x marks
         
         JLabel xm=new JLabel("Class X (%)");
         xm.setBounds(50,280,200,30);
         xm.setFont(new Font("serif",Font.BOLD,20));
         add(xm);
         
         
         xi=new JTextField();
         xi.setBounds(200,280,200,30);
         add(xi);
         
         //x marks end
         ///xii marks
         
         JLabel xim=new JLabel("Class XII (%)");
         xim.setBounds(450,280,200,30);
         xim.setFont(new Font("serif",Font.BOLD,20));
         add(xim);
         
         xii=new JTextField();
         xii.setBounds(600,280,200,30);
         add(xii);
         
         //xii marks end
         //qualification
         
         JLabel qu=new JLabel("Qualification");
         qu.setBounds(50,330,200,30);
         qu.setFont(new Font("serif",Font.BOLD,20));
         add(qu);
         
         
         String Qualification[]={"MCA","MBA","M-Tach","Msc"};
         tquli=new JComboBox(Qualification);
         tquli.setBounds(200,330,200,30);
         tquli.setFont(new Font("serif",Font.BOLD,20));
         add(tquli);
         
         //qualification ends
         //department
         
         JLabel dep=new JLabel("Department");
         dep.setBounds(450,330,200,30);
         dep.setFont(new Font("serif",Font.BOLD,20));
         add(dep);
         
         String Department[]={"Computer Science","Electionics","Mechanical","IT","Civil"};
         tdepart=new JComboBox(Department);
         tdepart.setBounds(600,330,200,30);
         tdepart.setFont(new Font("serif",Font.BOLD,20));
         add(tdepart);
         
                        
         
         //department end
         //submit button
         
         submit=new JButton("Submit");
         submit.setBounds(120,400,150,30);
         submit.setFont(new Font("serif",Font.BOLD,25));
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.addActionListener(this);
         add(submit);
         
         //submit button ends
         //cancel button 
         
         cancel=new JButton("Cancel");
         cancel.setBounds(500,400,150,30);
         cancel.setFont(new Font("serif",Font.BOLD,25));
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.addActionListener(this);
         add(cancel); 
         
         setVisible(true);
     }
     
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==submit)
         {
             String name=tname.getText();
             String fname=tfname.getText();
             String empid=empId.getText();
             String dob=((JTextField)tdate.getDateEditor().getUiComponent()).getText();
             String addr=taddrs.getText();
             String phone=tphone.getText();
             String email=temail.getText();
             String adhar=tadhar.getText();
             String xm=xi.getText();
             String xim=xii.getText();
             String qu=(String)tquli.getSelectedItem();
             String dep=(String)tdepart.getSelectedItem();
             try
             {
              String query="insert into Teacher3 values('"+name+"','"+fname+"','"+empid+"','"+addr+"','"+dob+"','"+phone+"','"+email+"','"+adhar+"','"+xm+"','"+xim+"','"+qu+"','"+dep+"')" ;  
              Conn con=new Conn();
              con.s.executeUpdate(query);
              
              JOptionPane.showMessageDialog(null, "Student Details Inserted Succsessfuly");
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
     
    public static void main(String[] args)
    {
        new AddTeacher();
    }
    
}

