import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Change_Pswd extends JFrame implements ActionListener

{
JLabel l0,l2,l3,l4,l5,l6,l7;
JTextField t1,t2;
JPasswordField p1,p2,p3,p4,p5;
JButton b1,b2;
ImageIcon image1;
        Change_Pswd()
	{
		super("Change Password");
                setVisible(true);
                setSize(1400,900);

		setLayout(null);
		Container c=getContentPane();
		c.setBackground(Color.orange);

       // Allocating Labels

                l0=new JLabel("User Name");
                l2=new JLabel("Old Password");
                l3=new JLabel("New UserName");
                l4=new JLabel("New Password");
                l5=new JLabel("Confirm Password");
                l6=new JLabel("Master User Name");
                l7=new JLabel("Master Password");

       // Allocating Textfields

                t1=new JTextField(15);
                t2=new JTextField(15);
                p1=new JPasswordField(15);
                p2=new JPasswordField(15);
                p3=new JPasswordField(15);
                p4=new JPasswordField(15);
                p5=new JPasswordField(15);


                b1=new JButton("OK");
                b2=new JButton("Cancel");

       // Adding Labels

                c.add(l0);
                c.add(l2);
                c.add(l3);
                c.add(l4);
                c.add(l5);
                c.add(l6);
                c.add(l7);

       // Adding Textfields

                c.add(t1);
                c.add(t2);
                c.add(p1);
                c.add(p2);
                c.add(p3);
                c.add(p4);
                c.add(p5);

                c.add(b1);
                c.add(b2);

        //Setting bounds

                l0.setBounds(100,100,150,30);
                l2.setBounds(100,150,150,30);
                l3.setBounds(100,200,150,30);
                l4.setBounds(100,250,150,30);
                l5.setBounds(100,300,150,30);
                l6.setBounds(100,350,150,30);
                l7.setBounds(100,400,150,30);

                t1.setBounds(250,100,200,30);
                p1.setBounds(250,150,200,30);
                t2.setBounds(250,200,200,30);
                p2.setBounds(250,250,200,30);
                p3.setBounds(250,300,200,30);
                p4.setBounds(250,350,200,30);
                p5.setBounds(250,400,200,30);


                b1.setBounds(400,500,100,30);
                b2.setBounds(550,500,100,30);


                b1.addActionListener(this);
                b2.addActionListener(this);
	}


 public void actionPerformed(ActionEvent ae)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
                String s1="";
                String s2="";
                String s3="";
                String s4="";
                String s5="";
                String s6="";
                String s7="";

                String str1=t1.getText();      //Old UserName
                String str2=p1.getText();      //Old Password
		String master_user="system";
		String master_pswd="system";




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

                        if(t1.getText().equals("")||t2.getText().equals("")||(p1.getText().equals(""))||(p2.getText().equals(""))||(p3.getText().equals(""))||(p4.getText().equals(""))||(p5.getText().equals("")))

			{
				flag=true;
			}

			if(flag==true)
			{
			JOptionPane.showMessageDialog(null,"One or more fields left blank!  Please provide all the details", "Airline Reservation System",
                  	JOptionPane.INFORMATION_MESSAGE);
			}

			else
			{

			try
                {
                 st=con.createStatement();

                rs=st.executeQuery("select *from Login");
               if(rs!=null)
                {
                 while(rs.next())
                    {

                      s1=rs.getString(1);       // old UserName from Database
                      s2=rs.getString(2);       // old Passwoed from Database
                     }
                 }
                }
            catch(Exception e1)
               {
               }
                                        s3=t2.getText();     // Naew UserName
                                        s4=p2.getText();     // New Password
                                        s5=p3.getText();
                                        s6=p4.getText();     // Master UserName
                                        s7=p5.getText();     // Master Password
                                        int n1=s4.length();
                                        int n2=s5.length();
          if(n1<=5&&n2<=5)
                {
                    JOptionPane.showMessageDialog(null,"Strength of UserName & Password is weak ! \nPlease provide UserName or Password minimum of 6 character ", "Mobile Shop Maintanance System",
                    JOptionPane.ERROR_MESSAGE);
                
                }
         else
           {
            if((str1.equals(s1))&&(str2.equals(s2))&&(master_user.equals(s6))&&(master_pswd.equals(s7)))
                     {
				try
				{
				   st=con.createStatement();

   st.executeUpdate("update Login set UserName='"+s3+"',Password='"+s4+"'");

                    JOptionPane.showMessageDialog(null,"UserName & Password Updated Successfully", "Mobile Shop Maintanance System",
                    JOptionPane.INFORMATION_MESSAGE);
                                }



			catch(Exception e3)
			{
				System.out.println(e3);
			}
                     }
			else
			{
			        JOptionPane.showMessageDialog(null,"You have entered Invalid old or master UserName & Password", "Mobile Shop Maintanance System",
                        JOptionPane.ERROR_MESSAGE);

			}
		}


               }
             }
           if(ae.getSource()==b2)
             {
               setVisible(false);
             }
            


}
}
