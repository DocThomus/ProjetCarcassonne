package InterfacePlateau;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Observable;

import InterfacePioche.ContPioche;
import Noyau.Evaluation;
import Noyau.Joueur;
import Noyau.Plateau;
import Noyau.Terrain;
import Noyau.Tuile;

public class ModPlateau extends Observable {
	private Plateau plateau;
	private int largNbTuiles;
	private int hautNbTuiles;
	private int xPosPlateau;
	private int yPosPlateau;

	private boolean etapePoseTuile;
	private boolean etapePosePion;
	private int xRelCentreTuilePosee;
	private int yRelCentreTuilePosee;
	
	public void evaluationFinTour(){
		Tuile tuileposee = ContPioche.ControleurPioche.getModele().getTuile();
		// Evaluation des Abbaye
		Evaluation evaltuileposee = new Evaluation(tuileposee,plateau,4);
		ArrayList<Evaluation> abbayeAevaluer = evaltuileposee.verifPresenceAbbaye();
		if(abbayeAevaluer.size()>0){
			for(int i=0;i<abbayeAevaluer.size();i++){
				abbayeAevaluer.get(i).evalAbbaye();
			}
		}
		//Evaluation du nord
		evaltuileposee = new Evaluation(tuileposee,plateau,0);
		ArrayList<Tuile> construction = evaltuileposee.evalConstruction();
		if(!construction.isEmpty()){
			if(tuileposee.getCarac(0)==Terrain.ROUTE){
				Joueur.getJoueurActif().ajoutPoints(construction.valeurRoute());
			}
			
		}
		
	}

	public ModPlateau(Plateau plateau, int largNbTuiles, int hautNbTuiles, int xPosPlateau, int yPosPlateau) {
		this.plateau = plateau;
		this.largNbTuiles = largNbTuiles;
		this.hautNbTuiles = hautNbTuiles;
		this.xPosPlateau = xPosPlateau;
		this.yPosPlateau = yPosPlateau;
		this.etapePoseTuile = true;
		this.etapePosePion = false;
	}
	
	
	private Image[][] getTabTabImages() {
		Image[][] tabtabImages = new Image[hautNbTuiles][largNbTuiles];
		for (int ligne = 0; ligne < hautNbTuiles; ligne++) {
			for (int col = 0; col < largNbTuiles; col++) {
				Tuile t = plateau.getTuile((col + this.xPosPlateau), (-(ligne + yPosPlateau))); 
				if (t != null) {
					tabtabImages[ligne][col] = t.getImageTuile();
				} 
			}
		}
		return tabtabImages;
	}
	
	private boolean[][] getTabTabCasesLibres() {
		boolean[][] tabtabCasesLibres = new boolean[hautNbTuiles][largNbTuiles];
		for (int ligne = 0; ligne < hautNbTuiles; ligne++) {
			for (int col = 0; col < largNbTuiles; col++) {
				tabtabCasesLibres[ligne][col] = this.plateau.isCaseLibre((col + this.xPosPlateau), (-(ligne + yPosPlateau))); 
			}
		}
		return tabtabCasesLibres;
	}
	
	public boolean[][] getTabTabPresencePion(){
		boolean[][] tabtabPresencePion = new boolean[hautNbTuiles][largNbTuiles];
		for (int ligne = 0; ligne < hautNbTuiles; ligne++) {
			for (int col = 0; col < largNbTuiles; col++) {
				Tuile t = plateau.getTuile((col + this.xPosPlateau), (-(ligne + yPosPlateau)));
				if (t != null && t.getPionPlacé()!=null) {
					tabtabPresencePion[ligne][col] = true;
				} else {
					tabtabPresencePion[ligne][col] = false;
				}
			}
		}
		return tabtabPresencePion;
	}
	
	public int [][] getTabTabPositionPion(){
		int[][] tabtabPositionPion = new int[hautNbTuiles][largNbTuiles];
		for (int ligne = 0; ligne < hautNbTuiles; ligne++) {
			for (int col = 0; col < largNbTuiles; col++) {
				Tuile t = plateau.getTuile((col + this.xPosPlateau), (-(ligne + yPosPlateau)));
				if (t != null && t.getPionPlacé()!=null) {
					tabtabPositionPion[ligne][col]=t.getPionPlacé().getPositionSurTuile();
				} 
			}
		}
		return tabtabPositionPion;
	}
	
	public  Color[][] getTabTabCouleurPion(){
		Color[][] tabtabCouleurPion = new Color[hautNbTuiles][largNbTuiles];
		for (int ligne = 0; ligne < hautNbTuiles; ligne++) {
			for (int col = 0; col < largNbTuiles; col++) {
				Tuile t = plateau.getTuile((col + this.xPosPlateau), (-(ligne + yPosPlateau)));
				if (t != null && t.getPionPlacé()!=null) {
						tabtabCouleurPion[ligne][col]=t.getPionPlacé().getProprio().getCouleur();
				}
			}
		}
		return tabtabCouleurPion;
	}
	
	public boolean poseTuile(int x, int y){
		if(ContPioche.ControleurPioche.getModele().getTuile().verifPoseTuileLegale(this.plateau, x, y)){
			ContPioche.ControleurPioche.getModele().getTuile().poseTuile(this.plateau, x, y);
			this.setCoordonneesRelCentreTuilePosees(x,y);
			System.out.println("c " + x + " " + y);
			this.etapePosePion = true;
			this.setEtapePoseTuile(false);
			this.sendMajToVue();
			return true;
		}
		else {
			System.out.println("Pose impossible");
			return false;
		}
	}
	
	private void setCoordonneesRelCentreTuilePosees(int x, int y) {
		this.xRelCentreTuilePosee = x;
		this.yRelCentreTuilePosee = y;
	}
	
	private boolean isTuilePoseeDansPlateau() {
		return (((this.xPosPlateau <= this.xRelCentreTuilePosee) && (this.xRelCentreTuilePosee <= this.xPosPlateau+this.largNbTuiles-1))
			&& ((this.yPosPlateau <= this.yRelCentreTuilePosee) && (this.yRelCentreTuilePosee <= this.yPosPlateau+this.hautNbTuiles-1)));
	}

	public void setXPosPlateau(int x){
		this.xPosPlateau=x;
		this.sendMajToVue();
		System.out.println("xPosPlateau :" + this.xPosPlateau);
	}
	
	public void setYPosPlateau(int y){
		this.yPosPlateau=y;
		this.sendMajToVue();
		System.out.println("yPosPlateau :" + this.yPosPlateau);
	}

	public void sendMajToVue() {
		this.setChanged();
		if (isTuilePoseeDansPlateau() && etapePosePion) {
			int colTuilePosee = this.xRelCentreTuilePosee - xPosPlateau;
			int ligneTuilePosee = -(yPosPlateau + this.yRelCentreTuilePosee);
			Tuile tuilePosee = this.plateau.getTuile((this.xRelCentreTuilePosee), (this.yRelCentreTuilePosee));
			boolean [] tabPresenceBoutonPosePion = tuilePosee.getTabPresenceBoutonPosePion();
			this.notifyObservers(new PaquetPlateau(this.getTabTabImages(), this.getTabTabCasesLibres(), this.etapePoseTuile, true, colTuilePosee, ligneTuilePosee, tabPresenceBoutonPosePion, this.getTabTabPresencePion(), this.getTabTabPositionPion(), this.getTabTabCouleurPion()));
			System.out.println("tuilePosée dedans !");
		} else {
			this.notifyObservers(new PaquetPlateau(this.getTabTabImages(), this.getTabTabCasesLibres(), this.etapePoseTuile, false, -1, -1, null, this.getTabTabPresencePion(), this.getTabTabPositionPion(), this.getTabTabCouleurPion()));
			System.out.println("tuilePosée dehors !");
		}		
	}
	
	public void setEtapePoseTuile(boolean b) {
		this.etapePoseTuile = b;
	}
	
	public void setEtapePosePion(boolean b) {
		this.etapePosePion = b;
	}
	
	
	
}
