package InterfaceScore;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class VueScore implements Observer{	
	private PanneauScore panScore;
	
	public VueScore (JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, int nbJoueurs, String[] nomsJoueurs) {
		panScore = new PanneauScore(nbJoueurs, nomsJoueurs);
		fenetrePrincipale.getContentPane().add(panScore, contraintesLayout);
	}
	
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		ArrayList<Object> tab = (ArrayList<Object>) arg; 
		
		int[] tabNbPion = (int[]) tab.get(0);
		int[] tabScore = (int[]) tab.get(1);
		
		this.panScore.maj(tabNbPion, tabScore);
	}
}
