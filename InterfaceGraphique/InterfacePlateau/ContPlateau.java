package InterfacePlateau;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import Noyau.Plateau;

public class ContPlateau {
	private ModPlateau modele;
	private VuePlateau vue;
	
	private int largNbTuiles = 7;
	private int hautNbTuiles = 6;
	private int xPosPlateau = -3;
	private int yPosPlateau = -2;
	
	public ContPlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, Plateau plateau) {
		modele = new ModPlateau(plateau, largNbTuiles, hautNbTuiles, xPosPlateau, yPosPlateau);
		vue = new VuePlateau(fenetrePrincipale, contraintesLayout, largNbTuiles, hautNbTuiles, this);
		modele.addObserver(vue);
		modele.sendMajToVue();
	}
	
	public void montePlateau(){
		System.out.println("controleur haut ok");
		this.yPosPlateau--;
		this.modele.setYPosPlateau(this.yPosPlateau);
	}
	public void descendPlateau(){
		System.out.println("controleur bas ok");
		this.yPosPlateau++;
		this.modele.setYPosPlateau(this.yPosPlateau);
	}
	public void decaleGauche(){
		System.out.println("controleur gauche ok");
		this.xPosPlateau--;
		this.modele.setXPosPlateau(this.xPosPlateau);
	}
	public void decaleDroite(){
		System.out.println("controleur droite ok");
		this.xPosPlateau++;
		this.modele.setXPosPlateau(this.xPosPlateau);
	}
	
	public void poseTuile(int col, int ligne){
		int xPosRelativeCentre = col + this.xPosPlateau;
		int yPosRelativeCentre = -(ligne + yPosPlateau);
		this.modele.poseTuile(xPosRelativeCentre, yPosRelativeCentre);
		System.out.println(xPosRelativeCentre + " " + yPosRelativeCentre);
	}
}
