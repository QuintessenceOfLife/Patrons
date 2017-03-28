package controller;

import model.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Perspective;
import vue.MenuEditer;
import vue.MenuFichier;

public class CtrlMenu implements ActionListener {
	
	private MenuFichier menuFichier;
	private MenuEditer menuEditer;
	private Image image;
	private Perspective perspective1;
	private Perspective perspective2;
	
	
	//TODO implement this controller
	
	/**
	 * Set the menus
	 * @param mf Menu fichier
	 * @param me Menu Editer
	 */
	public void setMenus(MenuFichier mf, MenuEditer me) {
		menuFichier = mf;
		menuEditer = me;
	}
	
	public void setPerspectives(Perspective v, Perspective p1, Perspective p2) {
		vignette = v;
		perspective1 = p1;
		perspective2 = p2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Ouvrir" : {
			Commande ouvrir = new Ouvrir(perspective1);
			ouvrir.faire();
			break;
		}
			case "Quitter" : {
				System.exit(0);
				break;
			}
		}
	}
	
	
}
