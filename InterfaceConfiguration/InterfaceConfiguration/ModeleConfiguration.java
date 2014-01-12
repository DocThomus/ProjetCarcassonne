package InterfaceConfiguration;

import Noyau.Joueur;


public class ModeleConfiguration  {
	String[] pseudo;
	
	public ModeleConfiguration(){
		this.pseudo= new String[7];
	}
	
	public void AjoutJoueur(int num,String nom){
			this.pseudo[num]=nom;
			System.out.println("pseudo ajouter : " + nom);	
	}
	
	public void supprimeJoueur(int num){
		this.pseudo[num]=null;
	}
	
	public void creerJoueurs(){
		for(int i=0; i<7;i++){
			if(this.pseudo[i]!=null)
			Joueur.creerJoueur(pseudo[i]);
		}
	}

}
