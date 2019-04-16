package com.hexaware.FTP112.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hexaware.FTP112.model.Wallet;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
/**
 * Test class for MenuDetails.
 */
public class WalletMapperTest {
 /**
 * Test class for MenuDetails.
 *@param resultSet to set resultSet.
 *@throws SQLException to throw exception.
 */
  @Test
  public final void testMap(@Mocked final ResultSet resultSet) throws SQLException {
    new Expectations() {
      {
        resultSet.getInt("wal_id"); result =  34;
        resultSet.getDouble("wal_amount"); result = 200.00;
        resultSet.getString("wal_source"); result = "PAYTM";
      }
        };
    WalletMapper walletMapper = new WalletMapper();
    Wallet wallet = walletMapper.map(34, resultSet, null);
    assertEquals(34, wallet.getWalletId());
    assertEquals(200.00, wallet.getWalletAmount(), 0);
    assertEquals("PAYTM", wallet.getWalletSource());

    new Verifications() { {
        resultSet.getInt("wal_id"); times = 1;
        resultSet.getDouble("wal_amount"); times = 1;
        resultSet.getString("wal_source"); times = 1;
        }
    };

  }
}
