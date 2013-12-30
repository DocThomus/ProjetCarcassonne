package InterfacePioche;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Plateau;

public class ContPioche {
	private ModPioche modele;
	private VuePioche vue;
	
	public ContPioche(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, Plateau plateau) {
		this.modele = new ModPioche(plateau);
		this.vue = new VuePioche(fenetrePrincipale, contraintesLayout, this);
		this.modele.addObserver(vue);
		//this.modele.setImage();//Test
	}
	
	public void rotationH (){
		this.modele.rotationHoraire();
		System.out.println("ok");
	}
	public void rotationAH (){
		this.modele.rotationAntiHoraire();
		System.out.println("ok");
	}
	
}
