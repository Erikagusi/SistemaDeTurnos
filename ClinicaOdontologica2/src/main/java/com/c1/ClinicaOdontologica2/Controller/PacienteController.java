package com.c1.ClinicaOdontologica2.Controller;


import com.c1.ClinicaOdontologica2.Entity.Paciente;
import com.c1.ClinicaOdontologica2.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//Ahora trabajo con vista y no con restController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService = new PacienteService();
    @GetMapping
    public String buscarPorCorreo (Model model, @RequestParam("email") String correo){
        Paciente paciente = pacienteService.buscarPorEMail(correo);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApeliido());
        //Esto lo paso a la vista

        return "index"; //timelif

    }
}
