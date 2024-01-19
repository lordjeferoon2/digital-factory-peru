package controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class StudentControllerTest {

    private final MockMvc mockMvc;

    private final WebTestClient webTestClient;

    public StudentControllerTest(MockMvc mockMvc, WebTestClient webTestClient) {
        this.mockMvc = mockMvc;
        this.webTestClient = webTestClient;
    }

    @Test
    public void saveAlumno_ValidStudent_ReturnsOk() throws Exception {
        String json = "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"active\":true,\"dateOfBirth\":\"2022-01-19T12:34:56\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/alumnos/grabar")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAllStudentsByStatusActive_ReturnsCorrectList() {
        webTestClient.get()
                .uri("/alumnos/activos")
                .exchange()
                .expectStatus().isOk()
                .expectBody(/* Puedes agregar expectativas sobre el cuerpo de la respuesta */);
    }

}
