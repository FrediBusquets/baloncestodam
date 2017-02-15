package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by USER on 02/11/2016.
 */
@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idclub;
    private String nombre;
    private String localidad;
    private LocalDate fechacreacion;

    public Equipo(String nombre, String localidad, LocalDate fechacreacion) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.fechacreacion = fechacreacion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idclub=" + idclub +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", fechacreacion=" + fechacreacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (!idclub.equals(equipo.idclub)) return false;
        if (!nombre.equals(equipo.nombre)) return false;
        if (!localidad.equals(equipo.localidad)) return false;
        return fechacreacion.equals(equipo.fechacreacion);

    }

    @Override
    public int hashCode() {
        int result = idclub.hashCode();
        result = 31 * result + nombre.hashCode();
        result = 31 * result + localidad.hashCode();
        result = 31 * result + fechacreacion.hashCode();
        return result;
    }

    public Equipo() {
    }

    public Long getIdclub() {
        return idclub;
    }

    public void setIdclub(Long idclub) {
        this.idclub = idclub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
}
