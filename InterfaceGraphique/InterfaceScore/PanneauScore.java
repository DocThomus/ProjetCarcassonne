package InterfaceScore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauScore extends JPanel {

	private static final long serialVersionUID = 13L;
	
	/*private final int margeHaute = 20;
	private final int margeGauche = 20;
	private final int hauteurEntete = 25;
	private final int interligne = 20;
	private final int largeurNoms = 170;
	private final int largeurNbPions = 50;*/
	public static int x[] =  { 0,  1,  2};
	public static int px[] = {90, 10, 10};
	
	private Integer nbJoueurs;
	private int[] tabNbPion;	
	private int[] tabScores;
	
	private JLabel[] etiquettesPions;
	private JLabel[] etiquettesScores;
	
	public PanneauScore(int nbJoueurs, String[] nomsJoueurs) {
		this.nbJoueurs = nbJoueurs;
		this.etiquettesPions = new JLabel[4];
		this.etiquettesScores = new JLabel[4];
		
		this.setBackground(Color.yellow); // Test
		
		this.setLayout(new GridBagLayout()); // Structure de l'affichage
		GridBagConstraints contraintesLayout = new GridBagConstraints();
		contraintesLayout.fill = GridBagConstraints.BOTH;
		for(int i = 0; i < nbJoueurs+1; i++) {
			for (int j = 0; j < 3; j++) {
				contraintesLayout.gridx = x[j];
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
						this.add(new JLabel("  "+nomsJoueurs[i-1]), contraintesLayout); // Noms
					} else if (j == 1) {
						//this.add(new JLabel(""+tabNbPion[i-1]), contraintesLayout);
						this.etiquettesPions[i-1] = new JLabel();
						this.add(this.etiquettesPions[i-1], contraintesLayout); // Pions
					} else if (j == 2) {
						//this.add(new JLabel(""+tabScore[i-1]), contraintesLayout);
						this.etiquettesScores[i-1] = new JLabel();
						this.add(this.etiquettesScores[i-1], contraintesLayout); // Score
					}
				}
			}
		}
	}

	public void maj(int[] tabNbP, int[] tabS) {
		tabNbPion = tabNbP;
		tabScores = tabS;
		
		for (int i = 0; i < this.nbJoueurs; i++) {
			etiquettesPions[i].setText(""+tabNbPion[i]);
			etiquettesScores[i].setText(""+tabScores[i]);
		}
		
		/*this.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.add(new JLabel(" "));
		this.add(new JLabel("Pions"));
		this.add(new JLabel("Score"));
		for(int i = 0; i < nbJoueurs; i++) {
			this.add(new JLabel(tabNomJoueur[i]));
			this.add(new JLabel(""+tabNbPion[i]));
			this.add(new JLabel(""+tabScore[i]));
		}*/
		
		//this.repaint();
	}
	
	/*public void paintComponent(Graphics g) {
		g.drawString("Pions", largeurNoms, margeHaute);
		g.drawString("Score", largeurNoms+largeurNbPions, margeHaute);
		for (int i = 0; i < nbJoueurs; i++) {
			g.drawString(tabNomJoueur[i], margeGauche, (margeHaute+hauteurEntete)+interligne*i);
			g.drawString(tabNbPion[i]+"", largeurNoms, (margeHaute+hauteurEntete)+interligne*i);
			g.drawString(tabScore[i]+"", largeurNoms+largeurNbPions, (margeHaute+hauteurEntete)+interligne*i);
		}
	}*/
	
	
}
