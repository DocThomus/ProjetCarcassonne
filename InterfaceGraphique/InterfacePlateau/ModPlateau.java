package InterfacePlateau;

import java.awt.Image;
import java.util.Observable;

import Noyau.Plateau;
import Noyau.Tuile;

public class ModPlateau extends Observable {
	private Plateau plateau;
	private static int largNbTuiles = 9;
	private static int hautNbTuiles = 7;
	private static int xPosPlateau = -4;
	private static int yPosPlateau = -3;


	public ModPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	
	public Image[][] getTabImages() {
		Image[][] tabtabImages = new Image[largNbTuiles][hautNbTuiles];
		for (int i = 0; i < largNbTuiles; i++) {
			for (int j = 0; j < hautNbTuiles; j++) {
				Tuile t = plateau.getTuile(Plateau.xCentre+i+xPosPlateau, Plateau.yCentre+j+yPosPlateau); 
				if (t != null) {
					//tabtabImages[i][j] = t.getImage();
				} else {

				}
			}
		}
		return tabtabImages;
	}
	
	public boolean[][] getTabCasesLibres() {
		return null;
	}
	
	

}
