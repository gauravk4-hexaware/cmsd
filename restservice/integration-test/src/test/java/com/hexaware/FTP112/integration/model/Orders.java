package com.hexaware.FTP112.integration.model;


import java.util.Objects;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hexaware.FTP112.integration.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Orders class used to display Orders information.
 * @author hexaware.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Orders {
/**
 * orders to store order.
 */
  private int orderId;
  private int cusId;
  private int venId;
  private double totalOrderPrice;
  private OrderStatus orderStatus;
  private String orderComments;
  private String cusName;
  private String walletSource;
  private String venName;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private Date orderDate;
  //private List<OrderItems> orderItems;
  private int walId;
  /**
   * Default Constructor.
   */
  public Orders() {

  }
    /**
   * @param argCusId to initialize customer Id.
   * @param argVenId to initialize vendor Id.
   * @param argTotalOrderPrice to initialize Total Order Price.
   * @param argWalId to initialize Wallet Id.
   * used to get details through constructor.
   */
  public Orders(final int argCusId, final int argVenId, final double argTotalOrderPrice, final int argWalId) {
    this.cusId = argCusId;
    this.venId = argVenId;
    this.totalOrderPrice = argTotalOrderPrice;
    this.walId = argWalId;
  }

  /**
   * @param argCusId gets the customer Id.
   */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
  /**
     * @return this customer Id.
     */
  public final int getCusId() {
    return this.cusId;
  }
      /**
     * @param argVenId gets the vendor Id.
     */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
 /**
     * @return this vendor Id.
     */
  public final int getVenId() {
    return this.venId;
  }
      /**
     * @param argTotalOrderPrice gets the order Price.
     */
  public final void setOrderPrice(final double argTotalOrderPrice) {
    this.totalOrderPrice = argTotalOrderPrice;
  }
 /**
     * @return this order price.
     */
  public final double getTotalOrderPrice() {
    return this.totalOrderPrice;
  }
    /**
     * @param argOrderStatus gets the order comments.
     */
  public final void setOrderStatus(final OrderStatus argOrderStatus) {
    this.orderStatus = argOrderStatus;
  }
    /**
       * @return this order Comments.
       */
  public final OrderStatus getOrderStatus() {
    return this.orderStatus;
  }
/**
  * @param argOrderDate gets the order date.
  */
  public final void setOrderDate(final Date argOrderDate) {
    this.orderDate = argOrderDate;
  }
/**
  * @return this order Date.
  */
  public final Date getOrderDate() {
    return this.orderDate;
  }
/**
  * @param argOrderId gets the order Id.
  */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }
/**
  * @return this order Id.
  */
  public final int getOrderId() {
    return this.orderId;
  }
/**
  * @param argOrderComments gets the order comments.
  */
  public final void setOrderComments(final String argOrderComments) {
    this.orderComments = argOrderComments;
  }
/**
  * @return this order Comments.
  */
  public final String getOrderComments() {
    return this.orderComments;
  }
/**
 * @param argWalId gets the wallet id.
 */
  public final void setWalId(final int argWalId) {
    this.walId = argWalId;
  }
/**
 * @return this order Comments.
 */
  public final int getWalId() {
    return this.walId;
  }
/**
  * @param argWalletSource gets the walletSource.
  */
  public final void setWalletSource(final String argWalletSource) {
    this.walletSource = argWalletSource;
  }
/**
  * @return this walletSource.
  */
  public final String getWalletSource() {
    return this.walletSource;
  }

/**
  * @param argCusName gets the cusName.
  */
  public final void setCusName(final String argCusName) {
    this.cusName = argCusName;
  }
/**
  * @return this cusName.
  */
  public final String getCusName() {
    return this.cusName;
  }
/**
  * @param argVenName gets the cusName.
  */
  public final void setVenName(final String argVenName) {
    this.venName = argVenName;
  }
/**
  * @return this cusName.
  */
  public final String getVenName() {
    return this.venName;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders orders = (Orders) obj;
    if (Objects.equals(cusId, orders.getCusId())
        && Objects.equals(venId, orders.getVenId())
        && Objects.equals(totalOrderPrice, orders.getTotalOrderPrice())
        && Objects.equals(orderStatus, orders.getOrderStatus())
        && Objects.equals(orderComments, orders.getOrderComments())
        && Objects.equals(walId, orders.getWalId())
       /* && Objects.equals(orderItems, orders.getOrderItems())*/) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, venId, totalOrderPrice, orderStatus, orderComments, walId /*, orderItems*/);
  }

}
