
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Om Sai143
 */

public class SignupTwo extends JFrame implements  ActionListener{
   
    JTextField  Adhar,panno,
             ss,esa;
    JButton next;
    JComboBox religion,cat,inco,edu,occu;
    String formno;
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Application Form Page 2");
        
        JLabel additionDetails =  new JLabel("Page 2 Additonal Details");
        additionDetails.setFont(new Font("Raleway",Font.BOLD,28));
        additionDetails.setBounds(140, 40, 600, 30);
        add(additionDetails);
  
        
        
        
         JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100, 140, 100, 30);
        add(rel);
        String valrel[]= {"Hindu","Muslim","Christian","Singh","Other"};
         religion = new JComboBox(valrel);
         religion.setBounds(300, 140, 400, 30);
        add(religion);
        
        
        
         JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
         String valcat[]= {"Open","OBC","SC","NT","Other"};
          cat = new JComboBox(valcat);
        cat.setBounds(300,190,400,30);
        add(cat);
        
         JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);
         String valinc[]= {"Null","<1,50,000","<2,50,000","<500000","Upto 10lack"};
           inco = new JComboBox(valinc);
        inco.setBounds(300,250,400,30);
        add(inco);
        
        
        

        
         JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
       gender.setBounds(100, 290, 200, 30);
        add(gender);
         JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
       email.setBounds(100, 315, 200, 30);
        add(email);
         String valedu[]= {"Graduate","Non-Graduate","Post-Graduate","Other"};
           edu = new JComboBox(valedu);
          edu.setBackground(Color.WHITE);
        edu.setBounds(300,315,400,30);
        add(edu);
        
       
        
         JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
          occ.setBounds(100, 390, 200, 30);
          add(occ);
         String valocc[]= {"Salaried","Self","Business","Student","Other"};
           occu = new JComboBox(valocc);
        occu.setBounds(300,390,400,30);
        add(occu);
        
        
        JLabel pan = new JLabel("PAN No:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
         panno = new JTextField();
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(300,440,400,30);
        add(panno);
        
        JLabel adhar = new JLabel("Adhar No:");
        adhar.setFont(new Font("Raleway",Font.BOLD,20));
     adhar.setBounds(100, 490, 200, 30);
        add(adhar);
        Adhar = new JTextField();
        Adhar.setFont(new Font("Raleway",Font.BOLD,20));
    Adhar.setBounds(300,490,400,30);
        add(Adhar);
        
        JLabel state = new JLabel("Senior Citizon: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
       state.setBounds(100, 540, 200, 30);
        add(state);
         ss = new JTextField();
       ss.setFont(new Font("Raleway",Font.BOLD,20));
       ss.setBounds(300,540,400,30);
        add(ss);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
       pincode.setBounds(100, 590, 200, 30);
        add(pincode);
         esa = new JTextField();
       esa.setFont(new Font("Raleway",Font.BOLD,20));
        esa.setBounds(300,590,400,30);
        add(esa);
        
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
        
        String Religion = (String)religion.getSelectedItem();//used to take value from dropdowm//
       String Category = (String)cat.getSelectedItem();
       String Income  = (String)inco.getSelectedItem();
       String Edu = (String)edu.getSelectedItem();
       String Occu = (String)occu.getSelectedItem();
       String SS = ss.getText();
       String ESA =esa.getText();
       String PAN =panno.getText();
       String ADHAR=Adhar.getText();
        
       try
       {
           Conn c = new Conn();
           String query = "insert into signuptwo values('" + formno + "','" + Religion + "','" + Category + "','" + Income + "','" + Edu + "','" + Occu + "','" + SS + "','" + ESA + "','" + PAN + "','" + ADHAR + "')";
           c.s.executeUpdate(query);
           //setting for signupThree page
           setVisible(false);
           new SignupThree(formno).setVisible(true);
       }catch(Exception e)
           {
               System.out.println(e);
           }
        
            
            
            

        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new SignupTwo("");
    }

    

    
    
}
