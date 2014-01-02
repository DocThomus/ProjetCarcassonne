package InterfaceInitialisation;

public class ControleurPage2 {
	ModelePage2 modele;
	VuePage2 vue;
	
	public ControleurPage2 (){
		this.modele=new ModelePage2();
		this.vue=new VuePage2(this);
	}
	
	public void ajoutJoueur(int num, String nom){
		System.out.println("Controleur ok  : " + nom);
		this.modele.AjoutJoueur(num,nom);
	}
	public void supprimeJoueur(int num){
		this.modele.supprimeJoueur(num);
	}
	
	public void commencerPartie(){
		this.modele.creerJoueurs();
	}
}
