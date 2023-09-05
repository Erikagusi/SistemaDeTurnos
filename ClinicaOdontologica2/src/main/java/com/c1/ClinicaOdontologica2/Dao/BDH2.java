package com.c1.ClinicaOdontologica2.Dao;

import com.c1.ClinicaOdontologica2.Service.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@Slf4j
@Component
public class BDH2 {
    private static final String SQL_CREATE="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(20) NOT NULL, APELLIDO VARCHAR(20) NOT NULL);" +
            "DROP TABLE IF EXISTS PACIENTES; " +
            "CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, CEDULA VARCHAR(20) NOT NULL, FECHA_INGRESO DATE NOT NULL, DOMICILIO_ID INT NOT NULL, EMAIL VARCHAR(100) NOT NULL);" +
            "DROP TABLE IF EXISTS DOMICILIOS; CREATE TABLE DOMICILIOS(ID INT AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(100) NOT NULL, NUMERO INT NOT NULL, LOCALIDAD VARCHAR (100) NOT NULL, PROVINCIA VARCHAR (100) NOT NULL);";

private static final String sql_prueba="" +
        "INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES" +
        "('Erika', 'Guarin', '123', '2023-08-09', 1, 'Erika@hotmail.com'), " +
        "('Andy', 'Castellanos', '234', '2022-09-01', 2,'andy@hotmail.com'); "+
        "INSERT INTO DOMICILIOS (CALLE, NUMERO,LOCALIDAD, PROVINCIA) VALUES('PRIMERA', 345, 'Manga', 'Pereira'), ('Segunda', 543, 'Caracoles', 'Cartagena')";

public static void crearTabla(){
        Connection connection = null;
        try{
            connection = getConnnection();

            //CREACION DE LA TABLA ODONTOLOGO
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);
            statement.execute(sql_prueba);
            log.info("Datos cargados");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public static Connection getConnnection() throws Exception{
        Class.forName("org.h2.Driver");
        log.info("conexion con Driver exitosa");
        return DriverManager.getConnection("jdbc:h2:~/clinicaOdontologica","admin","admin");
    }
}
