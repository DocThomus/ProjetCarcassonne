import java.util.ArrayList;
import java.util.Arrays;


public class Tuile {
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
	
	/**
	 * 
	 * @param caracs : Les caracterisqtiques des bords de la tuile
	 * @param presenceChamps : Présence des champs ou non.
	 * @param connexiteBordure : Tableau de connexité des bordures.
	 * @param connexiteChamps : Tableau de connexité des champs.
	 * @param bouclier : présence de bouclier ou non.
	 */
	
	public Tuile(Terrain [] caracs, boolean [] presenceChamps, boolean [][] connexiteBordure, boolean [][] connexiteChamps, int bouclier){
		// pré-requis : Terrain [5] terre;
		// boolean [8] presencechamps;
		// boolean [4][4] connexitébordure;
		// boolean [8][8] connexitéchamps;
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
		//action : verifier si il y a déja un pion sur la tuile.
		ArrayList<Evaluation> evalPosePion = e.evalPosePion();
		boolean autrePion = true;
		for(int i=0;i<evalPosePion.size();i++){
			if(evalPosePion.get(i).getT().PionPlacé!=null){ //Si il y a un pion sur cette tuile et ...
				if(evalPosePion.get(i).getT().PionPlacé.getPositionSurTuile()==evalPosePion.get(i).getPosition()){ // .. si ce pion est sur la même position que celle de l'évaluation.
					autrePion=false; // C'est qu'il y a déjà un ou plusieurs pion sur cette construction.
					System.out.println("Il y a déjà un pion sur cette construction"); //Si un pion est déjà présent on le signal au joueur.
				}
			}	
		}
		return autrePion;
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
		//pré-requis sens 1 : sens horaire ou sens -1 : sens antihoraire  
		/*
		if(sens == -1)
			sens = 3; // Bricolage pour le %4 si on a sens = -1
		
		this.sensTuile = (this.sensTuile + sens) % 4;
		
		Terrain temp=this.tabCarac[0]; //Fait tourner les caractéristiques de la tuile. 
		this.tabCarac[sens%4]=this.tabCarac[(1+sens)%4];
		this.tabCarac[(1+sens)%4]=this.tabCarac[(2+sens)%4];
		this.tabCarac[(2+sens)%4]=this.tabCarac[(3+sens)%4];
		this.tabCarac[(3+sens)%4]=temp;
		
		if (sens == 1) {
			sens = 2;
		} else if (sens == 3) {
			sens = 6;
		}
		
		boolean temp2 =this.tabPresenceChamps[0]; //Si il y a des champs, cette méthode permet de fare tourner les champs
		this.tabPresenceChamps[sens%8] = this.tabPresenceChamps[(1+sens)%8];
		this.tabPresenceChamps[(1+sens)%8] = this.tabPresenceChamps[(2+sens)%8];
		this.tabPresenceChamps[(2+sens)%8] = this.tabPresenceChamps[(3+sens)%8];
		this.tabPresenceChamps[(3+sens)%8] = this.tabPresenceChamps[(4+sens)%8];
		this.tabPresenceChamps[(4+sens)%8] = this.tabPresenceChamps[(5+sens)%8];
		this.tabPresenceChamps[(5+sens)%8] = this.tabPresenceChamps[(6+sens)%8];
		this.tabPresenceChamps[(6+sens)%8] = this.tabPresenceChamps[(7+sens)%8];
		this.tabPresenceChamps[(7+sens)%8] = temp2;
		*/
		
		
		
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
	
	
	
	/*public boolean verifPoseTuileLegale (Plateau p, ArrayList<Tuile> adjacente, int sens){
		// TODO gestion de si la tuile est posée sur une tuile déjà existante.
		// dans l'attribut ArrayList<Tuile> tuileAdjacentes, l'ordre correspond à leur place par rapport à la tuile qu'on veut poser : 0 = dessus, 1 = droite, 2 = dessous, 3 = à gauche
		if (adjacente.get(0) == null && adjacente.get(1) == null && adjacente.get(2) == null && adjacente.get(3) == null) {
			// On ne peut pas pose une tuile si elle n'est pas entourée d'au moins une tuile.
			return false;
		}
		else if(   (adjacente.get(0) != null && this.tabCarac[0]==adjacente.get(0).tabCarac[2])
				&& (adjacente.get(1) != null && this.tabCarac[1]==adjacente.get(1).tabCarac[3])
				&& (adjacente.get(2) != null && this.tabCarac[2]==adjacente.get(2).tabCarac[0]) 
				&& (adjacente.get(3) != null && this.tabCarac[3]==adjacente.get(3).tabCarac[1])) {
			// On vérifie la compatibilité des caractéristiques entre la tuile proposée et ses voisins.
			// Pour chaque voisin, on vérifie qu'il existe, et seulement ensuite, on vérifie la correspondance des caracs.
			return true;
		} else {
			// On retourne faux si les caracs des voisis ne correspondent pas.
			return false;
		}
	}*/
	
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

	/*public void poseTuile (ArrayList<Tuile> adjacente, Plateau r, int x, int y){
		// pré-requis : la pose de la tuile est légale
		r.poseTuile(this, x, y);
		this.x = x;
		this.y = y;
		
		// Pour chaque voisin, a condition qu'il existe, on ajoute à cette tuile son nouveau voisin, et au voisin cette tuile.
		if (adjacente.get(0) != null) {
			this.tuileAdjacentes.add(0,adjacente.get(0));
			this.tuileAdjacentes.get(0).tuileAdjacentes.add(2,this);
		} 
		
		if (adjacente.get(1) != null) {
			this.tuileAdjacentes.add(1,adjacente.get(1));
			this.tuileAdjacentes.get(1).tuileAdjacentes.add(3,this);
		}
		
		if (adjacente.get(2) != null) {
			this.tuileAdjacentes.add(2,adjacente.get(2));
			this.tuileAdjacentes.get(2).tuileAdjacentes.add(0,this);
		}
		
		if (adjacente.get(3) != null) {
			this.tuileAdjacentes.add(3,adjacente.get(3));
			this.tuileAdjacentes.get(3).tuileAdjacentes.add(1,this);
		}
	}*/
	
	
	
	
}// fin de classe
 
