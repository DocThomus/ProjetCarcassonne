package Noyau;

public class Pion {
	private Joueur proprio; // Propriétaire de la tuile.
	private Tuile tuile; // Tuile sur laquelle est posée le pion.
	private int positionSurTuile; // Position du pion sur la tuile, en suivant la logique suivante :
		/* 		11	12	1
		 * 	10				2
		 * 	9		0		3
		 * 	8				4
		 * 		7	6	5
		 */	
	
	public Pion(Joueur proprio, Tuile tuile, int pos){
		this.proprio = proprio;
		this.tuile = tuile;
		this.positionSurTuile = pos;
	}
	
	public Joueur getProprio() {
		return this.proprio;
	}
	
	public int getPositionSurTuile() {
		return this.positionSurTuile;
	}
	
	public Tuile getTuile() {
		return this.tuile;
	}
	
	public void liberePion() {
		this.proprio.retirePion(this); 
		this.tuile.retirePion(); 
	}
}