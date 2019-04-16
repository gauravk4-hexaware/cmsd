package com.hexaware.FTP112.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.FTP112.model.OrderItems;
import com.hexaware.FTP112.model.OrderStatus;
import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.persistence.OrdersDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

  /**
    *to test Order Factory class.
    */
@RunWith(JMockit.class)
public class OrdersFactoryTest {
  /**
    *to test empty constructor.
    */
  @Test
  public final void constructorTest() {
    assertNotNull(new OrdersFactory());

  }
  /**
    *to test showPendingOrdId method with invalid data.
    */
  @Test
  public final void showPendingOrdIdWithInvalidValue() {
    new MockUp<Validators>() {
        @Mock
        public void validateOrderItemId(final int ordItemId) {
            throw new IllegalArgumentException("Invalid orderitem Id");
        }
    };
    try {
      OrdersFactory.showPendingOrdId(200);
      fail("Validator failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals(e.getMessage(), "Invalid orderitem Id");
    }
  }
  /**
    *to test showPendingOrdI method with valid data.
    */
  @Test
  public final void showPendingOrdIdWithValidValue() {
    new MockUp<Validators>() {
      @Mock
        public void validateOrderItemId(final int ordItemId) { }
        };
    new Expectations() { {
        Validators.validateOrderItemId(200);
        }
        };
    try {
      OrdersFactory.showPendingOrdId(201);
    } catch (IllegalArgumentException e) {
      fail("Validation failed");
    }
  }
  /**
    *to test findByOrderItemId method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void findByOrderItemIdTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
          @Mock
            public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
          dao.fetchOrderItemId(200); result = 30;
        }
        };
    int authentication = OrdersFactory.findByOrderItemId(200);
    assertEquals(authentication, 30);
    new Verifications() { {
          dao.fetchOrderItemId(200); times = 1;
        }
        };
  }
  /**
    *to test showPendingOrders method.
   * @param dao to initialize wallet amount.
    */
  @Test
  public final void showPendingOrdersTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
            public OrdersDAO dao() {
        return dao;
      }
        };
    List<OrderItems> list = new ArrayList<OrderItems>();
    OrderItems o1 = new OrderItems(1, 20.00, 1, 1);
    OrderItems o2 = new OrderItems(2, 20.00, 2, 2);
    OrderItems o3 = new OrderItems(3, 20.00, 3, 3);
    list.add(o1);
    list.add(o2);
    list.add(o3);
    new Expectations() { {
        List<OrderItems> list = new ArrayList<OrderItems>();
        OrderItems o1 = new OrderItems(1, 20.00, 1, 1);
        OrderItems o2 = new OrderItems(2, 20.00, 2, 2);
        OrderItems o3 = new OrderItems(3, 20.00, 3, 3);
        list.add(o1);
        list.add(o2);
        list.add(o3);
        dao.show(200); result = list;
        }
        };
    List<OrderItems> orders = OrdersFactory.showPendingOrders(200);
    assertEquals(orders, list);
    assertEquals(orders.isEmpty(), false);
    assertEquals(orders.size(), 3);
    new Verifications() { {
        dao.show(200); times = 1;
        }
        };
  }
  /**
    *to test showCustomerHistory method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void showCustomerHistoryTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
      @Mock
            public OrdersDAO dao() {
        return dao;
      }
      };
    List<Orders> res = new ArrayList<Orders>();
    Orders orders1 = new Orders(1, 1, 20.00, 1);
    Orders orders2 = new Orders(2, 2, 20.00, 2);
    Orders orders3 = new Orders(3, 3, 20.00, 3);
    res.add(orders1);
    res.add(orders2);
    res.add(orders3);

    new Expectations() { {
            List<Orders> res = new ArrayList<Orders>();
            Orders o1 = new Orders(1, 1, 20.00, 1);
            Orders o2 = new Orders(2, 2, 20.00, 2);
            Orders o3 = new Orders(3, 3, 20.00, 3);
            res.add(o1);
            res.add(o2);
            res.add(o3);
            dao.customerHistory(200); result = res;
        }
        };
    List<Orders> orders = OrdersFactory.showCustomerHistory(200);
    assertEquals(orders, res);
    assertEquals(orders.size(), 3);
    new Verifications() { {
            dao.customerHistory(200); times = 1;
        }
        };
  }
  /**
    *to test setPlaceOrder method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void setPlaceOrderTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
            return dao;
        }
        };
    new Expectations() { {
            dao.placeOrder(new Orders(1, 1, 20.00, 1)); result = 10;
        }
        };
    int result = OrdersFactory.setPlaceOrder(new Orders(1, 1, 20.00, 1));
    assertEquals(result, 10);
    new Verifications() { {
            dao.placeOrder(new Orders(1, 1, 20.00, 1)); times = 1;
        }
        };
  }
  /**
    *to test updateOrderItems method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void updateOrderItemsTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
            public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.updateOrderItems(new OrderItems(10, 250.50, 10, 10));
        }
        };
    OrdersFactory.updateOrderItems(new OrderItems(10, 250.50, 10, 10));
  }
  /**
    *to test updateStatus method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void updateStatusTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.updateOrderStatus(10, OrderStatus.PENDING);
        }
        };
    OrdersFactory.updateStatus(10, OrderStatus.PENDING);
    new Verifications() { {
            dao.updateOrderStatus(10, OrderStatus.PENDING); times = 1;
        }
        };
  }
      /**
    *to test updateStatus method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void updateCommentsTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.updateOrderComments(1, "orderrr");
        }
        };
    OrdersFactory.updateComments(1, "orderrr");
    new Verifications() { {
            dao.updateOrderComments(1, "orderrr"); times = 1;
        }
        };
  }

  /**
    *to test updateStatus method.
    * @param dao to mock orders dao.
    */
  @Test
  public final void updateCommentTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.updateOrderComments(10, "comments");
        }
        };
    OrdersFactory.updateComments(10, "comments");
    new Verifications() { {
            dao.updateOrderComments(10, "comments"); times = 1;
        }
        };
  }
  /**
    *to test showVendorHistory method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void showVendorHistoryTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    List<Orders> res = new ArrayList<Orders>();
    Orders o1 = new Orders(1, 1, 20.00, 1);
    Orders o2 = new Orders(2, 2, 20.00, 2);
    Orders o3 = new Orders(3, 3, 20.00, 3);
    res.add(o1);
    res.add(o2);
    res.add(o3);
    new Expectations() { {
            List<Orders> res = new ArrayList<Orders>();
            Orders o1 = new Orders(1, 1, 20.00, 1);
            Orders o2 = new Orders(2, 2, 20.00, 2);
            Orders o3 = new Orders(3, 3, 20.00, 3);
            res.add(o1);
            res.add(o2);
            res.add(o3);
            dao.vendorHistory(200); result = res;
        }
        };
    List<Orders> orders = OrdersFactory.showVendorHistory(200);
    assertEquals(orders, res);
    assertEquals(orders.size(), 3);
    new Verifications() { {
            dao.vendorHistory(200); times = 1;
        }
        };
  }
  /**
    *to test getPrice method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void getPriceTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.getPrice(10, 20); result = 250.50;
        }
        };
    double price = OrdersFactory.getPrice(10, 20);
    assertEquals(price, 250.50, 0);
    new Verifications() { {
            dao.getPrice(10, 20); times = 1;
        }
        };
  }
  /**
    *to test getCustomerId method.
   * @param dao to initialize wallet amount.
    */
  @Test
  public final void getCustomerIdTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.getCustomerId(10, 20); result = 250;
        }
        };
    int res = OrdersFactory.getCustomerId(10, 20);
    assertEquals(res, 250);
    new Verifications() { {
            dao.getCustomerId(10, 20); times = 1;
        }
        };
  }
  /**
    *to test getWalletId method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void getWalletIdTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.getWalletId(10); result = 250;
        }
        };
    int res = OrdersFactory.getWalletId(10);
    assertEquals(res, 250);
    new Verifications() { {
            dao.getWalletId(10); times = 1;
        }
        };
  }
  /**
    *to test updateTotalPrice method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void updateTotalPriceTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.updateTotalPrice(250.50, 10);
        }
        };
    OrdersFactory.updateTotalPrice(250.50, 10);
    new Verifications() { {
            dao.updateTotalPrice(250.50, 10); times = 1;
        }
        };
  }
  /**
    *to test findByOrderItemIdByVenId method.
    * @param dao to initialize OrdersDAO.
    */
  @Test
  public final void findByOrderItemIdByVenIdTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
            dao.findByOrderItemByVen(250, 50); result = 10;
        }
        };
    int count = OrdersFactory.findByOrderItemIdByVenId(250, 50);
    assertEquals(count, 10);
    new Verifications() { {
            dao.findByOrderItemByVen(250, 50); times = 1;
        }
        };
  }

    /**
    *to test getOrders.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void getOrders(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    Orders o1 = new Orders(1, 1, 20.00, 1);
    new Expectations() { {

          Orders o1 = new Orders(1, 1, 20.00, 1);
          dao.getOrders(200); result = o1;
        }
        };
    Orders orders = OrdersFactory.getOrders(200);
    assertEquals(orders, o1);
    new Verifications() { {
            dao.getOrders(200); times = 1;
        }
        };
  }
    /**
    *to test showVendorHistory method.
    * @param dao to initialize wallet amount.
    */
  @Test
  public final void taxCalculationTest(@Mocked final OrdersDAO dao) {
    new MockUp<OrdersFactory>() {
        @Mock
        public OrdersDAO dao() {
        return dao;
      }
        };
    List<Orders> res = new ArrayList<Orders>();
    Orders o1 = new Orders(1, 1, 20.00, 1);
    Orders o2 = new Orders(2, 2, 20.00, 2);
    Orders o3 = new Orders(3, 3, 20.00, 3);
    res.add(o1);
    res.add(o2);
    res.add(o3);
    new Expectations() { {
          List<Orders> res = new ArrayList<Orders>();
          Orders o1 = new Orders(1, 1, 20.00, 1);
          Orders o2 = new Orders(2, 2, 20.00, 2);
          Orders o3 = new Orders(3, 3, 20.00, 3);
          res.add(o1);
          res.add(o2);
          res.add(o3);
          dao.taxCalculation(200, 200); result = res;
        }
        };
    List<Orders> orders = OrdersFactory.taxCalculation(200, 200);
    assertEquals(orders, res);
    assertEquals(orders.size(), 3);
    new Verifications() { {
            dao.taxCalculation(200, 200); times = 1;
        }
        };
  }


}
