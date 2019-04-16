package com.hexaware.FTP112.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;

  /**
    *to test Orderitem class.
    */
public class OrderItemsTest {
  private OrderItems orderItems1;
  private OrderItems orderItems2;
  /**
    *to setup values for constructor.
    */
  @Before
   public final void setUp() {
    orderItems1 = new OrderItems(1, 54.00, 2, 3);
    orderItems2 = new OrderItems(1, 2, 50.00, OrderStatus.PENDING, 3, 1);
  }
  /**
    *to test Orderitem class constructor.
    */
  @Test
   public final void testOrderitemConstructor1() {
    assertEquals(1, orderItems1.getMenId());
    assertEquals(54.00, orderItems1.getPrice(), 0);
    assertEquals(2, orderItems1.getQuantity());
    assertEquals(3, orderItems1.getOrderId());
  }
  /**
    *to test Orderitem class constructor.
    */
  @Test
   public final void testOrderitemConstructor2() {
    assertEquals(1, orderItems2.getOrderItemId());
    assertEquals(2, orderItems2.getMenId(), 0);
    assertEquals(50.00, orderItems2.getPrice(), 0);
    assertEquals(OrderStatus.PENDING, orderItems2.getStatus());
    assertEquals(3, orderItems2.getQuantity());
    assertEquals(1, orderItems2.getOrderId());
  }
  /**
    *to test setMenId Method.
    */
  @Test
   public final void testSetMenId() {
    assertEquals(2, orderItems2.getMenId());
    orderItems2.setMenId(3);
    assertNotEquals(2, orderItems2.getMenId());
    assertEquals(3, orderItems2.getMenId());
  }
  /**
    *to test setOrderItemId Method.
    */
  @Test
   public final void testSetOrderItemId() {
    assertEquals(1, orderItems2.getOrderItemId());
    orderItems2.setOrderItemId(5);
    assertNotEquals(1, orderItems2.getOrderItemId());
    assertEquals(5, orderItems2.getOrderItemId());
  }
  /**
    *to test setPrice Method.
    */
  @Test
   public final void testSetPrice() {
    assertEquals(50.00, orderItems2.getPrice(), 0);
    orderItems2.setPrice(2.00);
    assertNotEquals(50.00, orderItems2.getPrice(), 0);
    assertEquals(2.00, orderItems2.getPrice(), 0);
  }
  /**
    *to test setStatus Method.
    */
  @Test
   public final void testSetStatus() {
    assertEquals(OrderStatus.PENDING, orderItems2.getStatus());
    orderItems2.setStatus(OrderStatus.DENIED);
    assertNotEquals(OrderStatus.PENDING, orderItems2.getStatus());
    assertEquals(OrderStatus.DENIED, orderItems2.getStatus());
  }
  /**
    *to test setQuantity Method.
    */
  @Test
   public final void testSetQuantity() {
    assertEquals(3, orderItems2.getQuantity());
    orderItems2.setQuantity(1);
    assertNotEquals(3, orderItems2.getQuantity());
    assertEquals(1, orderItems2.getQuantity());
  }
  /**
    *to test setOrderId Method.
    */
  @Test
   public final void testSetOrderId() {
    assertEquals(1, orderItems2.getOrderId());
    orderItems2.setOrderId(2);
    assertNotEquals(1, orderItems2.getOrderId());
    assertEquals(2, orderItems2.getOrderId());
  }
  /**
    *to test setOrderId Method.
    */
  @Test
   public final void testSetMenItem() {
    orderItems1.setMenItem("jenni");
    assertEquals("jenni", orderItems1.getMenItem());
    orderItems1.setMenItem("jenni1");
    assertNotEquals("jenni", orderItems1.getMenItem());
  }
  /**
    *to test Equals Method.
    */
  @Test
   public final void testEquals() {
    OrderItems x = new OrderItems(1, 2, 50.00, OrderStatus.PENDING, 3, 1);
    OrderItems y = new OrderItems(1, 2, 50.00, OrderStatus.PENDING, 3, 1);
    assertTrue(x.equals(y) && y.equals(x));
  }
  /**
    *to test Equals Method.
    */
  @Test
   public final void testNotEquals() {
    OrderItems x = new OrderItems(1, 2, 50.00, OrderStatus.PENDING, 3, 1);
    OrderItems y = new OrderItems(3, 5, 55.00, OrderStatus.DENIED, 4, 9);
    assertFalse(x.equals(y) && y.equals(x));
  }
  /**
    *to test HashCode Method.
    */
  @Test
   public final void testHashCodeTrue() {
    OrderItems x = new OrderItems(1, 2, 50.00, OrderStatus.PENDING, 3, 1);
    OrderItems y = new OrderItems(1, 2, 50.00, OrderStatus.PENDING, 3, 1);
    assertTrue(x.hashCode() == y.hashCode());
  }
  /**
    *to test HashCode Method.
    */
  @Test
   public final void testHashCodeFalse() {
    OrderItems x = new OrderItems(1, 2, 50.00, OrderStatus.PENDING, 3, 1);
    OrderItems y = new OrderItems(3, 5, 55.00, OrderStatus.DENIED, 4, 9);
    assertFalse(x.hashCode() == y.hashCode());
  }
  /**
    *to test Objectgetclass part.
    */
  @Test
   public final void testGetclass() {
    Customer customer = new Customer();
    OrderItems order = new OrderItems(1, 54.00, 2, 3);
    assertFalse(order.equals(customer));
  }
  /**
    *to test Object null part.
    */
  @Test
   public final void testObjectNull() {
    assertFalse(orderItems2.equals(null));
  }
}
