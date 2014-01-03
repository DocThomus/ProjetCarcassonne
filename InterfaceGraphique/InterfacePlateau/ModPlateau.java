package InterfacePlateau;

import java.awt.Image;
import java.util.Observable;

import Noyau.Plateau;
import Noyau.Tuile;

public class ModPlateau extends Observable {
	private Plateau plateau;
	private int largNbTuiles;
	private int hautNbTuiles;
	private int xPosPlateau;
	private int yPosPlateau;


	public ModPlateau(Plateau plateau, int largNbTuiles, int hautNbTuiles, int xPosPlateau, int yPosPlateau) {
		this.plateau = plateau;
		this.largNbTuiles = largNbTuiles;
		this.hautNbTuiles = hautNbTuiles;
		this.xPosPlateau = xPosPlateau;
		this.yPosPlateau = yPosPlateau;
	}
	
	public Image[][] getTabTabImages() {
		Image[][] tabtabImages = new Image[hautNbTuiles][largNbTuiles];
		for (int i = 0; i < hautNbTuiles; i++) {
			for (int j = 0; j < largNbTuiles; j++) {
				Tuile t = plateau.getTuile(i+yPosPlateau, j+xPosPlateau); 
				if (t != null) {
					tabtabImages[i][j] = t.getImageTuile();
				} 
			}
		}
		return tabtabImages;
	}
	
	public boolean[][] getTabTabCasesLibres() {
		boolean[][] tabtabCasesLibres = new boolean[hautNbTuiles][largNbTuiles];
		for (int i = 0; i < hautNbTuiles; i++) {
			for (int j = 0; j < largNbTuiles; j++) {
				tabtabCasesLibres[i][j] = this.plateau.isCaseLibre(i+yPosPlateau, j+xPosPlateau);
			}
		}
		return tabtabCasesLibres;
	}

	public void sendMajToVue() {
		this.setChanged();
		this.notifyObservers(new PaquetPlateau(this.getTabTabImages(), this.getTabTabCasesLibres()));
	}
}
