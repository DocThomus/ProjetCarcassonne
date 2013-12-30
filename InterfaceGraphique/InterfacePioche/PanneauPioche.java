package InterfacePioche;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanneauPioche extends JPanel {
	
	private Image imgTuile;
	private JButton rotationHoraire;
	private JButton rotationAntiHoraire;
	
	
	public PanneauPioche (){
		try {
			this.imgTuile= ImageIO.read(new File("Image/tuileTest.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image rotationH;
		ImageIcon icon = new ImageIcon();
		try {
			rotationH = ImageIO.read(new File("Image/rotationH.jpg"));
			icon = new ImageIcon(rotationH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.rotationHoraire= new JButton(icon);
		
		Image rotationAH;
		ImageIcon icon2 = new ImageIcon();
		try {
			rotationAH = ImageIO.read(new File("Image/rotationAH.jpg"));
			icon2 = new ImageIcon(rotationAH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.rotationAntiHoraire= new JButton(icon2);
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(rotationHoraire);
		this.add(rotationAntiHoraire);
	}
	
	public void maj ( Image img){
		this.imgTuile=img;
	}
	
	public JButton getRotationH(){
		return this.rotationHoraire;
	}
	
	public JButton getRotationAH(){
		return this.rotationAntiHoraire;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgTuile, 20, 20, 250, 250, this);
	}
}
