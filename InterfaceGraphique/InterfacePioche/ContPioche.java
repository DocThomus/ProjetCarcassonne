package InterfacePioche;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Plateau;

public class ContPioche {
	public static ContPioche ControleurPioche;
	private ModPioche modele;
	private VuePioche vue;
	
	public ContPioche(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, Plateau plateau) {
		this.modele = new ModPioche(plateau);
		this.vue = new VuePioche(fenetrePrincipale, contraintesLayout, this);
		this.modele.addObserver(vue);
		this.modele.piocher();
		ContPioche.ControleurPioche = this;
	}
	
	public ModPioche getModele(){
		return this.modele;
	}
	
	public void rotationH (){
		this.modele.rotationHoraire();
		//this.modele.piocher();
		System.out.println("rotation horaire + test pioche ok");
	}
	public void rotationAH (){
		this.modele.rotationAntiHoraire();
		System.out.println("rotation anti horaire ok");
	}
	
	public void setRotation(boolean etat){
		this.vue.setRotation(etat);
	}
	
}
