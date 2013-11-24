import java.util.ArrayList;


public class Evaluation {
	private Tuile t;
	private Plateau p;
	private int position; // Dans l'Evaluation c'est la position de la caractéristique qui nous intéresse.
	
	public Evaluation (Tuile t, Plateau p, int pos){
		this.t=t;
		this.p=p;
		this.position=pos;
	}
	
	
	//***************BLOC ABBAYE**************************
	public ArrayList<Tuile> verifPresenceAbbaye (){
		// A utiliser sur une tuile qui vient d'être posé pour avoir la liste de toute les abbaye qui pourrait devenir compléte grâce à cette tuile.
		// Action : Renvoie la liste des tuiles adjacentes contenant une abbaye, y compris elle-même si c'est le cas.
		ArrayList<Tuile> TuileAbbaye = new ArrayList<Tuile>();
		int x= t.getX(); // Pour simplifier la lecture de la suite.
		int y= t.getY();
		
		if (t.getCarac(4)==Terrain.ABBAYE ){TuileAbbaye.add(t);}
		
		if (!p.isEmpty(x-1,y+1) && p.getTuile(x-1,y+1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(p.getTuile(x-1, y+1));}
		if (!p.isEmpty(x,y+1) && p.getTuile(x,y+1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(p.getTuile(x, y+1));}
		if (!p.isEmpty(x+1,y+1) && p.getTuile(x+1,y+1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(p.getTuile(x+1, y+1));}
		
		if (!p.isEmpty(x-1,y) && p.getTuile(x-1,y).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(p.getTuile(x-1, y));}
		if (!p.isEmpty(x+1,y) && p.getTuile(x+1,y).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(p.getTuile(x+1, y));}
		
		if (!p.isEmpty(x-1,y-1) && p.getTuile(x-1,y-1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(p.getTuile(x-1, y-1));}
		if (!p.isEmpty(x,y-1) && p.getTuile(x,y-1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(p.getTuile(x, y-1));}
		if (!p.isEmpty(x+1,y-1) && p.getTuile(x+1,y-1).getCarac(4)==Terrain.ABBAYE){ TuileAbbaye.add(p.getTuile(x+1, y-1));}
		
		return TuileAbbaye;
	}
	
	public int evalAbbaye(){
		// pré-requis : tuile avec un pion sur une abbaye, en cours de partie
		// action : retourne 9 si l'abaye est compléte, 0 sinon 
		if ( !p.isEmpty(t.getX()-1,t.getY()+1) && !p.isEmpty(t.getX(),t.getY()+1) && !p.isEmpty(t.getX()+1,t.getY()+1) &&
				!p.isEmpty(t.getX()+1,t.getY()) && !p.isEmpty(t.getX()+1,t.getY()-1) && !p.isEmpty(t.getX(),t.getY()-1) &&
				!p.isEmpty(t.getX()-1,t.getY()-1) && !p.isEmpty(t.getX()-1,t.getY() ))
		{return 9;}
		else { return 0;}		
	}
	
	public int evalAbbayeFinPartie(){
		// pré-requis : tuile avec un pion sur une abbaye, en fin de partie
		// action : retourne la valeur d'une abbaye en fin de partie
		int res=1; 
		if ( !p.isEmpty(t.getX()-1,t.getY()+1) ){ res++;}
		if ( !p.isEmpty(t.getX(),t.getY()+1) ){ res++;}
		if ( !p.isEmpty(t.getX()+1,t.getY()+1) ){ res++;}
		if ( !p.isEmpty(t.getX()+1,t.getY()) ){ res++;}
		
		if ( !p.isEmpty(t.getX()+1,t.getY()-1) ){ res++;}
		if ( !p.isEmpty(t.getX(),t.getY()-1) ){ res++;}
		if ( !p.isEmpty(t.getX()-1,t.getY()-1) ){ res++;}
		if ( !p.isEmpty(t.getX()-1,t.getY()) ){ res++;}
		
		return res;
	}
	//***************FIN BLOC ABBAYE**************************
	
	public int valeurRoute(ArrayList<Tuile>route){
		int res=0;
		for(int i=0;i<route.size()-1;i++){
			res++;
		}
		return res;
	}
	
	public int valeurVille(ArrayList<Tuile>ville){
		int res=0;
		for(int i=0;i<ville.size()-1;i++){
			res=res+2;
			if(ville.get(i).getBouclier()!=5){
				res=res+2;
			}
		}
		return res;
	}
	
	public ArrayList<Tuile> evalConstruction(){
		// Renvoie la liste de Tuile composant la construction(route ou ville) qui est situé sur t.getCarac(position), si la construction est terminée.
		// Sinon renvoie une liste vide.
		ArrayList<Evaluation>dejaVus = new ArrayList<Evaluation>();
		ArrayList<Evaluation>frontiere= new ArrayList<Evaluation>();
		boolean fini=false;
		boolean impossible=false;
		frontiere.add(this);
		ArrayList<Evaluation>fils;
		ArrayList<Tuile>construction=new ArrayList<Tuile>();
		
		while(!fini && !impossible){
			fils=frontiere.get(0).genereFils();
			if(!frontiere.isEmpty()){
				if(fils.isEmpty()){impossible=true;}} // Si il y a encore des Evaluation dans frontiere mais aucun fils généré, alors la construction est imcompléte
			else{frontiere.get(0).ajoutEtMaj(dejaVus,frontiere,fils);} // ajoute les fils dans frontiere et dejaVus, retire le pére de frontiere
			if(frontiere.isEmpty()){fini=true;}
		}
		
		if(!impossible){
				// La boucle suivante met les Tuile des Evaluation de dejaVus dans construction, en éliminant les tuiles en double parmis les Evaluation 	
			for(int i=0;i<dejaVus.size()-1;i++){ 
				if(!construction.contains(dejaVus.get(i).t)){
					construction.add(dejaVus.get(i).t);
				}
			}			
		}
		return construction;
		
	}
	
	public void ajoutEtMaj (ArrayList<Evaluation>dejaVus, ArrayList<Evaluation>frontiere, ArrayList<Evaluation>fils){
		// Ajoute dans dejaVus et frontiere les Evaluation de fils qui sont pas déja, et retire le pére de frontiere.
		for (int i = 0; i < fils.size()-1; i++) {
			if(!dejaVus.contains(fils.get(i))){
				dejaVus.add(fils.get(i));
				frontiere.add(fils.get(i));
			}
		}
		frontiere.remove(this);
	}
	
	
	
	public ArrayList<Evaluation> genereFils(){
		// Action : Renvoie les Evaluation fils si elles existent toutes, sinon renvoie un ArrayList vide
		boolean [][] connex = t.getConnexitéBordure();
		int x= t.getX(); // Pour simplifier la lecture de la suite.
		int y= t.getY();
		boolean existe=true;
		ArrayList<Evaluation>fils = new ArrayList();
		
		if(position==0){ // On s'intéresse a la caractéristique au Nord de la Tuile.
			
			if(p.isEmpty(x, y+1)){existe=false;} // Si la tuile au dessus n'existe pas c'est que la construction n'est pas fini.
			else{fils.add(new Evaluation(p.getTuile(x, y+1),p,2));} // Sinon on l'ajoute aux fils
			
			// Il faut faire de même avec d'autres caracéristiques si elles étaient connecté a position :
			if(connex[1][0]){ 
				if(p.isEmpty(x+1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x+1, y),p,3));}
			}	
			if(connex[2][0]){
				if(p.isEmpty(x, y-1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y-1),p,0));}
			}
			if(connex[3][0]){
				if(p.isEmpty(x-1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x-1, y),p,1));}
			}
			
		}
		
		if(position==1){
			if(p.isEmpty(x+1, y)){existe=false;}
			else{fils.add(new Evaluation(p.getTuile(x+1, y),p,3));}
			
			if(connex[1][0]){
				if(p.isEmpty(x, y+1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y+1),p,2));}}
	
			if(connex[2][1]){
				if(p.isEmpty(x, y-1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y-1),p,0));}}
			
			if(connex[3][1]){
				if(p.isEmpty(x-1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x-1, y),p,1));}}
			
		}
		
		if(position==2){
			if(p.isEmpty(x, y-1)){existe=false;}
			else{fils.add(new Evaluation(p.getTuile(x, y-1),p,0));}
			
			if(connex[2][0]){
				if(p.isEmpty(x, y+1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y+1),p,2));}}
	
			if(connex[2][1]){
				if(p.isEmpty(x+1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x+1, y),p,3));}}
			
			if(connex[3][2]){
				if(p.isEmpty(x-1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x-1, y),p,1));}}
		}
		
		if(position==3){
			if(p.isEmpty(x-1, y)){existe=false;}
			else{fils.add(new Evaluation(p.getTuile(x-1, y),p,1));}
			
			if(connex[3][0]){
				if(p.isEmpty(x, y+1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y+1),p,2));}}
	
			if(connex[3][1]){
				if(p.isEmpty(x+1, y)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x+1, y),p,3));}}
			
			if(connex[3][2]){
				if(p.isEmpty(x, y-1)){existe=false;}
				else{fils.add(new Evaluation(p.getTuile(x, y-1),p,0));}}
		}
		
		if(existe){return fils;}
		else return new ArrayList();
		
	}
	
	
	
	
}// fin de classe
