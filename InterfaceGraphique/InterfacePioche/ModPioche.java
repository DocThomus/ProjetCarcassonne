package InterfacePioche;
import java.awt.Image;
import java.util.List;
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
			System.out.println(this.pioche.getPioche().size());
			this.plateau= plateau;
			//this.piocher();
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
		
		public Image getImage(){
			System.out.println(this.t.getNum() +"  "+ this.t.getPosition());
			return  Tuile.listImagesTuiles.get(this.t.getNum()).get(this.t.getPosition());
		}
		
		public void setImage(){//Test
			this.t=this.pioche.getPioche().get(3);
			this.setChanged();
			this.notifyObservers(this.getImage());
		}
}
