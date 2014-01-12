package InterfaceConfiguration;

import Noyau.Joueur;
import Principal.ContPrincipal;

public class ControleurConfiguration {
	ModeleConfiguration modele;
	VueConfiguration vue;
	
	public ControleurConfiguration (){
		this.modele=new ModeleConfiguration();
		this.vue=new VueConfiguration(this);
	}
	
	public void ajoutJoueur(int num, String nom){
		System.out.println("Controleur ok  : " + nom);
		this.modele.AjoutJoueur(num,nom);
	}
	public void supprimeJoueur(int num){
		this.modele.supprimeJoueur(num);
	}
	
	public void commencerPartie(){
		this.modele.creerJoueurs();
		Joueur.initialiserJoueurActif();
		ContPrincipal.debutPartie();
	}
}
