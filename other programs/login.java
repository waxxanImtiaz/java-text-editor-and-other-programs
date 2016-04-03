import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.sql.*;
import java.util.*;

public class login extends JPanel implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;
    BufferedImage image1,i1,i2;

  login(BufferedImage image1)
{
      this.image1 = image1;

      setLayout(null);

      l1=new JLabel("User Name");
      l2=new JLabel("Password");

      t1=new JTextField(15);
      t2=new JPasswordField(10);


      l1.setBounds(300,90,80,20);
      add(l1);

      l2.setBounds(420,90,80,20);
      add(l2);

	  t1.setToolTipText("Ener USER ID");
      t2.setToolTipText("Ener PASSWORD");
      t1.setBounds(300,110,110,20);
      add(t1);

      t2.setBounds(420,110,110,20);
      add(t2);


      b1=new JButton("  OK  ");
      b2=new JButton("Cancel");
      b3=new JButton("Click ME");
         b1.setToolTipText("Click oK to SUBMIT");
         b2.setToolTipText("Click CANCEL to clear above TextField");
         b3.setToolTipText("Click for INFORMATION about Project Submitter");


      b1.setBounds(320,140,80,20);
      b2.setBounds(430,140,80,20);
      b3.setBounds(360,170,100,20);

     add(b1);
     add(b2);
	 add(b3);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);


  }

public void paintComponent(Graphics g)
    {
        g.drawImage(image1, 0, 0, this);

    }


//  OK button event handeling

public void actionPerformed(ActionEvent e4)
     {
        String s1="",s2="";
		 String st1=t1.getText();
		 String st2=t2.getText();
           int n=st2.length();

        if(e4.getSource()==b1)
         {
        if(n<=5)
            {
                    JOptionPane.showMessageDialog(null,"Strength of UserName & Password is weak ! \nPlease provide UserName or Password minimum of 6 character ", "Mobile Shop Maintanance System",
                    JOptionPane.ERROR_MESSAGE);

            }
        else
        {
        Connection con=null;
        Statement st=null;
        ResultSet rs;

        try
         {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con=DriverManager.getConnection("jdbc:odbc:MY");


           st=con.createStatement();
           rs=st.executeQuery("select *from login ");

           if(rs!=null)
               {
                  while(rs.next())
                    {

                      s1=rs.getString(1);       //username
                      s2=rs.getString(2);       //password

                    }
               }
         }
         catch(Exception e2)
            { System.out.println(e2);
            }





        if((st1.equals(s1))&&(st2.equals(s2)))
          {
        try
           {
        JFrame f=new JFrame("******* Selection Menu *******");

        i1= ImageIO.read(new File("E:/coding/2.jpg"));
	    i2= ImageIO.read(new File("E:/coding/4.jpg"));
	    menu m = new menu(i1,i2);


        f.add(m);
        f.setSize(1400,900);
        f.show();
        f.setBackground(Color.cyan);
          }


      catch(Exception e3)
         {  System.out.println(e3);
         }

        }

      else
        {
        JOptionPane.showMessageDialog(null,"Invalid UserName or Password ! Please provide right details for Login", "Mobile Shop Maintanance System",JOptionPane.ERROR_MESSAGE);
        }


     }

     }



    if(e4.getSource()==b2)
     {
       String s="";
       t1.setText(s);
       t2.setText(s);

     }

    if(e4.getSource()==b3)
      {
       JOptionPane.showMessageDialog(null,"This Project is made under super Guidance of Mrs. Shivani Rastogi\n(Faculty of Computer Science, KCMT Bareilly)  by \n\t Praval Parashari\n\t Sumeet Kumar\n\t Om Prakash\n\tStudents of MCA (IV sem)",
       "Mobile Shop Maintanance System",JOptionPane.INFORMATION_MESSAGE);

      }


    }

}






