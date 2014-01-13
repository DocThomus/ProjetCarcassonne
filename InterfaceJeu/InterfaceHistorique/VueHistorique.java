package InterfaceHistorique;

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

import InterfaceJeu.ControleurJeu;
import InterfacePioche.ContPioche;
import InterfacePlateau.ContPlateau;
import InterfaceScore.ContScore;
import Noyau.Joueur;
import Principal.ContPrincipal;

public class VueHistorique implements Observer, ActionListener {
	private static final int LARGEUR_HISTORIQUE = (int) (ControleurJeu.LARGEUR_FENETRE*0.1);
	private static final int HAUTEUR_HISTORIQUE = ControleurJeu.HAUTEUR_FENETRE;
	private static final int INTERLIGNE_HISTORIQUE = 2;
	
	private ArrayList<JLabel> etiquettesMessages;
	private JButton boutonPasser;
	private JFrame fenetrePrincipale;

	public VueHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		this.fenetrePrincipale = fenetrePrincipale;
		JPanel panHistorique = new JPanel();
		fenetrePrincipale.getContentPane().add(panHistorique, contraintesLayout);
		
		panHistorique.setLayout(new BoxLayout(panHistorique, BoxLayout.Y_AXIS));
		panHistorique.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 0));
		panHistorique.add(new JLabel("Historique :"));
		
		etiquettesMessages = new ArrayList<JLabel>();
		for(int i = 0; i < ContHistorique.NB_EVENEMENTS_MAX_AFFICHES; i++) {
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

	public void update(Observable o, Object arg) {
		PaquetHistorique ph = (PaquetHistorique) arg;
		ArrayList<String> listEvenements = ph.getListEvenements();
		
		for (int i = 0; i < listEvenements.size(); i++) {
			etiquettesMessages.get(i).setText(listEvenements.get(i));
		}
	}

	public void setEtatBoutonPasser(boolean b) {
		this.boutonPasser.setEnabled(b);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boutonPasser){
			ContPlateau.evaluationFinTour();
			ContScore.refresh();
			if (!ContPioche.isPiocheVide()) {	
				ContPioche.piocher();
				Joueur.joueurSuivant();
				this.setEtatBoutonPasser(false);
				ContPioche.setRotation(true);
				ContHistorique.ajouterEvenement("C'est à " + Joueur.getJoueurActif().getNom() + " de jouer.");
				ContPlateau.activerBoutonsPoserTuile();
				ContPlateau.desactiverBoutonsPoserPion();
				ContPlateau.refresh();
			} else {	// La partie est finie lorsque la pioche est vide.
				ContPlateau.evaluationFinDePartie();
				ContPrincipal.scoreFin();
				this.fenetrePrincipale.dispose();
			}
		}
	}
}
