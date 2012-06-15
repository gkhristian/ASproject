package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.TupleTypes.DadesEntrada;
import com.Shows.TupleTypes.DadesRepresentacio;
import com.Shows.TupleTypes.PosicioSeient;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class ComprarEntradaView extends JFrame {

	private static final long serialVersionUID = 1L;

	private ComprarEntradaController comprarEntradaController;
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
	private final Box horizontalBox = Box.createHorizontalBox();

	private int width = 600;
	private int heigth = 400;
	private JLabel missatgeLabel;

	/**
	 * Create the frame.
	 */
	public ComprarEntradaView(
			final ComprarEntradaController comprarEntradaController) {
		this.comprarEntradaController = comprarEntradaController;

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds(dimension.width / 2 - width / 2, dimension.height / 2
				- heigth / 2, width, heigth);

		// TODO Resizable?
		setResizable(false);

		espectaclePanel = new EspectaclePanel(comprarEntradaController, this);
		representacioPanel = new RepresentacioPanel(comprarEntradaController,
				this);
		seientsPanel = new SeientsPanel(comprarEntradaController, this);
		pagamentPanel = new PagamentPanel(comprarEntradaController, this);
		comprarEntradaPanel = new ComprarEntradaPanel();

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(centerPanel);

		setContentPane(contentPane);
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));

		contentPane.add(horizontalBox, BorderLayout.SOUTH);

		missatgeLabel = new JLabel(" ");
		missatgeLabel.setForeground(SystemColor.textHighlight);
		horizontalBox.add(missatgeLabel);

		centerPanel.setLayout(card);

		/**
		 * A�adir los paneles para luego poder mostrarlos
		 */
		centerPanel.add(comprarEntradaPanel, "comprarEntrada");
		centerPanel.add(espectaclePanel, "espectacle");
		centerPanel.add(representacioPanel, "representacio");
		centerPanel.add(seientsPanel, "seients");
		centerPanel.add(pagamentPanel, "pagament");

		JButton nuevo = comprarEntradaPanel.getComparEntradabtn();

		nuevo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				comprarEntradaController.PrComprarEntrada();
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
		seientsPanel.setSeients(seients);
		card.show(centerPanel, "seients");
	}

	public void mostraPreu(DadesEntrada dadesEntrada) {
		pagamentPanel.setDadesEntrada(dadesEntrada);
		card.show(centerPanel, "pagament");
	}

	public void mostraPreuMoneda(Float preu) {
		pagamentPanel.setPreu(preu);
	}

	public void mostraMissatge(String missatge) {
		missatgeLabel.setText(missatge);
	}

	public void mostraAvisFi(String missatge) {
		// TODO delete missatge???
		AvisAcabaDialog avisAcabaDialog = new AvisAcabaDialog(
				comprarEntradaController);
		avisAcabaDialog.setVisible(true);
	}

	public void mostraAvis(String missatge) {
		// TODO delete missatge???
		AvisSortirDialog avisSortirDialog = new AvisSortirDialog(
				comprarEntradaController);
		avisSortirDialog.setVisible(true);
	}

	public void tancarAvis() {
		// TODO necesario tancarAvis??? que es???
	}

	public void tancar() {
		try {
			finalize();
			System.exit(0);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
