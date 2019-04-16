package com.hexaware.FTP112.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * OrderItems class used to display Order items.
 * @author hexaware
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItems {
  private int orderItemId;
  private int menId;
  private String menItem;
  private double price;
  private OrderStatus status;
  private int quantity;
  private int orderId;

  /**
 * @param argMenId to initialize menu id.
 * @param argPrice to initialize menu price.
 * @param argQuantity to initialize quantity.
 * @param argorderId to initialize order Id .
 */
  public OrderItems(final int argMenId, final double argPrice, final int argQuantity, final int argorderId) {
    this.menId = argMenId;
    this.price = argPrice;
    this.quantity = argQuantity;
    this.orderId = argorderId;
  }
  /**
 * @param argOrderItemId to initialize order item id.
 * @param argMenId to initialize menu item.
 * @param argPrice to initialize menu price.
 * @param argStatus to initialize status.
 * @param argQuantity to initialize quantity.
 * @param argOrderId to initialize order Id.
 * used to get details through constructor.
 */
  public OrderItems(final int argOrderItemId, final int argMenId,
      final double argPrice, final OrderStatus argStatus, final int argQuantity, final int argOrderId) {
    this.orderItemId = argOrderItemId;
    this.menId = argMenId;
    this.price = argPrice;
    this.status = argStatus;
    this.quantity = argQuantity;
    this.orderId = argOrderId;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    OrderItems orderItems = (OrderItems) obj;
    if (Objects.equals(orderItemId, orderItems.getOrderItemId())
            && Objects.equals(menId, orderItems.getMenId())
            && Objects.equals(price, orderItems.getPrice())
            && Objects.equals(status, orderItems.getStatus())
            && Objects.equals(quantity, orderItems.getQuantity())
            && Objects.equals(orderId, orderItems.getOrderId())) {
      return true;
    }
    return false;
  }

  @Override
    public final int hashCode() {
    return Objects.hash(orderItemId, menId, price, status, quantity, orderId);
  }

    /**
    *@return order item Id.
    */
  public final int getOrderItemId() {
    return orderItemId;
  }
    /**
    *@return menu Id.
    */
  public final int getMenId() {
    return menId;
  }
    /**
    *@return price.
    */
  public final double getPrice() {
    return price;
  }
    /**
    *@return status.
    */
  public final OrderStatus getStatus() {
    return this.status;
  }
    /**
    *@return quantity.
    */
  public final int getQuantity() {
    return quantity;
  }
    /**
    *@return order Id.
    */
  public final int getOrderId() {
    return orderId;
  }
    /**
    *@return MenItem.
    */
  public final String getMenItem() {
    return menItem;
  }
   /**
     * @param argMenId gets the Menu id.
     */
  public final void setMenId(final int argMenId) {
    this.menId = argMenId;
  }
   /**
     * @param argMenItem gets the Menu Item.
     */
  public final void setMenItem(final String argMenItem) {
    this.menItem = argMenItem;
  }
   /**
     * @param argOrderItemId gets the order item Id.
     */
  public final void setOrderItemId(final int argOrderItemId) {
    this.orderItemId = argOrderItemId;
  }
   /**
     * @param argPrice gets the price.
     */
  public final void setPrice(final double argPrice) {
    this.price = argPrice;
  }
   /**
     * @param argStatus gets the status.
     */
  public final void setStatus(final OrderStatus argStatus) {
    this.status = argStatus;
  }
   /**
     * @param argQty gets the quantity.
     */
  public final void setQuantity(final int argQty) {
    this.quantity = argQty;
  }
   /**
     * @param argOrderId gets the order Id.
     */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }

}
