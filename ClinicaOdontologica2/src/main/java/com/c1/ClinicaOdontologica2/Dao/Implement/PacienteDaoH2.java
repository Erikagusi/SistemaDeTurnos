package com.c1.ClinicaOdontologica2.Dao.Implement;

import com.c1.ClinicaOdontologica2.Dao.BDH2;
import com.c1.ClinicaOdontologica2.Dao.Idao;
import com.c1.ClinicaOdontologica2.Entity.Domicilio;
import com.c1.ClinicaOdontologica2.Entity.Paciente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class PacienteDaoH2 implements Idao<Paciente> {
    private static final String SQL_INSERT = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES (?,?,?.?,?,?)";
    private static final String SQL_SELECT_ONE = "SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SELECT_EMAIL = "SELECT * FROM PACIENTES WHERE EMAIL=?";

    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";
    private static final String SQL_DELETE = "DELETE FROM PACIENTES WHERE ID=?";
    private static final String SQL_UPDATE = "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, CEDULA=?, FECHAINGRESO=?, DOMICILIO=?, EMAIL=? WHERE ID=?";

    @Override
    public Paciente guardar(Paciente paciente) {
        log.info("Iniciando operacion de: guardar un Paciente");
        Connection connection = null;
        DomicilioDaoH2 daoAux =new DomicilioDaoH2();
        Domicilio domicilio =daoAux.guardar(paciente.getDomicilio());


        try {
            connection = BDH2.getConnnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApeliido());
            psInsert.setString(3, paciente.getCedula());
            psInsert.setDate(4,Date.valueOf(paciente.getFechaIngreso()));
            psInsert.setInt(5, domicilio.getId());
            psInsert.setString(6, paciente.getEmail());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                paciente.setId(rs.getInt(1)); //La ubicacion del id en la columna de la tabla
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return paciente;


    }

    @Override
    public Paciente buscar(Integer id) {
        log.info("Iniciando operacion de: Buscar un Paciente");
        Connection connection = null;

        Paciente paciente = null;
        Domicilio domicilio = null;
        DomicilioDaoH2 daoaux = new DomicilioDaoH2();

        try {

            connection = BDH2.getConnnection();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1, id);
            ResultSet rs = psSelectOne.executeQuery();
            while (rs.next()) {
                domicilio = daoaux.buscar(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(),domicilio ,rs.getString(7));
            }

        } catch(Exception e){
                e.printStackTrace();
        } finally{
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                }
            return paciente;

        }


    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Paciente paciente) {

    }

    @Override
    public List<Paciente> listarTodos() {
        log.info("Iniciando operacion de: Listar Todos los Paciente");
        Connection connection = null;
        List<Paciente> pacientes= new ArrayList<>();
        Paciente paciente= null;
        Domicilio domicilio= null;
        DomicilioDaoH2 daoaux = new DomicilioDaoH2();

        try {

            connection = BDH2.getConnnection();
            PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psSelectAll.executeQuery();
            while (rs.next()) {
                domicilio = daoaux.buscar(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), domicilio, rs.getString(7));
                pacientes.add(paciente);
            }

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return pacientes;
    }

    @Override
    public Paciente buscarporString(String valor) {
        log.info("Iniciando operacion de: Buscado por Email: "+valor);
        Connection connection = null;

        Paciente paciente = null;
        Domicilio domicilio = null;
        DomicilioDaoH2 daoaux = new DomicilioDaoH2();

        try {

            connection = BDH2.getConnnection();
            PreparedStatement psSelectEmail = connection.prepareStatement(SQL_SELECT_EMAIL);
            psSelectEmail.setString(1, valor);
            ResultSet rs = psSelectEmail.executeQuery();
            while (rs.next()) {
                domicilio = daoaux.buscar(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(),domicilio ,rs.getString(7));
            }

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }
}
