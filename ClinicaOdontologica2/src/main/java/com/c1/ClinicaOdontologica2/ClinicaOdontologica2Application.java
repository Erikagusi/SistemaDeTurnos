package com.c1.ClinicaOdontologica2;

import com.c1.ClinicaOdontologica2.Dao.BDH2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologica2Application {

	public static void main(String[] args) {

		SpringApplication.run(ClinicaOdontologica2Application.class, args);
		BDH2.crearTabla();
	}

}
