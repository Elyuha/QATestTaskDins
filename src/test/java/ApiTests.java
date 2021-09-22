import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class ApiTests {
    @Test
    public void return200WithPojoObjectId1(){
        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts/1")
                .then().assertThat().statusCode(200)
                .and().body("id", is(1));

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts/3")
                .then().assertThat().statusCode(200)
                .and().body("id", is(3));

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts/10")
                .then().assertThat().statusCode(200)
                .and().body("id", is(10));
    }

    @Test
    public void return404(){
        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts/0")
                .then().assertThat().statusCode(404);

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts/fsddfdssa")
                .then().assertThat().statusCode(404);
    }

    @Test
    public void return200WithEmptyBody() {
        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts?id=123")
                .then().assertThat().statusCode(200)
                .and().body("isEmpty()", is(true));

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts?userId=123")
                .then().assertThat().statusCode(200)
                .and().body("isEmpty()", is(true));

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts?userId=1230")
                .then().assertThat().statusCode(200)
                .and().body("isEmpty()", is(true));

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts?userId=")
                .then().assertThat().statusCode(200)
                .and().body("isEmpty()", is(true));

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts?userId")
                .then().assertThat().statusCode(200)
                .and().body("isEmpty()", is(true));
    }

    @Test
    public void return200WithPojoObjectUserId1(){
        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts?userId=1")
                .then().assertThat().statusCode(200)
                .and().body("userId", everyItem(is(1)));

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts?userId=3")
                .then().assertThat().statusCode(200)
                .and().body("userId", everyItem(is(3)));

        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts?userId=9")
                .then().assertThat().statusCode(200)
                .and().body("userId", everyItem(is(9)));
    }

    @Test
    public void return200WithPojoObjectList(){
        RestAssured
                .when().get("https://jsonplaceholder.typicode.com/posts")
                .then().assertThat().statusCode(200)
                .and().body("size()", is(100));
    }
}
