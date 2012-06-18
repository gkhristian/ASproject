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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Shows.Domain.Exceptions.NoHiHaRepresentacions;
import com.Shows.Presentation.Controller.FrontController;
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
	public EspectaclePanel(final FrontController frontController,
			final ComprarEntradaView comprarEntradaView) {

		setLayout(new BorderLayout(0, 0));

		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);

		Component verticalStrut_1 = Box.createVerticalStrut(110);
		verticalBox.add(verticalStrut_1);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox_1);

		Component horizontalStrut = Box.createHorizontalStrut(10);
		horizontalBox_1.add(horizontalStrut);

		JLabel seleccioniEspectacleLabel = new JLabel(
				"Seleccioni espectacle i data: ");
		seleccioniEspectacleLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		horizontalBox_1.add(seleccioniEspectacleLabel);

		espectacleComboBox = new JComboBox();
		espectacleComboBox.setPreferredSize(new Dimension(150, 22));
		espectacleComboBox.setMaximumSize(new Dimension(150, 22));
		espectacleComboBox.setToolTipText("Espectacles");
		espectacleComboBox.setMaximumRowCount(30);
		espectacleComboBox.setMinimumSize(new Dimension(150, 22));

		espectacleComboBox.setRenderer(new PromptComboBoxRenderer(
				"Espectacle..."));

		horizontalBox_1.add(espectacleComboBox);
		dateChooser = new JDateChooser();
		dateChooser.setPreferredSize(new Dimension(170, 22));
		dateChooser.setMaximumSize(new Dimension(170, 22));
		JTextField dateEditor = (JTextField) dateChooser.getDateEditor()
				.getUiComponent();
		dateEditor.setEditable(false);

		Component horizontalStrut_2 = Box.createHorizontalStrut(10);
		horizontalBox_1.add(horizontalStrut_2);

		horizontalBox_1.add(dateChooser);
		dateChooser.setAlignmentX(Component.LEFT_ALIGNMENT);

		dateChooser.setMinimumSize(new Dimension(170, 22));

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

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_1);

		Component verticalStrut = Box.createVerticalStrut(150);
		verticalBox.add(verticalStrut);

		/***** DataChooser *****/

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new EmptyBorder(10, 0, 0, 0));
		add(horizontalBox, BorderLayout.SOUTH);

		JLabel MessageAreaLbl = new JLabel("");
		horizontalBox.add(MessageAreaLbl);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		continuaButton = new JButton("Continua");
		continuaButton.setEnabled(false);
		horizontalBox.add(continuaButton);

		Component horizontalStrut_3 = Box.createHorizontalStrut(10);
		horizontalBox.add(horizontalStrut_3);

		cancelaButton = new JButton("Cancel\u00B7la");
		horizontalBox.add(cancelaButton);

		continuaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					java.sql.Date date = new java.sql.Date(dateChooser
							.getDate().getTime());

					comprarEntradaView.setRepresentacionsString(espectacleComboBox
							.getSelectedItem().toString(), date.toString());

					frontController.PrOkObteRepresentacions(espectacleComboBox
							.getSelectedItem().toString(), date);
				} catch (NoHiHaRepresentacions noHiHaRepresentacions) {
					comprarEntradaView.mostraMissatge(noHiHaRepresentacions.getMessage());
					// noHiHaRepresentacions.printStackTrace();
				}
			}
		});

		cancelaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frontController.PrCancellar();
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
