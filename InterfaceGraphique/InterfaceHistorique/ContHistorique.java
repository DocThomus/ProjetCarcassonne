package InterfaceHistorique;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Joueur;

public class ContHistorique {
	public static final int NB_EVENEMENTS_MAX_AFFICHES = 20;
	public static ContHistorique contHistorique;
	private ModHistorique modele;
	private VueHistorique vue;

	public ContHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		modele = new ModHistorique();
		vue = new VueHistorique(fenetrePrincipale, contraintesLayout, this);
		this.desactiverBoutonPasser();
		modele.addObserver(vue);
		
		modele.ajouterEvenement("Bienvenue sur le Projet Carcassonne !");
		modele.ajouterEvenement("C'est à " + Joueur.getJoueurActif().getNom() + " de commencer.");
		modele.ajouterEvenement("Bonne partie à tous.");
		
		modele.refresh();
		
		ContHistorique.contHistorique = this;
	}
	
	public void ajouterEvenement(String str) {
		this.modele.ajouterEvenement(str);
	}
	
	public void activerBoutonPasser() {
		this.vue.setEtatBoutonPasser(true);
	}
	
	public void desactiverBoutonPasser() {
		this.vue.setEtatBoutonPasser(false);
	}	
}
