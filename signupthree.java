package bank.management.Atmsimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupthree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    signupthree(String formno){

        this.formno=formno;
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        JLabel l1 = new JLabel("PAGE 3 : ACCOUNT DETAILS");
        l1.setFont(new Font("Raleway",Font.BOLD,24));
        l1.setBounds(200,40,400,40);
        add(l1 );

        JLabel type = new JLabel(" ACCOUNT TYPE");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,130,200,30);
        add(type );

        r1= new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBounds(100,180,150,20);
        r1.setBackground(Color.GRAY);
        add(r1);

        r2= new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBounds(350,180,250,20);
        r2.setBackground(Color.GRAY);
        add(r2);

        r3= new JRadioButton("Current Account");
        r3.setBounds(100,220,150,20);
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(Color.GRAY);
        add(r3);

        r4= new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,220,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(Color.GRAY);
        add(r4);

        ButtonGroup accountgroup= new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card = new JLabel(" CARD NUMBER");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card );
        JLabel number = new JLabel(" XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300,300,300,30);
        add(number );
        JLabel cdetail = new JLabel(" Your 16 digit card number");
        cdetail.setFont(new Font("Raleway",Font.BOLD,12));
        cdetail.setBounds(100,320,200,30);
        add(cdetail );

        JLabel pin = new JLabel(" PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,350,200,30);
        add(pin );
        JLabel pnumber = new JLabel(" XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(300,350,300,30);
        add(pnumber );
        JLabel pdetail = new JLabel(" Your 4 digit pin number");
        pdetail.setFont(new Font("Raleway",Font.BOLD,12));
        pdetail.setBounds(100,370,300,30);
        add(pdetail );

        JLabel services= new JLabel("SERVICES REQUIRED");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,420,300,30);
        add(services );

        c1= new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBounds(100,470,200,20);
        c1.setBackground(Color.GRAY);
        add(c1 );

        c2= new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBounds(350,470,200,20);
        c2.setBackground(Color.GRAY);
        add(c2 );

        c3= new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBounds(100,490,200,20);
        c3.setBackground(Color.GRAY);
        add(c3 );

        c4= new JCheckBox("EMAIL & SMS ALERT");
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBounds(350,490,200,20);
        c4.setBackground(Color.GRAY);
        add(c4 );

        c5= new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway",Font.BOLD,14));
        c5.setBounds(100,510,200,20);
        c5.setBackground(Color.GRAY);
        add(c5 );

        c6= new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Raleway",Font.BOLD,14));
        c6.setBounds(350,510,200,20);
        c6.setBackground(Color.GRAY);
        add(c6 );

        c7= new JCheckBox("I hereby declare that the above entered details are true and best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,550,600,30);
        c7.setBackground(Color.GRAY);
        add(c7 );

        submit= new JButton("SUBMIT");
        submit.setBounds(250,600,100,20);                            
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("CANCEL");
        cancel.setBounds(420,600,100,20);                            
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


    }

    public static void main(String args[]){
        new signupthree("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==submit){
        String accounttype=null;
        if(r1.isSelected()){
         accounttype="Savings Account";
        }
        else if(r2.isSelected()){
            accounttype="Fixed Deposit Account";
        }
        else if(r3.isSelected()){
            accounttype="Current Account";
        }
        else if(r4.isSelected()){
            accounttype="Recurring Deposit";

        }


        Random random=new Random();
        String cardnumber= ""+Math.abs((random.nextLong()% 90000000L)+ 9749736000000000L);
        String pin=""+Math.abs((random.nextLong()% 9000L)+ 1000L);

        String facility="";
        if(c1.isSelected()){
         facility="Atm Card";
        }
        else if(c2.isSelected()){
            facility="Internet Banking";
        }
        else if(c3.isSelected()){
            facility="Mobile Banking";
        }
        else if(c4.isSelected()){
            facility="Email & sms alert";

        }
         else if(c5.isSelected()){
            facility="Cheque Book";

        }
         else if(c6.isSelected()){
            facility="E-statement";

        }
         
        try{

            conn conn = new conn();
            String query1="INSERT INTO signupthree VALUES('" + formno + "', '" + accounttype + "', '" + cardnumber + "', '" + pin + "','" + facility + "')";
            String query2="INSERT INTO login VALUES('" + formno + "', '" + cardnumber + "', '" + pin + "')"; 
            conn.s.executeUpdate(query1); 
            conn.s.executeUpdate(query2);     
            
            JOptionPane.showMessageDialog(null,"Cardnumber:"+ cardnumber +"\npin:"+ pin);
            setVisible(false);
            new Deposit(pin).setVisible(false);
        
        
        }
        catch(Exception e){
            System.out.println(e);

        }
    }
    else if (ae.getSource()==cancel){
        setVisible(false);
        new login().setVisible(true);

    }

    }
    
}
