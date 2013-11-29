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
						{true, false}, 
						{false, false , false}, 
						{true, false , true, false}},
				new boolean [][] { // Tableau de connexité des champs.
						{false},
						{false, false},
						{false, false, true},
						{false, false, false, false},
						{false, false, false, false, false},
						{false, false, false, false, false, false},
						{false, false, false, false, false, false, true}},
				5); // Position du bouclier.
		
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
		
				Tuile t3 = new Tuile(new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS}, // Caractéristiques des bords.
						new boolean [] {false, false, true, true, true, true, false, false}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{true , false, false}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{false},
								{false, false},
								{false, false, true},
								{false, false, true , true},
								{false, false, true , true , true},
								{false, false, false, false, false, false},
								{false, false, false, false, false, false, false}},
						5); // Position du bouclier.
						
				Tuile t4 = new Tuile(new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS}, // Caractéristiques des bords.
						new boolean [] {false, false, true, true, true, true, false, false}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{true , false, false}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{false},
								{false, false},
								{false, false, true},
								{false, false, true , true},
								{false, false, true , true , true},
								{false, false, false, false, false, false},
								{false, false, false, false, false, false, false}},
						5); // Position du bouclier.
						
				Tuile t5 = new Tuile(new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS}, // Caractéristiques des bords.
						new boolean [] {false, false, true, true, true, true, false, false}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{true , false, false}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{false},
								{false, false},
								{false, false, true},
								{false, false, true , true},
								{false, false, true , true , true},
								{false, false, false, false, false, false},
								{false, false, false, false, false, false, false}},
						5); // Position du bouclier.
						
				Tuile t6 = new Tuile(new Terrain [] {Terrain.VILLE, Terrain.CHAMPS, Terrain.CHAMPS, Terrain.VILLE, Terrain.CHAMPS}, // Caractéristiques des bords.
						new boolean [] {false, false, true, true, true, true, false, false}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{true , false, false}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{false},
								{false, false},
								{false, false, true},
								{false, false, true , true},
								{false, false, true , true , true},
								{false, false, false, false, false, false},
								{false, false, false, false, false, false, false}},
						5); // Position du bouclier.
		
		
		Joueur p1 = new Joueur(1);
		int x;int y; int rota; int i=0;
		Scanner sc = new Scanner(System.in);
		Tuile [] tab = new Tuile [10];
		tab[0]=t2;
		tab[1]=t3;
		tab[2]=t4;
		tab[3]=t5;
		tab[4]=t6;
		tab[6]=t1;
		
		/*t2.rotation(1);
		t2.poseTuile(r, 100, 99);
		
		t3.rotation(1);
		t3.rotation(1);
		t3.rotation(1);
		t3.poseTuile(r, 101, 99);
		
		t4.rotation(1);
		t4.rotation(1);
		t4.poseTuile(r, 99, 99);
		
		t5.rotation(1);
		t5.poseTuile(r, 99, 98);
		
		t6.poseTuile(r, 101, 98);
		
		t1.rotation(1);
		t1.poseTuile(r, 100, 98);
		*/
		
		t1.poseTuile(r, 100, 101);
		t2.poseTuile(r, 100, 102);
		
		
		/*while(tab[i]!=null){
		
			boolean poser=false;
			while(!poser){
				System.out.println("Entrez les coordonnées de la tuile à placer");
				 x = sc.nextInt();
				 y = sc.nextInt();
				rota = sc.nextInt();
				if (rota==1 || rota==-1){
					tab[i].rotation(rota);
				}
				
				if(tab[i].verifPoseTuileLegale(r,x,y)){	
					tab[i].poseTuile(r, x, y);
					poser=true;
					System.out.println("tuile " +i+ " posée");
				} 
				else {System.out.println("tuile " +i+ " non posée");}
			}
			
			System.out.println("Voulez-vous poser un pion, si oui indiquer sa position (0,1,2,3,4) sinon 5");
			int choix = sc.nextInt();
			if(choix>4){
				System.out.println("Pion non posé");
			}
			else{Evaluation pionT = new Evaluation(tab[i],r,choix);
				if(tab[i].verifPosePionLegale(pionT)){
					System.out.println("Pion légale");
					tab[i].posePion(p1,choix);
				}	
			}
			i++;
		}// fin boucle
		*/
		
		Evaluation e = new Evaluation(r.getTuile(100,100),r,0);
		/*boolean [][] connex = e.t.getConnexitéBordure();
		System.out.println(connex[1][0]);
		System.out.println(connex[2][0]);
		System.out.println(connex[3][0]);*/
		System.out.println("Evaluation de la Construction : ");
		ArrayList<Tuile>c=e.evalConstruction();
		System.out.println("Valeur : " + e.valeurVille(c) );
	}

}
