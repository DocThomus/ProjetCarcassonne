package InterfaceScore;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

public class ContScore {
	private static ContScore ControleurScore;
	private ModScore modele;
	private VueScore vue;
	
	
	public ContScore(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, int nbJoueurs, String[] nomsJoueurs) {
		modele = new ModScore();
		vue = new VueScore(fenetrePrincipale, contraintesLayout, nbJoueurs, nomsJoueurs);
		modele.addObserver(vue);
		ContScore.ControleurScore=this;
	}
	
	public static void refresh() {
		ContScore.ControleurScore.modele.refresh();
	}
}
