package Principal;

import InterfaceInitialisation.ControleurPage2;
import InterfaceJeu.ContJeu;
import Noyau.Joueur;

public class ContPrincipal {
	public static final int LARGEUR_FENETRE = 1280;
	public static final int HAUTEUR_FENETRE = 720;
	private static ContPrincipal contPrincipal;
	
	private VuePrincipale vuePrincipale;
	private Controleur contActuel;
	private boolean etapeInitialisation=false;
	
	public ContPrincipal() {
		contPrincipal = this;
		
		ControleurPage2 cont = new ControleurPage2();
		
		//vuePrincipale = new VuePrincipale();
		
		// Temporaire, pour tester l'interface graphique Jeu.
		/*Joueur.creerJoueur("Joueur1");
		Joueur.creerJoueur("Joueur2");
		Joueur.creerJoueur("Joueur3");
		Joueur.creerJoueur("Joueur4");
		Joueur.creerJoueur("Joueur5");
		Joueur.creerJoueur("Joueur6");
		Joueur.initialiserJoueurActif();*/
				
		//contActuel = new ContJeu(vuePrincipale.getFenetrePrincipale(), Joueur.getNbJoueurs(), Joueur.getNomsJoueurs());
	}
	
	public static void introduction() { // Interface intro (avec l'image)
		
	}
		
	public static void configuration() { // Interface de choix des persos
		
	}
	
	public static void debutPartie() { // Interface Plateau
		ContPrincipal.contPrincipal.vuePrincipale = new VuePrincipale();
		ContPrincipal.contPrincipal.contActuel = new ContJeu(ContPrincipal.contPrincipal.vuePrincipale.getFenetrePrincipale(), Joueur.getNbJoueurs(), Joueur.getNomsJoueurs());
	}
	
	public static void finPartie() { // Interface de score final
		//TODO
	}
}
