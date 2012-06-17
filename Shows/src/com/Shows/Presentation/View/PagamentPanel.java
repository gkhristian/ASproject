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
import javax.swing.text.MaskFormatter;

import com.Shows.Domain.Exceptions.PagamentNoAutoritzat;
import com.Shows.Domain.Exceptions.ServeiNoDisponible;
import com.Shows.Domain.Model.ShowsCom;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.Presentation.View.Renderer.PromptComboBoxRenderer;
import com.Shows.TupleTypes.DadesEntrada;

public class PagamentPanel extends JPanel implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	private ComprarEntradaController comprarEntradaController;
	private ComprarEntradaView comprarEntradaView;

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
			final ComprarEntradaView comprarEntradaView) {

		this.comprarEntradaController = comprarEntradaController;
		this.comprarEntradaView = comprarEntradaView;

		setLayout(new BorderLayout(0, 0));
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox, BorderLayout.NORTH);

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

		Box horizontalBox_7 = Box.createHorizontalBox();
		horizontalBox_7.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_7);

		JLabel SeientsLbl = new JLabel("Seients");
		horizontalBox_7.add(SeientsLbl);

		JLabel TotsSeientsLbl = new JLabel("New label");
		horizontalBox_7.add(TotsSeientsLbl);

		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_1);

		Component verticalStrut = Box.createVerticalStrut(30);
		verticalBox_1.add(verticalStrut);

		Box horizontalBox_10 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_10);

		JLabel DniLbl = new JLabel("DNI:");
		horizontalBox_10.add(DniLbl);

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

		numeroDniFormattedTextField = new JFormattedTextField(DNIMaskFormatter);
		numeroDniFormattedTextField.addPropertyChangeListener("value", this);
		horizontalBox_10.add(numeroDniFormattedTextField);
		numeroDniFormattedTextField.setColumns(9);

		Component verticalStrut_2 = Box.createVerticalStrut(30);
		verticalBox_1.add(verticalStrut_2);

		Component verticalStrut_1 = Box.createVerticalStrut(30);
		verticalBox_1.add(verticalStrut_1);

		Box horizontalBox_12 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_12);

		JLabel CompteLbl = new JLabel("Compte:");
		horizontalBox_12.add(CompteLbl);

		bancFormattedTextField = new JFormattedTextField(bankMaskFormatter);
		bancFormattedTextField.addPropertyChangeListener("value", this);
		horizontalBox_12.add(bancFormattedTextField);
		bancFormattedTextField.setColumns(4);

		compteFormattedTextField = new JFormattedTextField(compteMaskFormatter);
		compteFormattedTextField.addPropertyChangeListener("value", this);
		horizontalBox_12.add(compteFormattedTextField);
		compteFormattedTextField.setColumns(16);

		Box horizontalBox_9 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_9);
		horizontalBox_9.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel PreuTotalLbl = new JLabel("Preu Total:");
		horizontalBox_9.add(PreuTotalLbl);

		preuTotalEurosLabel = new JLabel("");
		horizontalBox_9.add(preuTotalEurosLabel);

		monedaComboBox = new JComboBox();
		monedaComboBox.setRenderer(new PromptComboBoxRenderer("Divisa..."));
		horizontalBox_9.add(monedaComboBox);

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