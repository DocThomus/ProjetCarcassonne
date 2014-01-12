package InterfacePioche;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Plateau;
import Noyau.Tuile;

public class ContPioche {
	private static ContPioche controleurPioche;
	private ModPioche modele;
	private VuePioche vue;
	
	public static boolean isPiocheVide() {
		return controleurPioche.modele.isPiocheVide();
	}
	
	public static void setRotation(boolean etat){
		controleurPioche.vue.setRotation(etat);
	}
	
	public static Tuile getTuile(){
		return controleurPioche.modele.getTuile();
	}
	
	public static void piocher() {
		controleurPioche.modele.piocher();
	}
	
	public ContPioche(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, Plateau plateau) {
		this.modele = new ModPioche(plateau);
		this.vue = new VuePioche(fenetrePrincipale, contraintesLayout, this);
		this.modele.addObserver(vue);
		this.modele.piocher();
		ContPioche.controleurPioche = this;
	}
	
	public void rotationH (){
		this.modele.rotationHoraire();

	}
	public void rotationAH (){
		this.modele.rotationAntiHoraire();
	}
}