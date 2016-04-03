import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class info_form extends JFrame implements ActionListener
  {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6;

    info_form()
    {
     super("******** Samsung Mobiles Information *********");

    setSize(700,600);
    Container ct = getContentPane();

    ct.setBackground(Color.orange);
    ct.setLayout(null);

    addWindowListener(new Exit());
    setVisible(true);


    l1=new JLabel("Product ID");
    t1=new JTextField(5);
    l1.setBounds(20,50,150,20);
    t1.setBounds(200,50,100,20);
    ct.add(l1);
    ct.add(t1);

    l2=new JLabel("Product Company");
    t2=new JTextField(15);
    l2.setBounds(20,75,150,20);
    t2.setBounds(200,75,150,20);
    ct.add(l2);
    ct.add(t2);


    l3=new JLabel("Serial No.");
    t3=new JTextField(15);
    l3.setBounds(20,100,150,20);
    t3.setBounds(200,100,150,20);
    ct.add(l3);
    ct.add(t3);

    l4=new JLabel("Model Name");
    t4=new JTextField(20);
    l4.setBounds(20,125,150,20);
    t4.setBounds(200,125,150,20);
    ct.add(l4);
    ct.add(t4);

    l5=new JLabel("IMEI No.");
    t5=new JTextField(20);
    l5.setBounds(20,150,150,20);
    t5.setBounds(200,150,150,20);
    ct.add(l5);
    ct.add(t5);

    l6=new JLabel("Price");
    t6=new JTextField(10);
    l6.setBounds(20,175,150,20);
    t6.setBounds(200,175,150,20);
    ct.add(l6);
    ct.add(t6);


    l7=new JLabel("Features");
    l7.setBounds(20,200,150,20);
    ct.add(l7);

     c1=new JCheckBox("Dual Sim");
     c2=new JCheckBox("QWERTY Keypad");
     c3=new JCheckBox("3G Technology");
     c4=new JCheckBox("Bluetooth");
     c5=new JCheckBox("GPRS");
     c6=new JCheckBox("Multimedia");

     c1.setBounds(200,200,150,20);
     c2.setBounds(400,200,150,20);
     c3.setBounds(600,200,150,20);
     c4.setBounds(200,240,150,20);
     c5.setBounds(400,240,150,20);
     c6.setBounds(600,240,150,20);
     ct.add(c1);
     ct.add(c2);
     ct.add(c3);
     ct.add(c4);
     ct.add(c5);
     ct.add(c6);

    b1=new JButton("Submit");
    b2=new JButton("Cancel");
    b1.setBounds(550,550,90,25);
    b2.setBounds(720,550,90,25);

    ct.add(b1);
    ct.add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);

    show();
    }

public void actionPerformed(ActionEvent ae)
	{
		Connection con=null;
		Statement st=null;
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
                                st.executeUpdate("insert into Main values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"')");
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



