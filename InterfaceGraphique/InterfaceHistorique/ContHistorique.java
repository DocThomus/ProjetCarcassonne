package InterfaceHistorique;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

public class ContHistorique {
	private ModHistorique modele;
	private VueHistorique vue;

	public ContHistorique(JFrame fenetrePrincipale, GridBagConstraints contraintesLayout) {
		modele = new ModHistorique();
		vue = new VueHistorique(fenetrePrincipale, contraintesLayout);
		modele.addObserver(vue);
	}
}
