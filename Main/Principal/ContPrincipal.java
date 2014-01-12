package Principal;

import InterfaceAccueil.Accueil;
import InterfaceJeu.ContJeu;
import Noyau.Joueur;

public abstract class ContPrincipal {
	public static final int LARGEUR_FENETRE = 1280;
	public static final int HAUTEUR_FENETRE = 720;
	
	private VuePrincipale vuePrincipale;
	private Controleur contActuel;
	
	public static void introduction() { // Interface intro (avec l'image)
		new Accueil();
	}
		
	public static void configuration() { // Interface de choix des persos
		new 
	}
	
	public static void debutPartie() { // Interface Plateau
		//TODO
	}
	
	public static void finPartie() { // Interface de score final
		//TODO
	}
}
