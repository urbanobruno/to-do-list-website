package com.labdessoft.roteiro01.integration;

import com.labdessoft.roteiro01.Roteiro01Application;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = { Roteiro01Application.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class TaskControllerIntegrationTest {
    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.port = 8080;
    }

    @Test
    public void listAllTasks_whenTasksExist_thenCorrect() {
        get("/tasks").then().statusCode(200).assertThat().body("size()", equalTo(2));
    }

    @Test
    public void createTask_whenValidRequest_thenCorrect() {
        String requestBody = """
            {
                "description": "Nova Tarefa",
            }
            """;

        given().contentType("application/json")
               .body(requestBody)
               .when()
               .post("/task")
               .then()
               .statusCode(201)
               .body("description", equalTo("Nova Tarefa"))
               .body("type", equalTo("LIVRE"));
    }

    @Test
    public void createDataTask_whenValidRequest_thenCorrect() {
        String requestData = """
            {
                "description": "Task Data",
                "priority": "ALTA",
                "plannedDate": "2024-06-01"
            }
            """;

        given().contentType("application/json")
               .body(requestData)
               .when()
               .post("/task/create/data")
               .then()
               .statusCode(201)
               .body("description", equalTo("Task Data"))
               .body("priority", equalTo("ALTA"))
               .body("plannedDate", equalTo("2024-06-01"));
    }

    @Test
    public void createPrazoTask_whenValidRequest_thenCorrect() {
        String requestPrazo = """
            {
                "description": "Task Prazo",
                "priority": "MEDIA",
                "plannedDays": 15
            }
            """;

        given().contentType("application/json")
               .body(requestPrazo)
               .when()
               .post("/task/create/prazo")
               .then()
               .statusCode(201)
               .body("description", equalTo("Task Prazo"))
               .body("priority", equalTo("MEDIA"))
               .body("plannedDays", equalTo(15));
    }

    @Test
    public void markTaskAsCompleted_whenExistingId_thenCorrect() {
        Long taskId = 1L;

        given().pathParam("id", taskId)
               .when()
               .patch("/task/{id}")
               .then()
               .statusCode(200)
               .body("completed", equalTo(true))
               .body("id", equalTo(taskId.intValue()));
    }

    @Test
    public void deleteTask_whenValidId_thenNoContent() {
        given().pathParam("id", 2)
               .when()
               .delete("/task/{id}")
               .then()
               .statusCode(204);
    }

    @Test
    public void deleteTask_whenExistingId_thenSuccess() {
        Long taskId = 1L;

        given().pathParam("id", taskId)
               .when()
               .delete("/task/{id}")
               .then()
               .statusCode(200);
    }

    @Test
    public void deleteTask_whenNonExistingId_thenNotFound() {
        Long taskId = 999L;

        given().pathParam("id", taskId)
               .when()
               .delete("/task/{id}")
               .then()
               .statusCode(404);
    }
}
