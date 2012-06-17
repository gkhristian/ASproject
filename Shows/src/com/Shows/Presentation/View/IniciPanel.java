package com.Shows.Presentation.View;

import javax.swing.JButton;
import javax.swing.JPanel;

public class IniciPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton comparEntradaButton;
	private JButton consultaRepresentacioButton;
	private JButton consultaOcupacioButton;

	public IniciPanel() {

		comparEntradaButton = new JButton("Comprar Entrada");
		add(comparEntradaButton);

		consultaRepresentacioButton = new JButton("Consulta Representaci�");
		add(consultaRepresentacioButton);

		consultaOcupacioButton = new JButton("Consulta Ocupaci�");
		add(consultaOcupacioButton);
	}

	public JButton getComparEntradaButton() {
		return comparEntradaButton;
	}

	public JButton getConsultaRepresentacioButton() {
		return consultaRepresentacioButton;
	}

	public JButton getConsultaOcupacioButton() {
		return consultaOcupacioButton;
	}
}
