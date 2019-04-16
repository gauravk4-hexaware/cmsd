package com.hexaware.FTP112.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP112.model.Vendor;
import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.model.OrderItems;
import javax.ws.rs.PathParam;
import com.hexaware.FTP112.factory.VendorFactory;
import com.hexaware.FTP112.factory.OrdersFactory;
import com.hexaware.FTP112.factory.WalletFactory;
import com.hexaware.FTP112.model.OrderStatus;

import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Response;
import com.hexaware.FTP112.factory.Validators;
/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/vendors")
public class VendorController {
  /**
   * Returns vendor details.
   * @param venId to initialize vendor Id.
   * @return the vendor details
   */
  @GET
  @Path("/{venId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Vendor> vendor(@PathParam("venId") final int venId) {
    Validators.validateVendorId(venId);
    return VendorFactory.showVendor(venId);
  }

  /**
   * Returns vendor details.
   * @return the vendor details
   * @param id to initialize vendor Id.
   */
  @GET
  @Path("/{id}/orders")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response listVendor(@PathParam("id") final int id) {
    Validators.validateVendorId(id);
    final List<Orders> vendorHistory = OrdersFactory.showVendorHistory(id);
    return Response.status(Response.Status.OK).entity(vendorHistory).build();
  }
  /**
   * Returns vendor details.
   * @return the vendor details
   * @param id to initialize vendor Id.
   */
  @GET
  @Path("/{id}/pending")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response listPEndingOrders(@PathParam("id") final int id) {
    Validators.validateVendorId(id);
    List<OrderItems> pendingList = OrdersFactory.showPendingOrders(id);
    return Response.status(Response.Status.OK).entity(pendingList).build();
  }

  /**
     * Returns vendor details.
   * @param orderItemId to initialize order Id.
   * @param orders to initialize order.
   * @param vendorId to initialize vendorId.
   * @return the response.
   */
  @PUT
  @Path("/{vendorId}/orders/{orderItemId}/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response updateOrderStatus(@PathParam("orderItemId") final int orderItemId,
                                          @PathParam("vendorId") final int vendorId, final Orders orders) {
    //Validators.validateVenOrdId(vendorId, orderItemId);
    if (orders.getOrderStatus() == OrderStatus.ACCEPTED) {
      OrdersFactory.updateStatus(orderItemId, orders.getOrderStatus());
      OrdersFactory.updateComments(orders.getOrderId(), orders.getOrderComments());

    } else if (orders.getOrderStatus() == OrderStatus.DENIED) {
      OrdersFactory.updateStatus(orderItemId, orders.getOrderStatus());
      double price = OrdersFactory.getPrice(vendorId, orderItemId);
      VendorFactory.updateRefund(price, vendorId);
      int customerId = OrdersFactory.getCustomerId(vendorId, orderItemId);
      int walletId = OrdersFactory.getWalletId(orderItemId);
      WalletFactory.refundAmount(price, customerId, walletId);
      OrdersFactory.updateTotalPrice(price, orderItemId);
      OrdersFactory.updateComments(orders.getOrderId(), orders.getOrderComments());

    }
    return Response.status(Response.Status.NO_CONTENT).build();
  }
  /**
   * @return response.
   * @param vendor to get values.
   */
  @POST
  @Path("/Auth")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response authorize(final Vendor vendor) {
    Validators.validateVendor(vendor.getVenId(), vendor.getVenPassword());
    return Response.status(Response.Status.OK).build();
  }


  /**
   * Returns vendor details.
   * @return the vendor details
   * @param id to initialize vendor Id.
   * @param month to initialize month.
   */
  @GET
  @Path("/{id}/tax/{month}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response taxVendor(@PathParam("id") final int id, @PathParam("month") final int month) {
    Validators.validateVendorId(id);
    if (month <= 12 && month >= 1) {
      final List<Orders> vendorTax = OrdersFactory.taxCalculation(id, month);
      Orders[] array = (Orders[]) vendorTax.toArray(new Orders[vendorTax.size()]);
      double sum = 0;
      for (Orders index : array) {
        sum = sum + index.getTotalOrderPrice();
      }
      double gst = (sum * 5) / 100;
      double stateTax = gst / 2;
      double centralTax = gst / 2;
      HashMap<String, Double> map = new HashMap();
      map.put("sum", sum);
      map.put("gst", gst);
      map.put("stateTax", stateTax);
      map.put("centralTax", centralTax);
      return Response.status(Response.Status.OK).entity(map).build();
    } else {
      return Response.status(Response.Status.FORBIDDEN).entity("enter valid month").build();
    }

  }
}
