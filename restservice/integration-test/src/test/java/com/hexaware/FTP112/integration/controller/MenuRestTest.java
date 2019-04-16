package com.hexaware.FTP112.integration.controller;
import com.hexaware.FTP112.integration.model.Menu;
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
import com.hexaware.FTP112.integration.model.Menu;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;
//import com.hexaware.FTP112.integration.util;
public class MenuRestTest {

	@Test
	public void testMenuList() throws URISyntaxException {
	given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/Menu")).then().assertThat().statusCode(200);
	}
	@Test
	public void testMenuShowList() throws URISyntaxException {
	given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/Menu/show")).then().assertThat().statusCode(200);
	}
	@Test
	public void testMenuPrice() throws URISyntaxException {
	given().when().contentType(ContentType.JSON).body("{}")
		.post(CommonUtil.getURI("api/Menu/1/update/1/50")).then().assertThat().statusCode(404);
	}
	
}
