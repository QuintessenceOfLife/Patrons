package controller;

import model.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
	
	// TODO: Relook at this, maybe create other methods if during created there's no vignette or perspectives yet
	public CtrlMenu(Image image, Perspective perspective1, Perspective perspective2) {
		this.image = image;
		this.perspective1 = perspective1;
		this.perspective2 = perspective2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Ouvrir" : {
			// TODO
			new Ouvrir();
			break;
		}
			case "Quitter" : {
				System.exit(0);
				break;
			}
		}
	}
}
