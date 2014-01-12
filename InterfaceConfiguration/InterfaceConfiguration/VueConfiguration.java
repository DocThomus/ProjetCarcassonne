package InterfaceConfiguration;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VueConfiguration implements ActionListener {
	private JButton Bouton1,Bouton2,Bouton3,Bouton4,Bouton5,Bouton6,Jouer;
	private JTextField champ1,champ2,champ3,champ4,champ5,champ6;
	private JLabel label1;
	private ControleurConfiguration controleur;
	private JFrame cadre;
	private int joueurCree=0;
	
	public VueConfiguration (ControleurConfiguration cont){
			this.controleur=cont;
			
			this.cadre = new JFrame();  // On crée un cadre 
			JPanel ListeBoutons = new JPanel(); //on crée le panel qui sera contenu dans le JFrame ("cadre")
			JPanel ListeChamps = new JPanel(); //On crée un panel qui vas gerer les champs
			JPanel Titre = new JPanel();// Le titre de la page
			JPanel Jeu = new JPanel(); // On créz un nouveau pannel pour le bouton demarrer
			
			Bouton1  = new JButton("OK"); // on cree un bouton
			Bouton1.addActionListener(this); //On enregistre l'objet de type controleur comme etant un ecouteur du bouton 
			
			Bouton2 = new JButton("OK");
			Bouton2.addActionListener(this); 
			
			Bouton3 = new JButton("OK");
			Bouton3.addActionListener(this);
			
			Bouton4 = new JButton("OK");
			Bouton4.addActionListener(this);
			
			Bouton5 = new JButton("OK");
			Bouton5.addActionListener(this);
			
			Bouton6 = new JButton("OK");
			Bouton6.addActionListener(this);
			
			Jouer = new JButton("JOUER");
			Jouer.addActionListener(this);
			
			champ1 = new JTextField(12);
			champ2 = new JTextField(12);
			champ3 = new JTextField(12);
			champ4 = new JTextField(12);
			champ5 = new JTextField(12);
			champ6 = new JTextField(12);
		
			label1 = new JLabel("Joueurs");
			
			ListeBoutons.setLayout(new BoxLayout(ListeBoutons, BoxLayout.Y_AXIS)); //on crée un nouveaux layout pour que les widgets soit disposé en colonne
			ListeBoutons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //ON crée un bord imaginaire qui eloigne de 10 les widgets des bords
			
			ListeChamps.setLayout(new BoxLayout(ListeChamps, BoxLayout.Y_AXIS));
			ListeChamps.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //ON crée un bord imaginaire qui eloigne de 10 les widgets des bords
			
			//ListeChamps.add(Box.createGlue());
			ListeChamps.add(champ1); //on ajoute un champs
			//ListeChamps.add(Box.createGlue());
			ListeChamps.add(champ2);
			//ListeChamps.add(Box.createGlue());
			ListeChamps.add(champ3);
			//ListeChamps.add(Box.createGlue());
			ListeChamps.add(champ4);
			//ListeChamps.add(Box.createGlue());
			ListeChamps.add(champ5);
			//ListeChamps.add(Box.createGlue());
			ListeChamps.add(champ6);
			//ListeChamps.add(Box.createGlue());
			
			ListeBoutons.add(Bouton1); //on ajoute un bouton
			ListeBoutons.add(Box.createGlue());
			ListeBoutons.add(Bouton2);
			ListeBoutons.add(Box.createGlue());
			ListeBoutons.add(Bouton3);
			ListeBoutons.add(Box.createGlue());
			ListeBoutons.add(Bouton4);
			ListeBoutons.add(Box.createGlue());
			ListeBoutons.add(Bouton5);
			ListeBoutons.add(Box.createGlue());
			ListeBoutons.add(Bouton6);
			
			Titre.add(label1); //on ajoute un titre
			
			Jeu.add(Jouer);
			
			//Titre.setBackground(Color.green);
			//ListeBoutons.setBackground(Color.gray);
			//ListeChamps.setBackground(Color.red);
			
			cadre.getContentPane().add(BorderLayout.NORTH,Titre);
			cadre.getContentPane().add(BorderLayout.WEST,ListeChamps);
			cadre.getContentPane().add(BorderLayout.EAST,ListeBoutons);
			cadre.getContentPane().add(BorderLayout.SOUTH,Jeu);
		
			cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ce programme s'arretera des que l'on appuira sur la croix en haut à droite 
			cadre.setSize(300,300);
			cadre.setResizable(false);
			cadre.setVisible(true); 
			cadre.setLocationRelativeTo(null); //On centre la frame au millieu de l'écran
			
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Bouton1){
			boolean changement = true;
			if(this.Bouton1.getText().equals("OK") && changement){
				if(this.champ1.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est créé
					this.controleur.ajoutJoueur(1,this.champ1.getText());
					this.Bouton1.setText("Annuler");
					this.champ1.setEditable(false);
					changement=false;
					this.joueurCree++;
				}
			}
			if(this.Bouton1.getText().equals("Annuler") && changement){
				this.controleur.supprimeJoueur(1);
				this.Bouton1.setText("OK");
				this.champ1.setEditable(true);
				changement=false;
				this.joueurCree--;
			}
		}
		
		if(e.getSource() == Bouton2){
			boolean changement = true;
			if(this.Bouton2.getText().equals("OK") && changement){
				if(this.champ2.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est créé
					this.controleur.ajoutJoueur(2,this.champ2.getText());
					this.Bouton2.setText("Annuler");
					this.champ2.setEditable(false);
					changement=false;
					this.joueurCree++;
				}
			}
			if(this.Bouton2.getText().equals("Annuler") && changement){
				this.controleur.supprimeJoueur(2);
				this.Bouton2.setText("OK");
				this.champ2.setEditable(true);
				changement=false;
				this.joueurCree--;
			}
		}
	
	
		if(e.getSource() == Bouton3){
			boolean changement = true;
			if(this.Bouton3.getText().equals("OK") && changement){
				if(this.champ3.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est créé
					this.controleur.ajoutJoueur(3,this.champ3.getText());
					this.Bouton3.setText("Annuler");
					this.champ3.setEditable(false);
					changement=false;
					this.joueurCree++;
				}
			}
			if(this.Bouton3.getText().equals("Annuler") && changement){
				this.controleur.supprimeJoueur(3);
				this.Bouton3.setText("OK");
				this.champ3.setEditable(true);
				changement=false;
				this.joueurCree--;
			}
		}
	
		if(e.getSource() == Bouton4){
			boolean changement = true;
			if(this.Bouton4.getText().equals("OK") && changement){
				if(this.champ4.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est créé
					this.controleur.ajoutJoueur(4,this.champ4.getText());
					this.Bouton4.setText("Annuler");
					this.champ4.setEditable(false);
					changement=false;
					this.joueurCree++;
				}
			}
			if(this.Bouton4.getText().equals("Annuler") && changement){
				this.controleur.supprimeJoueur(4);
				this.Bouton4.setText("OK");
				this.champ4.setEditable(true);
				changement=false;
				this.joueurCree--;
			}
		}
	
		if(e.getSource() == Bouton5){
			boolean changement = true;
			if(this.Bouton5.getText().equals("OK") && changement){
				if(this.champ5.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est créé
					this.controleur.ajoutJoueur(5,this.champ5.getText());
					this.Bouton5.setText("Annuler");
					this.champ5.setEditable(false);
					changement=false;
					this.joueurCree++;
				}
			}
			if(this.Bouton5.getText().equals("Annuler") && changement){
				this.controleur.supprimeJoueur(5);
				this.Bouton5.setText("OK");
				this.champ5.setEditable(true);
				changement=false;
				this.joueurCree--;
			}
		}
	
		if(e.getSource() == Bouton6){
			boolean changement = true;
			if(this.Bouton6.getText().equals("OK") && changement){
				if(this.champ6.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est créé
					this.controleur.ajoutJoueur(6,this.champ6.getText());
					this.Bouton6.setText("Annuler");
					this.champ6.setEditable(false);
					changement=false;
					this.joueurCree++;
				}
			}
			if(this.Bouton6.getText().equals("Annuler") && changement){
				this.controleur.supprimeJoueur(6);
				this.Bouton6.setText("OK");
				this.champ6.setEditable(true);
				changement=false;
				this.joueurCree--;
			}
		}
	
		if(e.getSource() == Jouer){
			if(this.joueurCree>=2){
				this.controleur.commencerPartie();
				this.cadre.dispose();
			}
		}
	} // fin de ActionPerformed
}	// fin de classe	
	


