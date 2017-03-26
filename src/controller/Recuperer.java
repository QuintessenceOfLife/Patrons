package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.Data;
import model.Perspective;
import model.Vignette;

public class Recuperer extends Commande {

	private Vignette vignette;
	private Perspective perspective1, perspective2;
	private File sauvegarde;
	
	/**
	 * Constructeur
	 * @param vignette recevra les données de la vignette.
	 * @param perspective1 recevra les données de la première perspective.
	 * @param perspective2 recevra les données de la deuxième perspective.
	 * @param sauvegarde fichier contenant les données à récupérer.
	 */
	public Recuperer(Vignette vignette, Perspective perspective1, Perspective perspective2, File sauvegarde) {
		this.vignette = vignette;
		this.perspective1 = perspective1;
		this.perspective2 = perspective2;
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
			Data data = (Data) ois.readObject();	
			vignette = data.getVignette();
			perspective1 = data.getPerspective1();
			perspective2 = data.getPerspective2();
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
