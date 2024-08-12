
package javaapplication9;
 
import javax.swing.*;
import java.awt.*;
public class Spash extends JFrame implements Runnable
{
   Thread t;
    Spash()
    {
               
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/first.jpg"));
        Image i2= i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        
         add(image);
         
         t=new Thread(this);
         t.start();
         int x=1;
         int i;
         for( i=2; i<=600;i+=4,x+=1)
         {
               setLocation(500 - ((i+x)/2),300-(i/2));
               setSize(i+3*x,i+x/2);
               setVisible(true);
               try
               {
                 Thread.sleep(10);
                 
               }catch(Exception e){}
         }
    }
    public void run()
    {
        try 
        {
          Thread.sleep(7000);
          setVisible(false);
          //NEXT FRAME
          new Login();
          
        }catch(Exception e) {}
    }
    public static void main(String[] args)
    {
        new Spash();   
    }

   

    
}
