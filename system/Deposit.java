package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{

    JButton depb, back;
    JTextField amnt;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel txt = new JLabel("Enter Amount you want to deposit");
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("System", Font.BOLD, 16));
        txt.setBounds(170, 300, 400, 20);
        image.add(txt);
        
        amnt = new JTextField();
        amnt.setFont(new Font("Raleway", Font.BOLD, 22));
        amnt.setBounds(170, 350, 320, 25);
        image.add(amnt);
        
        depb = new JButton("Deposit");
        depb.setBounds(355, 485, 150, 30);
        depb.addActionListener(this);
        image.add(depb);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depb) {
            String number = amnt.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter an amount");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into deposit values('" + pinnumber + "','" + date + "','Deposit','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
