package InterfacePlateau;

import javax.swing.JButton;

public class BoutonPlateau extends JButton {
	
	private String nom;
	private int x;
	private int y;	
	
	public BoutonPlateau (String nom ,int x , int y){
		super(nom);
		this.x=x;
		this.y=y;
		this.setActionCommand(this.x+","+this.y);
	}
	
	public int getX (){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
