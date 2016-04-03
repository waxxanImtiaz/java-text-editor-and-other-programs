import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.sql.*;

public class mobile extends JPanel implements ActionListener,ItemListener
  {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3;
    JCheckBox c1,c2,c3,c4,c5,c6;
    String str7,str8,str9,str10,str11,str12;
    String s1,s2,s3,s4,s5,s6;
    BufferedImage i,i1,i2;

    mobile(BufferedImage i)
    {
        this.i = i;

        s1="No";
        s2="No";
        s3="No";
        s4="No";
        s5="No";
        s6="No";

    setLayout(null);
    setVisible(true);
    setSize(1400,900);

    l1=new JLabel("Product ID");
    t1=new JTextField(5);
    l1.setBounds(20,50,150,20);
    t1.setBounds(200,50,100,20);
    t1.setToolTipText("Ener ID of Mobile to be Stored");

    add(l1);
    add(t1);

    l2=new JLabel("IMEI No.");
    t2=new JTextField(20);
    l2.setBounds(20,75,150,20);
    t2.setBounds(200,75,150,20);
    t2.setToolTipText("Ener IMEI No. of Mobile printed on Box");

    add(l2);
    add(t2);

    l3=new JLabel("Product Company");
    t3=new JTextField(15);
    l3.setBounds(20,100,150,20);
    t3.setBounds(200,100,150,20);
    t3.setToolTipText("Ener Company.of Mobile");

    add(l3);
    add(t3);

    l4=new JLabel("Model Name");
    t4=new JTextField(20);
    l4.setBounds(20,125,150,20);
    t4.setBounds(200,125,150,20);
    t4.setToolTipText("Ener IModel Name of Mobile");

    add(l4);
    add(t4);

    l5=new JLabel("Serial No.");
    t5=new JTextField(20);
    l5.setBounds(20,150,150,20);
    t5.setBounds(200,150,150,20);
    t5.setToolTipText("Ener Serial No.of Mobile printed on Box");

    add(l5);
    add(t5);

    l6=new JLabel("Price");
    t6=new JTextField(10);
    l6.setBounds(20,175,150,20);
    t6.setBounds(200,175,150,20);
    t6.setToolTipText("Ener Price of Mobile");

    add(l6);
    add(t6);


    l7=new JLabel("Features");
    l7.setBounds(20,200,150,20);
    add(l7);

    Font f=new Font("Courier New",Font.BOLD,16);
    l1.setFont(f);
    l2.setFont(f);
    l3.setFont(f);
    l4.setFont(f);
    l5.setFont(f);
    l6.setFont(f);
    l7.setFont(f);


     c1=new JCheckBox("GPRS");
     c2=new JCheckBox("Dual Sim");
     c3=new JCheckBox("Bluetooth");
     c4=new JCheckBox("3G Technology");
     c5=new JCheckBox("QWERTY Keypad");
     c6=new JCheckBox("Multimedia");

     c1.setBounds(200,200,150,20);
     c2.setBounds(400,200,150,20);
     c3.setBounds(600,200,150,20);
     c4.setBounds(200,240,150,20);
     c5.setBounds(400,240,150,20);
     c6.setBounds(600,240,150,20);
    add(c1);
    add(c2);
     add(c3);
     add(c4);
     add(c5);
     add(c6);

    b1=new JButton("Submit");
    b2=new JButton("Refresh");

    b3=new JButton(" BacK ");
    b1.setBounds(450,550,90,25);
    b2.setBounds(600,550,90,25);
    b3.setBounds(750,550,90,25);
	b1.setToolTipText("Click oK to SUBMIT");
    b2.setToolTipText("Click to Clear TextField");
    b3.setToolTipText("Click Back to Menu form");

    add(b1);
    add(b2);
    add(b3);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    c1.addItemListener(this);
    c2.addItemListener(this);
    c3.addItemListener(this);
    c4.addItemListener(this);
    c5.addItemListener(this);
    c6.addItemListener(this);

    }

public void paintComponent(Graphics g)
    {

        g.drawImage(i, 0, 0, this);

    }
public void itemStateChanged(ItemEvent e)
     {


        if(e.getSource()==c1)
             s1="Yes";

        if(e.getSource()==c2)
             s2="Yes";

        if(e.getSource()==c3)
             s3="Yes";

        if(e.getSource()==c4)
             s4="Yes";

        if(e.getSource()==c5)
             s5="Yes";

        if(e.getSource()==c6)
             s6="Yes";



     }
public void actionPerformed(ActionEvent ae)
	{
		Connection con=null;
                Statement st=null;
                Statement st1=null;

		try
		{
                   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                  con=DriverManager.getConnection("jdbc:odbc:MY");
		}
		catch(Exception e2)
		{
			System.out.println(e2);
		}

                if(ae.getSource()==b1)
		{

                      boolean flag=false;
        if(t1.getText().equals("")&&(t2.getText().equals(""))&&(t3.getText().equals(""))&&(t4.getText().equals(""))&&(t5.getText().equals(""))&&(t6.getText().equals("")))
                        {
				flag=true;
			}

                     if(flag==true)
			{
                        JOptionPane.showMessageDialog(null,"One or more fields left blank!  Please provide all the details", "Mobile Shop Maintanance System",
                  	JOptionPane.INFORMATION_MESSAGE);
			}

			else
			{

			try
			{
                                String str1=t1.getText();
                                String str2=t2.getText();
                                String str3=t3.getText();
                                String str4=t4.getText();
                                String str5=t5.getText();
                                String str6=t6.getText();

   st=con.createStatement();
   st.executeUpdate("insert into Store values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");

                        JOptionPane.showMessageDialog(null,"Inserted Successfully", "Mobile Shop Maintanance System",
                  	JOptionPane.INFORMATION_MESSAGE);





			}

			catch(Exception e3)
			{
				System.out.println(e3);
			}
			}
		}

      if(ae.getSource()==b2)
		{
			String s="";
			      t1.setText(s);
       			  t2.setText(s);
       			  t3.setText(s);
				  t4.setText(s);
				  t5.setText(s);
				  t6.setText(s);

		}

                if(ae.getSource()==b3)
		{
                        menu o=new menu(i1,i2);
			setVisible(false);
		}

	}


  }



