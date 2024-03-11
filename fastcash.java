package bank.management.Atmsimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener{

        String pin;
        JButton exit,deposit,withdrawal,fastcash,ministatement,pinchange,balanceenquiry;
     fastcash(String pin){
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

        JLabel text=new JLabel("Enter Withdrawal Amount");
        text.setBounds(230,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text);                                          // adding text over image//
        

         deposit= new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

         withdrawal= new JButton("Rs 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

         fastcash= new JButton(" Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

         ministatement= new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

         pinchange= new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

         balanceenquiry= new JButton("Rs 10000");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

         exit= new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

    }
    


public static void main(String args[]){
    new fastcash("");
}



@Override
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==exit){
        setVisible(false);
        new transaction(pin).setVisible(true);

    }
    else{
        String amount= ((JButton)ae.getSource()).getText().substring(3);
        conn conn = new conn();
        try{
        String query= "";

        ResultSet rs= conn.s.executeQuery("select * from bank where pin='"+pin+"'");
        int balance=0;
        while(rs.next()){
            if( rs.getString("type").equals("deposit")){
                balance+=Integer.parseInt(rs.getString("amount"));
            }  
            else{

                balance-=Integer.parseInt(rs.getString("amount"));
            }
        }
        if (ae.getSource()!=exit && balance<Integer.parseInt(amount)){
            JOptionPane.showMessageDialog(null,"Insufficient Balance");
            return;

        }
        else{

            Date date =new Date();
             query="insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Successfully" );
            setVisible(false);
            new transaction(pin).setVisible(true);

        }


        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
}