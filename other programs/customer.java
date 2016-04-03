import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.sql.*;


public class customer extends JPanel implements ActionListener
  {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6;
    BufferedImage i;
    Font f;

    customer(BufferedImage i)
    {
		this.i = i;

    setLayout(null);
    f=new Font("Courier New",Font.BOLD,16);
    l1=new JLabel("Customer ID");
    l2=new JLabel("Customer Name");
    l3=new JLabel("Address");
    l4=new JLabel("Amount");
    l5=new JLabel("Mobile No.");
    l6=new JLabel("Email ID");
    l7=new JLabel("Purchased Model");
    l8=new JLabel("Purchased date");
    l9=new JLabel("dd/mm/yyyy");

       /* l1.setColor(Color.RED);
	l2.setColor(Color.RED);
	l3.setColor(Color.RED);
	l4.setColor(Color.RED);
	l5.setColor(Color.RED);
	l6.setColor(Color.RED);
	l7.setColor(Color.RED);
	l8.setColor(Color.RED);
	l9.setColor(Color.RED);
        */
    l1.setFont(f);
    l2.setFont(f);
    l3.setFont(f);
    l4.setFont(f);
    l5.setFont(f);
    l6.setFont(f);
    l7.setFont(f);
    l8.setFont(f);
    l9.setFont(f);

    t1=new JTextField(5);
    l1.setBounds(20,50,150,20);
    t1.setBounds(200,50,100,20);
    add(l1);
    add(t1);

    t2=new JTextField(15);
    l2.setBounds(20,75,150,20);
    t2.setBounds(200,75,150,20);
    add(l2);
    add(t2);


    t3=new JTextField(15);
    l3.setBounds(20,100,150,20);
    t3.setBounds(200,100,150,20);
    add(l3);
    add(t3);

    t4=new JTextField(20);
    l4.setBounds(20,125,150,20);
    t4.setBounds(200,125,150,20);
    add(l4);
    add(t4);

    t5=new JTextField(20);
    l5.setBounds(20,150,150,20);
    t5.setBounds(200,150,150,20);
    add(l5);
    add(t5);

    t6=new JTextField(10);
    l6.setBounds(20,175,150,20);
    t6.setBounds(200,175,150,20);
    add(l6);
    add(t6);

    t7=new JTextField(10);
    l7.setBounds(20,200,150,20);
    t7.setBounds(200,200,150,20);
    add(l7);
    add(t7);

    t8=new JTextField(10);
    l8.setBounds(20,225,150,20);
    t8.setBounds(200,225,150,20);
    l9.setBounds(350,225,150,20);


    add(l8);
    add(t8);
    add(l9);
t1.setToolTipText("Input Customer ID");
t2.setToolTipText("Input Customer Name ");
t3.setToolTipText("Input Customer Address");
t4.setToolTipText("Input mobile cost purchased by customer");
t5.setToolTipText("Input Customer Mobile No");
t6.setToolTipText("Input Customeer Email Id");
t7.setToolTipText("Input purchased model name");
t8.setToolTipText("Input Purchasing Date");

    b1=new JButton("Submit");
    b2=new JButton("Cancel");
    b1.setBounds(550,550,90,25);
    b2.setBounds(720,550,90,25);
	b1.setToolTipText("Click oK to SUBMIT");
    b2.setToolTipText("Click to Clear TextField");

    add(b1);
    add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);

    }

public void paintComponent(Graphics g)
    {

        g.drawImage(i, 0, 0, this);

    }


public void actionPerformed(ActionEvent ae)
	{
		Connection con=null;
                Statement st=null,st1=null,st2=null;
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
        if(t1.getText().equals("")||(t2.getText().equals(""))||(t3.getText().equals(""))||(t4.getText().equals(""))||(t5.getText().equals(""))||(t7.getText().equals(""))||(t8.getText().equals("")))

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
                                String str1=t1.getText();         // C_ID
                                String str2=t2.getText();         // C_Name
                                String str3=t3.getText();         // Address
                                String str4=t4.getText();         // Amount
                                String str5=t5.getText();         // Mobile
                                String str6=t6.getText();         // Email
                                String str7=t7.getText();         // Purchased model
                                String str8=t8.getText();         // Purchased Date


				st=con.createStatement();
                                st.executeUpdate("insert into Customer values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"','"+str8+"')");

                                st1=con.createStatement();

                       // st1.executeUpdate("delete from store where Model="+str7);

   st2=con.createStatement();
   st2.executeUpdate("insert into Purchase values('"+str1+"','"+str2+"','"+str7+"','"+str4+"','"+str8+"')");

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
			setVisible(false);
		}
	}


  }
