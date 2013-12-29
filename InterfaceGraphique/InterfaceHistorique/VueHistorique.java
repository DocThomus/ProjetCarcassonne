package InterfaceHistorique;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class VueHistorique implements Observer {
	private PanneauHistorique panHistorique;

	public VueHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		panHistorique = new PanneauHistorique();
		fenetrePrincipale.getContentPane().add(panHistorique, contraintesLayout);
	}

	public void update(Observable o, Object arg) {
		this.panHistorique.maj((ArrayList<String>)arg);
	}

}
