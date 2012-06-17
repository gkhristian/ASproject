package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;

import com.Shows.Domain.Exceptions.SeientsNoDisp;
import com.Shows.Domain.Model.TipusSessio;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.Presentation.View.Renderer.CheckBoxRenderer;
import com.Shows.TupleTypes.DadesRepresentacio;

public class RepresentacioPanel extends JPanel {

	private static final long serialVersionUID = -3674558461643546039L;

	private JTable representacionsTable;
	private JLabel nomEspectacleLabel;
	private JLabel dataEspectacleLabel;
	private JButton continuaButton;
	private JSpinner nombreEspectadorsSpinner;

	/**
	 * Create the frame.
	 * 
	 * @param comprarEntradaView
	 */
	public RepresentacioPanel(
			final ComprarEntradaController comprarEntradaController,
			ComprarEntradaView comprarEntradaView) {

		setLayout(new BorderLayout(0, 0));
		Box horizontalBox_1 = Box.createHorizontalBox();
		add(horizontalBox_1);

		Box verticalBox = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox);

		horizontalBox_1.add(verticalBox);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new EmptyBorder(0, 0, 0, 10));
		horizontalBox_2.add(verticalBox_1);

		JLabel EspectacleLbl = new JLabel("Espectacle:");
		EspectacleLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(EspectacleLbl);

		nomEspectacleLabel = new JLabel("New Label");
		nomEspectacleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(nomEspectacleLabel);

		JLabel DataLbl = new JLabel("Data:");
		DataLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(DataLbl);

		dataEspectacleLabel = new JLabel("New Label");
		dataEspectacleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(dataEspectacleLabel);

		Box verticalBox_2 = Box.createVerticalBox();
		horizontalBox_2.add(verticalBox_2);

		/**** JTable *****/
		representacionsTable = new JTable();
		representacionsTable
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneRepresentacioTable = new JScrollPane(
				representacionsTable);
		verticalBox_2.add(scrollPaneRepresentacioTable);

		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBorder(new EmptyBorder(10, 0, 0, 0));
		verticalBox_2.add(horizontalBox_3);

		JLabel NombreEspectadorsLbl = new JLabel("Nombre d'espectadors:");
		horizontalBox_3.add(NombreEspectadorsLbl);
		NombreEspectadorsLbl.setBorder(new EmptyBorder(0, 0, 0, 10));
		NombreEspectadorsLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

		nombreEspectadorsSpinner = new JSpinner();
		horizontalBox_3.add(nombreEspectadorsSpinner);

		((DefaultFormatter) ((JSpinner.DefaultEditor) nombreEspectadorsSpinner
				.getEditor()).getTextField().getFormatter())
				.setAllowsInvalid(false);

		nombreEspectadorsSpinner.setMinimumSize(new Dimension(100, 30));
		nombreEspectadorsSpinner.setPreferredSize(new Dimension(50, 30));
		nombreEspectadorsSpinner.setMaximumSize(new Dimension(100, 30));
		nombreEspectadorsSpinner.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_1);

		nombreEspectadorsSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent changeEvent) {
				setEnableContinua();
			}
		});

		/***** No parece funcionar *****/
		nombreEspectadorsSpinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				setEnableContinua();
			}
		});

		nombreEspectadorsSpinner
				.addInputMethodListener(new InputMethodListener() {

					@Override
					public void inputMethodTextChanged(InputMethodEvent event) {
						setEnableContinua();
					}

					@Override
					public void caretPositionChanged(InputMethodEvent event) {
						setEnableContinua();
					}
				});
		/***/

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new EmptyBorder(10, 0, 0, 0));
		horizontalBox.setAlignmentX(RIGHT_ALIGNMENT);
		add(horizontalBox, BorderLayout.SOUTH);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		continuaButton = new JButton("Continua");
		continuaButton.setAlignmentX(RIGHT_ALIGNMENT);
		continuaButton.setEnabled(false);
		horizontalBox.add(continuaButton);

		JButton cancelaButton = new JButton("Cancel\u00B7la");
		cancelaButton.setAlignmentX(RIGHT_ALIGNMENT);
		horizontalBox.add(cancelaButton);

		continuaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
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
				} catch (SeientsNoDisp seientsNoDisp) {
					seientsNoDisp.printStackTrace();
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

	public void setInfo(Set<DadesRepresentacio> representacions) {

		String[] columnNames = { "Local", "Sessió", "Seients Disponibles",
				"És estrena?", "Preu" };

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
		continuaButton.setEnabled((representacionsTable.getSelectedRow() > -1)
				&& ((Integer) nombreEspectadorsSpinner.getValue() > 0));
	}
}
