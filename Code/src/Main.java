import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pioche p = new Pioche();
		Plateau r = new Plateau();
		Tuile t1 = new Tuile(
				new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE}, // Caractéristiques des bords.
				new boolean [] {false, false, true, true, true, true, true, true}, // Présence des champs.
				new boolean [][] { // Tableau de connexité des caractéristiques.
						{false, false, false, false, false}, 
						{false, false, false, true , true }, 
						{false, false, false, false, false}, 
						{false, true , false, false, true }, 
						{false, true , false, true , false}},
				new boolean [][] { // Tableau de connexité des champs.
						{false, false, false, false, false, false, false, true },
						{false, false, false, false, false, false, false, false},
						{false, false, false, false, false, false, false, false},
						{false, false, false, false, true , true , true , false},
						{false, false, false, true , false, true , true , false},
						{false, false, false, true , true , false, true , false},
						{false, false, false, true , true , true , false, false},
						{false, false, true , false, false, false, false, false}},
				5);
		ArrayList<Tuile> adj = new ArrayList<Tuile>();
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		adj = r.getTuileAdjacentes(x, y);
		if(t1.verifPoseTuileLegale(r, adj, 0)){		
			t1.poseTuile(adj, r, x, y);
			System.out.println("tuile1 posé");
		}
		
		Tuile t2 = new Tuile(new Terrain [] {Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE}, // Caractéristiques des bords.
				new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
				new boolean [][] { // Tableau de connexité des caractéristiques.
						{false, false, false, false, false}, 
						{false, false, false, false, false}, 
						{false, false, false, false, false}, 
						{false, false, false, false, false}, 
						{false, false, false, false, false}},
				new boolean [][] { // Tableau de connexité des champs.
						{false, false, false, false, false, false, false, true },
						{false, false, true , false, false, false, false, false},
						{false, true , false, false, false, false, false, false},
						{false, false, false, false, true , false, false, false},
						{false, false, false, true , false, false, false, false},
						{false, false, false, false, false, false, true , false},
						{false, false, false, false, false, true , false, false},
						{true , false, false, false, false, false, false, false}},
				5);
		
		x = sc.nextInt();
		y = sc.nextInt();
		adj = r.getTuileAdjacentes(x, y);
		if(t2.verifPoseTuileLegale(r, adj, 0)){		
			t2.poseTuile(adj, r, x, y);
			System.out.println("tuile2 posé");
		}
		
	}

}
