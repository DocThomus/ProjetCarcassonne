import java.util.ArrayList;


public class Tuile {
	Terrain [] tabCarac;// 0 nord, 1 est, 2 sud, 3 ouest, 4 centre
	boolean [] tabPresenceChamps; // 0 NNO, 1 NNE, 2 ENE, 3 ESE, 4 SSE, 5 SSO, 6 OSO, 7 ONO
	boolean [][] tabConnexitéBordure;
	boolean [][] tabConnexitéChamps;
	int bouclier;
	Pion PionPlacé;
	ArrayList<Tuile> tuileAdjacentes;
	int sensTuile;
	
	
	public Tuile(Terrain [] terre, boolean [] presencechamps, boolean [][] connexitéchamps, boolean [][] connexitébordure, int bouclier){
		// pré-requis : Terrain [5] terre;
		//boolean [8] presencechamps;
		//boolean [4][4] connexitébordure;
		//boolean [8][8] connexitéchamps;
		this.tabCarac=terre;
		this.tabPresenceChamps=presencechamps;
		this.tabConnexitéChamps=connexitéchamps;
		this.tabConnexitéBordure=connexitébordure;
		this.bouclier=bouclier;
		
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
	
	public boolean verifPoseTuileLegale (ArrayList<Tuile> adjacente, int sens){
		// dans le ArrayList<Tuile> l'ordre correspond à leur place par rapport à la tuile qu'on veut poser : 0 = dessus, 1 = droite, 2 = en dessus, 3 = à gauche
		if(  (this.tabCarac[0]==adjacente.get(0).tabCarac[2] || adjacente.get(0)==null)
				&& (this.tabCarac[1]==adjacente.get(1).tabCarac[3] || adjacente.get(1)==null)
				&& (this.tabCarac[2]==adjacente.get(2).tabCarac[0] || adjacente.get(2)==null) 
				&& (this.tabCarac[3]==adjacente.get(3).tabCarac[1] || adjacente.get(3)==null) ){
		
		return true;
		}
		else return false;
	}

	
	
	
}
 
