package com.hexaware.FTP112.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.runner.RunWith;
import mockit.Expectations;
import org.junit.Test;
import mockit.Mock;
import mockit.Mocked;
import mockit.MockUp;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import com.hexaware.FTP112.persistence.WalletDAO;
import java.util.List;
import java.util.ArrayList;
import com.hexaware.FTP112.model.Wallet;

import static org.junit.Assert.fail;
 /**
 * Test class for show Wallet Factory.
 *@param dao to set dao.
 */
@RunWith(JMockit.class)
public class WalletFactoryTest {

 /**
 * Test class for update Wallet Amount Test.
 *@param dao to set dao.
 */
  @Test
  public final void updateWalletAmountTest(@Mocked final WalletDAO dao) {
    new Expectations() { {
        dao.walletAmount(200.20, 1, 1);
      } };
    new MockUp<WalletFactory>() {
        @Mock
        private WalletDAO dao() {
            return dao;
        }
    };
    WalletFactory.updateWalletAmount(200.20, 1, 1);
    new Verifications() { {
        dao.walletAmount(200.20, 1, 1); times = 1;
      }
    };
  }

/**
 * Test class for refund Amount Test.
 *@param dao to set dao.
 */
  @Test
  public final void refundAmountTest(@Mocked final WalletDAO dao) {
    new Expectations() { {
        dao.refundAmount(200.20, 1, 1);
      } };
    new MockUp<WalletFactory>() {
        @Mock
        private WalletDAO dao() {
            return dao;
        }
    };
    WalletFactory.refundAmount(200.20, 1, 1);
    new Verifications() { {
        dao.refundAmount(200.20, 1, 1); times = 1;
      }
    };
  }

 /**
 * Test class for find By Wallet Id Test.
 *@param dao to set dao.
 */
  @Test
  public final void findByWalletIdTest(@Mocked final WalletDAO dao) {
    new Expectations() { {
        dao.fetchWalletId(1, 1); result = 1;
      } };
    new MockUp<WalletFactory>() {
        @Mock
        private WalletDAO dao() {
            return dao;
        }
    };
    int wallId = WalletFactory.findByWalletId(1, 1);
    assertEquals(1, wallId);
    new Verifications() { {
        dao.fetchWalletId(1, 1); times = 1;
      }
    };
  }


 /**
 * Test class for show Wallet Test.
 *@param dao to set dao.
 */
  @Test
  public final void showWalletTest(@Mocked final WalletDAO dao) {
    List<Wallet> list1 = new ArrayList<Wallet>();
    Wallet wallet1 = new Wallet(1, 200.00, "paytm");
    Wallet wallet2 = new Wallet(2, 300.00, "paytm");
    Wallet wallet3 = new Wallet(3, 400.00, "paytm");
    list1.add(wallet1);
    list1.add(wallet2);
    list1.add(wallet3);

    new Expectations() { {
        List<Wallet> list2 = new ArrayList<Wallet>();
        Wallet w1 = new Wallet(1, 200.00, "paytm");
        Wallet w2 = new Wallet(2, 300.00, "paytm");
        Wallet w3 = new Wallet(3, 400.00, "paytm");
        list2.add(w1);
        list2.add(w2);
        list2.add(w3);
        dao.show(1); result = list2;
      } };
    new MockUp<WalletFactory>() {
        @Mock
        private WalletDAO dao() {
            return dao;
        }
    };
    List<Wallet> wallet = WalletFactory.showWallet(1);
    assertEquals(wallet, list1);
    assertEquals(wallet.size(), 3);
    new Verifications() { {
        dao.show(1); times = 1;
      }
    };
  }


  /**
 * Test class for get  Walle tBalance Invalid Data.
 *@param dao to set dao.
 */
  @Test
  public final void getWalletBalanceInvalidData(@Mocked final WalletDAO dao) {
    new MockUp<Validators>() {
        @Mock
         public final void validateWalletId(final int walletId, final int cusId) {
          throw new IllegalArgumentException("Invalid wallet Id Id");
        }
    };

    try {
      WalletFactory.getWalletBalance(1, 1);
      fail("Validation Failed");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid wallet Id Id");
    }
  }

 /**
 * Test class for get Wallet Balance Valid Data.
 *@param dao to set dao.
 */
  @Test
  public final void getWalletBalanceValidData(@Mocked final WalletDAO dao) {
    new MockUp<Validators>() {
      @Mock
         public final void validateWalletId(final int walletId, final int cusId) {
        } };
    new MockUp<WalletFactory>() {
        @Mock
         public final WalletDAO dao() {
        return dao;
        } };
    new Expectations() { {
        dao.getWalletAmount(5); result = 50.00;
      } };
    try {
      double value = WalletFactory.getWalletBalance(5, 1);
      assertEquals(50.00, value, 0);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
    new Verifications() { {
        dao.getWalletAmount(5); times = 1;
      } };
  }

/**
   * Test method for MenuFactoryConstructor.
   */
  @Test
   public final void testWalletFactoryConstructor() {
    assertNotNull(new WalletFactory());
  }

 /**
 * Test class for find By Wallet Id Test.
 *@param dao to set dao.
 */
  @Test
  public final void fetchtotalAmountTest(@Mocked final WalletDAO dao) {
    new Expectations() { {
        dao.fetchWalletTotalAmount(1); result = 1.00;
      } };
    new MockUp<WalletFactory>() {
        @Mock
        private WalletDAO dao() {
            return dao;
        }
    };
    double wallId = WalletFactory.fetchtotalAmount(1);
    assertEquals(1, wallId, 0);
    new Verifications() { {
        dao.fetchWalletTotalAmount(1); times = 1;
      }
    };
  }


}



