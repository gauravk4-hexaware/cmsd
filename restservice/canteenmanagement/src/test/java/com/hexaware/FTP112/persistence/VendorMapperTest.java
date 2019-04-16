package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP112.model.Vendor;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;

  /**
    *to test mapper class.
    */
public class VendorMapperTest {
  /**
    *@param resultSet to set resultSet.
    *@throws SQLException to throw exception.
    *to test Mapper Method.
    */
  @Test
   public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
      {
        resultSet.getInt("VEN_ID"); result =  34;
        resultSet.getString("VEN_NAME"); result = "vinay";
        resultSet.getString("VEN_PHN_NO"); result = "12345";
        resultSet.getString("VEN_USERNAME"); result = "rocky";
        resultSet.getDouble("VEN_BALANCE"); result = 5000.00;
        resultSet.getString("VEN_EMAIL"); result = "jennifa@gmail.com";
      }
        };
    VendorMapper vendorMapper = new VendorMapper();
    Vendor vendor = vendorMapper.map(34, resultSet, null);

    assertEquals(34, vendor.getVenId());
    assertEquals("vinay", vendor.getVenName());
    assertEquals("12345", vendor.getVenPhoneNo());
    assertEquals("rocky", vendor.getVenUsername());
    assertEquals(5000.00, vendor.getVenBalance(), 0);
    assertEquals("jennifa@gmail.com", vendor.getVenEmail());

    new Verifications() { {
        resultSet.getInt("VEN_ID"); times = 1;
        resultSet.getString("VEN_NAME"); times = 1;
        resultSet.getString("VEN_PHN_NO"); times = 1;
        resultSet.getString("VEN_USERNAME"); times = 1;
        resultSet.getDouble("VEN_BALANCE"); times = 1;
        } };
  }
}
