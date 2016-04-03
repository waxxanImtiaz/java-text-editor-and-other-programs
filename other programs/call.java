import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;

class call extends JFrame
  { public static void main(String[] args) throws IOException
    {
    	JFrame f=new JFrame("******* Welcome to Mobile Information System *******");

        BufferedImage image1 =ImageIO.read(new File("E:/coding/img1.jpg"));

        login ip = new login(image1);
       // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(ip);
        f.setSize(600,450);
        f.setBackground(Color.orange);
        f.show();
    }
  }
