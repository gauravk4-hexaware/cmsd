
package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP112.model.Vendor;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * VendorMapper class used to fetch Vendor data from database.
 * @author hexware
 */
public class VendorMapper implements ResultSetMapper<Vendor> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Vendor map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Vendor
       */
    return new Vendor(rs.getInt("VEN_ID"), rs.getString("VEN_NAME"), rs.getString("VEN_PHN_NO"),
                    rs.getString("VEN_USERNAME"), rs.getString("VEN_EMAIL"), rs.getDouble("VEN_BALANCE"));
  }
}
