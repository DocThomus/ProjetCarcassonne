import java.util.ArrayList;

public class Joueur {
	
	private int identifiant; // Identifiant permettant de différencier les joueurs.
	private int score; // Compte courant de score du joueur
	private ArrayList<Pion> tabPions; // Liste des pions actuellements placés sur le plateau par le joueur. (0..7)
	
	public Joueur(int id) {
		this.identifiant = id;
		this.score = 0;
		this.tabPions = null;
	}
	
	public int getIdentifiant() {
		return this.identifiant;
	}
	
	public int comptagePointsFin() { 
		// Action : Compte le score total en fin de partie en ajoutant les points apportés par les points en fin de partie.
		// ToDo : Ajouter les points apportés par les fonctions eval
		return 0;
	}
	
	public int getNbPions() {
		// Remarque : Un joueur peut avoir entre 0 et 7 pions.
		return this.tabPions.size();
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void ajoutPoints(int p) {
		// Pré-requis : p est positif ou nul.
		this.score = this.score + p;
	}
	
	public void retirePion(Pion p) {
		// Pré-requis : une seule occurrence d'un pion dans la liste, et p appartient bien à la liste.
		// Remarque : Possibilité d'utiliser tabPions.contains(p) pour savoir si p appartient vraiment à la liste (normalement oui).
		this.tabPions.remove(p); 
	}
		
}
