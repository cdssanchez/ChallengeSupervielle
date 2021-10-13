package com.challenge.supervielle.controllers;

import com.challenge.supervielle.exceptions.DomainException;
import com.challenge.supervielle.models.PersonaModel;
import com.challenge.supervielle.repositories.PersonaRepository;
import com.challenge.supervielle.responses.ErrorResponse;
import com.challenge.supervielle.services.PersonaService;
import com.challenge.supervielle.services.RelacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private RelacionesService relacionesService;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public ArrayList<PersonaModel> verTodas(){
         return personaService.listAll();
    }

    @PostMapping()
    public ResponseEntity<String> guardarPersona(@RequestBody PersonaModel persona) throws DomainException {
        if (persona.getEdad()<18){
            return new ResponseEntity<String>(new ErrorResponse(500,"edad" ,"Menor de Edad").toString(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>(personaService.savePersona(persona).toString(), HttpStatus.CREATED) ;
    }

    @PostMapping("/{id1}/padre/{id2}")
    public ResponseEntity<String> relacionarPersona(@PathVariable long id1, @PathVariable int id2) throws DomainException {
        PersonaModel padre= personaRepository.findByDni(id1);
        PersonaModel hijo= personaRepository.findByDni(id2);
        padre.addHijo(hijo);
        hijo.setPadre(padre);
        personaRepository.save(padre);
        return new ResponseEntity<String>(HttpStatus.CREATED) ;
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarPersonaViaBody(@RequestBody PersonaModel persona){
        personaService.removePersona(persona);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping("{/dni}")
    public ResponseEntity<String> eliminarPersonaViaPath(@PathVariable int dni){
        personaService.removePersona(dni);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> actualizarPersona(@RequestBody PersonaModel persona){
        return personaService.update(persona);
    }

}
