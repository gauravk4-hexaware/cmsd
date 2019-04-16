package com.hexaware.FTP112.integration.controller;

import com.hexaware.FTP112.integration.model.Customer;
import com.hexaware.FTP112.integration.util.CommonUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;



public class CustomerRestTest {

/**
  Get methods.
*/
  @Test
    public void testlistCustomer() throws URISyntaxException {
    given().when().accept(ContentType.JSON)
    .get(CommonUtil.getURI("/api/customer/1")).then().assertThat().statusCode(200);
    }


  @Test
    public void testlistCustomers() throws URISyntaxException {
    given().when().accept(ContentType.JSON)
    .get(CommonUtil.getURI("/api/customer/1/orders")).then().assertThat().statusCode(200);
    }

  @Test
    public void testlistWallet() throws URISyntaxException {
    given().when().accept(ContentType.JSON)
    .get(CommonUtil.getURI("/api/customer/1/wallet")).then().assertThat().statusCode(200);
    }

  @Test
    public void testvendor() throws URISyntaxException {
    given().when().accept(ContentType.JSON)
    .get(CommonUtil.getURI("/api/customer/venName/1")).then().assertThat().statusCode(200);
    }



//  Post methods.

    @Test
    public void testcustomerLoginValid() throws URISyntaxException {
    given().when().contentType(ContentType.JSON).body("{\"CusId\":\"1\", \"CusPassword\":\"justin18@\"}")
    .post(CommonUtil.getURI("/api/customer/auth")).then().assertThat().statusCode(400);
    }

    @Test
    public void testcustomerLoginInvalid() throws URISyntaxException {
    given().when().contentType(ContentType.JSON).body("{\"CusId\":\"2\", \"CusPassword\":\"justin18@\"}")
    .post(CommonUtil.getURI("/api/customer/auth")).then().assertThat().statusCode(400);
    }


    @Test
    public void testplaceOrderValid() throws URISyntaxException {
    given().when().contentType(ContentType.JSON).body("{\"menId\":\"1\", \"CusId\":\"1\",\"qty\":\"2\",\"VenId\":\"2\",\"WalId\":\"1\"}")
    .post(CommonUtil.getURI("/api/customer/1/orders/2")).then().assertThat().statusCode(400);
    }


  }

