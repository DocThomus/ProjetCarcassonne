package InterfacePlateau;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VuePlateau implements Observer {
	private JPanel panPlateau;

	public VuePlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		JPanel panPlateau = new JPanel();
		fenetrePrincipale.getContentPane().add(panPlateau, contraintesLayout);
		
		panPlateau.setBackground(Color.pink);
	}

	public void update(Observable o, Object arg) {
		
	}

}
