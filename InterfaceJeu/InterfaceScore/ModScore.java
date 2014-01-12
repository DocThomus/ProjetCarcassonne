package InterfaceScore;

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
		this.setChanged();
		this.notifyObservers(new PaquetScore(this.getTabNbPions(), this.getTabScore()));
	}
}
