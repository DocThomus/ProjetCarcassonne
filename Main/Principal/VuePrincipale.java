package Principal;

import javax.swing.JFrame;

public class VuePrincipale {
	private FenetrePrincipale fenetrePrincipale;
	
	public VuePrincipale() {
		fenetrePrincipale = new FenetrePrincipale();
		fenetrePrincipale.setVisible(true);
	}
	
	protected JFrame getFenetrePrincipale() {
		return fenetrePrincipale;
	}
}
