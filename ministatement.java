package bank.management.Atmsimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ministatement extends JFrame {
    ministatement(String pin)
    {
    setSize(400,600);
    setLocation(20,20);
    setVisible(true);
    //setUndecorated(true);
    setLayout(null);

    JLabel bank=new JLabel(" Bank");
    bank.setBounds(150,20,100,20);

    bank.setFont(new Font("system",Font.BOLD,16));
    add(bank);

    JLabel card=new JLabel(" ");
    card.setBounds(20,80,300,20);
    add(card);

    JLabel mini=new JLabel();
    add(mini);
    mini.setBounds(20,140,400,200);

    JLabel balance=new JLabel();
    add(balance);
    balance.setBounds(20,400,300,20);



    try{

        conn c = new conn();
        ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
        while (rs.next()){
            card.setText("Card Number :"+ rs.getString("card_number").substring(0,4)+"-XXXX-XXXX-"+rs.getString("card_number").substring(12));
        }

    }catch(Exception e){
        System.out.println(e);
    }

    try{

        conn c = new conn();
        ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
        int bal=0;
        while (rs.next()){
            mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");

            if( rs.getString("type").equals("deposit")){
                bal+=Integer.parseInt(rs.getString("amount"));
            }
            else{

                bal-=Integer.parseInt(rs.getString("amount"));
            }

            balance.setText("Your current account balance is :"+ bal);
        }

    }catch(Exception e){
        System.out.println(e);
    }
    
    }

    public static void main (String args[]){
        new ministatement("");
    }
    
}
