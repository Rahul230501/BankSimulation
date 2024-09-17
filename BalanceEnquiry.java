package ATM_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        setLayout(null);
        this.pinnumber= pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn c =  new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                } else {
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        JLabel bal = new JLabel("Your Current Account balance is Rs "+ balance);
        bal.setForeground(Color.white);
        bal.setBounds(170,300,400,30);
        image.add(bal);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
