package InterfacePlateau;

import javax.swing.JButton;

public class BoutonPoseTuile extends JButton {
	private static final long serialVersionUID = -489245348202904739L;
	private int ligne;
	private int col;	
	
	public BoutonPoseTuile (String nom, int ligne, int col){
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
