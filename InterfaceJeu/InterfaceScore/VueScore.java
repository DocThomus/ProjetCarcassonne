package InterfaceScore;

import java.awt.GridBagConstraints;

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
		PaquetScore ps = (PaquetScore) arg; 		
		int[] tabNbPion = ps.getTabNbPions();
		int[] tabScore = ps.getTabScores();		
		this.panScore.maj(tabNbPion, tabScore);
	}
}
