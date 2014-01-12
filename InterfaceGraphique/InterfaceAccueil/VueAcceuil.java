public void evaluationFinDePartie(){
		Tuile t; int pos; Evaluation eval; ArrayList<Tuile> construction; 
		int posCarac=0; ArrayList<Joueur> winner;
		for(int i=0;i<Joueur.getNbJoueurs();i++){
			while(Joueur.getJoueur(i).getTabPions().size()>0){
				
				t = Joueur.getJoueur(i).getTabPions().get(0).getTuile();
				pos = Joueur.getJoueur(i).getTabPions().get(0).getPositionSurTuile();
				eval = new Evaluation(t,plateau,pos);
				construction=eval.evalConstructionFinDePartie();
				
				if(pos==12){posCarac=0;} if(pos==3){posCarac=1;} if(pos==6){posCarac=2;} if(pos==9){posCarac=3;} if(pos==0){posCarac=4;}
				
				if(t.getCarac(posCarac)==Terrain.ABBAYE){
					eval.evalAbbayeFinPartie();
				}
				
				if(t.getCarac(posCarac)==Terrain.VILLE){
					winner= eval.getMajorité(Joueur.getListJoueur());
					for(int j=0;j<winner.size();j++){
						winner.get(j).ajoutPoints(eval.valeurVilleFinDePartie(construction));
					}
				}
				if(t.getCarac(posCarac)==Terrain.ROUTE){
					winner= eval.getMajorité(Joueur.getListJoueur());
					for(int j=0;j<winner.size();j++){
						winner.get(j).ajoutPoints(eval.valeurRoute(construction));
					}
				}
			}
		}
	}