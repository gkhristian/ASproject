package com.Shows.Presentation.View;

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
import com.Shows.Presentation.View.CellRenderer.CheckBoxRenderer;
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

		horizontalBox_1.add(verticalBox);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox_2.add(verticalBox_1);

		JLabel EspectacleLbl = new JLabel("Espectacle:");
		verticalBox_1.add(EspectacleLbl);

		nomEspectacleLabel = new JLabel("New Label");
		verticalBox_1.add(nomEspectacleLabel);

		JLabel DataLbl = new JLabel("Data:");
		verticalBox_1.add(DataLbl);

		dataEspectacleLabel = new JLabel("New Label");
		verticalBox_1.add(dataEspectacleLabel);

		Component verticalStrut = Box.createVerticalStrut(80);
		verticalBox_1.add(verticalStrut);

		JLabel NombreEspectadorsLbl = new JLabel("Nombre d'espectadors:");
		verticalBox_1.add(NombreEspectadorsLbl);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);

		JSpinner NumeroEspectadorsSpinner = new JSpinner();
		verticalBox_1.add(NumeroEspectadorsSpinner);

		/**** JTable *****/
		representacionsTable = new JTable();
		representacionsTable.setVisible(true);
		// representacionsTable.setEnabled(false);

		JScrollPane scrollPaneRepresentacioTable = new JScrollPane(
				representacionsTable);
		horizontalBox_2.add(scrollPaneRepresentacioTable);

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

		String[] columnNames = { "Local", "Sessió", "Seients Disponibles",
				"És estrena?", "Preu" };

		DadesRepresentacio[] dades = representacions
				.toArray(new DadesRepresentacio[0]);

		DefaultTableModel dataModel = new DefaultTableModel();

		for (int i = 0; i < columnNames.length; i++) {
			dataModel.addColumn(columnNames[i]);
		}

		for (int j = 0; j < representacions.size(); j++) {
			Object datos[] = new Object[5];

			datos[0] = dades[j].getNomLocal();
			datos[1] = dades[j].getSessio();
			datos[2] = dades[j].getNombreSeientsLliures();
			datos[3] = dades[j].isEstrena();
			datos[4] = dades[j].getPreu();

			dataModel.addRow(datos);
		}

		representacionsTable.setModel(dataModel);

		representacionsTable.getColumnModel().getColumn(3)
				.setCellRenderer(new CheckBoxRenderer());

	}

	public void setnomEspectacleLabel(JLabel nomEspectacleLabel) {
		this.nomEspectacleLabel = nomEspectacleLabel;
	}

	public void setdataEspectacleLabel(JLabel dataEspectacleLabel) {
		this.dataEspectacleLabel = dataEspectacleLabel;
	}
}
