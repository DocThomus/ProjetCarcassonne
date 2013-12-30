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
		Joueur.creerJoueur("aazqsde");
		Joueur.creerJoueur("bazqsdee");
		Joueur.creerJoueur("cqsaed");
		Joueur.creerJoueur("qsqsddqa");
		Joueur.creerJoueur("cqzeaararsd");
		Joueur.creerJoueur("azeaqsd");
		
		System.out.println(Joueur.getNbJoueurs());
		
		contActuel = new ContJeu(vuePrincipale.getFenetrePrincipale(), Joueur.getNbJoueurs(), Joueur.getNomsJoueurs());
	}
}
