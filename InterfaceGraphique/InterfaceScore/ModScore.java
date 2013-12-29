package InterfaceScore;

import java.util.ArrayList;
import java.util.Observable;

import Noyau.Joueur;

public class ModScore extends Observable{
	
	private Integer getNbJoueurs() {
		return new Integer(Joueur.getNbJoueurs());
	}
	
	private String[] getTabNomsJoueurs () {
		int nbJoueurs = getNbJoueurs();
		String[] tabScore = new String[nbJoueurs];
		for(int i = 0; i < nbJoueurs; i++) {
			tabScore[i] = Joueur.listJoueur.get(i).getNom();
		}
		return tabScore;
	}	
	
	private int[] getTabNbPions() {
		int nbJoueurs = getNbJoueurs();
		int[] tabScore = new int[nbJoueurs];
		for(int i = 0; i < nbJoueurs; i++) {
			tabScore[i] = Joueur.listJoueur.get(i).getNbPions();
		}
		return tabScore;
	}
	
	private int[] getTabScore() {
		int nbJoueurs = getNbJoueurs();
		int[] tabScore = new int[nbJoueurs];
		for(int i = 0; i < nbJoueurs; i++) {
			tabScore[i] = Joueur.listJoueur.get(i).getScore();
		}
		return tabScore;
	}
	
	public void sendMajToVue() {
		ArrayList<Object> tabArg = new ArrayList<Object>();		// On crée un tableau d'objets que l'on enverra à la vue. 
		tabArg.add(this.getNbJoueurs());		// 1ère case : Nombre de joueurs
		tabArg.add(this.getTabNomsJoueurs());	// 2e case : Noms des joueurs
		tabArg.add(this.getTabNbPions());		// 3e case : Nombre de pions des joueurs
		tabArg.add(this.getTabScore());			// 4e case : Score des joueurs
		
		this.setChanged();
		this.notifyObservers(tabArg);
	}
}
