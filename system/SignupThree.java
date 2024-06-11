
package bank.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3 Account Details.");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,250,20);
        add(r1);
        
         r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);
        
         r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);
        
         r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        
        JLabel card = new JLabel("Card No");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300, 200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-1245");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300, 300,30);
        add(number);
        
         JLabel det = new JLabel("Your 16 digit card number");
        det.setFont(new Font("Raleway",Font.BOLD,12));
        det.setBounds(100,330, 300,20);
        add(det);
        
        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370, 200,30);
        add(pin);
        
        
        JLabel pno = new JLabel("XXXX");
        pno.setFont(new Font("Raleway",Font.BOLD,22));
        pno.setBounds(330,370, 300,30);
        add(pno);
        
        JLabel pw = new JLabel("Your 4 digit pin");
        pw.setFont(new Font("Raleway",Font.BOLD,12));
        pw.setBounds(100,400, 300,20);
        add(pw);
        
        JLabel ser = new JLabel("Services Requied");
        ser.setFont(new Font("Raleway",Font.BOLD,22));
        ser.setBounds(100,450,200,30);
        add(ser);
        
       c1 = new JCheckBox("ATM CARD");
c1.setBackground(Color.WHITE);
c1.setFont(new Font("Raleway", Font.BOLD, 16));
c1.setBounds(100, 500, 200, 30);
add(c1);

c2 = new JCheckBox("Internet Banking");
c2.setBackground(Color.WHITE);
c2.setFont(new Font("Raleway", Font.BOLD, 16));
c2.setBounds(350, 500, 200, 30);
add(c2);

c3 = new JCheckBox("Mobile Banking");
c3.setBackground(Color.WHITE);
c3.setFont(new Font("Raleway", Font.BOLD, 16));
c3.setBounds(100, 550, 200, 30);
add(c3);

c4 = new JCheckBox("Email And SMS Alert");
c4.setBackground(Color.WHITE);
c4.setFont(new Font("Raleway", Font.BOLD, 16));
c4.setBounds(350, 550, 200, 30);
add(c4);

        
        c5= new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I here by declare that above details are correct");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);
                
             submit = new JButton("Submit");
             submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
         cancel = new JButton("Cancel");
             cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accType = null;
            if(r1.isSelected())
            {
                accType="Saving";
                
            }
            else if(r2.isSelected())
            {
                accType="Current Account";
            }
            else if(r3.isSelected())
            {
                accType="Fixed Deposit Account";
            }
            else if(r4.isSelected())
            {
                accType="Recuring Deposit Account";
            }
            
            Random rand = new Random();
            long cardno = Math.abs(rand.nextLong() % 90000000L) + 5040936000000000L;
            String cardNumberString = Long.toString(cardno);
            System.out.print(cardNumberString);
            
            String pinno = "" + Math.abs((rand.nextLong()%9000L)+1000L);
            
            String facility = "";
            if(c1.isSelected())
            {
                facility=facility +"ATM Card";
            }
            else if(c2.isSelected())
            {
                facility = facility + "Internet Banking";
            }
            else if(c3.isSelected())
            {
                facility = facility + "Mobile Banking";
            }
            else if(c4.isSelected())
            {
                facility = facility + "Email And SMS Alert";
            }
            else if(c5.isSelected())
            {
                facility = facility + "Checkbook";
            }
            else if(c6.isSelected())
            {
                facility = facility + "E-Statement";
            }
                
            
             try     
          {
              if(accType.equals(""))
              {
                  JOptionPane.showMessageDialog(null,"Account Type is Requied");
              }
              else{
                  Conn c = new Conn();
                   String query = "insert into signupthree values('" + formno + "','" + accType + "','" + cardNumberString + "','" + pinno + "','" + facility + "')";
                   String query1 ="insert into login values('"+formno+"','"+cardNumberString+ "','" +pinno+"')";
                   c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                   JOptionPane.showMessageDialog(null,"Card NO: "+cardNumberString+"\nPin : "+pinno);
                   
                   setVisible(false);
                   new Deposit(pinno).setVisible(false);
              }
           
         
       }catch(Exception e)
           {
               System.out.println(e);
           }
            

        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    public static void main(String[] args)
    {
        new SignupThree("");
    }
}
