package InterfacePioche;

import java.awt.Color;
import java.awt.Image;

public class PaquetPioche {
	private String joueur;
	private Color couleur;
	private int taillePioche;
	private Image imgTuile;

	
	public PaquetPioche(String joueur, Color couleur, Image img, int taille){
		this.joueur = joueur;
		this.couleur = couleur;
		this.taillePioche=taille;
		this.imgTuile=img;
	}
	
	public String getJoueurActuel() {
		return this.joueur;
	}
	
	public Color getCouleurJoueurActuel() {
		return this.couleur;
	}
	
	public int getTaillePioche(){
		return this.taillePioche;
	}
	
	public Image getImageTuile(){
		return this.imgTuile;
	}
}

