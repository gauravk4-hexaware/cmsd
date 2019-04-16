package com.hexaware.FTP112.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;

  /**
    *to test Menu class.
    */
public class MenuTest {
  private Menu menu;
  /**
    *to setup values for constructor.
    */
  @Before
   public final void setUp() {
    menu = new Menu(1, "pav bhaji", 12.00, 1, 4, "nice", 120.00);
  }
  /**
    *to test Menu class constructor.
    */
  @Test
   public final void testMenuConstructor() {
    assertEquals(1, menu.getMenId());
    assertEquals("pav bhaji", menu.getMenItem());
    assertEquals(12.00, menu.getMenCalories(), 0);
    assertEquals(1, menu.getVenId());
    assertEquals(4, menu.getRatings());
    assertEquals("nice", menu.getReviews());
    assertEquals(120.00, menu.getMenPrice(), 0);
  }
  /**
    *to test Empty constructor.
    */
  @Test
   public final void testEmptyConstructor() {
    assertNotNull(new Menu());
  }
  /**
    *to test setMenId Method.
    */
  @Test
   public final void testSetMenId() {
    assertEquals(1, menu.getMenId());
    menu.setMenId(2);
    assertNotEquals(1, menu.getMenId());
    assertEquals(2, menu.getMenId());
  }
  /**
    *to test setMenItem Method.
    */
  @Test
   public final void testSetMenItem() {
    assertEquals("pav bhaji", menu.getMenItem());
    menu.setMenItem("Tikki");
    assertNotEquals("pav bhaji", menu.getMenItem());
    assertEquals("Tikki", menu.getMenItem());
  }
  /**
    *to test setMenCalories Method.
    */
  @Test
   public final void testSetMenCalories() {
    assertEquals(12.00, menu.getMenCalories(), 0);
    menu.setMenCalories(2.00);
    assertNotEquals(23.00, menu.getMenCalories(), 0);
    assertEquals(2.00, menu.getMenCalories(), 0);
  }
  /**
    *to test setVenPhnNo Method.
    */
  @Test
   public final void testSetVenPhnNo() {
    menu.setVenPhnNo("457637");
    assertNotEquals("62346", menu.getVenPhnNo());
    assertEquals("457637", menu.getVenPhnNo());
  }
  /**
    *to test setMenPrice Method.
    */
  @Test
   public final void testSetMenPrice() {
    assertEquals(120.00, menu.getMenPrice(), 0);
    menu.setMenPrice(12.00);
    assertNotEquals(120.00, menu.getMenPrice(), 0);
    assertEquals(12.00, menu.getMenPrice(), 0);
  }
  /**
    *to test setVenName Method.
    */
  @Test
   public final void testSetVenName() {
    menu.setVenName("aman");
    assertNotEquals("none", menu.getVenName());
    assertEquals("aman", menu.getVenName());
  }
  /**
    *to test setMenSpeciality Method.
    */
  @Test
   public final void testSetMenSpeciality() {
    menu.setMenSpeciality("aman");
    assertNotEquals("none", menu.getMenSpeciality());
    assertEquals("aman", menu.getMenSpeciality());
  }
  /**
    *to test Equals Method.
    */
  @Test
   public final void testEquals() {
    Menu x = new Menu(1, "pav bhaji", 12.00, 1, 4, "nice", 120.00);
    Menu y = new Menu(1, "pav bhaji", 12.00, 1, 4, "nice", 120.00);
    assertTrue(x.equals(y) && y.equals(x));
  }
  /**
    *to test Equals Method.
    */
  @Test
   public final void testNotEquals() {
    Menu x = new Menu(1, "pav bhaji", 12.00, 1, 4, "nice", 120.00);
    Menu y = new Menu(2, "bhaji", 32.00, 4, 5, "good", 130.00);
    assertFalse(x.equals(y) && y.equals(x));
  }
  /**
    *to test HashCode Method.
    */
  @Test
   public final void testHashCodeTrue() {
    Menu x = new Menu(1, "pav bhaji", 12.00, 1, 4, "nice", 120.00);
    Menu y = new Menu(1, "pav bhaji", 12.00, 1, 4, "nice", 120.00);
    assertTrue(x.hashCode() == y.hashCode());
  }
  /**
    *to test HashCode Method.
    */
  @Test
   public final void testHashCodeFalse() {
    Menu x = new Menu(1, "pav bhaji", 12.00, 1, 4, "nice", 120.00);
    Menu y = new Menu(2, "bhaji", 32.00, 4, 5, "good", 130.00);
    assertFalse(x.hashCode() == y.hashCode());
  }
  /**
    *to test Objectgetclass part.
    */
  @Test
   public final void testGetclass() {
    Customer customer = new Customer();
    Menu menu1 = new Menu();
    assertFalse(menu1.equals(customer));
  }
  /**
    *to test Object null part.
    */
  @Test
   public final void testObjectNull() {
    assertFalse(menu.equals(null));
  }
}
