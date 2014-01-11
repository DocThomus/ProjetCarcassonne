package InterfacePlateau;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanneauTuile extends JPanel {
	private static final long serialVersionUID = 3402916968807493499L;
	private Image imageTuile;
	
	public PanneauTuile(Image imageTuile) {
		this.imageTuile = imageTuile;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imageTuile, 0, 0, null);
	}
}
