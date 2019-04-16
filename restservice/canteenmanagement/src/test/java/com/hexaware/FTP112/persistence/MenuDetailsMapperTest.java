package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP112.model.MenuDetails;
import mockit.Mocked;
import mockit.Expectations;
import mockit.Verifications;

  /**
    *to test mapper class.
    */
public class MenuDetailsMapperTest {
  /**
    *@param resultSet to set resultSet.
    *@throws SQLException to throw exception.
    *to test Mapper Method.
    */
  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
      {
        resultSet.getInt("VEN_ID"); result = 1;
        resultSet.getInt("JUN_RATING"); result = 3;
        resultSet.getString("JUN_REVIEWS"); result = "good";
        resultSet.getDouble("JUN_PRICE"); result = 250.00;
        resultSet.getString("VEN_NAME"); result = "jennifa";
        resultSet.getString("VEN_PHN_NO"); result = "8971736796";
      }
      };
    MenuDetailsMapper menuDetailsMapper = new MenuDetailsMapper();
    MenuDetails menuDetails = menuDetailsMapper.map(22, resultSet, null);

    assertEquals(1, menuDetails.getVenId());
    assertEquals(3, menuDetails.getRatings());
    assertEquals("good", menuDetails.getReviews());
    assertEquals(250.00, menuDetails.getMenPrice(), 0);
    assertEquals("jennifa", menuDetails.getVenName());
    assertEquals("8971736796", menuDetails.getVenPhnNo());

    new Verifications() { {
        resultSet.getInt("VEN_ID"); times = 1;
        resultSet.getInt("JUN_RATING"); times = 1;
        resultSet.getString("JUN_REVIEWS"); times = 1;
        resultSet.getDouble("JUN_PRICE"); times = 1;
        resultSet.getString("VEN_NAME"); times = 1;
        resultSet.getString("VEN_PHN_NO"); times = 1;
      } };
  }
}
