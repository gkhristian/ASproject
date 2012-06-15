package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Shows.Domain.Exceptions.NoHiHaRepresentacions;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.Presentation.View.Renderer.PromptComboBoxRenderer;
import com.toedter.calendar.JDateChooser;

public class EspectaclePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox espectacleComboBox;
	private JDateChooser dateChooser;

	private JButton continuaButton;
	private JButton cancelaButton;

	/**
	 * Create the frame.
	 * 
	 * @param comprarEntradaView
	 */
	public EspectaclePanel(
			final ComprarEntradaController comprarEntradaController,
			final ComprarEntradaView comprarEntradaView) {

		setLayout(new BorderLayout(0, 0));

		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);

		Component verticalStrut_1 = Box.createVerticalStrut(150);
		verticalBox.add(verticalStrut_1);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox_1);

		JLabel seleccioniEspectacleLabel = new JLabel(
				"Seleccioni espectacle i data: ");
		horizontalBox_1.add(seleccioniEspectacleLabel);

		espectacleComboBox = new JComboBox();
		espectacleComboBox.setToolTipText("Espectacles");
		espectacleComboBox.setMaximumRowCount(30);

		espectacleComboBox.setRenderer(new PromptComboBoxRenderer(
				"Espectacle..."));

		horizontalBox_1.add(espectacleComboBox);
		dateChooser = new JDateChooser();

		dateChooser.setMinimumSize(new Dimension(100, 20));

		horizontalBox_1.add(dateChooser);

		dateChooser.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {

					@Override
					public void propertyChange(
							PropertyChangeEvent propertyChangeEvent) {
						if ("date".equals(propertyChangeEvent.getPropertyName())) {
							System.out.println(propertyChangeEvent
									.getPropertyName()
									+ ": "
									+ (java.util.Date) propertyChangeEvent
											.getNewValue());
							setEnableContinua();
						}
					}
				});

		Component verticalStrut = Box.createVerticalStrut(150);
		verticalBox.add(verticalStrut);

		/***** DataChooser *****/

		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox, BorderLayout.SOUTH);

		JLabel MessageAreaLbl = new JLabel("");
		horizontalBox.add(MessageAreaLbl);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		continuaButton = new JButton("Continua");
		continuaButton.setEnabled(false);
		horizontalBox.add(continuaButton);

		cancelaButton = new JButton("Cancel\u00B7la");
		horizontalBox.add(cancelaButton);

		continuaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					java.sql.Date date = new java.sql.Date(dateChooser
							.getDate().getTime());

					comprarEntradaController.PrOkObteRepresentacions(
							espectacleComboBox.getSelectedItem().toString(),
							date);
				} catch (NoHiHaRepresentacions noHiHaRepresentacions) {
					comprarEntradaView.mostraMissatge(noHiHaRepresentacions
							.getMessage());
					// noHiHaRepresentacions.printStackTrace();
				}
			}
		});

		cancelaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				comprarEntradaController.PrCancellar();
			}
		});
	}

	public void setEspectacleComboBox(Set<String> espectacles) {

		Vector<String> espectaclesVector = new Vector<String>();

		for (String titol : espectacles) {
			espectaclesVector.add(titol);
		}

		DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(
				espectaclesVector);

		espectacleComboBox.setModel(defaultComboBoxModel);

		espectacleComboBox.setSelectedIndex(-1);

		espectacleComboBox.setMinimumSize(new Dimension(200, 20));

		espectacleComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setEnableContinua();
			}
		});
	}

	private void setEnableContinua() {
		continuaButton
				.setEnabled((dateChooser.getDate() != null && espectacleComboBox
						.getSelectedIndex() > -1));
	}
}
