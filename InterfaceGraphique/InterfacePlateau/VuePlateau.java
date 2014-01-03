package InterfacePlateau;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePlateau implements Observer {
	private JPanel panPlateau;
	private int largeurPlateau;
	private int hauteurPlateau;
	private Image[][] tabtabImages;
	private boolean[][] tabtabCasesLibres;

	public VuePlateau(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, int largeurPlateau, int hauteurPlateau) {
		this.largeurPlateau = largeurPlateau;
		this.hauteurPlateau = hauteurPlateau;
		
		this.panPlateau = new JPanel();
		
		fenetrePrincipale.getContentPane().add(this.panPlateau, contraintesLayout);
		
		panPlateau.setBackground(Color.pink);

		panPlateau.setLayout(new GridLayout(this.hauteurPlateau, this.largeurPlateau));
	}

	public void update(Observable o, Object arg) {
		PaquetPlateau pp = (PaquetPlateau) arg;
		
		this.tabtabImages = pp.getTabTabImages();
		this.tabtabCasesLibres = pp.getTabTabCasesLibres();
		this.panPlateau.removeAll();
		
		for(int i = 0; i < this.hauteurPlateau; i++) {
			for(int j = 0; j < this.largeurPlateau; j++) {
				if(this.tabtabImages[i][j] != null) {
					this.panPlateau.add(new JLabel(new ImageIcon(tabtabImages[i][j])));
				} else if(this.tabtabCasesLibres[i][j] == true) {
					this.panPlateau.add(new JButton("Poser")); // On pet créer sa propre classe qui extends JButton, et qui prend en paramètre les coordonnées du bouton sur le plateau.
				} else {
					this.panPlateau.add(new JPanel());
				}
			}
		}
	}
}
