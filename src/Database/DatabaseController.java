/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.Client;
import Models.Issuing;
import Tests.JDBCTests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ripflame
 */
public class DatabaseController {

  public void createDatabase() {
    Connection c = null;
    Statement stmt = null;

    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");

      stmt = c.createStatement();

      String sql = "CREATE TABLE CLIENTS "
        + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
        + " NAME           TEXT NOT NULL, "
        + " STREET         TEXT, "
        + " EXT_NUM        TEXT,  "
        + " INT_NUM        TEXT,  "
        + " COLONY         TEXT, "
        + " REFERENCE      TEXT, "
        + " POSTAL_CODE    TEXT,  "
        + " MUNICIPALITY   TEXT, "
        + " CITY           TEXT, "
        + " STATE          TEXT, "
        + " COUNTRY        TEXT, "
        + " RFC            TEXT NOT NULL, "
        + " EMAIL          TEXT, "
        + " PHONE          TEXT, "
        + " COMMENTS       TEXT )";
      stmt.executeUpdate(sql);

      sql = "CREATE TABLE ISSUING "
        + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
        + "NAME TEXT NOT NULL, "
        + "STREET TEXT, "
        + "EXT_NUM TEXT, "
        + "INT_NUM TEXT, "
        + "COLONY TEXT, "
        + "REFERENCE TEXT, "
        + "POSTAL_CODE TEXT, "
        + "MUNICIPALITY TEXT, "
        + "CITY TEXT, "
        + "STATE TEXT, "
        + "COUNTRY TEXT, "
        + "RFC TEXT NOT NULL, "
        + "REGIME TEXT )";
      stmt.executeUpdate(sql);
      
      stmt.close();
      c.close();

    } catch (Exception e) {
      Logger.getLogger(JDBCTests.class.getName()).log(Level.INFO, "Error creating db", e);
      System.exit(0);
    }
  }

  public void createIssuing(Issuing issuing) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "INSERT INTO ISSUING"
        + "(NAME, STREET, EXT_NUM, INT_NUM, COLONY, REFERENCE, POSTAL_CODE,"
        + "MUNICIPALITY, CITY, STATE, COUNTRY, RFC, REGIME) "
        + "VALUES ( '" + issuing.getName() + "','"
        + issuing.getStreet() + "','"
        + issuing.getExtNum() + "','"
        + issuing.getIntNum() + "','"
        + issuing.getColony() + "','"
        + issuing.getReference() + "','"
        + issuing.getPostalCode() + "','"
        + issuing.getMunicipality() + "','"
        + issuing.getCity() + "','"
        + issuing.getState() + "','"
        + issuing.getCountry() + "','"
        + issuing.getRFC() + "','"
        + issuing.getRegime() + "' );";

      stmt.executeUpdate(sql);
      stmt.close();

      c.commit();
      c.close();
    } catch (Exception e) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.INFO, "Error creating issuing", e);
    }
  }

  public Issuing getIssuing( ) {
    Issuing issuing = new Issuing();

    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM ISSUING;");
      while (rs.next()) {
        String name = rs.getString("name");
        String street = rs.getString("street");
        String extNum = rs.getString("ext_num");
        String intNum = rs.getString("int_num");
        String colony = rs.getString("colony");
        String reference = rs.getString("reference");
        String postalCode = rs.getString("postal_code");
        String municipality = rs.getString("municipality");
        String city = rs.getString("city");
        String state = rs.getString("state");
        String country = rs.getString("country");
        String rfc = rs.getString("rfc");
        String regime = rs.getString("regime");

        issuing.setName(name);
        issuing.setStreet(street);
        issuing.setExtNum(extNum);
        issuing.setIntNum(intNum);
        issuing.setColony(colony);
        issuing.setReference(reference);
        issuing.setPostalCode(postalCode);
        issuing.setMunicipality(municipality);
        issuing.setCity(city);
        issuing.setState(state);
        issuing.setCountry(country);
        issuing.setRFC(rfc);
        issuing.setRegime(regime);
      }
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.INFO, "Couldn't get issuing", e);
      System.exit(0);
    }

    return issuing;
  }

  public boolean updateIssuing(Issuing newIssuing, String RFC) {
    boolean didUpdate = true;

    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String queryString = "UPDATE ISSUING "
        + "SET NAME='" + newIssuing.getName()
        + "', STREET='" + newIssuing.getStreet()
        + "', EXT_NUM='" + newIssuing.getExtNum()
        + "', INT_NUM='" + newIssuing.getIntNum()
        + "', COLONY='" + newIssuing.getColony()
        + "', REFERENCE='" + newIssuing.getReference()
        + "', POSTAL_CODE='" + newIssuing.getPostalCode()
        + "', MUNICIPALITY='" + newIssuing.getMunicipality()
        + "', CITY='" + newIssuing.getCity()
        + "', STATE='" + newIssuing.getState()
        + "', COUNTRY='" + newIssuing.getCountry()
        + "', RFC='" + newIssuing.getRFC()
        + "', REGIME='" + newIssuing.getRegime()
        + "' WHERE RFC='" + RFC + "';";
      stmt.executeUpdate(queryString);
      stmt.close();
      c.commit();
      c.close();
    } catch (Exception ex) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, "Couldn't update issuing", ex);
      didUpdate = false;
      return didUpdate;
    }

    return didUpdate;
  }

  public void createClient(Client client) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String sql = "INSERT INTO CLIENTS (NAME,STREET,EXT_NUM,INT_NUM,COLONY,REFERENCE,POSTAL_CODE,MUNICIPALITY,CITY,STATE,COUNTRY,RFC,EMAIL,PHONE,COMMENTS) "
        + "VALUES ( '" + client.getName() + "','" + client.getStreet() + "','" + client.getExtNum() + "','" + client.getIntNum() + "','" + client.getColony() + "','" + client.getReference() + "','" + client.getPostalCode() + "','" + client.getMunicipality() + "','" + client.getCity() + "','"
        + client.getState() + "','" + client.getCountry() + "','" + client.getRFC() + "','" + client.getEmail() + "','" + client.getPhone() + "','" + client.getComments() + "' );";
      stmt.executeUpdate(sql);
      stmt.close();

      c.commit();
      c.close();
    } catch (Exception e) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.INFO, "Error creating client", e);
    }
  }

  public ArrayList<Client> getClients(String clientName) {
    ArrayList<Client> clients = new ArrayList<Client>();

    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTS WHERE `NAME` like '" + clientName + "%';");
      while (rs.next()) {
        String name = rs.getString("name");
        String street = rs.getString("street");
        String extNum = rs.getString("ext_num");
        String intNum = rs.getString("int_num");
        String colony = rs.getString("colony");
        String reference = rs.getString("reference");
        String postalCode = rs.getString("postal_code");
        String municipality = rs.getString("municipality");
        String city = rs.getString("city");
        String state = rs.getString("state");
        String country = rs.getString("country");
        String rfc = rs.getString("rfc");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String comments = rs.getString("comments");

        Client client = new Client(name, street, extNum, intNum, colony, reference, postalCode, municipality, city, state, country, rfc, email, phone, comments);
        clients.add(client);
      }
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.INFO, "Couldn't get clients with that name", e);
      System.exit(0);
    }

    return clients;
  }

  public ArrayList<Client> getAllClients() {
    ArrayList<Client> clients = new ArrayList<Client>();

    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String queryString = "SELECT * FROM CLIENTS";
      ResultSet rs = stmt.executeQuery(queryString);
      while (rs.next()) {
        String name = rs.getString("name");
        String street = rs.getString("street");
        String extNum = rs.getString("ext_num");
        String intNum = rs.getString("int_num");
        String colony = rs.getString("colony");
        String reference = rs.getString("reference");
        String postalCode = rs.getString("postal_code");
        String municipality = rs.getString("municipality");
        String city = rs.getString("city");
        String state = rs.getString("state");
        String country = rs.getString("country");
        String rfc = rs.getString("rfc");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String comments = rs.getString("comments");

        Client client = new Client(name, street, extNum, intNum, colony, reference, postalCode, municipality, city, state, country, rfc, email, phone, comments);
        clients.add(client);
      }
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.INFO, "Couldn't get all clients", e);
      System.exit(0);
    }

    return clients;
  }

  public Client getClient(String clientRFC) {
    Connection c = null;
    Statement stmt = null;
    ArrayList<Client> clients = new ArrayList<Client>();
    Client client = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String queryString = "SELECT * FROM CLIENTS WHERE `RFC`='" + clientRFC + "';";
      ResultSet rs = stmt.executeQuery(queryString);
      while (rs.next()) {
        String name = rs.getString("name");
        String street = rs.getString("street");
        String extNum = rs.getString("ext_num");
        String intNum = rs.getString("int_num");
        String colony = rs.getString("colony");
        String reference = rs.getString("reference");
        String postalCode = rs.getString("postal_code");
        String municipality = rs.getString("municipality");
        String city = rs.getString("city");
        String state = rs.getString("state");
        String country = rs.getString("country");
        String rfc = rs.getString("rfc");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String comments = rs.getString("comments");

        client = new Client(name, street, extNum, intNum, colony, reference, postalCode, municipality, city, state, country, rfc, email, phone, comments);
        clients.add(client);
      }
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.INFO, "Couldn't get client", e);
      System.exit(0);
    }

    return client;
  }

  public boolean updateClient(Client client, String rfc) {
    boolean didUpdate = true;

    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String queryString = "UPDATE CLIENTS "
        + "SET NAME='" + client.getName()
        + "', STREET='" + client.getStreet()
        + "', EXT_NUM='" + client.getExtNum()
        + "', INT_NUM='" + client.getIntNum()
        + "', COLONY='" + client.getColony()
        + "', REFERENCE='" + client.getReference()
        + "', POSTAL_CODE='" + client.getPostalCode()
        + "', MUNICIPALITY='" + client.getMunicipality()
        + "', CITY='" + client.getCity()
        + "', STATE='" + client.getState()
        + "', COUNTRY='" + client.getCountry()
        + "', RFC='" + client.getRFC()
        + "', EMAIL='" + client.getEmail()
        + "', PHONE='" + client.getPhone()
        + "', COMMENTS='" + client.getComments()
        + "' WHERE RFC='" + rfc + "';";
      stmt.executeUpdate(queryString);
      stmt.close();
      c.commit();
      c.close();
    } catch (Exception ex) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, "Couldn't update client", ex);
      didUpdate = false;
      return didUpdate;
    }

    return didUpdate;
  }

  public boolean removeClient(String rfc) {
    boolean didRemove = true;

    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:database.db");
      c.setAutoCommit(false);

      stmt = c.createStatement();
      String queryString = "DELETE from CLIENTS WHERE RFC='" + rfc + "';";
      stmt.executeUpdate(queryString);
      stmt.close();
      c.commit();
      c.close();
    } catch (Exception ex) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, "Couldn't remove client", ex);
      didRemove = false;
      return didRemove;
    }

    return didRemove;
  }
}
