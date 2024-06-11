
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener {
JButton deposit,withd,fastcash,mins,pc,bi,exit;
String pinnumber;
    Transactions(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select the transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
         deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withd = new JButton("Cash Withdraw");
        withd.setBounds(355,415,150,30);
         withd.addActionListener(this);
        image.add(withd);
        
         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
         fastcash.addActionListener(this);
        image.add(fastcash);
        
         mins= new JButton("Mini Statement");
        mins.setBounds(355,450,150,30);
         mins.addActionListener(this);
        image.add(mins);
        
         pc= new JButton("Pin Change");
        pc.setBounds(170,485,150,30);
         pc.addActionListener(this);
        image.add(pc);
        
          bi= new JButton("Balance Inquiry");
        bi.setBounds(355,485,150,30);
         bi.addActionListener(this);
        image.add(bi);
        
          exit= new JButton("Exit");
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
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withd)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pc)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==bi)
        {
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==mins)
        {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Transactions("");
    }
    
}
