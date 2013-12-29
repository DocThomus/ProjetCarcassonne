package InterfaceScore;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

public class ContScore {
	private ModScore modele;
	private VueScore vue;
	
	public ContScore(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		modele = new ModScore();
		vue = new VueScore(fenetrePrincipale, contraintesLayout);
		modele.addObserver(vue);
	}
}
