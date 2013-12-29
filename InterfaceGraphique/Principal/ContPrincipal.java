package Principal;

import InterfaceJeu.ContJeu;

public class ContPrincipal {
	public static final int LARGEUR_FENETRE = 1280;
	public static final int HAUTEUR_FENETRE = 720;
	
	private VuePrincipale vuePrincipale;
	private Controleur contActuel;
	
	public ContPrincipal() {
		vuePrincipale = new VuePrincipale();
		
		String[] nomsJoueurs = {"a","b","c","d"};
		contActuel = new ContJeu(vuePrincipale.getFenetrePrincipale(), 4, nomsJoueurs); // Temporaire, pour tester l'interface graphique Jeu.
	}
	
	public static void main(String[] args) {
		ContPrincipal c = new ContPrincipal();
		
	}
}
