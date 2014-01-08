package InterfacePlateau;

import javax.swing.JButton;

import Noyau.Tuile;

public class BoutonPion extends JButton {
	private static final long serialVersionUID = 2938267745613188098L;
	private Tuile tuile;
	private int position;
	
	public BoutonPion (int pos){
		super();
		this.position = pos;
	}
	
	public void setTuile(Tuile t) {
		this.tuile = t;
	}

	public int getPosition() {
		return this.position;
	}

	public Tuile getTuile() {
		return this.tuile;
	}	
}
