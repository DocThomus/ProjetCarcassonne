package InterfaceScore;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class VueScore implements Observer{
	private PanneauScore panScore;
	
	public VueScore () {
		panScore = new PanneauScore();
	}
	
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		ArrayList<Object> tab = (ArrayList<Object>) arg; 
		
		Integer nbJoueurs = (Integer) tab.get(0);
		String[] tabNomJoueur = (String[]) tab.get(1);
		int[] tabNbPion = (int[]) tab.get(2);
		int[] tabScore = (int[]) tab.get(3);
		
		this.panScore.maj(nbJoueurs, tabNomJoueur, tabNbPion, tabScore);
	}
}
