package InterfacePlateau;

import java.awt.Image;

public class PaquetPlateau {
	private Image[][] tabtabImages;
	private boolean[][] tabtabCasesLibres;
	private boolean etapePoseTuile;
	
	public PaquetPlateau(Image[][] tabtabImages, boolean[][] tabtabCasesLibres, boolean etapePoseTuile) {
		this.tabtabImages = tabtabImages;
		this.tabtabCasesLibres = tabtabCasesLibres;
		this.etapePoseTuile = etapePoseTuile;
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
