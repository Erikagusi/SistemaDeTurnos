package com.c1.ClinicaOdontologica2.Dao.Implement;

import com.c1.ClinicaOdontologica2.Dao.BDH2;
import com.c1.ClinicaOdontologica2.Dao.Idao;
import com.c1.ClinicaOdontologica2.Entity.Domicilio;
import com.c1.ClinicaOdontologica2.Entity.Odontologo;
import com.c1.ClinicaOdontologica2.Entity.Paciente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class OdontologoDaoH2 implements Idao<Odontologo> {
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
    private static final String SQL_SELECT_ONE = "SELECT * FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    private static final String SQL_DELETE = "DELETE FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA=?, NOMBRE=?, APELLIDO=? WHERE ID=?";

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        log.info("Iniciando operacion de: guardar un Odontologo");
        Connection connection = null;

        try {
            connection = BDH2.getConnnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());

             psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                odontologo.setId(rs.getInt(1)); //La ubicacion del id en la columna de la tabla
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
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        log.info("Iniciando operacion de: Buscar un Odontologo");
        Connection connection = null;

        Odontologo odontologo = null;

        try {

            connection = BDH2.getConnnection();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1, id);
            ResultSet rs = psSelectOne.executeQuery();
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
        return odontologo;    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

        log.info("Iniciando operacion de Actualizar Odontologo");
        Connection connection = null;

        try {

            connection = BDH2.getConnnection();


            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            //Parametrizadas
            psUpdate.setString(3, odontologo.getMatricula());
            psUpdate.setString(1, odontologo.getNombre());
            psUpdate.setString(2, odontologo.getApellido());
            psUpdate.setInt(7, odontologo.getId());
            psUpdate.execute();


        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        log.info("Iniciando operacion de: Listar Todos los Odontologos");
        Connection connection = null;
        List<Odontologo> odontologos= new ArrayList<>();
        Odontologo odontologo = null;

        try {

            connection = BDH2.getConnnection();
            PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psSelectAll.executeQuery();
            while (rs.next()) {

                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                odontologos.add(odontologo);
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
        return odontologos;    }

    @Override
    public Odontologo buscarporString(String valor) {
        return null;
    }
}
