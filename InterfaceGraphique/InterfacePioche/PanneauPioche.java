package InterfacePioche;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanneauPioche extends JPanel {
	
	private ImageIcon imgTuile;
	private JButton rotationHoraire;
	private JButton rotationAntiHoraire;
	
	
	public PanneauPioche (ContPioche controleur){
		try {
			imgTuile = new ImageIcon(ImageIO.read(new File("Image/tuileTest.jpg")));
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
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panBoutons = new JPanel();
		panBoutons.setLayout(new BoxLayout(panBoutons, BoxLayout.LINE_AXIS));
		panBoutons.add(rotationHoraire);
		panBoutons.add(rotationAntiHoraire);
		
		JLabel panImage = new JLabel(imgTuile);
		panImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.add(Box.createVerticalGlue());
		this.add(panImage, BorderLayout.CENTER);
		this.add(Box.createVerticalStrut(10));
		this.add(panBoutons);
		this.add(Box.createVerticalStrut(10));		
	}
	
	public void maj (Image img){
		this.imgTuile = new ImageIcon(img);
	}
	
	public JButton getRotationH(){
		return this.rotationHoraire;
	}
	
	public JButton getRotationAH(){
		return this.rotationAntiHoraire;
	}
}
