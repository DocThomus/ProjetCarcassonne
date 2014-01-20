package Noyau;
import java.awt.Color;
import java.util.ArrayList;

public class Joueur {
	
	private static ArrayList<Joueur> listJoueur= new ArrayList<Joueur>();
	private static Joueur joueurActuel;
	private static int numJoueurActuel = 0;
	
	public static ArrayList<Joueur> getListJoueur(){
		return listJoueur;
	}
	
	public static String[] getTabNomsJoueur() {
		int nbJoueurs = getNbJoueurs();
		String[] tabNomsJoueurs = new String[nbJoueurs];
		for(int i = 0; i < nbJoueurs; i++) {
			tabNomsJoueurs[i] = getJoueur(i).getNom();
		}
		return tabNomsJoueurs;
	}		
	
	public static int getNbJoueurs() {
		return listJoueur.size();
	}
	
	public static void creerJoueur(String nom) {
		listJoueur.add(new Joueur(nom));
	}	
	
	public static Joueur getJoueur(int id) {
		return listJoueur.get(id);
	}
	
	public static Joueur getJoueurActif(){
		return Joueur.joueurActuel;
	} 
	
	public static void initialiserJoueurActif() {
		joueurActuel = listJoueur.get(0);
	}
	
	public static void joueurSuivant(){
		numJoueurActuel = (numJoueurActuel+1) % listJoueur.size();
		joueurActuel = listJoueur.get(numJoueurActuel);
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
	private Color couleur;
	private int score; // Compte courant de score du joueur
	private ArrayList<Pion> tabPions; // Liste des pions actuellements placés sur le plateau par le joueur. (0..7)
	
	public Joueur(String n) {
		this.nom = n;
		this.identifiant = listJoueur.size();
		this.setCouleur();
		this.score = 0;
		this.tabPions = new ArrayList<Pion>();
	}
	
	public void setCouleur(){
		if(this.identifiant==0){
			this.couleur=Color.BLUE;
		}
		if(this.identifiant==1){
			this.couleur=Color.RED;
		}
		if(this.identifiant==2){
			this.couleur=Color.MAGENTA;
		}
		if(this.identifiant==3){
			this.couleur=Color.ORANGE;
		}
		if(this.identifiant==4){
			this.couleur=Color.DARK_GRAY;
		}
		if(this.identifiant==5){
			this.couleur=Color.GREEN;
		}
	}
	
	public Color getCouleur(){
		return this.couleur;
	}

	public String getNom() {
		return this.nom;
	}
	
	public int getIdentifiant() {
		return this.identifiant;
	}
		
	public int getNbPions() {
		// Remarque : Un joueur peut avoir entre 0 et 7 pions.
		return 7-this.tabPions.size();
	}
	
	public ArrayList<Pion> getTabPions(){
		return this.tabPions;
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
	
	public boolean nAPlusDePion() {
		return (this.getNbPions() == 0);
	}
}
