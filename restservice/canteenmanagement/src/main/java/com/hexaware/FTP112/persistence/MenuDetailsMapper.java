package com.hexaware.FTP112.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.FTP112.model.MenuDetails;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class MenuDetailsMapper implements ResultSetMapper<MenuDetails> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final MenuDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return MenuDetails
       */
    return new MenuDetails(rs.getInt("VEN_ID"), rs.getInt("JUN_RATING"), rs.getString("JUN_REVIEWS"),
                    rs.getDouble("JUN_PRICE"), rs.getString("VEN_NAME"), rs.getString("VEN_PHN_NO"));
  }
}
