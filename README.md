
# BankSimulation
In this project i create  a bank simulation using java swing , awt ,mysql.

## 1. Login and SignUp Page
![Screenshot_20240727_002236](https://github.com/user-attachments/assets/48156003-4d59-41af-9b24-938eac0c2179)

 #### MySql Query for creating login
 
 create table login (formno varchar(20),cardnumber varchar(25),pinnumber varchar(10));

## 2.SignUp Page

  ###  2.1 Page 1

  ![image](https://github.com/user-attachments/assets/8e0a1814-cc9c-460b-b44a-cef4bfc6d271)

  #### MySql Query for creating page1
  
  create table signup(formno varchar(20), name varchar(20),father_name varchar(20),dob varchar(20),gender varchar(20),email varchar(30),marital_status 
  varchar(20),address varchar(40),city varchar(20),state varchar(20),pin varchar(20));
  use bankmanagementsystem;

  ### 2.2 Page 2

  ![image](https://github.com/user-attachments/assets/85f77d59-3484-4dc3-bff6-6daf184d82af)

  #### MySql Query for creating page2
  
   create table signup2(formno varchar(20),catogory varchar(20),income varchar(20),education varchar(30),Occupation varchar(30),pan varchar(20),aadhar 
  varchar(30),seniorCitizen varchar(20),existingaccount varchar(20));


  ### 2.2 Page 3

   ![image](https://github.com/user-attachments/assets/e5696d5c-4d6e-4ac9-b6f7-b26ee7f8bdbf)


  #### MySql Query for creating page3
  
  create table signup3(formno varchar(20),accountType varchar(40),cardnumber varchar(25),pinnumber varchar(10),facility varchar(100));

   ## 3. Transaction

   ![image](https://github.com/user-attachments/assets/48ec83be-d7c8-4873-95aa-083bb77f68ea)

  #### MySql Query for Transection page

  create table bank(pinnumber varchar(10), date varchar(50),type varchar(20),amount varchar(20));

  ### Other Screenshots

  #### Deposit

   ![image](https://github.com/user-attachments/assets/23777b4e-e23e-426e-b765-0e39d50d9ed6)

 #### Withdrawl

 ![image](https://github.com/user-attachments/assets/4bd198d9-e419-479e-ad16-63d13ceaf758)

 #### Fast cash

 ![image](https://github.com/user-attachments/assets/55aa8369-5935-452a-9e47-00411bc733b1)

 #### Mini Statement

 ![image](https://github.com/user-attachments/assets/ae8eb341-114f-4a38-a2ea-9bac296126a6)

 #### Change PIN

 ![image](https://github.com/user-attachments/assets/f7695646-e508-4feb-bc2d-fe0c8a4ce522)

 #### Balance Enquiry

 ![image](https://github.com/user-attachments/assets/da1ccb01-bd33-42bf-9bac-9742f040dc90)

 ## Other Detail 
 ##### Icons and Jar file for date and MySql is also present.





  

  
  
   

   

  
  


