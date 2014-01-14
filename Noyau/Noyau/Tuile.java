package Noyau;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import InterfaceHistorique.ContHistorique;

public class Tuile {
	private int num; // Num�ro de la tuile (correspond au num�ro de l'image associ�e)
	private int orientation; // Num�ro correspondant � une des 4 orientations possible de la tuile
	private Terrain [] tabCarac; // 0 nord, 1 est, 2 sud, 3 ouest, 4 centre
	private boolean [] tabPresenceChamps; // 0 NNO, 1 NNE, 2 ENE, 3 ESE, 4 SSE, 5 SSO, 6 OSO, 7 ONO
	private boolean [][] tabConnexit�Bordure; // Soit N = Nord, S = Sud, E = Est, O = Ouest, C = Centre :
		/* Ainsi, la table de connexit� est la suivante (chaque case correspond � un couple de bordures qui sont connexes (la case vaut true) ou non (false)
		 * x\y 	0	1	2	3
		 * 	0	EN 
		 * 	1	SN 	SE
		 * 	2	ON 	OE 	OS
		 * 	3	CN 	CE 	CS 	CO
		 * 
		 * Ex : [2][1] = OE
		 */
	
	private boolean [][] tabConnexit�Champs; // Cette table de connexit� concerne les champs.
		/* Soit NNO = A, NNE = B, ENE = C, ESE = D, SSE = E, SSO = F, OSO = G, ONO = H.
		 * x\y	0	1	2	3	4	5	6
		 * 	0	AB
		 * 	1	AC	BC
		 * 	2	AD	BD	CD
		 * 	3	AE	BE	CE	DE
		 * 	4	AF	BF	CF	DF	EF	
		 * 	5	AG	BG	CG	DG	EG	FG
		 * 	6	AH  BH	CH	DH	EH	FH	GH
		 * N�cessite une rev�rification des �critures des tuiles dans la pioche.
		 */
	
	private boolean[] tabPresenceBoutonPosePion; // Ce tableau permet de savoir ou sont les positions possibles d'un pion sur la tuile.
		/*	Ce sch�ma est le m�me que pour repr�senter la position d'un pion (dans la classe Pion).
		 * 		11	12	1
		 * 	10				2
		 * 	9		0		3
		 * 	8				4
		 * 		7	6	5
		 */
	
	private int bouclier; // 0 nord, 1 est, 2 sud, 3 ouest, 4 centre, 5 pas de bouclier.
	private Pion pionPlace;
	private int x; // abscisse de la tuile dans le rep�re du jeu ( ensemble des tuile pos�e )
	private int y; // ordonn�e ...
	
	public static ArrayList<ArrayList<Image>> listImagesTuiles = new ArrayList<ArrayList<Image>>(24);
	
	/**
	 * 
	 * @param caracs : Les caracterisqtiques des bords de la tuile
	 * @param presenceChamps : Pr�sence des champs ou non.
	 * @param connexiteBordure : Tableau de connexit� des bordures.
	 * @param connexiteChamps : Tableau de connexit� des champs.
	 * @param bouclier : pr�sence de bouclier ou non.
	 */
	
	public Tuile(int num, Terrain [] caracs, boolean [] presenceChamps, boolean [][] connexiteBordure, boolean [][] connexiteChamps, boolean [] tabPresenceBoutonPosePion, int bouclier){
		// Pr�-requis : la structure de chaque param�tre doit �tre d�finie comme demand�.
		this.num = num;
		this.orientation=0;
		this.tabCarac=caracs;
		this.tabPresenceChamps=presenceChamps;
		this.tabConnexit�Bordure=connexiteBordure;
		this.tabConnexit�Champs=connexiteChamps;
		this.tabPresenceBoutonPosePion = tabPresenceBoutonPosePion;
		this.bouclier=bouclier;		
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
		if (orientation != other.orientation)
			return false;
		if (!Arrays.equals(tabCarac, other.tabCarac))
			return false;
		if (!Arrays.equals(tabConnexit�Bordure, other.tabConnexit�Bordure))
			return false;
		if (!Arrays.equals(tabConnexit�Champs, other.tabConnexit�Champs))
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
	 * @param j : le joueur desirant pos� un pion.
	 * @param pos : la position � laquelle le joueur veut poser le pion.
	 */
	
	public boolean posePion(Joueur j, int pos){
		//pr�-requis : la pose du pion est l�gale
		//action: pose un pion � la position souhait�e
		if(j.getTabPions().size()<7){			
			Pion p = new Pion(j,this,pos);
			j.getTabPions().add(p);
			this.pionPlace=p;
			return true;
		} else { 
			return false;
		}
		
	}
	
	/**
	 * 
	 * @param e : Appel de la m�thode Evaluation qui permetra de verifier si la pose est l�gale ou non. 
	 * @return
	 */
	
	public boolean verifPosePionLegale(Evaluation e){
		//pr�-requis : aucun
		//action : verifier si il y a d�ja un pion sur la construction.
		ArrayList<Evaluation> evalPosePion = e.evalPosePion();
		boolean pasAutrePion = true;
		for(int i=0; i < evalPosePion.size(); i++) {
			if(evalPosePion.get(i).getT().pionPlace != null) { // Si il y a un pion sur cette tuile et ...
				if(evalPosePion.get(i).getT().pionPlace.getPositionSurTuile() == evalPosePion.get(i).getPosition()) { // .. si ce pion est sur la m�me position que celle de l'�valuation.
					pasAutrePion = false; // C'est qu'il y a d�j� un ou plusieurs pion sur cette construction.
					ContHistorique.ajouterEvenement("Vous ne pouvez poser de pion ici !");
				}
			}
		}
		return pasAutrePion;
	} 
      
	public void retirePion(){
		this.pionPlace=null;
	}
	
	public Image getImageTuile(){
		return Tuile.listImagesTuiles.get(this.num).get(this.orientation);
	}
	
	public int getOrientation(){
		return this.orientation;
	}
	
	public int getNum(){
		return this.num;
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
	
	public boolean [][] getConnexit�Bordure(){
		return this.tabConnexit�Bordure;
	}
	
	public Pion getPionPlac�(){
		return this.pionPlace;
	}
	
	public boolean [] getTabPresenceBoutonPosePion() {
		return this.tabPresenceBoutonPosePion;
	}
	 /**
	  * 
	  * @param sens : Cette m�thode permet au joueur de faire tourner sa tuile si il le d�sir.
	  */
	 
	public void rotation(){
		this.orientation = (this.orientation + 1) % 4;
			
		Terrain[] carac = new Terrain [5]; // Fait pivoter les caract�ristique des bords.
		carac[0] = this.tabCarac[3];
		carac[1] = this.tabCarac[0];
		carac[2] = this.tabCarac[1];
		carac[3] = this.tabCarac[2];
		carac[4] = this.tabCarac[4];
		this.tabCarac = carac;
		
		boolean[] champs = new boolean[8];
		champs[0] = this.tabPresenceChamps[6];
		champs[1] = this.tabPresenceChamps[7];
		champs[2] = this.tabPresenceChamps[0];
		champs[3] = this.tabPresenceChamps[1];
		champs[4] = this.tabPresenceChamps[2];
		champs[5] = this.tabPresenceChamps[3];
		champs[6] = this.tabPresenceChamps[4];
		champs[7] = this.tabPresenceChamps[5];
		this.tabPresenceChamps = champs;
		
		/* Rappel : structure de connexit�Bordures :
		 * x\y	0	1	2	3
		 * 	0	EN 
		 * 	1	SN 	SE
		 * 	2	ON 	OE 	OS
		 * 	3	CN 	CE 	CS 	CO
		 */
		
		boolean[][] connexBord= new boolean[4][4]; // Fait pivoter les connexit� entre les caract�ristique.
		connexBord[0][0] = this.tabConnexit�Bordure[2][0]; // EN prend ON
		connexBord[1][0] = this.tabConnexit�Bordure[2][1]; // SN prend OE
		connexBord[1][1] = this.tabConnexit�Bordure[0][0]; // SE prend EN
		connexBord[2][0] = this.tabConnexit�Bordure[2][2]; // ON prend OS
		connexBord[2][1] = this.tabConnexit�Bordure[1][0]; // OE prend SN
		connexBord[2][2] = this.tabConnexit�Bordure[1][1]; // OS prend SE
		connexBord[3][0] = this.tabConnexit�Bordure[3][3]; // CN prend CO
		connexBord[3][1] = this.tabConnexit�Bordure[3][0]; // CE prend CN
		connexBord[3][2] = this.tabConnexit�Bordure[3][1]; // CS prend CE
		connexBord[3][3] = this.tabConnexit�Bordure[3][2]; // CO prend CS
		this.tabConnexit�Bordure = connexBord;
		
		boolean[] presenceBoutonPion = new boolean[13];
		presenceBoutonPion[0] = tabPresenceBoutonPosePion[0];
		presenceBoutonPion[1] = tabPresenceBoutonPosePion[10];
		presenceBoutonPion[2] = tabPresenceBoutonPosePion[11];
		presenceBoutonPion[3] = tabPresenceBoutonPosePion[12];
		presenceBoutonPion[4] = tabPresenceBoutonPosePion[1];
		presenceBoutonPion[5] = tabPresenceBoutonPosePion[2];
		presenceBoutonPion[6] = tabPresenceBoutonPosePion[3];
		presenceBoutonPion[7] = tabPresenceBoutonPosePion[4];
		presenceBoutonPion[8] = tabPresenceBoutonPosePion[5];
		presenceBoutonPion[9] = tabPresenceBoutonPosePion[6];
		presenceBoutonPion[10] = tabPresenceBoutonPosePion[7];
		presenceBoutonPion[11] = tabPresenceBoutonPosePion[8];
		presenceBoutonPion[12] = tabPresenceBoutonPosePion[9];
		this.tabPresenceBoutonPosePion = presenceBoutonPion;
	}

	
	/**
	 * 
	 * @param p : le plateau sur lequel la tuile est pos�
	 * @param x : l'abcisse choisie par l'utilisateur
	 * @param y : l'ordonn�e choisie par l'utilisateur
	 * @return
	 */
	
	public boolean verifPoseTuileLegale (Plateau p, int x, int y){
		if(p.isEmpty(x,y)){ // V�rifie que l'emplacement est disponible
			if(p.isEmpty(x-1, y) || p.getTuile(x-1, y).getCarac(1)==this.tabCarac[3]){ // V�rifie la compatibilit� avec la tuile de gauche si elle existe
				if(p.isEmpty(x, y+1) || p.getTuile(x, y+1).getCarac(2)==this.tabCarac[0]){ // V�rifie la compatibilit� avec la tuile du haut si elle existe
					if(p.isEmpty(x+1, y) || p.getTuile(x+1, y).getCarac(3)==this.tabCarac[1]){ // V�rifie la compatibilit� avec la tuile de droite si elle existe
						if(p.isEmpty(x, y-1) || p.getTuile(x, y-1).getCarac(0)==this.tabCarac[2]){ // V�rifie la compatibilit� avec la tuile du bas si elle existe
							if(!p.isEmpty(x-1, y) || !p.isEmpty(x, y+1) || !p.isEmpty(x+1, y) || !p.isEmpty(x, y-1) ){ // V�rifie si il y a au moins une tuile adjacentes
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
	 * @param p : le plateau sur lequel on pose la tuile.
	 * @param x : la coordonn�e d'abcisse.
	 * @param y : la coordonn�e d'ordonn�e.
	 */
	
	public void poseTuile (Plateau p, int x, int y){
		p.poseTuile(this, x, y);
		this.x = x;
		this.y = y;
	}

	public boolean verifTuileEstPosable(Plateau p){
		boolean estPosable=false;
		int x=0; int y=0;
		for(int i =0; i<p.getTuilePosees().size();i++){ //Pour chaque tuile d�j� pos�es...
			x=p.getTuilePosees().get(i).getX();
			y=p.getTuilePosees().get(i).getY();
			for(int j=0;j<3;j++){ // ... et pour les 4 position possible...
				if( this.verifPoseTuileLegale(p,x,y+1) || this.verifPoseTuileLegale(p,x+1,y) || this.verifPoseTuileLegale(p,x,y-1) || this.verifPoseTuileLegale(p,x-1,y)	 ){
					estPosable=true; //... on cherche si il y a au moins un emplacement libre autour des tuiles d�j� pos�es
				}
				this.rotation();
			}
			this.rotation(); // La tuile revient dans sa position initiale;
		}
		
		return estPosable;
	}
	
	public static void ajouteImagesTuiles() {
		for(int i=0;i<25;i++){ // Cr�ation des 25 ArrayList<Image>, qui contiendront chacune 4 image 
			Tuile.listImagesTuiles.add(i,new ArrayList<Image>());
		}
		// *************************Tuile 0
		try {
			Tuile.listImagesTuiles.get(0).add(0,ImageIO.read(new File("Image/Tuiles/tuile00.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(0).add(1,ImageIO.read(new File("Image/Tuiles/tuile01.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(0).add(2,ImageIO.read(new File("Image/Tuiles/tuile02.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(0).add(3,ImageIO.read(new File("Image/Tuiles/tuile03.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 1
		try {
			Tuile.listImagesTuiles.get(1).add(0,ImageIO.read(new File("Image/Tuiles/tuile10.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(1).add(1,ImageIO.read(new File("Image/Tuiles/tuile11.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(1).add(2,ImageIO.read(new File("Image/Tuiles/tuile12.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(1).add(3,ImageIO.read(new File("Image/Tuiles/tuile13.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 2
		try {
			Tuile.listImagesTuiles.get(2).add(0,ImageIO.read(new File("Image/Tuiles/tuile20.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(2).add(1,ImageIO.read(new File("Image/Tuiles/tuile21.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(2).add(2,ImageIO.read(new File("Image/Tuiles/tuile22.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(2).add(3,ImageIO.read(new File("Image/Tuiles/tuile23.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}				
		
		// **********************************Tuile 3
		try {
			Tuile.listImagesTuiles.get(3).add(0,ImageIO.read(new File("Image/Tuiles/tuile30.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(3).add(1,ImageIO.read(new File("Image/Tuiles/tuile31.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(3).add(2,ImageIO.read(new File("Image/Tuiles/tuile32.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(3).add(3,ImageIO.read(new File("Image/Tuiles/tuile33.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 4
		try {
			Tuile.listImagesTuiles.get(4).add(0,ImageIO.read(new File("Image/Tuiles/tuile40.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(4).add(1,ImageIO.read(new File("Image/Tuiles/tuile41.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(4).add(2,ImageIO.read(new File("Image/Tuiles/tuile42.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(4).add(3,ImageIO.read(new File("Image/Tuiles/tuile43.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 5
		try {
			Tuile.listImagesTuiles.get(5).add(0,ImageIO.read(new File("Image/Tuiles/tuile50.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(5).add(1,ImageIO.read(new File("Image/Tuiles/tuile51.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(5).add(2,ImageIO.read(new File("Image/Tuiles/tuile52.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(5).add(3,ImageIO.read(new File("Image/Tuiles/tuile53.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 6
		try {
			Tuile.listImagesTuiles.get(6).add(0,ImageIO.read(new File("Image/Tuiles/tuile60.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(6).add(1,ImageIO.read(new File("Image/Tuiles/tuile61.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(6).add(2,ImageIO.read(new File("Image/Tuiles/tuile62.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(6).add(3,ImageIO.read(new File("Image/Tuiles/tuile63.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
			// **********************************Tuile 7
		try {
			Tuile.listImagesTuiles.get(7).add(0,ImageIO.read(new File("Image/Tuiles/tuile70.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(7).add(1,ImageIO.read(new File("Image/Tuiles/tuile71.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(7).add(2,ImageIO.read(new File("Image/Tuiles/tuile72.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(7).add(3,ImageIO.read(new File("Image/Tuiles/tuile73.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 8
		try {
			Tuile.listImagesTuiles.get(8).add(0,ImageIO.read(new File("Image/Tuiles/tuile80.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(8).add(1,ImageIO.read(new File("Image/Tuiles/tuile81.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(8).add(2,ImageIO.read(new File("Image/Tuiles/tuile82.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(8).add(3,ImageIO.read(new File("Image/Tuiles/tuile83.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 9
		try {
			Tuile.listImagesTuiles.get(9).add(0,ImageIO.read(new File("Image/Tuiles/tuile90.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(9).add(1,ImageIO.read(new File("Image/Tuiles/tuile91.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(9).add(2,ImageIO.read(new File("Image/Tuiles/tuile92.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(9).add(3,ImageIO.read(new File("Image/Tuiles/tuile93.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 10
		try {
			Tuile.listImagesTuiles.get(10).add(0,ImageIO.read(new File("Image/Tuiles/tuile100.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(10).add(1,ImageIO.read(new File("Image/Tuiles/tuile101.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(10).add(2,ImageIO.read(new File("Image/Tuiles/tuile102.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(10).add(3,ImageIO.read(new File("Image/Tuiles/tuile103.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 11
		try {
			Tuile.listImagesTuiles.get(11).add(0,ImageIO.read(new File("Image/Tuiles/tuile110.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(11).add(1,ImageIO.read(new File("Image/Tuiles/tuile111.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(11).add(2,ImageIO.read(new File("Image/Tuiles/tuile112.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(11).add(3,ImageIO.read(new File("Image/Tuiles/tuile113.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 12
		try {
			Tuile.listImagesTuiles.get(12).add(0,ImageIO.read(new File("Image/Tuiles/tuile120.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(12).add(1,ImageIO.read(new File("Image/Tuiles/tuile121.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(12).add(2,ImageIO.read(new File("Image/Tuiles/tuile122.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(12).add(3,ImageIO.read(new File("Image/Tuiles/tuile123.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 13
		try {
			Tuile.listImagesTuiles.get(13).add(0,ImageIO.read(new File("Image/Tuiles/tuile130.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(13).add(1,ImageIO.read(new File("Image/Tuiles/tuile131.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(13).add(2,ImageIO.read(new File("Image/Tuiles/tuile132.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(13).add(3,ImageIO.read(new File("Image/Tuiles/tuile133.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 14
		try {
			Tuile.listImagesTuiles.get(14).add(0,ImageIO.read(new File("Image/Tuiles/tuile140.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(14).add(1,ImageIO.read(new File("Image/Tuiles/tuile141.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(14).add(2,ImageIO.read(new File("Image/Tuiles/tuile142.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(14).add(3,ImageIO.read(new File("Image/Tuiles/tuile143.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 15
		try {
			Tuile.listImagesTuiles.get(15).add(0,ImageIO.read(new File("Image/Tuiles/tuile150.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(15).add(1,ImageIO.read(new File("Image/Tuiles/tuile151.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(15).add(2,ImageIO.read(new File("Image/Tuiles/tuile152.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(15).add(3,ImageIO.read(new File("Image/Tuiles/tuile153.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 16
		try {
			Tuile.listImagesTuiles.get(16).add(0,ImageIO.read(new File("Image/Tuiles/tuile160.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(16).add(1,ImageIO.read(new File("Image/Tuiles/tuile161.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(16).add(2,ImageIO.read(new File("Image/Tuiles/tuile162.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(16).add(3,ImageIO.read(new File("Image/Tuiles/tuile163.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 17
		try {
			Tuile.listImagesTuiles.get(17).add(0,ImageIO.read(new File("Image/Tuiles/tuile170.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(17).add(1,ImageIO.read(new File("Image/Tuiles/tuile171.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(17).add(2,ImageIO.read(new File("Image/Tuiles/tuile172.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(17).add(3,ImageIO.read(new File("Image/Tuiles/tuile173.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 18
		try {
			Tuile.listImagesTuiles.get(18).add(0,ImageIO.read(new File("Image/Tuiles/tuile180.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(18).add(1,ImageIO.read(new File("Image/Tuiles/tuile181.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(18).add(2,ImageIO.read(new File("Image/Tuiles/tuile182.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(18).add(3,ImageIO.read(new File("Image/Tuiles/tuile183.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 19
		try {
			Tuile.listImagesTuiles.get(19).add(0,ImageIO.read(new File("Image/Tuiles/tuile190.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(19).add(1,ImageIO.read(new File("Image/Tuiles/tuile191.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(19).add(2,ImageIO.read(new File("Image/Tuiles/tuile192.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(19).add(3,ImageIO.read(new File("Image/Tuiles/tuile193.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 20
		try {
			Tuile.listImagesTuiles.get(20).add(0,ImageIO.read(new File("Image/Tuiles/tuile200.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(20).add(1,ImageIO.read(new File("Image/Tuiles/tuile201.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(20).add(2,ImageIO.read(new File("Image/Tuiles/tuile202.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(20).add(3,ImageIO.read(new File("Image/Tuiles/tuile203.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 21
		try {
			Tuile.listImagesTuiles.get(21).add(0,ImageIO.read(new File("Image/Tuiles/tuile210.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(21).add(1,ImageIO.read(new File("Image/Tuiles/tuile211.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(21).add(2,ImageIO.read(new File("Image/Tuiles/tuile212.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(21).add(3,ImageIO.read(new File("Image/Tuiles/tuile213.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 22
		try {
			Tuile.listImagesTuiles.get(22).add(0,ImageIO.read(new File("Image/Tuiles/tuile220.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(22).add(1,ImageIO.read(new File("Image/Tuiles/tuile221.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(22).add(2,ImageIO.read(new File("Image/Tuiles/tuile222.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(22).add(3,ImageIO.read(new File("Image/Tuiles/tuile223.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 23
		try {
			Tuile.listImagesTuiles.get(23).add(0,ImageIO.read(new File("Image/Tuiles/tuile230.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(23).add(1,ImageIO.read(new File("Image/Tuiles/tuile231.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(23).add(2,ImageIO.read(new File("Image/Tuiles/tuile232.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(23).add(3,ImageIO.read(new File("Image/Tuiles/tuile233.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// **********************************Tuile 24
		try {
			Tuile.listImagesTuiles.get(24).add(0,ImageIO.read(new File("Image/Tuiles/tuile240.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(24).add(1,ImageIO.read(new File("Image/Tuiles/tuile241.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(24).add(2,ImageIO.read(new File("Image/Tuiles/tuile242.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Tuile.listImagesTuiles.get(24).add(3,ImageIO.read(new File("Image/Tuiles/tuile243.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}