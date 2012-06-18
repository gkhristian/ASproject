package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.Shows.Exceptions.SeientsNoOk;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.Presentation.View.Component.JSeient;
import com.Shows.TupleTypes.PosicioSeient;

public class SeientsPanel extends JPanel {

	private static final long serialVersionUID = -8834919801528392136L;

	private ComprarEntradaController comprarEntradaController;

	private JPanel seientsPanel;

	private JButton continuaButton;
	private JButton cancelaButton;

	private HashSet<PosicioSeient> selectedSeients;

	/**
	 * Create the frame.
	 * 
	 * @param comprarEntradaView
	 */
	public SeientsPanel(
			final ComprarEntradaController comprarEntradaController,
			final ComprarEntradaView comprarEntradaView) {

		this.comprarEntradaController = comprarEntradaController;

		setLayout(new BorderLayout(0, 0));

		Box verticalBox_1 = Box.createVerticalBox();
		add(verticalBox_1, BorderLayout.CENTER);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue);

		seientsPanel = new JPanel();
		seientsPanel.setBorder(new LineBorder(Color.BLACK));

		verticalBox_1.add(seientsPanel);

		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue_1);

		Box horizontalBox_11 = Box.createHorizontalBox();
		horizontalBox_11.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(horizontalBox_11, BorderLayout.SOUTH);
		JLabel MessageAreaLbl = new JLabel("");
		horizontalBox_11.add(MessageAreaLbl);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_11.add(horizontalGlue);

		continuaButton = new JButton("Continua");
		continuaButton.setEnabled(false);
		horizontalBox_11.add(continuaButton);

		Component horizontalStrut = Box.createHorizontalStrut(10);
		horizontalBox_11.add(horizontalStrut);

		cancelaButton = new JButton("Cancel\u00B7la");
		horizontalBox_11.add(cancelaButton);

		continuaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				try {

					String seients = new String();

					Iterator<PosicioSeient> iterator = selectedSeients
							.iterator();
					while (iterator.hasNext()) {
						PosicioSeient posicioSeient = (PosicioSeient) iterator
								.next();
						seients += "{" + posicioSeient.getFila() + ", "
								+ posicioSeient.getColumna() + "} ";
					}

					comprarEntradaView.setPagamentString(seients);

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

	public void setSeients(Set<PosicioSeient> seients, boolean simple) {

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

		seientsPanel.setBackground(comprarEntradaController
				.getBackgroundColor());

		for (int m = 0; m < maxFila; m++) {
			for (int n = 0; n < maxColumna; n++) {
				panelHolder[m][n] = new JPanel();

				holder[m][n] = new JSeient(new PosicioSeient(m + 1, n + 1));
				holder[m][n].setEnabled(false);

				panelHolder[m][n].add(holder[m][n]);

				holder[m][n].setBackground(comprarEntradaController
						.getBackgroundColor());
				panelHolder[m][n].setBackground(comprarEntradaController
						.getBackgroundColor());

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
		continuaButton.setVisible(!simple);
		cancelaButton.setVisible(!simple);
	}

	private void setEnableContinua() {
		continuaButton.setEnabled((selectedSeients.size() > 0));
	}
}
