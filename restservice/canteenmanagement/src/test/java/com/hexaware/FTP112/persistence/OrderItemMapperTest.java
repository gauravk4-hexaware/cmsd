package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP112.model.OrderItems;
import com.hexaware.FTP112.model.OrderStatus;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;


/**
 * Test class for MenuDetails.
 */
public class OrderItemMapperTest {
 /**
 * Test class for MenuDetails.
 *@param resultSet to set resultSet.
 *@throws SQLException to throw exception.
 */
  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {
    new Expectations() {
      {
        resultSet.getInt("ORD_ITEM_ID"); result =  34;
        resultSet.getInt("MEN_ID"); result = 2;
        resultSet.getDouble("MEN_PRICE"); result = 200.00;
        resultSet.getString("ORD_STATUS"); result = "PENDING";
        resultSet.getInt("ORD_QUANTITY"); result = 3;
        resultSet.getInt("ORD_ID"); result = 5;
      }
    };
    OrderItemsMapper orderItemsMapper = new OrderItemsMapper();
    OrderItems orderItems = orderItemsMapper.map(3, resultSet, null);
    assertEquals(34, orderItems.getOrderItemId());
    assertEquals(2, orderItems.getMenId());
    assertEquals(200.00, orderItems.getPrice(), 0);
    assertEquals(OrderStatus.PENDING, orderItems.getStatus());
    assertEquals(3, orderItems.getQuantity());
    assertEquals(5, orderItems.getOrderId());

    new Verifications() { {
        resultSet.getInt("ORD_ITEM_ID"); times = 1;
        resultSet.getInt("MEN_ID"); times = 1;
        resultSet.getDouble("MEN_PRICE"); times = 1;
        resultSet.getString("ORD_STATUS"); times = 1;
        resultSet.getInt("ORD_QUANTITY"); times = 1;
        resultSet.getInt("ORD_ID"); times = 1;
        }
    };

  }
}
