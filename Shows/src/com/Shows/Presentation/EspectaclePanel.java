package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Set;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListDataListener;

import com.Shows.Domain.Model.Espectacle;
import com.Shows.Presentation.Controller.ComprarEntradaController;

public class EspectaclePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComprarEntradaController comprarEntradaController;
	private Date data = new Date(1);
	JComboBox EspectacleComboBox;
	/**
	 * Create the frame.
	 */
	public EspectaclePanel(final ComprarEntradaController comprarEntradaController) {
		this.comprarEntradaController = comprarEntradaController;

		setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		Component verticalStrut = Box.createVerticalStrut(120);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		JLabel lblSeleccioniEspectacleI = new JLabel("Seleccioni espectacle i data");
		horizontalBox_1.add(lblSeleccioniEspectacleI);
		
		EspectacleComboBox = new JComboBox();
		horizontalBox_1.add(EspectacleComboBox);
		
		JButton btnDatapicker = new JButton("DATAPICKER");
		horizontalBox_1.add(btnDatapicker);
		
		Component verticalStrut_1 = Box.createVerticalStrut(120);
		verticalBox.add(verticalStrut_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox, BorderLayout.SOUTH);
		
		JLabel MessageAreaLbl = new JLabel("");
		horizontalBox.add(MessageAreaLbl);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JButton ContinuaBtn = new JButton("Continua");
		ContinuaBtn.setEnabled(false);
		horizontalBox.add(ContinuaBtn);
		
		JButton CancelaBtn = new JButton("Cancel\u00B7la");
		horizontalBox.add(CancelaBtn);
		
		ContinuaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				//TODO mirar el flujo de datos y modificar datos
				comprarEntradaController.PrOkObteRepresentacions("", data);				
				
			}
		});
		
		CancelaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				comprarEntradaController.PrCancellarAvis();
			}
		});
	}
	
	public void setEspectacleComboBox(Set<String> espectacles) {
		
		Vector<String> espectaclesVector= new Vector<String>();
		
		for (String titol : espectacles) {
			espectaclesVector.add(titol);
		}
		
		EspectacleComboBox = new JComboBox(espectaclesVector);
	}

}

