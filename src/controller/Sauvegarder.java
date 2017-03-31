package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sauvegarder extends Commande {

	private File sauvegarde;

	/**
	 * Constructeur
	 * @param sauvegarde le fichier cible de la sauvegarde.
	 */
	public Sauvegarder(File sauvegarde) {
		this.sauvegarde = sauvegarde;
	}

	/**
	 * Effectuer la sauvegarde.
	 * @return
	 */
	@Override
	public void faire() {
		Object[] objects = new Object[9];
		objects[0] = photo.getFichierPhoto();
		objects[1] = perspective1.getX1();
		objects[2] = perspective1.getY1();
		objects[3] = perspective1.getX2();
		objects[4] = perspective1.getY2();
		objects[5] = perspective2.getX1();
		objects[6] = perspective2.getY1();
		objects[7] = perspective2.getX2();
		objects[8] = perspective2.getY2();
				
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sauvegarde));) {
			oos.writeObject(objects);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Il est interdit d'appeler cette méthode!
	 * @throws NoSuchMethodError
	 */
	@Override
	public void defaire() {
		// Ne pas appeler cette méthode!
		throw new NoSuchMethodError();
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
