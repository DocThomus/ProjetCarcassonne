package InterfaceScore;

import javax.swing.JFrame;

public class ContScore {
	private ModScore modele;
	private VueScore vue;
	
	public ContScore(JFrame fenetrePrincipale) {
		modele = new ModScore();
		vue = new VueScore(fenetrePrincipale);
		modele.addObserver(vue);
	}
}
