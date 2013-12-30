package InterfaceHistorique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
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

import Principal.ContPrincipal;

public class VueHistorique implements Observer {
	private static final int LARGEUR_HISTORIQUE = (int) (ContPrincipal.LARGEUR_FENETRE*0.1);
	private static final int HAUTEUR_HISTORIQUE = ContPrincipal.HAUTEUR_FENETRE;
	private static final int INTERLIGNE_HISTORIQUE = 2;
	
	private ArrayList<JLabel> etiquettesMessages;
	private JButton boutonPasser;

	public VueHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		JPanel panHistorique = new JPanel();
		fenetrePrincipale.getContentPane().add(panHistorique, contraintesLayout);
		
		panHistorique.setBackground(Color.cyan);
		
		
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

}