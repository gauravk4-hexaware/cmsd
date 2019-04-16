package com.hexaware.FTP112.factory;

import mockit.integration.junit4.JMockit;
import com.hexaware.FTP112.model.Customer;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.runner.RunWith;
import static org.junit.Assert.fail;
import mockit.MockUp;
import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import com.hexaware.FTP112.persistence.CustomerDAO;
import mockit.Verifications;
  /**
   Test class for customerfactory.
   */
@RunWith(JMockit.class)
public class CustomerFactoryTest {
  /**
   Test class for validators with valid data.
   */
  @Test
    public final void authenticateCustomerWithInvalidData() {

    new MockUp<Validators>() {
      @Mock
            public final void validateCustomer(final int cusId, final String password) {
        throw new IllegalArgumentException("Invalid CusId or Password");
      } };
    try {
      CustomerFactory.authenticateCustomer(20, "divi");
      fail("Validator failed");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals(e.getMessage(), "Invalid CusId or Password");
    }
  }
  /**
   Test class for validators with invalid data.
   */
  @Test
    public final void authenticateCustomerWithValidData() {

    new MockUp<Validators>() {
      @Mock
            public void validateCustomer(final int cusId, final String password) {
      }
        };
    new Expectations() { {
            Validators.validateCustomer(20, "divi");
        }
        };
    try {
      CustomerFactory.authenticateCustomer(20, "divi");
    } catch (IllegalArgumentException e) {
      fail("Validator failed");
    }
  }
  /**
   Test class for findByCustomerId.
   * @param dao to initialize wallet amount.
   */
  @Test
    public final void findByCustomerId(@Mocked final CustomerDAO dao) {
    new MockUp<CustomerFactory>() {
        @Mock
        public CustomerDAO dao() {
            return dao;
        }
    };
    new Expectations() { {
            dao.fetchCustomerId(20, "divi"); result = 10;
      }
    };
    int count = CustomerFactory.findByCustomerId(20, "divi");
    assertEquals(count, 10);
    new Verifications() { {
        dao.fetchCustomerId(20, "divi"); times = 1;
      }
    };
  }
  /**
   Test class for findByCustomerId.
   * @param dao to initialize wallet amount.
   */
  @Test
    public final void findByCusId(@Mocked final CustomerDAO dao) {
    new MockUp<CustomerFactory>() {
        @Mock
        public CustomerDAO dao() {
            return dao;
        }
    };
    new Expectations() { {
            dao.fetchCusId(20); result = 10;
      }
    };
    int count = CustomerFactory.findByCusId(20);
    assertEquals(count, 10);
    new Verifications() { {
        dao.fetchCusId(20); times = 1;
      }
    };
  }
  /**
   Test class for testshowCustomer.
   * @param dao to initialize wallet amount.
   */
  @Test
    public final void testshowCustomer(@Mocked final CustomerDAO dao) {
    new MockUp<CustomerFactory>() {
      @Mock
            public CustomerDAO dao() {
        return dao;
      }
        };
    List<Customer> list1 = new ArrayList();
    list1.add(new Customer(1, "divi", "banu", "prathi", "jennifa@gmail.com"));
    list1.add(new Customer(2, "gaurav", "kumar", "thakur", "jennifa@gmail.com"));
    new Expectations() { {
        List<Customer> list2 = new ArrayList();
        list2.add(new Customer(1, "divi", "banu", "prathi", "jennifa@gmail.com"));
        list2.add(new Customer(2, "gaurav", "kumar", "thakur", "jennifa@gmail.com"));
        dao.show(20); result = list2;
      } };
    List<Customer> customer = CustomerFactory.showCustomer(20);
    assertEquals(customer, list1);
    new Verifications() { {
        dao.show(20); times = 1;
      } };
  }
      /**
 * Test method for customerfactory.
 */
  @Test
  public final void testCustomerFactoryConstuctor() {
    assertNotNull(new CustomerFactory());
  }


}
