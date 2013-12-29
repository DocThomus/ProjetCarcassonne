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
		
		int[] b = {1,5,6,2}; 				// ...
		int[] c = {10,20,54,120}; 			// ...
		panScore.maj(b,c); 					// ...
		
		
		int[] b2 = {2,5,6,2}; 				// ...
		int[] c2 = {11,20,54,120}; 			// ...
		panScore.maj(b2,c2); 				// ...*/
	}
	
	public void update(Observable o, Object arg) {
		ArrayList<Object> tab = (ArrayList<Object>) arg; 
		
		int[] tabNbPion = (int[]) tab.get(2);
		int[] tabScore = (int[]) tab.get(3);
		
		this.panScore.maj(tabNbPion, tabScore);
	}
}
