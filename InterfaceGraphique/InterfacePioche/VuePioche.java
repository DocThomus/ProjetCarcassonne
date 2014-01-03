package InterfacePioche;
import java.awt.GridBagConstraints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class VuePioche implements Observer {

	private PanneauPioche panPioche;

	public VuePioche (JFrame fenetrePrincipale, GridBagConstraints contraintesLayout, ContPioche controleur){
		this.panPioche=new PanneauPioche(controleur);
		fenetrePrincipale.getContentPane().add(panPioche, contraintesLayout);
	}

	
	public void update(Observable o, Object arg) {
		PaquetPioche pp = (PaquetPioche) arg;	
		this.panPioche.maj(pp.getImageTuile(),pp.getTaillePioche());
	}
}
