package InterfacePlateau;

import java.awt.Image;

public class PaquetPlateau {
	private Image[][] tabtabImages;
	private boolean[][] tabtabCasesLibres;
	private boolean etapePoseTuile;
	private boolean tuilePoseeDansPlateau;
	private int ligneTuilePosee;
	private int colTuilePosee;
	
	public PaquetPlateau(Image[][] tabtabImages, boolean[][] tabtabCasesLibres, boolean etapePoseTuile, boolean tuilePoseeDansPlateau, int colTuilePosee , int ligneTuilePosee) {
		this.tabtabImages = tabtabImages;
		this.tabtabCasesLibres = tabtabCasesLibres;
		this.etapePoseTuile = etapePoseTuile;
		this.tuilePoseeDansPlateau = tuilePoseeDansPlateau;
		this.colTuilePosee = colTuilePosee;
		this.ligneTuilePosee = ligneTuilePosee;
		System.out.println("posée : "+tuilePoseeDansPlateau+colTuilePosee+','+ligneTuilePosee);
	}
	
	public boolean isTuilePoseeDansPlateau() {
		return this.tuilePoseeDansPlateau;
	}
	
	public int getLigneTuilePosee() {
		return this.ligneTuilePosee;
	}
	
	public int getColTuilePosee() {
		return this.colTuilePosee;
	}
	
	public boolean getEtapePoseTuile() {
		return this.etapePoseTuile;
	}
	
	public Image[][] getTabTabImages() {
		return this.tabtabImages;
	}
	
	public boolean[][] getTabTabCasesLibres() {
		return this.tabtabCasesLibres;
	}
}
