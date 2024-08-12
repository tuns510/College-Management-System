package javaapplication9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setSize(1920, 1080);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        //new information
        JMenu info = new JMenu("NEW INFORMATION");
        info.setForeground(Color.BLUE);
        
        mb.add(info);

        JMenuItem itm1 = new JMenuItem("new Facaulty");
        itm1.setBackground(Color.WHITE);
        itm1.addActionListener(this);
        info.add(itm1);

        JMenuItem itm2 = new JMenuItem("new Student");
        itm2.setBackground(Color.WHITE);
        itm2.addActionListener(this);
        info.add(itm2);

        //end information 
        //view adetails
        JMenu info2 = new JMenu("View Details");
        info2.setForeground(Color.BLUE);
        
        mb.add(info2);

        JMenuItem itm3 = new JMenuItem("View Facaulty details");
        itm3.setBackground(Color.WHITE);
        itm3.addActionListener(this);
        info2.add(itm3);

        JMenuItem itm4 = new JMenuItem("View Student Details");
        itm4.setBackground(Color.WHITE);
        itm4.addActionListener(this);
        info2.add(itm4);

        //details end
        //Aplay leave 
        JMenu info3 = new JMenu("apply leave");
        info3.setForeground(Color.BLUE);
        mb.add(info3);

        JMenuItem itm5 = new JMenuItem("Facaulty leave");
        itm5.setBackground(Color.WHITE);
        itm5.addActionListener(this);
        info3.add(itm5);

        JMenuItem itm6 = new JMenuItem("Student Leave");
        itm6.setBackground(Color.WHITE);
        itm6.addActionListener(this);
        info3.add(itm6);
        
        JMenu info4=new JMenu("Leave Details");
        info4.setForeground(Color.BLUE);
        mb.add(info4);
        
        JMenuItem jitm6=new JMenuItem("Student Leave Details");
        jitm6.setBackground(Color.WHITE);
        jitm6.addActionListener(this);
        info4.add(jitm6);
        
        JMenuItem jitm7=new JMenuItem("Teacher Leave Details");
        jitm7.setBackground(Color.WHITE);
        jitm7.addActionListener(this);
        info4.add(jitm7);

        //Apply leave end
        //Exams starts
        JMenu info5 = new JMenu("Examination");
        info5.setForeground(Color.BLUE);
        mb.add(info5);

        JMenuItem itm7 = new JMenuItem("Examination Details");
        itm7.setBackground(Color.WHITE);
        itm7.addActionListener(this);
        info5.add(itm7);

        JMenuItem itm8 = new JMenuItem("Enter Marks");
        itm8.setBackground(Color.WHITE);
        itm8.addActionListener(this);
        info5.add(itm8);
         
          //end Exam
          
          
        JMenu in=new JMenu("Update details");
        in.setForeground(Color.BLUE);
        mb.add(in);
        
        JMenuItem jin=new JMenuItem("Update Faculty Details");
        jin.setBackground(Color.white);
        jin.addActionListener(this);
        in.add(jin);
        
        JMenuItem jin1=new JMenuItem("Update Student Dtails");
        jin1.setBackground(Color.WHITE);
        jin1.addActionListener(this);
        in.add(jin1);
        
        
        //Fee details start
        JMenu info6 = new JMenu("Fee Details");
        info6.setForeground(Color.BLUE);
        mb.add(info6);

        JMenuItem item = new JMenuItem("fee Structure");
        item.setBackground(Color.WHITE);
        item.addActionListener(this);
        
        info6.add(item);

        JMenuItem item1 = new JMenuItem("Student Fee Form");
        item1.setBackground(Color.white);
        item1.addActionListener(this);
        info6.add(item1);

        //Fee details end
        //utility starts
        JMenu info7 = new JMenu("Utility");
        info7.setForeground(Color.BLUE);
        mb.add(info7);

        JMenuItem item2 = new JMenuItem("Notepad");
        item2.setBackground(Color.WHITE);
        item2.addActionListener(this);
        info7.add(item2);

        JMenuItem item3 = new JMenuItem("Calculater");
        item3.setBackground(Color.WHITE);
        item3.addActionListener(this);
        info7.add(item3);

        //utility end
        //about
        
        JMenu ab=new JMenu("About");
        ab.setForeground(Color.BLUE);
        mb.add(ab);
        
        JMenuItem jmitm=new JMenuItem("About");
        jmitm.setBackground(Color.WHITE);
        jmitm.addActionListener(this);
        ab.add(jmitm);
        
        //exit starts
        JMenu info8 = new JMenu("Exit");
        info8.setForeground(Color.BLUE);
        mb.add(info8);

        JMenuItem item4 = new JMenuItem("Exit");
        item4.setBackground(Color.WHITE);
        item4.addActionListener(this);
        info8.add(item4);

        setJMenuBar(mb);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
     String msg=ae.getActionCommand();
     if(msg.equals("Exit"))
     {
         setVisible(false);
     }else if(msg.equals("Calculater"))
     {
         try{
             Runtime.getRuntime().exec("calc.exe");
         }catch(Exception e)
         {
            e.printStackTrace();
         }
     }else if(msg.equals("Notepad"))
     {
         try{
             Runtime.getRuntime().exec("Notepad.exe");
         }catch(Exception e)
         {
             e.printStackTrace();
             
         }
     }else if(msg.equals("new Facaulty"))
     {
         new AddTeacher();
     }else if(msg.equals("new Student"))
     {
         new AddStudent();
     }else if(msg.equals("View Facaulty details"))
     {
         new TeacherDetails();
     }else if(msg.equals("View Student Details"))
     {
         new StudentDetails();
     }else if(msg.equals("Facaulty leave"))
     {
         new TeacherLeave();
     }else if(msg.equals("Student Leave"))
     {
         new StudentLeave();
         
     }else if(msg.equals("Student Leave Details"))
     {       
         new StudentLeaveDetails();
     }else if(msg.equals("Teacher Leave Details"))
     {
         new TeacherLeavedetails();
     }else if(msg.equals("Update Faculty Details"))
     {
         new TeacherUpdate();
     }else if(msg.equals("Update Student Dtails"))
     {
         new StudentUpdate();
     }else if(msg.equals("Enter Marks"))
     {
         new ExamMarks();
     }else if(msg.equals("Examination Details"))
     {
         new Examination();
     }else if(msg.equals("fee Structure"))
     {
         new FeeStructure();
     }else if(msg.equals("About"))
     {
         new About();
     }else if(msg.equals("Student Fee Form"))
     {
         new StudentFeeForm();
     }
     
    }

    public static void main(String args[]) {
        new Project();
    }
}
