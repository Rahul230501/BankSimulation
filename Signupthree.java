package ATM_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signupthree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;

    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancle;
    String formno;
    Signupthree(String formno){
        this.formno=formno;

        setLayout(null);
        JLabel li =new JLabel("Page 3 : Account Detail");
        li.setFont(new Font("Raleway",Font.BOLD,22));
        li.setBounds(280,40,400,40);
        add(li);

        JLabel type =new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 =new JRadioButton("Saving Account");
        r1.setBounds(100,180,150,20);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        add(r1);

        r2 =new JRadioButton("Fixed Deposit Account");
        r2.setBounds(400,180,250,20);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        add(r2);

        r3 =new JRadioButton("Current Account");
        r3.setBounds(100,220,150,20);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        add(r3);

        r4 =new JRadioButton("Recurring Deposit Account");
        r4.setBounds(400,220,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup accounttype = new ButtonGroup();
        accounttype.add(r1);
        accounttype.add(r2);
        accounttype.add(r3);
        accounttype.add(r4);

        JLabel card =new JLabel("Card Number :");
        card.setBounds(100,270,200,20);
        card.setFont(new Font("Relaway",Font.BOLD,22));
        add(card);

        JLabel cardnumber =new JLabel("XXXX-XXXX-XXXX-4541");
        cardnumber.setBounds(330,270,300,20);
        cardnumber.setFont(new Font("Relaway",Font.BOLD,22));
        add(cardnumber);
        JLabel carddetail =new JLabel(" Your 16 digit card number");
        carddetail.setBounds(100,290,200,20);
        carddetail.setFont(new Font("Relaway",Font.BOLD,12));
        add(carddetail);
        JLabel pin =new JLabel("PIN :");
        pin.setBounds(100,340,200,20);
        pin.setFont(new Font("Relaway",Font.BOLD,22));
        add(pin);

        JLabel pinnumber =new JLabel(" XXXX ");
        pinnumber.setBounds(330,340,200,20);
        pinnumber.setFont(new Font("Relaway",Font.BOLD,22));
        add(pinnumber);

        JLabel pindetail =new JLabel(" Your 4 digit PIN number");
        pindetail.setBounds(100,360,200,20);
        pindetail.setFont(new Font("Relaway",Font.BOLD,12));
        add(pindetail);

        JLabel service =new JLabel("Services Required :");
        service.setBounds(100,410,300,20);
        service.setFont(new Font("Relaway",Font.BOLD,22));
        add(service);

        c1 =new JCheckBox("ATM Card");
        c1.setBounds(100,450,200,20);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Relaway",Font.BOLD,16));
        add(c1);
        c2 =new JCheckBox("Internet Banking");
        c2.setBounds(350,450,200,20);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Relaway",Font.BOLD,16));
        add(c2);
        c3 =new JCheckBox("Mobile Banking");
        c3.setBounds(100,500,200,20);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Relaway",Font.BOLD,16));
        add(c3);
        c4 =new JCheckBox("Cheque Book");
        c4.setBounds(350,500,200,20);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Relaway",Font.BOLD,16));
        add(c4);
        c5 =new JCheckBox("Email & SMS Alert");
        c5.setBounds(100,550,200,20);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Relaway",Font.BOLD,16));
        add(c5);
        c6 =new JCheckBox("E-Statement");
        c6.setBounds(350,550,200,20);
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Relaway",Font.BOLD,16));
        add(c6);
        c7 =new JCheckBox("I have declared that the above entered details are correct to the best of my knowledge");
        c7.setBounds(100,630,600,20);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Relaway",Font.BOLD,12));
        add(c7);


        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Relaway",Font.BOLD,14));
        submit.setBounds(250,680, 100, 30);
        submit.addActionListener(this);
        add(submit);


        cancle=new JButton("Cancle");
        cancle.setBackground(Color.black);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Relaway",Font.BOLD,14));
        cancle.setBounds(420,680, 100, 30);
        cancle.addActionListener(this);
        add(cancle);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String AccountType="";
            if(r1.isSelected()){
                AccountType="Saving Account";
            }
            else if(r2.isSelected()){
                AccountType="Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                AccountType="Current Account";
            }
            else if(r4.isSelected()){
                AccountType="Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = ""+Math.abs((random.nextLong()%90000000L)+5416162000000000L);

            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);

            String facility=" ";
            if(c1.isSelected()){
                facility=facility+" ATM Card";
            }
            if(c2.isSelected()){
                facility=facility+" Internet Banking";
            }
            if(c3.isSelected()){
                facility=facility+" Mobile Banking";
            }
            if(c4.isSelected()){
                facility=facility+" Email & SMS Alert";
            }
            if(c5.isSelected()){
                facility=facility+" Cheque Book";
            }
            if(c6.isSelected()){
                facility=facility+" E-Statement";
            }
            try{
                if(AccountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is Required");
                }
                if (!c7.isSelected()){
                    JOptionPane.showMessageDialog(null,"Required to select Declaration");
                }
                    else{
                    Conn conn =new Conn();
                    String query1= "insert into signup3 values('"+formno+"','"+AccountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2= "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number :"+cardnumber+"\n Pin Numner :"+pinnumber);
                }
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }

            
        } else if (ae.getSource()==cancle) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signupthree("");
    }
}
