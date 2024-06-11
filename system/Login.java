
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//for actionlistener
import java.sql.*;

/**
 *
 * @author Om Sai143
 */
public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;//define button globally
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        setTitle("ATM");//title of front end
        setLayout(null);//shift the icon at left side 
        ImageIcon i =new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//add logo of icon
        Image i2 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//set our image in proper format
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l =new JLabel(i3);
        l.setBounds(70, 10, 100, 100);
        add(l);
        
        JLabel text = new JLabel("WELCOME TO BANK ATM"); 
        text.setFont(new Font("Osward",Font.BOLD,38)); 
        text.setBounds(200,40,500,40);
        add(text);
        
        JLabel cardno = new JLabel("CARD NO : "); 
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,5400,40);
        add(cardno);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,30);
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN NO : "); 
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,400,40);
        add(pin);
        
          pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        add(pinTextField);
        
        
         login = new JButton ("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton ("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.WHITE);
        clear.addActionListener(this);//add actionlistener after click on button
        add(clear);
        
         signup = new JButton ("Sign Up");
        signup.setBounds(300,350,100,30);
        signup.setBackground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.PINK);
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);//frame will open  from  350 left 200 right
        
        
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == clear) {
        cardTextField.setText("");
        pinTextField.setText("");
    } else if (e.getSource() == login) {
        Conn conne = new Conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String query ="select *  from login where Card_No = '"+cardnumber+"'and Pin='"+pinnumber+"'";
       try {
             //this is ddl command
             Statement stmt = conne.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             if(rs.next())
             {
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
             }
                 
    // Process the ResultSet
}       catch (SQLException ae) {
          ae.printStackTrace(); // Or handle the exception in an appropriate way
}

        // Your logic for login button action goes here
    } else if (e.getSource() == signup) {
        setVisible(false);
        new SignupOne().setVisible(true);
    }
}



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Login();
    }
}
    
        
    

   