package Noyau;
import java.util.ArrayList;

public class Joueur {
	
	private static ArrayList<Joueur> listJoueur= new ArrayList<Joueur>();
	
	public static int getNbJoueurs() {
		return listJoueur.size();
	}
	
	public static void creerJoueur(String nom) {
		listJoueur.add(new Joueur(nom));
	}	
	
	public static Joueur getJoueur(int id) {
		return listJoueur.get(id);
	}
	
	public static String[] getNomsJoueurs() {
		int nbJoueurs = getNbJoueurs();
		String[] noms = new String[getNbJoueurs()];
		
		for (int i = 0; i < nbJoueurs; i++) {
			noms[i] = getJoueur(i).getNom();
		}
		
		return noms;
	}
		
	private String nom; // Nom du joueur (en rapport avec l'interface)
	private int identifiant; // Identifiant permettant de différencier les joueurs. l'id est la position dans l'arrayList listJoueur.
	private int score; // Compte courant de score du joueur
	private ArrayList<Pion> tabPions; // Liste des pions actuellements placés sur le plateau par le joueur. (0..7)
	
	public Joueur(String n) {
		this.nom = n;
		this.identifiant = listJoueur.size();
		this.score = 0;
		this.tabPions = new ArrayList<Pion>();
	}

	public String getNom() {
		return this.nom;
	}
	
	public int getIdentifiant() {
		return this.identifiant;
	}
	
	public int comptagePointsFin() { 
		// Action : Compte le score total en fin de partie en ajoutant les points apportés par les points en fin de partie.
		// TODO : Ajouter les points apportés par les fonctions eval
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
		// Pré-requis : p est positif ou nul.
		// TODO A utiliser avec valeurAbbaye() ou valeurVille() ou valeurRoute()
		this.score = this.score + p;
		System.out.println("joueur : " + this.identifiant);
		System.out.println(" + " + p +" points");
	}
	
	public void retirePion(Pion p) {
		// Pré-requis : une seule occurrence d'un pion dans la liste, et p appartient bien à la liste.
		// Remarque : Possibilité d'utiliser tabPions.contains(p) pour savoir si p appartient vraiment à la liste (normalement oui).
		this.tabPions.remove(p); 
	}		
}
