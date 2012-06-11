package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.TupleTypes.PosicioSeient;

public class SeientsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8834919801528392136L;
	private JPanel contentPane;
	private JTable table;
	private ComprarEntradaController comprarEntradaController;

	/**
	 * Create the frame.
	 */
	public SeientsPanel(final ComprarEntradaController comprarEntradaController) {

		this.comprarEntradaController = comprarEntradaController;
		setLayout(new BorderLayout(0, 0));
		
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);

		Box verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_1);

		JLabel EspectacleLbl = new JLabel("Espectacle:");
		horizontalBox_1.add(EspectacleLbl);

		JLabel NomEspectacleLbl = new JLabel("New label");
		horizontalBox_1.add(NomEspectacleLbl);

		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_2);

		JLabel DataLbl = new JLabel("Data:");
		horizontalBox_2.add(DataLbl);

		JLabel DataEspectacleLbl = new JLabel("New Label");
		horizontalBox_2.add(DataEspectacleLbl);

		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_4);

		JLabel LocalLbl = new JLabel("Local:");
		horizontalBox_4.add(LocalLbl);

		JLabel NomLocalLbl = new JLabel("New label");
		horizontalBox_4.add(NomLocalLbl);

		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_3);

		JLabel SessioLbl = new JLabel("Sessio:");
		horizontalBox_3.add(SessioLbl);

		JLabel TipusSessioLbl = new JLabel("New label");
		horizontalBox_3.add(TipusSessioLbl);

		Box horizontalBox_5 = Box.createHorizontalBox();
		horizontalBox_5.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_5);

		JLabel NombreEspectadorsLbl = new JLabel("Nombre d'espectadors:");
		horizontalBox_5.add(NombreEspectadorsLbl);

		JLabel NumeroEspectadorsLbl = new JLabel("New label");
		horizontalBox_5.add(NumeroEspectadorsLbl);

		Box horizontalBox_6 = Box.createHorizontalBox();
		horizontalBox_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_6);

		JLabel EsEstrenaLbl = new JLabel("New label");
		horizontalBox_6.add(EsEstrenaLbl);

		Box horizontalBox_8 = Box.createHorizontalBox();
		horizontalBox_8.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_8);

		JLabel PreuSeientsLbl = new JLabel("Preu per seient:");
		horizontalBox_8.add(PreuSeientsLbl);

		JLabel PreuPerSeientEurosLbl = new JLabel("New label");
		horizontalBox_8.add(PreuPerSeientEurosLbl);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);

		Box horizontalBox_7 = Box.createHorizontalBox();
		horizontalBox_7.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_7);

		JLabel OcupatLbl = new JLabel("Ocupat");
		horizontalBox_7.add(OcupatLbl);

		Box horizontalBox_9 = Box.createHorizontalBox();
		horizontalBox_9.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_9);
		JLabel DisponibleLbl = new JLabel("Disponible");
		horizontalBox_9.add(DisponibleLbl);

		Box horizontalBox_10 = Box.createHorizontalBox();
		horizontalBox_10.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_10);
		JLabel SeleccionatLbl = new JLabel("Seleccionat");
		horizontalBox_10.add(SeleccionatLbl);

		table = new JTable();
		table.setToolTipText("");
		horizontalBox.add(table);

		Box horizontalBox_11 = Box.createHorizontalBox();
		add(horizontalBox_11, BorderLayout.SOUTH);
		JLabel MessageAreaLbl = new JLabel("");
		horizontalBox_11.add(MessageAreaLbl);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_11.add(horizontalGlue);

		JButton ContinuaBtn = new JButton("Continua");
		ContinuaBtn.setEnabled(false);
		horizontalBox_11.add(ContinuaBtn);

		JButton CancelaBtn = new JButton("Cancel\u00B7la");
		horizontalBox_11.add(CancelaBtn);

		ContinuaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				// TODO mirar el flujo de datos y modificar datos

				Set<PosicioSeient> seients = null;
				seients.add(new PosicioSeient(1, 1));
				comprarEntradaController.PrOkSelecionarSeients(seients);

			}
		});

		CancelaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				comprarEntradaController.PrCancellarAvis();
			}
		});

	}

}
