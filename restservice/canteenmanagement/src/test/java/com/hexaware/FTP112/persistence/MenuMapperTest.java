package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP112.model.Menu;
import mockit.Mocked;
import mockit.Expectations;
import mockit.Verifications;

 /**
  Testing for menumapper.
  */
public class MenuMapperTest {
  /**
  Testing for expectatins and verifications.
  @param resultSet is to call result set.
  @throws SQLException is throws the sql exceptions.
  */
  @Test
    public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
        {
          resultSet.getInt("MEN_ID"); result = 10;
          resultSet.getString("men_item"); result = "Fish briyani";
          resultSet.getDouble("men_calories"); result = 500.00;
          resultSet.getInt("ven_id"); result = 1;
          resultSet.getInt("jun_rating"); result = 9;
          resultSet.getString("jun_reviews"); result = "tasty";
          resultSet.getDouble("jun_price"); result = 300.00;
        }
    };
    MenuMapper menuMapper = new MenuMapper();
    Menu menu = menuMapper.map(10, resultSet, null);
   /*Menu menu = menuMapper.map("Fish briyani", resultSet, null);
    Menu menu = menuMapper.map(500, resultSet, null);
    Menu menu = menuMapper.map(1, resultSet, null);
    Menu menu = menuMapper.map(9, resultSet, null);
    Menu menu = menuMapper.map("tasty", resultSet, null);
    Menu menu = menuMapper.map(300, resultSet, null);*/

    assertEquals(10, menu.getMenId());
    assertEquals("Fish briyani", menu.getMenItem());
    assertEquals(500.00, menu.getMenCalories(), 0);
    assertEquals(1, menu.getVenId());
    assertEquals(9, menu.getRatings());
    assertEquals("tasty", menu.getReviews());
    assertEquals(300.00, menu.getMenPrice(), 0);

    new Verifications() { {
            resultSet.getInt("MEN_ID"); times = 1;
            resultSet.getString("men_item"); times = 1;
            resultSet.getDouble("men_calories"); times = 1;
            resultSet.getInt("ven_id"); times = 1;
            resultSet.getInt("jun_rating"); times = 1;
            resultSet.getString("jun_reviews"); times = 1;
            resultSet.getDouble("jun_price"); times = 1;

        } };

  }
}



