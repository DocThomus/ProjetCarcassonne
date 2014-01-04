package InterfacePlateau;

import java.awt.BorderLayout;
import java.awt.Color;
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

	public VuePlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, int largeurPlateau, int hauteurPlateau) {
		this.largeurPlateau = largeurPlateau;
		this.hauteurPlateau = hauteurPlateau;
		
		
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
		
		this.tabtabImages = pp.getTabTabImages();
		this.tabtabCasesLibres = pp.getTabTabCasesLibres();
		this.panPlateau.removeAll();
		
		for(int i = 0; i < this.hauteurPlateau; i++) {
			for(int j = 0; j < this.largeurPlateau; j++) {
				if(this.tabtabImages[i][j] != null) {
					this.panPlateau.add(new JLabel(new ImageIcon(tabtabImages[i][j])));
				} else if(this.tabtabCasesLibres[i][j] == true) {
					BoutonPlateau boutonPoser = new BoutonPlateau("Poser", i, j);
					this.panPlateau.add(boutonPoser); // On pet créer sa propre classe qui extends JButton, et qui prend en paramètre les coordonnées du bouton sur le plateau.
					boutonPoser.addActionListener(this);
				} else {
					this.panPlateau.add(new JPanel());
				}
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		
		
	}
}