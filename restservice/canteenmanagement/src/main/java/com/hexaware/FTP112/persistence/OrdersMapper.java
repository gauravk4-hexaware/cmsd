package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.model.OrderStatus;


import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrderMapper class used to fetch Orders data from database.
 * @author hexware
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Orders
       */
    Orders orders = new Orders(rs.getInt("CUS_ID"), rs.getInt("VEN_ID"),
        rs.getDouble("TOTAL_ORD_PRICE"), rs.getInt("WAL_ID"));
    orders.setOrderId(rs.getInt("ORD_ID"));
    orders.setOrderDate(rs.getTimestamp("ORD_DATE"));
    orders.setOrderStatus(OrderStatus.valueOf(rs.getString("ORD_STATUS")));
    orders.setOrderComments(rs.getString("ORD_COMMENTS"));
    orders.setWalletSource(rs.getString("WAL_SOURCE"));
    orders.setCusName(rs.getString("CUS_NAME"));
    orders.setVenName(rs.getString("VEN_NAME"));
    return orders;
  }
}



