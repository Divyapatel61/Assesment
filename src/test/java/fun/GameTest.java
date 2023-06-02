package fun;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	//@Test
	public void testGet()
	{
		baseURI="http://localhost:3000/";
		
		//Get-1
		given().
			get("/Game").
		then().
			statusCode(200).
		log().all();
		
		//GET-2
		given().
			param("name", "Sudoku").
		get("/Game").then().
			statusCode(200).
		log().all();

	}
	
	@Test
	public void JsonSchemaTest()
	{
			
		baseURI="http://localhost:3000/";
		
		given().
			get("/Game?name=Sudoku").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200);
	}
	
}
