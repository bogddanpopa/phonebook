package phonebook.view;

import java.awt.*;
import javax.swing.*;

public class SplashStart extends JWindow {

	private static final long serialVersionUID = 6631514251702163729L;
	private int duration;
	
  public SplashStart(int d) {
    duration = d;
  }


  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.white);
    content.setOpaque(false);
    setAlwaysOnTop(true);
    setBackground(Color.LIGHT_GRAY);

    int width  = 287;
    int height = 300;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);

    JLabel label = new JLabel(new ImageIcon(getClass().getResource("/img/phonebook.png")));
    
    JLabel nume = new JLabel("Bogdan Popa", JLabel.CENTER);
    nume.setForeground(Color.DARK_GRAY);
    nume.setFont(new Font("Sans-Serif", Font.BOLD, 11));
    content.add(label, BorderLayout.CENTER);
    content.add(nume, BorderLayout.SOUTH);
   
    setVisible(true);

    try { Thread.sleep(duration); } catch (Exception e) {}

    setVisible(false);
    dispose();
  }

}