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
				// Tuile 12 bis : Ville qui traverse la tuile ( nord, centre, sud) sans bouclier, champs a l'est et l'ouest (x1).
				new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE}, // Caractéristiques des bords.
				new boolean [] { false, false, true, true, false, false, true, true}, // Présence des champs.
				new boolean [][] { // Tableau de connexité des caractéristiques.
						{false}, 
						{false, false}, 
						{true, false , false}, 
						{false, false , false, false}},
				new boolean [][] { // Tableau de connexité des champs.
						{false},
						{false, false},
						{false, false, true},
						{false, false, false, false},
						{false, false, false, false, false},
						{false, false, false, false, false, false},
						{false, false, false, false, false, false, true}},
				5); // Position du bouclier.
		
		Joueur p1 = new Joueur(1);
		int x;int y; int rota;
		boolean poser=false;
		Scanner sc = new Scanner(System.in);
		while(!poser){
			 x = sc.nextInt();
			 y = sc.nextInt();
			rota = sc.nextInt();
			if (rota==1 || rota==-1){
				t1.rotation(rota);
			}
			
			if(t1.verifPoseTuileLegale(r,x,y)){	
				t1.poseTuile(r, x, y);
				poser=true;
				System.out.println("tuile1 posée");
			} 
			else {System.out.println("tuile1 non posée");	}
		}
		System.out.println("Voulez-vous poser un pion, si oui indiquer sa position (0,1,2,3,4) sinon 5");
		int choix = sc.nextInt();
		if(choix>4){
			System.out.println("Pion non posé");
		}
		else{Evaluation pionT = new Evaluation(t1,r,choix);
			if(t1.verifPosePionLegale(pionT)){
				System.out.println("Pion légale");
				t1.posePion(p1,choix);
			}
		}
		// Tuile 15 : Ville au nord et ville au sud (disjointes et sans bouclier), champs au centre, est et ouest (joints) (x3).
		Tuile t2 = new Tuile(
				new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS}, // Caractéristiques des bords.
				new boolean [] {false, false, true, true, false, false, true, true}, // Présence des champs.
				new boolean [][] { // Tableau de connexité des caractéristiques.
						{false}, 
						{false, false}, 
						{false, false, false}, 
						{false, false, false, false}},
				new boolean [][] { // Tableau de connexité des champs.
						{false},
						{false, false},
						{false, false, true},
						{false, false, false, false},
						{false, false, false, false, false},
						{false, false, true , true , false, false},
						{false, false, true , true , false, false, true}},
				5); // Position du bouclier.
		
		x = sc.nextInt();
		y = sc.nextInt();

		if(t2.verifPoseTuileLegale(r,x,y)){		
			t2.poseTuile(r, x, y);
			System.out.println("tuile2 posée");
		} else {
			System.out.println("tuile2 non posée");
		}
		
		System.out.println("Voulez-vous poser un pion, si oui indiquer sa position (0,1,2,3,4) sinon 5");
		choix = sc.nextInt();
		if(choix>4){
			System.out.println("Pion non posé");
		}
		else{Evaluation pionT = new Evaluation(t2,r,choix);
			if(t1.verifPosePionLegale(pionT)){
				t1.posePion(p1,choix);
			}
		}

		
		Evaluation e = new Evaluation(r.getTuile(100,100),r,0);
		/*boolean [][] connex = e.t.getConnexitéBordure();
		System.out.println(connex[1][0]);
		System.out.println(connex[2][0]);
		System.out.println(connex[3][0]);*/
		System.out.println("000");
		ArrayList<Tuile>c=e.evalConstruction();
		System.out.println("000");
		System.out.println(e.valeurVille(c));
	}

}
