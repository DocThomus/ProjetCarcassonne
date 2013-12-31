package InterfacePioche;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Noyau.Tuile;


public class PanneauPioche extends JPanel implements ActionListener {
	
	//private ImageIcon imgTuile;
	private Image imgTuile;
	private JButton rotationHoraire;
	private JButton rotationAntiHoraire;
	private ContPioche controleur;
	
	public PanneauPioche (ContPioche controleur){
		this.controleur=controleur;
		//this.imgTuile= new ImageIcon(Tuile.listImagesTuiles.get(24).get(0));
		this.imgTuile= Tuile.listImagesTuiles.get(24).get(0);
		
		ImageIcon icon = new ImageIcon();
		try {
			icon = new ImageIcon(ImageIO.read(new File("Image/rotationH.jpg")));
		} catch (IOException e) {e.printStackTrace();}
		
		this.rotationHoraire= new JButton(icon);
		rotationHoraire.addActionListener(this);
		
		
		ImageIcon icon2 = new ImageIcon();
		try {
			icon2 = new ImageIcon(ImageIO.read(new File("Image/rotationAH.jpg")));
		} catch (IOException e) {e.printStackTrace();}
		
		this.rotationAntiHoraire= new JButton(icon2);
		rotationAntiHoraire.addActionListener(this);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panBoutons = new JPanel();
		panBoutons.setLayout(new BoxLayout(panBoutons, BoxLayout.LINE_AXIS));
		panBoutons.add(rotationHoraire);
		panBoutons.add(rotationAntiHoraire);
		
		/*JLabel panImage = new JLabel(imgTuile);
		panImage.setAlignmentX(Component.CENTER_ALIGNMENT);*/
		
		this.add(Box.createVerticalGlue());
		
		//this.add(panImage, BorderLayout.CENTER);
		this.add(Box.createVerticalStrut(10));
		this.add(panBoutons);
		this.add(Box.createVerticalStrut(10));
	}
	
	public void maj (Image img){
		System.out.println("maj ok");
		//this.imgTuile = new ImageIcon(img);
		this.imgTuile=img;
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgTuile, this.getWidth()/4,this.getHeight()/4,150,150,this);
	}
	
	public JButton getRotationH(){
		return this.rotationHoraire;
	}
	
	public JButton getRotationAH(){
		return this.rotationAntiHoraire;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rotationHoraire){
			this.controleur.rotationH();
		}
		if(e.getSource() == rotationAntiHoraire){
			this.controleur.rotationAH();
		}
	}
}
