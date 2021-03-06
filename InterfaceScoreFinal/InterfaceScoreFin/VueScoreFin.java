package InterfaceScoreFin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueScoreFin implements ActionListener{		
	private ControleurScoreFin controleur;
	private JButton rejouer, quitter;
	private JFrame fenetre;
				
	public VueScoreFin (ControleurScoreFin c){
		int egalite = 0;
		fenetre = new JFrame();
		this.controleur = c;
		String [] nomsJoueurs = controleur.getNomsJoueurs();
		String [] scoreJoueurs = controleur.getScoreJoueurs();
		
	
		Font policeVictoire = new Font("courier", Font.BOLD,40);
		Font policeClassement = new Font("courier", Font.PLAIN, 20);
		
		
		JLabel joueur1,joueur2, joueur3, joueur4, joueur5, joueur6;
		JLabel pointsgagnant, points2, points3, points4, points5, points6;
        JLabel victoire = new JLabel (" Victoire de... ");
        
        
        JPanel classement = new JPanel(); // le panel du classement
        JPanel premier= new JPanel(); //le panel qui affichera le texte 'victoire de' et le nom du gagnant
        JLabel gagnant = new JLabel(" "+controleur.getNomsJoueurs()[0] + " !"); //le panel qui affichera le gagnant de la partie
        JPanel points = new JPanel();//affichera les points des joueurs en relation avec le classement
        
        gagnant.setFont(policeVictoire);
        victoire.setFont(policeVictoire);
        points.setFont(policeClassement);        
        classement.setFont(policeClassement);
        
        
        JPanel boutons = new JPanel(); //panel des boutons
        rejouer = new JButton ("Rejouer");
        rejouer.addActionListener(this);
        quitter = new JButton ("Quitter");
        quitter.addActionListener(this);
        
       
        while(egalite < nomsJoueurs.length-1 && scoreJoueurs[egalite].equals(scoreJoueurs[egalite +1] ))
        {egalite ++;}
        System.out.println ("egalite : " + egalite);
        
        if (egalite > 0)
        	
        { victoire = new JLabel ("�galit� entre");
          victoire.setFont(policeVictoire);
        
          String s = egalite+1 + " joueurs";
          gagnant = new JLabel(s);
          gagnant.setFont(policeVictoire);
         
          points.setLayout(new BoxLayout(points, BoxLayout.Y_AXIS));
          points.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
          boutons.add(Box.createGlue());
          boutons.add(rejouer);
          boutons.add(Box.createGlue());
          boutons.add(quitter);
          boutons.add(Box.createGlue());
          joueur1 = new JLabel("1er       "+nomsJoueurs[0]);
          pointsgagnant = new JLabel(scoreJoueurs[0]+"     points");
          classement.add(joueur1); classement.add(Box.createGlue());
          points.add(pointsgagnant); points.add(Box.createGlue());
          int cpt = 2;
          
          joueur2= new JLabel("2nd       " +nomsJoueurs[1]);
          points2= new JLabel(scoreJoueurs[1]+ "     points");
          
           classement.add(joueur2); classement.add(Box.createGlue());
           points.add(points2); points.add(Box.createGlue());
         
         if (cpt < controleur.getNbJoueurs())
         { joueur3= new JLabel("3eme   "+nomsJoueurs[cpt]);
         points3= new JLabel(scoreJoueurs[cpt]+ "     points");
         cpt++;
          classement.add(joueur3); classement.add(Box.createGlue()); 
          points.add(points3); points.add(Box.createGlue());}
         
         if (cpt < controleur.getNbJoueurs())
         { joueur4= new JLabel("4eme   "+nomsJoueurs[cpt]); 
         points4= new JLabel(scoreJoueurs[cpt]+"     points");
         cpt++; classement.add(joueur4); classement.add(Box.createGlue());
         points.add(points4); points.add(Box.createGlue());
         }
         
         if (cpt < controleur.getNbJoueurs())
         { joueur5= new JLabel("5eme   "+nomsJoueurs[cpt]); 
         points5= new JLabel(scoreJoueurs[cpt]+"     points");
         cpt ++;   classement.add(joueur5); classement.add(Box.createGlue());
         points.add(points5); points.add(Box.createGlue());}
         
         if (cpt < controleur.getNbJoueurs())
         { joueur6= new JLabel("6eme   "+nomsJoueurs[cpt]);
         points6= new JLabel(scoreJoueurs[cpt]+"     points");
         cpt++; classement.add(joueur6); classement.add(Box.createGlue());
         points.add(points6); points.add(Box.createGlue());
         }
        }
        
        else {
        joueur1 = new JLabel("1er        " + controleur.getNomsJoueurs()[0]);
        classement.add(joueur1); 
        classement.add(Box.createGlue());
        
        points.setLayout(new BoxLayout(points, BoxLayout.Y_AXIS));
        points.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        pointsgagnant = new JLabel(scoreJoueurs[0]+"     points");
        
        points.add(pointsgagnant);
        points.add(Box.createGlue());
        boutons.add(Box.createGlue());
        boutons.add(rejouer);
        boutons.add(Box.createGlue());
        boutons.add(quitter);
        boutons.add(Box.createGlue());
       
      
        
        int cpt = 2;
       
         joueur2= new JLabel("2nd       " +nomsJoueurs[1]);
         points2= new JLabel(scoreJoueurs[1]+ "     points");
         
          classement.add(joueur2); classement.add(Box.createGlue());
          points.add(points2); points.add(Box.createGlue());
        
        if (cpt < controleur.getNbJoueurs())
        { joueur3= new JLabel("3eme   "+nomsJoueurs[cpt]);
        points3= new JLabel(scoreJoueurs[cpt]+ "     points");
        cpt++;
         classement.add(joueur3); classement.add(Box.createGlue()); 
         points.add(points3); points.add(Box.createGlue());}
        
        if (cpt < controleur.getNbJoueurs())
        { joueur4= new JLabel("4eme   "+nomsJoueurs[cpt]); 
        points4= new JLabel(scoreJoueurs[cpt]+"     points");
        cpt++; classement.add(joueur4); classement.add(Box.createGlue());
        points.add(points4); points.add(Box.createGlue());
        }
        
        if (cpt < controleur.getNbJoueurs())
        { joueur5= new JLabel("5eme   "+nomsJoueurs[cpt]); 
        points5= new JLabel(scoreJoueurs[cpt]+"     points");
        cpt ++;   classement.add(joueur5); classement.add(Box.createGlue());
        points.add(points5); points.add(Box.createGlue());}
        
        if (cpt < controleur.getNbJoueurs())
        { joueur6= new JLabel("6eme   "+nomsJoueurs[cpt]);
        points6= new JLabel(scoreJoueurs[cpt]+"     points");
        cpt++; classement.add(joueur6); classement.add(Box.createGlue());
        points.add(points6); points.add(Box.createGlue());
        }
	
        }  
        boutons.setLayout(new BoxLayout(boutons, BoxLayout.X_AXIS));
        boutons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        classement.setLayout(new BoxLayout(classement, BoxLayout.Y_AXIS));
        classement.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        premier.setLayout(new BoxLayout(premier, BoxLayout.Y_AXIS));
        premier.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        premier.add(victoire);
        premier.add(Box.createGlue());
        premier.add(gagnant);
        premier.add(Box.createGlue());
		fenetre.setTitle("Carcassonne");
		fenetre.setSize(400,500);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fenetre.setResizable(false);
	    fenetre.getContentPane().add(BorderLayout.WEST,classement);
	    fenetre.getContentPane().add(BorderLayout.NORTH,premier);
	    fenetre.getContentPane().add(BorderLayout.EAST,points);
	    fenetre.getContentPane().add(BorderLayout.SOUTH, boutons);
		fenetre.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.rejouer) { // Fin de partie.
			this.controleur.relancerPartie();
			this.fenetre.dispose();
		} else if(e.getSource() == this.quitter) { // Realancer Partie.
			this.fenetre.dispose();
		}
	}
}