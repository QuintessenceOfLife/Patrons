package controller;

public abstract class DecoratorPerspective extends CommandeDecorator {
	
	protected final static GestionnaireCmd gestionnaire = GestionnaireCmd.getGestionnaireCmd();
	
	public DecoratorPerspective(Commande command) {
		super(command);
	}
	
	public abstract void defaire();
	
}
