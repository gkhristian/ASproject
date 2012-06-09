package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class RepresentacioView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3674558461643546039L;
	private JPanel contentPane;
	private JTable RepresentacionsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepresentacioView frame = new RepresentacioView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RepresentacioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		JComboBox comboBox = new JComboBox();
		verticalBox.add(comboBox);
		
		Component verticalStrut_1 = Box.createVerticalStrut(90);
		verticalBox.add(verticalStrut_1);
		
		RepresentacionsTable = new JTable();
		horizontalBox_1.add(RepresentacionsTable);
	}

}
