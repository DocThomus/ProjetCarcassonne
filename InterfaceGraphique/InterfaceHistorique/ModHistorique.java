package InterfaceHistorique;

import java.util.ArrayList;
import java.util.Observable;

public class ModHistorique extends Observable {
	private ArrayList<String> listeEvenements;
	
	public ModHistorique() {
		listeEvenements = new ArrayList<String>();
	}
	
	public void ajouterEvenement(String str) {
		listeEvenements.add(0, str);
	}
	
	private ArrayList<String> getListeEvenements() { // Retourne la liste des derniers éléments à afficher.
		int nbMessages = listeEvenements.size();
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i < nbMessages; i++) {
			list.add(0, listeEvenements.get(i));
		}
		
		return list;
	}
	
	public void refresh() {
		this.setChanged();
		this.notifyObservers(this.getListeEvenements());
	}
}
