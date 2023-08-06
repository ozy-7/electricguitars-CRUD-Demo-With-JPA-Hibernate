package com.example.cruddemo.electricguitars.electricguitars;

import com.example.cruddemo.electricguitars.electricguitars.dao.ElectricGuitarDAO;
import com.example.cruddemo.electricguitars.electricguitars.entity.ElectricGuitar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElectricguitarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricguitarsApplication.class, args);


	}



	@Bean
	public CommandLineRunner commandLineRunner(ElectricGuitarDAO electricGuitarDao) {
		return runner -> {
			createElectricGuitar(electricGuitarDao);
		};
	}

	private void createElectricGuitar(ElectricGuitarDAO electricGuitarDao) {
		//create a new electric guitar
		System.out.println("Creating a new electric guitar object...");
		ElectricGuitar tempElectricGuitar = new ElectricGuitar("ESP", "LTD M-100", "HH", 24, "Rosewood");

		//save the electric guitar
		System.out.println("Saving the electric guitar...");
		electricGuitarDao.save(tempElectricGuitar);

		//display the id of saved electric guitar
		System.out.println("Saved the electric guitar. Generated id:" + tempElectricGuitar.getId());
	}



}
