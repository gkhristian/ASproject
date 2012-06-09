package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Choice;

public class ComprarEntradaView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprarEntradaView frame = new ComprarEntradaView();
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
	public ComprarEntradaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioniEspectacleI = new JLabel("Seleccioni espectacle i data");
		lblSeleccioniEspectacleI.setBounds(10, 28, 149, 14);
		contentPane.add(lblSeleccioniEspectacleI);
		
		Choice choice = new Choice();
		choice.setBounds(155, 22, 127, 20);
		contentPane.add(choice);
	}
}
