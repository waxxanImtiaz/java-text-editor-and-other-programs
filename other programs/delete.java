import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.image.BufferedImage; 



public class delete extends JPanel implements ActionListener,ItemListener
  {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2,b3,b;
    JCheckBox c1,c2,c3,c4,c5,c6;
    String str1,str2,str3,str4,str5,str6,str7,str8;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
    BufferedImage i1,i2,i;

    delete(BufferedImage i)
    {  this.i=i;

    setSize(1400,900);

    setBackground(Color.blue);
    setLayout(null);

    setVisible(true);

    l1=new JLabel("Product ID");
    t1=new JTextField(5);
    l1.setBounds(20,50,150,20);
    t1.setBounds(200,50,100,20);
    add(l1);
    add(t1);

    b=new JButton("Search");
    b.setBounds(400,50,100,20);
    add(b);
    b.addActionListener(this);

    l2=new JLabel("IMEI No.");
    t2=new JTextField(20);
    l2.setBounds(20,75,150,20);
    t2.setBounds(200,75,150,20);
    add(l2);
    add(t2);


    l3=new JLabel("Product Company");
    t3=new JTextField(15);
    l3.setBounds(20,100,150,20);
    t3.setBounds(200,100,150,20);
    add(l3);
    add(t3);

    l4=new JLabel("Model Name");
    t4=new JTextField(20);
    l4.setBounds(20,125,150,20);
    t4.setBounds(200,125,150,20);
    add(l4);
    add(t4);

    l5=new JLabel("Serial No.");
    t5=new JTextField(20);
    l5.setBounds(20,150,150,20);
    t5.setBounds(200,150,150,20);
    add(l5);
    add(t5);

    l6=new JLabel("Price");
    t6=new JTextField(10);
    l6.setBounds(20,175,150,20);
    t6.setBounds(200,175,150,20);
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
     
     c1.setBackground(Color.yellow);
     c2.setBackground(Color.yellow);
     c3.setBackground(Color.yellow);
     c4.setBackground(Color.yellow);
     c5.setBackground(Color.yellow);
     c6.setBackground(Color.yellow);

     add(c1);
     add(c2);
     add(c3);
     add(c4);
     add(c5);
     add(c6);

    b1=new JButton("Delete");
    b2=new JButton("Cancel");

    b3=new JButton(" BacK ");
    b1.setBounds(450,550,90,25);
    b2.setBounds(600,550,90,25);
    b3.setBounds(750,550,90,25);

    add(b1);
    add(b2);
    add(b3);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);


    show();
    }

public void paintComponent(Graphics g)
    {

        g.drawImage(i, 0, 0, this);

    }



public void actionPerformed(ActionEvent ae)
	{

        	Connection con=null;
                Statement st=null,st1=null;

                ResultSet rs;
                String s=t1.getText();
		try
		{
                  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                  con=DriverManager.getConnection("jdbc:odbc:MY");
                 }
		catch(Exception e2)
		{
			System.out.println(e2);
		}


           if(ae.getSource()==b)
                {
                try
                { 
                 st1=con.createStatement();

                rs=st1.executeQuery("select *from store where PID="+s);
               if(rs!=null)
                {
                 while(rs.next())
                    {
//Index 0 is for ID

                      s2=rs.getString(2);       //IMEI
                      s3=rs.getString(3);       //company
                      s4=rs.getString(4);       //model
                      s5=rs.getString(5);       //Sr. No.
                      s6=rs.getString(6);       //Price

                      s7=rs.getString(7);       //GPRS
                      s8=rs.getString(8);       //Dual sim
                      s9=rs.getString(9);       //Bluetooth
                      s10=rs.getString(10);     //3G
                      s11=rs.getString(11);     //QWERTY
                      s12=rs.getString(12);     //Multimedia


                      c1.setSelected(s7.equals("Yes"));
                      c2.setSelected(s8.equals("Yes"));
                      c3.setSelected(s9.equals("Yes"));
                      c4.setSelected(s10.equals("Yes"));
                      c5.setSelected(s11.equals("Yes"));
                      c6.setSelected(s12.equals("Yes"));

				c1.addItemListener(this);
				c2.addItemListener(this);
				c3.addItemListener(this);
				c4.addItemListener(this);
				c5.addItemListener(this);
				c6.addItemListener(this);



                      t2.setText(s2);
                      t3.setText(s3);
                      t4.setText(s4);
                      t5.setText(s5);
                      t6.setText(s6);

                    }

                  }


                }
                catch(Exception e4)
                { System.out.println(e4);
                }

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


   st=con.createStatement();
   st.executeUpdate("delete from Store where PID= "+s);

                        JOptionPane.showMessageDialog(null,"Deleted Successfully", "Mobile Shop Maintanance System",
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

                if(ae.getSource()==b3)
		{
                        menu o=new menu(i1,i2);
			setVisible(false);

                }

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

  }


