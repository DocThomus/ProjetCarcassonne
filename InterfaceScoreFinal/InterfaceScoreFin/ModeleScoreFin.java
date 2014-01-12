package InterfaceScoreFin;
import java.util.ArrayList;

import Noyau.Joueur;

public class ModeleScoreFin {
	private ArrayList<Joueur> listJoueur;
	               
	public ModeleScoreFin() {   
		listJoueur = Joueur.getListJoueur();     
		this.classementJoueurs(); // le tableau de Joueur est maintenant classé par ordre décroissant de score
	}

	public String [] getNomsJoueurs() {	// renvoie les noms des Joueurs dans l'ordre décroissant de score
		String [] nomsJoueurs = new String [listJoueur.size()];
		for(int i=0; i<listJoueur.size(); i++) {
			nomsJoueurs[i] = listJoueur.get(i).getNom();
		}
    	return nomsJoueurs;
    }	
    	
    public String [] getScoreJoueurs() { // renvoie les scores des joueurs dans l'ordre décroissant
    	String [] scoreJoueurs = new String[listJoueur.size()];
    	for(int i=0; i<listJoueur.size(); i++) {   
    		String s = String.valueOf(listJoueur.get(i).getScore());
    		scoreJoueurs[i] = s;
    	}
    	return scoreJoueurs;
    }
    		
    public int getScore(int id) { 
    	return Joueur.getJoueur(id).getScore();
    }
    
    public void classementJoueurs() { // fait un tri des joueurs en fonction de leur score (ordre décroissant)
    	int [] scorejoueurs = new int [listJoueur.size()];
    	
    	for(int i = 0; i< listJoueur.size(); i++) {
    		scorejoueurs [i] = listJoueur.get(i).getScore();
    	}

    	int interscore = 0; Joueur interJoueur= null;
    	
    	for(int i =0; i<listJoueur.size();i++) {
    		for(int j=1; j< listJoueur.size(); j++) {
    			if (scorejoueurs[j-1] < scorejoueurs[j]) {  
    				interscore = scorejoueurs[j-1];
					interJoueur = listJoueur.get(j-1);
					scorejoueurs[j-1] = scorejoueurs[j];
					listJoueur.set(j-1, listJoueur.get(j));
					scorejoueurs[j]= interscore;
					listJoueur.set(j,interJoueur);
    			}
    		}
    	} 
    }
}