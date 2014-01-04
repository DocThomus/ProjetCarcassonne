package InterfacePlateau;

import javax.swing.JButton;

public class BoutonPlateau extends JButton {
	
	private int ligne;
	private int col;	
	
	public BoutonPlateau (String nom, int ligne, int col){
		super(nom);
		this.ligne=ligne;
		this.col=col;
	}
	
	public int getLigne(){
		return ligne;
	}
	
	public int getCol(){
		return col;
	}
	
}
