package com.rover.katanarover;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rover.katanarover.models.GridElement;
import com.rover.katanarover.models.Plateau;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testServerStatus() {
        String url = "http://localhost:" + port + "/api/rover/up";

        // Hacer una solicitud GET a la URL del servidor y verificar el código de respuesta
        int statusCode = restTemplate.getForEntity(url, String.class).getStatusCode().value();

        // Verificar que el código de respuesta sea 200 (OK)
        assertEquals(200, statusCode);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreatePlateau() throws Exception {
        // Crea un objeto Plateau para enviar en la solicitud
        Plateau plateau = new Plateau(/* inicializa el objeto Plateau */);

        // Envia una solicitud POST a /api/rover y verifica que devuelve un código 201
        mockMvc.perform(MockMvcRequestBuilders.post("/api/rover")
                        .content(asJsonString(plateau))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testPlateauList() throws Exception {
        // Envía una solicitud GET a /api/rover y verifica que devuelve un código 200
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rover")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Implementa pruebas similares para otros endpoints según sea necesario /api/rover/obstacle"

    @Test
    public void testCreateObstacle() throws Exception {
        // Crea un objeto Plateau para enviar en la solicitud
        GridElement gridElement = new GridElement(/* inicializa el objeto Plateau */);

        // Envia una solicitud POST a /api/rover y verifica que devuelve un código 201
        mockMvc.perform(MockMvcRequestBuilders.post("/api/rover/obstacleAll")
                        .content(asJsonString(gridElement))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testObstaclesList() throws Exception {
        // Envía una solicitud GET a /api/rover y verifica que devuelve un código 200
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rover/obstacle")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRoverMoveList() throws Exception {
        // Envía una solicitud GET a /api/rover y verifica que devuelve un código 200
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rover/roverMoveAll")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRoverCommandsList() throws Exception {
        // Envía una solicitud GET a /api/rover y verifica que devuelve un código 200
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rover/commandAll")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
