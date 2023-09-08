package com.c1.ClinicaOdontologica2.Controller;

import com.c1.ClinicaOdontologica2.Dao.Implement.OdontologoDaoH2;
import com.c1.ClinicaOdontologica2.Entity.Odontologo;
import com.c1.ClinicaOdontologica2.Entity.Turno;
import com.c1.ClinicaOdontologica2.Service.OdontologoService;
import com.c1.ClinicaOdontologica2.Service.PacienteService;
import com.c1.ClinicaOdontologica2.Service.TurnoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService = new TurnoService();

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Turno>> buscarTodos() {
        return ResponseEntity.ok(turnoService.ObtenerTurnos());
    }

    @PostMapping("/registrarTurno")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        OdontologoService odontologoService = new OdontologoService();
        PacienteService pacienteService = new PacienteService();
        if (pacienteService.buscarporID(turno.getPaciente().getId()) != null && odontologoService.buscarporID(turno.getOdontologo().getId()) != null) {
            //los dos existen
            return ResponseEntity.ok(turnoService.guardarTurno(turno));

        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

