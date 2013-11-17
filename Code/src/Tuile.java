import java.util.ArrayList;


public class Tuile {
	private Terrain [] tabCarac; // 0 nord, 1 est, 2 sud, 3 ouest, 4 centre
	private boolean [] tabPresenceChamps; // 0 NNO, 1 NNE, 2 ENE, 3 ESE, 4 SSE, 5 SSO, 6 OSO, 7 ONO
	private boolean [][] tabConnexitéBordure;
	private boolean [][] tabConnexitéChamps;
	private int bouclier; // 0 nord, 1 est, 2 sud, 3 ouest, 4 centre, 5 pas de bouclier.
	private Pion PionPlacé;
	private ArrayList<Tuile> tuileAdjacentes;
	private int sensTuile;
	private int x; // abscisse de la tuile dans le repére du jeu ( ensemble des tuile posée )
	private int y; // ordonnée ...
	
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
	
	public Tuile (){
		this.tabCarac= new Terrain[4];
		for(int i =0;i<4;i++){
		this.tabCarac[i]=Terrain.VIDE;
		}
		this.tabPresenceChamps= new boolean [1];
		this.tabConnexitéBordure= new boolean [1][1];
		this.tabConnexitéChamps=new boolean [1][1];
		this.bouclier=5;
	}
	
	public void retirePion(){
		this.PionPlacé=null;
	}
	
	public void rotation(int sens){
		//pré-requis sens 1 : sens horaire ou sens -1 : sens antihoraire  
		if(sens == -1)
			sens = 3; // Bricolage pour le %4 si on a sens = -1
		
		this.sensTuile = (this.sensTuile + sens) % 4;
		
		Terrain temp=this.tabCarac[0];
		this.tabCarac[sens%4]=this.tabCarac[(1+sens)%4];
		this.tabCarac[(1+sens)%4]=this.tabCarac[(2+sens)%4];
		this.tabCarac[(2+sens)%4]=this.tabCarac[(3+sens)%4];
		this.tabCarac[(3+sens)%4]=temp;
		
		if (sens == 1) {
			sens = 2;
		} else if (sens == 3) {
			sens = 6;
		}
		
		boolean temp2 =this.tabPresenceChamps[0];
		this.tabPresenceChamps[sens%8] = this.tabPresenceChamps[(1+sens)%8];
		this.tabPresenceChamps[(1+sens)%8] = this.tabPresenceChamps[(2+sens)%8];
		this.tabPresenceChamps[(2+sens)%8] = this.tabPresenceChamps[(3+sens)%8];
		this.tabPresenceChamps[(3+sens)%8] = this.tabPresenceChamps[(4+sens)%8];
		this.tabPresenceChamps[(4+sens)%8] = this.tabPresenceChamps[(5+sens)%8];
		this.tabPresenceChamps[(5+sens)%8] = this.tabPresenceChamps[(6+sens)%8];
		this.tabPresenceChamps[(6+sens)%8] = this.tabPresenceChamps[(7+sens)%8];
		this.tabPresenceChamps[(7+sens)%8] = temp2;
	}
	
	public boolean verifPoseTuileLegale (Plateau p, ArrayList<Tuile> adjacente, int sens){
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
	}

	public void poseTuile (ArrayList<Tuile> adjacente, Plateau r, int x, int y){
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
	}
	
	
	public ArrayList<Tuile> verifPresenceAbbaye (){
		// Fonctions à appliquer sur la tuile qui vient d'être posé et aprés que le pion a été placé ( ou pas )
		//Vérifie si il y a une abbaye sur la tuile et/ou sur les tuile autour ( adjacente et diagonale ) et l'ajoute dans un ArrayList si c'est le cas
		//Rappel : dans l'attribut ArrayList<Tuile> tuileAdjacentes, l'ordre correspond à leur place par rapport à la tuile qu'on vient de poser : 0 = dessus, 1 = droite, 2 = dessous, 3 = à gauche
		
		
		ArrayList<Tuile> TuileAbbaye = new ArrayList<Tuile>();
		
		if(this.tabCarac[4]==Terrain.ABBAYE){ //pour la tuile qui vient d'être posé 
			TuileAbbaye.add(this);
		}
		if(this.tuileAdjacentes.get(0)!=null){ // pour la tuile du dessus
			if((this.tuileAdjacentes.get(0)).tabCarac[4]==Terrain.ABBAYE){
				TuileAbbaye.add(this.tuileAdjacentes.get(0));
			}
			
		}
		if(this.tuileAdjacentes.get(1)!=null){ // pour la tuile de droite
			if((this.tuileAdjacentes.get(1)).tabCarac[4]==Terrain.ABBAYE){
				TuileAbbaye.add(this.tuileAdjacentes.get(1));
			}
			
		}
		if(this.tuileAdjacentes.get(2)!=null){ // pour la tuile du dessous
			if((this.tuileAdjacentes.get(2)).tabCarac[4]==Terrain.ABBAYE){
				TuileAbbaye.add(this.tuileAdjacentes.get(2));
			}
			
		}
		if(this.tuileAdjacentes.get(3)!=null){ // pour la tuile de gauche
			if((this.tuileAdjacentes.get(3)).tabCarac[4]==Terrain.ABBAYE){
				TuileAbbaye.add(this.tuileAdjacentes.get(3));
			}
			
		}
		
		// les 8 if suivant vérifient la presence d'abbaye sur les diagonales (2 if par diagonale car 2 chemin pour y accéder), mais ne peut détecter une abbaye qui est en haut à gauche de la tuile posé si celle-ci n'a
		// ni tuile au-dessus et à gauche d'elle. Mais pas de probléme car dans ce cas l'abbaye est forcément imcompléte et donc rien à faire.
		
		if( this.tuileAdjacentes.get(0)!=null && this.tuileAdjacentes.get(0).tuileAdjacentes.get(3)!=null){ // diagonale haut/gauche en passant par le haut
			if (this.tuileAdjacentes.get(0).tuileAdjacentes.get(3).tabCarac[4]==Terrain.ABBAYE) {
				TuileAbbaye.add(this.tuileAdjacentes.get(0).tuileAdjacentes.get(3));
			}
		}	
		else if (this.tuileAdjacentes.get(3)!=null && this.tuileAdjacentes.get(3).tuileAdjacentes.get(0)!=null) { // else pour éviter de l'ajouter 2 fois si les 2 chemins sont valide, diagonale haut/gauche en passant par la gauche
			if (this.tuileAdjacentes.get(3).tuileAdjacentes.get(0).tabCarac[4]==Terrain.ABBAYE) {
				TuileAbbaye.add(this.tuileAdjacentes.get(3).tuileAdjacentes.get(0));
			}
		}
		
		if( this.tuileAdjacentes.get(0)!=null && this.tuileAdjacentes.get(0).tuileAdjacentes.get(1)!=null){ // diagonale haut/droite en passant par le haut
			if (this.tuileAdjacentes.get(0).tuileAdjacentes.get(1).tabCarac[4]==Terrain.ABBAYE) {
				TuileAbbaye.add(this.tuileAdjacentes.get(0).tuileAdjacentes.get(1));
			}
		}	
		else if (this.tuileAdjacentes.get(1)!=null && this.tuileAdjacentes.get(1).tuileAdjacentes.get(0)!=null) { // diagonale haut/droite en passant par la droite
			if (this.tuileAdjacentes.get(1).tuileAdjacentes.get(0).tabCarac[4]==Terrain.ABBAYE) {
				TuileAbbaye.add(this.tuileAdjacentes.get(1).tuileAdjacentes.get(0));
			}
		}
		
		if( this.tuileAdjacentes.get(2)!=null && this.tuileAdjacentes.get(2).tuileAdjacentes.get(1)!=null){ // diagonale bas/droite en passant par le bas
			if (this.tuileAdjacentes.get(2).tuileAdjacentes.get(1).tabCarac[4]==Terrain.ABBAYE) {
				TuileAbbaye.add(this.tuileAdjacentes.get(2).tuileAdjacentes.get(1));
			}
		}	
		else if (this.tuileAdjacentes.get(1)!=null && this.tuileAdjacentes.get(1).tuileAdjacentes.get(2)!=null) { // diagonale bas/droite en passant par la droite
			if (this.tuileAdjacentes.get(1).tuileAdjacentes.get(2).tabCarac[4]==Terrain.ABBAYE) {
				TuileAbbaye.add(this.tuileAdjacentes.get(1).tuileAdjacentes.get(2));
			}
		}
		
		if( this.tuileAdjacentes.get(2)!=null && this.tuileAdjacentes.get(2).tuileAdjacentes.get(3)!=null){ // diagonale bas/gauche en passant par le bas
			if (this.tuileAdjacentes.get(2).tuileAdjacentes.get(3).tabCarac[4]==Terrain.ABBAYE) {
				TuileAbbaye.add(this.tuileAdjacentes.get(2).tuileAdjacentes.get(3));
			}
		}	
		else if (this.tuileAdjacentes.get(3)!=null && this.tuileAdjacentes.get(3).tuileAdjacentes.get(2)!=null) { // diagonale bas/gauche en passant par la gauche
			if (this.tuileAdjacentes.get(3).tuileAdjacentes.get(2).tabCarac[4]==Terrain.ABBAYE) {
				TuileAbbaye.add(this.tuileAdjacentes.get(3).tuileAdjacentes.get(2));
			}
		}
		
		return TuileAbbaye;
				
	}
	
	
	public boolean verifAbbayeComplete (){
		// vérifie si une abbaye est compléte
		if ( this.tuileAdjacentes.get(0)!=null && this.tuileAdjacentes.get(1)!=null && this.tuileAdjacentes.get(2)!=null && this.tuileAdjacentes.get(3)!=null ) { // les 4 adjacentes
				return (this.tuileAdjacentes.get(0).tuileAdjacentes.get(3)!=null && this.tuileAdjacentes.get(0).tuileAdjacentes.get(1)!=null && // les 2 diagonales du haut
						this.tuileAdjacentes.get(2).tuileAdjacentes.get(3)!=null && this.tuileAdjacentes.get(2).tuileAdjacentes.get(1)!=null ); // les 2 diagonales du bas
		}
		else return false;
	}
	
	public int evalAbbayeFinPartie(Plateau r){
		// pré-requis : tuile avec un pion, en fin de partie
		// action : retourne la valeur d'une abbaye en fin de partie
		int res=1; 
		if ( r.getTuile(this.x-1,this.y+1)!=null ){ res++;}
		if ( r.getTuile(this.x,this.y+1)!=null ){ res++;}
		if ( r.getTuile(this.x+1,this.y+1)!=null ){ res++;}
		if ( r.getTuile(this.x+1,this.y)!=null ){ res++;}
		
		if ( r.getTuile(this.x+1,this.y-1)!=null ){ res++;}
		if ( r.getTuile(this.x,this.y-1)!=null ){ res++;}
		if ( r.getTuile(this.x-1,this.y-1)!=null ){ res++;}
		if ( r.getTuile(this.x-1,this.y)!=null ){ res++;}
		
		return res;
	}
	
	
	
	
	
	
}
 
