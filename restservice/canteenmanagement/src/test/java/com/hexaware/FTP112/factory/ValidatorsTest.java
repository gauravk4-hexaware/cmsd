package com.hexaware.FTP112.factory;

import org.junit.runner.RunWith;
import org.junit.Test;
import mockit.MockUp;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
*to test Menu Validatorsfactory class.
*/
@RunWith(JMockit.class)
public class ValidatorsTest {


/**
*to test validate Customer Test Valid method.
*/
  @Test
  public final void validateCustomerTestValidCount() {
    new MockUp<CustomerFactory>() {
        @Mock
        public final int findByCustomerId(final int cusId, final String password) {
        return 5;
        }
    };
    try {
      Validators.validateCustomer(10, "hello");
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }

/**
*to test validate Customer Test Validity method.
*/
  @Test
  public final void validateCustomerTestValidity() {
    new MockUp<CustomerFactory>() {
        @Mock
        public final int findByCusId(final int cusId) {
        return 5;
        }
    };
    try {
      Validators.validateCustomerById(10);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }


/**
*to test validate Invalid Customer method.
*/
  @Test
  public final void validateInvalidCustomer() {
    new MockUp<CustomerFactory>() {
        @Mock
        public final int findByCustomerId(final int cusId, final String password) {
        return 0;
        }
      };
    try {
      Validators.validateCustomer(10, "hello");
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid customer Id or password", e.getMessage());
    }
  }

/**
*to test validate Invalid Customer method.
*/
  @Test
  public final void validateInvalidCustomerId() {
    new MockUp<CustomerFactory>() {
        @Mock
        public final int findByCusId(final int cusId) {
        return 0;
        }
      };
    try {
      Validators.validateCustomerById(10);
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid customer Id", e.getMessage());
    }
  }

/**
*to test validate Vendor method.
*/
  @Test
  public final void validateVendorvalid() {
    new MockUp<VendorFactory>() {
        @Mock
        public final int findVendor(final int vendorId, final String vendorPassword) {
        return 5;
        }
    };
    try {
      Validators.validateVendor(10, "hello");
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }


/**
*to test validate Vendor Invalid method.
*/
  @Test
  public final void validateVendorInvalid() {
    new MockUp<VendorFactory>() {
        @Mock
        public final int findVendor(final int vendorId, final String vendorPassword) {
        return 0;
        }
      };
    try {
      Validators.validateVendor(10, "hello");
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid vendor credentials", e.getMessage());
    }
  }


/**
*to test validate Vendor method.
*/
  @Test
  public final void validateWalletIdValid() {
    new MockUp<WalletFactory>() {
        @Mock
        public final int findByWalletId(final int walletId, final int cusId) {
        return 5;
        }
    };
    try {
      Validators.validateWalletId(10, 10);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }


/**
*to test validate Vendor Invalid method.
*/
  @Test
  public final void validateWalletIdInvalid() {
    new MockUp<WalletFactory>() {
        @Mock
        public final int findByWalletId(final int walletId, final int cusId) {
        return 0;
        }
      };
    try {
      Validators.validateWalletId(10, 10);
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid wallet Id", e.getMessage());
    }
  }



/**
*to test validate Vendor method.
*/
  @Test
  public final void validateMenVenIdValid() {
    new MockUp<MenuFactory>() {
        @Mock
        public final int findByMenVenId(final int menId, final int venId) {
        return 5;
        }
    };
    try {
      Validators.validateMenVenId(10, 10);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }


/**
*to test validate Vendor Invalid method.
*/
  @Test
  public final void validateMenVenIdInValid() {
    new MockUp<MenuFactory>() {
        @Mock
        public final int findByMenVenId(final int menId, final int venId) {
        return 0;
        }
      };
    try {
      Validators.validateMenVenId(10, 10);
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid MenuId or VendorId", e.getMessage());
    }
  }


  /**
*to test validate Vendor method.
*/
  @Test
  public final void validateMenIdValid() {
    new MockUp<MenuFactory>() {
        @Mock
        public final int findByMenId(final int menId) {
        return 5;
        }
    };
    try {
      Validators.validateMenId(10);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }


/**
*to test validate Vendor Invalid method.
*/
  @Test
  public final void validateMenIdInValid() {
    new MockUp<MenuFactory>() {
        @Mock
        public final int findByMenId(final int menId) {
        return 0;
        }
      };
    try {
      Validators.validateMenId(10);
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid MenuId", e.getMessage());
    }
  }


  /**
*to test validate Vendor method.
*/
  @Test
  public final void validateOrderItemIdValid() {
    new MockUp<OrdersFactory>() {
        @Mock
        public final int findByOrderItemId(final int ordItemId) {
        return 5;
        }
    };
    try {
      Validators.validateOrderItemId(10);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }


/**
*to test validate Vendor Invalid method.
*/
  @Test
  public final void validateOrderItemIdInValid() {
    new MockUp<OrdersFactory>() {
        @Mock
        public final int findByOrderItemId(final int ordItemId) {
        return 0;
        }
      };
    try {
      Validators.validateOrderItemId(10);
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid orderitem Id", e.getMessage());
    }
  }
  /**
   * Test method for Validator Constructor.
   */
  @Test
   public final void testValidatorConstructor() {
    assertNotNull(new Validators());
  }
/**
*to test validate Vendor Id method and Order item Id.
*/
  @Test
  public final void validateVenOrdIdTestInvaliValue() {
    new MockUp<OrdersFactory>() {
        @Mock
        public final int findByOrderItemIdByVenId(final int orderItemId, final int vendorId) {
        return 0;
        }
      };
    try {
      Validators.validateVenOrdId(10, 20);
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid vendor Id or Order Id", e.getMessage());
    }
  }
  /**
*to test validate Vendor Id method.
*/
  @Test
  public final void validateVenOrdIdTestValiValue() {
    new MockUp<OrdersFactory>() {
        @Mock
        public final int findByOrderItemIdByVenId(final int ordItemId,  final int vendorId) {
        return 5;
        }
    };
    try {
      Validators.validateVenOrdId(10, 20);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }
/**
*to test validate Vendor Id method and Order item Id.
*/
  @Test
  public final void validateVenIdTestInvalidValue() {
    new MockUp<VendorFactory>() {
        @Mock
        public final int findVendorId(final int vendorId) {
        return 0;
        }
      };
    try {
      Validators.validateVendorId(10);
      fail("validation failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid vendor Id", e.getMessage());
    }
  }
  /**
*to test validate Vendor Id method.
*/
  @Test
  public final void validateVenIdTestValidValue() {
    new MockUp<VendorFactory>() {
        @Mock
        public final int findVendorId(final int vendorId) {
        return 5;
        }
    };
    try {
      Validators.validateVendorId(10);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
  }
}
