package Noyau;
import java.util.ArrayList;

public class Plateau {

	private Tuile [][] repere;
	private ArrayList<Tuile> tuilePosees;
	private static int taillePlateau = 200;
	
	public final static int xCentre = 100;
	public final static int yCentre = 100;

	public Plateau () {
		this.repere= new Tuile [taillePlateau][taillePlateau]; // taillePlateau = 200.
		this.tuilePosees = new ArrayList<Tuile>() ; // permet de parcourir toute les tuile posï¿½ rapidement, en fin de jeu notamment
		Tuile tuileDeBase = new Tuile(
					24,
					new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE}, // Caractï¿½ristiques des bords.
					new boolean [] {false, false, true, true, true, true, true, true}, // Prï¿½sence des champs.
					new boolean [][] { // Tableau de connexitï¿½ des caractï¿½ristiques.
							{false}, 
							{false, false}, 
							{false, true , false}, 
							{false, true , false, true}},
					new boolean [][] { // Tableau de connexitï¿½ des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, true},
							{false, false, false, true , true},
							{false, false, false, true , true , true},
							{false, false, true , false, false, false, false}},
					new boolean [] {true, false, false, false, false, false, false, false, false, false, false, false, true}, // Presence des boutons PoserPion.
					5); // Position du bouclier.
		tuileDeBase.poseTuile(this, 0, 0); // Place la tuile de base sur le plateau en position 100/100 (xCentre et yCentre sont ajoutés dans poseTuile).
	}

	public void poseTuile (Tuile t, int x, int y){
		x = x + xCentre;
		y = y + yCentre;
		this.repere[x][y] = t;
		this.tuilePosees.add(t);
	}
	
	public ArrayList<Tuile> getTuilePosees(){
		return this.tuilePosees;
	}
	
	public Tuile getTuile (int x, int y){
		x = x + xCentre;
		y = y + yCentre;
		return this.repere[x][y];
	}
	
	public boolean isEmpty (int x, int y){
		x = x + xCentre;
		y = y + yCentre;
		return (this.repere[x][y]==null);
	}
	
	public boolean isCaseLibre(int x, int y) {
		// retourne vrai ssi la case en positon (x,y) est libre, et si elle a au moins un voisin.
		// On considère la taille du plateau suffisemment grande pour ne pas dépasser ses bords.
		return (this.isEmpty(x, y)) && ((!this.isEmpty(x-1, y) || !this.isEmpty(x, y-1) || !this.isEmpty(x+1, y) || !this.isEmpty(x, y+1)));
	}
}
