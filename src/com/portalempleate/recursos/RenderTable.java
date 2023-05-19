package com.portalempleate.recursos;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class RenderTable extends DefaultTableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object objetoRenderizable, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (objetoRenderizable instanceof JButton) {
			return (JButton) objetoRenderizable;
		}
		return super.getTableCellRendererComponent(table, objetoRenderizable, isSelected, hasFocus, row, column);
	}
}
