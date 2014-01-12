package InterfaceScore;

public class PaquetScore {
	private int[] tabNbPions;
	private int[] tabScores;
	
	public PaquetScore(int[] tabNbPions, int[] tabScores) {
		this.tabNbPions = tabNbPions;
		this.tabScores = tabScores;
	}
	
	public int[] getTabNbPions() {
		return this.tabNbPions;
	}

	public int[] getTabScores() {
		return this.tabScores;
	}
}
