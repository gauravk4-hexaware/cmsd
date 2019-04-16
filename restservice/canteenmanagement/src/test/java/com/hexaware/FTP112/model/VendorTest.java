package com.hexaware.FTP112.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

  /**
     * to test Vendor.
     */
public class VendorTest {

  private Vendor vendor;
    /**
     * to test vendor.
     */

  @Before
    public final void setUp() {
    vendor = new Vendor(4, "divya", "9892345678", "prathi", "jennifa@gmail.com", 360.00);
  }  /**
     * to test constuctor.
     */

  @Test
    public final void testVendorConstructor() {

    assertEquals(4, vendor.getVenId());
    assertEquals("divya", vendor.getVenName());
    assertEquals("9892345678", vendor.getVenPhoneNo());
    assertEquals("prathi", vendor.getVenUsername());
    assertEquals(360.00, vendor.getVenBalance(), 0);
    assertEquals("jennifa@gmail.com", vendor.getVenEmail());
  }
  /**
     * to test vendor_Id.
     */
  @Test
    public final void testSetVenId() {
    assertEquals(4, vendor.getVenId());
    vendor.setVenId(56);
    assertNotEquals(4, vendor.getVenId());
    assertEquals(56, vendor.getVenId());
  }
    /**
     * to test vendor_Name.
     */
  @Test
   public final void testSetVenName() {
    assertEquals("divya", vendor.getVenName());
    vendor.setVenName("malar");
    assertNotEquals("divya", vendor.getVenName());
    assertEquals("malar", vendor.getVenName());
  }
    /**
     * to test vendor_PhoneNumber.
     */
  @Test
   public final void testSetVenPhoneNo() {
    assertEquals("9892345678", vendor.getVenPhoneNo());
    vendor.setVenPhoneNo("9876543210");
    assertNotEquals("9892345678", vendor.getVenPhoneNo());
    assertEquals("9876543210", vendor.getVenPhoneNo());
  }
    /**
     * to test vendor_UserName.
     */
  @Test
   public final void testSetVenUsername() {
    assertEquals("prathi", vendor.getVenUsername());
    vendor.setVenUsername("madhu");
    assertNotEquals("prathi", vendor.getVenUsername());
    assertEquals("madhu", vendor.getVenUsername());
  }
    /**
     * to test vendor_Balance.
     */
  @ Test
   public final void testSetVenBalance() {
    assertEquals(360.00, vendor.getVenBalance(), 0);
    vendor.setVenBalance(400.00);
    assertNotEquals(360.00, vendor.getVenBalance(), 0);
    assertEquals(400.00, vendor.getVenBalance(), 0);
  }
  /**
     * to test vendor_Balance.
     */
  @ Test
   public final void testSetVenPassword() {
    vendor.setVenPassword("divi");
    assertNotEquals("prathi", vendor.getVenPassword());
    assertEquals("divi", vendor.getVenPassword());
  }
  /**
     * to test vendor_email.
     */
  @ Test
   public final void testSetVenEmail() {
    vendor.setVenEmail("jennifa13@gmail.com");
    assertNotEquals("jennifa@gmail.com", vendor.getVenEmail());
    assertEquals("jennifa13@gmail.com", vendor.getVenEmail());
  }
       /**
     * to test constructor.
     */
  @Test
    public final void testVendorConstructortwo() {
    assertNotNull(new Vendor());
  }
    /**
     * to test equals.
     */
  @Test
    public final void testEquals() {
    Vendor x = new Vendor(4, "divya", "9892345678", "prathi", "jennifa@gmail.com", 360.00);
    Vendor y = new Vendor(4, "divya", "9892345678", "prathi", "jennifa@gmail.com", 360.00);
    assertTrue(x.equals(y) && y.equals(x));
  }
    /**
     * to test Not-equals.
     */
  @Test
    public final void testNotEquals() {
    Vendor x = new Vendor(4, "divya", "9892345678", "prathi", "jennifa@gmail.com", 360.00);
    Vendor y = new Vendor(2, "kaviya", "9087654321", "kaatru", "jennifa@gmail.com", 360.00);
    assertFalse(x.equals(y) && y.equals(x));
  }
    /**
     * to test hashcode.
     */
  @Test
    public final void testHashCodeTrue() {
    Vendor x = new Vendor(4, "divya", "9892345678", "prathi", "jennifa@gmail.com", 360.00);
    Vendor y = new Vendor(4, "divya", "9892345678", "prathi", "jennifa@gmail.com", 360.00);
    assertTrue(x.hashCode() == y.hashCode());
  }
    /**
     * to test hashcode.
     */
  @Test
    public final void testHashCodeFalse() {
    Vendor x = new Vendor(4, "divya", "9892345678", "prathi", "jennifa@gmail.com", 360.00);
    Vendor y = new Vendor(2, "kaviya", "9087654321", "kaatru", "jennifa@gmail.com", 360.00);
    assertFalse((x.hashCode()) == (y.hashCode()));
  }
  /**
     * to test method.
     */
  @Test
  public final void testObjectIsNull() {
    assertNotEquals(vendor, null);
  }
    /**
     * to test method.
     */
  @Test
  public final void testGetClass() {
    Vendor vendor1 = new Vendor();
    Wallet wallet = new Wallet();
    assertFalse(vendor1.equals(wallet));
  }




}
