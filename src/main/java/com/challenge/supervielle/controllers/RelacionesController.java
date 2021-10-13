package com.challenge.supervielle.controllers;

import com.challenge.supervielle.exceptions.DomainException;
import com.challenge.supervielle.services.RelacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relaciones")
public class RelacionesController {

    @Autowired
    RelacionesService relacionesService;


    @GetMapping("/{id1}/{id2}")
    public ResponseEntity<String> verificarRelacion(@PathVariable long id1, @PathVariable long id2) throws DomainException {
        return relacionesService.getRelacion(id1,id2);
    }


}
