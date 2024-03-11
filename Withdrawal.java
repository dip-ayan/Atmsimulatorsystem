package bank.management.Atmsimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

 public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw,back;
    String pin;
    Withdrawal(String pin){
        this.pin=pin;

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text);

        amount= new JTextField();
       amount .setFont(new Font("Raleway",Font.BOLD,14));
       amount .setBounds(170,350,320,25);
        add(amount );

         withdraw= new JButton("Withdraw");
         withdraw.setBounds(355,485,150,30);
         withdraw.addActionListener(this);
        image.add(withdraw);

        back= new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
    }
    public static void main(String args[]){
        new Withdrawal("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource()==withdraw){

              String Amount=amount.getText();
              Date date= new Date();
              if (Amount.equals("")){

                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
              }
              else  {
                try{

                conn conn =new conn();
                String query="insert into bank values ('" + pin + "', '" + date + "', ' withdraw ', '" + Amount + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+ Amount+ " Withdrawn Successfully");
                setVisible(false);
                new transaction(pin).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);

                }

              }




       }
       else if (ae.getSource()==back){

        setVisible(false);
        new transaction(pin).setVisible(true);
       }
    }
}

