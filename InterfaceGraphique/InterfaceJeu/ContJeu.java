package InterfaceJeu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;


import Noyau.Joueur;
import Noyau.Plateau;
import Principal.Controleur;
import InterfacePioche.ContPioche;
import InterfaceScore.ContScore;
import InterfaceHistorique.ContHistorique;
import InterfacePlateau.ContPlateau;

public class ContJeu implements Controleur {	
	
	public static int nbElements = 4;
	public static int x[] = 	{ 0,  0,  1,  7};
	public static int y[] = 	{ 0,  2,  0,  0};
	public static int larg[] = 	{ 1,  1,  6,  3};
	public static int haut[] =  { 3,  8,  8, 10};
	public static int px[] = 	{10,  0,  0, 70};
	public static int py[] = 	{ 0,100,  0,  0};
	
	private ContScore contScore;
	private ContHistorique contHistorique;
	private ContPioche contPioche;
	private ContPlateau contPlateau;
	
	public ContJeu(JFrame fenetrePrincipale, int nbJoueurs, String[] nomsJoueurs) {
		Plateau plateau = new Plateau();
		
		fenetrePrincipale.getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints contraintesLayout = new GridBagConstraints();
		contraintesLayout.fill = GridBagConstraints.BOTH;
		for (int i = 0; i < nbElements; i++) {
			contraintesLayout.gridx = x[i];
			contraintesLayout.gridy = y[i];
			contraintesLayout.gridwidth = larg[i];
			contraintesLayout.gridheight = haut[i];
			contraintesLayout.weightx = px[i];
			contraintesLayout.weighty = py[i];
			if (i == 0) {
				contScore = new ContScore(fenetrePrincipale, contraintesLayout, nbJoueurs, nomsJoueurs);
			} else if(i == 1) {
				contPioche = new ContPioche(fenetrePrincipale, contraintesLayout, plateau);				
			} else if(i == 2) {
				contPlateau = new ContPlateau(fenetrePrincipale, contraintesLayout, plateau);
			} else if(i == 3) {
				contHistorique = new ContHistorique(fenetrePrincipale, contraintesLayout);
			}
		}
		contScore.refresh();
	}
}
