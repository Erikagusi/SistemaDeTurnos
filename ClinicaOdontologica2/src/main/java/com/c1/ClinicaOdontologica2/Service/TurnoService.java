package com.c1.ClinicaOdontologica2.Service;

import com.c1.ClinicaOdontologica2.Dao.Idao;
import com.c1.ClinicaOdontologica2.Dao.Implement.TurnoDaoList;
import com.c1.ClinicaOdontologica2.Entity.Turno;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {



    private Idao<Turno> turnoidao;

    @Autowired
    public TurnoService() {
        turnoidao = new TurnoDaoList();
    }

    public List<Turno> ObtenerTurnos(){
        return turnoidao.listarTodos();
    }
    public Turno buscarPorId(Integer id){
        return turnoidao.buscar(id);
    }
    public void eliminarTurno(Integer id){
        turnoidao.eliminar(id);
    }
    public void  actualizarTurno(Turno turno){
        turnoidao.actualizar(turno);
    }

    public Turno guardarTurno(Turno turno){
        return  turnoidao.guardar(turno);
    }

}
