package ATM_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {


        JButton o1,o2,o3,o4,o5,o6,exit;

        String pinnumber;
        FastCash(String pinnumber){
            this.pinnumber=pinnumber;
            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image =new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);

            JLabel text =new JLabel("Select Withdrawal Amount");
            text.setBounds(215,300,700,35);
            text.setForeground(Color.white);
            text.setFont(new Font("System",Font.BOLD,16));
            image.add(text);  // to show text over image;

            o1 = new JButton("Rs 100");
            o1.addActionListener(this);
            o1.setBounds(170,415,150,30);
            image.add(o1);

            o2 = new JButton("Rs 500");
            o2.addActionListener(this);
            o2.setBounds(355,415,150,30);
            image.add(o2);

            o3 = new JButton("Rs 1000");
            o3.addActionListener(this);
            o3.setBounds(170,450,150,30);
            image.add(o3);

            o4 = new JButton("Rs 2000");
            o4.addActionListener(this);
            o4.setBounds(355,450,150,30);
            image.add(o4);

            o5 = new JButton("Rs 5000");
            o5.addActionListener(this);
            o5.setBounds(170,485,150,30);
            image.add(o5);

            o6 = new JButton("Rs 10000");
            o6.addActionListener(this);
            o6.setBounds(355,485,150,30);
            image.add(o6);

            exit = new JButton("Exit");
            exit.addActionListener(this);
            exit.setBounds(355,520,150,30);
            image.add(exit);


            setSize(900,900);
            setLocation(300,0);
            // setUndecorated(true);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==exit){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                String amount = ((JButton)ae.getSource()).getText().substring(3);
                Conn c =  new Conn();
                try{
                    ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit"))
                        {
                            balance = balance + Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance=balance-Integer.parseInt(rs.getString("amount"));
                         }
                    }
                    if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Your balance is insufficient");
                        return;
                    }
                    Date date = new Date();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" debited successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                }
                catch (Exception e){

                }
            }


        }

        public static void main(String[] args) {

            new FastCash("");
        }
    }


