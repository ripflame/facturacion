/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Ripflame
 */
public class Client {

  private String name;
  private String street;
  private String extNum;
  private String intNum;
  private String colony;
  private String reference;
  private String postalCode;
  private String municipality;
  private String city;
  private String state;
  private String country;
  private String RFC;
  private String email;
  private String phone;
  private String comments;

  public Client() {
    this.name = "";
    this.street = "";
    this.postalCode = "";
    this.city = "";
    this.state = "";
    this.country = "";
    this.RFC = "";
    this.email = "";
    this.phone = "";
    this.comments = "";
  }

  public Client(String name, String street, String extNum, String intNum, String colony, String reference, String postalCode, String municipality, String city, String state, String country, String RFC, String email, String phone) {
    this.name = name;
    this.street = street;
    this.extNum = extNum;
    this.intNum = intNum;
    this.colony = colony;
    this.reference = reference;
    this.postalCode = postalCode;
    this.municipality = municipality;
    this.city = city;
    this.state = state;
    this.country = country;
    this.RFC = RFC;
    this.email = email;
    this.phone = phone;
    this.comments = "";
  }

  public Client(String name, String street, String extNum, String intNum, String colony, String reference, String postalCode, String municipality, String city, String state, String country, String RFC, String email, String phone, String comments) {
    this.name = name;
    this.street = street;
    this.extNum = extNum;
    this.intNum = intNum;
    this.colony = colony;
    this.reference = reference;
    this.postalCode = postalCode;
    this.municipality = municipality;
    this.city = city;
    this.state = state;
    this.country = country;
    this.RFC = RFC;
    this.email = email;
    this.phone = phone;
    this.comments = comments;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the address
   */
  public String getStreet() {
    return street;
  }

  /**
   * @param street the address to set
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * @return the postalCode
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * @param postalCode the postalCode to set
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * @return the RFC
   */
  public String getRFC() {
    return RFC;
  }

  /**
   * @param RFC the RFC to set
   */
  public void setRFC(String RFC) {
    this.RFC = RFC;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * @return the comments
   */
  public String getComments() {
    return comments;
  }

  /**
   * @param comments the comments to set
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  /**
   * @return the extNum
   */
  public String getExtNum() {
    return extNum;
  }

  /**
   * @param extNum the extNum to set
   */
  public void setExtNum(String extNum) {
    this.extNum = extNum;
  }

  /**
   * @return the intNum
   */
  public String getIntNum() {
    return intNum;
  }

  /**
   * @param intNum the intNum to set
   */
  public void setIntNum(String intNum) {
    this.intNum = intNum;
  }

  /**
   * @return the colony
   */
  public String getColony() {
    return colony;
  }

  /**
   * @param colony the colony to set
   */
  public void setColony(String colony) {
    this.colony = colony;
  }

  /**
   * @return the reference
   */
  public String getReference() {
    return reference;
  }

  /**
   * @param reference the reference to set
   */
  public void setReference(String reference) {
    this.reference = reference;
  }

  /**
   * @return the municipality
   */
  public String getMunicipality() {
    return municipality;
  }

  /**
   * @param municipality the municipality to set
   */
  public void setMunicipality(String municipality) {
    this.municipality = municipality;
  }

}
