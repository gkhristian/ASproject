package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Component;

public class ComprarEntradaView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel centerPanel = new JPanel();
	private EspectacleView espectacle = new EspectacleView();
	private CardLayout card = new CardLayout();
	private final Box horizontalBox = Box.createHorizontalBox();
	private final JButton ContinuaBtn = new JButton("Comprar Entrada");
	
	//TODO comprobar creadora, hay que pasarle el controlador??
	
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(centerPanel);

		setContentPane(contentPane);
		
		contentPane.add(horizontalBox, BorderLayout.SOUTH);
		
		horizontalBox.add(ContinuaBtn);
		
		ContinuaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				centerPanel.setLayout(card);

				centerPanel.add(espectacle, "first");

				card.show(centerPanel, "first");				
				
			}
		});
		
	}
}
