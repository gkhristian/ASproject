package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Shows.Domain.Exceptions.SeientsNoOk;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.Presentation.View.Component.JSeient;
import com.Shows.TupleTypes.PosicioSeient;

public class SeientsPanel extends JPanel {

	private static final long serialVersionUID = -8834919801528392136L;

	private JPanel seientsPanel;

	private JButton continuaButton;

	private HashSet<PosicioSeient> selectedSeients;

	/**
	 * Create the frame.
	 * 
	 * @param comprarEntradaView
	 */
	public SeientsPanel(
			final ComprarEntradaController comprarEntradaController,
			final ComprarEntradaView comprarEntradaView) {

		setLayout(new BorderLayout(0, 0));

		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);

		Box horizontalBox_12 = Box.createHorizontalBox();
		horizontalBox.add(horizontalBox_12);

		Box verticalBox = Box.createVerticalBox();
		horizontalBox_12.add(verticalBox);

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

		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox_12.add(verticalBox_1);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue);

		seientsPanel = new JPanel();
		verticalBox_1.add(seientsPanel);

		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue_1);

		Box horizontalBox_11 = Box.createHorizontalBox();
		add(horizontalBox_11, BorderLayout.SOUTH);
		JLabel MessageAreaLbl = new JLabel("");
		horizontalBox_11.add(MessageAreaLbl);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_11.add(horizontalGlue);

		continuaButton = new JButton("Continua");
		continuaButton.setEnabled(false);
		horizontalBox_11.add(continuaButton);

		JButton cancelaButton = new JButton("Cancel\u00B7la");
		horizontalBox_11.add(cancelaButton);

		continuaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				try {
					comprarEntradaController
							.PrOkSelecionarSeients(selectedSeients);
				} catch (SeientsNoOk seientsNoOk) {
					comprarEntradaView.mostraMissatge(seientsNoOk.getMessage());
					// seientsNoOk.printStackTrace();
				}

			}
		});

		cancelaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				comprarEntradaController.PrCancellar();
			}
		});
	}

	public void setSeients(Set<PosicioSeient> seients) {

		PosicioSeient[] dades = seients.toArray(new PosicioSeient[0]);

		int maxFila = 0;
		int maxColumna = 0;
		for (int i = 0; i < dades.length; i++) {
			if (maxFila < dades[i].getFila())
				maxFila = dades[i].getFila();
			if (maxColumna < dades[i].getColumna())
				maxColumna = dades[i].getColumna();
		}

		JPanel[][] panelHolder = new JPanel[maxFila][maxColumna];
		JSeient[][] holder = new JSeient[maxFila][maxColumna];

		seientsPanel.removeAll();

		selectedSeients = new HashSet<PosicioSeient>();

		seientsPanel.setLayout(new GridLayout(maxFila, maxColumna));

		for (int m = 0; m < maxFila; m++) {
			for (int n = 0; n < maxColumna; n++) {
				panelHolder[m][n] = new JPanel();
				holder[m][n] = new JSeient(new PosicioSeient(m + 1, n + 1));
				holder[m][n].setEnabled(false);
				panelHolder[m][n].add(holder[m][n]);
				seientsPanel.add(panelHolder[m][n]);
			}
		}

		int m, n;
		for (int i = 0; i < dades.length; i++) {
			m = dades[i].getFila() - 1;
			n = dades[i].getColumna() - 1;
			holder[m][n].setEnabled(true);
			holder[m][n].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent mouseEvent) {
					JSeient jSeient = (JSeient) mouseEvent.getSource();
					if (jSeient.isSelected())
						selectedSeients.add(jSeient.getPosicioSeient());
					else
						selectedSeients.remove(jSeient.getPosicioSeient());
					setEnableContinua();
				}
			});
		}
	}

	private void setEnableContinua() {
		continuaButton.setEnabled((selectedSeients.size() > 0));
	}
}
