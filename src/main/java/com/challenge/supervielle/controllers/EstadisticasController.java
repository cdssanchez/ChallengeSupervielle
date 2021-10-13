package com.challenge.supervielle.controllers;

import com.challenge.supervielle.models.PersonaModel;
import com.challenge.supervielle.repositories.PersonaRepository;
import com.challenge.supervielle.services.EstadisticaService;
import com.challenge.supervielle.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticaService estadisticaService;


    @GetMapping
    public ResponseEntity<String> obtenerEstadisticas(){
        return new ResponseEntity<String>(estadisticaService.getEstadisticas().toString(), HttpStatus.OK);
    }
}
