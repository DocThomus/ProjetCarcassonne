package InterfaceScore;

import java.util.ArrayList;
import java.util.Observable;

import Noyau.Joueur;

public class ModScore extends Observable {
	
	private int[] getTabNbPions() {
		int nbJoueurs = Joueur.getNbJoueurs();
		int[] tabScore = new int[nbJoueurs];
		for(int i = 0; i < nbJoueurs; i++) {
			tabScore[i] = Joueur.getJoueur(i).getNbPions();
		}
		return tabScore;
	}
	
	private int[] getTabScore() {
		int nbJoueurs = Joueur.getNbJoueurs();
		int[] tabScore = new int[nbJoueurs];
		for(int i = 0; i < nbJoueurs; i++) {
			tabScore[i] = Joueur.getJoueur(i).getScore();
		}
		return tabScore;
	}
	
	public void refresh() {
		ArrayList<Object> tabArg = new ArrayList<Object>();		// On crée un tableau d'objets que l'on enverra à la vue. 
		tabArg.add(this.getTabNbPions());						// 1e case : Nombre de pions des joueurs
		tabArg.add(this.getTabScore());							// 2e case : Score des joueurs
		
		this.setChanged();
		this.notifyObservers(tabArg);
	}
}
