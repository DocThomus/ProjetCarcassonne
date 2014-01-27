package InterfaceScoreFin;

import Noyau.Joueur;
import Principal.ContPrincipal;

public class ControleurScoreFin {
    ModeleScoreFin modele;
    VueScoreFin vue;
    
    public ControleurScoreFin (){
        this.modele=new ModeleScoreFin();
        this.vue=new VueScoreFin(this);
    }
    
    public String [] getNomsJoueurs(){
        return modele.getNomsJoueurs();
    }
    
    public String [] getScoreJoueurs(){
    	return modele.getScoreJoueurs();
    }
    
    public int getNbJoueurs(){
    	return modele.getNomsJoueurs().length;
    }
    
    public void relancerPartie(){
    	Joueur.resetListeJoueurs();
    	ContPrincipal.configuration();
    }
}