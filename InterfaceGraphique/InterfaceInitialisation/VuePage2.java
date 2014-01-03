package InterfaceInitialisation;
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


public class VuePage2 implements ActionListener {
	private JButton Bouton1,Bouton2,Bouton3,Bouton4,Bouton5,Bouton6,Jouer;
	private JTextField champ1,champ2,champ3,champ4,champ5,champ6;
	private JLabel label1;
	private ControleurPage2 controleur;
	
	public VuePage2 (ControleurPage2 cont){
			this.controleur=cont;
			
			JFrame cadre = new JFrame();  // On cr�e un cadre 
			JPanel ListeBoutons = new JPanel(); //on cr�e le panel qui sera contenu dans le JFrame ("cadre")
			JPanel ListeChamps = new JPanel(); //On cr�e un panel qui vas gerer les champs
			JPanel Titre = new JPanel();// Le titre de la page
			JPanel Jeu = new JPanel(); // On cr�z un nouveau pannel pour le bouton demarrer
			
			Bouton1  = new JButton("Joueur1"); // on cree un bouton
			Bouton1.addActionListener(this); //On enregistre l'objet de type controleur comme etant un ecouteur du bouton 
			
			Bouton2 = new JButton("Joueur2");
			Bouton2.addActionListener(this); 
			
			Bouton3 = new JButton("Joueur3");
			Bouton3.addActionListener(this);
			
			Bouton4 = new JButton("Joueur4");
			Bouton4.addActionListener(this);
			
			Bouton5 = new JButton("Joueur5");
			Bouton5.addActionListener(this);
			
			Bouton6 = new JButton("Joueur6");
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
			
			ListeBoutons.setLayout(new BoxLayout(ListeBoutons, BoxLayout.Y_AXIS)); //on cr�e un nouveaux layout pour que les widgets soit dispos� en colonne
			ListeBoutons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //ON cr�e un bord imaginaire qui eloigne de 10 les widgets des bords
			
			ListeChamps.setLayout(new BoxLayout(ListeChamps, BoxLayout.Y_AXIS));
			ListeChamps.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //ON cr�e un bord imaginaire qui eloigne de 10 les widgets des bords
			
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
			cadre.getContentPane().add(BorderLayout.WEST,ListeBoutons);
			cadre.getContentPane().add(BorderLayout.EAST,ListeChamps);
			cadre.getContentPane().add(BorderLayout.SOUTH,Jeu);
		
			cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ce programme s'arretera des que l'on appuira sur la croix en haut � droite 
			cadre.setSize(300,300);
			cadre.setResizable(false);
			cadre.setVisible(true); 
			cadre.setLocationRelativeTo(null); //On centre la frame au millieu de l'�cran
			
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Bouton1){
			boolean changement = true;
			if(this.Bouton1.getText().equals("Joueur1") && changement){
				if(this.champ1.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est cr��
					this.controleur.ajoutJoueur(1,this.champ1.getText());
					this.Bouton1.setText("OK");
					this.champ1.setEditable(false);
					changement=false;
				}
			}
			if(this.Bouton1.getText().equals("OK") && changement){
				this.controleur.supprimeJoueur(1);
				this.Bouton1.setText("Joueur1");
				this.champ1.setEditable(true);
				changement=false;
			}
		}
		
		if(e.getSource() == Bouton2){
			boolean changement = true;
			if(this.Bouton2.getText().equals("Joueur2") && changement){
				if(this.champ2.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est cr��
					this.controleur.ajoutJoueur(2,this.champ2.getText());
					this.Bouton2.setText("OK");
					this.champ2.setEditable(false);
					changement=false;
				}
			}
			if(this.Bouton2.getText().equals("OK") && changement){
				this.controleur.supprimeJoueur(2);
				this.Bouton2.setText("Joueur2");
				this.champ2.setEditable(true);
				changement=false;
			}
		}
	
	
	if(e.getSource() == Bouton3){
		boolean changement = true;
		if(this.Bouton3.getText().equals("Joueur3") && changement){
			if(this.champ3.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est cr��
				this.controleur.ajoutJoueur(3,this.champ3.getText());
				this.Bouton3.setText("OK");
				this.champ3.setEditable(false);
				changement=false;
			}
		}
		if(this.Bouton3.getText().equals("OK") && changement){
			this.controleur.supprimeJoueur(3);
			this.Bouton3.setText("Joueur3");
			this.champ3.setEditable(true);
			changement=false;
		}
	}
	
	if(e.getSource() == Bouton4){
		boolean changement = true;
		if(this.Bouton4.getText().equals("Joueur4") && changement){
			if(this.champ4.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est cr��
				this.controleur.ajoutJoueur(4,this.champ4.getText());
				this.Bouton4.setText("OK");
				this.champ4.setEditable(false);
				changement=false;
			}
		}
		if(this.Bouton4.getText().equals("OK") && changement){
			this.controleur.supprimeJoueur(4);
			this.Bouton4.setText("Joueur4");
			this.champ4.setEditable(true);
			changement=false;
		}
	}
	
	if(e.getSource() == Bouton5){
		boolean changement = true;
		if(this.Bouton5.getText().equals("Joueur5") && changement){
			if(this.champ5.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est cr��
				this.controleur.ajoutJoueur(5,this.champ5.getText());
				this.Bouton5.setText("OK");
				this.champ5.setEditable(false);
				changement=false;
			}
		}
		if(this.Bouton5.getText().equals("OK") && changement){
			this.controleur.supprimeJoueur(5);
			this.Bouton5.setText("Joueur5");
			this.champ5.setEditable(true);
			changement=false;
		}
	}
	
	if(e.getSource() == Bouton6){
		boolean changement = true;
		if(this.Bouton6.getText().equals("Joueur6") && changement){
			if(this.champ6.getText().length()>0){ // Ne marche pas : un joueur sans pseudo est cr��
				this.controleur.ajoutJoueur(6,this.champ6.getText());
				this.Bouton6.setText("OK");
				this.champ6.setEditable(false);
				changement=false;
			}
		}
		if(this.Bouton6.getText().equals("OK") && changement){
			this.controleur.supprimeJoueur(6);
			this.Bouton6.setText("Joueur6");
			this.champ6.setEditable(true);
			changement=false;
		}
	}
	
	if(e.getSource() == Jouer){
		this.controleur.commencerPartie();
	}
	
	} // fin de ActionPerformed
	
	
}	// fin de classe	
	

