package com.hexaware.FTP112.util;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP112.model.Menu;
import com.hexaware.FTP112.factory.MenuFactory;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/Menu")
public class MenuController {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Path("")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response listMenu() {
    final List<Menu> menu = MenuFactory.showMenu();
    if (!menu.isEmpty()) {
      return Response.ok().entity(menu).build();
    } else {
      return Response.status(Response.Status.FORBIDDEN).entity("menu not found").build();
    }
  }
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Path("/show")
  @Produces(MediaType.APPLICATION_JSON)
  public final Response listMenuAdd() {
    final List<Menu> menu = MenuFactory.showMenuAdd();
    if (!menu.isEmpty()) {
      return Response.ok().entity(menu).build();
    } else {
      return Response.status(Response.Status.FORBIDDEN).entity("menu not found").build();
    }
  }
  /**
     * Returns vendor details.
   * @param price to initialize price.
   * @param menuId to initialize menuId.
   * @param vendorId to initialize vendorId.
   * @return the response.
   */
  @POST
  @Path("/{vendorId}/update/{menuId}/{price}/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response updateJunction(@PathParam("vendorId") final int vendorId, @PathParam("menuId") final int menuId,
                                  @PathParam("price") final int price) {
    MenuFactory.updateJunction(menuId, vendorId, price);
    return Response.status(Response.Status.OK).build();
  }
  /**
     * Returns vendor details.
   * @param menuId to initialize menuId.
   * @param vendorId to initialize vendorId.
   * @return the response.
   */
  @DELETE
  @Path("/{vendorId}/update/{menuId}/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Response deleteVenMen(@PathParam("vendorId") final int vendorId, @PathParam("menuId") final int menuId) {
    MenuFactory.deleteVenMen(menuId, vendorId);
    return Response.status(Response.Status.OK).build();
  }
}
