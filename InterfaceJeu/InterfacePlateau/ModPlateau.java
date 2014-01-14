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
	
	public void setCoordonneesRelCentreTuilePosees(int x, int y) {
		this.xRelCentreTuilePosee = x;
		this.yRelCentreTuilePosee = y;
	}

	public void setXPosPlateau(int x){
		this.xPosPlateau=x;
		this.sendMajToVue();
	}
	
	public void setYPosPlateau(int y){
		this.yPosPlateau=y;
		this.sendMajToVue();
	}
	
	public void setEtapePoseTuile(boolean b) {
		this.etapePoseTuile = b;
	}
	
	public void setEtapePosePion(boolean b) {
		this.etapePosePion = b;
	}
	
	private boolean isTuilePoseeDansPlateau() {
		int xGauche = xPosPlateau;
		int yHaut = -yPosPlateau;
		int xDroite = xGauche + largNbTuiles - 1;
		int yBas = yHaut - hautNbTuiles + 1;
		
		return ((xGauche <= xRelCentreTuilePosee) 	&&	(xRelCentreTuilePosee <= xDroite)
			&&	(yBas <= yRelCentreTuilePosee)		&&	(yRelCentreTuilePosee <= yHaut)	 );	
	}

	public void sendMajToVue() {
		this.setChanged();
		if (isTuilePoseeDansPlateau() && etapePosePion) {
			int colTuilePosee = this.xRelCentreTuilePosee - xPosPlateau;
			int ligneTuilePosee = -(yPosPlateau + this.yRelCentreTuilePosee);
			Tuile tuilePosee = this.plateau.getTuile((this.xRelCentreTuilePosee), (this.yRelCentreTuilePosee));
			boolean [] tabPresenceBoutonPosePion = tuilePosee.getTabPresenceBoutonPosePion();
			this.notifyObservers(new PaquetPlateau(this.getTabTabImages(), this.getTabTabCasesLibres(), this.etapePoseTuile, true, colTuilePosee, ligneTuilePosee, tabPresenceBoutonPosePion, this.getTabTabPresencePion(), this.getTabTabPositionPion(), this.getTabTabCouleurPion()));
		} else {
			this.notifyObservers(new PaquetPlateau(this.getTabTabImages(), this.getTabTabCasesLibres(), this.etapePoseTuile, false, -1, -1, null, this.getTabTabPresencePion(), this.getTabTabPositionPion(), this.getTabTabCouleurPion()));
		}		
	}
	
	public void evaluationFinTour(){
		Tuile tuileposee = ContPioche.getTuile();
		ArrayList<Joueur> winner;
		Evaluation evalPion;
		// Evaluation des Abbaye
		Evaluation evaltuileposee = new Evaluation(tuileposee,plateau,4);
		ArrayList<Evaluation> abbayeAevaluer = evaltuileposee.verifPresenceAbbaye();
			for(int i=0;i<abbayeAevaluer.size();i++){
				abbayeAevaluer.get(i).evalAbbaye();
		}
		//Evaluation du nord
		evaltuileposee = new Evaluation(tuileposee,plateau,0);
		ArrayList<Tuile> construction = evaltuileposee.evalConstruction();
		if(!construction.isEmpty()){
			if(tuileposee.getCarac(0)==Terrain.ROUTE){
				evalPion=new Evaluation(tuileposee,plateau,12);
				winner = evalPion.getMajorité(Joueur.getListJoueur());
				for(int i=0;i<winner.size();i++){
					winner.get(i).ajoutPoints(evaltuileposee.valeurRoute(construction));
				}
			}
			if(tuileposee.getCarac(0)==Terrain.VILLE){
				evalPion=new Evaluation(tuileposee,plateau,12);
				winner = evalPion.getMajorité(Joueur.getListJoueur());
				for(int i=0;i<winner.size();i++){
					winner.get(i).ajoutPoints(evaltuileposee.valeurVille(construction));
				}
			}
		}
		//Evaluation de l'est
		evaltuileposee = new Evaluation(tuileposee,plateau,1);
		construction = evaltuileposee.evalConstruction();
		if(!construction.isEmpty()){
			if(tuileposee.getCarac(1)==Terrain.ROUTE){
				evalPion=new Evaluation(tuileposee,plateau,3);
				winner = evalPion.getMajorité(Joueur.getListJoueur());
				for(int i=0;i<winner.size();i++){
					winner.get(i).ajoutPoints(evaltuileposee.valeurRoute(construction));
				}
			}
			if(tuileposee.getCarac(1)==Terrain.VILLE){
				evalPion=new Evaluation(tuileposee,plateau,3);
				winner = evalPion.getMajorité(Joueur.getListJoueur());
				for(int i=0;i<winner.size();i++){
					winner.get(i).ajoutPoints(evaltuileposee.valeurVille(construction));
				}
			}
		}
		//Evaluation du sud
		evaltuileposee = new Evaluation(tuileposee,plateau,2);
		construction = evaltuileposee.evalConstruction();
		if(!construction.isEmpty()){
			if(tuileposee.getCarac(2)==Terrain.ROUTE){
				evalPion=new Evaluation(tuileposee,plateau,6);
				winner = evalPion.getMajorité(Joueur.getListJoueur());
				for(int i=0;i<winner.size();i++){
					winner.get(i).ajoutPoints(evaltuileposee.valeurRoute(construction));
				}
			}
			if(tuileposee.getCarac(2)==Terrain.VILLE){
				evalPion=new Evaluation(tuileposee,plateau,6);
				winner = evalPion.getMajorité(Joueur.getListJoueur());
				for(int i=0;i<winner.size();i++){
					winner.get(i).ajoutPoints(evaltuileposee.valeurVille(construction));
				}
			}
		}
		//Evaluation de l'ouest
		evaltuileposee = new Evaluation(tuileposee,plateau,3);
		construction = evaltuileposee.evalConstruction();
		if(!construction.isEmpty()){
			if(tuileposee.getCarac(3)==Terrain.ROUTE){
				evalPion=new Evaluation(tuileposee,plateau,9);
				winner = evalPion.getMajorité(Joueur.getListJoueur());
				for(int i=0;i<winner.size();i++){
					winner.get(i).ajoutPoints(evaltuileposee.valeurRoute(construction));
				}
			}
			if(tuileposee.getCarac(3)==Terrain.VILLE){
				evalPion=new Evaluation(tuileposee,plateau,9);
				winner = evalPion.getMajorité(Joueur.getListJoueur());
				for(int i=0;i<winner.size();i++){
					winner.get(i).ajoutPoints(evaltuileposee.valeurVille(construction));
				}
			}
		}
	}

	public void evaluationFinDePartie(){
		Tuile t; int pos; Evaluation eval; ArrayList<Tuile> construction; 
		int posCarac=0; ArrayList<Joueur> winner;
		for(int i=0;i<Joueur.getNbJoueurs();i++){
			while(Joueur.getJoueur(i).getTabPions().size()>0){
				
				t = Joueur.getJoueur(i).getTabPions().get(0).getTuile();
				pos = Joueur.getJoueur(i).getTabPions().get(0).getPositionSurTuile();
				eval = new Evaluation(t,plateau,pos);
				construction=eval.evalConstructionFinDePartie();
				
				if(pos==12){posCarac=0;} if(pos==3){posCarac=1;} if(pos==6){posCarac=2;} if(pos==9){posCarac=3;} if(pos==0){posCarac=4;}
				
				if(t.getCarac(posCarac)==Terrain.ABBAYE){
					eval.evalAbbayeFinPartie();
				}
				
				if(t.getCarac(posCarac)==Terrain.VILLE){
					winner= eval.getMajorité(Joueur.getListJoueur());
					for(int j=0;j<winner.size();j++){
						winner.get(j).ajoutPoints(eval.valeurVilleFinDePartie(construction));
					}
				}
				if(t.getCarac(posCarac)==Terrain.ROUTE){
					winner= eval.getMajorité(Joueur.getListJoueur());
					for(int j=0;j<winner.size();j++){
						winner.get(j).ajoutPoints(eval.valeurRoute(construction));
					}
				}
			}
		}
	}
}
