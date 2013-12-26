package InterfaceScore;

import java.awt.Color;

import javax.swing.JFrame;

public class MaFenetre extends JFrame {

	private static final long serialVersionUID = 5412332298652554358L;
	
	public MaFenetre() {
		this.setSize(600, 600);
		PanneauScore pan = new PanneauScore();
		String[] a = {"a", "b", "c", "d"};
		int[] b = {1,5,6,2};
		int[] c = {10,20,54,120};
		pan.maj(4,a,b,c);
		this.getContentPane().add(pan);
	}
	
	public static void main(String[] args) {
		MaFenetre fen = new MaFenetre();
		fen.setVisible(true);
	}
}
