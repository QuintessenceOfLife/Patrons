package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.Data;
import model.Perspective;
import model.Vignette;

public class Recuperer extends Commande {

	private File sauvegarde;
	
	/**
	 * Constructeur
	 * @param vignette recevra les données de la vignette.
	 * @param perspective1 recevra les données de la première perspective.
	 * @param perspective2 recevra les données de la deuxième perspective.
	 * @param sauvegarde fichier contenant les données à récupérer.
	 */
	public Recuperer(File sauvegarde) {
		this.sauvegarde = sauvegarde;
		gestionnaire.executerCommande(this);
	}
		
	/**
	 * Récupérer la vignette et les deux perspectives à partir de la sauvegarde.
	 * @return
	 */
	@Override
	public boolean faire() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sauvegarde));) {			
			Object[] objects = (Object[]) ois.readObject();				
			Perspective p = (Perspective) objects[0];
			vignette.setFichierImage(p.getFichierImage());
			p = (Perspective) objects[1];
			perspective1.setCoordinates(p.getX1(), p.getY1(), p.getX2(), p.getY2());
			p = (Perspective) objects[2];
			perspective1.setCoordinates(p.getX1(), p.getY1(), p.getX2(), p.getY2());						
//			System.out.println("----------dans Recuperer.faire()------------");			
//			System.out.println("contenu de vignette : ");
//			System.out.println(vignette.getFichierImage().toString());
//			System.out.println("contenu de perspective1 :");
//			System.out.println(perspective1.getX1());
//			System.out.println(perspective1.getY1());
//			System.out.println(perspective1.getX2());
//			System.out.println(perspective1.getY2());
//			System.out.println("contenu de perspective2 :");
//			System.out.println(perspective2.getX1());
//			System.out.println(perspective2.getY1());
//			System.out.println(perspective2.getX2());
//			System.out.println(perspective2.getY2());
//			System.out.println("-----------------------------------------------------------");
		} catch (ClassNotFoundException | IOException e) {		
			e.printStackTrace();
		}				
		return false; //toujours
	}

	/**
	 * Il est interdit d'appeler cette méthode!
	 * @throws NoSuchMethodError
	 */
	@Override
	public void defaire() {
		//Ne pas appeler cette méthode!
        throw new NoSuchMethodError();
	}

}
