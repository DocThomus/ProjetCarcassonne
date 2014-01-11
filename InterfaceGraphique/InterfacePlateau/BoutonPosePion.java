package InterfacePlateau;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import Noyau.Tuile;

public class BoutonPosePion extends JButton {
	private static final long serialVersionUID = 2938267745613188098L;
	private Tuile tuile;
	private int position;
	
	public BoutonPosePion (int pos, ActionListener ecouteur){
		super();
		this.position = pos;
		this.addActionListener(ecouteur);
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
