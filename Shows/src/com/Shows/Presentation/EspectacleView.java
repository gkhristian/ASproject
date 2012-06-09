package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Shows.Presentation.Controller.ComprarEntradaController;

public class EspectacleView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ComprarEntradaController comprarEntradaController;
	private Date data = new Date(1);

	/**
	 * Create the frame.
	 */
	public EspectacleView(final ComprarEntradaController comprarEntradaController) {
		this.comprarEntradaController = comprarEntradaController;
		setBounds(100, 100, 477, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Box horizontalBox = Box.createHorizontalBox();
		contentPane.add(horizontalBox, BorderLayout.SOUTH);
		
		JLabel MessageAreaLbl = new JLabel("");
		horizontalBox.add(MessageAreaLbl);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JButton ContinuaBtn = new JButton("Continua");
		ContinuaBtn.setEnabled(false);
		horizontalBox.add(ContinuaBtn);
		
		JButton CancelaBtn = new JButton("Cancel\u00B7la");
		horizontalBox.add(CancelaBtn);
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(50);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		JLabel lblSeleccioniEspectacleI = new JLabel("Seleccioni espectacle i data");
		horizontalBox_1.add(lblSeleccioniEspectacleI);
		
		JComboBox EspectacleComboBox = new JComboBox();
		horizontalBox_1.add(EspectacleComboBox);
		
		JButton btnDatapicker = new JButton("DATAPICKER");
		horizontalBox_1.add(btnDatapicker);
		
		ContinuaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				//TODO mirar el flujo de datos y modificar datos
				comprarEntradaController.PrOkObteRepresentacions("", data);				
				
			}
		});
	}
}