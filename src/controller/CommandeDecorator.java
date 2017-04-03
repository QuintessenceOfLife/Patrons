package controller;

public abstract class CommandeDecorator extends Commande {
	
	private Commande command;

	public CommandeDecorator(Commande command) {
		this.command = command;
	}
	
	@Override
	public void faire() {
		command.faire();
	}
	
}
