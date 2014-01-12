package InterfaceHistorique;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Joueur;

public class ContHistorique {
	public static final int NB_EVENEMENTS_MAX_AFFICHES = 20;
	private static ContHistorique contHistorique;
	private ModHistorique modele;
	private VueHistorique vue;

	public ContHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		ContHistorique.contHistorique = this;
		modele = new ModHistorique();
		vue = new VueHistorique(fenetrePrincipale, contraintesLayout);
		desactiverBoutonPasser();
		modele.addObserver(vue);
		
		modele.ajouterEvenement("Bienvenue sur le Projet Carcassonne !");
		modele.ajouterEvenement("Bonne partie à tous.");
		modele.ajouterEvenement("C'est à " + Joueur.getJoueurActif().getNom() + " de commencer.");
		
		modele.refresh();
	}
	
	public static void ajouterEvenement(String str) {
		contHistorique.modele.ajouterEvenement(str);
	}
	
	public static void activerBoutonPasser() {
		contHistorique.vue.setEtatBoutonPasser(true);
	}
	
	public static void desactiverBoutonPasser() {
		contHistorique.vue.setEtatBoutonPasser(false);
	}	
}
