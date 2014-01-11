package Noyau;
import java.util.ArrayList;


public class Evaluation {
	private Tuile t;
	private Plateau p;
	private int position; // Dans l'Evaluation c'est la position sur t de la caract�ristique qui nous int�resse.
	
	public Evaluation (Tuile t, Plateau p, int pos){
		this.t=t;
		this.p=p;
		this.position=pos;
	}
	
	public Tuile getT(){
		return t;
	}
	public int getPosition(){
		return position;
	}
	
	
	//***************BLOC ABBAYE**************************
	public ArrayList<Evaluation> verifPresenceAbbaye() {
		// A utiliser sur une tuile qui vient d'�tre pos�e pour avoir la liste de toutes les abbayes qui pourraient devenir compl�tes gr�ce � cette tuile.
		// Action : Renvoie la liste des tuiles adjacentes contenant une abbaye, y compris elle-m�me si c'est le cas.
		ArrayList<Evaluation> TuileAbbaye = new ArrayList<Evaluation>();
		int x= t.getX(); // Pour simplifier la lecture de la suite.
		int y= t.getY();
		
		if (t.getCarac(4)==Terrain.ABBAYE ){TuileAbbaye.add(new Evaluation(t,p,4));}
		
		if (!p.isEmpty(x-1,y+1) && p.getTuile(x-1,y+1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(new Evaluation(p.getTuile(x-1, y+1),p,4));}
		if (!p.isEmpty(x,y+1) && p.getTuile(x,y+1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(new Evaluation(p.getTuile(x, y+1),p,4));}
		if (!p.isEmpty(x+1,y+1) && p.getTuile(x+1,y+1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(new Evaluation(p.getTuile(x+1, y+1),p,4));}
		
		if (!p.isEmpty(x-1,y) && p.getTuile(x-1,y).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(new Evaluation(p.getTuile(x-1, y),p,4));}
		if (!p.isEmpty(x+1,y) && p.getTuile(x+1,y).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(new Evaluation(p.getTuile(x+1, y),p,4));}
		
		if (!p.isEmpty(x-1,y-1) && p.getTuile(x-1,y-1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(new Evaluation(p.getTuile(x-1, y-1),p,4));}
		if (!p.isEmpty(x,y-1) && p.getTuile(x,y-1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(new Evaluation(p.getTuile(x, y-1),p,4));}
		if (!p.isEmpty(x+1,y-1) && p.getTuile(x+1,y-1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(new Evaluation(p.getTuile(x+1, y-1),p,4));}
		
		return TuileAbbaye;
	}
	
	public void evalAbbaye(){
		// pr�-requis : tuile avec un pion sur une abbaye, en cours de partie
		// action : ajoute 9 et retire le pion si l'abaye est compl�te, 0 sinon 
		int x= t.getX(); // Pour simplifier la lecture de la suite.
		int y= t.getY();
		if(this.t.getPionPlac�()!=null){
			if ( !p.isEmpty(x-1,y+1) && !p.isEmpty(x,y+1) && !p.isEmpty(x+1,y+1) && !p.isEmpty(x+1,y) && !p.isEmpty(x+1,y-1) && !p.isEmpty(x,y-1) && !p.isEmpty(x-1,y-1) && !p.isEmpty(x-1,y)){
				this.t.getPionPlac�().getProprio().ajoutPoints(9);
				this.t.getPionPlac�().liberePion();
			}
		}
	}
	
	public void evalAbbayeFinPartie(){
		// pr�-requis : tuile avec un pion sur une abbaye, en fin de partie
		// action : retourne la valeur d'une abbaye en fin de partie, et retire le pion.
		int x= t.getX(); // Pour simplifier la lecture de la suite.
		int y= t.getY();
		if(this.t.getPionPlac�()!=null){
			int res=1; 
			if ( !p.isEmpty(x-1,y+1) ){ res++;}
			if ( !p.isEmpty(x,y+1) ){ res++;}
			if ( !p.isEmpty(x+1,y+1) ){ res++;}
			if ( !p.isEmpty(x+1,y) ){ res++;}
			
			if ( !p.isEmpty(x+1,y-1) ){ res++;}
			if ( !p.isEmpty(x,y-1) ){ res++;}
			if ( !p.isEmpty(x-1,y-1) ){ res++;}
			if ( !p.isEmpty(x-1,y) ){ res++;}
			
			this.t.getPionPlac�().getProprio().ajoutPoints(res);
			this.t.getPionPlac�().liberePion();
		}
	}
	//***************FIN BLOC ABBAYE**************************
	
	public int valeurRoute(ArrayList<Tuile>route){
		int res=0;
		for(int i=0;i<route.size();i++){
			res++;
		}
		return res;
	}
	
	public int valeurVille(ArrayList<Tuile>ville){
		int res=0;
		for(int i=0;i<ville.size();i++){
			res=res+2;
			if(ville.get(i).getBouclier()!=5){
				res=res+2;
			}
		}
		return res;
	}
	
	public int valeurVilleFinDePartie(ArrayList<Tuile>ville){
		int res=0;
		for(int i=0;i<ville.size();i++){
			res=res+1;
			if(ville.get(i).getBouclier()!=5){
				res=res+1;
			}
		}
		return res;
	}
	
	public ArrayList<Tuile> evalConstructionFinDePartie(){
		ArrayList<Evaluation> eval = this.evalPosePion();
		ArrayList<Tuile> construction = new ArrayList<Tuile>();
		
		for(int i=0;i<eval.size();i++){ 
			if(!construction.contains(eval.get(i).t)){
				construction.add(eval.get(i).t);
			}
		}
		return construction;
	}
	
	
	public ArrayList<Tuile> evalConstruction(){
		// Renvoie la liste de Tuile composant la construction(route ou ville) qui est situ� sur t.getCarac(position), si la construction est termin�e.
		// Sinon renvoie une liste vide.
		ArrayList<Evaluation>dejaVus = new ArrayList<Evaluation>();
		ArrayList<Evaluation>frontiere= new ArrayList<Evaluation>();
		boolean fini=false;
		boolean impossible=false;
		frontiere.add(0,this);
		dejaVus.add(0,this);
		ArrayList<Evaluation> fils;
		ArrayList<Tuile>construction=new ArrayList<Tuile>();

		while(!fini && !impossible){
			fils=frontiere.get(0).genereFils();
			
			if(!frontiere.isEmpty()){
				if(fils.isEmpty()){impossible=true;
				System.out.println("La construction n'est pas termin�e");
				} // Si il y a encore des Evaluation dans frontiere mais aucun fils g�n�r�, alors la construction est imcompl�te
				else{frontiere.get(0).ajoutEtMaj(dejaVus,frontiere,fils);}// ajoute les fils dans frontiere et dejaVus, retire le p�re de frontiere
			} 			
			if(frontiere.isEmpty()){fini=true;}
			//**TEST pour voir les changement
			//System.out.println("fils : "+fils.size());System.out.println("dejaVus : "+dejaVus.size());System.out.println("frontiere fin : "+frontiere.size());System.out.println("fini : "+ fini + ", impossible : " +impossible);System.out.println("------");
			//**TEST
		}
			
		if(!impossible){
				// La boucle suivante met les Tuile des Evaluation de dejaVus dans construction, en �liminant les tuiles en double parmis les Evaluation 	
			for(int i=0;i<dejaVus.size();i++){ 
				if(!construction.contains(dejaVus.get(i).t)){
					construction.add(dejaVus.get(i).t);
				}
			}			
		}
		System.out.println("construction : "+construction.size());
		return construction;
	}
	
	
	
	public void ajoutEtMaj (ArrayList<Evaluation>dejaVus, ArrayList<Evaluation>frontiere, ArrayList<Evaluation>fils){
		// Ajoute dans dejaVus et frontiere les Evaluation de fils qui sont pas d�ja, et retire le p�re de frontiere.
		boolean trouve =false;
		for (int i = 0; i < fils.size(); i++) { // Pour chaque Evaluation dans fils...
			trouve=false;
			for(int j=0; j<dejaVus.size();j++){// et pour chaque Evaluation dans dejaVus...
				if( fils.get(i).equals(dejaVus.get(j)) ){  // ... on v�rifie si le fils est dans dejaVus
					trouve=true;
				}
			}
			if(!trouve){dejaVus.add(fils.get(i)); // Si il n'y �tait pas on l'ajoute a dejaVus et frontiere
			frontiere.add(fils.get(i));}
		}
		frontiere.remove(this);
	}
	
	public boolean equals(Evaluation e){
		return (this.t.equals(e.t) && this.position==e.position );
	}
	
	
	public ArrayList<Evaluation> genereFils(){
		// Action : Renvoie les Evaluation fils si elles existent toutes, sinon renvoie un ArrayList vide
		boolean [][] connex = t.getConnexit�Bordure();
		int x= t.getX(); // Pour simplifier la lecture de la suite.
		int y= t.getY();
		boolean existe=true;
		ArrayList<Evaluation>fils = new ArrayList<Evaluation>();
		
		if(position==0){ // On s'int�resse a la caract�ristique au Nord de la Tuile.
			
			if(p.isEmpty(x, y+1)){existe=false;} // Si la tuile au dessus n'existe pas c'est que la construction n'est pas fini.
			else{fils.add(new Evaluation(p.getTuile(x, y+1),p,2));} // Sinon on l'ajoute aux fils
			
			// Il faut faire de m�me avec d'autres caract�ristiques si elles �taient connect� a position :
			if(connex[0][0]){ 
				//System.out.println("connection haut gauche");
				if(p.isEmpty(x+1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x+1, y),p,3));}
			}	
			if(connex[1][0]){
				//System.out.println("connection haut bas");
				if(p.isEmpty(x, y-1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y-1),p,0));}
			}
			if(connex[2][0]){
				//System.out.println("connection haut droite");
				if(p.isEmpty(x-1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x-1, y),p,1));}
			}
			if(connex[3][0]){
				//System.out.println("connection avec le centre") : inutile pour l'�valuation des construction mais important pour rep�rer les pions pr�sent sur une m�me construction
				fils.add(new Evaluation(p.getTuile(x, y),p,4));
			}
			
		}
		
		if(position==1){
			if(p.isEmpty(x+1, y)){existe=false;}
			else{fils.add(new Evaluation(p.getTuile(x+1, y),p,3));}
			
			if(connex[0][0]){
				if(p.isEmpty(x, y+1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y+1),p,2));}}
	
			if(connex[1][1]){
				if(p.isEmpty(x, y-1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y-1),p,0));}}
			
			if(connex[2][1]){
				if(p.isEmpty(x-1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x-1, y),p,1));}}
			if(connex[3][1]){
				fils.add(new Evaluation(p.getTuile(x, y),p,4));
			}
			
		}
		
		if(position==2){
			if(p.isEmpty(x, y-1)){existe=false;}
			else{fils.add(new Evaluation(p.getTuile(x, y-1),p,0));}
			
			if(connex[1][0]){
				if(p.isEmpty(x, y+1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y+1),p,2));}}
	
			if(connex[1][1]){
				if(p.isEmpty(x+1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x+1, y),p,3));}}
			
			if(connex[2][2]){
				if(p.isEmpty(x-1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x-1, y),p,1));}}
			if(connex[3][2]){
				fils.add(new Evaluation(p.getTuile(x, y),p,4));
			}
		}
		
		if(position==3){
			if(p.isEmpty(x-1, y)){existe=false;}
			else{fils.add(new Evaluation(p.getTuile(x-1, y),p,1));}
			
			if(connex[2][0]){
				if(p.isEmpty(x, y+1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y+1),p,2));}}
	
			if(connex[2][1]){
				if(p.isEmpty(x+1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x+1, y),p,3));}}
			
			if(connex[2][2]){
				if(p.isEmpty(x, y-1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y-1),p,0));}}
			if(connex[3][3]){
				fils.add(new Evaluation(p.getTuile(x, y),p,4));
			}
		}
		
		if(position==4){
			fils.add(this);
			if(connex[3][0]){fils.add(new Evaluation(p.getTuile(x, y),p,0));}
			if(connex[3][1]){fils.add(new Evaluation(p.getTuile(x, y),p,1));}
			if(connex[3][2]){fils.add(new Evaluation(p.getTuile(x, y),p,2));}
			if(connex[3][3]){fils.add(new Evaluation(p.getTuile(x, y),p,3));}
			
		}
		
		if(existe){ return fils; }
		else return new ArrayList<Evaluation>();
		
	}
	
	///****Bloc concernant les Evaluation utilis� pour la gestion des pions, il s'agit parfois de fonction presque identique � celle utilis�e pour les construction  
	
	
	public ArrayList<Joueur>getMajorit�(ArrayList<Joueur> player){
	// Renvoie la liste du(ou des) joueur(s) ayant la majorit� des pions sur une construction achev�. Et retire les pions.
		ArrayList<Evaluation> evalPosePion = this.evalPosePion();
		System.out.println("evalPosePion : " + evalPosePion.size());
		ArrayList<Joueur> winner = new ArrayList<Joueur>();
		int [] nbpion= new int [player.size()];
		for(int i=0;i<evalPosePion.size();i++){
			if(evalPosePion.get(i).getT().getPionPlac�()!=null){ //Si il y a un pion sur cette tuile ...
				if(evalPosePion.get(i).t.getPionPlac�().getPositionSurTuile()==evalPosePion.get(i).getPosition()){ // Pour ne pas comptabiliser un pion qui serait sur la tuile mais pas dans la construction qui nous int�resse
					nbpion[evalPosePion.get(i).getT().getPionPlac�().getProprio().getIdentifiant()-1]++; // +1 dans la case du tableau ayant le m�me num�ro que l'id du joueur.
					evalPosePion.get(i).getT().getPionPlac�().liberePion(); // retire le pion.
				}
			}
		}
		
		int max=1; // Pour �viter que, si une construction est �valu� alors qu'il n'y a pas de pion, les point soient ajouter � tous les joueurs
		for(int i=0;i<nbpion.length;i++){ // trouve quel est le plus haut nombre de pion pour un m�me joueur.
			if(nbpion[i]>max){max=nbpion[i];}
			i++;
		}
		
		for(int i=0;i<player.size();i++){
			if(nbpion[player.get(i).getIdentifiant()-1]==max){
				winner.add(player.get(i));
			}
		}
		
		for(int i =0;i<nbpion.length;i++){
			System.out.println("tableau pion : " +nbpion[i]);
		}
		return winner;
	}
	
	
	
	public ArrayList<Evaluation> evalPosePion(){
		// Renvoie la liste des evaluation composant la construction(route ou ville) qui est situ�e sur this.t.getCarac(position)
		// Contrairement a evalConstruction, on ne s'arr�te pas quand il manque un voisin � une tuile. Le boolean "impossible" et tout ce qui va avec est donc retir�.
		// De plus on conserve position ce qui permet de v�rifier la pr�sence de pion.
		// Les Evaluations renvoy�es peuvent aussi servir en fin de jeu pour les construction imcompl�te.
		ArrayList<Evaluation> dejaVus = new ArrayList<Evaluation>();
		ArrayList<Evaluation> frontiere= new ArrayList<Evaluation>();
		boolean fini = false;
		frontiere.add(0,this);
		dejaVus.add(0,this);
		ArrayList<Evaluation> fils;

		while(!fini ){
			fils=frontiere.get(0).genereFilsPion();
			frontiere.get(0).ajoutEtMaj(dejaVus,frontiere,fils);
			if(frontiere.isEmpty()){fini=true;}
		}
		return dejaVus;
	}
	
	public ArrayList<Evaluation> genereFilsPion(){
		// Action : Renvoie les Evaluation fils  
		// Contrairement a genereFils, le boolean existe ne sert plus a rien puisqu'on veut conna�tre les Evaluation d'une construction m�me si elle n'est pas fini (pour savoir si il y a d�j� des pions dessus).
		boolean [][] connex = t.getConnexit�Bordure();
		int x= t.getX(); // Pour simplifier la lecture de la suite.
		int y= t.getY();
		ArrayList<Evaluation>fils = new ArrayList<Evaluation>();
		
		//if(position==0){ // On s'int�resse a la caract�ristique au Nord de la Tuile.
		if(position==12){ // On s'int�resse a la caract�ristique au Nord de la Tuile. 12 et non 0 par rapport a la fa�on d'organiser les bonton voir la classe : VuePlateau
			
			if(!p.isEmpty(x, y+1)){
			fils.add(new Evaluation(p.getTuile(x, y+1),p,6));} 
			
			// Il faut faire de m�me avec d'autres carac�ristiques si elles �taient connect� a position :
			if(connex[0][0]){ 
				//System.out.println("connection haut gauche");
				if(!p.isEmpty(x+1, y)){
				fils.add(new Evaluation(p.getTuile(x+1, y),p,9));}
			}	
			if(connex[1][0]){
				//System.out.println("connection haut bas");
				if(!p.isEmpty(x, y-1)){
				fils.add(new Evaluation(p.getTuile(x, y-1),p,12));}
			}
			if(connex[2][0]){
				//System.out.println("connection haut droite");
				if(!p.isEmpty(x-1, y)){
				fils.add(new Evaluation(p.getTuile(x-1, y),p,3));}
			}
			if(connex[3][0]){
				//System.out.println("connection avec le centre") : inutile pour l'�valuation des construction mais important pour rep�rer les pions pr�sent sur une m�me construction
				fils.add(new Evaluation(p.getTuile(x, y),p,0));
			}
			
		}
		
		//if(position==1){
		if(position==3){
			
			if(!p.isEmpty(x+1, y)){
			fils.add(new Evaluation(p.getTuile(x+1, y),p,9));}
			
			if(connex[0][0]){
				if(!p.isEmpty(x, y+1)){
				fils.add(new Evaluation(p.getTuile(x, y+1),p,6));}}
	
			if(connex[1][1]){
				if(!p.isEmpty(x, y-1)){
				fils.add(new Evaluation(p.getTuile(x, y-1),p,12));}}
			
			if(connex[2][1]){
				if(!p.isEmpty(x-1, y)){
				fils.add(new Evaluation(p.getTuile(x-1, y),p,3));}}
			if(connex[3][1]){
				fils.add(new Evaluation(p.getTuile(x, y),p,0));
			}
			
		}
		
		//if(position==2){
		if(position==6){
			if(!p.isEmpty(x, y-1)){
			fils.add(new Evaluation(p.getTuile(x, y-1),p,12));}
			
			if(connex[1][0]){
				if(!p.isEmpty(x, y+1)){
				fils.add(new Evaluation(p.getTuile(x, y+1),p,6));}}
	
			if(connex[1][1]){
				if(!p.isEmpty(x+1, y)){
				fils.add(new Evaluation(p.getTuile(x+1, y),p,9));}}
			
			if(connex[2][2]){
				if(!p.isEmpty(x-1, y)){
				fils.add(new Evaluation(p.getTuile(x-1, y),p,3));}}
			if(connex[3][2]){
				fils.add(new Evaluation(p.getTuile(x, y),p,0));
			}
		}
		
		//if(position==3){
		if(position==9){
			if(!p.isEmpty(x-1, y)){
			fils.add(new Evaluation(p.getTuile(x-1, y),p,3));}
			
			if(connex[2][0]){
				if(!p.isEmpty(x, y+1)){
				fils.add(new Evaluation(p.getTuile(x, y+1),p,6));}}
	
			if(connex[2][1]){
				if(!p.isEmpty(x+1, y)){
				fils.add(new Evaluation(p.getTuile(x+1, y),p,9));}}
			
			if(connex[2][2]){
				if(!p.isEmpty(x, y-1)){
				fils.add(new Evaluation(p.getTuile(x, y-1),p,12));}}
			if(connex[3][3]){
				fils.add(new Evaluation(p.getTuile(x, y),p,0));
			}
		}
		
		//if(position==4){
		if(position==0){
			fils.add(this);
			if(connex[3][0]){fils.add(new Evaluation(p.getTuile(x, y),p,12));}
			if(connex[3][1]){fils.add(new Evaluation(p.getTuile(x, y),p,3));}
			if(connex[3][2]){fils.add(new Evaluation(p.getTuile(x, y),p,6));}
			if(connex[3][3]){fils.add(new Evaluation(p.getTuile(x, y),p,9));}
		}
		return fils; 		
	}
	
	
}// fin de classe
