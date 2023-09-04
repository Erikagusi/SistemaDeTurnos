package com.c1.ClinicaOdontologica2.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Domicilio {
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}
