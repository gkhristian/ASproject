package com.Shows.Presentation.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.Shows.Domain.Exceptions.NoHiHaRepresentacions;
import com.Shows.Domain.Exceptions.SeientsNoDisp;
import com.Shows.Domain.Model.TipusSessio;
import com.Shows.Presentation.Controller.FrontController;
import com.toedter.calendar.JDateChooser;

public class IniciPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton comparEntradaButton;
	private JButton consultaRepresentacioButton;
	private JButton consultaOcupacioButton;
	private Box verticalBox;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField titolEspectacleTextField;
	private Box verticalBox_1;
	private Box horizontalBox;
	private JLabel lblNewLabel;
	private Component horizontalStrut;
	private Component verticalStrut;
	private Box horizontalBox_1;
	private JTextField localTextField;
	private Box verticalBox_2;
	private JLabel lblNewLabel_1;
	private JSpinner espectadorsSpinner;
	private JLabel lblNewLabel_2;
	private JComboBox sessioComboBox;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component verticalStrut_4;
	private Box horizontalBox_2;
	private Box horizontalBox_3;
	private Component verticalStrut_1;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;

	public IniciPanel(final FrontController frontController,
			final IniciView iniciView) {

		verticalBox = Box.createVerticalBox();
		add(verticalBox);

		panel_2 = new JPanel();
		panel_2.setBackground(frontController.getBackgroundColor());
		verticalBox.add(panel_2);

		comparEntradaButton = new JButton("Comprar Entrada");
		comparEntradaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(comparEntradaButton);

		comparEntradaButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				frontController.PrComprarEntrada();
			}
		});

		verticalStrut = Box.createVerticalStrut(50);
		verticalBox.add(verticalStrut);

		horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		panel = new JPanel();
		horizontalBox_3.add(panel);
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Prova Cas d'\u00DAs",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBackground(frontController.getBackgroundColor());

		verticalBox_1 = Box.createVerticalBox();
		panel.add(verticalBox_1);

		horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);

		lblNewLabel = new JLabel("Títol espectacle: ");
		horizontalBox.add(lblNewLabel);

		horizontalStrut = Box.createHorizontalStrut(10);
		horizontalBox.add(horizontalStrut);

		titolEspectacleTextField = new JTextField();
		horizontalBox.add(titolEspectacleTextField);
		titolEspectacleTextField.setColumns(10);

		verticalStrut_1 = Box.createVerticalStrut(10);
		verticalBox_1.add(verticalStrut_1);

		final JDateChooser representacioDateChooser = new JDateChooser();

		representacioDateChooser.getDateEditor().addPropertyChangeListener(
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

							consultaRepresentacioButton
									.setEnabled((representacioDateChooser
											.getDate() != null));
						}
					}
				});

		verticalBox_1.add(representacioDateChooser);

		verticalStrut_4 = Box.createVerticalStrut(10);
		verticalBox_1.add(verticalStrut_4);

		consultaRepresentacioButton = new JButton("Consulta Representació");
		consultaRepresentacioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(consultaRepresentacioButton);
		consultaRepresentacioButton.setEnabled(false);

		horizontalStrut_4 = Box.createHorizontalStrut(10);
		horizontalBox_3.add(horizontalStrut_4);

		panel_1 = new JPanel();
		horizontalBox_3.add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Prova Cas d'\u00DAs",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBackground(frontController.getBackgroundColor());

		verticalBox_2 = Box.createVerticalBox();
		panel_1.add(verticalBox_2);

		horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_1);

		lblNewLabel_1 = new JLabel("Local: ");
		horizontalBox_1.add(lblNewLabel_1);

		horizontalStrut_2 = Box.createHorizontalStrut(10);
		horizontalBox_1.add(horizontalStrut_2);

		localTextField = new JTextField();
		horizontalBox_1.add(localTextField);
		localTextField.setColumns(10);

		horizontalStrut_1 = Box.createHorizontalStrut(10);
		horizontalBox_1.add(horizontalStrut_1);

		lblNewLabel_2 = new JLabel("Espectadors: ");
		horizontalBox_1.add(lblNewLabel_2);

		espectadorsSpinner = new JSpinner();
		espectadorsSpinner.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		horizontalBox_1.add(espectadorsSpinner);

		verticalStrut_2 = Box.createVerticalStrut(10);
		verticalBox_2.add(verticalStrut_2);

		horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_2);

		sessioComboBox = new JComboBox();
		horizontalBox_2.add(sessioComboBox);

		Vector<String> sessioVector = new Vector<String>();

		sessioVector.add(TipusSessio.mati.toString());
		sessioVector.add(TipusSessio.tarda.toString());
		sessioVector.add(TipusSessio.nit.toString());

		DefaultComboBoxModel model = new DefaultComboBoxModel(sessioVector);

		sessioComboBox.setModel(model);

		horizontalStrut_3 = Box.createHorizontalStrut(10);
		horizontalBox_2.add(horizontalStrut_3);

		final JDateChooser ocupacioDateChooser = new JDateChooser();

		ocupacioDateChooser.getDateEditor().addPropertyChangeListener(
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

							consultaOcupacioButton
									.setEnabled((ocupacioDateChooser.getDate() != null));
						}
					}
				});

		horizontalBox_2.add(ocupacioDateChooser);

		verticalStrut_3 = Box.createVerticalStrut(10);
		verticalBox_2.add(verticalStrut_3);

		consultaOcupacioButton = new JButton("Consulta Ocupació");
		consultaOcupacioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_2.add(consultaOcupacioButton);
		consultaOcupacioButton.setEnabled(false);

		consultaOcupacioButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				if (consultaOcupacioButton.isEnabled()) {

					java.sql.Date date = new java.sql.Date(ocupacioDateChooser
							.getDate().getTime());

					try {
						frontController.PrConsultaOcupacio(localTextField
								.getText(), TipusSessio.valueOf(sessioComboBox
								.getSelectedItem().toString()),
								(Integer) espectadorsSpinner.getValue(), date);
					} catch (SeientsNoDisp seientsNoDisp) {
						iniciView.mostraMissatge(seientsNoDisp.getMessage());
					}
				}
			}
		});

		consultaRepresentacioButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				if (consultaRepresentacioButton.isEnabled()) {
					java.sql.Date date = new java.sql.Date(
							representacioDateChooser.getDate().getTime());

					try {
						frontController.PrConsultaRepresentacio(
								titolEspectacleTextField.getText(), date);
					} catch (NoHiHaRepresentacions noHiHaRepresentacions) {
						iniciView.mostraMissatge(noHiHaRepresentacions
								.getMessage());
					}
				}
			}
		});
	}
}
