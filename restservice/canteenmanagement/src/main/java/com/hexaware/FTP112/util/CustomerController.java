package com.hexaware.FTP112.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;



import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP112.model.Customer;
import com.hexaware.FTP112.model.Menu;
import com.hexaware.FTP112.factory.CustomerFactory;
import com.hexaware.FTP112.factory.VendorFactory;
import com.hexaware.FTP112.factory.OrdersFactory;
import com.hexaware.FTP112.factory.MenuFactory;
import com.hexaware.FTP112.factory.WalletFactory;
import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.model.Wallet;
import com.hexaware.FTP112.model.OrderItems;
import com.hexaware.FTP112.factory.Validators;
import javax.ws.rs.core.Response;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/customer")
public class CustomerController {
  /**
   * Returns Customer details.
   * @param cusId for customer.
   * @return the Customer details.
   */
  @GET
  @Path("/{cusId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Customer> listCustomer(@PathParam("cusId") final int cusId) {
    Validators.validateCustomerById(cusId);
    return CustomerFactory.showCustomer(cusId);
  }
  /**
   * Returns Customer details.
   * @param cusId for customer.
   * @return the Customer details.
   */
  @GET
  @Path("/{cusId}/orders")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Orders> listCustomers(@PathParam("cusId") final int cusId) {
    Validators.validateCustomerById(cusId);
    return OrdersFactory.showCustomerHistory(cusId);
  }
  /**
   * Returns Customer details.
   * @param cusId for customer.
   * @return the wallet details.
   */
  @GET
  @Path("/{cusId}/wallet")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Wallet> listWallet(@PathParam("cusId") final int cusId) {
    return WalletFactory.showWallet(cusId);
  }
  /**
   * Returns Customer details.
   * @param  order for customer.
   * @param  menId for customer.
   * @param  qty for customer.
   * @return the orders.
   */
  @POST
  @Path("/{menid}/orders/{qty}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response placeOrder(final Orders order, @PathParam("menid") final int menId, @PathParam("qty") final int qty) {
    Validators.validateMenId(menId);
    Validators.validateCustomerById(order.getCusId());
    Validators.validateMenVenId(menId, order.getVenId());
    Validators.validateWalletId(order.getWalId(), order.getCusId());
    double orderPrice = MenuFactory.getOrderPrice(menId, order.getVenId());
    order.setOrderPrice(orderPrice * qty);
    double totalOrderPrice = order.getTotalOrderPrice();
    int orderId = OrdersFactory.setPlaceOrder(order);
    OrderItems orderItem = new OrderItems(menId, orderPrice, qty, orderId);
    OrdersFactory.updateOrderItems(orderItem);
    double walAmount = WalletFactory.getWalletBalance(order.getWalId(),  order.getCusId());
    WalletFactory.updateWalletAmount(walAmount - totalOrderPrice,  order.getCusId(), order.getWalId());
    double vendorWalletAmount = VendorFactory.getVendorBalance(order.getVenId());
    VendorFactory.updateVendorWallet(vendorWalletAmount + totalOrderPrice,  order.getVenId());
    Orders orders = OrdersFactory.getOrders(orderId);
    return Response.ok().entity(orders).build();
  }
 /**
   * @return response.
   * @param  customer for customer.
   */
  @POST
  @Path("/auth")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response customerLogin(final Customer customer) {
    int cusId = customer.getCusId();
    String cusPassword = customer.getCusPassword();
    Validators.validateCustomer(cusId, cusPassword);
    return Response.status(Response.Status.OK).build();
  }
  /**
   * Returns Customer details.
   * @param menId for customer.
   * @return the vendor details.
   */
  @GET
  @Path("/venName/{menId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response vendor(@PathParam("menId") final int menId) {
    List<Menu> vendorname = MenuFactory.showVendorName(menId);
    return Response.ok().entity(vendorname).build();
  }
}
