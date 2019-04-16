package com.hexaware.FTP112.factory;

import com.hexaware.FTP112.persistence.MenuDAO;
import com.hexaware.FTP112.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP112.model.Menu;
//import com.hexaware.FTP112.model.MenuDetails;



/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
    /**
   * Call the data base connection.
   * @return the array of vendor object.
   * @param menId to initialize menu Id.
   */
  public static List<Menu> showVendorName(final int menId) {
    List<Menu> vendor = dao().showVendorName(menId);
    return vendor;
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static List<Menu> showMenu() {
    List<Menu> menu = dao().show();
    return menu;
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static List<Menu> showMenuAdd() {
    List<Menu> menu = dao().showadd();
    return menu;
  }
  /**
   * Call the data base connection.
   * @param menId to initialize menu Id.
   * @param venId to initialize vendor Id.
   * @return the order price .
   */
  public static double getOrderPrice(final int menId, final int venId) {
    Validators.validateMenVenId(menId, venId);
    double orderPrice = dao().fetchOrderPrice(menId, venId);
    return orderPrice;
  }

  /**
   * Call the data base connection.
   * @param menId to initialize menu Id.
   * @param venId to initialize vendor Id.
   * @param price to initialize price.
   */
  public static void updateJunction(final int menId, final int venId, final double price) {
    dao().updateJunction(menId, venId, price);
  }
  /**
   * Call the data base connection.
   * @param menId to initialize menu Id.
   * @param venId to initialize vendor Id.
   */
  public static void deleteVenMen(final int menId, final int venId) {
    dao().deleteVenMen(menId, venId);
  }
  /**
   * Call the data base connection.
   * @param menId to initialize menu Id.
   * @param venId to initialize vendor Id.
   * @return the customerId.
   */
  public static int findByMenVenId(final int menId, final int venId) {
    int id = dao().fetchMenVenId(menId, venId);
    return id;
  }
  /**
   * Call the data base connection.
   * @param menId to initialize menu Id.
   */

  public static void findByMenuId(final int menId) {
    Validators.validateMenId(menId);
  }
    /**
   * Call the data base connection.
   * @return the order price.
   * @param menId to initialize menu Id.
   */
  public static int findByMenId(final int menId) {
    int id = dao().fetchMenId(menId);
    return id;
  }
}
