package com.hexaware.FTP112.util;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;

/**
* This class provides a ExceptionHandler for all Exception Classes.
*/
@Provider
public class GlobalException implements  ExceptionMapper<IllegalArgumentException> {
  /**
   * @param ex reference variable for IllegalException.
   * @return the integer values for response.
   */
  public final Response toResponse(final IllegalArgumentException ex) {
    if (ex instanceof IllegalArgumentException) {
      return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
    }
    return Response.status(500).entity(ex.getMessage()).build();
  }
}
