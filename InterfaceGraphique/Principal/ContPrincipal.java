package Principal;

import InterfaceJeu.ContJeu;
import Noyau.Joueur;

public class ContPrincipal {
	public static final int LARGEUR_FENETRE = 1280;
	public static final int HAUTEUR_FENETRE = 720;
	
	private VuePrincipale vuePrincipale;
	private Controleur contActuel;
	
	public ContPrincipal() {
		vuePrincipale = new VuePrincipale();
		
		// Temporaire, pour tester l'interface graphique Jeu.
		Joueur.creerJoueur("Joueur1");
		Joueur.creerJoueur("Joueur2");
		Joueur.creerJoueur("Joueur3");
		Joueur.creerJoueur("Joueur4");
		Joueur.creerJoueur("Joueur5");
		Joueur.creerJoueur("Joueur6");
		Joueur.initialiserJoueurActif();
		
		System.out.println("test joueurs :");
		System.out.println(Joueur.getJoueur(0).getNom());
		System.out.println(Joueur.getJoueur(1).getNom());
		System.out.println(Joueur.getJoueur(2).getNom());
		System.out.println(Joueur.getJoueur(3).getNom());
		System.out.println(Joueur.getJoueur(4).getNom());
		System.out.println(Joueur.getJoueur(5).getNom());
		
		
		contActuel = new ContJeu(vuePrincipale.getFenetrePrincipale(), Joueur.getNbJoueurs(), Joueur.getNomsJoueurs());
	}
}
