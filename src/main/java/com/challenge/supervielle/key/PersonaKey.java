package com.challenge.supervielle.key;

import com.challenge.supervielle.utils.Sexo;
import com.challenge.supervielle.utils.TipoDNI;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class PersonaKey implements Serializable {


    @Id
    private Long dni;
    @Id
    private TipoDNI dniType;
    @Id
    private Sexo sexo;
    @Id
    private String pais;


}
