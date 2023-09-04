package com.c1.ClinicaOdontologica2.Service;

import com.c1.ClinicaOdontologica2.Dao.Idao;
import com.c1.ClinicaOdontologica2.Dao.Implement.PacienteDaoH2;
import com.c1.ClinicaOdontologica2.Entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {

@Autowired
private Idao<Paciente> pacienteiDao = new PacienteDaoH2();


PacienteService pacienteService;
public Paciente guardarPaciente (Paciente paciente){
    return pacienteiDao.guardar(paciente);
}
public Paciente buscarporID(Integer id){
    return pacienteiDao.buscar(id);
}

public void eliminarPaciente(Integer id){
    pacienteiDao.eliminar(id);
}

public void actualizarPaciente(Paciente paciente){
    pacienteiDao.actualizar(paciente);
}

public List<Paciente> obtenerPacientes(){
    return pacienteiDao.listarTodos();
}

public Paciente buscarPorEMail (String valor){
    return pacienteiDao.buscarporString(valor);
}


}
