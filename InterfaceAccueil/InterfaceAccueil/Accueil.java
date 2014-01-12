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
		fenetre.setSize(300, 300);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			Image imageAccueil = ImageIO.read(new File("Image/imageAccueil.jpg"));
			fenetre.add(new JLabel(new ImageIcon(imageAccueil)));
		} catch (IOException e) {
			System.out.println("image d'accueil introuvable.");
			e.printStackTrace();
		}
		
		fenetre.setVisible(true);
		
		try {
			Thread.sleep(2500);	// On fait attendre le processus 2,5 secondes
		} catch (InterruptedException e) {
			System.out.println("Arrêt pendant le chargement.");
			e.printStackTrace();
		}
		
		ContPrincipal.configuration();
		fenetre.dispose();
	}
}
