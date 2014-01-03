package InterfacePlateau;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Plateau;

public class ContPlateau {
	private ModPlateau modele;
	private VuePlateau vue;
	
	private int largNbTuiles = 9;
	private int hautNbTuiles = 7;
	private int xPosPlateau = -4;
	private int yPosPlateau = -3;
	
	public ContPlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, Plateau plateau) {
		modele = new ModPlateau(plateau, largNbTuiles, hautNbTuiles, xPosPlateau, yPosPlateau);
		vue = new VuePlateau(fenetrePrincipale, contraintesLayout, largNbTuiles, hautNbTuiles);
		modele.addObserver(vue);
		modele.sendMajToVue();
	}
}
