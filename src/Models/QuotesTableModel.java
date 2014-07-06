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
public class QuotesTableModel extends AbstractTableModel {

    private ArrayList<Quote> list;
    private String[] columnNames = {"Fecha", "RFC", "Nombre", "Precio Total"};

    public QuotesTableModel() {
        list = new ArrayList<Quote>();
    }

    public QuotesTableModel( ArrayList<Quote> quotes ) {
        this.list = quotes;
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Quote quote = this.list.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = quote.getDate();
                break;
            case 1:
                value = quote.getClient().getRFC();
                break;
            case 2:
                value = quote.getClient().getName();
                break;
            case 3:
                value = quote.getTotal();
                break;
        }

        return value;
    }

}
