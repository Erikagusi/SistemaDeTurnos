package com.c1.ClinicaOdontologica2.Controller;


import com.c1.ClinicaOdontologica2.Entity.Paciente;
import com.c1.ClinicaOdontologica2.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.awt.*;

//@Controller//Ahora trabajo con vista y no con restController
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService = new PacienteService();

    @PostMapping ("/crearPaciente") //Crear un nuevo paciente
    public ResponseEntity<Paciente> regustarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok( pacienteService.guardarPaciente(paciente));

    }

    @PutMapping ("/actualizarPaciente")
    public String actualizarPaciente(@RequestBody Paciente  paciente){
        Paciente pacienteBuscado = pacienteService.buscarporID(paciente.getId());
        if (pacienteBuscado != null){
            return "Paciente Actualizado con Exito: "+paciente.getNombre();
        }else{
            return "No se pudo actualizar el paciente solicitado";
        }
    }

    /*@GetMapping ("/ListarTodos")
    public  ResponseEntity<List<Paciente>> listarTodos (){
        return ResponseEntity.ok(pacienteService.obtenerPacientes());
    }*/






    /*@GetMapping
    public String buscarPorCorreo (Model model, @RequestParam("email") String correo){
        Paciente paciente = pacienteService.buscarPorEMail(correo);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApeliido());
        //Esto lo paso a la vista

        return "index"; //timelif

    }*/

}
