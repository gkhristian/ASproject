package com.Shows.Presentation.View.Renderer;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class PromptComboBoxRenderer extends BasicComboBoxRenderer {
	private static final long serialVersionUID = 1L;

	private String prompt;

	public PromptComboBoxRenderer(String prompt) {
		this.prompt = prompt;
	}

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);

		if (value == null)
			setText(prompt);

		return this;
	}
}
