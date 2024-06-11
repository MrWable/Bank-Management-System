
package bank.management.system;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

/**
 *
 * @author Om Sai143
 */

public class SignupOne extends JFrame implements  ActionListener{
    long random;
    JTextField  nameTextField,fnameTextField,emailTextField,addTextField,cityTextField,
            date ,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    
    SignupOne()
    {
        setBackground(Color.PINK);
        setLayout(null);
        Random ran = new Random();
        System.out.println(Math.abs((ran.nextLong() % 9000L)+1000L));
         random = Math.abs((ran.nextLong()% 9000L)+1000L);
        
        JLabel l = new JLabel("APPLICATION FORM NUMBER IS "+ random);
        l.setFont(new Font("Raleway",Font.BOLD,28));
        l.setBounds(140, 40, 600, 30);
        add(l);
        
        JLabel perdet = new JLabel("Page 1 :Personal Details");
        perdet.setFont(new Font("Raleway",Font.BOLD,22));
        perdet.setBounds(290, 80, 400, 30);
        add(perdet);
        
         JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
         JLabel fname = new JLabel("Father Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
         fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
         JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        
        JDateChooser date = new JDateChooser();
        date.setBounds(300, 240, 400, 30);
        add(date);
        
        
         JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
       gender.setBounds(100, 290, 200, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        add(female);
        /*to select only one male or female*/
        ButtonGroup gengroup = new ButtonGroup();
        gengroup.add(male);
        gengroup.add(female);
        
         JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
       email.setBounds(100, 340, 200, 30);
        add(email);
       emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
         JLabel mst = new JLabel("Marital Status:");
        mst.setFont(new Font("Raleway",Font.BOLD,20));
       mst.setBounds(100, 390, 200, 30);
        add(mst);
         married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        add(married);
         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        add(unmarried);
         other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        add(other);
        /*to select only one male or female*/
        ButtonGroup margroup = new ButtonGroup();
        margroup.add(married);
        margroup.add(unmarried);
        margroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
       address.setBounds(100, 440, 200, 30);
        add(address);
         addTextField = new JTextField();
        addTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addTextField.setBounds(300,440,400,30);
        add(addTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
     city.setBounds(100, 490, 200, 30);
        add(city);
         cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
    cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
       state.setBounds(100, 540, 200, 30);
        add(state);
         stateTextField = new JTextField();
       stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
       pincode.setBounds(100, 590, 200, 30);
        add(pincode);
         pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
                
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae)
    {
        String formno= ""+random;//to convert int to string
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String gender =null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else
        {
            gender="Female";
        }
        String email=emailTextField.getText();
        String martial=null;
        if(married.isSelected())
        {
            martial="Married";
        }
        else if(unmarried.isSelected())
        {
            martial="Unmarried";
            
        }
        else
        {
            martial="other";
        }
        String address=addTextField.getText();
         String city=cityTextField.getText();
          String state=stateTextField.getText();
           String pin=pinTextField.getText();
           try{
               
               //doing validation
               if(name.equals(""))
               {
                   //to create pop up and validate
                   JOptionPane.showMessageDialog(null, "Enter the name plz");
               }
               else
               {
                   Conn c = new Conn();
                   String query = "INSERT INTO signup VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + gender + "', '" + email + "', '" + martial + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
                   c.s.executeUpdate(query);
                   
                   setVisible(false);
                   new SignupTwo(formno).setVisible(true);
                }
                   
              
           }catch(Exception e)
           {
               System.out.println(e);
           }
        
            
            
            

        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new SignupOne();
    }

    

    
    
}
