package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.Shows.Domain.Exceptions.PagamentNoAutoritzat;
import com.Shows.Domain.Exceptions.ServeiNoDisponible;
import com.Shows.Domain.Model.ShowsCom;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.Presentation.View.Renderer.PromptComboBoxRenderer;
import com.Shows.TupleTypes.DadesEntrada;
import java.awt.Font;

public class PagamentPanel extends JPanel implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	private ComprarEntradaController comprarEntradaController;
	private IniciView comprarEntradaView;

	private JFormattedTextField numeroDniFormattedTextField;
	private JFormattedTextField bancFormattedTextField;
	private JFormattedTextField compteFormattedTextField;

	private JLabel preuTotalEurosLabel;

	private JComboBox monedaComboBox;

	private JButton continuaButton;

	private Object monedaComboBoxSelectetItem;

	/**
	 * Create the frame.
	 * 
	 * @param comprarEntradaView
	 */
	public PagamentPanel(
			final ComprarEntradaController comprarEntradaController,
			final IniciView comprarEntradaView) {

		this.comprarEntradaController = comprarEntradaController;
		this.comprarEntradaView = comprarEntradaView;

		setLayout(new BorderLayout(0, 0));

		Box verticalBox_1 = Box.createVerticalBox();
		add(verticalBox_1, BorderLayout.CENTER);

		Box horizontalBox_10 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_10);

		MaskFormatter DNIMaskFormatter = null;
		MaskFormatter bankMaskFormatter = null;
		MaskFormatter compteMaskFormatter = null;
		try {
			DNIMaskFormatter = new MaskFormatter("########-U");
			bankMaskFormatter = new MaskFormatter("####");
			compteMaskFormatter = new MaskFormatter("#### ## ## ########");
		} catch (ParseException parseException) {
			parseException.printStackTrace();
		}
		DNIMaskFormatter.setPlaceholderCharacter('_');
		bankMaskFormatter.setPlaceholderCharacter('_');
		compteMaskFormatter.setPlaceholderCharacter('_');
		DNIMaskFormatter.setCommitsOnValidEdit(true);
		bankMaskFormatter.setCommitsOnValidEdit(true);
		compteMaskFormatter.setCommitsOnValidEdit(true);

		JLabel DniLbl = new JLabel("DNI:");
		DniLbl.setBorder(new EmptyBorder(0, 0, 0, 10));
		horizontalBox_10.add(DniLbl);

		numeroDniFormattedTextField = new JFormattedTextField(DNIMaskFormatter);
		numeroDniFormattedTextField.addPropertyChangeListener("value", this);
		horizontalBox_10.add(numeroDniFormattedTextField);
		numeroDniFormattedTextField.setColumns(9);

		Component verticalStrut_2 = Box.createVerticalStrut(10);
		verticalBox_1.add(verticalStrut_2);

		Box horizontalBox_12 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_12);

		JLabel CompteLbl = new JLabel("Compte:");
		CompteLbl.setBorder(new EmptyBorder(0, 0, 0, 10));
		horizontalBox_12.add(CompteLbl);

		bancFormattedTextField = new JFormattedTextField(bankMaskFormatter);
		bancFormattedTextField.addPropertyChangeListener("value", this);
		horizontalBox_12.add(bancFormattedTextField);
		bancFormattedTextField.setColumns(4);

		compteFormattedTextField = new JFormattedTextField(compteMaskFormatter);
		compteFormattedTextField.addPropertyChangeListener("value", this);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		horizontalBox_12.add(horizontalStrut_1);
		horizontalBox_12.add(compteFormattedTextField);
		compteFormattedTextField.setColumns(16);

		Box horizontalBox_9 = Box.createHorizontalBox();
		horizontalBox_9.setBorder(new EmptyBorder(10, 0, 0, 0));
		verticalBox_1.add(horizontalBox_9);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_9.add(horizontalGlue_1);

		JLabel PreuTotalLbl = new JLabel("Preu Total:");
		PreuTotalLbl.setFont(new Font("Arial", Font.BOLD, 16));
		PreuTotalLbl.setBorder(new EmptyBorder(0, 0, 0, 10));
		horizontalBox_9.add(PreuTotalLbl);

		preuTotalEurosLabel = new JLabel("");
		preuTotalEurosLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		horizontalBox_9.add(preuTotalEurosLabel);

		monedaComboBox = new JComboBox();
		monedaComboBox.setRenderer(new PromptComboBoxRenderer("Divisa..."));
		horizontalBox_9.add(monedaComboBox);
		
		Component verticalStrut_1 = Box.createVerticalStrut(160);
		verticalBox_1.add(verticalStrut_1);

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

		JButton cancelaButton = new JButton("Cancel\u00B7la");
		horizontalBox_11.add(cancelaButton);

		continuaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					comprarEntradaController.PrOkPagament(
							numeroDniFormattedTextField.getValue().toString(),
							Integer.parseInt(bancFormattedTextField.getValue()
									.toString()), compteFormattedTextField
									.getValue().toString());
				} catch (PagamentNoAutoritzat pagamentNoAutoritzat) {
					comprarEntradaView.mostraMissatge(pagamentNoAutoritzat
							.getMessage());
					pagamentNoAutoritzat.printStackTrace();
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

	public void setDadesEntrada(DadesEntrada dadesEntrada) {

		setPreu(dadesEntrada.getPreu());

		monedaComboBox.setModel(new DefaultComboBoxModel(dadesEntrada
				.getCanvis().toArray()));

		monedaComboBoxSelectetItem = ShowsCom.getInstance().getDivisa()
				.toString();

		monedaComboBox.setSelectedItem(monedaComboBoxSelectetItem);

		setMinimumSize(new Dimension(50, 20));

		monedaComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if (monedaComboBoxSelectetItem != monedaComboBox
						.getSelectedItem()) {
					try {
						comprarEntradaController
								.canviPreuMoneda((String) monedaComboBox
										.getSelectedItem());

						monedaComboBoxSelectetItem = monedaComboBox
								.getSelectedItem();

					} catch (ServeiNoDisponible serveiNoDisponible) {
						comprarEntradaView.mostraMissatge(serveiNoDisponible
								.getMessage());
						// serveiNoDisponible.printStackTrace();
					}
				}
				setEnableContinua();
			}
		});
	}

	public void setPreu(float preu) {
		preuTotalEurosLabel.setText(Float.toString(preu));
	}

	private void setEnableContinua() {
		int bancLength = 0, dniLength = 0, compteLength = 0;

		if (bancFormattedTextField.getValue() != null)
			bancLength = bancFormattedTextField.getValue().toString().length();

		if (numeroDniFormattedTextField.getValue() != null)
			dniLength = numeroDniFormattedTextField.getValue().toString()
					.length();

		if (compteFormattedTextField.getValue() != null)
			compteLength = compteFormattedTextField.getValue().toString()
					.length();

		continuaButton.setEnabled((monedaComboBox.getSelectedIndex() > -1
				&& bancLength > 3 && compteLength > 15 && dniLength > 8));
	}

	@Override
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
		setEnableContinua();
	}
}