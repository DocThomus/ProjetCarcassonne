package Principal;

import InterfaceAccueil.Accueil;
import InterfaceConfiguration.ControleurConfiguration;
import InterfaceJeu.ControleurJeu;
import InterfaceScoreFin.ControleurScoreFin;
import Noyau.Tuile;

public abstract class ContPrincipal {
	
	public static void accueil() { // Interface intro (avec l'image)
		Tuile.ajouteImagesTuiles();
		new Accueil();
	}
		
	public static void configuration() { // Interface de choix des persos
		new ControleurConfiguration();
	}
	
	public static void debutPartie(int nbJoueurs, String[] nomsJoueurs) { // Interface Plateau
		new ControleurJeu(nbJoueurs, nomsJoueurs);
	}
	
	public static void scoreFin() { // Interface de score final
		new ControleurScoreFin();
	}
}
