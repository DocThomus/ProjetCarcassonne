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
				
				//Tuile 22 : Route au sud et à l'ouest (joints), champs au nord et à l'est (x9).
				Tuile t7 = new Tuile(
						new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE, Terrain.CHAMPS}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{false, false, true}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{true},
								{true , true},
								{true , true , true},
								{true , true , true , true},
								{false, false, false, false, false},
								{false, false, false, false, false, true},
								{true , true , true , true , true , false, false}},
						5);
				
				Tuile t71 = new Tuile(
						new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE, Terrain.CHAMPS}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{false, false, true}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{true},
								{true , true},
								{true , true , true},
								{true , true , true , true},
								{false, false, false, false, false},
								{false, false, false, false, false, true},
								{true , true , true , true , true , false, false}},
						5);
				
				Tuile t72 = new Tuile(
						new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE, Terrain.CHAMPS}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{false, false, true}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{true},
								{true , true},
								{true , true , true},
								{true , true , true , true},
								{false, false, false, false, false},
								{false, false, false, false, false, true},
								{true , true , true , true , true , false, false}},
						5);
				
				Tuile t73 = new Tuile(
						new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.ROUTE, Terrain.CHAMPS}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{false, false, true}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{true},
								{true , true},
								{true , true , true},
								{true , true , true , true},
								{false, false, false, false, false},
								{false, false, false, false, false, true},
								{true , true , true , true , true , false, false}},
						5);
				
				// Tuile 21 : Route au nord, centre et au sud (joints), champs à l'ouest et à l'est (x8).
				Tuile t8 = new Tuile(
						new Terrain [] {Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{true , false}, 
								{false, false, false}, 
								{true , false, true , false}},
						new boolean [][] { // Tableau de connexité des champs.
								{false},
								{false, true},
								{false, true , true},
								{false, true , true , true},
								{true , false, false, false, false},
								{true , false, false, false, false, true},
								{true , false, false, false, false, true , true}},
						5);
				
				Tuile t81 = new Tuile(
						new Terrain [] {Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{true , false}, 
								{false, false, false}, 
								{true , false, true , false}},
						new boolean [][] { // Tableau de connexité des champs.
								{false},
								{false, true},
								{false, true , true},
								{false, true , true , true},
								{true , false, false, false, false},
								{true , false, false, false, false, true},
								{true , false, false, false, false, true , true}},
						5);
				
				Tuile t82 = new Tuile(
						new Terrain [] {Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ROUTE}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{true , false}, 
								{false, false, false}, 
								{true , false, true , false}},
						new boolean [][] { // Tableau de connexité des champs.
								{false},
								{false, true},
								{false, true , true},
								{false, true , true , true},
								{true , false, false, false, false},
								{true , false, false, false, false, true},
								{true , false, false, false, false, true , true}},
						5);
				
				// Tuile 2 : Abbaye entourée de champs, avec une route au sud (x2).
				Tuile t9 = new Tuile(
						new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ABBAYE}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{false, false, false}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{true},
								{true , true},
								{true , true , true},
								{true , true , true , true},
								{true , true , true , true , true},
								{true , true , true , true , true , true},
								{true , true , true , true , true , true , true}},
						5); 
				
				Tuile t91 = new Tuile(
						new Terrain [] {Terrain.CHAMPS, Terrain.CHAMPS, Terrain.ROUTE, Terrain.CHAMPS, Terrain.ABBAYE}, // Caractéristiques des bords.
						new boolean [] {true, true, true, true, true, true, true, true}, // Présence des champs.
						new boolean [][] { // Tableau de connexité des caractéristiques.
								{false}, 
								{false, false}, 
								{false, false, false}, 
								{false, false, false, false}},
						new boolean [][] { // Tableau de connexité des champs.
								{true},
								{true , true},
								{true , true , true},
								{true , true , true , true},
								{true , true , true , true , true},
								{true , true , true , true , true , true},
								{true , true , true , true , true , true , true}},
						5); 
		
				
		
		Joueur p1 = new Joueur(1);
		Joueur p2 = new Joueur(2);
		Joueur p3 = new Joueur(3);
		int x;int y; int rota; int i=0;
		Scanner sc = new Scanner(System.in);
		
		/*
		//BLOC TEST ABBAYE
		t7.poseTuile(r,101,100);
		
		t71.rotation(1);
		t71.rotation(1);
		t71.rotation(1);
		t71.poseTuile(r,99,100);
		
		t8.rotation(1);
		t8.poseTuile(r, 99, 99);
		
		t81.rotation(1);
		t81.poseTuile(r, 101, 99);
		
		t73.rotation(1);
		t73.rotation(1);
		t73.poseTuile(r, 99, 98);
		
		t72.rotation(1);
		t72.poseTuile(r, 100, 98);
		
		t9.poseTuile(r, 100, 99);
		t9.posePion(p1, 4);
		
		t82.rotation(1);
		t82.poseTuile(r, 101, 98);
		
		t91.rotation(1);
		t91.poseTuile(r, 101, 101);
		t91.posePion(p1, 4);
		
		Evaluation e = new Evaluation(r.getTuile(100,100),r,4);
		ArrayList<Evaluation> abb = e.verifPresenceAbbaye();
		for(i=0;i<abb.size();i++){
			int res=abb.get(i).evalAbbaye();
			//int res=abb.get(i).evalAbbayeFinPartie(); // Teste en fin de partie pour l'abbaye imcompléte
			System.out.println(res);
		}
		*/
		// FIN BLOC ABBAYE
		
		
		//BLOC TEST ROUTE 
		/*
		if(t71.verifPoseTuileLegale(r, 101, 100)){
		t7.poseTuile(r,101,100);
		System.out.println("tuile ok");}
		Evaluation pionT = new Evaluation(t7,r,3);
		if(t7.verifPosePionLegale(pionT)){
			System.out.println("Pion légale 1");
			t7.posePion(p1,3);
		}
		
		t71.rotation(1);
		t71.rotation(1);
		t71.rotation(1);
		if(t71.verifPoseTuileLegale(r, 99, 100)){
		t71.poseTuile(r,99,100);
		System.out.println("tuile ok");
		}
		pionT = new Evaluation(t71,r,2);
		if(t71.verifPosePionLegale(pionT)){
			System.out.println("Pion légale 2");
			t71.posePion(p2,2);
		}	
			
		t72.rotation(1);
		t72.poseTuile(r,101,99);
		pionT = new Evaluation(t72,r,0);
		if(t72.verifPosePionLegale(pionT)){
			System.out.println("Pion légale 3");
			t72.posePion(p3,0);}
		
		t73.rotation(1);
		t73.rotation(1);
		t73.poseTuile(r,99,99);
		
		t8.rotation(1); 
		t8.poseTuile(r,100,99);
		
		Evaluation e = new Evaluation(r.getTuile(100,100),r,4);
		System.out.println("Evaluation de la Construction : ");
		ArrayList<Tuile>c=e.evalConstruction();
		//ArrayList<Tuile>c=e.evalConstructionFinDePartie(); // Pour tester l'évaluation d'une route imcompléte
		System.out.println("Valeur : " + e.valeurRoute(c) );
		
		ArrayList<Joueur> winner=e.getMajorité(Joueur.listJoueur);
		System.out.println("nb de winner : " + winner.size() );
		for(int j=0;j<winner.size();j++){
			winner.get(j).ajoutPoints(e.valeurRoute(c));
		}
		*/
		// FIN BLOC ROUTE
		
		
	
	 	//**************************** BLOC TEST VILLE 
		/*
		t2.rotation(1);
		t2.poseTuile(r, 100, 99);
		Evaluation pionT = new Evaluation(t2,r,3);
		if(t2.verifPosePionLegale(pionT)){
			System.out.println("Pion légale 1");
			t2.posePion(p1,3);}
		
		t3.rotation(1);
		t3.rotation(1);
		t3.rotation(1);
		t3.poseTuile(r, 101, 99);
		pionT = new Evaluation(t3,r,3);
		if(t3.verifPosePionLegale(pionT)){
			System.out.println("Pion légale 2");
			t3.posePion(p2,3);}
		
		t4.rotation(1);
		t4.rotation(1);
		t4.poseTuile(r, 99, 99);
		pionT = new Evaluation(t4,r,1);
		if(t4.verifPosePionLegale(pionT)){
			System.out.println("Pion légale 3");
			t4.posePion(p3,1);}
		
		t5.rotation(1);
		t5.poseTuile(r, 99, 98);
		
		t6.poseTuile(r, 101, 98);
		
		t1.rotation(1);
		t1.poseTuile(r, 100, 98);
		
		Evaluation e = new Evaluation(r.getTuile(99,98),r,1);
		System.out.println("Evaluation de la Construction : ");
		ArrayList<Tuile>c=e.evalConstruction();
		System.out.println("Valeur : " + e.valeurVille(c) );
		
		ArrayList<Joueur> winner=e.getMajorité(Joueur.listJoueur);
		System.out.println("nb de winner : " + winner.size() );
		for(int j=0;j<winner.size();j++){
			winner.get(j).ajoutPoints(e.valeurVille(c));
		}
		*/
	
	//**************** FIN BLOC VILLE
	
		
		
		
		 // BLOC TOUR TYPE En cours
		 /*
		 	int tour=0;//initialisation avant début du jeu puis incrémente enfin de tour
		 	
			Tuile tp=p.piocheAleatoire();
			Joueur player = Joueur.listJoueur.get(tour);
		
			boolean poser=false;
			while(!poser){
				System.out.println("Entrez les coordonnées de la tuile à placer");
				 x = sc.nextInt();
				 y = sc.nextInt();
				 System.out.println("Voulez-vous faire pivoter la tuile ? (1= oui)");
				rota = sc.nextInt();
				if (rota==1){
					tp.rotation(rota);
				}
				
				if(tp.verifPoseTuileLegale(r,x,y)){	
					tp.poseTuile(r, x, y);
					poser=true;
					System.out.println("tuile posée");
				} 
				else {System.out.println("tuile non posée");}
			}
			
			System.out.println("Voulez-vous poser un pion, si oui indiquer sa position (0,1,2,3,4) sinon 5");
			int choix = sc.nextInt();
			if(choix>4){
				System.out.println("Pion non posé");
			}
			else{Evaluation pionT = new Evaluation(tp,r,choix);
				if(tp.verifPosePionLegale(pionT)){
					System.out.println("Pion légale");
					tp.posePion(p1,choix);
				}	
			}
			
			for(i)
	*/
		
		
	} // fin main

} // fin classe
