package com.challenge.supervielle.services;

import com.challenge.supervielle.models.EstadisticaModel;
import com.challenge.supervielle.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadisticaService {

    @Autowired
    private PersonaRepository personaRepository;


    public EstadisticaModel getEstadisticas(){
        int total=personaRepository.countPersonas();
        int mujeres=personaRepository.countMujeres();
        int arg=personaRepository.countArgentinos();
        return new EstadisticaModel(mujeres,total-mujeres,total/arg*100);


    }
}
