import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class store_report extends JFrame implements ActionListener
	{
		JMenuBar mb;
		JMenu m;
		JMenuItem i1,i2;
		ScrollPane s;
		TextPanel_1 t1;
		Toolkit tool;
		PrintJob pj;

                public store_report()
		{
			super("REPORT of Mobile Store");
			//Container ct=getContentPane();

			mb=new JMenuBar();
			m=new JMenu("File");
			i1=new JMenuItem("Print");
			i2=new JMenuItem("Exit");
			m.add(i1);
			m.add(i2);
			mb.add(m);
			tool=getToolkit();
			setJMenuBar(mb);

			i1.addActionListener(this);
			i2.addActionListener(this);

			s=new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
			t1=new TextPanel_1();
			s.add(t1);
			add(s);
			setSize(1400,700);
			setVisible(true);


		}

	public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==i1)
				{
					Properties prop=new Properties();
                                        pj=tool.getPrintJob(store_report.this,"Hello",prop);
				}
                        if(e.getSource()==i2)
				{ setVisible(false);
				}
		}

	public static void main(String args[])
		{
			store_report o=new store_report();

		}
	}







class TextPanel_1 extends Canvas
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
                                 st=con.createStatement();
                                 st.executeQuery("select * from store");
                                 rs=st.getResultSet();
                                 ResultSetMetaData rsm=rs.getMetaData();

                                 int numColumn=rsm.getColumnCount();
                                 g.setFont(new Font("Times New Roman",1,34));
                                 g.setColor(Color.red);
                                 g.drawString("Report of mobiles in Shop",30,30);
                                 g.drawLine(10,40,1460,40);
                                 g.setFont(new Font("Times New Roman",1,14));
                                 g.setColor(Color.blue);
                                 g.drawString("Sr.No",20,80);

                                 for(int i=1;i<=numColumn;i++)
                                   {
                                      String c=rsm.getColumnName(i);
                                      g.drawString(c,x,y);
                                      x+=100;
										}
                                      int n=1;
                                     g.setColor(Color.black);
                                     while(rs.next())
                                       {
                                           x=90;
                                           y+=22;
                                           g.drawString(n+".",25,y);
                                           n++;

                                        for(int i=1;i<=numColumn;++i)
                                          {
                                          String s=rs.getString(i);
                                          g.drawString(s,x,y);
                                          x+=100;
                                          }
										}

                                     }
                                    catch(Exception e2)
                                       {
                                    System.out.println("Hello"+e2);
                                       }
                       	}

     }
