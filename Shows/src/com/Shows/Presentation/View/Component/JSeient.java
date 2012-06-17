package com.Shows.Presentation.View.Component;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import com.Shows.TupleTypes.PosicioSeient;

public class JSeient extends JCheckBox {

	private static final long serialVersionUID = 1L;

	private PosicioSeient posicioSeient;

	public JSeient(PosicioSeient posicioSeient) {
		this.setPosicioSeient(posicioSeient);

		setIcon(new ImageIcon("assets/gfx/icons/iconLliure.png"));	
		setSelectedIcon(new ImageIcon("assets/gfx/icons/iconSeleccionat.png"));	
		setDisabledIcon(new ImageIcon("assets/gfx/icons/iconOcupat.png"));	
	}

	public PosicioSeient getPosicioSeient() {
		return posicioSeient;
	}

	public void setPosicioSeient(PosicioSeient posicioSeient) {
		this.posicioSeient = posicioSeient;
	}
}
