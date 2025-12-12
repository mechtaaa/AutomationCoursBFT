import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class TestApi {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    @Step("Cоздать книгу")
    @Description("Cоздаем книгу и проверяем все поля")
    public void createBook() {
        BookReq bookReq = new BookReq("Aleksandr", "Studentov", 222, true, new BookingDates("2018-01-01", "2019-01-01"), "Breakfast");

        given()
                .contentType(ContentType.JSON)
                .body(bookReq)
                .when()
                .post("/booking")
                .then().log().all()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("Aleksandr"))
                .body("booking.lastname", equalTo("Studentov"))
                .body("booking.totalprice", equalTo(222))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .body("booking.bookingdates.checkout", equalTo("2019-01-01"))
                .body("booking.additionalneeds", equalTo("Breakfast"));
    }

    @Test
    @Step("Получить книгу")
    @Description("Получаем по ID книгу")
    public void getBook() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking/2")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    @Step("Изменить книгу")
    @Description("Авторизуемся через токен и изменим книгу и проверим, что данные изменились")
    public void updateBook() {
        String token = given()
                .contentType(ContentType.JSON)
                .body(new AuthReq("admin", "password123"))
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract().path("token");

        BookReq bookReq = new BookReq("Student", "Bftov", 1000, false, new BookingDates("2024-05-05", "2026-05-05"), "Diner");

        given()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .body(bookReq)
                .when()
                .put("/booking/2")
                .then().log().all()
                .statusCode(200)
                .body("firstname", equalTo("Student"))
                .body("lastname", equalTo("Bftov"))
                .body("totalprice", equalTo(1000))
                .body("depositpaid", equalTo(false))
                .body("bookingdates.checkin", equalTo("2024-05-05"))
                .body("bookingdates.checkout", equalTo("2026-05-05"))
                .body("additionalneeds", equalTo("Diner"));
    }

    @Test
    @Step("Изменить созданную книгу")
    @Description("Создадим книгу, проверим, что она создалась, изменим её поля и проверим что сохранились изменения")
    public void updateCreatedBook() {
        BookReq createBook = new BookReq("Aleksandr", "Studentov", 222, true, new BookingDates("2018-01-01", "2019-01-01"), "Breakfast");
        int bookingId = given()
                .contentType(ContentType.JSON)
                .body(createBook)
                .when()
                .post("/booking")
                .then().log().all()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .extract().path("bookingid");


        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(200)
                .body("firstname", equalTo("Aleksandr"))
                .body("lastname", equalTo("Studentov"))
                .body("totalprice", equalTo(222))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("Breakfast"));


        BookReq updateReq = new BookReq("Student", "Bftov", 1000, false, new BookingDates("2024-05-05", "2026-05-05"), "Diner");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body(updateReq)
                .when()
                .put("/booking/" + bookingId)
                .then().log().all()
                .statusCode(200)
                .body("firstname", equalTo("Student"))
                .body("lastname", equalTo("Bftov"))
                .body("totalprice", equalTo(1000))
                .body("depositpaid", equalTo(false))
                .body("bookingdates.checkin", equalTo("2024-05-05"))
                .body("bookingdates.checkout", equalTo("2026-05-05"))
                .body("additionalneeds", equalTo("Diner"));
    }

    @Test
    @Step("Удалить созданную книгу")
    @Description("Создадим книгу, проверим, что она созалась, удалим её  и проверим, что данные книга удалена")
    public void deleteCreatedBook() {
        BookReq createBook = new BookReq("Aleksandr", "Studentov", 222, true, new BookingDates("2018-01-01", "2019-01-01"), "Breakfast");
        int bookingId = given()
                .contentType(ContentType.JSON)
                .body(createBook)
                .when()
                .post("/booking")
                .then().log().all()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("Aleksandr"))
                .extract().path("bookingid");


        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(200)
                .body("firstname", equalTo("Aleksandr"))
                .body("lastname", equalTo("Studentov"))
                .body("totalprice", equalTo(222))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("Breakfast"));


        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .delete("/booking/" + bookingId)
                .then().log().all()
                .statusCode(201);


        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(404);
    }
}