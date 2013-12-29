package InterfaceJeu;

import javax.swing.JFrame;

import InterfaceScore.ContScore;
import Principal.Controleur;
//import InterfaceHistorique.ContHistorique;
//import InterfacePioche.ContPioche;
//import InterfacePlateau.ContPlateau;

public class ContJeu implements Controleur {
	private ContScore contScore;
	// private ContHistorique contHistorique;
	// private ContPioche contPioche;
	// private ContPlateau contPlateau;
	
	public ContJeu(JFrame fenetrePrincipale) {
		contScore = new ContScore(fenetrePrincipale);
		//contHistorique = new ContHistorique(fenetrePrincipale);
		//contPioche = new ContPioche(fenetrePrincipale);
		//contPlateau = new ContPlateau(fenetrePrincipale);
	}
}
