package com.hexaware.FTP112.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
  /**
     * to test Wallet.
     */
public class WalletTest {

  private Wallet wallet;
    /**
     * to test wallet.
     */

  @Before
    public final void setUp() {
    wallet = new Wallet(4, 360.00, "divya");
  }  /**
     * to test constuctor.
     */

  @Test
    public final void testWalletConstructor() {

    assertEquals(4, wallet.getWalletId());
    assertEquals(360.00, wallet.getWalletAmount(), 0);
    assertEquals("divya", wallet.getWalletSource());
  }
      /**
     * to test wallet_amount.
     */
  @Test
    public final void testSetWalletAmount() {
    assertEquals(360.00, wallet.getWalletAmount(), 0);
    wallet.setWalletAmount(56.00);
    assertNotEquals(360.00, wallet.getWalletId(), 0);
    assertEquals(56.00, wallet.getWalletAmount(), 0);
  }
      /**
     * to test wallet_amount.
     */
  @Test
    public final void testSetWalletSource() {
    assertEquals("divya", wallet.getWalletSource());
    wallet.setWalletSource("prathi");
    assertNotEquals("divya", wallet.getWalletSource());
    assertEquals("prathi", wallet.getWalletSource());
  }
     /**
     * to test constructor.
     */
  @Test
    public final void testWalletConstructortwo() {
    assertNotNull(new Wallet());
  }

    /**
     * to test equals.
     */
  @Test
    public final void testEquals() {
    Wallet x = new Wallet(4, 360.00, "divya");
    Wallet y = new Wallet(4, 360.00, "divya");
    assertTrue(x.equals(y) && y.equals(x));
  }
    /**
     * to test Not-equals.
     */
  @Test
    public final void testNotEquals() {
    Wallet x = new Wallet(4, 360.00, "divya");
    Wallet y = new Wallet(5, 370.00, "prathi");
    assertFalse(x.equals(y) && y.equals(x));
  }
    /**
     * to test hashcode.
     */
  @Test
    public final void testHashCodeTrue() {
    Wallet x = new Wallet(4, 360.00, "divya");
    Wallet y = new Wallet(4, 360.00, "divya");
    assertTrue(x.hashCode() == y.hashCode());
  }
    /**
     * to test hashcode.
     */
  @Test
    public final void testHashCodeFalse() {
    Wallet x = new Wallet(4, 360.00, "divya");
    Wallet y = new Wallet(5, 370.00, "prathi");
    assertFalse((x.hashCode()) == (y.hashCode()));
  }
    /**
     * to test method.
     */
  @Test
  public final void testObjectIsNull() {
    assertNotEquals(wallet, null);
  }
    /**
     * to test method.
     */
  @Test
  public final void testGetClass() {
    Vendor vendor = new Vendor();
    Wallet wallet1 = new Wallet();
    assertFalse(wallet1.equals(vendor));
  }



}

