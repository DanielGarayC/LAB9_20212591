package org.example.lab9.dto;
import java.util.Date;
public class listaMetricaG {
    private Date fecha;
    private int num_alquileres;
    private int ganancias;
    private int perdidas;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNum_alquileres() {
        return num_alquileres;
    }

    public void setNum_alquileres(int num_alquileres) {
        this.num_alquileres = num_alquileres;
    }

    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }
}
