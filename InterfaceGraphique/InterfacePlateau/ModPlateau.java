package InterfacePlateau;

import java.awt.Image;
import java.util.Observable;

import InterfacePioche.ContPioche;
import InterfacePioche.ModPioche;
import Noyau.Plateau;
import Noyau.Tuile;

public class ModPlateau extends Observable {
	private Plateau plateau;
	private int largNbTuiles;
	private int hautNbTuiles;
	private int xPosPlateau;
	private int yPosPlateau;

	private boolean etapePoseTuile;

	public ModPlateau(Plateau plateau, int largNbTuiles, int hautNbTuiles, int xPosPlateau, int yPosPlateau) {
		this.plateau = plateau;
		this.largNbTuiles = largNbTuiles;
		this.hautNbTuiles = hautNbTuiles;
		this.xPosPlateau = xPosPlateau;
		this.yPosPlateau = yPosPlateau;
		this.etapePoseTuile = true;
	}
	
	public Image[][] getTabTabImages() {
		Image[][] tabtabImages = new Image[hautNbTuiles][largNbTuiles];
		for (int ligne = 0; ligne < hautNbTuiles; ligne++) {
			for (int col = 0; col < largNbTuiles; col++) {
				Tuile t = plateau.getTuile((col + this.xPosPlateau), (-(ligne + yPosPlateau))); 
				if (t != null) {
					tabtabImages[ligne][col] = t.getImageTuile();
				} 
			}
		}
		return tabtabImages;
	}
	
	public boolean[][] getTabTabCasesLibres() {
		boolean[][] tabtabCasesLibres = new boolean[hautNbTuiles][largNbTuiles];
		for (int ligne = 0; ligne < hautNbTuiles; ligne++) {
			for (int col = 0; col < largNbTuiles; col++) {
				tabtabCasesLibres[ligne][col] = this.plateau.isCaseLibre((col + this.xPosPlateau), (-(ligne + yPosPlateau))); 
			}
		}
		return tabtabCasesLibres;
	}
	
	public void poseTuile(int x, int y){
		if(ContPioche.ControleurPioche.get(0).getModele().getTuile().verifPoseTuileLegale(this.plateau, x, y)){
			//int xp = x+Plateau.xCentre; int yp = y+Plateau.yCentre;
			ContPioche.ControleurPioche.get(0).getModele().getTuile().poseTuile(this.plateau, x, y);
			this.sendMajToVue(false);
		}
		else {System.out.println("Pose impossible");}
	}
	
	public void setXPosPlateau(int x){
		this.xPosPlateau=x;
		this.sendMajToVue(this.etapePoseTuile);
		System.out.println("xPosPlateau :" + this.xPosPlateau);
	}
	
	public void setYPosPlateau(int y){
		this.yPosPlateau=y;
		this.sendMajToVue(this.etapePoseTuile);
		System.out.println("yPosPlateau :" + this.yPosPlateau);
	}

	public void sendMajToVue(boolean etapePoseTuile) {
		this.setChanged();
		this.notifyObservers(new PaquetPlateau(this.getTabTabImages(), this.getTabTabCasesLibres(), etapePoseTuile));
	}
	
	
}
