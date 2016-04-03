import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class update1 extends JPanel implements ActionListener
  {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2,b3,b;
    String str1,str2,str3,str4,str5,str6,str7,str8;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    BufferedImage i,i1,i2;

    update1(BufferedImage i)
    {
    this.i=i;

    setLayout(null);


    l1=new JLabel("Customer ID");
    t1=new JTextField(5);
    l1.setBounds(20,50,150,20);
    t1.setBounds(200,50,100,20);
    add(l1);
    add(t1);

    b=new JButton("Search");
    b.setBounds(400,50,100,20);
    add(b);
    b.addActionListener(this);

    l2=new JLabel("Customer Name.");
    t2=new JTextField(20);
    l2.setBounds(20,75,150,20);
    t2.setBounds(200,75,150,20);
    add(l2);
    add(t2);

    l3=new JLabel("Address");
    t3=new JTextField(15);
    l3.setBounds(20,100,150,20);
    t3.setBounds(200,100,150,20);
    add(l3);
    add(t3);

    l4=new JLabel("City");
    t4=new JTextField(20);
    l4.setBounds(20,125,150,20);
    t4.setBounds(200,125,150,20);
    add(l4);
    add(t4);

    l5=new JLabel("Mobile No.");
    t5=new JTextField(20);
    l5.setBounds(20,150,150,20);
    t5.setBounds(200,150,150,20);
    add(l5);
    add(t5);

        l6=new JLabel("Email ID");
        t6=new JTextField(10);
        l6.setBounds(20,175,150,20);
        t6.setBounds(200,175,150,20);
        add(l6);
        add(t6);

        l7=new JLabel("Purchased Product Model");
        t7=new JTextField(10);
        l7.setBounds(20,200,150,20);
        t7.setBounds(200,200,150,20);
        add(l7);
        add(t7);

        l8=new JLabel("Purchased date");
        t8=new JTextField(10);
        l9=new JLabel("dd/mm/yyyy");
        l8.setBounds(20,225,150,20);
        t8.setBounds(200,225,150,20);
        l9.setBounds(350,225,150,20);
        add(l8);
        add(t8);
        add(l9);

    Font f=new Font("Courier New",Font.BOLD,16);

    l1.setFont(f);
    l2.setFont(f);
    l3.setFont(f);
    l4.setFont(f);
    l5.setFont(f);
    l6.setFont(f);
    l7.setFont(f);
    l8.setFont(f);
    l9.setFont(f);



    b1=new JButton("Submit");
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

                ResultSet rs=null;
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
                { rs=null;
                 st1=con.createStatement();

                rs=st1.executeQuery("select *from customer where ID="+s);

               if(rs!=null)
                {
                 while(rs.next())
                    {
//Index 0 is for ID

                      s2=rs.getString(2);       //C ID
                      s3=rs.getString(3);       //C name
                      s4=rs.getString(4);       //C Address
                      s5=rs.getString(5);       //C Mob.
                      s6=rs.getString(6);       //C Email
                      s7=rs.getString(7);       //Product
                      s8=rs.getString(8);       //Purchased Date

                      t2.setText(s2);
                      t3.setText(s3);
                      t4.setText(s4);
                      t5.setText(s5);
                      t6.setText(s6);
                      t7.setText(s7);
                      t8.setText(s8);

                    }

                  }
               else if(rs==null)
               		{
                        JOptionPane.showMessageDialog(null,"Data is not founded ! Please provide correct ID", "Mobile Shop Maintanance System",
                  	JOptionPane.INFORMATION_MESSAGE);
System.out.println("Hello");
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
                                String str1=t1.getText();
                                String str2=t2.getText();
                                String str3=t3.getText();
                                String str4=t4.getText();
                                String str5=t5.getText();
                                String str6=t6.getText();
                                String str7=t7.getText();
                                String str8=t8.getText();


				st=con.createStatement();
                                st.executeUpdate("update Customer set ID='"+str1+"',C_name='"+str2+"',Address='"+str3+"',City='"+str4+"',Mobile='"+str5+"',Email_ID='"+str6+"',Model='"+str7+"',Purchased_Date='"+str8+"'where ID="+s);

                        JOptionPane.showMessageDialog(null,"Updated Successfully", "Mobile Shop Maintanance System",
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

  }
