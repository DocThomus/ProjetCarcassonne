package InterfacePlateau;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BoutonPosePion extends JButton {
	private static final long serialVersionUID = 2938267745613188098L;
	private int position;
	
	public BoutonPosePion (int pos, ActionListener ecouteur){
		super();
		this.position = pos;
		this.addActionListener(ecouteur);
	}

	public int getPosition() {
		return this.position;
	}
}
