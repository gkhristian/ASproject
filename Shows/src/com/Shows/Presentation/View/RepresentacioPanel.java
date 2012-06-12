package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import com.Shows.Domain.Exception.seientsNoDisp;
import com.Shows.Domain.Model.TipusSessio;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.Presentation.View.CellRenderer.CheckBoxRenderer;
import com.Shows.TupleTypes.DadesRepresentacio;

public class RepresentacioPanel extends JPanel {

	private static final long serialVersionUID = -3674558461643546039L;

	private ComprarEntradaController comprarEntradaController;
	private JPanel contentPane;
	private JTable representacionsTable;
	private JLabel nomEspectacleLabel;
	private JLabel dataEspectacleLabel;
	private JButton continuaButton;
	private JSpinner nombreEspectadorsSpinner;

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

		nombreEspectadorsSpinner = new JSpinner();
		nombreEspectadorsSpinner.setModel(new SpinnerNumberModel(0, 0, 25, 1));
		verticalBox_1.add(nombreEspectadorsSpinner);

		/**** JTable *****/
		representacionsTable = new JTable();
		// representacionsTable.setVisible(true);
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

		continuaButton = new JButton("Continua");
		continuaButton.setAlignmentX(RIGHT_ALIGNMENT);
		continuaButton.setEnabled(false);
		horizontalBox.add(continuaButton);

		JButton CancelaBtn = new JButton("Cancel\u00B7la");
		CancelaBtn.setAlignmentX(RIGHT_ALIGNMENT);
		horizontalBox.add(CancelaBtn);

		continuaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO mirar el flujo de datos y modificar datos
				try {
					comprarEntradaController.PrOkObteOcupacio(
							representacionsTable
									.getModel()
									.getValueAt(
											representacionsTable
													.getSelectedRow(), 0)
									.toString(),
							(TipusSessio) representacionsTable.getModel()
									.getValueAt(
											representacionsTable
													.getSelectedRow(), 1),
							(Integer) nombreEspectadorsSpinner.getValue());
				} catch (seientsNoDisp e) {
					// TODO mostrar excepci�n!
					e.printStackTrace();
				}

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

		String[] columnNames = { "Local", "Sessi�", "Seients Disponibles",
				"�s estrena?", "Preu" };

		DadesRepresentacio[] dades = representacions
				.toArray(new DadesRepresentacio[0]);

		DefaultTableModel dataModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

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

		representacionsTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				setEnableContinua();
			}
		});

	}

	public void setnomEspectacleLabel(JLabel nomEspectacleLabel) {
		this.nomEspectacleLabel = nomEspectacleLabel;
	}

	public void setdataEspectacleLabel(JLabel dataEspectacleLabel) {
		this.dataEspectacleLabel = dataEspectacleLabel;
	}

	private void setEnableContinua() {
		continuaButton.setEnabled((representacionsTable.getSelectedRow() > -1));
	}
}
