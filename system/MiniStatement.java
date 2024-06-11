
package bank.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame  {
 
    String pinnumber;
    
    MiniStatement(String pinnumber)
    {
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel();
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
         try
         {
             Conn conn =  new Conn();
           ResultSet rs =   conn.s.executeQuery("select * from login where  Pin = '"+pinnumber+"'");
           while(rs.next())
           {
               card.setText("Card Number: "+rs.getString("Card_No"));
               
           }
          
         }
        catch(Exception e)
        {
            System.out.println(e);
        }
         
         try
         {
             Conn conn =  new Conn();
             ResultSet rs = conn.s.executeQuery("select * from deposit where pin ='"+pinnumber+"'");
             while(rs.next())
             {
                 mini.setText(mini.getText()+  "<html>" +rs.getString("date")+ "&nbsp&nbsp&nbsp;"+rs.getString("type")+"&nbsp&nbsp&nbsp;"+rs.getString("Amount")+"<br>");
                 System.out.println("\n");
             }
         }
         catch(Exception e)
        {
            System.out.println(e);
        }
         
         mini.setBounds(20,140,400,200);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.PINK);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
    
}
