package bank.management.Atmsimulatorsystem;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import com.toedter.calendar.JDateChooser;       //import jar file//

public class signupone extends JFrame implements ActionListener{

    long random;
    JTextField nametextfield,emailtextfield,fathertextfield,addresstextfield,citytextfield,statetextfield,pintextfield;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser datechooser;


    
    signupone(){

         
          setSize(850,800);
          setVisible(true);
          setLocation(350,10);
          getContentPane().setBackground(Color.GRAY);
          setLayout(null);

          Random ran= new Random();                             // generating random application number//
           random = Math.abs(ran.nextLong()%9000L)+ 1000L;

          JLabel formno  = new JLabel("APPLICATION FORM NO:"+ random);
          formno.setFont(new Font("Raleway",Font.BOLD,38));
          formno.setBounds(140,20,600,40);
          add(formno);

          JLabel personaldetails = new JLabel("PAGE 1 : PERSONAL DETAILS");
          personaldetails.setFont(new Font("Raleway",Font.BOLD,24));
          personaldetails.setBounds(270,80,400,30);
          add(personaldetails);

          JLabel name = new JLabel("NAME :");
          name.setFont(new Font("Raleway",Font.BOLD,20));
          name.setBounds(100,140,200,30);
          add(name);

           nametextfield = new JTextField();
          nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
          nametextfield.setBounds(300,140,300,30);
          add(nametextfield);

          JLabel Fathername = new JLabel("FATHER'S NAME :");
          Fathername.setFont(new Font("Raleway",Font.BOLD,20));
          Fathername.setBounds(100,190,200,30);
          add(Fathername);

           fathertextfield = new JTextField();
          fathertextfield.setFont(new Font("Raleway",Font.BOLD,14));
          fathertextfield.setBounds(300,190,300,30);
          add(fathertextfield);

          JLabel dob = new JLabel("DATE OF BIRTH:");
          dob .setFont(new Font("Raleway",Font.BOLD,20));
          dob .setBounds(100,240,200,30);
          add( dob);

           datechooser= new JDateChooser();
          datechooser.setBounds(300,240,300,30);
          datechooser.setForeground(Color.BLACK);
          add(datechooser);
          

          JLabel gender= new JLabel("GENDER:");
          gender .setFont(new Font("Raleway",Font.BOLD,20));
          gender .setBounds(100,290,200,30);
          add( gender);

           male=new JRadioButton("MALE");
          male.setBounds(300,290,60,30);
          male.setBackground(Color.GRAY);
          add(male);

         female= new JRadioButton("FEMALE");
          female.setBounds(450,290,120,30);
          female.setBackground(Color.GRAY);
          add(female);

          ButtonGroup gendergroup=new ButtonGroup();
          gendergroup.add(male);
          gendergroup.add(female);

          JLabel email = new JLabel("EMAIL:");
          email.setFont(new Font("Raleway",Font.BOLD,20));
          email .setBounds(100,340,200,30);
          add( email);

          emailtextfield = new JTextField();
          emailtextfield.setFont(new Font("Raleway",Font.BOLD,14));
          emailtextfield.setBounds(300,340,300,30);
          add(emailtextfield);

          JLabel marital = new JLabel("MARITAL STATUS:");
          marital .setFont(new Font("Raleway",Font.BOLD,20));
          marital .setBounds(100,390,200,30);
          add( marital);

           married=new JRadioButton("MARRIED");
          married.setBounds(300,390,100,30);
          married.setBackground(Color.GRAY);
          add(married);
           unmarried= new JRadioButton("UNMARRIED");
          unmarried.setBounds(410,390,100,30);
          unmarried.setBackground(Color.GRAY);
          add(unmarried);
         other= new JRadioButton("OTHER");
          other.setBounds(550,390,100,30);
          other.setBackground(Color.GRAY);
          add(other);

          ButtonGroup maritalgroup=new ButtonGroup();
          maritalgroup.add(married);
          maritalgroup.add(unmarried);
          maritalgroup.add(other);

          JLabel address = new JLabel("ADDRESS:");
          address  .setFont(new Font("Raleway",Font.BOLD,20));
          address  .setBounds(100,440,200,30);
          add( address );

           addresstextfield = new JTextField();
          addresstextfield .setFont(new Font("Raleway",Font.BOLD,14));
          addresstextfield .setBounds(300,440,300,30);
          add(addresstextfield );

          JLabel city = new JLabel("CITY:");
          city  .setFont(new Font("Raleway",Font.BOLD,20));
          city  .setBounds(100,490,200,30);
          add( city);
          citytextfield = new JTextField();
          citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
          citytextfield .setBounds(300,490,300,30);
          add(citytextfield);


          JLabel state = new JLabel("STATE:");
          state  .setFont(new Font("Raleway",Font.BOLD,20));
          state .setBounds(100,540,200,30);
          add( state );
          statetextfield = new JTextField();
          statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
          statetextfield .setBounds(300,540,300,30);
          add(statetextfield);

          JLabel pincode= new JLabel("PINCODE:");
          pincode .setFont(new Font("Raleway",Font.BOLD,20));
          pincode.setBounds(100,590,200,30);
          add( pincode );
           pintextfield = new JTextField();
          pintextfield .setFont(new Font("Raleway",Font.BOLD,14));
          pintextfield  .setBounds(300,590,300,30);
          add(pintextfield );

           next= new JButton("NEXT");
          next.setBounds(520,660,80,20);                            
          next.setBackground(Color.BLACK);
          next.setForeground(Color.WHITE);
          add(next);
          next.addActionListener(this);



    }
    

    public static void main(String args[]){
    new signupone();    


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       String formno= ""+random;
       String name=nametextfield.getText();
       String fname=fathertextfield.getText();
      String dob=( (JTextField)datechooser.getDateEditor().getUiComponent()).getText();


       String email=emailtextfield.getText();
       String address=addresstextfield.getText();
       String city=citytextfield.getText();
       String state=statetextfield.getText();
       String pin=pintextfield.getText();
       String gender=null;
       if(male.isSelected()){
        gender="Male";
       }
       else if(female.isSelected()){
        gender="Female";
       }

       String marital=null;
       if(married.isSelected()){
        marital="Married";
       }
       else if(unmarried.isSelected()){
        marital="Unmarried";
       }
       else if(other.isSelected()){
        marital="Other";
       }

       try{
        conn c= new conn();
        String query="INSERT INTO signup(formno, name, fname, dob, gender, email, marital, address, city, state, pin) VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";


        c.s.executeUpdate(query);

        setVisible(false);
        new signuptwo(formno).setVisible(true);

       }
       catch(Exception e){
        System.out.println(e);

       }


    }


    

}