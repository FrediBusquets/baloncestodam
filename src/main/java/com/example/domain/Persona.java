package com.example.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by USER on 02/11/2016.
 */

@Entity
public class Persona {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private LocalDate fechanacimiento;
    private int canastastotales;
    private int asistenciastotales;
    private int rebotestotales;
    private String posicion;
    @ManyToOne
    private Equipo pertenece;

    public Persona(){}

    public Persona (Equipo pertenece){
        this.pertenece = pertenece;
    }
    public Persona(String nombre, LocalDate fechanacimiento, int canastastotales, int asistenciastotales, int rebotestotales, String posicion) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.canastastotales = canastastotales;
        this.asistenciastotales = asistenciastotales;
        this.rebotestotales = rebotestotales;
        this.posicion = posicion;

    }

    public Persona(String nombre, LocalDate fechanacimiento, int canastastotales, int asistenciastotales, int rebotestotales, String posicion, Equipo pertenece) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.canastastotales = canastastotales;
        this.asistenciastotales = asistenciastotales;
        this.rebotestotales = rebotestotales;
        this.posicion = posicion;
        this.pertenece = pertenece;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", canastastotales=" + canastastotales +
                ", asistenciastotales=" + asistenciastotales +
                ", rebotestotales=" + rebotestotales +
                ", posicion='" + posicion + '\'' +
                ", pertenece=" + pertenece +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public int getCanastastotales() {
        return canastastotales;
    }

    public void setCanastastotales(int canastastotales) {
        this.canastastotales = canastastotales;
    }

    public int getAsistenciastotales() {
        return asistenciastotales;
    }

    public void setAsistenciastotales(int asistenciastotales) {
        this.asistenciastotales = asistenciastotales;
    }

    public int getRebotestotales() {
        return rebotestotales;
    }

    public void setRebotestotales(int rebotestotales) {
        this.rebotestotales = rebotestotales;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getPertenece() {
        return pertenece;
    }

    public void setPertenece(Equipo pertenece) {
        this.pertenece = pertenece;
    }
}
