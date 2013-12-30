package InterfacePioche;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Plateau;

public class ContPioche {
	private ModPioche modele;
	private VuePioche vue;
	
	public ContPioche(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, Plateau plateau) {
		modele = new ModPioche(plateau);
		vue = new VuePioche(fenetrePrincipale, contraintesLayout);
		modele.addObserver(vue);
	}
	
	
}
