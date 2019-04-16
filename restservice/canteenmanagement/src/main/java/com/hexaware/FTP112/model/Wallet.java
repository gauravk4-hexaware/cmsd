package com.hexaware.FTP112.model;

import java.util.Objects;

/**
 * Wallet class used to display Wallet information.
 * @author hexware
 */
public class Wallet {
    /*Attributes in wallet */
  private int walletId;
  private double walletAmount;
  private String walletSource;
/**
   * Default Constructor.
   */
  public Wallet() {

  }
/**
 * @param argswalletAmount to initialize wallet amount.
 * @param argswalletSource to initialize wallet source.
 * @param argswalletId to initialize wallet Id.
 * used to get details through constructor.
 */
  public Wallet(final int argswalletId, final double argswalletAmount, final String argswalletSource) {
    this.walletId = argswalletId;
    this.walletAmount = argswalletAmount;
    this.walletSource = argswalletSource;
  }
     /**
     * @param argswalletAmount gets the wallet amount.
     */
  public final void setWalletAmount(final double argswalletAmount) {
    this.walletAmount = argswalletAmount;
  }
  /**
     * @param argswalletSource gets the wallet source.
     */
  public final void setWalletSource(final String argswalletSource) {
    this.walletSource = argswalletSource;
  }
  /**
     * @return this wallet amount.
     */
  public final double getWalletAmount() {
    return walletAmount;
  }
  /**
     * @return this wallet source.
     */
  public final int getWalletId() {
    return walletId;
  }
  /**
     * @return this wallet source.
     */
  public final String getWalletSource() {
    return walletSource;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Wallet wallet = (Wallet) obj;
    if (Objects.equals(walletAmount, wallet.getWalletAmount()) && Objects.equals(walletSource, wallet.getWalletSource())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(walletAmount, walletSource);
  }
}
