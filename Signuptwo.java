package ATM_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Signuptwo extends JFrame implements ActionListener {

        JTextField panTextField,aadharTextField;
        JButton next;
        JRadioButton yes1,no1,yes2,no2;


        ButtonGroup Senior,exisiting;
        JComboBox religion,cato,incom,Edu,occ;

        String formno;
        Signuptwo(String formno){
            this.formno=formno;
            setLayout(null);

            setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

            //Text(JLable)


            JLabel additinalDetails=new JLabel("Page 2: Additional Detail");
            additinalDetails.setFont(new Font("Raleway",Font.BOLD,22));
            additinalDetails.setBounds(290,80,400,30);
            add(additinalDetails);

            JLabel rel=new JLabel("Religion:");
            rel.setFont(new Font("Raleway",Font.BOLD,20));
            rel.setBounds(100,140,100,30);
            add(rel);

            JLabel cat=new JLabel("Category:");
            cat.setFont(new Font("Raleway",Font.BOLD,20));
            cat.setBounds(100,190,200,30);
            add(cat);

            JLabel income=new JLabel("Income:");
            income.setFont(new Font("Raleway",Font.BOLD,20));
            income.setBounds(100,240,200,30);
            add(income);

            JLabel edu=new JLabel("Educational");
            edu.setFont(new Font("Raleway",Font.BOLD,20));
            edu.setBounds(100,290,200,30);
            add(edu);

            JLabel qualification=new JLabel("Qualification:");
            qualification.setFont(new Font("Raleway",Font.BOLD,20));
            qualification.setBounds(100,315,200,30);
            add(qualification);

            JLabel occupation=new JLabel("Occupation:");
            occupation.setFont(new Font("Raleway",Font.BOLD,20));
            occupation.setBounds(100,365,200,30);
            add(occupation);

            JLabel pan=new JLabel("PAN No:");
            pan.setFont(new Font("Raleway",Font.BOLD,20));
            pan.setBounds(100,415,200,30);
            add(pan);

            JLabel aadhar=new JLabel("Aadhar Number:");
            aadhar.setFont(new Font("Raleway",Font.BOLD,20));
            aadhar.setBounds(100,465,200,30);
            add(aadhar);

            JLabel senior=new JLabel("Senior Citizen:");
            senior.setFont(new Font("Raleway",Font.BOLD,20));
            senior.setBounds(100,515,200,30);
            add(senior);

            JLabel exist =new JLabel("Exisiting Account:");
            exist.setFont(new Font("Raleway",Font.BOLD,20));
            exist.setBounds(100,565,200,30);
            add(exist);



            //ComboBox or Choice both are use to create this


            String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
             religion=new JComboBox<String>(valReligion); // use to show comboBox
            //religion.setFont(new Font("Raleway",Font.BOLD,17));
            religion.setBackground(Color.WHITE);
            religion.setBounds(300,140,400,30);
            add(religion);

            String valCat[]={"GENERAL","OBC","ST","SC"};
             cato=new JComboBox<String>(valCat); // use to show comboBox
            //religion.setFont(new Font("Raleway",Font.BOLD,17));
            cato.setBackground(Color.WHITE);
            cato.setBounds(300,190,400,30);
            add(cato);

            String valIncome[]={"NULL","<2,00,000","<5,00,000",">5,00,000"};
             incom=new JComboBox<String>(valIncome);
            incom.setBackground(Color.WHITE);;
            incom.setBounds(300,240,400,30);
            add(incom);

            String valEdu[]={"Non Graduate","Graduate"};
             Edu=new JComboBox<String>(valEdu);
            Edu.setBackground(Color.WHITE);;
            Edu.setBounds(300,315,400,30);
            add(Edu);

            String valOcc[]={"Student","Businessman","Government Employee","Private Employee"};
             occ=new JComboBox<String>(valOcc);
            occ.setBackground(Color.WHITE);;
            occ.setBounds(300,365,400,30);
            add(occ);



            //Input(Textfield)

            panTextField=new JTextField();
            panTextField.setFont(new Font("Raleway",Font.BOLD,17));
            panTextField.setBounds(300,415,400,30);
            add(panTextField);

            aadharTextField=new JTextField();
            aadharTextField.setFont(new Font("Raleway",Font.BOLD,17));
            aadharTextField.setBounds(300,465,400,30);
            add(aadharTextField);

            //radio Buttom

            yes1 =new JRadioButton("Yes");
            yes1.setBounds(300,515,150,30);
            yes1.setBackground(Color.WHITE);
            add(yes1);

            no1 =new JRadioButton("No");
            no1.setBounds(500,515,150,30);
            no1.setBackground(Color.WHITE);
            add(no1);

            yes2 =new JRadioButton("Yes");
            yes2.setBounds(300,565,150,30);
            yes2.setBackground(Color.WHITE);
            add(yes2);

            no2 =new JRadioButton("No");
            no2.setBounds(500,565,150,30);
            no2.setBackground(Color.WHITE);
            add(no2);

             Senior =new ButtonGroup();
            Senior.add(yes1);
            Senior.add(no1);

            exisiting =new ButtonGroup();
            exisiting.add(yes2);
            exisiting.add(no2);


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
            String formno1 = formno;
            String sreligion=(String) religion.getSelectedItem(); //getText is use to get item from choice from JtextField
            String scato=(String) cato.getSelectedItem();
            String income=(String)incom.getSelectedItem();
            String edu=(String) Edu.getSelectedItem();
            String socc=(String)occ.getSelectedItem();

            String pan=panTextField.getText();
            String aadhar=aadharTextField.getText();

            String senior=null;
            if(yes1.isSelected()){
                senior="Yes";
            } else if (no1.isSelected()) {
                senior="No";
            }
            String existingAccount=null;
            if(yes2.isSelected()){
                existingAccount="Yes";
            } else if (no2.isSelected()) {
                existingAccount="No";
            }

            String Pan =panTextField.getText();
            String Aadhar=aadharTextField.getText();

            //exception hendling
            try{
                if(pan.equals("")){
                    JOptionPane.showMessageDialog(null,"Pan no. is Required");
                }else{
                    Conn c=new Conn();
                    String query ="insert into signup2 values('"+formno1+"','"+sreligion+"','"+scato+"','"+income+"','"+edu+"','"+pan+"','"+aadhar+"','"+senior+"','"+existingAccount+"')";
                    c.s.executeUpdate(query);
                }
                setVisible(false);
                new Signupthree(formno).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }


        }
        public static void main(String[] args) {
            new ATM_System.Signuptwo("");
        }
    }

