package com.Shows.Presentation.View.Component;

import javax.swing.JCheckBox;

import com.Shows.TupleTypes.PosicioSeient;

public class JSeient extends JCheckBox {

	private static final long serialVersionUID = 1L;
	
	private PosicioSeient posicioSeient;
	
	public JSeient(PosicioSeient posicioSeient) {
		this.setPosicioSeient(posicioSeient);
	}

	public PosicioSeient getPosicioSeient() {
		return posicioSeient;
	}

	public void setPosicioSeient(PosicioSeient posicioSeient) {
		this.posicioSeient = posicioSeient;
	}
}
