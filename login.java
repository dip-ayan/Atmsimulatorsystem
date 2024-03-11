package bank.management.Atmsimulatorsystem;

import javax.swing.*;                                   // jframe is a part of the swing package//
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 public class login extends JFrame implements ActionListener {           //interface//

    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    login(){                   //constructor is made as the frame will appear as soon as object is made//

        setSize(800,480);             //dimensions of the frame
        setVisible(true);
        setLocation(350,200);                   //location of the frame from the origin//
        setTitle("Automated Teller Machine");
        setLayout(null);
        


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));      //imageicon class is used to use image in frame 
        Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);        //scaling the image                      
       
        ImageIcon i3=new ImageIcon(i2);       //jlabel is used to place the image on the frame and add function to add it
        JLabel label=new JLabel(i3); 
        add(label) ; 
        label.setBounds(70, 10, 100, 100);
        getContentPane().setBackground(Color.GRAY);                    //background color//

       
        JLabel text =new JLabel("WELCOME TO ATM");
        add(text);
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,40));

        JLabel cardno =new JLabel("CARD NO:");
        add(cardno);
        cardno.setBounds(120,150,150,30);
        cardno.setFont(new Font("Osward",Font.BOLD,30));
       
         cardTextField =new JTextField();
        cardTextField.setBounds(300, 150,250 , 30);
        add(cardTextField);


        JLabel pin =new JLabel("PIN:");
        add(pin);
        pin.setBounds(120,220,250,30);
        pin.setFont(new Font("Osward",Font.BOLD,30));

        pinTextField =new JPasswordField();
        pinTextField.setBounds(300, 220,250 , 30);
        add(pinTextField);


        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);                            //buttons specifications//
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);                            
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);                            
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

    }
    public static void main(String[] args) {
        new login();
        

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }
        else if (ae.getSource()==login){

            conn conn= new conn();
            String card_number= cardTextField.getText();
            String pin= pinTextField.getText();
            String query="select * from login where card_number='"+card_number+"' and pin='"+pin+"'";
            try{
             ResultSet rs= conn.s.executeQuery(query);
             if (rs.next()){
                setVisible(false);
                new transaction(pin).setVisible(true);
             }
             else{

                JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");

                
             }
            }
            catch(Exception e){
                System.out.println(e);

            }

        }
        else if (ae.getSource()==signup){
            setVisible(false);
            new signupone().setVisible(true);

        }

        
    }

}

