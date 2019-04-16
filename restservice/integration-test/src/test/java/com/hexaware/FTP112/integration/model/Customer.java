package com.hexaware.FTP112.integration.model;

import java.util.Objects;
/**
 * Customer class used to display Customer information.
 * @author hexaware
 */
public class Customer {
/*attributes in customer table*/
  private int cusId;
  private String cusName;
  private String cusPhoneNo;
  private String cusEmail;
  private String cusUserName;
  private String cusPassword;
  /**
   * Default Constructor.
   */
  public Customer() {

  }
/**
 * @param argCusId to initialize customer id.
 * @param argCusName to initialize customer name.
 * @param argCusPhoneNo to initialize customer phone number.
 * @param argCusUserName to initialize customer username.
 * @param argscusEmail to initialize customer username.
 * used to get details through constructor.
 */
  public Customer(final int argCusId, final String argCusName,
      final String argCusPhoneNo,
      final String argCusUserName,
      final String argscusEmail) {
    this.cusId = argCusId;
    this.cusName = argCusName;
    this.cusPhoneNo = argCusPhoneNo;
    this.cusUserName = argCusUserName;
    this.cusEmail = argscusEmail;
  }
  /**
   * @param argCusId gets the cus id.
   */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
  /**
   * @param argCusName gets the cus name.
   */
  public final void setCusName(final String argCusName) {
    this.cusName = argCusName;
  }
  /**
   * @param argCusPhoneNo gets the cus phone no.
   */
  public final void setCusPhoneNo(final String argCusPhoneNo) {
    this.cusPhoneNo = argCusPhoneNo;
  }
  /**
   * @param argscusEmail gets the cus email.
   */
  public final void setCusEmail(final String argscusEmail) {
    this.cusEmail = argscusEmail;
  }
  /**
   * @param argCusUserName gets the cus user name.
   */
  public final void setCusUserName(final String argCusUserName) {
    this.cusUserName = argCusUserName;
  }
  /**
   * @param argscusPassword gets the cus password.
   */
  public final void setCusPassword(final String argscusPassword) {
    this.cusPassword = argscusPassword;
  }

    /**
     * @return this cus ID.
     */
  public final int getCusId() {
    return this.cusId;
  }
    /**
     * @return this cus name.
     */
  public final String getCusName() {
    return this.cusName;
  }
    /**
     * @return this phone no.
     */
  public final String getCusPhoneNo() {
    return this.cusPhoneNo;
  }
    /**
     * @return this cus email.
     */
  public final String getCusEmail() {
    return this.cusEmail;
  }
     /**
     * @return this user name.
     */
  public final String getCusUserName() {
    return this.cusUserName;
  }
     /**
     * @return this cus password.
     */
  public final String getCusPassword() {
    return this.cusPassword;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    if (Objects.equals(cusId, customer.getCusId())
        && Objects.equals(cusName, customer.getCusName())
        && Objects.equals(cusPhoneNo, customer.getCusPhoneNo())
        && Objects.equals(cusUserName, customer.getCusUserName())) {
        //&& Objects.equals(cusPassword, customer.getCusPassword())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, cusName, cusPhoneNo, cusUserName);
  }
}
