import java.awt.event.*;

public class Exit extends WindowAdapter
 {
  public void windowClosing(WindowEvent event) 
  {
    System.exit(0);
  }

}