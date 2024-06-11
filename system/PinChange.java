
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JButton change,back;
    String pinnumber;
    JTextField rpin,pin;
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change Your Pin");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
         JLabel ntext = new JLabel("New Pin");
        ntext.setBounds(165,320,180,25);
        ntext.setForeground(Color.WHITE);
        ntext.setFont(new Font("System",Font.BOLD,16));
        image.add(ntext);
        
        pin = new JTextField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel retext = new JLabel("Re-Enter New Pin");
        retext.setBounds(165,360,180,25);
        retext.setForeground(Color.WHITE);
        retext.setFont(new Font("System",Font.BOLD,16));
        image.add(retext);
        
         rpin = new JTextField();
        rpin.setFont(new Font("Raleway",Font.BOLD,25));
        rpin.setBounds(330,360,180,25);
        image.add(rpin);
        
        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==change)
        {
        try
        {
          String npin = pin.getText();
          String repin = rpin.getText();
          
          if(!npin.equals(repin))
          {
              JOptionPane.showMessageDialog(null,"Entered pin not matching");
          }
          
          if(npin.equals(""))
          {
               JOptionPane.showMessageDialog(null,"Please enter pin");
          }
          
          if(repin.equals(""))
          {
               JOptionPane.showMessageDialog(null,"Please Re-Enter Pin");
          }
           Conn con = new Conn();
           String query1 = "update deposit set Pin = '"+npin+"'where Pin ='"+pinnumber+"'";
           String query2 = "update signupthree set Pin_NO = '"+npin+"'where Pin_NO ='"+pinnumber+"'";
           String query3 = "update login set Pin = '"+npin+"'where Pin ='"+pinnumber+"'";
           
           con.s.executeUpdate(query1);
           con.s.executeUpdate(query2);
           con.s.executeUpdate(query3);
           
           JOptionPane.showMessageDialog(null,"Pin changed successfully");
           setVisible(false);
           new Transactions(repin).setVisible(true);
          
          
              
          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     }
        else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
        
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
