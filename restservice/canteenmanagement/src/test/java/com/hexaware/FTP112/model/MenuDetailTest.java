package com.hexaware.FTP112.model;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

/**
 * Test class for MenuDetails.
 */
public class MenuDetailTest {
  private MenuDetails menuDetailsOne;
  private MenuDetails menuDetailsTwo;
 /**
 * Test class for MenuDetails.
 */
  @Before
    public final void setUp() {
    menuDetailsOne = new MenuDetails(1, 1, 220, 5, "good food");
    menuDetailsTwo = new MenuDetails(1, 5, "good food", 220, "GAURAV", "1234567890");
  }
 /**
 * Test method for MenuDetailsConstructor.
 */
  @Test
  public final void testMenuDetailsConstructorOne() {
    assertEquals(1, menuDetailsOne.getMenId());
    assertEquals(1, menuDetailsOne.getVenId());
    assertEquals(220, menuDetailsOne.getMenPrice(), 0);
    assertEquals(5, menuDetailsOne.getRatings());
    assertEquals("good food", menuDetailsOne.getReviews());
  }
  /**
 * Test method for MenuDetailsConstructor.
 */
  @Test
  public final void testMenuDetailsConstructorTwo() {
    assertEquals(1, menuDetailsTwo.getVenId());
    assertEquals("1234567890", menuDetailsTwo.getVenPhnNo());
    assertEquals(220, menuDetailsTwo.getMenPrice(), 0);
    assertEquals(5, menuDetailsTwo.getRatings());
    assertEquals("good food", menuDetailsTwo.getReviews());
    assertEquals("GAURAV", menuDetailsTwo.getVenName());
  }
  /**
 * Test method for MenuDetailsConstructor.
 */
  @Test
  public final void testMenuDetailsConstructorThree() {
    assertNotNull(new MenuDetails());
  }
  /**
 * Test method for Equal.
 */
  @Test
  public final void testEqualsTrue() {
    MenuDetails menuDetailsObject1 = new MenuDetails(1, 1, 220, 5, "good food");
    MenuDetails menuDetailsObject2 = new MenuDetails(1, 1, 220, 5, "good food");
    assertTrue(menuDetailsObject1.equals(menuDetailsObject2) && menuDetailsObject2.equals(menuDetailsObject1));
  }
  /**
 * Test method for Equal.
 */
  @Test
  public final void testEqualsFalse() {
    MenuDetails menuDetailsObject1 = new MenuDetails(1, 1, 220, 5, "not good food");
    MenuDetails menuDetailsObject2 = new MenuDetails(1, 1, 220, 5, "good food");
    assertFalse(menuDetailsObject1.equals(menuDetailsObject2) && menuDetailsObject2.equals(menuDetailsObject1));
  }
 /**
 * Test method for HashCode.
 */
  @Test
  public final void testHashCodeTrue() {
    MenuDetails menuDetailsObject1 = new MenuDetails(1, 1, 220, 5, "good food");
    MenuDetails menuDetailsObject2 = new MenuDetails(1, 1, 220, 5, "good food");
    assertTrue(menuDetailsObject1.hashCode() == menuDetailsObject2.hashCode());
  }
  /**
 * Test method for HashCode.
 */
  @Test
  public final void testHashCodeFalse() {
    MenuDetails menuDetailsObject1 = new MenuDetails(1, 1, 220, 5, "not good food");
    MenuDetails menuDetailsObject2 = new MenuDetails(1, 1, 220, 5, "good food");
    assertFalse(menuDetailsObject1.hashCode() == menuDetailsObject2.hashCode());
  }
  /**
 * Test method for MenId.
 */
  @Test
  public final void testSetMenId() {
    assertEquals(1, menuDetailsOne.getMenId());
    menuDetailsOne.setMenId(2);
    assertEquals(2, menuDetailsOne.getMenId());
    assertNotEquals(1, menuDetailsOne.getMenId());
  }
  /**
 * Test method for VenId.
 */
  @Test
  public final void testSetVenId() {
    assertEquals(1, menuDetailsOne.getVenId());
    menuDetailsOne.setVenId(2);
    assertEquals(2, menuDetailsOne.getVenId());
    assertNotEquals(1, menuDetailsOne.getVenId());
  }
  /**
 * Test method for MenPrice.
 */
  @Test
  public final void testSetMenPrice() {
    assertEquals(220, menuDetailsOne.getMenPrice(), 0);
    menuDetailsOne.setMenPrice(500);
    assertEquals(500, menuDetailsOne.getMenPrice(), 0);
    assertNotEquals(22, menuDetailsOne.getMenPrice(), 0);
  }
  /**
 * Test method for SetRatings.
 */
  @Test
  public final void testSetRatings() {
    assertEquals(5, menuDetailsOne.getRatings());
    menuDetailsOne.setRatings(2);
    assertEquals(2, menuDetailsOne.getRatings());
    assertNotEquals(1, menuDetailsOne.getRatings());
  }
  /**
 * Test method for VenPhnNo.
 */
  @Test
  public final void testSetVenPhnNo() {
    menuDetailsOne.setVenPhnNo("1234567891");
    assertEquals("1234567891", menuDetailsOne.getVenPhnNo());
    assertNotEquals("2345678901", menuDetailsOne.getVenPhnNo());
  }
  /**
 * Test method for VenName.
 */
  @Test
  public final void testSetVenName() {
    menuDetailsOne.setVenName("gaurav");
    assertEquals("gaurav", menuDetailsOne.getVenName());
    assertNotEquals("GAURAV", menuDetailsOne.getVenName());
  }
  /**
 * Test method for Reviews.
 */
  @Test
  public final void testSetReviews() {
    assertEquals("good food", menuDetailsOne.getReviews());
    menuDetailsOne.setReviews("not good");
    assertEquals("not good", menuDetailsOne.getReviews());
    assertNotEquals("good food", menuDetailsOne.getReviews());
  }
  /**
 * Test method for Reviews.
 */
  @Test
  public final void testObjectIsNull() {
    assertNotEquals(menuDetailsOne, null);
  }
  /**
 * Test method for Reviews.
 */
  @Test
  public final void testGetClass() {
    Customer customer = new Customer();
    assertFalse(menuDetailsOne.equals(customer));
  }

}

