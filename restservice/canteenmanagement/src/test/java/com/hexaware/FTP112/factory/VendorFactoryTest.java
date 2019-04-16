package com.hexaware.FTP112.factory;
import com.hexaware.FTP112.persistence.VendorDAO;
import com.hexaware.FTP112.model.Vendor;

import org.junit.Test;


import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import mockit.MockUp;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;


  /**
   *test for VendorFactory.
   */
@RunWith(JMockit.class)
public class VendorFactoryTest {

/**
 *test for findVendor method.
 *@param dao is to mock vendor DAO.
 */
  @Test
    public final void findVendorTest(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
            public VendorDAO dao() {
            return dao;
        }
        };
    new Expectations() { {
        dao.authenticateVendor(55, "hello"); result = 50;
        }
        };

    int authentication = VendorFactory.findVendor(55, "hello");
    assertEquals(authentication, 50);

    new Verifications()  { {
            dao.authenticateVendor(55, "hello"); times = 1;

        }
    };
  }


/**
 *Testing invalidity for authenticateVendor method .
 */
  @Test
    public final void authenticateVendorWithInvalidData() {
    new MockUp<Validators>() {
      @Mock
        public void validateVendor(final int vendorId, final String vendorPassword) {
        throw new IllegalArgumentException("Invalid Vendor Id or Vendor Password");
      }
      };
    try {
      VendorFactory.authenticateVendor(55, "hello");
      fail("Validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals(e.getMessage(), "Invalid Vendor Id or Vendor Password");
    }
  }
/**
 *Testing validity for authenticateVendor method .
 */

  @Test
    public final void authenticateVendorWithValidData() {
    new MockUp<Validators>() {
      @Mock
            public void validateVendor(final int vendorId, final String vendorPassword) { }
        };
    try {
      VendorFactory.authenticateVendor(22, "hai");
    } catch (IllegalArgumentException e) {
      fail("Validation failed");
    }
  }

/**
 *test for VendorBalance method.
 *@param dao is to mock vendor DAO.
 */

  @Test
    public final void getVendorBalanceTest(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
            public VendorDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
        dao.vendorBalance(55); result = 5000.00;
        }
        };

    double vendorBalance = VendorFactory.getVendorBalance(55);
    assertEquals(vendorBalance, 5000.00, 0);

    new Verifications() { {
        dao.vendorBalance(55); times = 1;

        }
    };
  }


/**
 *test for updateVendorWallet method.
 *@param dao is to mock vendor DAO.
 */

  @Test
    public final void updateVendorWalletTest(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
            public VendorDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
        dao.vendorWallet(500.00, 55);
        }
    };
    VendorFactory.updateVendorWallet(500.00, 55);
    new Verifications() { {
        dao.vendorWallet(500.00, 55); times = 1;

        }
    };
  }

/**
 *test for updateRefund method.
 *@param dao is to mock vendor DAO.
 */

  @Test
    public final void updateRefundTest(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
            public VendorDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
        dao.refund(200.00, 55);
        }
        };
    VendorFactory.updateRefund(200.00, 55);
    new Verifications() { {
        dao.refund(200.00, 55); times = 1;

        }
    };
  }

/**
 *test for showVendor method.
 *@param dao is to mock vendor DAO.
 */


  @Test
    public final void showVendorTest(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
            public VendorDAO dao() {
        return dao;
        }
        };
    List<Vendor> a = new ArrayList<Vendor>();
    Vendor v1 = new Vendor(1, "PRIYA", "9876543210", "PRIYA@10", "jennifa@gmail.com", 360.00);
    Vendor v2 = new Vendor(2, "ANU", "9976743310", "Anu@22", "jennifa@gmail.com", 360.00);
    Vendor v3 = new Vendor(3, "AISHU", "9877653210", "AISHU@08", "jennifa@gmail.com", 360.00);
    Vendor v4 = new Vendor(4, "SHREE", "9123498210", "SHREE@33", "jennifa@gmail.com", 360.00);
    a.add(v1);
    a.add(v2);
    a.add(v3);
    a.add(v4);

    new Expectations() { {
          List<Vendor> a = new ArrayList<Vendor>();
          Vendor v1 = new Vendor(1, "PRIYA", "9876543210", "PRIYA@10", "jennifa@gmail.com", 360.00);
          Vendor v2 = new Vendor(2, "ANU", "9976743310", "Anu@22", "jennifa@gmail.com", 360.00);
          Vendor v3 = new Vendor(3, "AISHU", "9877653210", "AISHU@08", "jennifa@gmail.com", 360.00);
          Vendor v4 = new Vendor(4, "SHREE", "9123498210", "SHREE@33", "jennifa@gmail.com", 360.00);
          a.add(v1);
          a.add(v2);
          a.add(v3);
          a.add(v4);
          dao.show(1); result = a;
          }
    };
    List<Vendor> vendor = VendorFactory.showVendor(1);
    assertEquals(vendor, a);
    assertEquals(vendor.size(), 4);

    new Verifications() { {
          dao.show(1); times = 1;
        }
    };
  }
/**
  * Tests the empty constructor of the Orders class.
  */
  @Test
   public final void testEmptyConstructor() {
    assertNotNull(new VendorFactory());
  }
/**
 *test for updateRefund method.
 *@param dao is to mock vendor DAO.
 */
  @Test
    public final void findVendorIdTest(@Mocked final VendorDAO dao) {
    new MockUp<VendorFactory>() {
      @Mock
            public VendorDAO dao() {
        return dao;
      }
        };
    new Expectations() { {
        dao.authenticateVendorId(200); result = 10;
        }
        };
    int count = VendorFactory.findVendorId(200);
    assertEquals(count, 10);
    new Verifications() { {
        dao.authenticateVendorId(200); times = 1;

        }
    };
  }
}
