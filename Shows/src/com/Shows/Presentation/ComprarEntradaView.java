package com.Shows.Presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.TupleTypes.DadesEntrada;
import com.Shows.TupleTypes.DadesRepresentacio;
import com.Shows.TupleTypes.PosicioSeient;

public class ComprarEntradaView extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Instancia de los Panels
	 */
	private EspectaclePanel espectaclePanel;
	private RepresentacioPanel representacioPanel;
	private SeientsPanel seientsPanel;
	private PagamentPanel pagamentPanel;
	private ComprarEntradaPanel comprarEntradaPanel;

	private JPanel contentPane;
	private JPanel centerPanel = new JPanel();
	private CardLayout card = new CardLayout();
	private ComprarEntradaController comprarEntradaController;
	private final Box horizontalBox = Box.createHorizontalBox();
	private final JButton ContinuaBtn = new JButton("Comprar Entrada");

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { comprarEntradaController = new
	 * ComprarEntradaController(); //ComprarEntradaView frame = new
	 * ComprarEntradaView(comprarEntradaController); //frame.setVisible(true); }
	 * catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ComprarEntradaView(
			final ComprarEntradaController comprarEntradaController) {
		espectaclePanel = new EspectaclePanel(comprarEntradaController);
		representacioPanel = new RepresentacioPanel(comprarEntradaController);
		seientsPanel = new SeientsPanel(comprarEntradaController);
		pagamentPanel = new PagamentPanel(comprarEntradaController);
		comprarEntradaPanel = new ComprarEntradaPanel();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(centerPanel);

		setContentPane(contentPane);

		contentPane.add(horizontalBox, BorderLayout.SOUTH);

		// horizontalBox.add(ContinuaBtn);

		centerPanel.setLayout(card);

		/**
		 * Añadir los paneles para luego poder mostrarlos
		 */
		centerPanel.add(comprarEntradaPanel, "comprarEntrada");
		centerPanel.add(espectaclePanel, "espectacle");
		centerPanel.add(representacioPanel, "representacio");
		centerPanel.add(seientsPanel, "seients");
		centerPanel.add(pagamentPanel, "pagament");

		JButton nuevo = comprarEntradaPanel.getComparEntradabtn();

		/*
		 * ContinuaBtn.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent arg0) {
		 * 
		 * card.show(centerPanel, "espectacle"); }
		 * 
		 * });
		 */

		nuevo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				comprarEntradaController.PrOkObteRepresentacions("",
						new Date(1));
			}

		});

	}

	public void mostraEspectacles(Set<String> espectacles) {
		espectaclePanel.setEspectacleComboBox(espectacles);
		card.show(centerPanel, "espectacle");
	}

	public void mostraRepresentacions(Set<DadesRepresentacio> representacions) {
		representacioPanel.setInfo(representacions);
		card.show(centerPanel, "representacio");
	}

	public void mostraOcupacio(Set<PosicioSeient> seients) {

	}

	public void mostraPreu(DadesEntrada dadesEntrada) {

	}

	public void mostraPreuMoneda(Float preu) {

	}

	public void mostraMissatge(String missatge) {

	}

	public void mostraAvisFi(String missatge) {

	}

	public void mostraAvis(String missatge) {

	}

	public void tancarAvis() {

	}

	public void tancar() {

	}

}
