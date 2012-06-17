package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;
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

	private static final String[] flowNames = { "Inici",
			"Espectacles", "Representacions", "Seleccionar seients", "Pagament" };

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

	private Box horizontalBox_1;
	private JLabel stateLabel;

	private Box horizontalBox;
	private ArrayList<JLabel> navigationLabels;
	private ArrayList<Box> navigationHorizontalBox;

	private int width = 600;
	private int heigth = 400;

	private String espectacle = new String();
	private String data = new String();
	private String local = new String();
	private String sessio = new String();
	private String nombEspectadors = new String();
	private String estrena = new String();
	private String preuSeient = new String();
	private String seients = new String();
	private JButton ConsultaRepresentacionsBtn;
	private JButton ConsultaDisponibilitatBtn;

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
				mostraAvis("Està segur que desitja tancar l'aplicació? Es perdràn els canvis.");
			}
		});

		Color backgroundColor = comprarEntradaController.getBackgroundColor();

		setBackground(backgroundColor);

		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBackground(backgroundColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new EmptyBorder(10, 0, 10, 0));
		contentPane.add(horizontalBox, BorderLayout.NORTH);

		horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		contentPane.add(horizontalBox_1, BorderLayout.CENTER);

		stateLabel = new JLabel();
		stateLabel.setVerticalTextPosition(SwingConstants.TOP);
		stateLabel.setVerticalAlignment(SwingConstants.TOP);
		stateLabel.setBorder(new EmptyBorder(10, 10, 0, 0));
		stateLabel.setMaximumSize(new Dimension(160, 600));
		stateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_1.add(stateLabel);

		espectaclePanel = new EspectaclePanel(comprarEntradaController, this);
		representacioPanel = new RepresentacioPanel(comprarEntradaController,
				this);
		seientsPanel = new SeientsPanel(comprarEntradaController, this);
		pagamentPanel = new PagamentPanel(comprarEntradaController, this);
		comprarEntradaPanel = new ComprarEntradaPanel();
		comprarEntradaPanel.getComparEntradaButton().addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
		comprarEntradaPanel.setPreferredSize(new Dimension(0, 0));
		comprarEntradaPanel.setMinimumSize(new Dimension(0, 0));
		comprarEntradaPanel.setMaximumSize(new Dimension(0, 0));

		espectaclePanel.setBackground(backgroundColor);
		representacioPanel.setBackground(backgroundColor);
		seientsPanel.setBackground(backgroundColor);
		pagamentPanel.setBackground(backgroundColor);
		comprarEntradaPanel.setBackground(backgroundColor);
		centerPanel.setPreferredSize(new Dimension(0, 0));
		centerPanel.setMinimumSize(new Dimension(0, 0));
		centerPanel.setMaximumSize(new Dimension(600, 600));
		horizontalBox_1.add(centerPanel);

		centerPanel.setBackground(backgroundColor);
		centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		centerPanel.setLayout(card);
		centerPanel.add(comprarEntradaPanel, flowNames[0]);
		centerPanel.add(espectaclePanel, flowNames[1]);
		centerPanel.add(representacioPanel, flowNames[2]);
		centerPanel.add(seientsPanel, flowNames[3]);
		centerPanel.add(pagamentPanel, flowNames[4]);

		JButton comparEntradaButton = comprarEntradaPanel
				.getComparEntradaButton();

		ConsultaRepresentacionsBtn = new JButton("Consulta Representacions");
		ConsultaRepresentacionsBtn.setEnabled(false);
		comprarEntradaPanel.add(ConsultaRepresentacionsBtn);

		ConsultaDisponibilitatBtn = new JButton("Consulta Disponibilitat");
		ConsultaDisponibilitatBtn.setEnabled(false);
		comprarEntradaPanel.add(ConsultaDisponibilitatBtn);

		comparEntradaButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				comprarEntradaController.PrComprarEntrada();
			}
		});

		setContentPane(contentPane);

		/**
		 * Añadir los paneles para luego poder mostrarlos
		 */

		navigationLabels = new ArrayList<JLabel>(5);
		navigationHorizontalBox = new ArrayList<Box>(5);

		for (int i = 0; i < 5; i++) {
			JLabel jLabel = new JLabel(flowNames[i]);

			jLabel.setFont(new Font("Arial", Font.BOLD, 14));

			Box hBox = Box.createHorizontalBox();

			if (i != 0) {
				JLabel indicatorLabel = new JLabel(">");
				indicatorLabel.setFont(new Font("Arial", Font.BOLD, 14));
				indicatorLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
				hBox.add(indicatorLabel);
			}
			hBox.add(jLabel);
			navigationLabels.add(jLabel);

			navigationHorizontalBox.add(hBox);
			jLabel.setEnabled(false);
			jLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
			hBox.setVisible(false);

			jLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent mouseEvent) {

					JLabel jLabel = (JLabel) mouseEvent.getComponent();
					setFlowState(navigationLabels.indexOf(jLabel));
				}

				@Override
				public void mouseEntered(MouseEvent mouseEvent) {

					JLabel jLabel = (JLabel) mouseEvent.getComponent();
					jLabel.setForeground(new Color(163, 184, 204));
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

			horizontalBox.add(hBox);
		}
		setFlowState(COMPRAR_ENTRADA);
	}

	private void setFlowState(int flowState) {

		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		for (int i = 0; i < 5; i++) {
			navigationLabels.get(i).setEnabled((i < flowState));
			navigationHorizontalBox.get(i).setVisible((i <= flowState));
		}

		switch (flowState) {
		case COMPRAR_ENTRADA:
			stateLabel.setText("");
			stateLabel.setVisible(false);
			break;

		case ESPECTACLES:
			stateLabel.setText("");
			stateLabel.setVisible(false);
			break;

		case REPRESENTACIONS:
			stateLabel.setVisible(true);
			stateLabel.setText("<html><b>Espectacle: </b>" + espectacle
					+ "<br><b>Data: </b>" + data + "</html>");
			break;

		case SEIENTS:
			stateLabel.setVisible(true);
			stateLabel.setText("<html><b>Espectacle: </b>" + espectacle
					+ "<br><b>Data: </b>" + data + "<br><b>Local: </b>" + local
					+ "<br><b>Sessió: </b>" + sessio
					+ "<br><b>Espectadors: </b>" + nombEspectadors
					+ "<br><b>Estrena: </b>" + estrena
					+ "<br><b>Preu per seient: </b>" + preuSeient + "</html>");
			break;

		case PAGAMENT:
			stateLabel.setVisible(true);
			stateLabel.setText("<html><b>Espectacle: </b>" + espectacle
					+ "<br><b>Data: </b>" + data + "<br><b>Local: </b>" + local
					+ "<br><b>Sessió: </b>" + sessio
					+ "<br><b>Espectadors: </b>" + nombEspectadors
					+ "<br><b>Estrena: </b>" + estrena
					+ "<br><b>Preu per seient: </b>" + preuSeient
					+ "<br><b>Seients: </b>" + seients + "</html>");
			break;

		default:
			break;
		}

		card.show(centerPanel, flowNames[flowState]);
	}

	public void setRepresentacionsString(final String espectacle,
			final String data) {
		this.espectacle = espectacle;
		this.data = data;
	}

	public void setSeientsString(final String local, final String sessio,
			final String nombEspectadors, final String estrena,
			final String preuSeient) {
		this.local = local;
		this.sessio = sessio;
		this.nombEspectadors = nombEspectadors;
		this.estrena = estrena;
		this.preuSeient = preuSeient;
	}

	public void setPagamentString(String seients) {
		this.seients = seients;
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
