package InterfaceAccueil;
import java.awt.event.*;
    import javax.swing.*;
    import java.awt.*;
    
    public class BGFrame extends JFrame
    {
    Image image;
    JScrollPane scrollPane;
    public void setBackground(String src)
    {
     image = new ImageIcon(src).getImage();
     JPanel panel = new JPanel()
     {
      protected void paintComponent(Graphics g)
      {
       Dimension d = getSize(); //capture les dimensions de la fenetre
       g.drawImage(image, 0, 0, d.width, d.height, null); //dessine l'image aux dimensions de la fenetre
       super.paintComponent(g); //peint la fenetre avec ce qu'on a choisi
      }
     };
     panel.setOpaque(false);
     super.getContentPane().add(panel);
    }
    }