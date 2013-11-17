import java.util.ArrayList;

public class Plateau {

private Tuile [][] repere;
private ArrayList<Tuile> tuilePosees;
private static int taillePlateau = 200;
//private static Tuile tuileDeBase; la tuile de base sera ajouté comme les autres tuile en position centrale ( x=75, y= 75 pour un repere de taille 150

	public Plateau () {
		this.repere= new Tuile [taillePlateau][taillePlateau]; // taillePlateau = 200.
		this.tuilePosees = new ArrayList<Tuile>() ; // permet de parcourir toute les tuile posé rapidement, en fin de jeu notamment
		Tuile tuileDeBase = new Tuile(
					new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE}, // Caractéristiques des bords.
					new boolean [] {false, false, true, true, true, true, true, true}, // Présence des champs.
					new boolean [][] { // Tableau de connexité des caractéristiques.
							{false}, 
							{false, false}, 
							{false, true , false}, 
							{false, true , false, true}},
					new boolean [][] { // Tableau de connexité des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, true},
							{false, false, false, true , true},
							{false, false, false, true , true , true},
							{false, false, true , false, false, false, false}},
					5); // Position du bouclier.
		tuileDeBase.poseTuile(getTuileAdjacentes(100, 100), this, 100, 100); // Place la tuile de base sur le plateau en position 100/100
		//this.tuileDeBase = tuileDeBase; 
	}

	public void poseTuile (Tuile t, int x, int y){
		this.repere[x][y] = t;
		this.tuilePosees.add(t);
	}
	
	public Tuile getTuile (int x, int y){
		return this.repere[x][y];
	}
	
	public ArrayList<Tuile> getTuileAdjacentes(int x, int y) {
		// renvoie les tuile adjacente a un point précis pour faire les vérifications de légalité, poser la tuile etc...
		// si il n'y a pas de tuile en renvoie une Tuile vide plutôt qu'un null pour éviter les problèmes par la suite
		ArrayList<Tuile> tAdjacente= new ArrayList<Tuile>(4);
		
		if (this.getTuile(x, y+1) == null) { 
			tAdjacente.add(0, null);
		} else {
			tAdjacente.add(0, this.getTuile(x, y+1));
		}
		
		if (this.getTuile(x+1, y) == null) { 
			tAdjacente.add(1, null);
		} else {
			tAdjacente.add(1, this.getTuile(x+1, y));
		}
		
		if (this.getTuile(x, y-1) == null) { 
			tAdjacente.add(2, null);
		}
		else {
			tAdjacente.add(2, this.getTuile(x, y-1));
		}
		
		if (this.getTuile(x-1, y) == null) {  
			tAdjacente.add(3, null);
		} else {
			tAdjacente.add(3, this.getTuile(x-1, y));
		}
		
		return tAdjacente;
	}
	
	
}
