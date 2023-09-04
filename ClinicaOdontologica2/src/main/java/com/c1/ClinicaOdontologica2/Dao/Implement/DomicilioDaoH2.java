package com.c1.ClinicaOdontologica2.Dao.Implement;

import com.c1.ClinicaOdontologica2.Dao.BDH2;
import com.c1.ClinicaOdontologica2.Dao.Idao;
import com.c1.ClinicaOdontologica2.Entity.Domicilio;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.List;

@Slf4j


public class DomicilioDaoH2 implements Idao<Domicilio> {
    private static final String SQL_INSERT = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)";
    private static final String SQL_SELECT_ONE = "SELECT * FROM DOMICILIOS WHERE ID=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM DOMICILIOS";
    private static final String SQL_DELETE = "DELETE FROM DOMICILIOS WHERE ID=?";
    private static final String SQL_UPDATE = "UPDATE DOMICILIOS SET CALLE=?, NUMERO=?, LOCALIDAD=?, PROVINCIA=? WHERE ID=?";

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        log.info("Iniciando operacion de: guardar un domicilio");
        Connection connection = null;
        try {
            connection = BDH2.getConnnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, domicilio.getCalle());
            psInsert.setInt(2, domicilio.getNumero());
            psInsert.setString(3, domicilio.getLocalidad());
            psInsert.setString(4, domicilio.getProvincia());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                domicilio.setId(rs.getInt(1)); //La ubicacion del id en la columna de la tabla
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
        return domicilio;

    }



    @Override
    public Domicilio buscar(Integer id) {
        log.info("Iniciando operacion de: buscar un domicilio");
        Connection connection = null;
        Domicilio domicilio = null;

        try{
            connection=BDH2.getConnnection();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
           ResultSet rs= psSelectOne.executeQuery();
           while (rs.next()){
               domicilio=new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));

    }
    }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public void eliminar(Integer id) {
        log.info("Iniciando operacion de: eliminar un domicilio");

    }

    @Override
    public void actualizar(Domicilio domicilio) {
        log.info("Iniciando operacion de: actualizar un domicilio");

    }

    @Override
    public List<Domicilio> listarTodos() {
        log.info("Iniciando operacion de: Listar un domicilio");

        return null;
    }

    @Override
    public Domicilio buscarporString(String valor) {
        return null;
    }
}
