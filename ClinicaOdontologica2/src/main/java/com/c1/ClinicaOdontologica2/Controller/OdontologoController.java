package com.c1.ClinicaOdontologica2.Controller;


import com.c1.ClinicaOdontologica2.Entity.Odontologo;
import com.c1.ClinicaOdontologica2.Service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService = new OdontologoService();

    @PostMapping("/crearOdontologo") //Crear un nuevo odontologo
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {

        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @GetMapping ("/buscarOdontologo/{id}")
    public ResponseEntity<Odontologo> buscarporID (@PathVariable Integer id){
        return ResponseEntity.ok(odontologoService.buscarporID(id));
    }
}
