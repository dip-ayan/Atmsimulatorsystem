package bank.management.Atmsimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;





public class signuptwo extends JFrame implements ActionListener{

    
    JTextField pantextfield,adhartextfield;
    JButton next;
    JRadioButton eyes,eno,syes,sno;
    JComboBox Religion,Category,Income,Education,Occupation;
    String formno;


    
    signuptwo(String formno){

         this.formno= formno;
          setSize(850,800);
          setVisible(true);
          setLocation(350,10);
          getContentPane().setBackground(Color.GRAY);
          setLayout(null);

          setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

          JLabel additionaldetails = new JLabel("PAGE 2 : ADDITIONAL DETAILS");
          additionaldetails .setFont(new Font("Raleway",Font.BOLD,24));
          additionaldetails .setBounds(270,80,400,30);
          add(additionaldetails );

          JLabel religion = new JLabel("RELIGION :");
          religion.setFont(new Font("Raleway",Font.BOLD,20));
          religion.setBounds(100,140,200,30);
          add(religion);

           

         String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
         Religion=new JComboBox(valReligion);
         Religion.setBounds(300,140,300,30);
         Religion.setBackground(Color.WHITE);
          add(Religion);

          JLabel category = new JLabel("CATEGORY :");
          category.setFont(new Font("Raleway",Font.BOLD,20));
          category.setBounds(100,190,200,30);
          add(category);

           

          String valcategory[] = {"General","OBC","SC","ST","Other"};
          Category=new JComboBox(valcategory);
         Category.setBounds(300,190,300,30);
         Category.setBackground(Color.WHITE);
          add(Category);

          JLabel income = new JLabel("INCOME:");
          income .setFont(new Font("Raleway",Font.BOLD,20));
          income .setBounds(100,240,200,30);
          add( income);

          String incomecategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10 lakh"};
          Income=new JComboBox(incomecategory);
          Income.setBounds(300,240,300,30);
          Income.setBackground(Color.WHITE);
          add(Income);

          

          JLabel education= new JLabel("EDUCATIONAL");
          education .setFont(new Font("Raleway",Font.BOLD,20));
          education .setBounds(100,290,200,30);
          add( education);

          JLabel qual= new JLabel("QUALIFICATION:");
          qual.setFont(new Font("Raleway",Font.BOLD,20));
          qual .setBounds(100,320,200,30);
          add( qual);

          String educationvalues[] = {"Non Graduate","Graduate","Post Graduate","Doctorate","Others"};
           Education=new JComboBox(educationvalues);
          Education.setBounds(300,320,300,30);
          Education.setBackground(Color.WHITE);
          add(Education);

          JLabel occupation = new JLabel("OCCUPATION:");
          occupation .setFont(new Font("Raleway",Font.BOLD,20));
          occupation .setBounds(100,390,200,30);
          add( occupation);

          String occupationvalues[] = {"Salaried","Self-Employed","Business","Student","Retired"};
           Occupation=new JComboBox(occupationvalues);
          Occupation.setBounds(300,390,300,30);
          Occupation.setBackground(Color.WHITE);
          add(Occupation);

         

          JLabel pan = new JLabel("PAN NO:");
          pan  .setFont(new Font("Raleway",Font.BOLD,20));
          pan  .setBounds(100,440,200,30);
          add( pan );

          pantextfield = new JTextField();
          pantextfield .setFont(new Font("Raleway",Font.BOLD,14));
          pantextfield .setBounds(300,440,300,30);
          add(pantextfield );

          JLabel adhar = new JLabel("ADHAR NO:");
          adhar  .setFont(new Font("Raleway",Font.BOLD,20));
          adhar  .setBounds(100,490,200,30);
          add( adhar);
          adhartextfield = new JTextField();
          adhartextfield.setFont(new Font("Raleway",Font.BOLD,14));
          adhartextfield .setBounds(300,490,300,30);
          add(adhartextfield);


          JLabel senior = new JLabel("SENIOR CITIZEN:");
          senior  .setFont(new Font("Raleway",Font.BOLD,20));
          senior .setBounds(100,540,200,30);
          add( senior );

          syes=new JRadioButton("YES");
          syes.setBounds(300,540,100,30);
          syes.setBackground(Color.GRAY);
          add(syes);
          sno= new JRadioButton("NO");
          sno.setBounds(410,540,100,30);
          sno.setBackground(Color.GRAY);
          add(sno);
         

          ButtonGroup seniorgroup=new ButtonGroup();
          seniorgroup.add(syes);
          seniorgroup.add(sno);
          
          

          JLabel exacc= new JLabel("EXISTING ACCOUNT:");
          exacc .setFont(new Font("Raleway",Font.BOLD,20));
          exacc.setBounds(100,590,220,30);
          add( exacc );
          eyes=new JRadioButton("YES");
          eyes.setBounds(300,590,100,30);
          eyes.setBackground(Color.GRAY);
          add(eyes);
          eno= new JRadioButton("NO");
          eno.setBounds(410,590,100,30);
          eno.setBackground(Color.GRAY);
          add(eno);
         

          ButtonGroup accgroup=new ButtonGroup();
          accgroup.add(eyes);
          accgroup.add(eno);

           next= new JButton("NEXT");
          next.setBounds(520,660,80,20);                            
          next.setBackground(Color.BLACK);
          next.setForeground(Color.WHITE);
          add(next);
          next.addActionListener(this);



    }
    

    public static void main(String args[]){
    new signuptwo("");    


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       
       String sreligion=(String)Religion.getSelectedItem();
       String scategory=(String)Category.getSelectedItem();
       String sincome=(String)Income.getSelectedItem();
       String seducation=(String)Education.getSelectedItem();
       String span=pantextfield.getText();
       String soccupation=(String)Occupation.getSelectedItem();
       String sadhar=adhartextfield.getText();
    
       String seniorcitizen=null;
       if(syes.isSelected()){
        seniorcitizen="Yes";
       }
       else if(sno.isSelected()){
        seniorcitizen="No";
       }

       String exsacc=null;
       if(eyes.isSelected()){
        exsacc="Yes";
       }
       else if(eno.isSelected()){
        exsacc="No";
       }
       

       try{
        conn c= new conn();
        String query="INSERT INTO signuptwo VALUES ('" + formno + "','" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "','" + soccupation + "', '"+ span + "', '" + sadhar + "', '" + seniorcitizen + "', '" + exsacc + "')";

        c.s.executeUpdate(query);

        setVisible(false);
        new signupthree(formno).setVisible(true);

       }
       catch(Exception e){
        System.out.println(e);

       }


    }


    

}
