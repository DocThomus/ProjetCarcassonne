package Noyau;

import InterfaceAccueil.VueAcceuil;
import Principal.ContPrincipal;

public class Main {
	public static void main(String[] args) {
		Tuile.ajouteImagesTuiles();
		VueAcceuil vueA = new VueAcceuil();
		ContPrincipal c = new ContPrincipal();
	}
}
