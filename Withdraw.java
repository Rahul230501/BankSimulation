package ATM_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField amount;

    String pinnumber;

    Withdraw(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);  // withot setlayout(null) setbound is not work

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleways", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number == "") {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                Conn conn = new Conn();



                    try {
                        ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber ='" + pinnumber + "'");
                        int balance = 0;
                        while (rs.next()) {
                            if (rs.getString("type").equals("Deposit")) {
                                balance = balance + Integer.parseInt(rs.getString("amount"));
                            } else {
                                balance = balance - Integer.parseInt(rs.getString("amount"));
                            }
                        }
                        if (ae.getSource() != back && balance < Integer.parseInt(number)) {
                            JOptionPane.showMessageDialog(null, "Your balance is insufficient");
                            return;
                        }

                        String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdraw','" + number + "')";
                        conn.s.executeUpdate(query);
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw successfully");
                }

            }else if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }

        }
    }

