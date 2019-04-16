package com.hexaware.FTP112.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import java.util.Date;
import org.junit.Test;
import org.junit.Before;

/**
 * OrdersTest class used to test.
 * @author hexaware
 */
public class OrdersTest {
  private Orders order;

/**
 * OrdersTest class used to test.
 * @author hexaware
 */
  @Before
  public final void initInput() {
    order = new Orders(100, 201, 300.50d, 500);
  }

/**
  * Tests the empty constructor of the Orders class.
  */
  @Test
  public final void testEmptyConstructor() {
    assertNotNull(new Orders());
  }
/**
  * Tests the equals/hashcode methods of the Orders class.
  */
  @Test
  public final void testOrdersConstructor() {
    assertNotEquals(order, null);
    assertEquals(100, order.getCusId());
  }
/**
  * Tests the testSetCusId methods of the Orders class.
  */
  @Test
  public final void testSetCusId() {
    assertEquals(100, order.getCusId());
    order.setCusId(50);
    assertNotEquals(100, order.getCusId());
    assertEquals(50, order.getCusId());
  }
/**
  * Tests the testSetVenId methods of the Orders class.
  */
  @Test
  public final void testSetVenId() {
    assertEquals(201, order.getVenId());
    order.setVenId(51);
    assertNotEquals(201, order.getVenId());
    assertEquals(51, order.getVenId());
  }
/**
  * Tests the testSetTotalOrderPrice methods of the Orders class.
  */
  @Test
  public final void testSetTotalOrderPrice() {
    assertEquals(300.50d, order.getTotalOrderPrice(), 0);
    order.setOrderPrice(500.50d);
    assertNotEquals(300.50d, order.getTotalOrderPrice(), 0);
    assertEquals(500.50d, order.getTotalOrderPrice(), 0);
  }
/**
  * Tests the testSetWalletId methods of the Orders class.
  */
  @Test
  public final void testSetWalId() {
    assertEquals(500, order.getWalId(), 0);
    order.setWalId(502);
    assertNotEquals(500, order.getWalId(), 0);
    assertEquals(502, order.getWalId(), 0);
  }
/**
  * Tests the testSetOrderStatus methods of the Orders class.
  */
  @Test
  public final void testSetOrderStatus() {
    order.setOrderStatus(OrderStatus.ACCEPTED);
    assertEquals(OrderStatus.ACCEPTED, order.getOrderStatus());
    order.setOrderStatus(OrderStatus.DENIED);
    assertNotEquals(OrderStatus.ACCEPTED, order.getOrderStatus());
    assertEquals(OrderStatus.DENIED, order.getOrderStatus());
  }
/**
  * Tests the testSetOrderId methods of the Orders class.
  */
  @Test
  public final void testSetOrderId() {
    assertEquals(0, order.getOrderId());
    order.setOrderId(200);
    assertNotEquals(100, order.getOrderId());
    assertEquals(200, order.getOrderId());
  }
/**
  * Tests the testSetOrderComments methods of the Orders class.
  */
  @Test
  public final void testSetOrderComments() {
    order.setOrderComments("Late");
    assertEquals("Late", order.getOrderComments());
    order.setOrderComments("Delivered");
    assertNotEquals("Late", order.getOrderComments());
    assertEquals("Delivered", order.getOrderComments());
  }

/**
  * Tests the testSetOrderDate methods of the Orders class.
  */
  @Test
  public final void testSetOrderDate() {
    order.setOrderDate(new Date(19, 02, 12));
    assertEquals(new Date(19, 02, 12), order.getOrderDate());
    assertNotEquals(new Date(19, 01, 12), order.getOrderDate());
  }

/**
  * Tests the testEquals methods of the Orders class.
  */
  @Test
  public final void testEquals() {
    Orders order1 = new Orders(100, 201, 300.50d, 500);
    Orders order2 = new Orders(100, 201, 300.50d, 500);
    assertTrue(order1.equals(order2) && order2.equals(order1));
  }

/**
  * Tests the equals/hashcode methods of the Orders class.
  */
  @Test
  public final void testNotEquals() {
    Orders order1 = new Orders(100, 201, 300.50d, 500);
    Orders order2 = new Orders(101, 203, 500.50d, 601);
    assertFalse(order1.equals(order2) && order2.equals(order1));
  }
/**
  * Tests the testHash methods of the Orders class.
  */
  @Test
  public final void testHash() {
    Orders order1 = new Orders(100, 201, 300.50d, 500);
    Orders order2 = new Orders(100, 201, 300.50d, 500);
    assertTrue(order1.hashCode() == order2.hashCode());
  }
/**
  * Tests the testNotHash methods of the Orders class.
  */
  @Test
  public final void testNotHash() {
    Orders order1 = new Orders(100, 201, 300.50d, 500);
    Orders order2 = new Orders(101, 203, 500.50d, 601);
    assertFalse(order1.hashCode() == order2.hashCode());
  }
/**
  * Tests the testGetClass of the Orders class.
  */
  @Test
  public final void testGetClass() {
    Customer customer = new Customer();
    Orders order1 = new Orders();
    assertFalse(order1.equals(customer));
  }
/**
  * Tests the testObjectIsNull of the Orders class.
  */
  @Test
  public final void testObjectIsNull() {
    assertFalse(order.equals(null));
  }
}

