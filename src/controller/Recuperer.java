package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.Perspective;
import model.Photo;

public class Recuperer extends Commande {

	private File sauvegarde;
	
	/**
	 * Constructeur	
	 * @param sauvegarde fichier contenant les données à récupérer.
	 */
	public Recuperer(File sauvegarde) {
		this.sauvegarde = sauvegarde;
		gestionnaire.executerCommande(this);
	}
		
	/**
	 * Récupérer l'image et les deux perspectives à partir de la sauvegarde.
	 * @return
	 */
	@Override
	public boolean faire() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sauvegarde));) {			
			Object[] objects = (Object[]) ois.readObject();				
			photo.setFichierPhoto( ((Photo) objects[0]).getFichierPhoto() );
			perspective1.setCoordinates( 
					((Perspective) objects[1]).getX1(), 
					((Perspective) objects[1]).getY1(), 
					((Perspective) objects[1]).getX2(), 
					((Perspective) objects[1]).getY2() );			
			perspective2.setCoordinates( 
					((Perspective) objects[2]).getX1(), 
					((Perspective) objects[2]).getY1(), 
					((Perspective) objects[2]).getX2(), 
					((Perspective) objects[2]).getY2() );						
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
