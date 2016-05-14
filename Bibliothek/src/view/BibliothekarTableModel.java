package view;

import javax.swing.table.AbstractTableModel;

import model.BibliothekModel;

public class BibliothekarTableModel extends AbstractTableModel {

	private BibliothekModel model;
	
	private String[] columnNames = { "id", "name" };
	private Object[][] data = {{"",""},{"",""}};

	public BibliothekarTableModel() {
	
	}

	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return data[row][col];
	}

	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return columnNames[col];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		data[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
}
