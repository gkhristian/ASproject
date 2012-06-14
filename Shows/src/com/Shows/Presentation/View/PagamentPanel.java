package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Shows.Domain.Model.Moneda;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.TupleTypes.DadesEntrada;

public class PagamentPanel extends JPanel {

	private static final long serialVersionUID = 6594237397946129351L;

	private JPanel contentPane;
	private JTextField NumeroDniTextField;
	private JTextField BancTextField;
	private JTextField CompteTextField;
	private ComprarEntradaController comprarEntradaController;
	private JComboBox MonedaComboBox;

	/**
	 * Create the frame.
	 */
	public PagamentPanel(final ComprarEntradaController comprarEntradaController) {

		this.comprarEntradaController = comprarEntradaController;

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

		Box horizontalBox_9 = Box.createHorizontalBox();
		horizontalBox_9.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox_9);

		JLabel PreuTotalLbl = new JLabel("Preu Total:");
		horizontalBox_9.add(PreuTotalLbl);

		JLabel PreuTotalEurosLbl = new JLabel("New label");
		horizontalBox_9.add(PreuTotalEurosLbl);

		MonedaComboBox = new JComboBox();
		horizontalBox_9.add(MonedaComboBox);

		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_1);

		Component verticalStrut = Box.createVerticalStrut(30);
		verticalBox_1.add(verticalStrut);

		Box horizontalBox_10 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_10);

		JLabel DniLbl = new JLabel("DNI:");
		horizontalBox_10.add(DniLbl);

		NumeroDniTextField = new JTextField();
		horizontalBox_10.add(NumeroDniTextField);
		NumeroDniTextField.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(30);
		verticalBox_1.add(verticalStrut_1);

		Box horizontalBox_12 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_12);

		JLabel CompteLbl = new JLabel("Compte:");
		horizontalBox_12.add(CompteLbl);

		BancTextField = new JTextField();
		horizontalBox_12.add(BancTextField);
		BancTextField.setColumns(10);

		CompteTextField = new JTextField();
		CompteTextField.setText("");
		horizontalBox_12.add(CompteTextField);
		CompteTextField.setColumns(10);

		Component verticalStrut_2 = Box.createVerticalStrut(30);
		verticalBox_1.add(verticalStrut_2);

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

				comprarEntradaController.PrOkPagament("", 1, "");

			}
		});

		CancelaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				comprarEntradaController.PrCancellarAvis();
			}
		});
	}

	public void setDadesEntrada(DadesEntrada dadesEntrada) {
		// TODO
		Vector<String> monedas = new Vector<String>();
		monedas.add("�");
		monedas.add("pts");
		monedas.add("libras");
		
		DefaultComboBoxModel model = new DefaultComboBoxModel(monedas);
		MonedaComboBox.setModel(model);
		MonedaComboBox.setSelectedIndex(-1);
		setMinimumSize(new Dimension(50,20));
		MonedaComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comprarEntradaController.canviPreuMoneda((Moneda) MonedaComboBox.getSelectedItem());
			}
		});


	}

//	private void setEnableContinua() {
//		continuaButton
//				.setEnabled((dateChooser.getDate() != null && espectacleComboBox
//						.getSelectedIndex() > -1));
//	}
}
