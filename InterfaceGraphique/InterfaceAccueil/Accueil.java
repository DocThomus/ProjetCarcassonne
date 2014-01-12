package InterfaceAccueil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Accueil extends JPanel {
	private static final long serialVersionUID = 8012493901397795711L;
	JLabel image;
	static JFrame cadre;
	ImageIcon icone;
	static BGFrame bg;
	static Thread t;
	
	public Accueil() {
		JFrame fenetre = new JFrame();
		fenetre.setSize(300, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		
		//cadre = new JFrame();
		
		
		 // ImageIcon i = new ImageIcon();
		//  ImageIcon icone = new ImageIcon("image/index.jpg");
		 // JLabel image = new JLabel(icone);
		
		 /*t = new Thread(); 
		
		  bg = new BGFrame(); //on crée une nouvelle frame
		  bg.setBackground("Image/index.jpg"); //on met l'image en fond de frame
		  bg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  bg.setSize(300, 300);
		  bg.setLocationRelativeTo(null); //On centre la frame au millieu de l'écran
		  bg.setVisible(true);
		  try {
			t.sleep(10000); //on fait rester la page quelques secondes avant de l'enlever
			bg.setVisible(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		  
		  
		 //cadre.getContentPane().add(image);
		// cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// cadre.setSize(300, 300);
		// cadre.setVisible(true);
	}
	
	/*public void paintComponent(Graphics g){
		Image I = new ImageIcon("index.jpg").getImage();
		g.drawImage(I,3,4,this);
	}*/
	
	

}
