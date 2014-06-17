/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ripflame
 */
public class ClientsTableModel extends AbstractTableModel {

  private ArrayList<Client> list;
  private String[] columnNames = {"Nombre", "Calle", "Num. Ext.", "Num. Int.", "Colonia", "Referencia", "Codigo Postal", "Municipio", "Ciudad", "Estado", "Pais", "RFC", "Email", "Tel", "Comentarios"};

  public ClientsTableModel() {
    this.list = new ArrayList<Client>();
  }

  public ClientsTableModel(ArrayList<Client> clients) {
    this.list = clients;
  }

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  @Override
  public int getRowCount() {
    return list.size();
  }

  @Override
  public int getColumnCount() {
    return 15;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Client client = list.get(rowIndex);
    Object value = null;
    switch (columnIndex) {
      case 0:
        value = client.getName();
        break;
      case 1:
        value = client.getStreet();
        break;
      case 2:
        value = client.getExtNum();
        break;
      case 3:
        value = client.getIntNum();
        break;
      case 4:
        value = client.getColony();
        break;
      case 5:
        value = client.getReference();
        break;
      case 6:
        value = client.getPostalCode();
        break;
      case 7:
        value = client.getMunicipality();
        break;
      case 8:
        value = client.getCity();
        break;
      case 9:
        value = client.getState();
        break;
      case 10:
        value = client.getCountry();
        break;
      case 11:
        value = client.getRFC();
        break;
      case 12:
        value = client.getEmail();
        break;
      case 13:
        value = client.getPhone();
        break;
      case 14:
        value = client.getComments();
        break;
    }

    return value;
  }

}
