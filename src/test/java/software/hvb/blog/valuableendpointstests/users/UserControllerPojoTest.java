package software.hvb.blog.valuableendpointstests.users;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserControllerPojoTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void shouldListAllUsers() {
        List<User> expectedUsers = List.of(
                new User(1L, "Walter", "White"),
                new User(2L, "Jesse", "Pinkman")
        );

        List<User> users =
                given()
                    .contentType(APPLICATION_JSON_VALUE)
                .when()
                    .get("/users")
                .then()
                    .statusCode(OK.value())
                    .contentType(APPLICATION_JSON_VALUE)
                    .extract().as(new TypeRef<>() {});

        assertEquals(expectedUsers, users);
    }
}