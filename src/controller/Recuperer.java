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
			vignette.setFichierImage(data.getVignette().getFichierImage());
			perspective1.init(data.getPerspective1().getFichierImage(), data.getPerspective1().getX2(), data.getPerspective1().getY2());
			perspective2.init(data.getPerspective2().getFichierImage(), data.getPerspective2().getX2(), data.getPerspective2().getY2());			
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
