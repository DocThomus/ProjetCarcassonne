package InterfacePlateau;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import InterfacePioche.ContPioche;
import Noyau.Tuile;

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
	
	private BoutonPion boutonPion01;
	private BoutonPion boutonPion02;
	private BoutonPion boutonPion03;
	private BoutonPion boutonPion10;
	private BoutonPion boutonPion14;
	private BoutonPion boutonPion20;
	private BoutonPion boutonPion22;
	private BoutonPion boutonPion24;
	private BoutonPion boutonPion30;
	private BoutonPion boutonPion34;
	private BoutonPion boutonPion41;
	private BoutonPion boutonPion42;
	private BoutonPion boutonPion43;
	
	private boolean etapePoseTuile;
	private boolean isTuilePoseeDansPlateau;
	private int colTuilePosee;
	private int ligneTuilePosee;
	private boolean[] tabPresenceBoutonPosePion;

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
		
		this.boutonPion01 = new BoutonPion(11);
		this.boutonPion02 = new BoutonPion(12);
		this.boutonPion03 = new BoutonPion(1);
		this.boutonPion10 = new BoutonPion(10);
		this.boutonPion14 = new BoutonPion(2);
		this.boutonPion20 = new BoutonPion(9);
		this.boutonPion22 = new BoutonPion(0);
		this.boutonPion24 = new BoutonPion(3);
		this.boutonPion30 = new BoutonPion(8);
		this.boutonPion34 = new BoutonPion(4);
		this.boutonPion41 = new BoutonPion(7);
		this.boutonPion42 = new BoutonPion(6);
		this.boutonPion43 = new BoutonPion(5);
		
		this.boutonPion01.addActionListener(this);
		this.boutonPion02.addActionListener(this);
		this.boutonPion03.addActionListener(this);
		this.boutonPion10.addActionListener(this);
		this.boutonPion14.addActionListener(this);
		this.boutonPion20.addActionListener(this);
		this.boutonPion22.addActionListener(this);
		this.boutonPion24.addActionListener(this);
		this.boutonPion30.addActionListener(this);
		this.boutonPion34.addActionListener(this);
		this.boutonPion41.addActionListener(this);
		this.boutonPion42.addActionListener(this);
		this.boutonPion43.addActionListener(this);
		
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
		
		Tuile tuilePosee = ContPioche.ControleurPioche.getModele().getTuile();
		
		this.etapePoseTuile = pp.getEtapePoseTuile();
		this.tabtabImages = pp.getTabTabImages();
		this.tabtabCasesLibres = pp.getTabTabCasesLibres();
		this.isTuilePoseeDansPlateau = pp.isTuilePoseeDansPlateau();
		this.colTuilePosee = pp.getColTuilePosee();
		this.ligneTuilePosee = pp.getLigneTuilePosee();
		this.tabPresenceBoutonPosePion = pp.getTabPresenceBoutonPosePion();
		
		this.panPlateau.removeAll();
		this.panPlateau.validate();
		
		for(int ligne = 0; ligne < this.hauteurPlateau; ligne++) {
			for(int col = 0; col < this.largeurPlateau; col++) {
				if (this.isTuilePoseeDansPlateau && (col == this.colTuilePosee) && (ligne == this.ligneTuilePosee)) {
					PanneauTuile panTuilePosee = new PanneauTuile(tabtabImages[ligne][col]);
					panTuilePosee.setMinimumSize(new Dimension(100, 100));
					
					// Bouton pions :
					this.boutonPion01.setTuile(tuilePosee);
					this.boutonPion02.setTuile(tuilePosee);
					this.boutonPion03.setTuile(tuilePosee);
					this.boutonPion10.setTuile(tuilePosee);
					this.boutonPion14.setTuile(tuilePosee);
					this.boutonPion20.setTuile(tuilePosee);
					this.boutonPion22.setTuile(tuilePosee);
					this.boutonPion24.setTuile(tuilePosee);
					this.boutonPion30.setTuile(tuilePosee);
					this.boutonPion34.setTuile(tuilePosee);
					this.boutonPion41.setTuile(tuilePosee);
					this.boutonPion42.setTuile(tuilePosee);
					this.boutonPion43.setTuile(tuilePosee);
					
					this.boutonPion01.setVisible(tabPresenceBoutonPosePion[11]);
					this.boutonPion02.setVisible(tabPresenceBoutonPosePion[12]);
					this.boutonPion03.setVisible(tabPresenceBoutonPosePion[1]);
					this.boutonPion10.setVisible(tabPresenceBoutonPosePion[10]);
					this.boutonPion14.setVisible(tabPresenceBoutonPosePion[2]);
					this.boutonPion20.setVisible(tabPresenceBoutonPosePion[9]);
					this.boutonPion22.setVisible(tabPresenceBoutonPosePion[0]);
					this.boutonPion24.setVisible(tabPresenceBoutonPosePion[3]);
					this.boutonPion30.setVisible(tabPresenceBoutonPosePion[8]);
					this.boutonPion34.setVisible(tabPresenceBoutonPosePion[4]);
					this.boutonPion41.setVisible(tabPresenceBoutonPosePion[7]);
					this.boutonPion42.setVisible(tabPresenceBoutonPosePion[6]);
					this.boutonPion43.setVisible(tabPresenceBoutonPosePion[5]);
					
					panTuilePosee.setLayout(new GridLayout(5, 5, 10, 10)); 
					JPanel panVide00 = new JPanel();
					JPanel panVide01 = new JPanel();
					JPanel panVide03 = new JPanel();
					JPanel panVide04 = new JPanel();
					JPanel panVide10 = new JPanel();
					JPanel panVide11 = new JPanel();
					JPanel panVide12 = new JPanel();
					JPanel panVide13 = new JPanel();
					JPanel panVide14 = new JPanel();
					JPanel panVide21 = new JPanel();
					JPanel panVide23 = new JPanel();
					JPanel panVide30 = new JPanel();
					JPanel panVide31 = new JPanel();
					JPanel panVide32 = new JPanel();
					JPanel panVide33 = new JPanel();
					JPanel panVide34 = new JPanel();
					JPanel panVide40 = new JPanel();
					JPanel panVide41 = new JPanel();
					JPanel panVide43 = new JPanel();
					JPanel panVide44 = new JPanel();
					
					panVide00.setVisible(false);
					panVide01.setVisible(false);
					panVide03.setVisible(false);
					panVide04.setVisible(false);
					panVide10.setVisible(false);
					panVide11.setVisible(false);
					panVide12.setVisible(false);
					panVide13.setVisible(false);
					panVide14.setVisible(false);
					panVide21.setVisible(false);
					panVide23.setVisible(false);
					panVide30.setVisible(false);
					panVide31.setVisible(false);
					panVide32.setVisible(false);
					panVide33.setVisible(false);
					panVide34.setVisible(false);
					panVide40.setVisible(false);
					panVide41.setVisible(false);
					panVide43.setVisible(false);
					panVide44.setVisible(false);
					
					panTuilePosee.add(panVide00);
					panTuilePosee.add(panVide01); // panTuilePosee.add(this.boutonPion01); 
					panTuilePosee.add(this.boutonPion02);
					panTuilePosee.add(panVide03); // panTuilePosee.add(this.boutonPion03);
					panTuilePosee.add(panVide04);
					panTuilePosee.add(panVide10); // panTuilePosee.add(this.boutonPion10);
					panTuilePosee.add(panVide11);
					panTuilePosee.add(panVide12);
					panTuilePosee.add(panVide13);
					panTuilePosee.add(panVide14); // panTuilePosee.add(this.boutonPion14);
					panTuilePosee.add(this.boutonPion20);
					panTuilePosee.add(panVide21);
					panTuilePosee.add(this.boutonPion22);
					panTuilePosee.add(panVide23);
					panTuilePosee.add(this.boutonPion24);
					panTuilePosee.add(panVide30); // panTuilePosee.add(this.boutonPion30);
					panTuilePosee.add(panVide31);
					panTuilePosee.add(panVide32);
					panTuilePosee.add(panVide33);
					panTuilePosee.add(panVide34); // panTuilePosee.add(this.boutonPion34);
					panTuilePosee.add(panVide40);
					panTuilePosee.add(panVide41); // panTuilePosee.add(this.boutonPion41);
					panTuilePosee.add(this.boutonPion42);
					panTuilePosee.add(panVide43); // panTuilePosee.add(this.boutonPion43);
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
						BoutonTuile boutonPoser = new BoutonTuile("Poser", ligne, col);
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
		} else if(e.getSource().getClass() == BoutonTuile.class) {	// Bouton Tuile
			int colPosBouton = ((BoutonTuile) e.getSource()).getCol();
			System.out.println(""+colPosBouton);
			int lignePosBouton = ((BoutonTuile) e.getSource()).getLigne();
			System.out.println(""+lignePosBouton);
			this.controleur.poseTuile(lignePosBouton, colPosBouton);
		} else if(e.getSource().getClass() == BoutonPion.class) {	// Bouton Pion
			int position = ((BoutonPion) e.getSource()).getPosition();
			Tuile tuile = ((BoutonPion) e.getSource()).getTuile();
			System.out.println("Pion : " + position);
			this.controleur.posePion(tuile, position);
		}
	}
}