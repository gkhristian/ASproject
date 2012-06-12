package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.Set;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Shows.Domain.Exception.noHiHaRepresentacions;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.toedter.calendar.JDateChooser;

public class EspectaclePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ComprarEntradaController comprarEntradaController;
	private Date data1 = Date.valueOf("2012-07-31");
	private JComboBox espectacleComboBox;
	private JDateChooser dateChooser;

	private JButton continuaButton;
	private JButton cancelaButton;

	/**
	 * Create the frame.
	 */
	public EspectaclePanel(
			final ComprarEntradaController comprarEntradaController) {
		this.comprarEntradaController = comprarEntradaController;

		setLayout(new BorderLayout(0, 0));

		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);

		Component verticalStrut = Box.createVerticalStrut(120);
		verticalBox.add(verticalStrut);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		JLabel lblSeleccioniEspectacleI = new JLabel(
				"Seleccioni espectacle i data ");
		horizontalBox_1.add(lblSeleccioniEspectacleI);

		espectacleComboBox = new JComboBox();
		horizontalBox_1.add(espectacleComboBox);

		/***** DataChooser *****/
		dateChooser = new JDateChooser();

		horizontalBox_1.add(dateChooser);

		Component verticalStrut_1 = Box.createVerticalStrut(120);
		verticalBox.add(verticalStrut_1);

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
				} catch (noHiHaRepresentacions e) {
					// TODO Excepción por mostrar!!!
					e.printStackTrace();
				}

			}
		});

		cancelaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				comprarEntradaController.PrCancellar();
			}
		});

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
	}

	public void setEspectacleComboBox(Set<String> espectacles) {

		Vector<String> espectaclesVector = new Vector<String>();

		for (String titol : espectacles) {
			espectaclesVector.add(titol);
		}

		DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(
				espectaclesVector);

		espectacleComboBox.setModel(defaultComboBoxModel);

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
