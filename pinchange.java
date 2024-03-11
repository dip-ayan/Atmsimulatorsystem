package bank.management.Atmsimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener {

    JPasswordField pintextfield,repintextfield;
    JButton change,back;
    String pin;
    pinchange(String pin){
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

        JLabel text=new JLabel("Change Your Pin");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text); 

        JLabel epin=new JLabel("New Pin");
        epin.setBounds(165,320,180,25);
        epin.setForeground(Color.WHITE);
        epin.setFont(new Font("system",Font.BOLD,16));
        image.add(epin); 

        pintextfield = new JPasswordField();
          pintextfield .setFont(new Font("Raleway",Font.BOLD,16));
          pintextfield .setBounds(330,320,180,25);
          image.add(pintextfield );

        JLabel repin=new JLabel("Re Enter New Pin");
        repin.setBounds(165,360,180,25);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("system",Font.BOLD,16));
        image.add(repin); 

        repintextfield = new JPasswordField();
          repintextfield .setFont(new Font("Raleway",Font.BOLD,16));
          repintextfield .setBounds(330,360,180,25);
          image.add(repintextfield );
       
          change = new JButton("Change");
         change.setBounds(355, 485,150,30);
         change.addActionListener(this);
         image.add(change);

          back = new JButton("Back");
         back.setBounds(355, 520,150,30);
         back.addActionListener(this);
         image.add(back);

    }

    public static void main(String[] args){

        new pinchange("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

      if (ae.getSource()==change)
      try{

        String npin=pintextfield.getText();
        String rpin=repintextfield.getText();

        if(!npin.equals(rpin)){
          JOptionPane.showMessageDialog(null,"Entered PIN does not match");
          return;
        }
        if(npin.equals("")){
          JOptionPane.showMessageDialog(null,"Please Enter New Pin");
          return;
        }
        if(rpin.equals("")){
          JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
          return;
        }

        conn c=new conn();
        String query1= "update bank set pin='"+rpin+"'where pin='"+pin+"'";
        String query2= "update login set pin='"+rpin+"'where pin='"+pin+"'";
        String query3= "update signupthree set pin='"+rpin+"'where pin='"+pin+"'";
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        c.s.executeUpdate(query3);
        JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
        setVisible(false);
        new transaction(rpin).setVisible(true);


      }
      catch(Exception e){

        System.out.println(e);
      }

      else{
         setVisible(false);
         new transaction(pin).setVisible(true);
      }
      
    }
    
}
