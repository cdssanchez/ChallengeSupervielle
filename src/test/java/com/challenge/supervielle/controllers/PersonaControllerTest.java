package com.challenge.supervielle.controllers;

import com.challenge.supervielle.models.PersonaModel;
import com.challenge.supervielle.repositories.PersonaRepository;
import com.challenge.supervielle.utils.Sexo;
import com.challenge.supervielle.utils.TipoDNI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.challenge.supervielle.utils.TipoDNI.DNI;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonaController.class)
class PersonaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonaRepository personaRepository;

    @Test
    void getAll() throws Exception {
        PersonaModel mock = new PersonaModel();
        mock.setApellido("Sanchez");
        mock.setNombre("Cristian");
        mock.setEdad(36);
        mock.setDni(31389813L);
        mock.setDniType(DNI);
        mock.setSexo(Sexo.MASCULINO);
        mock.setPais("Argentina");


        List<PersonaModel> records = new ArrayList<>(Arrays.asList(mock));


        Mockito.when(personaRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/persona")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is("Cristian")));
    }



}