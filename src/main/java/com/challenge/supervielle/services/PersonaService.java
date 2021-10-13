package com.challenge.supervielle.services;

import com.challenge.supervielle.key.PersonaKey;
import com.challenge.supervielle.models.PersonaModel;
import com.challenge.supervielle.repositories.PersonaRepository;
import com.challenge.supervielle.responses.ErrorResponse;
import com.challenge.supervielle.utils.Sexo;
import com.challenge.supervielle.utils.TipoDNI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.IdClass;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public ArrayList<PersonaModel> listAll(){
        return (ArrayList<PersonaModel>) personaRepository.findAll();
    }

    public PersonaModel savePersona(PersonaModel persona){
        return personaRepository.save(persona);
    }

    public void removePersona(PersonaModel persona){personaRepository.delete(persona);}

    public void removePersona(int id){
        personaRepository.delete(personaRepository.findByDni(id));}

    public ResponseEntity<String> update(PersonaModel persona){
        PersonaModel exist= personaRepository.findByDni(persona.getDni());
        if (exist!=null){
            return new ResponseEntity<String>(savePersona(persona).toString(), HttpStatus.OK) ;
        }else {
            return new ResponseEntity<String>(new ErrorResponse(501,"Persona" ,"Persona no existe").toString(), HttpStatus.CONFLICT);
        }
    }


}
