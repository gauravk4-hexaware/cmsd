package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.model.OrderStatus;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
  /**
    *to test mapper class.
    */

public class OrdersMapperTest {
      /**
    *@param resultSet to set resultSet.
    *@throws SQLException to throw exception.
    *to test Mapper Method.
    */

  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
        {
          resultSet.getInt("CUS_ID"); result = 56;
          resultSet.getInt("VEN_ID"); result = 77;
          resultSet.getDouble("TOTAL_ORD_PRICE"); result = 75.00;
          resultSet.getInt("WAL_ID"); result = 22;
          resultSet.getString("ORD_STATUS"); result = "PENDING";
          resultSet.getString("ORD_COMMENTS"); result = "good";
      }
        };
    OrdersMapper ordersMapper = new OrdersMapper();
    Orders orders = ordersMapper.map(56, resultSet, null);
    assertEquals(56, orders.getCusId());
    assertEquals(77, orders.getVenId());
    assertEquals(75.00, orders.getTotalOrderPrice(), 0);
    assertEquals(22, orders.getWalId());
    assertEquals(OrderStatus.PENDING, orders.getOrderStatus());
    assertEquals("good", orders.getOrderComments());

    new Verifications() { {
          resultSet.getInt("CUS_ID"); times = 1;
          resultSet.getInt("VEN_ID"); times = 1;
          resultSet.getDouble("TOTAL_ORD_PRICE"); times = 1;
          resultSet.getInt("WAL_ID"); times = 1;
          resultSet.getString("ORD_STATUS"); times = 1;
          resultSet.getString("ORD_COMMENTS"); times = 1;
        } };

  }
}
