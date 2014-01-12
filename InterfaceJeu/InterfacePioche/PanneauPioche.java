package InterfacePioche;
import java.awt.BorderLayout;
import java.awt.Component;
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
	private static final long serialVersionUID = 9115548704472911549L;
	
	private Image imgTuile;
	private JButton rotationHoraire;
	private JButton rotationAntiHoraire;
	private ContPioche controleur;
	private int taillePioche=0;
	private JLabel nbTuile;
	private JLabel panImage;
	
	public PanneauPioche (ContPioche controleur){
		this.controleur=controleur;
		
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
		
		this.panImage = new JLabel(new ImageIcon(imgTuile));
		this.panImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel labelNbTuilesConst = new JLabel("Nombre de tuiles restantes : ");
		labelNbTuilesConst.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.nbTuile = new JLabel(""+this.taillePioche);
		this.nbTuile.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(Box.createVerticalGlue());
		this.add(labelNbTuilesConst);
		this.add(nbTuile);
		this.add(Box.createVerticalStrut(10));
		this.add(panImage, BorderLayout.CENTER);
		this.add(Box.createVerticalStrut(10));
		this.add(panBoutons);
		this.add(Box.createVerticalStrut(10));
	}
	
	public void maj (Image img,int taille){
		this.imgTuile=img;
		this.taillePioche=taille;
		this.nbTuile.setText(""+this.taillePioche);
		this.panImage.setIcon(new ImageIcon(img));
	}

	
	public JButton getRotationH(){
		return this.rotationHoraire;
	}
	
	public JButton getRotationAH(){
		return this.rotationAntiHoraire;
	}
	
	public void setRotation(boolean etat){
		this.rotationHoraire.setEnabled(etat);
		this.rotationAntiHoraire.setEnabled(etat);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rotationHoraire){
			this.controleur.rotationH();
		}
		if(e.getSource() == rotationAntiHoraire){
			this.controleur.rotationAH();
		}
	}
}
