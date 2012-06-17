package com.Shows.Presentation.View;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ComprarEntradaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton comparEntradaButton;

	public ComprarEntradaPanel() {

		comparEntradaButton = new JButton("Comprar Entrada");
		add(comparEntradaButton);
	}

	public JButton getComparEntradaButton() {
		return comparEntradaButton;
	}
}
