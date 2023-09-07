package com.c1.ClinicaOdontologica2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Turno {
    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate Fecha;

    public Turno() {
    }
}
