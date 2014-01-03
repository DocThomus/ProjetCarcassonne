package InterfacePlateau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePlateau implements Observer {
	private JButton boutonHaut;
	private JButton boutonDroite;
	private JButton boutonBas;
	private JButton boutonGauche;
	private JPanel panPlateau;				// Contient les images des tuiles et les boutons pour poser.
	private JPanel panPlateauAvecBoutons;	// Contient panPlateau entouré de 4 boutons grâce à un BorderLayout.
	private JPanel panPlateauAvecGlues; 	// Contient verticalement : 1 glue, panPlateauAvecBoutons, 1 glue.
	private int largeurPlateau;
	private int hauteurPlateau;
	private Image[][] tabtabImages;
	private boolean[][] tabtabCasesLibres;

	public VuePlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, int largeurPlateau, int hauteurPlateau) {
		this.largeurPlateau = largeurPlateau;
		this.hauteurPlateau = hauteurPlateau;
		
		
		this.panPlateau = new JPanel();
		this.panPlateau.setLayout(new GridLayout(this.hauteurPlateau, this.largeurPlateau));
		//this.panPlateau.setBackground(Color.pink);
		
		this.boutonHaut = new JButton("Haut");
		this.boutonBas = new JButton("Bas");
		this.boutonDroite = new JButton("Droite");
		this.boutonGauche = new JButton("Gauche");
		
		this.panPlateauAvecBoutons = new JPanel();
		this.panPlateauAvecBoutons.setLayout(new BorderLayout());
		this.panPlateauAvecBoutons.add(panPlateau, BorderLayout.CENTER);
		this.panPlateauAvecBoutons.add(boutonHaut, BorderLayout.NORTH);
		this.panPlateauAvecBoutons.add(boutonBas, BorderLayout.SOUTH);
		this.panPlateauAvecBoutons.add(boutonDroite, BorderLayout.EAST);
		this.panPlateauAvecBoutons.add(boutonGauche, BorderLayout.WEST);
		
		
		this.panPlateauAvecGlues = new JPanel();
		this.panPlateauAvecGlues.setLayout(new BoxLayout(panPlateauAvecGlues, BoxLayout.Y_AXIS));
		//this.panPlateauAvecGlues.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		this.panPlateauAvecGlues.add(Box.createGlue());
		this.panPlateauAvecGlues.add(this.panPlateauAvecBoutons);
		this.panPlateauAvecGlues.add(Box.createGlue());
		this.panPlateauAvecGlues.revalidate();
		this.panPlateauAvecGlues.repaint();
		
		
		fenetrePrincipale.getContentPane().add(this.panPlateauAvecGlues, contraintesLayout);
	}

	public void update(Observable o, Object arg) {
		PaquetPlateau pp = (PaquetPlateau) arg;
		
		this.tabtabImages = pp.getTabTabImages();
		this.tabtabCasesLibres = pp.getTabTabCasesLibres();
		this.panPlateau.removeAll();
		
		for(int i = 0; i < this.hauteurPlateau; i++) {
			for(int j = 0; j < this.largeurPlateau; j++) {
				if(this.tabtabImages[i][j] != null) {
					this.panPlateau.add(new JLabel(new ImageIcon(tabtabImages[i][j])));
				} else if(this.tabtabCasesLibres[i][j] == true) {
					this.panPlateau.add(new JButton("Poser")); // On pet créer sa propre classe qui extends JButton, et qui prend en paramètre les coordonnées du bouton sur le plateau.
				} else {
					this.panPlateau.add(new JPanel());
				}
			}
		}
	}
}
