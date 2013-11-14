public class Plateau {

private Tuile [][] repere;
private Tuile [] tuilePose;
//private static Tuile tuileDeBase; la tuile de base sera ajouté comme les autres tuile en position centrale ( x=75, y= 75 pour un repere de taille 150

	public Plateau (int taille, int nbTuile) {
		this.repere= new Tuile [taille][taille]; // taille > 150
		this.tuilePose = new Tuile [nbTuile]; // permet de parcourir toute les tuile posé rapidement, en fin de jeu notamment
		//this.tuileDeBase = tuileDeBase; 
	}

	public void setTuile (Tuile t, int x, int y){
		this.repere[x][y] = t;
	}
}
