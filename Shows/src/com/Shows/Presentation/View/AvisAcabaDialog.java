package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AvisAcabaDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AvisAcabaDialog() {
		setAlwaysOnTop(true);
		setModal(true);
		setResizable(false);

		setBounds(100, 100, 279, 122);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblElPagamentSha = new JLabel(
					"El pagament s'ha produ\u00EFt correctament.");
			JLabel lblElPagamentSha2 = new JLabel(
					"Ja ho pot recogir a la seva entitat banc\u00E0ria.");
			contentPanel.add(lblElPagamentSha);
			contentPanel.add(lblElPagamentSha2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Accepta");
				okButton.setActionCommand("Accepta");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
