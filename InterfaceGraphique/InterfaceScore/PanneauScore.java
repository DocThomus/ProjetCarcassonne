package InterfaceScore;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauScore extends JPanel {

	private static final long serialVersionUID = 13L;
	
	private final int margeHaute = 20;
	private final int margeGauche = 20;
	private final int hauteurEntete = 25;
	private final int interligne = 20;
	private final int largeurNoms = 100;
	private final int largeurNbPions = 50;
	
	private Integer nbJoueurs;
	private String[] tabNomJoueur;
	private int[] tabNbPion;	
	private int[] tabScore;
	
	public PanneauScore() {
		this.nbJoueurs = 0;
		//this.setSize(200, 300);
		this.setBackground(Color.yellow);
	}

	public void maj(Integer nbJ, String[] tabNomJ, int[] tabNbP, int[] tabS) {
		this.nbJoueurs = new Integer(nbJ);
		tabNomJoueur = tabNomJ;
		tabNbPion = tabNbP;
		tabScore = tabS;
		
		this.repaint();
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
