import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

class report1 extends Canvas
	{
		public Dimension getParameterSize()
			{
				return new Dimension(1000,1000);
			}

		public void paint(Graphics g)
			{
				int x=80,y=80;

					Connection con=null;
					                Statement st=null;
					               ResultSet rs=null;

							try
							{
					                  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					                  con=DriverManager.getConnection("jdbc:odbc:MY");
					                  st.executeQuery("select ID,C_Name,Address,amount,mobile,model,purchase_date from customer");
					                  rs=st.getResultSet();
					                  ResultSetMetaData rsm=rs.getMetaData();
					                  int numColumn=rsm.getColumnCount();
					                  g.setFont(new Font("Times New Roman",1,34));
					                  g.setColor(Color.red);
					                  g.drawString("Report Number 1",30,30);
					                  g.drawLine(30,40,660,30);
					                  g.setFont(new Font("Times New Roman",1,14));
									  g.setColor(Color.blue);
									  g.drawString("Sr.No",20,80);
									  for(int i=1;i<=numColumn;i++)
										{
											String c=rsm.getColumnName(i);
											g.drawString(c,x,y);
											x+=100;
										}



							}
							catch(Exception e2)
							{
								System.out.println(e2);
							}

			}

	}