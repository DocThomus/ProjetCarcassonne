package InterfaceHistorique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import InterfacePioche.ContPioche;
import Noyau.Joueur;
import Principal.ContPrincipal;

public class VueHistorique implements Observer, ActionListener {
	private static final int LARGEUR_HISTORIQUE = (int) (ContPrincipal.LARGEUR_FENETRE*0.1);
	private static final int HAUTEUR_HISTORIQUE = ContPrincipal.HAUTEUR_FENETRE;
	private static final int INTERLIGNE_HISTORIQUE = 2;
	
	private ArrayList<JLabel> etiquettesMessages;
	private JButton boutonPasser;
	private ContHistorique controleur;

	public VueHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, ContHistorique controleur) {
		this.controleur = controleur;
		JPanel panHistorique = new JPanel();
		fenetrePrincipale.getContentPane().add(panHistorique, contraintesLayout);
		
		//panHistorique.setBackground(Color.cyan);
		
		panHistorique.setLayout(new BoxLayout(panHistorique, BoxLayout.Y_AXIS));
		panHistorique.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 0));
		panHistorique.add(new JLabel("Historique :"));
		
		etiquettesMessages = new ArrayList<JLabel>();
		for(int i = 0; i < 10; i++) {
			panHistorique.add(Box.createVerticalStrut(INTERLIGNE_HISTORIQUE));
			JLabel e = new JLabel();
			panHistorique.add(e);
			etiquettesMessages.add(e);
		}
		
		boutonPasser = new JButton("Passer");
		boutonPasser.addActionListener(this);
		panHistorique.add(Box.createGlue());
		panHistorique.add(boutonPasser);
		
		panHistorique.setPreferredSize(new Dimension(LARGEUR_HISTORIQUE, HAUTEUR_HISTORIQUE));
		panHistorique.setMinimumSize(new Dimension(LARGEUR_HISTORIQUE, HAUTEUR_HISTORIQUE));
		panHistorique.revalidate();
		panHistorique.repaint();
	}

	@SuppressWarnings("unchecked")
	public void update(Observable o, Object arg) {
		for (int i = 0; i < ((ArrayList<String>)arg).size(); i++) {
			etiquettesMessages.get(i).setText(((ArrayList<String>)arg).get(i));
		}
	}

	public void setEtatBoutonPasser(boolean b) {
		this.boutonPasser.setEnabled(b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boutonPasser){
			ContPioche.ControleurPioche.getModele().piocher();
			Joueur.joueurSuivant();
			this.setEtatBoutonPasser(false);
			this.controleur.ajouterEvenement("C'est à " + Joueur.getJoueurActif().getNom() + " de jouer.");
		}
		
	}

}
