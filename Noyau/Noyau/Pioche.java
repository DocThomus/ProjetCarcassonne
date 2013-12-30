package Noyau;
import java.util.ArrayList;
import java.util.Random;


public class Pioche {

	private ArrayList<Tuile> pioche;
	
	public Pioche() {
		// On cr�e la pioche, en y ajoutant chaque tuile du jeu de base une � une.
		this.pioche = new ArrayList<Tuile> ();
		
		// Tuile 0 : Abbaye entour�e de champs (x4).
		for (int i = 0; i < 4; i++) {
			this.pioche.add(new Tuile(
					0,
					new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ABBAYE}, // Caract�ristiques des bords.
					new boolean [] {true, true, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{true},
							{true , true},
							{true , true , true},
							{true , true , true , true},
							{true , true , true , true , true},
							{true , true , true , true , true , true},
							{true , true , true , true , true , true , true}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 1 : Abbaye entour�e de champs, avec une route au sud (x2).
		for (int i = 0; i < 2; i++) {
			this.pioche.add(new Tuile(
					1,
					new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ABBAYE}, // Caract�ristiques des bords.
					new boolean [] {true, true, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{true},
							{true , true},
							{true , true , true},
							{true , true , true , true},
							{true , true , true , true , true},
							{true , true , true , true , true , true},
							{true , true , true , true , true , true , true}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 2 : Ville totale avec bouclier (x1).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					2,
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.VILLE, Terrain.VILLE, Terrain.VILLE}, // Caract�ristiques des bords.
					new boolean [] {false, false, false, false, false, false, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{true}, 
							{true , true}, 
							{true , true , true}, 
							{true , true , true , true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, false},
							{false, false, false, false, false},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					4)); // Position du bouclier.
		}
		
		
		// Tuile 3 : Une seule ville (nord, ouest, est) sans bouclier, avec champs au sud (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					3,
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.VILLE}, // Caract�ristiques des bords.
					new boolean [] {false, false, false, false, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{true}, 
							{false, false}, 
							{true , true , false}, 
							{true , true , false, true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, false},
							{false, false, false, false, true},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 4 : Une seule ville (nord, ouest, est) avec bouclier, avec champs au sud (x1).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					4,
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.VILLE}, // Caract�ristiques des bords.
					new boolean [] {false, false, false, false, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{true}, 
							{false, false}, 
							{true , true , false}, 
							{true , true , false, true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, false},
							{false, false, false, false, true},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					0)); // Position du bouclier.
		}
		
		
		// Tuile 5 : Une seule ville (nord, ouest, est) sans bouclier, avec route au sud (x1).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					5,
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.ROUTE, Terrain.VILLE, Terrain.VILLE}, // Caract�ristiques des bords.
					new boolean [] {false, false, false, false, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{true}, 
							{false, false}, 
							{true , true , false}, 
							{true , true , false, true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, false},
							{false, false, false, false, false},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 6 : Une seule ville (nord, ouest, est) avec bouclier, avec route au sud (x2).
		for (int i = 0; i < 2; i++) {
			this.pioche.add(new Tuile(
					6,
					new Terrain [] {Terrain.VILLE, Terrain.VILLE, Terrain.ROUTE, Terrain.VILLE, Terrain.VILLE}, // Caract�ristiques des bords.
					new boolean [] {false, false, false, false, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{true}, 
							{false, false}, 
							{true , true , false}, 
							{true , true , false, true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, false},
							{false, false, false, false, false},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					4)); // Position du bouclier.
		}
		
		
		// Tuile 7 : Ville en diagonale (nord, ouest) sans bouclier, champs en diagonale (est, sud) (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					7,
					new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{true , false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, true},
							{false, false, true , true},
							{false, false, true , true , true},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 8 : Ville en diagonale (nord, ouest) avec bouclier, champs en diagonale (est, sud) (x2).
		for (int i = 0; i < 2; i++) {
			this.pioche.add(new Tuile(
					8,
					new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{true , false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, true},
							{false, false, true , true},
							{false, false, true , true , true},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					0)); // Position du bouclier.
		}
		
		
		// Tuile 9 : Ville en diagonale (nord, ouest) sans bouclier, route en diagonale (est, sud) (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					9,
					new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.ROUTE, Terrain.VILLE, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, true}, 
							{true , false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, true},
							{false, false, true , false, false},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 10 : Ville en diagonale (nord, ouest) avec bouclier, route en diagonale (est, sud) (x2).
		for (int i = 0; i < 2; i++) {
			this.pioche.add(new Tuile(
					10,
					new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.ROUTE, Terrain.VILLE, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, true}, 
							{true , false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, true},
							{false, false, true , false, false},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					0)); // Position du bouclier.
		}
		
		
		// Tuile 11 : Ville qui traverse la tuile (ouest, centre, est) sans bouclier, champs au nord, champs au sud (x1).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					11,
					new Terrain [] {Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.VILLE}, // Caract�ristiques des bords.
					new boolean [] {true, true, false, false, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, true , false}, 
							{false, true , false, true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{true},
							{false, false},
							{false, false, false},
							{false, false, false, false},
							{false, false, false, false, true},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		

		
		
		// Tuile 12 : Ville qui traverse la tuile (ouest, centre, est) avec bouclier, champs au nord, champs au sud (x2).
		for (int i = 0; i < 2; i++) {
			this.pioche.add(new Tuile(
					12,
					new Terrain [] {Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.VILLE}, // Caract�ristiques des bords.
					new boolean [] {true, true, false, false, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, true , false}, 
							{false, true , false, true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{true},
							{false, false},
							{false, false, false},
							{false, false, false, false},
							{false, false, false, false, true},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					1)); // Position du bouclier.
		}
		
		
		// Tuile 13 : Ville au nord et ville � l'ouest (disjointes et sans bouclier), champs au centre, est et sud (joints) (x2).
		for (int i = 0; i < 2; i++) {
			this.pioche.add(new Tuile(
					13,
					new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, false, false}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, true},
							{false, false, true , true},
							{false, false, true , true , true},
							{false, false, false, false, false, false},
							{false, false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		// Tuile 14 : Ville au nord et ville au sud (disjointes et sans bouclier), champs au centre, est et ouest (joints) (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					14,
					new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, false, false, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, true},
							{false, false, false, false},
							{false, false, false, false, false},
							{false, false, true , true , false, false},
							{false, false, true , true , false, false, true}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 15 : Ville au nord (sans bouclier), champs au centre, est, sud et ouest (joints) (x5).
		for (int i = 0; i < 5; i++) {
			this.pioche.add(new Tuile(
					15,
					new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, true},
							{false, false, true , true},
							{false, false, true , true , true},
							{false, false, true , true , true , true},
							{false, false, true , true , true , true , true}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 16 : Ville au nord (sans bouclier), route � l'ouest et au sud (joints) champs � l'est (joints) (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					16,
					new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, true}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, true},
							{false, false, true , true},
							{false, false, false, false, false},
							{false, false, false, false, false, true},
							{false, false, true , true , true , false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 17 : Ville au nord (sans bouclier), route � l'est et au sud (joints) champs � l'ouest (joints) (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					17,
					new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.ROUTE, Terrain.CHAMPS, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, true}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, true},
							{false, false, true , false, false},
							{false, false, true , false, false, true},
							{false, false, true , false, false, true , true}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 18 : Ville au nord (sans bouclier), route � l'ouest, est et au sud (disjoints avec croisement) (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					18,
					new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, true},
							{false, false, false, false, false},
							{false, false, false, false, false, true},
							{false, false, true , false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 19 : Ville au nord (sans bouclier), route � l'ouest et � l'est (joints), champs au sud (x3).
		for (int i = 0; i < 3; i++) {
			this.pioche.add(new Tuile(
					19,
					new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, true , false}, 
							{false, true , false, true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, true},
							{false, false, false, true , true},
							{false, false, false, true , true , true},
							{false, false, true , false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 20 : Route au nord, centre et au sud (joints), champs � l'ouest et � l'est (x8).
		for (int i = 0; i < 8; i++) {
			this.pioche.add(new Tuile(
					20,
					new Terrain [] {Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE}, // Caract�ristiques des bords.
					new boolean [] {true, true, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{true , false}, 
							{false, false, false}, 
							{true , false, true , false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, true},
							{false, true , true},
							{false, true , true , true},
							{true , false, false, false, false},
							{true , false, false, false, false, true},
							{true , false, false, false, false, true , true}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 21 : Route au sud et � l'ouest (joints), champs au nord et � l'est (x9).
		for (int i = 0; i < 9; i++) {
			this.pioche.add(new Tuile(
					21,
					new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE, Terrain.CHAMPS}, // Caract�ristiques des bords.
					new boolean [] {true, true, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, true}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{true},
							{true , true},
							{true , true , true},
							{true , true , true , true},
							{false, false, false, false, false},
							{false, false, false, false, false, true},
							{true , true , true , true , true , false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 22 : Route au sud, � l'est et � l'ouest (disjoints), champs au nord (x4).
		for (int i = 0; i < 4; i++) {
			this.pioche.add(new Tuile(
					22,
					new Terrain [] {Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE}, // Caract�ristiques des bords.
					new boolean [] {true, true, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{true},
							{true , true},
							{false, false, false},
							{false, false, false, true},
							{false, false, false, false, false},
							{false, false, false, false, false, true},
							{true , true , true , false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		// Tuile 23 : Route au sud, � l'est, au nord et � l'ouest (disjoints) (x1).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					23,
					new Terrain [] {Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE, Terrain.ROUTE}, // Caract�ristiques des bords.
					new boolean [] {true, true, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, false, false}, 
							{false, false, false, false}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, true},
							{false, false, false},
							{false, false, false, true},
							{false, false, false, false, false},
							{false, false, false, false, false, true},
							{true , false, false, false, false, false, false}},
					5)); // Position du bouclier.
		}
		
		
		/*// Tuile 24 : Route � l'est et � l'ouest (joints), ville au nord, champs au sud, tuile de base (x1).
		for (int i = 0; i < 1; i++) {
			this.pioche.add(new Tuile(
					24,
					new Terrain [] {Terrain.VILLE, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE}, // Caract�ristiques des bords.
					new boolean [] {false, false, true, true, true, true, true, true}, // Pr�sence des champs.
					new boolean [][] { // Tableau de connexit� des caract�ristiques.
							{false}, 
							{false, false}, 
							{false, true , false}, 
							{false, true , false, true}},
					new boolean [][] { // Tableau de connexit� des champs.
							{false},
							{false, false},
							{false, false, false},
							{false, false, false, true},
							{false, false, false, true , true},
							{false, false, false, true , true , true},
							{false, false, true , false, false, false, false}},
					5)); // Position du bouclier.
		}*/
	}
	
	
	public int random() {
		int val = 0;
		Random r = new Random();
		val = r.nextInt(this.pioche.size()+1); // Un entier sera choisi entre 0 et la taille de la pioche.
		return val;
	}
	
	
	public Tuile piocheAleatoire(){
		int val = this.random();
		Tuile t = this.pioche.get(val); // On r�cupere la tuile � l'index qui est donn� par la fonction random().
		this.pioche.remove(val); // On suppprime la tuile de la pioche pour ne pas la repiocher.
		return t;
	}
}
