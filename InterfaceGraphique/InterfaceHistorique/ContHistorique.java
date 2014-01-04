package InterfaceHistorique;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

public class ContHistorique {
	public static ContHistorique contHistorique;
	private ModHistorique modele;
	private VueHistorique vue;

	public ContHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		modele = new ModHistorique();
		vue = new VueHistorique(fenetrePrincipale, contraintesLayout);
		this.desactiverBoutonPasser();
		modele.addObserver(vue);
		
		// Test 
		modele.ajouterEvenement("Joueur1 pose un tuile en position (0,5).");
		modele.ajouterEvenement("Joueur1 pose un pion en position (0,5).");
		modele.ajouterEvenement("Joueur2 pose une tuile en position (0,6).");
		modele.ajouterEvenement("Joueur3 pose une tuile en position (-1,6).");
		modele.ajouterEvenement("Joueur3 pose un pion en position (-1,6).");
		modele.ajouterEvenement("Joueur4 pose une tuile en position (-1,5).");
		modele.ajouterEvenement("Une ville, située en {(-1,5),(-1,6),(0,5)} est complétée.");
		modele.ajouterEvenement("Joueur1 gagne 6 points.");
		modele.ajouterEvenement("Joueur3 gagne 6 points.");
		modele.ajouterEvenement("Joueur5 pose une tuile en position (-2,6).");
		modele.ajouterEvenement("Joueur5 pose un pion en position (-2,6).");
		modele.ajouterEvenement("Joueur6 pose une tuile en position (1,5).");
		
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
