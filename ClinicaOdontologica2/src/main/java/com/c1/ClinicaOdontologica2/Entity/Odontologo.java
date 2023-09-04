package com.c1.ClinicaOdontologica2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Odontologo {

    private int id;
    private int matricula;
    private String nombre;
    private String apellido;

}
