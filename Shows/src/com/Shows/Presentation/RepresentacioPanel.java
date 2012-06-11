package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.TupleTypes.DadesRepresentacio;

public class RepresentacioPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3674558461643546039L;
	private JPanel contentPane;
	private JTable representacionsTable;
	private ComprarEntradaController comprarEntradaController;
	private JLabel nomEspectacleLabel;

	private JLabel dataEspectacleLabel;

	/**
	 * Create the frame.
	 */
	public RepresentacioPanel(
			final ComprarEntradaController comprarEntradaController) {

		this.comprarEntradaController = comprarEntradaController;
		setLayout(new BorderLayout(0, 0));
		Box horizontalBox_1 = Box.createHorizontalBox();
		add(horizontalBox_1);

		Box verticalBox = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox);

		representacionsTable = new JTable();
		verticalBox.add(representacionsTable);

		horizontalBox_1.add(verticalBox);

		JLabel EspectacleLbl = new JLabel("Espectacle:");
		verticalBox.add(EspectacleLbl);

		nomEspectacleLabel = new JLabel("New Label");
		verticalBox.add(nomEspectacleLabel);

		JLabel DataLbl = new JLabel("Data:");
		verticalBox.add(DataLbl);

		dataEspectacleLabel = new JLabel("New Label");
		verticalBox.add(dataEspectacleLabel);

		Component verticalStrut = Box.createVerticalStrut(80);
		verticalBox.add(verticalStrut);

		JLabel NombreEspectadorsLbl = new JLabel("Nombre d'espectadors:");
		verticalBox.add(NombreEspectadorsLbl);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);

		JSpinner NumeroEspectadorsSpinner = new JSpinner();
		verticalBox.add(NumeroEspectadorsSpinner);

		representacionsTable = new JTable();
		verticalBox.add(representacionsTable);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(RIGHT_ALIGNMENT);
		add(horizontalBox, BorderLayout.SOUTH);
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

		ContinuaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO mirar el flujo de datos y modificar datos
				comprarEntradaController.PrOkObteOcupacio("", "", 2);

			}
		});

		CancelaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				comprarEntradaController.PrCancellar();
			}
		});
	}

	public void setInfo(Set<DadesRepresentacio> representacions) {
		/*String[] columnNames = { "Local", "Sessi�", "Seients Disponibles",
				"�s estrena?", "Preu" };*/
		
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

		//JScrollPane scpEjemplo = new JScrollPane();
		DefaultTableModel dtmEjemplo = new DefaultTableModel(null, columnNames);

		/*
		 * int i = 0; for (DadesRepresentacio dades : representacions) { Object
		 * datos[] = new Object[3];
		 * 
		 * datos[i] = dades.getNombreSeientsLliures(); datos[i] =
		 * dades.getNomLocal(); datos[i] = dades.getPreu(); datos[i] =
		 * dades.getSessio(); ++i; dtmEjemplo.addRow(datos); }
		 */
		Object datos[] = new Object[3];
		datos[0] = "hola";
		datos[1] = "hola";
		datos[2] = "hola";
		
		Object[][] rowData = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};

		representacionsTable = new JTable(rowData, columnNames);
		//scpEjemplo.add(representacionsTable);
		representacionsTable.setVisible(true);
	}

	public void setnomEspectacleLabel(JLabel nomEspectacleLabel) {
		this.nomEspectacleLabel = nomEspectacleLabel;
	}

	public void setdataEspectacleLabel(JLabel dataEspectacleLabel) {
		this.dataEspectacleLabel = dataEspectacleLabel;
	}
}
