package InterfacePioche;

import java.util.Observable;

import Noyau.Pioche;
import Noyau.Plateau;
import Noyau.Tuile;

		

public class ModPioche extends Observable {
		private Tuile t;
		private Pioche pioche;
		private Plateau plateau;
		
		public ModPioche (Plateau plateau){
			this.pioche= new Pioche();
			this.plateau= plateau;
			this.piocher();
			
			// TODO Test :
			for(int i = 0; i < 65; i++) {
				this.piocher();
			}
		}
		
		public void piocher (){
			this.t=this.pioche.piocheAleatoire();
			while(!this.t.verifTuileEstPosable(plateau)){
				this.t=this.pioche.piocheAleatoire();
			}
			this.setChanged();
			this.notifyObservers(this.getImage());
		}
		
		public void rotationHoraire(){
			this.t.rotation();
			this.setChanged();
			this.notifyObservers(this.getImage());
		}
		
		public void rotationAntiHoraire(){
			this.t.rotation();
			this.t.rotation();
			this.t.rotation();
			this.setChanged();
			this.notifyObservers(this.getImage());
		}
		
		public Tuile getTuile(){
			return this.t;
		}
		
		public PaquetPioche getImage(){
			System.out.println(this.pioche.getPioche().size());
			return  new PaquetPioche(Tuile.listImagesTuiles.get(this.t.getNum()).get(this.t.getOrientation()), this.pioche.getPioche().size());
		}
		
		public boolean isPiocheVide() {
			return this.pioche.isVide();
		}
		
}
