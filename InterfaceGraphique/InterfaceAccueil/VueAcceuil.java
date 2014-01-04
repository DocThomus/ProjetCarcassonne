package InterfaceAccueil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VueAcceuil extends JPanel {
	Graphics I;
	
	public VueAcceuil(){
		this.paintComponent(I);
		Thread t = new Thread();
		JFrame cadre = new JFrame();
		cadre.setSize(300, 300);
		cadre.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		Image I = new ImageIcon("index.jpg").getImage();
		g.drawImage(I,3,4,this);
	}
	
	

}
