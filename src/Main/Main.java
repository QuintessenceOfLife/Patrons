/******************************************************
* Cours:   LOG121
* Session: H2017
* Groupe:  03
* Projet: Laboratoire #4
* Etudiant(e)s: Youssef Soliman
				Yassine Abdellaoui
				Raph Jobin
				Victor Trinh
* Professeur : 	Vincent Lacasse
* Charge : 		Patrice Boucher
* Nom du fichier: Main.java
* Date cree: 2017-03-23
*******************************************************/

package Main;

import java.awt.EventQueue;

import vue.FenetrePrincipale;

/*****************************************************************************
 * Initialise le programme. Creation de la fenetre principale.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		    	  new FenetrePrincipale();
		      }
		    });
	}
	
}
