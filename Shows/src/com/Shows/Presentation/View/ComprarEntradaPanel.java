package com.Shows.Presentation.View;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ComprarEntradaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8173915658769528191L;
	private JButton ComparEntradabtn;

	/**
	 * Create the panel.
	 */
	public ComprarEntradaPanel() {

		ComparEntradabtn = new JButton("Comprar Entrada");
		add(ComparEntradabtn);

	}

	public JButton getComparEntradabtn() {
		return ComparEntradabtn;
	}

}
