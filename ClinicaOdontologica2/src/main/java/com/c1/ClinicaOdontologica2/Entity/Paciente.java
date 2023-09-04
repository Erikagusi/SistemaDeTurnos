package com.c1.ClinicaOdontologica2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class Paciente {
    private Integer id;
    private String nombre;
    private String apeliido;
    private String cedula;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;
    private String email;

    public Paciente(String nombre, String apeliido, String cedula, LocalDate fechaIngreso, Domicilio domicilio, String email) {
        this.nombre = nombre;
        this.apeliido = apeliido;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.email = email;
    }

    public Paciente(Integer id, String nombre, String apeliido, String cedula, LocalDate fechaIngreso, Domicilio domicilio, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apeliido = apeliido;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.email = email;
    }
}


