package InterfaceJeu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import InterfaceScore.ContScore;
import Principal.Controleur;
import InterfaceHistorique.ContHistorique;
//import InterfacePioche.ContPioche;
//import InterfacePlateau.ContPlateau;

public class ContJeu implements Controleur {	
	
	public static int nbElements = 4;
	public static int x[] = 	{ 0,  0,  2,  7};
	public static int y[] = 	{ 0,  1,  0,  0};
	public static int larg[] = 	{ 2,  2,  5,  3};
	public static int haut[] =  { 1,  1,  2,  2};
	public static int px[] = 	{20,  0, 50, 30};
	public static int py[] = 	{50, 50,  0,  0};
	
	private ContScore contScore;
	private ContHistorique contHistorique;
	// private ContPioche contPioche;
	// private ContPlateau contPlateau;
	
	public ContJeu(JFrame fenetrePrincipale) {
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
				contScore = new ContScore(fenetrePrincipale, contraintesLayout);
			} else if(i == 1) {
				fenetrePrincipale.getContentPane().add((new JButton("3")),contraintesLayout); // Test
				//contPioche = new ContPioche(fenetrePrincipale, contraintesLayout);				
			} else if(i == 2) {
				fenetrePrincipale.getContentPane().add((new JButton("4")),contraintesLayout); // Test
				//contPlateau = new ContPlateau(fenetrePrincipale, contraintesLayout);
			} else if(i == 3) {
				contHistorique = new ContHistorique(fenetrePrincipale, contraintesLayout);
			}
		}
	}
}
