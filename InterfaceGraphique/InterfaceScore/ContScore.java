package InterfaceScore;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

public class ContScore {
	private ModScore modele;
	private VueScore vue;
	
	public ContScore(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, int nbJoueurs, String[] nomsJoueurs) {
		modele = new ModScore();
		vue = new VueScore(fenetrePrincipale, contraintesLayout, nbJoueurs, nomsJoueurs);
		modele.addObserver(vue);
	}
	
	public void refresh() {
		modele.refresh();
	}
}
