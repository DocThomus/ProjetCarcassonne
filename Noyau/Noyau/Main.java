package Noyau;

import Principal.ContPrincipal;

public class Main {
	public static void main(String[] args) {
		Tuile.ajouteImagesTuiles();
		ContPrincipal c = new ContPrincipal();
		System.out.println("id :" + Joueur.getJoueurActif().getIdentifiant());
		Joueur.joueurSuivant();
		System.out.println("id :" + Joueur.getJoueurActif().getIdentifiant());
		Joueur.joueurSuivant();
		System.out.println("id :" + Joueur.getJoueurActif().getIdentifiant());
		Joueur.joueurSuivant();
	}
}
