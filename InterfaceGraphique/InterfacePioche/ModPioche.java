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
			this.plateau= plateau;
		}
		
		public void piocher (){
			this.t=pioche.piocheAleatoire();
			while(!this.t.verifTuileEstPosable(plateau)){
				this.t=pioche.piocheAleatoire();
			}
		}
		
		public Tuile getTuile(){
			return this.t;
		}
		
		/*public Image getImage(){
			return ((List<Image>) Tuile.listImagesTuiles.get(this.t.getNum())).get(0);
		}*/
}
