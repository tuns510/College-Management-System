
package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class AddStudent extends JFrame implements ActionListener {
    
    JTextField tname,tfname,addr,phn,temail,an,cx,cxii;
    JLabel rno;
    JDateChooser dofb;
    JComboBox co,br;
    JButton sub,can;
    
    Random ran=new Random();
    long first4= Math.abs(ran.nextLong() %9000L)+1000L;
    
    
    AddStudent()
    {
        setSize(900,600);
        setLocation(170,70);
        setLayout(null);
        
        //heading 
        JLabel heading=new JLabel("NEW STUDENT INFORMATION");
        heading.setBounds(200,20,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        //heading end
        //name srart
        
        JLabel name=new JLabel("Name:-");
        name.setBounds(50,80,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        //name end
        
        tname=new JTextField();
        tname.setBounds(200,80,200,30);
       // tname.setFont(new Font("serif",Font.BOLD,20));
        add(tname);
        
        //add fathers name
        
        JLabel fname=new JLabel("Fathers Name:-");
        fname.setBounds(450,80,150,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        tfname=new JTextField();
        tfname.setBounds(600,80,200,30);
        add(tfname);
        
        //fathers name ends
        
        //add roll number
        rno=new JLabel("1233"+first4);
        rno.setBounds(200,130,100,30);
        add(rno);
        
        JLabel rno=new JLabel("Roll Number:-");
        rno.setBounds(50,130,150,30);
        rno.setFont(new Font("serif",Font.BOLD,20));
        add(rno);
        
       //end roll number
       //choos date of birth
       
       JLabel dob=new JLabel("Date Of Birth:-");
       dob.setBounds(450,130,200,30);
       dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        
        dofb=new JDateChooser();
        dofb.setBounds(600,130,200,30);
        add(dofb);
        
       //end date 
       //address
       
       JLabel adrs=new JLabel("Address :-");
       adrs.setBounds(50,180,200,30);
       adrs.setFont(new Font("serif",Font.BOLD,20));
       add(adrs);
        
       addr=new JTextField();
       addr.setBounds(200,180,200,30);
       add(addr);
       
       //end address
       //phone Number 
       
       JLabel ph=new JLabel("Phone Number :-");
       ph.setBounds(450,180,200,30);
       ph.setFont(new Font("serif",Font.BOLD,20));
       add(ph);
        
       phn=new JTextField();
       phn.setBounds(600,180,200,30);
       add(phn);
        
       //phone umber end
       //email id
       
       JLabel eml=new JLabel("Email ID :-");
       eml.setBounds(50,230,200,30);
       eml.setFont(new Font("serif",Font.BOLD,20));
       add(eml);
       
       temail=new JTextField();
       temail.setBounds(200,230,200,30);
       add(temail);
       
       //ens Email
       //Adhar number
       
       JLabel adr=new JLabel("Adhar Number");
       adr.setBounds(450,230,200,30);
       adr.setFont(new Font("serif",Font.BOLD,20));
       add(adr);
       
       an=new JTextField();
       an.setBounds(600,230,200,30);
       add(an);
       
       //endAdharcard number
       //class x th marks
       
       JLabel x=new JLabel("Class X(%)");
       x.setBounds(50,280,200,30);
       x.setFont(new Font("serif",Font.BOLD,20));
       add(x);
       
       

       cx=new JTextField();
       cx.setBounds(200,280,200,30);
       add(cx);
       
       //end class xth marks
       //class xii th marks
       
       JLabel cxi=new JLabel("Class XII (%)");
       cxi.setBounds(450,280,200,30);
       cxi.setFont(new Font("serif",Font.BOLD,20));
       add(cxi);

       cxii=new JTextField();
       cxii.setBounds(600,280,200,30);
       add(cxii);
       
       // End class xii marks
       //Cource
       
       JLabel cou=new JLabel("Cource");
       cou.setBounds(50,330,200,30);
       cou.setFont(new Font("serif",Font.BOLD,20));
       add(cou);
       
       String cource[]={"B-Tech","BBA","BCA","BSC","M-TECH","MBA","MCA"};
       co=new JComboBox(cource);
       co.setBounds(200,330,200,30);
       co.setBackground(Color.WHITE);
       add(co);
       
       //end Cource
       //Branch 
       
        JLabel branch=new JLabel("Branch");
       branch.setBounds(450,330,200,30);
       branch.setFont(new Font("serif",Font.BOLD,20));
       add(branch);
       
       String Branch[]={"Computer Science","Electionics","Mechanical","IT","Civil"};
       br=new JComboBox(Branch);
       br.setBounds(600,330,200,30);
       br.setBackground(Color.WHITE);
       add(br);
       
       //Breanch end
       //add submit buttom
       
       sub=new JButton("Submit");
       sub.setBounds(130,400,200,30);
       sub.setFont(new Font("serif",Font.BOLD,20));
       sub.setBackground(Color.BLACK);
       sub.setForeground(Color.WHITE);
       sub.addActionListener(this);
       add(sub);
       
       can=new JButton("Cancel");
       can.setBounds(500,400,200,30);
       can.setFont(new Font("serif",Font.BOLD,20));
       can.setBackground(Color.BLACK);
       can.setForeground(Color.WHITE);
       can.addActionListener(this);
       add(can);
       
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==sub){
            String name=tname.getText();
            String fname=tfname.getText();
            String rollno=rno.getText();
            String dob=((JTextField)dofb.getDateEditor().getUiComponent()).getText();
            String address=addr.getText();
            String phone=phn.getText();
            String email=temail.getText();
            String adhar=an.getText();
            String x=cx.getText();
            String xii=cxii.getText();
            String cource=(String)co.getSelectedItem();
            String branch=(String)br.getSelectedItem();
            try{
               String query = "insert into student values('" + name + "','" + fname + "','" + rollno + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + adhar + "','" + x + "','" + xii + "','" + cource + "','" + branch + "')";     
               Conn con=new Conn();
              
               con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Details Inserted Inserted Successfully");
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
        new AddStudent();
    }
}
