package com.challenge.supervielle.models;

public class EstadisticaModel {

    private int cantidad_mujeres;
    private int cantidad_hombres;
    private int porcentaje_argentinos;

    public EstadisticaModel(int cantidad_mujeres, int cantidad_hombres, int porcentaje_argentinos) {
        this.cantidad_mujeres = cantidad_mujeres;
        this.cantidad_hombres = cantidad_hombres;
        this.porcentaje_argentinos = porcentaje_argentinos;
    }

    @Override
    public String toString() {
        return "{" +
                "cantidad_mujeres=" + cantidad_mujeres +
                ", cantidad_hombres=" + cantidad_hombres +
                ", porcentaje_argentinos=" + porcentaje_argentinos +
                '}';
    }
}
