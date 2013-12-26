package InterfaceScore;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauScore extends JPanel {

	private static final long serialVersionUID = 8455710366269867217L;
	private Integer nbJoueurs;
	private String[] tabNomJoueur;
	private int[] tabNbPion;	
	private int[] tabScore;
	
	public PanneauScore() {
		this.nbJoueurs = 0;
		this.setSize(200, 300);
	}

	public void maj(Integer nbJ, String[] tabNomJ, int[] tabNbP, int[] tabS) {
		this.nbJoueurs = new Integer(nbJ);
		tabNomJoueur = tabNomJ;
		tabNbPion = tabNbP;
		tabScore = tabS;
		
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.drawString("Pions", 100, 20);
		g.drawString("Score", 150, 20);
		for (int i = 0; i < nbJoueurs; i++) {
			g.drawString(tabNomJoueur[i], 20, 45+20*i);
			g.drawString(tabNbPion[i]+"", 100, 45+20*i);
			g.drawString(tabScore[i]+"", 150, 45+20*i);
		}
	}
	
	
}
