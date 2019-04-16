package com.hexaware.FTP112.model;

import java.util.Objects;
/**
 * Vendor class used to display Vendor information.
 * @author hexware
 */
public class Vendor {
  private int venId;
  private String venName;
  private String venPhoneNo;
  private String venUsername;
  private String venPassword;
  private double venBalance;
  private String venEmail;
/**
   * Default Constructor.
   */
  public Vendor() {

  }
/**
 * @param argsvenId to initialize vendor id.
 * @param argsvenName to initialize vendor name.
 * @param argsvenPhoneNo to initialize vendor phone no.
 * @param argsvenUsername to initialize vendor username.
 * @param argsvenPassword to initialize vendor password.
 * @param argsvenBalance to initialize vendor balance.
 * used to get details through constructor.

  public Vendor(final int argsvenId, final String argsvenName,
      final String argsvenPhoneNo, final String argsvenUsername,
      final String argsvenPassword, final double argsvenBalance) {
    this.venId = argsvenId;
    this.venName = argsvenName;
    this.venPhoneNo = argsvenPhoneNo;
    this.venUsername = argsvenUsername;
    this.venPassword = argsvenPassword;
    this.venBalance = argsvenBalance;

  }
  */
  /**
 * @param argsvenId to initialize vendor id.
 * @param argsvenName to initialize vendor name.
 * @param argsvenPhoneNo to initialize vendor phone no.
 * @param argsvenUsername to initialize vendor username.
 * @param argsvenBalance to initialize vendor balance.
 * @param argsvenEmail to initialize venEmail.
 * used to get details through constructor.
 */
  public Vendor(final int argsvenId, final String argsvenName,
      final String argsvenPhoneNo, final String argsvenUsername,
      final String argsvenEmail, final double argsvenBalance) {
    this.venId = argsvenId;
    this.venName = argsvenName;
    this.venPhoneNo = argsvenPhoneNo;
    this.venUsername = argsvenUsername;
    this.venBalance = argsvenBalance;
    this.venEmail = argsvenEmail;

  }
  /**
 * @param argsvenId to get vendor id.
   */
  public final void setVenId(final int argsvenId) {
    this.venId = argsvenId;
  }

/**
 * @param argsvenName to get vendorname.
*/
  public final void setVenName(final String argsvenName) {
    this.venName = argsvenName;
  }
 /**
 * @param argsvenPhoneNo to get Vendor phone no.
   */
  public final void setVenPhoneNo(final String argsvenPhoneNo) {
    this.venPhoneNo = argsvenPhoneNo;
  }

/**
 * @param argsvenUsername to get Vendor username.
   */
  public final void setVenUsername(final String argsvenUsername) {
    this.venUsername = argsvenUsername;
  }

/**
 * @param argsvenPassword to get Vendor password.
   */
  public final void setVenPassword(final String argsvenPassword) {
    this.venPassword = argsvenPassword;
  }

/**
 * @param argsvenBalance to get Vendor balance.
   */
  public final void setVenBalance(final double argsvenBalance) {
    this.venBalance = argsvenBalance;
  }
/**
 * @param argsVenEmail to get Vendor email.
   */
  public final void setVenEmail(final String argsVenEmail) {
    this.venEmail = argsVenEmail;
  }
/**
 * @return this venEmail.
     */
  public final String getVenEmail() {
    return this.venEmail;
  }

/**
 * @return this venId.
     */
  public final int getVenId() {
    return this.venId;
  }

  /**
    * @return this venName.
   */
  public final String getVenName() {
    return this.venName;
  }

/**
     * @return this venPhoneno.
     */
  public final String getVenPhoneNo() {
    return this.venPhoneNo;
  }

/**
     * @return this venUsername.
     */
  public final String getVenUsername() {
    return this.venUsername;
  }

/**
  * @return this venPassword.
  */
  public final String getVenPassword() {
    return this.venPassword;
  }

/**
  * @return this venBalance.
  */
  public final double getVenBalance() {
    return this.venBalance;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(venId, vendor.getVenId())
        && Objects.equals(venName, vendor.getVenName())
        && Objects.equals(venPhoneNo, vendor.getVenPhoneNo())
        && Objects.equals(venUsername, vendor.getVenUsername())
        && Objects.equals(venPassword, vendor.getVenPassword())
        && Objects.equals(venBalance, vendor.getVenBalance())) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(venId, venName, venPhoneNo, venUsername, venPassword, venBalance);
  }
}
