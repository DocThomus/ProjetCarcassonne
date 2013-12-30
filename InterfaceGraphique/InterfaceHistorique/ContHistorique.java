package InterfaceHistorique;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

public class ContHistorique {
	private ModHistorique modele;
	private VueHistorique vue;

	public ContHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		modele = new ModHistorique();
		vue = new VueHistorique(fenetrePrincipale, contraintesLayout);
		modele.addObserver(vue);
		
		// Test 
		modele.ajouterEvenement("0 Joueur1 pose un tuile en position (0,5).");
		modele.ajouterEvenement("1 Joueur1 pose un pion en position (0,5).");
		modele.ajouterEvenement("2 Joueur2 pose une tuile en position (0,6).");
		modele.ajouterEvenement("3 Joueur3 pose une tuile en position (-1,6).");
		modele.ajouterEvenement("4 Joueur3 pose un pion en position (-1,6).");
		modele.ajouterEvenement("5 Joueur4 pose une tuile en position (-1,5).");
		modele.ajouterEvenement("6 Une ville, située en {(-1,5),(-1,6),(0,5)} est complétée.");
		modele.ajouterEvenement("7 Joueur1 gagne 6 points.");
		modele.ajouterEvenement("8 Joueur3 gagne 6 points.");
		modele.ajouterEvenement("9 Joueur5 pose une tuile en position (-2,6).");
		modele.ajouterEvenement("10 Joueur5 pose un pion en position (-2,6).");
		modele.ajouterEvenement("11 Joueur6 pose une tuile en position (1,5).");
		
		modele.refresh();
	}
}
