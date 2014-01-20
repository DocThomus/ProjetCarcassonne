package InterfacePlateau;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import InterfaceHistorique.ContHistorique;
import InterfacePioche.ContPioche;
import InterfaceScore.ContScore;
import Noyau.Evaluation;
import Noyau.Joueur;
import Noyau.Plateau;
import Noyau.Tuile;

public class ContPlateau {
	private static ContPlateau contPlateau;
	private ModPlateau modele;
	private VuePlateau vue;
	
	private int largNbTuiles = 7;
	private int hautNbTuiles = 6;
	private int xPosPlateau = -3;
	private int yPosPlateau = -2;
	private Plateau plateau;
	
	private int xPosRelativeCentre;
	private int yPosRelativeCentre;
	
	public static void activerBoutonsPoserTuile() {
		ContPlateau.contPlateau.modele.setEtapePoseTuile(true);
	}
	
	public static void desactiverBoutonsPoserPion() {
		ContPlateau.contPlateau.modele.setEtapePosePion(false);
	}
	
	public static void refresh() {
		ContPlateau.contPlateau.modele.sendMajToVue();
	}
	

	public static void evaluationFinTour(){
		ContPlateau.contPlateau.modele.evaluationFinTour();
	}
	
	public static void evaluationFinDePartie() {
		ContPlateau.contPlateau.modele.evaluationFinDePartie();
	}
	
	public ContPlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, Plateau plateau) {
		this.plateau = plateau;
		modele = new ModPlateau(plateau, largNbTuiles, hautNbTuiles, xPosPlateau, yPosPlateau);
		vue = new VuePlateau(fenetrePrincipale, contraintesLayout, largNbTuiles, hautNbTuiles, this);
		modele.addObserver(vue);
		modele.setEtapePoseTuile(true);
		modele.sendMajToVue();
		ContPlateau.contPlateau = this;
	}
	
	public void montePlateau(){
		this.yPosPlateau--;
		this.modele.setYPosPlateau(this.yPosPlateau);
	}
	public void descendPlateau(){
		this.yPosPlateau++;
		this.modele.setYPosPlateau(this.yPosPlateau);
	}
	public void decaleGauche(){
		this.xPosPlateau--;
		this.modele.setXPosPlateau(this.xPosPlateau);
	}
	public void decaleDroite(){
		this.xPosPlateau++;
		this.modele.setXPosPlateau(this.xPosPlateau);
	}
	
	public void poseTuile(int ligne, int col){
		this.xPosRelativeCentre = col + this.xPosPlateau;
		this.yPosRelativeCentre = -(ligne + this.yPosPlateau);
		
		if (ContPioche.getTuile().verifPoseTuileLegale(this.plateau, xPosRelativeCentre, yPosRelativeCentre)) {
			ContPioche.getTuile().poseTuile(this.plateau, xPosRelativeCentre, yPosRelativeCentre);
			ContPioche.setRotation(false);
			this.modele.setCoordonneesRelCentreTuilePosees(xPosRelativeCentre, yPosRelativeCentre);
			this.modele.setEtapePosePion(true);
			this.modele.setEtapePoseTuile(false);
			ContHistorique.activerBoutonPasser();
			ContHistorique.ajouterEvenement(Joueur.getJoueurActif().getNom() + " a pose une tuile en (" + xPosRelativeCentre + "," + yPosRelativeCentre + ").");
			this.modele.sendMajToVue();
		} else {
			ContHistorique.ajouterEvenement("Vous ne pouvez poser cette tuile ici !");
		}
	}
	
	public void posePion(Tuile t, int pos) {
		if(!Joueur.getJoueurActif().nAPlusDePion()) {
			if(t.verifPosePionLegale(new Evaluation(t, this.plateau, pos))) {
				t.posePion(Joueur.getJoueurActif(), pos);
				ContHistorique.ajouterEvenement(Joueur.getJoueurActif().getNom() + " a pose un pion en (" + this.xPosRelativeCentre + "," + this.yPosRelativeCentre + ").");
				this.modele.setEtapePosePion(false);
				this.modele.sendMajToVue();
				ContScore.refresh();
			}
		} else {
			ContHistorique.ajouterEvenement("Vous n'avez plus de pion");
		}
	}
}
