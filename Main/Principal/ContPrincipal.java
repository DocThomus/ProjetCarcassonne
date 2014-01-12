package Principal;

import InterfaceAccueil.Accueil;
import InterfaceConfiguration.ControleurConfiguration;
import InterfaceJeu.ControleurJeu;
import InterfaceScoreFin.ControleurScoreFin;
import Noyau.Tuile;

public abstract class ContPrincipal {
	
	public static void introduction() { // Interface intro (avec l'image)
		new Accueil();
	}
		
	public static void configuration() { // Interface de choix des persos
		new ControleurConfiguration();
		System.out.println("config");
	}
	
	public static void debutPartie(int nbJoueurs, String[] nomsJoueurs) { // Interface Plateau
		Tuile.ajouteImagesTuiles();
		new ControleurJeu(nbJoueurs, nomsJoueurs);
	}
	
	public static void finPartie() { // Interface de score final
		new ControleurScoreFin();
	}
}
