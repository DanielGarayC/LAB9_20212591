package org.example.lab9.dto;

public class listaMetricaC {
    private String tipo_combustible;
    private int cant_carros;
    private int capacidad_maxima;
    private int capacidad_minima;
    private int promedio;

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public int getCant_carros() {
        return cant_carros;
    }

    public void setCant_carros(int cant_carros) {
        this.cant_carros = cant_carros;
    }

    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public int getCapacidad_minima() {
        return capacidad_minima;
    }

    public void setCapacidad_minima(int capacidad_minima) {
        this.capacidad_minima = capacidad_minima;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }
}
