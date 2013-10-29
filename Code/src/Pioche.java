import java.util.ArrayList;


public class Pioche {

	private ArrayList<Tuile> pioche;
	
	public Pioche() {
		// On crée la pioche, en y ajoutant chaque tuile du jeu de base une à une.
		this.pioche = new ArrayList<Tuile> ();
		
		// Tuile 1 : Abbaye entourée de champs (x4).
		for (int i = 0; i < 4; i++) {
			this.pioche.add(new Tuile(
					new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ABBAYE}, // Caractéristiques des bords.
					new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
					new boolean [][] { // Tableau de connexité des caractéristiques.
							{false, false, false, false, false}, 
							{false, false, false, false, false}, 
							{false, false, false, false, false}, 
							{false, false, false, false, false}, 
							{false, false, false, false, false}},
					new boolean [][] { // Tableau de connexité des champs.
							{false, true , true , true , true , true , true , true },
							{true , false, true , true , true , true , true , true },
							{true , true , false, true , true , true , true , true },
							{true , true , true , false, true , true , true , true },
							{true , true , true , true , false, true , true , true },
							{true , true , true , true , true , false, true , true },
							{true , true , true , true , true , true , false, true },
							{true , true , true , true , true , true , true , false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 2 : Abbaye entourée de champs, avec une route au sud (x2).
		for (int i = 0; i < 2; i++) {
			this.pioche.add(new Tuile(
					new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ABBAYE}, // Caractéristiques des bords.
					new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
					new boolean [][] { // Tableau de connexité des caractéristiques.
							{false, false, false, false, false}, 
							{false, false, false, false, false}, 
							{false, false, false, false, false}, 
							{false, false, false, false, false}, 
							{false, false, false, false, false}},
					new boolean [][] { // Tableau de connexité des champs.
							{false, true , true , true , true , true , true , true },
							{true , false, true , true , true , true , true , true },
							{true , true , false, true , true , true , true , true },
							{true , true , true , false, true , true , true , true },
							{true , true , true , true , false, true , true , true },
							{true , true , true , true , true , false, true , true },
							{true , true , true , true , true , true , false, true },
							{true , true , true , true , true , true , true , false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 3 : Tuile ville totale avec bouclier (x1).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.VILLE, Terrain.VILLE, Terrain.VILLE}, // Caractéristiques des bords.
					new boolean [] {false, false, false, false, false, false, false, false}, // Présence des champs.
					new boolean [][] { // Tableau de connexité des caractéristiques.
							{false, true , true , true , true }, 
							{true , false, true , true , true }, 
							{true , true , false, true , true }, 
							{true , true , true , false, true }, 
							{true , true , true , true , false}},
					new boolean [][] { // Tableau de connexité des champs.
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false}},
					4)); // Position du bouclier.
		}
		
		
		// Tuile 4 : Tuile une seule ville (nord, ouest, est) sans bouclier, avec champs au sud (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.VILLE}, // Caractéristiques des bords.
					new boolean [] {false, false, false, false, true, true, false, false}, // Présence des champs.
					new boolean [][] { // Tableau de connexité des caractéristiques.
							{false, true , false, true , true }, 
							{true , false, false, true , true }, 
							{false, false, false, false, false}, 
							{true , true , false, false, true }, 
							{true , true , false, true , false}},
					new boolean [][] { // Tableau de connexité des champs.
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, true , false, false},
							{false, false, false, false, true , false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 5 : Tuile une seule ville (nord, ouest, est) avec bouclier, avec champs au sud (x1).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.VILLE}, // Caractéristiques des bords.
					new boolean [] {false, false, false, false, true, true, false, false}, // Présence des champs.
					new boolean [][] { // Tableau de connexité des caractéristiques.
							{false, true , false, true , true }, 
							{true , false, false, true , true }, 
							{false, false, false, false, false}, 
							{true , true , false, false, true }, 
							{true , true , false, true , false}},
					new boolean [][] { // Tableau de connexité des champs.
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, true , false, false},
							{false, false, false, false, true , false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 6 : Tuile une seule ville (nord, ouest, est) sans bouclier, avec route au sud (x3).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.ROUTE, Terrain.VILLE, Terrain.VILLE}, // Caractéristiques des bords.
					new boolean [] {false, false, false, false, true, true, false, false}, // Présence des champs.
					new boolean [][] { // Tableau de connexité des caractéristiques.
							{false, true , false, true , true }, 
							{true , false, false, true , true }, 
							{false, false, false, false, false}, 
							{true , true , false, false, true }, 
							{true , true , false, true , false}},
					new boolean [][] { // Tableau de connexité des champs.
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 7 : Tuile une seule ville (nord, ouest, est) avec bouclier, avec route au sud (x3).
		for (int i = 0; i < 2; i++) {
			this.pioche.add(new Tuile(
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.ROUTE, Terrain.VILLE, Terrain.VILLE}, // Caractéristiques des bords.
					new boolean [] {false, false, false, false, true, true, false, false}, // Présence des champs.
					new boolean [][] { // Tableau de connexité des caractéristiques.
							{false, true , false, true , true }, 
							{true , false, false, true , true }, 
							{false, false, false, false, false}, 
							{true , true , false, false, true }, 
							{true , true , false, true , false}},
					new boolean [][] { // Tableau de connexité des champs.
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false},
							{false, false, false, false, false, false, false, false}},
					4)); // Position du bouclier.
		}
	}
}
