package InterfacePlateau;

import java.awt.Image;
import java.util.Observable;

import Noyau.Plateau;

public class ModPlateau extends Observable {
	private Plateau plateau;
	private int xPosPlateau;
	private int yPosPlateau;
	private int largNbTuiles;
	private int hautNbTuiles;

	public ModPlateau(Plateau plateau) {
		this.plateau = plateau;
		
	}
	
	public Image[][] getTabImages() {
		return null;
	}
	
	public boolean[][] getTabCasesLibres() {
		return null;
	}
	
	

}
