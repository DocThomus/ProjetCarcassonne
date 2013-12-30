package Noyau;

import java.awt.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Tuile {
	private int num; // Numéro de la tuile (correspond au numéro de l'image associée)
	private Terrain [] tabCarac; // 0 nord, 1 est, 2 sud, 3 ouest, 4 centre
	private boolean [] tabPresenceChamps; // 0 NNO, 1 NNE, 2 ENE, 3 ESE, 4 SSE, 5 SSO, 6 OSO, 7 ONO
	private boolean [][] tabConnexitéBordure;
	private boolean [][] tabConnexitéChamps; //Cette table de connexité concerne les champs.
	private int bouclier; // 0 nord, 1 est, 2 sud, 3 ouest, 4 centre, 5 pas de bouclier.
	private Pion PionPlacé;
	private ArrayList<Tuile> tuileAdjacentes;
	private int sensTuile;
	private int x; // abscisse de la tuile dans le repére du jeu ( ensemble des tuile posée )
	private int y; // ordonnée ...
	
	public static ArrayList<Image> listImagesTuiles = new ArrayList<Image>(); // TODO A remplir
	
	/**
	 * 
	 * @param caracs : Les caracterisqtiques des bords de la tuile
	 * @param presenceChamps : Présence des champs ou non.
	 * @param connexiteBordure : Tableau de connexité des bordures.
	 * @param connexiteChamps : Tableau de connexité des champs.
	 * @param bouclier : présence de bouclier ou non.
	 */
	
	public Tuile(int num, Terrain [] caracs, boolean [] presenceChamps, boolean [][] connexiteBordure, boolean [][] connexiteChamps, int bouclier){
		// pré-requis : Terrain [5] terre;
		// boolean [8] presencechamps;
		// boolean [4][4] connexitébordure;
		// boolean [8][8] connexitéchamps;
		this.num = num;
		this.tabCarac=caracs;
		this.tabPresenceChamps=presenceChamps;
		this.tabConnexitéBordure=connexiteBordure;
		this.tabConnexitéChamps=connexiteChamps;
		this.bouclier=bouclier;
		this.tuileAdjacentes=new ArrayList<Tuile>(4);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuile other = (Tuile) obj;
		if (bouclier != other.bouclier)
			return false;
		if (sensTuile != other.sensTuile)
			return false;
		if (!Arrays.equals(tabCarac, other.tabCarac))
			return false;
		if (!Arrays.equals(tabConnexitéBordure, other.tabConnexitéBordure))
			return false;
		if (!Arrays.equals(tabConnexitéChamps, other.tabConnexitéChamps))
			return false;
		if (!Arrays.equals(tabPresenceChamps, other.tabPresenceChamps))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	/**
	 * 
	 * @param j : le joueur desirant posé un pion.
	 * @param pos : la position à laquelle le joueur veut poser le pion.
	 */
	
	public void posePion(Joueur j, int pos){
		//pré-requis : la pose du pion est légale
		//action: pose un pion à la position souhaitée
		if(j.getTabPions().size()<7){			
			Pion p = new Pion(j,this,pos);
			j.getTabPions().add(p);
			this.PionPlacé=p;
			System.out.println("Pion placé");
		}
		else{ System.out.println("Vous n'avez plus de pions");}
		
	}
	
	/**
	 * 
	 * @param e : Appel de la méthode Evaluation qui permetra de verifier si la pose est légale ou non. 
	 * @return
	 */
	
	public boolean verifPosePionLegale(Evaluation e){
		//prérequis : aucun
		//action : verifier si il y a déja un pion sur la construction.
		ArrayList<Evaluation> evalPosePion = e.evalPosePion();
		boolean pasAutrePion = true;
		for(int i=0;i<evalPosePion.size();i++){
			if(evalPosePion.get(i).getT().PionPlacé!=null){ //Si il y a un pion sur cette tuile et ...
				if(evalPosePion.get(i).getT().PionPlacé.getPositionSurTuile()==evalPosePion.get(i).getPosition()){ // .. si ce pion est sur la même position que celle de l'évaluation.
					pasAutrePion= false; // C'est qu'il y a déjà un ou plusieurs pion sur cette construction.
					System.out.println("Il y a déjà un pion sur cette construction"); //Si un pion est déjà présent on le signal au joueur.
				}
			}	
		}
		return pasAutrePion;
	} 
      
	public void retirePion(){
		this.PionPlacé=null;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Terrain getCarac(int i){
		return this.tabCarac[i];
	}
	
	public int getBouclier(){
		return this.bouclier;
	}
	
	public boolean [][] getConnexitéBordure(){
		return this.tabConnexitéBordure;
	}
	
	public Pion getPionPlacé(){
		return this.PionPlacé;
	}
	 /**
	  * 
	  * @param sens : Cette méthode permet au joueur de faire tourner sa tuile si il le désir.
	  */
	 
	public void rotation(int sens){
		//pré-requis sens 1 : sens horaire

		if(sens==1){
			
			Terrain[]carac=new Terrain [5]; // Fait pivoter les caractéristique des bords.
			carac[0]=this.tabCarac[3];
			carac[1]=this.tabCarac[0];
			carac[2]=this.tabCarac[1];
			carac[3]=this.tabCarac[2];
			carac[4]=this.tabCarac[4];
			this.tabCarac=carac;
			
			boolean[][] rconnex= new boolean[4][4]; // Fait pivoter les connexité entre les caractéristique.
			rconnex[0][0]=this.tabConnexitéBordure[2][0];
			rconnex[1][0]=this.tabConnexitéBordure[2][1];
			rconnex[1][1]=this.tabConnexitéBordure[0][0];
			rconnex[2][0]=this.tabConnexitéBordure[2][2];
			rconnex[2][1]=this.tabConnexitéBordure[1][0];
			rconnex[2][2]=this.tabConnexitéBordure[1][1];
			rconnex[3][0]=this.tabConnexitéBordure[3][3];
			rconnex[3][1]=this.tabConnexitéBordure[3][0];
			rconnex[3][2]=this.tabConnexitéBordure[3][1];
			rconnex[3][3]=this.tabConnexitéBordure[3][2];
			this.tabConnexitéBordure=rconnex;
		}
		
	}

	
	/**
	 * 
	 * @param p : le plateau sur lequel la tuile est posé
	 * @param x : l'abcisse choisie par l'utilisateur
	 * @param y : l'ordonnée choisie par l'utilisateur
	 * @return
	 */
	
	public boolean verifPoseTuileLegale (Plateau p, int x, int y){
		if(p.isEmpty(x,y)){ // Vérifie que l'emplacement est disponible
			if(p.isEmpty(x-1, y) || p.getTuile(x-1, y).getCarac(1)==this.tabCarac[3]){ // Vérifie la compatibilité avec la tuile de gauche si elle existe
				if(p.isEmpty(x, y+1) || p.getTuile(x, y+1).getCarac(2)==this.tabCarac[0]){ // Vérifie la compatibilité avec la tuile du haut si elle existe
					if(p.isEmpty(x+1, y) || p.getTuile(x+1, y).getCarac(3)==this.tabCarac[1]){ // Vérifie la compatibilité avec la tuile de droite si elle existe
						if(p.isEmpty(x, y-1) || p.getTuile(x, y-1).getCarac(0)==this.tabCarac[2]){ // Vérifie la compatibilité avec la tuile du bas si elle existe
							if(!p.isEmpty(x-1, y) || !p.isEmpty(x, y+1) || !p.isEmpty(x+1, y) || !p.isEmpty(x, y-1) ){ // Vérifie si il y a au moins une tuile adjacentes
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	/**
	 * 
	 * @param r : le plateau sur lequel on pose la tuile.
	 * @param x : la coordonnée d'abcisse.
	 * @param y : la coordonnée d'ordonnée.
	 */
	
	public void poseTuile (Plateau r, int x, int y){
		r.poseTuile(this, x, y);
		this.x = x;
		this.y = y;
	}

	public boolean verifTuileEstPosable(Plateau p){
		boolean estPosable=false;
		int x=0; int y=0;
		for(int i =0; i<p.getTuilePosees().size();i++){ //Pour chaque tuile déjà posées...
			x=p.getTuilePosees().get(i).getX();
			y=p.getTuilePosees().get(i).getY();
			for(int j=0;j<3;j++){ // ... et pour les 4 position possible...
				if( this.verifPoseTuileLegale(p,x,y+1) || this.verifPoseTuileLegale(p,x+1,y) || this.verifPoseTuileLegale(p,x,y-1) || this.verifPoseTuileLegale(p,x-1,y)	 ){
					estPosable=true; //... on cherche si il y a au moins un emplacement libre autour des tuiles déjà posées
				}
				this.rotation(1);
			}
			this.rotation(1); // La tuile revient dans sa position initiale;
		}
		
		return estPosable;
	}
	
	
	
	
}// fin de classe
 
