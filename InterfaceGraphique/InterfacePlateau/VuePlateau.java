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
	
	private JButton boutonPion01;
	private JButton boutonPion02;
	private JButton boutonPion03;
	private JButton boutonPion10;
	private JButton boutonPion14;
	private JButton boutonPion20;
	private JButton boutonPion22;
	private JButton boutonPion24;
	private JButton boutonPion30;
	private JButton boutonPion34;
	private JButton boutonPion41;
	private JButton boutonPion42;
	private JButton boutonPion43;
	
	private boolean etapePoseTuile;
	private boolean isTuilePoseeDansPlateau;
	private int colTuilePosee;
	private int ligneTuilePosee;

	public VuePlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, int largeurPlateau, int hauteurPlateau, ContPlateau controleur) {
		this.largeurPlateau = largeurPlateau;
		this.hauteurPlateau = hauteurPlateau;
		this.controleur = controleur;
		
		this.etapePoseTuile = true;
		
		this.panPlateau = new JPanel();
		this.panPlateau.setLayout(new GridLayout(this.hauteurPlateau, this.largeurPlateau));
		//this.panPlateau.setBackground(Color.pink);
		
		this.boutonHaut = new JButton("Haut");
		this.boutonBas = new JButton("Bas");
		this.boutonDroit = new JButton("Droite");
		this.boutonGauche = new JButton("Gauche");
		
		this.boutonPion01 = new JButton();
		this.boutonPion02 = new JButton();
		this.boutonPion03 = new JButton();
		this.boutonPion10 = new JButton();
		this.boutonPion14 = new JButton();
		this.boutonPion20 = new JButton();
		this.boutonPion22 = new JButton();
		this.boutonPion24 = new JButton();
		this.boutonPion30 = new JButton();
		this.boutonPion34 = new JButton();
		this.boutonPion41 = new JButton();
		this.boutonPion42 = new JButton();
		this.boutonPion43 = new JButton();
		
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
		
		this.etapePoseTuile = pp.getEtapePoseTuile();
		this.tabtabImages = pp.getTabTabImages();
		this.tabtabCasesLibres = pp.getTabTabCasesLibres();
		this.isTuilePoseeDansPlateau = pp.isTuilePoseeDansPlateau();
		this.colTuilePosee = pp.getColTuilePosee();
		this.ligneTuilePosee = pp.getLigneTuilePosee();
		
		this.panPlateau.removeAll();
		this.panPlateau.validate();
		
		for(int ligne = 0; ligne < this.hauteurPlateau; ligne++) {
			for(int col = 0; col < this.largeurPlateau; col++) {
				if (this.isTuilePoseeDansPlateau && (col == this.colTuilePosee) && (ligne == this.ligneTuilePosee)) {
					PanneauTuilePosee panTuilePosee = new PanneauTuilePosee();
					panTuilePosee.setMinimumSize(new Dimension(100, 100));
					panTuilePosee.setImageFond(tabtabImages[ligne][col]);
					
					// Bouton pions :
					panTuilePosee.setLayout(new GridLayout(5, 5, 10, 10)); 
					JPanel panVide00 = new JPanel();
					JPanel panVide04 = new JPanel();
					JPanel panVide11 = new JPanel();
					JPanel panVide12 = new JPanel();
					JPanel panVide13 = new JPanel();
					JPanel panVide21 = new JPanel();
					JPanel panVide23 = new JPanel();
					JPanel panVide31 = new JPanel();
					JPanel panVide32 = new JPanel();
					JPanel panVide33 = new JPanel();
					JPanel panVide40 = new JPanel();
					JPanel panVide44 = new JPanel();
					
					panVide00.setVisible(false);
					panVide04.setVisible(false);
					panVide11.setVisible(false);
					panVide12.setVisible(false);
					panVide13.setVisible(false);
					panVide21.setVisible(false);
					panVide23.setVisible(false);
					panVide31.setVisible(false);
					panVide32.setVisible(false);
					panVide33.setVisible(false);
					panVide40.setVisible(false);
					panVide44.setVisible(false);
					
					panTuilePosee.add(panVide00);
					panTuilePosee.add(this.boutonPion01);
					panTuilePosee.add(this.boutonPion02);
					panTuilePosee.add(this.boutonPion03);
					panTuilePosee.add(panVide04);
					panTuilePosee.add(this.boutonPion10);
					panTuilePosee.add(panVide11);
					panTuilePosee.add(panVide12);
					panTuilePosee.add(panVide13);
					panTuilePosee.add(this.boutonPion14);
					panTuilePosee.add(this.boutonPion20);
					panTuilePosee.add(panVide21);
					panTuilePosee.add(this.boutonPion22);
					panTuilePosee.add(panVide23);
					panTuilePosee.add(this.boutonPion24);
					panTuilePosee.add(this.boutonPion30);
					panTuilePosee.add(panVide31);
					panTuilePosee.add(panVide32);
					panTuilePosee.add(panVide33);
					panTuilePosee.add(this.boutonPion34);
					panTuilePosee.add(panVide40);
					panTuilePosee.add(this.boutonPion41);
					panTuilePosee.add(this.boutonPion42);
					panTuilePosee.add(this.boutonPion43);
					panTuilePosee.add(panVide44);
					
					this.panPlateau.add(panTuilePosee);
					panTuilePosee.revalidate();
				} else {
					if(this.tabtabImages[ligne][col] != null) {
						JLabel image = new JLabel(new ImageIcon(tabtabImages[ligne][col]));
						image.setMinimumSize(new Dimension(100, 100));
						this.panPlateau.add(image);
						image.revalidate();
					} else if(this.tabtabCasesLibres[ligne][col] == true) {
						BoutonPlateau boutonPoser = new BoutonPlateau("Poser", ligne, col);
						boutonPoser.setEnabled(this.etapePoseTuile);
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