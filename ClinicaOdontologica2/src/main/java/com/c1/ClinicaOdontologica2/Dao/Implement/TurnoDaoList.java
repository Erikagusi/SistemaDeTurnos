package com.c1.ClinicaOdontologica2.Dao.Implement;

import com.c1.ClinicaOdontologica2.Dao.Idao;
import com.c1.ClinicaOdontologica2.Entity.Turno;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TurnoDaoList implements Idao<Turno> {
    @Autowired
    private List<Turno> turnoList= new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        turnoList.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        for (Turno turno:turnoList) {
            if (turno.getId().equals(id)) {
                return turno;
            }
        }
            return null;

    }

    @Override
    public void eliminar(Integer id) {
        Turno turnoBuscado =buscar(id);
        turnoList.remove(turnoBuscado);
    }
    @Override
    public void actualizar(Turno turno) {
        eliminar(turno.getId());
        guardar(turno);
    }

    @Override
    public List<Turno> listarTodos() {
        return turnoList;
    }

    @Override
    public Turno buscarporString(String valor) {
        return null;
    }
}
