package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Data;
import model.Perspective;
import model.Vignette;

public class Sauvegarder extends Commande implements ISauvegarder {

	private File sauvegarde;
	private Data data;
	
	/**
	 * Constructeur
	 * @param data tableau contenant les objets vignette, perspective1 et perspective2 à sauvegarder.
	 * @param sauvegarde le fichier cible de la sauvegarde.
	 */
	public Sauvegarder(Data data, File sauvegarde) {
		this.data = data;
		this.sauvegarde = sauvegarde;
		gestionnaire.executerCommande(this);
	}

	/**
	 * Effectuer la sauvegarde.
	 * @return
	 */
	@Override
	public boolean faire() {
		//TODO remove this debug --------------------------------------------------------------------------
//		System.out.println(((Vignette) data[0]).getFichierImage().toString());
//		System.out.println(((Perspective) data[1]).getX2());
//		System.out.println(((Perspective) data[2]).getY2());
		//---------------------------------------------------------------------------------------------------
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sauvegarde));) {			
			oos.writeObject(data);			
		} catch (IOException e) {
			e.printStackTrace();
		} 		
		return false;
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
