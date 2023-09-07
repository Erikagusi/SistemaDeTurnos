package com.c1.ClinicaOdontologica2.Service;

import com.c1.ClinicaOdontologica2.Dao.Idao;
import com.c1.ClinicaOdontologica2.Dao.Implement.OdontologoDaoH2;
import com.c1.ClinicaOdontologica2.Entity.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {


    @Autowired
    private Idao<Odontologo> odontologoIdao = new OdontologoDaoH2();


    OdontologoService odontologoService;
    Idao<Odontologo> interfaz;
    public Odontologo guardarOdontologo (Odontologo odontologo){
        return odontologoIdao.guardar(odontologo);
    }
    public Odontologo buscarporID(Integer id){
        return odontologoIdao.buscar(id);
    }

    public void eliminarOdontologo(Integer id){
        odontologoIdao.eliminar(id);
    }

    public void actualizarOdontologo(Odontologo odontologo){
        odontologoIdao.actualizar(odontologo);
    }

    public List<Odontologo> obtenerOdontologos(){
        return odontologoIdao.listarTodos();
    }

    public Odontologo buscarPorEMail (String valor){
        return odontologoIdao.buscarporString(valor);
    }

}
