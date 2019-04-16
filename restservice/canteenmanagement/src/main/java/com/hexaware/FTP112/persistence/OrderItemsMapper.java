package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.FTP112.model.OrderItems;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
import com.hexaware.FTP112.model.OrderStatus;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class OrderItemsMapper implements ResultSetMapper<OrderItems> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final OrderItems map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return OrderITems
       */
    OrderItems orderItems = new OrderItems(rs.getInt("ORD_ITEM_ID"), rs.getInt("MEN_ID"), rs.getDouble("MEN_PRICE"),
        OrderStatus.valueOf(rs.getString("ORD_STATUS")),
        rs.getInt("ORD_QUANTITY"), rs.getInt("ORD_ID"));
    orderItems.setMenItem(rs.getString("MEN_ITEM"));
    return orderItems;
  }
}
