package InterfacePlateau;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanneauTuilePosee extends JPanel {
	private Image imageFond;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imageFond, 0, 0, null);
	}

	public void setImageFond(Image imageFond) {
		this.imageFond = imageFond;
		this.repaint();
	}
}
