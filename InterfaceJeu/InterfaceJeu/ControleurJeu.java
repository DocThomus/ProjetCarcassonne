package InterfaceJeu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import Noyau.Plateau;
import InterfacePioche.ContPioche;
import InterfaceScore.ContScore;
import InterfaceHistorique.ContHistorique;
import InterfacePlateau.ContPlateau;

public class ControleurJeu {	
	public static final int LARGEUR_FENETRE = 1280;
	public static final int HAUTEUR_FENETRE = 720;
	
	private static int nbElements = 4;
	private static int x[] = 	{ 0,  0,  1,  7};
	private static int y[] = 	{ 0,  2,  0,  0};
	private static int larg[] = { 1,  1,  6,  3};
	private static int haut[] = { 3,  8,  8, 10};
	private static int px[] = 	{10,  0,  0, 70};
	private static int py[] = 	{ 0,100,  0,  0};
	
	public ControleurJeu(int nbJoueurs, String[] nomsJoueurs) {
		Plateau plateau = new Plateau();
		
		JFrame fenetrePrincipale = new JFrame();
		fenetrePrincipale.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
		fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetrePrincipale.setLocationRelativeTo(null); //On centre la frame au millieu de l'écran
		fenetrePrincipale.setResizable(false);
		
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
				new ContScore(fenetrePrincipale, contraintesLayout, nbJoueurs, nomsJoueurs);
			} else if(i == 1) {
				new ContPioche(fenetrePrincipale, contraintesLayout, plateau);				
			} else if(i == 2) {
				new ContPlateau(fenetrePrincipale, contraintesLayout, plateau);
			} else if(i == 3) {
				new ContHistorique(fenetrePrincipale, contraintesLayout);
			}
		}
		ContScore.refresh();
		fenetrePrincipale.setVisible(true);
	}
}
