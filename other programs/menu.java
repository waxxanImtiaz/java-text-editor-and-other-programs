import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;


class menu extends JPanel implements ActionListener
  { JMenuBar mb;
    JLabel l1;
    JMenu m1,m2,m3,m4,m5;
    JMenuItem m11,m12,m13,m21,m22,m23,m31,m32,m33,m41,m42,m43,m51,m52,m53;
    BufferedImage i1,i2;

    menu(BufferedImage i1,BufferedImage i2)
     {
        this.i1=i1;
        this.i2=i2;

        setLayout(null);


        mb=new JMenuBar();
        mb.setBounds(0,0,1400,25);
        add(mb);

        m1=new JMenu(" NEW ENTRY ");
        m2=new JMenu("EDIT");
        m3=new JMenu("VIEW");
        m4=new JMenu("Extra");
        m5=new JMenu("Login");

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);


        m1.add(m11=new JMenuItem("Mobile "));
        m1.add(m12=new JMenuItem("Customer "));

        m2.add(m21=new JMenuItem("Delete"));
        m2.add(m22=new JMenuItem("Update"));
        m2.add(m23=new JMenuItem("Update Customer"));

        m3.add(m31=new JMenuItem("Customer Detail"));
        m3.add(m32=new JMenuItem("Sets in shop"));
        m3.add(m33=new JMenuItem("Features wise"));

		m4.add(m41=new JMenuItem("Accessories"));
		m4.add(m42=new JMenuItem("Calculator"));
		m4.add(m43=new JMenuItem("Help"));


        m5.add(m51=new JMenuItem("Log Out"));
        m5.add(m52=new JMenuItem("Exit"));
        m5.add(m53=new JMenuItem("Change Password"));


        m11.addActionListener(this);
        m12.addActionListener(this);

        m21.addActionListener(this);
        m22.addActionListener(this);
        m23.addActionListener(this);

		m31.addActionListener(this);
		m32.addActionListener(this);

        m42.addActionListener(this);
		m43.addActionListener(this);

        m51.addActionListener(this);
        m52.addActionListener(this);
        m53.addActionListener(this);


     }

public void paintComponent(Graphics g)
    {
        g.drawImage(i2, 0, 0, this);

        g.drawImage(i1, 500, 30, this);

    }



        public void actionPerformed(ActionEvent e)
          {
             if(e.getSource()==m11)
               {
                 try
                  {
                   JFrame f=new JFrame("******* Mobile Entry Form *******");

                   i2= ImageIO.read(new File("E:/coding/4.jpg"));

                   mobile o=new mobile(i2);

                   f.add(o);

                   f.setSize(1400,900);

                   f.show();
                  }

                 catch(Exception e3)
                   {  System.out.println(e3);
                   }


               }

             if(e.getSource()==m12)
               {
                 try
                  {
                   JFrame f=new JFrame("******* Customer Entry Form *******");

                   i1= ImageIO.read(new File("E:/coding/5.jpg"));

                   customer o1=new customer(i1);


                   f.add(o1);

                   f.setSize(1400,900);

                   f.show();
                  }

                 catch(Exception e3)
                   {  System.out.println(e3);
                   }


               }

             if(e.getSource()==m21)
               {
                 try
                  {
                   JFrame f=new JFrame("******* Updation Form *******");

                   i1= ImageIO.read(new File("E:/coding/4.jpg"));

                   delete o1=new delete(i1);

                   f.add(o1);

                   f.setSize(1400,900);

                   f.show();
                  }

                 catch(Exception e3)
                   {  System.out.println(e3);
                   }


               }

             if(e.getSource()==m22)
               {
                 try
                  {
                   JFrame f=new JFrame("******* Updation Form *******");

                   i1= ImageIO.read(new File("E:/coding/5.jpg"));

                   update o1=new update(i1);

                   f.add(o1);

                   f.setSize(1400,900);

                   f.show();
                  }

                 catch(Exception e3)
                   {  System.out.println(e3);
                   }



               }

             if(e.getSource()==m23)
               {

                 try
                  {
                   JFrame f=new JFrame("******* Updation Form *******");

                   i1= ImageIO.read(new File("E:/coding/5.jpg"));

                   update1 o2=new update1(i1);

                   f.add(o2);

                   f.setSize(1400,900);

                   f.show();
                  }

                 catch(Exception e3)
                   {  System.out.println(e3);
                   }

               }
			  if(e.getSource()==m31)
			               { order o=new order();
					   }

			  if(e.getSource()==m32)
			               { store_report o=new store_report();
					   }

             if(e.getSource()==m42)
               {

                 calculator o=new calculator();
               }

             if(e.getSource()==m43)
               {
				JOptionPane.showMessageDialog(null,"For any kind of Help please Contact me @ 9897848848 & parashari23@rediffmail.com", "Mobile Shop Maintanance System",
                  	JOptionPane.INFORMATION_MESSAGE);

               }


             if(e.getSource()==m51)
               {
					  setVisible(false);
                 login o=new login(i2);



               }

             if(e.getSource()==m52)
               { System.exit(0);
               }

             if(e.getSource()==m53)
               {
                  Change_Pswd o=new Change_Pswd();
               }

          }

    }





