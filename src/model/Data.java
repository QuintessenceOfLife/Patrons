package model;

import java.io.Serializable;

public class Data implements Serializable {
	
	private static final long serialVersionUID = -771357032998808954L;
	private	Vignette vignette;
	private Perspective perspective1, perspective2;
	
	public Data(Vignette vignette, Perspective perspective1, Perspective perspective2) {
		this.vignette = vignette;
		this.perspective1 = perspective1;
		this.perspective2 = perspective2;
	}

	public Vignette getVignette() {
		return vignette;
	}

	public Perspective getPerspective1() {
		return perspective1;
	}

	public Perspective getPerspective2() {
		return perspective2;
	}
	
}
