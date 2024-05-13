package ATM_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;


public class SignUpOne extends JFrame  implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,pinTextField,stateTextField,cityTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried,otherMarital;
    JDateChooser dateChooser;

    SignUpOne(){
        setLayout(null);

        //Generte random number
        Random ran=new Random();// random class object
        random=Math.abs(ran.nextLong() %9000l)+1000l;//ran.nextLong() is use to print random long datatype random number


        //Text(JLable)
        JLabel formno=new JLabel("APPLICATION FORM NO."+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails=new JLabel("Page 1: Personal Detail");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        JLabel pin =new JLabel("PIN Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);



        //Input(Textfield)
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,17));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,17));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,17));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,17));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,17));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,17));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,17));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);



        //Calendar(Date of birth)
        dateChooser=new JDateChooser(); //we create JDateChooser object
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(128,112,105));
        add(dateChooser);




        //RadioButton( for gender)
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female=new JRadioButton("female");
        female.setBackground(Color.white);
        female.setBounds(450,290,120,30);
        add(female);

        other =new JRadioButton("Other");
        other.setBounds(600,290,60,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup gendergroup=new ButtonGroup(); //to make male and female button linked
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);



        //RadioButton (for Merital Status)

        married=new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.white);
        add(married);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBackground(Color.white);
        unmarried.setBounds(450,390,120,30);
        add(unmarried);

        otherMarital =new JRadioButton("Other");
        otherMarital.setBounds(600,390,60,30);
        otherMarital.setBackground(Color.white);
        add(otherMarital);

        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(otherMarital);

        //Buttom(next)
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(480,650,60,30);
        next.addActionListener( this);//adding Action listener
        add(next);


        //Frame
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
        String formno =""+random; //convert long into string
        String name=nameTextField.getText(); //getText is use to get value from JtextField
        String fname=fnameTextField.getText();
        String dob= ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        } else if (female.isSelected()) {
            gender="Female";

        } else if (other.isSelected()) {
            gender="Other";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        } else if (unmarried.isSelected()) {
            marital="Unmarried";
        } else if (otherMarital.isSelected()) {
            marital="Other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();

        //exception handling
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                Conn c=new Conn();
                String query ="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signuptwo(formno).setVisible(true);

            }

        }catch (Exception e){
            System.out.println(e);
        }


    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}
