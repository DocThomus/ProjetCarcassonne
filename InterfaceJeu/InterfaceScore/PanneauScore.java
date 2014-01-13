package InterfaceScore;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Noyau.Joueur;

public class PanneauScore extends JPanel {
	private static final long serialVersionUID = 13L;
	private final static int px[] = {90, 10, 10};
	
	private int nbJoueurs;
	private JLabel[] etiquettesPions;
	private JLabel[] etiquettesScores;
	
	public PanneauScore(int nbJoueurs, String[] nomsJoueurs) {
		this.nbJoueurs = nbJoueurs;
		this.etiquettesPions = new JLabel[nbJoueurs];
		this.etiquettesScores = new JLabel[nbJoueurs];		
		this.setLayout(new GridBagLayout()); // Structure de l'affichage
		GridBagConstraints contraintesLayout = new GridBagConstraints();
		contraintesLayout.fill = GridBagConstraints.BOTH;
		for(int i = 0; i < nbJoueurs+1; i++) {
			for (int j = 0; j < 3; j++) {
				contraintesLayout.gridx = j;
				contraintesLayout.gridy = i;
				contraintesLayout.gridwidth = 1;
				contraintesLayout.gridheight = 1;
				contraintesLayout.weightx = px[j];
				contraintesLayout.weighty = 10;
				
				if (i == 0) { // Entete
					if (j == 0) {
						this.add(new JLabel("  Noms"), contraintesLayout);
					} else if (j == 1) {
						this.add(new JLabel("Pions"), contraintesLayout);
					} else if (j == 2) {
						this.add(new JLabel("Score"), contraintesLayout);
					}
				} else { 
					if (j == 0) {
						JLabel nom = new JLabel("  "+nomsJoueurs[i-1]);
						nom.setForeground(Joueur.getJoueur(i-1).getCouleur());
						this.add(nom, contraintesLayout); // Noms
					} else if (j == 1) {
						this.etiquettesPions[i-1] = new JLabel();
						this.add(this.etiquettesPions[i-1], contraintesLayout); // Pions
					} else if (j == 2) {
						this.etiquettesScores[i-1] = new JLabel();
						this.add(this.etiquettesScores[i-1], contraintesLayout); // Score
					}
				}
			}
		}
	}

	public void maj(int[] tabNbP, int[] tabS) {
		int[] tabNbPion = tabNbP;
		int[] tabScores = tabS;
		
		for (int i = 0; i < this.nbJoueurs; i++) {
			etiquettesPions[i].setText(""+tabNbPion[i]);
			etiquettesScores[i].setText(""+tabScores[i]);
		}
	}
}
