package InterfaceScoreFin;
import java.util.ArrayList;
import java.util.Arrays;

import Noyau.Joueur;
	@SuppressWarnings("unused")
	public class ModeleScoreFin {
	        private ArrayList <Joueur> joueurs;
	       
	        
	        
	        ModeleScoreFin()
	        {   joueurs = new ArrayList();
	        	for(int i = 0; i< Joueur.getNbJoueurs(); i++)
	             {
	        	joueurs.add(Joueur.getJoueur(i));}          // récupération des joueurs en désordre (par rapport au score)
	          ClassementJoueurs(); // le tableau de Joueur est maintenant classé par ordre décroissant de score
	        }
	        
	        
	        
	        public void relancePartie(){
	                //TODO : Code pour relancer une partie
	        }
	        
	        public void quitter(){
	               //TODO : Code pour fermer le jeu
	                }
	        
            public String [] getNomsJoueurs()   // renvoie les noms des Joueurs dans l'ordre décroissant de score
            {    String [] nomsJoueurs = new String [joueurs.size()];
            	for (int i=0; i<joueurs.size(); i++)
            	{nomsJoueurs[i] = joueurs.get(i).getNom();}
            	return nomsJoueurs;
            }	
            	
            public String [] getScoreJoueurs() // renvoie les scores des joueurs dans l'ordre décroissant
            {   String [] scoreJoueurs = new String[joueurs.size()];
               for  (int i=0; i<joueurs.size(); i++)
               {   
                   String s = String.valueOf(joueurs.get(i).getScore());
            	   scoreJoueurs[i] = s;}
            return scoreJoueurs;
            }
            		
           
            

            
	        
	        public int getScore(int id)
	        { return Joueur.getJoueur(id).getScore();
	        }
	        
	        public void ClassementJoueurs() // fait un tri des joueurs en fonction de leur score (ordre décroissant)
	        {  
	           int [] scorejoueurs = new int [joueurs.size()];
	        for(int i = 0; i< joueurs.size(); i++)
	        	{scorejoueurs [i] = joueurs.get(i).getScore();}
	        
	        int interscore = 0; Joueur interJoueur= null;
	        for(int i =0; i<joueurs.size();i++)
	          {for(int j=1; j< joueurs.size()-1; j++)
	              {if (scorejoueurs[j-1] < scorejoueurs[j])
	                  {  interscore = scorejoueurs[j-1];
	                     interJoueur = joueurs.get(j-1);
	                     scorejoueurs[j-1] = scorejoueurs[j];
	                     joueurs.set(j-1, joueurs.get(j));
	                     scorejoueurs[j]= interscore;
	                     joueurs.set(j,interJoueur);
	                  }
	              }
	          } System.out.println(joueurs.toString());
	          }
	          
	        
	}

