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
* Nom du fichier: CtrlPerspective.java
* Date cree: 2017-03-23
*******************************************************/
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;
import model.Perspective;
import vue.FenetrePerspective;
import controller.Zoom;
import controller.Translater;

/*****************************************************************************
 * Classe abstraite qui permet l'ajout de methodes et de variables que
 * necessiterait une commande.
 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
 *****************************************************************************/
public class CtrlPerspective {
	
	/*****************************
	 * VARIABLES
	 *****************************/
	private final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
	private int numFenetre;
	private Perspective perspective;
	private int initialDragOriginX, initialDragOriginY;
	private int subsequentDragOriginX, subsequentDragOriginY;
	private double initialSX1, initialSY1, initialSX2, initialSY2;
	private static final double FACTEUR_ZOOM = 0.1;
	private Timer timer;
	private static final int DELAI = 200; 
	
	/*****************************
	 * CONSTRUCTEUR
	 * @param fenPerspective
	 * @param perspective
	 *****************************/
	public CtrlPerspective(FenetrePerspective fenPerspective, Perspective perspective) {		
		numFenetre = fenPerspective.getNumFenetre();		
		fenPerspective.setZoomListener(new IncrementalZoomListener());
		fenPerspective.setTranslateListener(new TranslateListener());
		fenPerspective.setMousePressedListener(new MousePressedListener());
		fenPerspective.setMouseReleasedListener(new MouseReleasedListener());
		this.perspective = perspective;
		timer = new Timer(DELAI, new TotalZoomListener());
		timer.setRepeats(false);
	}	
	
	/**
	 * Classe interne qui détecte le mouvement d'un scroll de la souris
	 * et effectue un zoom.
	 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
	 */
	private class IncrementalZoomListener extends MouseAdapter {
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			/*
			 * On prend les coordonnées de la souris.
			 * On prend les coordonnées de départ de la photo.
			 * On vérifie le sens du zoom.
			 * Une photo ne peut pas dépasser 20000x20000 ni être plus petit que 50x50
			 * On ne peut zoomer que dans l'image.
			 * On initialise les données s'il n'y en avait pas
			 * On calcule les coordonnées de fin
			 * On effectue le zoom
			 */
			int wheelX = e.getX();
			int wheelY = e.getY();
			
			double x1 = perspective.getX1();
			double x2 = perspective.getX2();
			double y1 = perspective.getY1();
			double y2 = perspective.getY2();
			
			int notches;
			if (e.getWheelRotation() < 0) {
				notches = 1;
				if ( (x2-x1) >= 20000 || (y2-y1) >= 20000 )
					return; //on sort si la largeur ou la hauteur max est atteinte
			} else {
				notches = -1;
				if ( (x2-x1) <= 50 || (y2-y1) <= 50 )
					return; //on sort si la largeur ou la hauteur min est atteinte
			}
			if ( wheelX <= x1 || wheelX >= x2 || wheelY <= y1 || wheelY >= y2 )
				return; //on sort si le curseur est en dehors de l'image
			
			if (initialSY2 == 0) {
				initialSX1 = x1;
				initialSY1 = y1;
				initialSX2 = x2;
				initialSY2 = y2;
			}			
			
			double dx1 = x1 - (wheelX - x1) * notches * FACTEUR_ZOOM;
			double dy1 = y1 - (wheelY - y1) * notches * FACTEUR_ZOOM;
			double dx2 = x2 + (x2 - wheelX) * notches * FACTEUR_ZOOM;
			double dy2 = y2 + (y2 - wheelY) * notches * FACTEUR_ZOOM;
			
			(new Zoom(numFenetre, x1, y1, x2, y2, dx1, dy1, dx2, dy2)).faire();
			
			timer.restart();
		}		
	}
	
	/**
	 * Classe interne qui detecte l'arrêt d'un zoom
	 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
	 */
	private class TotalZoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { 
        	/*
        	 * Si les coordonnées initiales sont égales aux coordonnées de fin, on ne fait rien.
        	 * Sinon, on fait un zoom et on ajoute le defaire dans le zoom.
        	 * On ajoute dans la liste la commande effectuée.
        	 * On reset la donnée initiale
        	 */
        	if ( perspective.getX1() == initialSX1 && 
        		 perspective.getY1() == initialSY1 &&	
        		 perspective.getX2() == initialSX2 &&
        		 perspective.getY2() == initialSY2 )
        		return;
        	
        	Zoom zoom = new Zoom(numFenetre, initialSX1, initialSY1, initialSX2, initialSY2, 
        			perspective.getX1(), perspective.getY1(), perspective.getX2(), perspective.getY2());
        	
        	CommandeDecorator decoratedZoom = new CommandeDecorator(zoom) {	
				@Override
				public void defaire() {
					if (numFenetre == 1)
						perspective1.setCoordinates(zoom.getSX1(), zoom.getSY1(), zoom.getSX2(), zoom.getSY2());
					else if (numFenetre == 2)
						perspective2.setCoordinates(zoom.getSX1(), zoom.getSY1(), zoom.getSX2(), zoom.getSY2());					
				}
			}; 
			
			gestionnaire.addToDone(decoratedZoom, numFenetre);
            gestionnaire.clearUndoneList(numFenetre);
            initialSY2 = 0;            
        }
    }
	
	/**
	 * Classe interne qui detecte le mouvement d'un drag de la souris après un clic
	 * et effectue une translation.
	 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
	 */
	private class TranslateListener extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			(new Translater(numFenetre, e.getX(), e.getY(), subsequentDragOriginX, subsequentDragOriginY)).faire();
			subsequentDragOriginX = e.getX();
			subsequentDragOriginY = e.getY();
		}
	}
	
	/**
	 * Classe interne qui detecte le mouvement d'un clic de la souris 
	 * et enregistre les coordonnées initiales.
	 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
	 */
	private class MousePressedListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			initialDragOriginX = e.getX();
			initialDragOriginY = e.getY();
			subsequentDragOriginX = e.getX();
			subsequentDragOriginY = e.getY();			
		}
	}
	
	/**
	 * Classe interne qui detecte le mouvement d'un release de la souris 
	 * et enregistre les coordonnées pour effectuer la translation totale.
	 * @author Youssef Soliman, Yassine Abdellaoui, Raph Jobin, Victor Trinh
	 */
	private class MouseReleasedListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			/*
			 * Enregistrement des coordonnées de fin.
			 * Faire la translation.
			 * Ajouter la commande dans la bonne liste.
			 */
			if ((e.getX() == initialDragOriginX) && (e.getY() == initialDragOriginY))
				return;
			
			Translater translater = new Translater(numFenetre, e.getX(), e.getY(), initialDragOriginX, initialDragOriginY);
			CommandeDecorator decoratedTranslater = new CommandeDecorator(translater) {				
				@Override
				public void defaire() {
					if (numFenetre == 1)
						perspective1.translater(-1 * translater.getDeltaX(), -1 * translater.getDeltaY());
					else if (numFenetre == 2)
						perspective2.translater(-1 * translater.getDeltaX(), -1 * translater.getDeltaY());					
				}
			};
			gestionnaire.addToDone(decoratedTranslater, numFenetre);
			gestionnaire.clearUndoneList(numFenetre);
		}
	}
		
}
