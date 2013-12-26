package InterfaceScore;

public class ContScore {
	private ModScore modele;
	private VueScore vue;
	
	public ContScore() {
		modele = new ModScore();
		vue = new VueScore();
		modele.addObserver(vue);
	}
}
