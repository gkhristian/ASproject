package com.Shows.Presentation.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AvisSortirDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AvisSortirDialog() {
		// TODO message???
		setAlwaysOnTop(true);
		setModal(true);
		setResizable(false);

		setBounds(100, 100, 308, 106);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblSiCancelaLoperaci = new JLabel(
					"Si cancel\u00B7a l'operaci\u00F3 es perdr\u00E0 tot el proc\u00E8s");
			contentPanel.add(lblSiCancelaLoperaci);
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
			{
				JButton cancelButton = new JButton("Cancel·la");
				cancelButton.setActionCommand("Cancel·la");
				buttonPane.add(cancelButton);
			}
		}
	}

}
