package com.challenge.supervielle.services;

import com.challenge.supervielle.models.PersonaModel;
import com.challenge.supervielle.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RelacionesService {


    @Autowired
    private PersonaRepository personaRepository;

    public ResponseEntity<String> getRelacion(long id1, long id2){
        PersonaModel persona1= personaRepository.findByDni(id1);
        PersonaModel persona2= personaRepository.findByDni(id2);

        try{
            if (sonHermanos(persona1,persona2)){
                return new ResponseEntity<String>("Herman@s", HttpStatus.OK);
            }else if (sonHermanos(persona1.getPadre(),persona2.getPadre())){
                return new ResponseEntity<String>("Prim@s", HttpStatus.OK);
            } else if (sonHermanos(persona1.getPadre(),persona2)){
                return new ResponseEntity<>("Ti@",HttpStatus.OK);
            }


        }catch (Exception e){
        }

        return new ResponseEntity<String>("No existe relacion", HttpStatus.OK);
    }

    private boolean sonHermanos(PersonaModel p1, PersonaModel p2){
        if (p1.getPadre().getHijos().contains(p2)){
            return true;
        }else {
            return false;
        }
    }



}
