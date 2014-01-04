package InterfacePlateau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class VuePlateau implements Observer, ActionListener {
	private ContPlateau controleur;
	
	private JButton boutonHaut;
	private JButton boutonDroit;
	private JButton boutonBas;
	private JButton boutonGauche;
	private JPanel panPlateau;				// Contient les images des tuiles et les boutons pour poser.
	//private JPanel panPlateauAvecBoutons;	// Contient panPlateau entouré de 4 boutons grâce à un BorderLayout.
	//private JPanel panPlateauAvecGlues; 	// Contient verticalement : 1 glue, panPlateauAvecBoutons, 1 glue.
	private int largeurPlateau;
	private int hauteurPlateau;
	private Image[][] tabtabImages;
	private boolean[][] tabtabCasesLibres;

	public VuePlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, int largeurPlateau, int hauteurPlateau, ContPlateau controleur) {
		this.largeurPlateau = largeurPlateau;
		this.hauteurPlateau = hauteurPlateau;
		this.controleur = controleur;
		
		
		this.panPlateau = new JPanel();
		this.panPlateau.setLayout(new GridLayout(this.hauteurPlateau, this.largeurPlateau));
		//this.panPlateau.setBackground(Color.pink);
		
		this.boutonHaut = new JButton("Haut");
		this.boutonBas = new JButton("Bas");
		this.boutonDroit = new JButton("Droite");
		this.boutonGauche = new JButton("Gauche");
		
		JPanel panPlateauAvecBoutons = new JPanel();
		BorderLayout layoutAvecBoutons = new BorderLayout();
		panPlateauAvecBoutons.setLayout(layoutAvecBoutons);
		panPlateauAvecBoutons.add(panPlateau, BorderLayout.CENTER);
		panPlateauAvecBoutons.add(boutonHaut, BorderLayout.NORTH);
		boutonHaut.addActionListener(this);
		panPlateauAvecBoutons.add(boutonBas, BorderLayout.SOUTH);
		boutonBas.addActionListener(this);
		panPlateauAvecBoutons.add(boutonDroit, BorderLayout.EAST);
		boutonDroit.addActionListener(this);
		panPlateauAvecBoutons.add(boutonGauche, BorderLayout.WEST);
		boutonGauche.addActionListener(this);

		fenetrePrincipale.getContentPane().add(panPlateauAvecBoutons, contraintesLayout);
		
		/*JPanel panPlateauComplet = new JPanel();
		panPlateauComplet.setLayout(new BoxLayout(panPlateauComplet, BoxLayout.PAGE_AXIS));
		panPlateauComplet.add(Box.createHorizontalGlue());
		panPlateauComplet.add(panPlateauAvecBoutons);
		panPlateauComplet.add(Box.createHorizontalGlue());*/
		
		//fenetrePrincipale.getContentPane().add(panPlateauComplet, contraintesLayout);
	}

	public void update(Observable o, Object arg) {
		PaquetPlateau pp = (PaquetPlateau) arg;
		System.out.println("update ok");
		this.tabtabImages = pp.getTabTabImages();
		this.tabtabCasesLibres = pp.getTabTabCasesLibres();
		this.panPlateau.removeAll();
		this.panPlateau.validate();
		
		for(int ligne = 0; ligne < this.hauteurPlateau; ligne++) {
			for(int col = 0; col < this.largeurPlateau; col++) {
				if(this.tabtabImages[ligne][col] != null) {
					JLabel image = new JLabel(new ImageIcon(tabtabImages[ligne][col]));
					image.setMinimumSize(new Dimension(100, 100));
					this.panPlateau.add(image);
					image.revalidate();
				} else if(this.tabtabCasesLibres[ligne][col] == true) {
					BoutonPlateau boutonPoser = new BoutonPlateau("Poser", ligne, col);
					boutonPoser.setMinimumSize(new Dimension(100, 100));
					this.panPlateau.add(boutonPoser); // On peut créer sa propre classe qui extends JButton, et qui prend en paramètre les coordonnées du bouton sur le plateau.
					boutonPoser.addActionListener(this);
					boutonPoser.revalidate();
				} else {
					JPanel panelVide = new JPanel();
					panelVide.setMinimumSize(new Dimension(100, 100));
					this.panPlateau.add(panelVide);
					panelVide.revalidate();
				}
			}
		}
		this.panPlateau.validate();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== boutonHaut){				// Bouton Haut
			this.controleur.montePlateau();
		} else if(e.getSource()== boutonBas){		// Bouton Bas
			this.controleur.descendPlateau();
		} else if(e.getSource()== boutonGauche){	// Bouton Gauche
			this.controleur.decaleGauche();
		} else if(e.getSource()== boutonDroit){		// Bouton Droit
			this.controleur.decaleDroite();
		} else if(e.getSource().getClass() == BoutonPlateau.class) {	// Bouton Poser
			int colPosBouton = ((BoutonPlateau) e.getSource()).getCol();
			System.out.println(""+colPosBouton);
			int lignePosBouton = ((BoutonPlateau) e.getSource()).getLigne();
			System.out.println(""+lignePosBouton);
			this.controleur.poseTuile(colPosBouton, lignePosBouton);
		}
	}
}