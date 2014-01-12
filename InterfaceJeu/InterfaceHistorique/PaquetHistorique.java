package InterfaceHistorique;

import java.util.ArrayList;

public class PaquetHistorique {
	private ArrayList<String> listEvenements;
	
	public PaquetHistorique(ArrayList<String> listEvenements) {
		this.listEvenements = listEvenements;
	}

	public ArrayList<String> getListEvenements() {
		return listEvenements;
	}
}
