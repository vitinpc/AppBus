package br.com.appbus.appBus.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OnibusController.class)
public class OnibusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static class LocalizacaoDTO {
        public String latitude;

        public LocalizacaoDTO(String latitude) {
            this.latitude = latitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
    }

    @Test
    void deveRetornarListaDeHorarios() throws Exception {
        mockMvc.perform(get("/api/onibus"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("06:30"))
                .andExpect(jsonPath("$[1]").value("07:00"))
                .andExpect(jsonPath("$[2]").value("08:00"));
    }

    @Test
    void deveRegistrarLocalizacaoComPost() throws Exception {
        LocalizacaoDTO dto = new LocalizacaoDTO("-19.9227");

        mockMvc.perform(post("/api/onibus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Localização recebida: -19.9227"));
    }
}
