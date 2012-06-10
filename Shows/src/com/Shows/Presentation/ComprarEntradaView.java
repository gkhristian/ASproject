package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Shows.Presentation.Controller.ComprarEntradaController;

public class ComprarEntradaView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel centerPanel = new JPanel();
	private EspectacleView espectacle;
	private Prueba prueba = new Prueba();
	private CardLayout card = new CardLayout();
	private static ComprarEntradaController comprarEntradaController;
	private final Box horizontalBox = Box.createHorizontalBox();
	private final JButton ContinuaBtn = new JButton("Comprar Entrada");

	// TODO comprobar creadora, hay que pasarle el controlador??

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comprarEntradaController = new ComprarEntradaController(); 
					ComprarEntradaView frame = new ComprarEntradaView(comprarEntradaController);
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
	public ComprarEntradaView(final ComprarEntradaController comprarEntradaController) {
		espectacle = new EspectacleView(comprarEntradaController);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(centerPanel);

		setContentPane(contentPane);

		contentPane.add(horizontalBox, BorderLayout.SOUTH);

		horizontalBox.add(ContinuaBtn);

		ContinuaBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				centerPanel.setLayout(card);

				centerPanel.add(prueba, "first");

				card.show(centerPanel, "first");
			}
			
		});/*(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				
				centerPanel.setLayout(card);

				centerPanel.add(prueba, "first");

				card.show(centerPanel, "first");

			}
		});*/

	}
}
