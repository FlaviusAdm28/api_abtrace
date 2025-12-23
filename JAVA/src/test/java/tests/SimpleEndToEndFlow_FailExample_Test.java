package tests;

import com.abtrace.api.enumeration.CoreConnectionPNames;
import com.abtrace.api.enumeration.EndpointEnum;
import com.abtrace.api.enumeration.StatusCodeEnum;
import com.abtrace.api.utils.TokenRetriever;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SimpleEndToEndFlow_FailExample_Test {

    private String jsonBody;
    private String lastCreatedTitle;
    private final Logger logger = Logger.getLogger(SimpleEndToEndFlow_FailExample_Test.class);

    //SETUP API URL AND CSV FILE NAME
    @BeforeClass()
    public void setup() {
        //DEFINE BASE API URL
        String baseHost = "https://j25m87y4z7.execute-api.eu-west-2.amazonaws.com";

        if(baseHost==null || baseHost.isBlank()|| !baseHost.contains("https")){
            logger.warn("INFO STATUS: BaseHost URL MUST be declared !!");
            System.exit(0);
        }else{
            RestAssured.baseURI = baseHost;

            //SET Response TIMEOUT
            HttpClientConfig httpCLientConfig = HttpClientConfig.httpClientConfig()
                    .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT.getName(), 10500)
                    .setParam(CoreConnectionPNames.SO_TIMEOUT.getName(), 10500);
            RestAssured.config = RestAssuredConfig.config().httpClient(httpCLientConfig);
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");
        String timestamp = now.format(formatter);

        lastCreatedTitle = "API TESTE POST " + now.format(formatter);


        jsonBody = """
        {
          "details": "API TESTE POST 1",
          "id": "",
          "title": "API TESTE POST %s",
          "user": "flavioteste"
        }
        """.formatted(timestamp);
    }

    //Get User Items
    @Test()
    public void GET_TODOS() {
        String token = TokenRetriever.getToken();

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("user","flavioteste")
                .when()
                .get(EndpointEnum.GET_ENDPOINT.getEndpoint())
                .then()
                .log().status()
                .log().body()
                .extract().response();

        // Valida Status Code
        Assert.assertEquals(response.getStatusCode(), 200);

        // verifica body vazio
        String responseBody = response.getBody().asString();
        Assert.assertFalse(responseBody.isEmpty(), "O body da resposta está vazio!");

    }

    // Insert an Item
    @Test(dependsOnMethods = "GET_TODOS")
    public void POST_ITEM() throws IOException, ParseException {
        String token = TokenRetriever.getToken();
        //this.jsonParser = JsonParser.jPath().path("src/test/java/request/test_POST_SAMPLE_PASS.json");

        //---------------------
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("user","flavioteste")
                .contentType("application/json")
                .body(jsonBody)
                .and()
                .when()
                .post(EndpointEnum.POST_ENDPOINT.getEndpoint()) //Pass the endpoint
                .then()
                .log().status()
                .log().body()
                .extract().response();

        //Verify or validate API RESPONSE
        Assert.assertEquals(response.getStatusCode(), StatusCodeEnum.STATUS_201.getCode());
    }

    // Verify previous inserted item

    //Get User Items
    @Test(dependsOnMethods = "POST_ITEM")
    public void GET_VERIFY_TODOS() throws InterruptedException {
        Thread.sleep(2000); //Explicit sleep waiting for BE

        String token = TokenRetriever.getToken();

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("user","flavioteste")
                .when()
                .get(EndpointEnum.GET_ENDPOINT.getEndpoint())
                .then()
                .log().status()
                .log().body()
                .extract().response();

        // Valida Status Code
        Assert.assertEquals(response.getStatusCode(), 200);

        // cria JsonPath a partir do response
        JsonPath jsonPath = response.jsonPath();
        // pega todos os titles
        List<String> titles = jsonPath.getList("title");

        // verifica se contem o esperado
        Assert.assertTrue(titles.contains(lastCreatedTitle),"O title esperado não foi encontrado!");

    }
}
