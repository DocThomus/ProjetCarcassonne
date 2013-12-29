package InterfaceHistorique;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Principal.ContPrincipal;

public class PanneauHistorique extends JPanel {
	
	private static final long serialVersionUID = 12L;
	
	private ArrayList<String> listeEvenements;
	
	public PanneauHistorique() {
		this.listeEvenements = new ArrayList<String>();
		
		//this.setSize(280,720);
		this.setBackground(Color.cyan);
	}

	public void maj(ArrayList<String> arg) {
		listeEvenements = arg;
		
		this.repaint();
	}
	
	/*public void paintComponent(Graphics g) {
		g.drawString("Evènements récents :", ContPrincipal.LARGEUR_FENETRE-200, 20);
	}*/
}
