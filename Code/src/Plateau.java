import java.util.ArrayList;

public class Plateau {

private Tuile [][] repere;
private ArrayList<Tuile> tuilePose;
//private static Tuile tuileDeBase; la tuile de base sera ajouté comme les autres tuile en position centrale ( x=75, y= 75 pour un repere de taille 150

	public Plateau (int taille,int nbTuile) {
		this.repere= new Tuile [taille][taille]; // taille > 150
		this.tuilePose = new ArrayList<Tuile>(nbTuile) ; // permet de parcourir toute les tuile posé rapidement, en fin de jeu notamment
		//this.tuileDeBase = tuileDeBase; 
	}

	public void setTuile (Tuile t, int x, int y){
		this.repere[x][y] = t;
		this.tuilePose.add(t);
	}
	
	public Tuile getTuile (int x, int y){
		return this.repere[x][y];
	}
	
	public ArrayList<Tuile> getTuileAdjacentes(int x, int y){
		// renvoie les tuile adjacente a un point précis pour faire les vérifications de légalité, poser la tuile etc...
		// si il n'y a pas de tuile en renvoie une Tuile vide plutôt qu'un null pour éviter les problèmes par la suite
		ArrayList<Tuile> tAdjacente= new ArrayList<Tuile>(4);
		
		if(this.getTuile(x, y+1)==null){ 
			Tuile tVide = new Tuile(); 
			tAdjacente.add(0,tVide); }
		else {tAdjacente.add(0,this.getTuile(x, y+1));}
		
		if(this.getTuile(x+1, y)==null){ 
			Tuile tVide = new Tuile(); 
			tAdjacente.add(1,tVide);}
		else tAdjacente.add(1,this.getTuile(x+1, y));
		
		if(this.getTuile(x, y-1)==null){ 
			Tuile tVide = new Tuile(); 
			tAdjacente.add(2,tVide);}
		else {tAdjacente.add(2,this.getTuile(x, y-1));}
		
		if(this.getTuile(x-1, y)==null){ 
			Tuile tVide = new Tuile(); 
			tAdjacente.add(3,tVide);}
		else {tAdjacente.add(3,this.getTuile(x-1, y));}
		
		return tAdjacente;
	}
	
	
}
