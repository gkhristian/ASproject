package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Shows.HibernateUtil;
import com.Shows.Presentation.Controller.ComprarEntradaController;
import com.Shows.TupleTypes.DadesEntrada;
import com.Shows.TupleTypes.DadesRepresentacio;
import com.Shows.TupleTypes.PosicioSeient;

public class ComprarEntradaView extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int COMPRAR_ENTRADA = 0;
	private static final int ESPECTACLES = COMPRAR_ENTRADA + 1;
	private static final int REPRESENTACIONS = ESPECTACLES + 1;
	private static final int SEIENTS = REPRESENTACIONS + 1;
	private static final int PAGAMENT = SEIENTS + 1;

	private static final String[] flowNames = { "Comprar Entrada",
			"Espectacles", "Representacions", "Seients", "Pagament" };

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

	private Box horizontalBox;
	private ArrayList<JLabel> navigationLabels;

	private int width = 600;
	private int heigth = 400;

	/**
	 * Create the frame.
	 */
	public ComprarEntradaView(
			final ComprarEntradaController comprarEntradaController) {
		this.comprarEntradaController = comprarEntradaController;

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds(dimension.width / 2 - width / 2, dimension.height / 2
				- heigth / 2, width, heigth);

		setResizable(false);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				// TODO mensaje de confirmación, cerrar
				mostraAvis("Tancar? <-- TODO");
			}
		});

		espectaclePanel = new EspectaclePanel(comprarEntradaController, this);
		representacioPanel = new RepresentacioPanel(comprarEntradaController,
				this);
		seientsPanel = new SeientsPanel(comprarEntradaController, this);
		pagamentPanel = new PagamentPanel(comprarEntradaController, this);
		comprarEntradaPanel = new ComprarEntradaPanel();

		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		horizontalBox = Box.createHorizontalBox();
		contentPane.add(horizontalBox, BorderLayout.NORTH);

		contentPane.add(centerPanel);

		setContentPane(contentPane);

		centerPanel.setLayout(card);

		/**
		 * Añadir los paneles para luego poder mostrarlos
		 */
		centerPanel.add(comprarEntradaPanel, flowNames[0]);
		centerPanel.add(espectaclePanel, flowNames[1]);
		centerPanel.add(representacioPanel, flowNames[2]);
		centerPanel.add(seientsPanel, flowNames[3]);
		centerPanel.add(pagamentPanel, flowNames[4]);

		JButton nuevo = comprarEntradaPanel.getComparEntradabtn();

		nuevo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				comprarEntradaController.PrComprarEntrada();
			}
		});

		navigationLabels = new ArrayList<JLabel>(5);

		for (int i = 0; i < 5; i++) {
			JLabel jLabel = new JLabel(flowNames[i]);
			navigationLabels.add(jLabel);
			jLabel.setEnabled(false);
			jLabel.setVisible(false);
			jLabel.setBorder(new EmptyBorder(0, 10, 0, 0));

			jLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent mouseEvent) {
					JLabel jLabel = (JLabel) mouseEvent.getComponent();
					setFlowState(navigationLabels.indexOf(jLabel));
				}

				@Override
				public void mouseEntered(MouseEvent mouseEvent) {
					JLabel jLabel = (JLabel) mouseEvent.getComponent();
					jLabel.setForeground(new Color(0.2f, 0.3f, 0.7f));
					if (jLabel.isEnabled())
						ComprarEntradaView.this.setCursor(new Cursor(
								Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent mouseEvent) {
					JLabel jLabel = (JLabel) mouseEvent.getComponent();
					jLabel.setForeground(Color.BLACK);
					if (jLabel.isEnabled())
						ComprarEntradaView.this.setCursor(new Cursor(
								Cursor.DEFAULT_CURSOR));
				}
			});

			horizontalBox.add(jLabel);
		}
		setFlowState(COMPRAR_ENTRADA);
	}

	private void setFlowState(int flowState) {

		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		for (int i = 0; i < 5; i++) {
			navigationLabels.get(i).setEnabled((i < flowState));
			navigationLabels.get(i).setVisible((i <= flowState));
		}

		card.show(centerPanel, flowNames[flowState]);
	}

	public void mostraEspectacles(Set<String> espectacles) {

		espectaclePanel.setEspectacleComboBox(espectacles);
		setFlowState(ESPECTACLES);
	}

	public void mostraRepresentacions(Set<DadesRepresentacio> representacions) {

		representacioPanel.setInfo(representacions);
		setFlowState(REPRESENTACIONS);
	}

	public void mostraOcupacio(Set<PosicioSeient> seients) {

		seientsPanel.setSeients(seients);
		setFlowState(SEIENTS);
	}

	public void mostraPreu(DadesEntrada dadesEntrada) {

		pagamentPanel.setDadesEntrada(dadesEntrada);
		setFlowState(PAGAMENT);
	}

	public void mostraPreuMoneda(Float preu) {

		pagamentPanel.setPreu(preu);
	}

	public void mostraMissatge(String missatge) {

		JOptionPane.showMessageDialog(this, missatge, "Informació",
				JOptionPane.WARNING_MESSAGE);
	}

	public void mostraAvisFi(String missatge) {

		int confirmation = JOptionPane.showConfirmDialog(this, missatge,
				"Informació", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);

		if (confirmation == JOptionPane.OK_OPTION) {
			comprarEntradaController.PrFi();
		}
	}

	public void mostraAvis(String missatge) {

		int confirmation = JOptionPane.showConfirmDialog(this, missatge,
				"Confirmació", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (confirmation == JOptionPane.OK_OPTION) {
			comprarEntradaController.PrFi();
		}
	}

	public void tancar() {

		try {
			HibernateUtil.getSession().close();
			finalize();
			System.exit(0);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
}
