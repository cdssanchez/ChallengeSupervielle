package com.challenge.supervielle.models;

import com.challenge.supervielle.key.PersonaKey;
import com.challenge.supervielle.utils.Sexo;
import com.challenge.supervielle.utils.TipoDNI;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Configuration;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="PERSONA")
//@IdClass(PersonaKey.class)
public class PersonaModel {

    @Id
    @Column(name="dni",nullable=false)
    private Long dni;

    @Column(name="dniType",nullable=false)
    private TipoDNI dniType;

    @Column(name="sexo",nullable=false)
    private Sexo sexo;

    @Column(name="pais",nullable=false)
    private String pais;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="edad")
    private Integer edad;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_dni")
    private PersonaModel padre;

    @JsonIgnore
    @OneToMany(mappedBy = "padre", fetch = FetchType.EAGER)
    private List<PersonaModel> hijos  = new ArrayList<>();

    public PersonaModel() {
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public TipoDNI getDniType() {
        return dniType;
    }

    public void setDniType(TipoDNI dniType) {
        this.dniType = dniType;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public PersonaModel getPadre() {
        return padre;
    }

    public void setPadre(PersonaModel padre) {
        this.padre = padre;
    }

    public List<PersonaModel> getHijos() {
        return hijos;
    }

    public void setHijos(List<PersonaModel> hijos) {
        this.hijos = hijos;
    }

    public void addHijo(PersonaModel persona) {
        this.hijos.add(persona);
    }

    public void removeHijo(PersonaModel hijo) {
        this.hijos.remove(hijo);
    }

    @Override
    public String toString() {
        return "{" +
                "dni=" + dni +
                ", dniType=" + dniType +
                ", sexo=" + sexo +
                ", pais='" + pais + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
