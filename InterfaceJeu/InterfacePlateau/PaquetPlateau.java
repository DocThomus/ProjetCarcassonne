package InterfacePlateau;

import java.awt.Color;
import java.awt.Image;

public class PaquetPlateau {
	private Image[][] tabtabImages;
	private boolean[][] tabtabCasesLibres;
	private boolean etapePoseTuile;
	private boolean tuilePoseeDansPlateau;
	private int ligneTuilePosee;
	private int colTuilePosee;
	private boolean[] tabPresenceBoutonPosePion;
	private boolean[][] tabtabPresencePion;
	private int [][] tabtabPositionPion;
	private Color[][] tabtabCouleurPion;
	
	public PaquetPlateau(Image[][] tabtabImages, boolean[][] tabtabCasesLibres, boolean etapePoseTuile, boolean tuilePoseeDansPlateau, int colTuilePosee , int ligneTuilePosee, boolean[] tabPresenceBoutonPosePion, boolean[][] tabtabPresencePion, int [][] tabtabPositionPion, Color[][] tabtabCouleurPion) {
		this.tabtabImages = tabtabImages;
		this.tabtabCasesLibres = tabtabCasesLibres;
		this.etapePoseTuile = etapePoseTuile;
		this.tuilePoseeDansPlateau = tuilePoseeDansPlateau;
		this.colTuilePosee = colTuilePosee;
		this.ligneTuilePosee = ligneTuilePosee;
		this.tabPresenceBoutonPosePion = tabPresenceBoutonPosePion;
		this.tabtabPresencePion = tabtabPresencePion;
		this.tabtabPositionPion = tabtabPositionPion;
		this.tabtabCouleurPion = tabtabCouleurPion;
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
	
	public boolean[] getTabPresenceBoutonPosePion() {
		return this.tabPresenceBoutonPosePion;
	}
	
	public boolean[][] getTabTabPresencePion(){
		return this.tabtabPresencePion;
	}
	
	public int [][] getTabTabPositionPion(){
		return this.tabtabPositionPion;
	}
	
	public Color[][] getTabTabCouleurPion(){
		return this.tabtabCouleurPion;
	}
	
	
}//fin classe
