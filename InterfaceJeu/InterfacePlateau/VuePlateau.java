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

import javax.swing.JButton;
import javax.swing.JFrame;
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
	private int largeurPlateau;
	private int hauteurPlateau;
	private Image[][] tabtabImages;
	private boolean[][] tabtabCasesLibres;
	private boolean[][] tabtabPresencePion;
	private int[][] tabtabPositionPion;
	private Color[][] tabtabCouleurPion;
	
	private BoutonPosePion tabBoutonPosePion[];
	
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
		
		this.boutonHaut = new JButton("Haut");
		this.boutonBas = new JButton("Bas");
		this.boutonDroit = new JButton("Droite");
		this.boutonGauche = new JButton("Gauche");
		
		this.tabBoutonPosePion = new BoutonPosePion[13];
		
		for(int i = 0; i < 13; i++) {
			this.tabBoutonPosePion[i] = new BoutonPosePion(i, this);
		}
		
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
	}

	public void update(Observable o, Object arg) {
		PaquetPlateau pp = (PaquetPlateau) arg;
		
		this.etapePoseTuile = pp.getEtapePoseTuile();
		this.tabtabImages = pp.getTabTabImages();
		this.tabtabCasesLibres = pp.getTabTabCasesLibres();
		this.isTuilePoseeDansPlateau = pp.isTuilePoseeDansPlateau();
		this.colTuilePosee = pp.getColTuilePosee();
		this.ligneTuilePosee = pp.getLigneTuilePosee();
		this.tabPresenceBoutonPosePion = pp.getTabPresenceBoutonPosePion();
		this.tabtabPresencePion = pp.getTabTabPresencePion();
		this.tabtabPositionPion = pp.getTabTabPositionPion();
		this.tabtabCouleurPion = pp.getTabTabCouleurPion();
		
		this.panPlateau.removeAll();
		this.panPlateau.validate();
		
		for(int ligne = 0; ligne < this.hauteurPlateau; ligne++) {
			for(int col = 0; col < this.largeurPlateau; col++) {
				if (this.isTuilePoseeDansPlateau && (col == this.colTuilePosee) && (ligne == this.ligneTuilePosee)) {
					PanneauTuile panTuilePosee = new PanneauTuile(tabtabImages[ligne][col]);
					
					for(int i = 0; i < 13; i++) {
						this.tabBoutonPosePion[i].setVisible(tabPresenceBoutonPosePion[i]);
					}
					panTuilePosee.setBoutonsPosePion(this.tabBoutonPosePion, tabPresenceBoutonPosePion);			
					
					this.panPlateau.add(panTuilePosee);
					panTuilePosee.revalidate();
				} else {
					if(this.tabtabImages[ligne][col] != null) {
						PanneauTuile panTuile = new PanneauTuile(tabtabImages[ligne][col]);
						if(tabtabPresencePion[ligne][col]) {
							panTuile.setPion(tabtabPresencePion[ligne][col], tabtabPositionPion[ligne][col], tabtabCouleurPion[ligne][col]);
						}
						this.panPlateau.add(panTuile);
						panTuile.revalidate();
					} else if(this.tabtabCasesLibres[ligne][col] == true) {
						BoutonPoseTuile boutonPoser = new BoutonPoseTuile("Poser", ligne, col);
						boutonPoser.setEnabled(this.etapePoseTuile);
						boutonPoser.setMinimumSize(new Dimension(100, 100));
						this.panPlateau.add(boutonPoser); // On peut créer sa propre classe qui extends JButton, et qui prend en paramètre les coordonnées du bouton sur le plateau.
						boutonPoser.addActionListener(this);
						boutonPoser.revalidate();
					} else {
						JPanel panelVide = new JPanel();
						panelVide.setMinimumSize(new Dimension(100, 100));
						panelVide.setBackground(new Color(204, 153, 102));
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
		} else if(e.getSource().getClass() == BoutonPoseTuile.class) {	// Bouton Tuile
			int colPosBouton = ((BoutonPoseTuile) e.getSource()).getCol();
			int lignePosBouton = ((BoutonPoseTuile) e.getSource()).getLigne();
			this.controleur.poseTuile(lignePosBouton, colPosBouton);
		} else if(e.getSource().getClass() == BoutonPosePion.class) {	// Bouton Pion
			int position = ((BoutonPosePion) e.getSource()).getPosition();
			Tuile tuilePosee = ContPioche.getTuile();
			this.controleur.posePion(tuilePosee, position);
		}
	}
}