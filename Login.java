package ATM_System;

import javax.swing.*;//JFrame is in this class which is use for creation of frame
import java.awt.*; // Image and color class is inside this packege
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    // JFrame is use to create frame
    // ActionListener is use to provide action in bottom,frame element
    // ActionListener cannot work if we cannot create  method actionPerformed

    JButton login,clear,signup; // declear it out side of to use outside of constructor
    JTextField cardTextField; //use to create a input box for text
    JPasswordField pinTextField;// use to create a input box for password
    Login(){

        setLayout(null);// java swing set a default layout

        //title
        setTitle("AUTOMATED TALLER MACHINE"); //use to give title of frame

        //Icons
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/Logo.jpg"));  //we create a object of ImageIcon class and name it i1 and by help of classLoader.getSystemResource we load image.
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//we to size the image width,height
        ImageIcon i3=new ImageIcon(i2);//Jlable cannot take image as argument so we convert image into imageIcon
        JLabel label=new JLabel(i3);//we can not direct use image in our frame so by help of jlable class we create a object and pass image name as argument;
        add(label); //we use add() to add icons on frame
        label.setBounds(70,10,100,100);//set location of image before use it we need to set layout =null;
        //background
        getContentPane().setBackground(Color.white);//use to set background
        //text
        JLabel text =new JLabel("Welcome to ATM");//Jlable is mainly use to write some thing on frame
        text.setFont(new Font("Osward",Font.BOLD,38)); //Use to set font of text
        add(text);//to add text on frame
        text.setBounds(200,40,400,40);//first we have to setBounds of text to see text on frame;

        JLabel cardno =new JLabel("Card No:");//Jlable is mainly use to write some thing on frame
        cardno.setFont(new Font("Osward",Font.BOLD,30)); //Use to set font of text
        add(cardno);//to add text on frame
        cardno.setBounds(120,150,150,30);//first we have to setBounds of text to see text on frame;

        JLabel pin =new JLabel("PIN:");//Jlable is mainly use to write some thing on frame
        pin.setFont(new Font("Osward",Font.BOLD,30)); //Use to set font of text
        add(pin);//to add text on frame
        pin.setBounds(120,220,150,30);//first we have to setBounds of text to see text on frame;

        //Input(textfield)
        //card
        cardTextField=new JTextField(); //use to take input from user
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        //pin
        pinTextField=new JPasswordField(); //use to take input from user
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        //Button
        //login
        login =new JButton("SIGN IN"); //use to create a botton
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        //clear
        clear =new JButton("CLEAR"); //use to create a botton
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);//set color of text inside bottom
        clear.addActionListener(this);
        add(clear);
        //sign up
        signup =new JButton("SIGN UP"); //use to create a botton
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);//set color of text inside bottom
        signup.addActionListener(this);
        add(signup);



        //frame
        setSize(800,480);//use to set size of frame
        setVisible(true);//use to visible frame , by default is value is false
        setLocation(350,200); //use to fixed pop up location
    }
    public void actionPerformed(ActionEvent ae){// we have to create this method

        if(ae.getSource()==clear){
            cardTextField.setText("");// set.Text is use to set text when click on clear button
            pinTextField.setText("");

        } else if (ae.getSource()==login) {
            Conn conn =new Conn();
            String cardnumgber =cardTextField.getText();
            String pinnumber =pinTextField.getText();
            String query = " select * from login where cardnumber='"+cardnumgber+"' and pinnumber='"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }

            }
            catch (Exception e){
                System.out.println(e);
            }


        } else if (ae.getSource() == signup) {
            setVisible(false);//close current frame;
            new SignUpOne().setVisible(true);//open SignUpOne frame

        }
    }
    public static void main(String[] args) {
        new Login();

    }
}
