package InterfacePioche;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;


public class VuePioche implements Observer{

	private PanneauPioche panPioche;
	// COntroleur ?
	
	public VuePioche (){
		panPioche=new PanneauPioche();
	}

	@Override
	public void update(Observable o, Object arg) {
		Image imgTuile = (Image) arg;
		this.panPioche.maj(imgTuile);
	}
}
