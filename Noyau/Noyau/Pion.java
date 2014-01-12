package Noyau;
public class Pion {

	private Joueur proprio; // Propriétaire de la tuile.
	private int positionSurTuile; // Entier entre 0 et 12 (inclus) : 0 = milieu / 1..12 = position selon le sens horraire (3 = est, 6 = sud, 9 = ouest, 12 = nord).
	private Tuile tuile; // Tuile sur laquelle est posée le pion.
	
	public Pion(Joueur proprio, Tuile tuile, int pos){
		this.proprio = proprio;
		this.tuile = tuile;
		this.positionSurTuile = pos;
	}
	
	public Joueur getProprio() {
		return this.proprio;
	}
	
	public Integer getPositionSurTuile() {
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