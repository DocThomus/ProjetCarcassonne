package Noyau;
import java.util.ArrayList;

public class Joueur {
	
	static ArrayList<Joueur> listJoueur= new ArrayList<Joueur>();
	
	private int identifiant; // Identifiant permettant de diff�rencier les joueurs.
	private int score; // Compte courant de score du joueur
	private ArrayList<Pion> tabPions; // Liste des pions actuellements plac�s sur le plateau par le joueur. (0..7)
	
	public Joueur(int id) {
		this.identifiant = id;
		this.score = 0;
		this.tabPions = new ArrayList<Pion>();
		listJoueur.add(this);
	}
	
	public int getIdentifiant() {
		return this.identifiant;
	}
	
	public int comptagePointsFin() { 
		// Action : Compte le score total en fin de partie en ajoutant les points apport�s par les points en fin de partie.
		// ToDo : Ajouter les points apport�s par les fonctions eval
		return 0;
	}
	
	public int getNbPions() {
		// Remarque : Un joueur peut avoir entre 0 et 7 pions.
		return this.tabPions.size();
	}
	
	public ArrayList<Pion> getTabPions(){
		return this.tabPions;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void ajoutPoints(int p) {
		// Pr�-requis : p est positif ou nul.
		// A utiliser avec valeurAbbaye() ou valeurVille() ou valeurRoute()
		this.score = this.score + p;
		System.out.println("joueur : " + this.identifiant);
		System.out.println(" + " + p +" points");
	}
	
	public void retirePion(Pion p) {
		// Pr�-requis : une seule occurrence d'un pion dans la liste, et p appartient bien � la liste.
		// Remarque : Possibilit� d'utiliser tabPions.contains(p) pour savoir si p appartient vraiment � la liste (normalement oui).
		this.tabPions.remove(p); 
	}
		
}
