package InterfacePioche;
import javax.swing.JFrame;


public class FenetreTest extends JFrame {
	
	public FenetreTest(){
		this.setTitle("Interface Pioche");
		this.setSize(300, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		PanneauPioche pio = new PanneauPioche();
		this.getContentPane().add(pio);
		//this.add(pio.getRotationH());
		//this.getContentPane().add(pio.getRotationAH());
	}
	
	public static void main(String[] args) {
		FenetreTest fen = new FenetreTest();
		fen.setVisible(true);
	}

}
