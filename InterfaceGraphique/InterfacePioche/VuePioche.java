package InterfacePioche;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class VuePioche implements Observer {

	private PanneauPioche panPioche;

	public VuePioche (JFrame fenetrePrincipale, GridBagConstraints contraintesLayout){
		panPioche=new PanneauPioche();
		fenetrePrincipale.getContentPane().add(panPioche, contraintesLayout);
	}

	@Override
	public void update(Observable o, Object arg) {
		Image imgTuile = (Image) arg;
		this.panPioche.maj(imgTuile);
	}
}
