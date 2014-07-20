/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gilberto
 */
public class ItemsTableModel extends AbstractTableModel {

    private ArrayList<Item> list;
    private String[] columnNames = {"Cantidad", "Unidad de Medida",
                                     "Descripción", "Precio Unitario", "Importe" };

    public ItemsTableModel() {
        this.list = new ArrayList<Item>();
    }

    public ItemsTableModel( ArrayList<Item> items) {
        this.list = items;
    }

    @Override
    public String getColumnName( int column ) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = this.list.get(rowIndex);
        Object value = null;

        switch (columnIndex) {
            case 0:
                value = item.getQuantity();
                break;
            case 1:
                value = item.getMeasureUnit();
                break;
            case 2:
                value = item.getDescription();
                break;
            case 3:
                value = String.valueOf(item.getUnitPrice());
                break;
            case 4:
                value = String.valueOf(item.getSubtotal());
        }

        return value;
    }

}
