package InterfacePlateau;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;

public class PanneauTuile extends JPanel {
	private static final long serialVersionUID = 3402916968807493499L;
	private Image imageTuile;
	private boolean presencePion;
	private int positionPion;
	private Color couleurPion;
	
	public PanneauTuile(Image imageTuile) {
		this.imageTuile = imageTuile;
		this.presencePion = false;
		this.setMinimumSize(new Dimension(100, 100));
	}
	
	public void setPion(boolean presencePion, int positionPion, Color couleurPion) {
		this.presencePion = presencePion;
		this.positionPion = positionPion;
		this.couleurPion = couleurPion;
	}

	public void setBoutonsPosePion(BoutonPosePion[] tabBoutonPosePion, boolean[] tabPresenceBoutonPosePion) {		
		
		this.setLayout(new GridLayout(5, 5, 10, 10)); 
		JPanel panVide00 = new JPanel();
		JPanel panVide01 = new JPanel();
		JPanel panVide03 = new JPanel();
		JPanel panVide04 = new JPanel();
		JPanel panVide10 = new JPanel();
		JPanel panVide11 = new JPanel();
		JPanel panVide12 = new JPanel();
		JPanel panVide13 = new JPanel();
		JPanel panVide14 = new JPanel();
		JPanel panVide21 = new JPanel();
		JPanel panVide23 = new JPanel();
		JPanel panVide30 = new JPanel();
		JPanel panVide31 = new JPanel();
		JPanel panVide32 = new JPanel();
		JPanel panVide33 = new JPanel();
		JPanel panVide34 = new JPanel();
		JPanel panVide40 = new JPanel();
		JPanel panVide41 = new JPanel();
		JPanel panVide43 = new JPanel();
		JPanel panVide44 = new JPanel();
		
		panVide00.setVisible(false);
		panVide01.setVisible(false);
		panVide03.setVisible(false);
		panVide04.setVisible(false);
		panVide10.setVisible(false);
		panVide11.setVisible(false);
		panVide12.setVisible(false);
		panVide13.setVisible(false);
		panVide14.setVisible(false);
		panVide21.setVisible(false);
		panVide23.setVisible(false);
		panVide30.setVisible(false);
		panVide31.setVisible(false);
		panVide32.setVisible(false);
		panVide33.setVisible(false);
		panVide34.setVisible(false);
		panVide40.setVisible(false);
		panVide41.setVisible(false);
		panVide43.setVisible(false);
		panVide44.setVisible(false);
		
		this.add(panVide00);
		this.add(panVide01); // panTuilePosee.add(tabBoutonPosePion[11]); 
		this.add(tabBoutonPosePion[12]);
		this.add(panVide03); // panTuilePosee.add(tabBoutonPosePion[1]);
		this.add(panVide04);
		this.add(panVide10); // panTuilePosee.add(tabBoutonPosePion[10]);
		this.add(panVide11);
		this.add(panVide12);
		this.add(panVide13);
		this.add(panVide14); // panTuilePosee.add(tabBoutonPosePion[2]);
		this.add(tabBoutonPosePion[9]);
		this.add(panVide21);
		this.add(tabBoutonPosePion[0]);
		this.add(panVide23);
		this.add(tabBoutonPosePion[3]);
		this.add(panVide30); // panTuilePosee.add(tabBoutonPosePion[8]);
		this.add(panVide31);
		this.add(panVide32);
		this.add(panVide33);
		this.add(panVide34); // panTuilePosee.add(tabBoutonPosePion[4]);
		this.add(panVide40);
		this.add(panVide41); // panTuilePosee.add(tabBoutonPosePion[7]);
		this.add(tabBoutonPosePion[6]);
		this.add(panVide43); // panTuilePosee.add(tabBoutonPosePion[5]);
		this.add(panVide44);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imageTuile, 0, 0, null);
		
		if(this.presencePion) {
			g.setColor(this.couleurPion);
			if(this.positionPion == 0) { // Centre
				g.fillRect(45, 45, 10, 10);
			} else if(this.positionPion == 12) { // Nord 
				g.fillRect(45, 5, 10, 10);
			} else if(this.positionPion == 3) {	// Est
				g.fillRect(85, 45, 10, 10);
			} else if(this.positionPion == 6) { // Sud
				g.fillRect(45, 85, 10, 10);
			} else if(this.positionPion == 9) { // Ouest
				g.fillRect(5, 45, 10, 10);
			}
		}
	}
}
