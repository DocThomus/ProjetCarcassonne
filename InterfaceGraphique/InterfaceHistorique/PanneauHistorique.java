package InterfaceHistorique;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanneauHistorique extends JPanel {
	
	private static final long serialVersionUID = 12L;
	
	private ArrayList<String> listeEvenements;
	
	public PanneauHistorique() {
		this.listeEvenements = new ArrayList<String>();

		this.setBackground(Color.cyan);
	}

	public void maj(ArrayList<String> arg) {
		listeEvenements = arg;
		
		
	}
	
	/*public void paintComponent(Graphics g) {
		g.drawString("Evènements récents :", ContPrincipal.LARGEUR_FENETRE-200, 20);
	}*/
}
