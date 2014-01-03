package InterfacePlateau;

import java.awt.Image;

public class PaquetPlateau {
	private Image[][] tabtabImages;
	private boolean[][] tabtabCasesLibres;
	
	public PaquetPlateau(Image[][] tabtabImages, boolean[][] tabtabCasesLibres) {
		this.tabtabImages = tabtabImages;
		this.tabtabCasesLibres = tabtabCasesLibres;
	}
	
	public Image[][] getTabTabImages() {
		return this.tabtabImages;
	}
	
	public boolean[][] getTabTabCasesLibres() {
		return this.tabtabCasesLibres;
	}
}
