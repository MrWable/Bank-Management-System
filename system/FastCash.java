
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
JButton deposit,withd,fastcash,mins,pc,bi,exit;
String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select withdrawl amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
         deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withd = new JButton("Rs 500");
        withd.setBounds(355,415,150,30);
         withd.addActionListener(this);
        image.add(withd);
        
         fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
         fastcash.addActionListener(this);
        image.add(fastcash);
        
         mins= new JButton("Rs 2000");
        mins.setBounds(355,450,150,30);
         mins.addActionListener(this);
        image.add(mins);
        
         pc= new JButton("Rs 5000");
        pc.setBounds(170,485,150,30);
         pc.addActionListener(this);
        image.add(pc);
        
          bi= new JButton("Rs 10000");
        bi.setBounds(355,485,150,30);
         bi.addActionListener(this);
        image.add(bi);
        
          exit= new JButton("Back");
        exit.setBounds(355,520,150,30);
         exit.addActionListener(this);
        image.add(exit);
        
                
                
        
        
        
         setSize(900,900);
        setLocation(300,0);
         //setUndecorated(true);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else 
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from deposit where Pin = '"+pinnumber+"'");
                int balance=0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                        
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into deposit values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+amount+" Debited Successfully.");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
        }
        
            
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new FastCash("");
    }
    
}
