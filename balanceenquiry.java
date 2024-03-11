package bank.management.Atmsimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class balanceenquiry extends JFrame implements ActionListener {
    JButton back;
    String pin;

balanceenquiry(String pin){
    this.pin=pin;
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        //setUndecorated(true);
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520,150,30);
        back.addActionListener(this);
        image.add(back);

       
        int balance=0;
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

            JLabel text=new JLabel("Your Current Account Balance is Rs :"+ balance);
          text.setBounds(170,300,400,30);
           text.setForeground(Color.WHITE);
            text.setFont(new Font("system",Font.BOLD,12));
            image.add(text); 
           
        

}
    public static void main(String args[]){
        new balanceenquiry("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new transaction(pin).setVisible(true);
        
        }
       
}
