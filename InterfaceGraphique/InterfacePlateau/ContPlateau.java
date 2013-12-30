package InterfacePlateau;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Plateau;

public class ContPlateau {
	private ModPlateau modele;
	private VuePlateau vue;
	
	public ContPlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, Plateau plateau) {
		modele = new ModPlateau(plateau);
		vue = new VuePlateau(fenetrePrincipale, contraintesLayout);
		modele.addObserver(vue);
		
		modele.getTabImages();
	}
}
