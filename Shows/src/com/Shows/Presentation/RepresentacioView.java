package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.Shows.Presentation.Controller.ComprarEntradaController;

public class RepresentacioView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3674558461643546039L;
	private JPanel contentPane;
	private JTable RepresentacionsTable;
	private ComprarEntradaController comprarEntradaController;


	/**
	 * Create the frame.
	 */
	public RepresentacioView(final ComprarEntradaController comprarEntradaController) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(RIGHT_ALIGNMENT);
		contentPane.add(horizontalBox, BorderLayout.SOUTH);
		
		JLabel MessageAreaLbl = new JLabel("");
		MessageAreaLbl.setAlignmentX(RIGHT_ALIGNMENT);
		horizontalBox.add(MessageAreaLbl);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JButton ContinuaBtn = new JButton("Continua");
		ContinuaBtn.setAlignmentX(RIGHT_ALIGNMENT);
		ContinuaBtn.setEnabled(false);
		horizontalBox.add(ContinuaBtn);
		
		JButton CancelaBtn = new JButton("Cancel\u00B7la");
		CancelaBtn.setAlignmentX(RIGHT_ALIGNMENT);
		horizontalBox.add(CancelaBtn);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_1, BorderLayout.WEST);
		
		Box verticalBox = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox);
		
		JLabel EspectacleLbl = new JLabel("Espectacle:");
		verticalBox.add(EspectacleLbl);
		
		JLabel NomEspectacleLbl = new JLabel("New Label");
		verticalBox.add(NomEspectacleLbl);
		
		JLabel DataLbl = new JLabel("Data:");
		verticalBox.add(DataLbl);
		
		JLabel DataEspectacleLbl = new JLabel("New Label");
		verticalBox.add(DataEspectacleLbl);
		
		Component verticalStrut = Box.createVerticalStrut(80);
		verticalBox.add(verticalStrut);
		
		JLabel NombreEspectadorsLbl = new JLabel("Nombre d'espectadors:");
		verticalBox.add(NombreEspectadorsLbl);
		
		Component verticalStrut_1 = Box.createVerticalStrut(90);
		verticalBox.add(verticalStrut_1);
		
		JSpinner NumeroEspectadorsSpinner = new JSpinner();
		verticalBox.add(NumeroEspectadorsSpinner);
		
		RepresentacionsTable = new JTable();
		horizontalBox_1.add(RepresentacionsTable);
		
		ContinuaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				//TODO mirar el flujo de datos y modificar datos
				comprarEntradaController.PrOkObteOcupacio("", "", 2);	
				
			}
		});
	}

}
