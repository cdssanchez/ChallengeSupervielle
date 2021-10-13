package com.challenge.supervielle.controllers;

import com.challenge.supervielle.models.PersonaModel;
import com.challenge.supervielle.repositories.PersonaRepository;
import com.challenge.supervielle.services.EstadisticaService;
import com.challenge.supervielle.utils.Sexo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.challenge.supervielle.utils.TipoDNI.DNI;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstadisticasController.class)
class EstadisticasControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EstadisticaService estadisticaService;

    @MockBean
    PersonaRepository personaRepository;

    @Test
    void getEstadisticas() throws Exception  {
         }
}