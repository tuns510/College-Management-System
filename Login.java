

package javaapplication9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,can;
    JTextField usrname,jpass;
    
    Login()
    {
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel username=new JLabel("Username :-");
      username.setBounds(40, 20, 100, 20);
      add(username);
      
      usrname=new JTextField();
      usrname.setBounds(130,20,150,20);
      add(usrname);
      
      JLabel pass=new JLabel("Password :-");
      pass.setBounds(40,70,100,20);
      add(pass);
      
       jpass=new JPasswordField();
      jpass.setBounds(130,70,150,20);
      add(jpass);
      
       login=new JButton("Login");
      login.setBounds(40,120,120,30);
      login.setBackground(Color.BLACK);
      login.setForeground(Color.WHITE);
      login.addActionListener(this);
      login.setFont(new Font("serif", Font.BOLD,17));
      add(login);
      
      can=new JButton("Cancel");
      can.setBounds(170,120,120,30);
      can.setBackground(Color.BLACK);
      can.setForeground(Color.WHITE);
      can.addActionListener(this);

      can.setFont(new Font("serif",Font.BOLD,17));
      add(can);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
      Image i2=i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel img=new JLabel(i3);
      img.setBounds(350,0,200,200);
      add(img);
      
      setSize(600,300);
      setLocation(350,200);
      setVisible(true);
        
    }
      public void actionPerformed(ActionEvent ae)
      {
          if(ae.getSource()==login){
              String username=usrname.getText();
              String password=jpass.getText();
             
              String query="select * from login where username='"+username+"'and password='"+password+"'";
              
              try{
                 Conn c=new Conn();
                  ResultSet rs = c.s.executeQuery(query);
                 
                 if(rs.next())
                 {
                  setVisible(false);  
                  new Project();
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"Invalid useername or password");
                     setVisible(false);
                 }
                 
              }catch(Exception e){
                  e.printStackTrace();
              }
          }
          else if(ae.getSource()==can){
              setVisible(false);
          }
      }
      
    public static void main(String[] args)
    {
        new Login();
    }
}
