package Main;

import java.awt.EventQueue;

import vue.FenetrePrincipale;

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
