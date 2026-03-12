package ru.aston.homework.lesson8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.allOf;

public class PostmanEchoTest {

    private static final String BASE_URL = "https://postman-echo.com";

    // Метод для проверки полей запроса "GET Request"
    @Test
    public void testGet() {
        given()
                .baseUri(BASE_URL)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .headers(
                        "accept-encoding", "gzip, deflate, br",
                        "accept", "*/*",
                        "user-agent", "PostmanRuntime/7.51.1"
                )
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body(
                        "headers.accept-encoding",
                        allOf(
                                containsString("gzip"),
                                containsString("br")
                        )
                )
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.51.1"))
                .body("headers.x-forwarded-proto", notNullValue())
                .body("headers.postman-token", anyOf(nullValue(), notNullValue()))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()));
    }


    // Метод для проверки полей запроса "POST Raw Text"
    @Test
    public void testPostRawText() {
        String body = "{\n    \"test\": \"value\"\n}";

        given()
                .baseUri(BASE_URL)
                .headers(
                        "accept-encoding", "gzip, deflate, br",
                        "accept", "*/*",
                        "user-agent", "PostmanRuntime/7.51.1",
                        "content-type", "text/plain"
                )
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", notNullValue())
                .body(
                        "headers.accept-encoding",
                        allOf(
                                containsString("gzip"),
                                containsString("br")
                        )
                )
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.51.1"))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.x-forwarded-proto", notNullValue())
                .body("headers.postman-token", anyOf(nullValue(), notNullValue()))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()))
                .body("json", anyOf(nullValue(), notNullValue()));
    }


    // Метод для проверки полей запроса "POST Form Data"
    @Test
    public void testPostFormData() {
        String body = "foo1=bar1&foo2=bar2";

        given()
                .baseUri(BASE_URL)
                .headers(
                        "accept-encoding", "gzip, deflate, br",
                        "accept", "*/*",
                        "user-agent", "PostmanRuntime/7.51.1",
                        "content-type", "application/json"
                )
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", notNullValue())
                .body(
                        "headers.accept-encoding",
                        allOf(
                                containsString("gzip"),
                                containsString("br")
                        )
                )
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.51.1"))
                .body("headers.content-type", startsWith("application/json"))
                .body("headers.x-forwarded-proto", notNullValue())
                .body("headers.postman-token", anyOf(nullValue(), notNullValue()))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()))
                .body("json", anyOf(nullValue(), notNullValue()));
    }


    // Метод для проверки полей запроса "PUT Request"
    @Test
    public void testPut() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .headers(
                        "accept-encoding", "gzip, deflate, br",
                        "accept", "*/*",
                        "user-agent", "PostmanRuntime/7.51.1",
                        "content-type", "text/plain"
                )
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", notNullValue())
                .body(
                        "headers.accept-encoding",
                        allOf(
                                containsString("gzip"),
                                containsString("br")
                        )
                )
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.51.1"))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.x-forwarded-proto", notNullValue())
                .body("headers.postman-token", anyOf(nullValue(), notNullValue()))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()))
                .body("json", anyOf(nullValue(), notNullValue()));
    }


    // Метод для проверки полей запроса "PATCH Request"
    @Test
    public void testPatch() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .headers(
                        "accept-encoding", "gzip, deflate, br",
                        "accept", "*/*",
                        "user-agent", "PostmanRuntime/7.51.1",
                        "content-type", "text/plain"
                )
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", notNullValue())
                .body(
                        "headers.accept-encoding",
                        allOf(
                                containsString("gzip"),
                                containsString("br")
                        )
                )
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.51.1"))
                .body("headers.x-forwarded-proto", notNullValue())
                .body("headers.postman-token", anyOf(nullValue(), notNullValue()))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()))
                .body("json", anyOf(nullValue(), notNullValue()));
    }



    // Метод для проверки полей запроса "DELETE Request"
    @Test
    public void testDelete() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .headers(
                        "accept-encoding", "gzip, deflate, br",
                        "accept", "*/*",
                        "user-agent", "PostmanRuntime/7.51.1",
                        "content-type", "text/plain"
                )
                .body(body)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("files.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", notNullValue())
                .body(
                        "headers.accept-encoding",
                        allOf(
                                containsString("gzip"),
                                containsString("br")
                        )
                )
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", equalTo("PostmanRuntime/7.51.1"))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.x-forwarded-proto", notNullValue())
                .body("headers.postman-token", anyOf(nullValue(), notNullValue()))
                .body("headers.cookie", anyOf(nullValue(), notNullValue()))
                .body("json", anyOf(nullValue(), notNullValue()));
    }

}

