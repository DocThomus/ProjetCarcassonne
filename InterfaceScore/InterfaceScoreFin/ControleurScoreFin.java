package InterfaceScoreFin;
import Noyau.Joueur;





	public class ControleurScoreFin {
	        ModeleScoreFin modele;
	        VueScoreFin vue;
	        
	        public ControleurScoreFin (){
	                this.modele=new ModeleScoreFin();
	                this.vue=new VueScoreFin(this);
	        }
	        
	        public String [] getNomsJoueurs(){
	                return modele.getNomsJoueurs();
	        }
	        
	        public String [] getScoreJoueurs(){
	        	return modele.getScoreJoueurs();
	        }
	        
	        public int getNbJoueurs(){
	        	return modele.getNomsJoueurs().length;
	        }
	         
	        
	        public void quitterPartie(){
	                this.modele.quitter();
	        }
	        
	        public void relancerPartie(){
	                this.modele.relancePartie();
	        }
	        
	        
	        

	    	public static void main(String[] args){
               Joueur un = new Joueur("joueur1");
             
               un.creerJoueur("joueur1");
               un.creerJoueur("joueur2");
               un.creerJoueur("joueur3");
               un.creerJoueur("joueur4");
               un.creerJoueur("joueur5");
               un.creerJoueur("joueur6");
              un.getJoueur(0).ajoutPoints(100);
              un.getJoueur(1).ajoutPoints(80);
              un.getJoueur(2).ajoutPoints(120);
              un.getJoueur(3).ajoutPoints(50);
              un.getJoueur(4).ajoutPoints(78);
              un.getJoueur(5).ajoutPoints(30);
            	 
	    		ControleurScoreFin controleur = new ControleurScoreFin();
	    		System.out.println(controleur.getNomsJoueurs()[0]);
	    	
	    	}
	    	
	}


