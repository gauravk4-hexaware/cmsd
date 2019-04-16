package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP112.model.Customer;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;

  /**
    *to test mapper class.
    */
public class CustomerMapperTest {
  /**
    *@param resultSet to set resultSet.
    *@throws SQLException to throw exception.
    *to test Mapper Method.
    */
  @Test
   public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {

    new Expectations() {
      {
        resultSet.getInt("CUS_ID"); result =  34;
        resultSet.getString("CUS_NAME"); result = "vinay";
        resultSet.getString("CUS_PHN_NO"); result = "12345";
        resultSet.getString("CUS_USERNAME"); result = "vinay22";
        resultSet.getString("CUS_EMAIL"); result = "vinay@gmail.com";
      }
        };
    CustomerMapper customerMapper = new CustomerMapper();
    Customer customer = customerMapper.map(34, resultSet, null);

    assertEquals(34, customer.getCusId());
    assertEquals("vinay", customer.getCusName());
    assertEquals("12345", customer.getCusPhoneNo());
    assertEquals("vinay22", customer.getCusUserName());
    assertEquals("vinay@gmail.com", customer.getCusEmail());

    new Verifications() { {
        resultSet.getInt("CUS_ID"); times = 1;
        resultSet.getString("CUS_NAME"); times = 1;
        resultSet.getString("CUS_PHN_NO"); times = 1;
        } };
  }
}
