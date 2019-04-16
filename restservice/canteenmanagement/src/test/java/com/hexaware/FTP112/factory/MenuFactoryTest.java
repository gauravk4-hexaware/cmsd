package com.hexaware.FTP112.factory;

import org.junit.runner.RunWith;
import org.junit.Test;
import mockit.MockUp;
import mockit.Mock;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import mockit.Expectations;
import mockit.Verifications;
import com.hexaware.FTP112.persistence.MenuDAO;
import com.hexaware.FTP112.model.Menu;
import java.util.List;
import java.util.ArrayList;


  /**
    *to test Menu Factory class.
    */
@RunWith(JMockit.class)
public class MenuFactoryTest {
  /**
    *to test findByMenu method with invalid data.
    */
  @Test
   public final void findByMenuIdWithInvalidData() {
    new MockUp<Validators>() {
        @Mock
         public final void validateMenId(final int menId) {
          throw new IllegalArgumentException("Invalid Menu Id");
        }
    };

    try {
      MenuFactory.findByMenuId(12);
      fail("Validation Failed");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid Menu Id");
    }
  }
  /**
    *to test findByMenu method with valid data.
    */
  @Test
   public final void findByMenuIdWithValidData() {
    new MockUp<Validators>() {
        @Mock
         public final void validateMenId(final int menId) {
        }
    };

    try {
      MenuFactory.findByMenuId(12);
    } catch (IllegalArgumentException e) {
      fail("Validation Failed");
    }
  }
  /**
    *to test findByMenu Id method.
    *@param dao to mock dao.
    */
  @Test
   public final void findbyMenId(@Mocked final MenuDAO dao) {
    new MockUp<MenuFactory>() {
        @Mock
         public final MenuDAO dao() {
        return dao;
      } };
    new Expectations() { {
        dao.fetchMenId(1); result = 50;
      } };
    int menId = MenuFactory.findByMenId(1);
    assertEquals(50, menId);

    new Verifications() { {
        dao.fetchMenId(1); times = 1;
      } };
  }
  /**
    *to test findbyMenVenId method.
    *@param dao to mock dao.
    */
  @Test
   public final void findByMenVenId(@Mocked final MenuDAO dao) {
    new MockUp<MenuFactory>() {
        @Mock
         public final MenuDAO dao() {
        return dao;
      } };
    new Expectations() { {
        dao.fetchMenVenId(1, 1); result = 50;
      } };
    int menId = MenuFactory.findByMenVenId(1, 1);
    assertEquals(50, menId);

    new Verifications() { {
        dao.fetchMenVenId(1, 1); times = 1;
      } };
  }
  /**
    *to test getOrderPrice method with invalid data.
    */
  @Test
   public final void getOrderPriceWithInvalidData() {
    new MockUp<Validators>() {
        @Mock
         public final void validateMenVenId(final int menId, final int venId) {
          throw new IllegalArgumentException("Invalid Menu Id or Vendor id");
        }
    };

    try {
      MenuFactory.getOrderPrice(50, 50);
      fail("Validation Failed");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid Menu Id or Vendor id");
    }
  }
  /**
    *to test getOrderPrice method with invalid data.
    *@param dao to mock dao.
    */
  @Test
   public final void getOrderPriceWithValidData(@Mocked final MenuDAO dao) {
    new MockUp<Validators>() {
        @Mock
         public final void validateMenVenId(final int menId, final int venId) {
        } };
    new MockUp<MenuFactory>() {
        @Mock
         public final MenuDAO dao() {
        return dao;
        } };
    new Expectations() { {
        dao.fetchOrderPrice(50, 50); result = 50.00;
      } };
    try {
      double value = MenuFactory.getOrderPrice(50, 50);
      assertEquals(50.00, value, 0);
    } catch (IllegalArgumentException e) {
      fail("validation failed");
    }
    new Verifications() { {
        dao.fetchOrderPrice(50, 50); times = 1;
      } };
  }
  /**
    *to test showMenu method.
    *@param dao to mock dao.
    */
  @Test
   public final void showMenu(@Mocked final MenuDAO dao) {
    new MockUp<MenuFactory>() {
        @Mock
         public final MenuDAO dao() {
        return dao;
      } };
    List<Menu> menu = new ArrayList<Menu>();
    Menu a = new Menu(1, "aman", 50.00, 1, 5, "nice", 50.00);
    Menu b = new Menu(2, "pavbhaji", 100.00, 3, 4, "good", 40.00);
    Menu c = new Menu(3, "tikki", 120.00, 5, 5, "tasty", 30.00);
    menu.add(a);
    menu.add(b);
    menu.add(c);
    new Expectations() { {
        List<Menu> menu = new ArrayList<Menu>();
        Menu a = new Menu(1, "aman", 50.00, 1, 5, "nice", 50.00);
        Menu b = new Menu(2, "pavbhaji", 100.00, 3, 4, "good", 40.00);
        Menu c = new Menu(3, "tikki", 120.00, 5, 5, "tasty", 30.00);
        menu.add(a);
        menu.add(b);
        menu.add(c);
        dao.show(); result = menu.toArray(new Menu[menu.size()]);
      } };
    List<Menu> list = MenuFactory.showMenu();
    assertEquals(menu.size(), 3);

    new Verifications() { {
        dao.show(); times = 1;
      } };
  }
  /**
    *to test showMenu method.
    *@param dao to mock dao.
    */
  @Test
   public final void showVendorName(@Mocked final MenuDAO dao) {
    new MockUp<MenuFactory>() {
        @Mock
         public final MenuDAO dao() {
        return dao;
      } };
    List<Menu> menu = new ArrayList<Menu>();
    Menu a = new Menu(1, "aman", 50.00, 1, 5, "nice", 50.00);
    Menu b = new Menu(2, "pavbhaji", 100.00, 3, 4, "good", 40.00);
    Menu c = new Menu(3, "tikki", 120.00, 5, 5, "tasty", 30.00);
    menu.add(a);
    menu.add(b);
    menu.add(c);
    new Expectations() { {
        List<Menu> menu = new ArrayList<Menu>();
        Menu a = new Menu(1, "aman", 50.00, 1, 5, "nice", 50.00);
        Menu b = new Menu(2, "pavbhaji", 100.00, 3, 4, "good", 40.00);
        Menu c = new Menu(3, "tikki", 120.00, 5, 5, "tasty", 30.00);
        menu.add(a);
        menu.add(b);
        menu.add(c);
        dao.showVendorName(3); result = menu.toArray(new Menu[menu.size()]);
      } };
    List<Menu> list = MenuFactory.showVendorName(3);
    assertEquals(menu.size(), 3);

    new Verifications() { {
        dao.showVendorName(3); times = 1;
      } };
  }
  /**
   * Test method for MenuFactoryConstructor.
   */
  @Test
   public final void testMenuFactoryConstructor() {
    assertNotNull(new MenuFactory());
  }
}
