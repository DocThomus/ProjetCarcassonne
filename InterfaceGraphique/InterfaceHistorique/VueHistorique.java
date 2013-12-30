package InterfaceHistorique;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueHistorique implements Observer {
	private ArrayList<JLabel> etiquettesMessages;

	public VueHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		JPanel panHistorique = new JPanel();
		fenetrePrincipale.getContentPane().add(panHistorique, contraintesLayout);
		
		panHistorique.setBackground(Color.cyan);
		
		panHistorique.setLayout(new BoxLayout(panHistorique, BoxLayout.Y_AXIS));
		panHistorique.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		panHistorique.add(new JLabel("Historique :"));
		
		etiquettesMessages = new ArrayList<JLabel>();
		for(int i = 0; i < 10; i++) {
			JLabel e = new JLabel();
			panHistorique.add(e);
			etiquettesMessages.add(e);
		}
	}

	@SuppressWarnings("unchecked")
	public void update(Observable o, Object arg) {
		for (int i = 0; i < ((ArrayList<String>)arg).size(); i++) {
			etiquettesMessages.get(i).setText(((ArrayList<String>)arg).get(i));
		}
	}

}
