package InterfaceScore;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class VueScore implements Observer{
	private PanneauScore panScore;
	
	public VueScore (JFrame fenetrePrincipale) {
		panScore = new PanneauScore();
		fenetrePrincipale.add(panScore);
		
		String[] a = {"a", "b", "c", "d"}; 	// Test
		int[] b = {1,5,6,2}; 				// ...
		int[] c = {10,20,54,120}; 			// ...
		panScore.maj(4,a,b,c); 				// ...
	}
	
	public void update(Observable o, Object arg) {
		ArrayList<Object> tab = (ArrayList<Object>) arg; 
		
		Integer nbJoueurs = (Integer) tab.get(0);
		String[] tabNomJoueur = (String[]) tab.get(1);
		int[] tabNbPion = (int[]) tab.get(2);
		int[] tabScore = (int[]) tab.get(3);
		
		this.panScore.maj(nbJoueurs, tabNomJoueur, tabNbPion, tabScore);
	}
}
