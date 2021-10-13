package com.challenge.supervielle.repositories;


import com.challenge.supervielle.key.PersonaKey;
import com.challenge.supervielle.models.PersonaModel;
import com.challenge.supervielle.utils.Sexo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaModel, PersonaKey> {

    @Query("select count(*) FROM PersonaModel")
    int countPersonas();

    @Query("select count(*) FROM PersonaModel t WHERE t.sexo = com.challenge.supervielle.utils.Sexo.FEMENINO")
    int countMujeres ();

    @Query("select count(*) FROM PersonaModel t WHERE t.pais = 'Argentina'")
    int countArgentinos ();

    PersonaModel findByDni(long dni);
}
