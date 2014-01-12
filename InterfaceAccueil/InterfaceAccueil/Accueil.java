package InterfaceAccueil;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Principal.ContPrincipal;

public class Accueil {
	
	public Accueil() {
		JFrame fenetre = new JFrame();
		fenetre.setSize(425, 635);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null); //On centre la frame au millieu de l'écran
		
		try {
			Image imageAccueil = ImageIO.read(new File("Image/presentation.jpg"));
			fenetre.add(new JLabel(new ImageIcon(imageAccueil)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		fenetre.setVisible(true);
		
		try {
			Thread.sleep(2500);	// On fait attendre le processus 2,5 secondes
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ContPrincipal.configuration();
		fenetre.dispose();
	}
}
