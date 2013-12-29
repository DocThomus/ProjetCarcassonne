package Principal;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetrePrincipale extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public FenetrePrincipale() {
		this.setSize(ContPrincipal.LARGEUR_FENETRE, ContPrincipal.HAUTEUR_FENETRE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
