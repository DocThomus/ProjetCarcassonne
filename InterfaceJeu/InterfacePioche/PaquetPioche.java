package InterfacePioche;

import java.awt.Image;

public class PaquetPioche {

	private int taillePioche;
	private Image imgTuile;
	
	public PaquetPioche(Image img, int taille){
		this.taillePioche=taille;
		this.imgTuile=img;
	}
	
	public int getTaillePioche(){
		return this.taillePioche;
	}
	public Image getImageTuile(){
		return this.imgTuile;
	}
}

