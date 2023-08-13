package com.electricguitars.electricguitars;

import com.electricguitars.electricguitars.dao.ElectricGuitarDAO;
import com.electricguitars.electricguitars.entity.ElectricGuitar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class ElectricguitarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricguitarsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ElectricGuitarDAO electricGuitarDAO) {
		return runner -> {
			createElectricGuitar(electricGuitarDAO);
			//findElectricGuitar(electricGuitarDAO);
		};
	}

	private void findElectricGuitar(ElectricGuitarDAO electricGuitarDAO) {
		int electricGuitarIDToFind;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the id of electric guitar that you want to retrieve: ");
		electricGuitarIDToFind = scanner.nextInt();

		System.out.println("Retrieving electric guitar with the ID of: " + electricGuitarIDToFind);

		System.out.println(electricGuitarDAO.findById(electricGuitarIDToFind));
	}

	private void createElectricGuitar(ElectricGuitarDAO electricGuitarDAO) {
		System.out.println("Creating new electric guitar...");
		ElectricGuitar theElectricGuitar = new ElectricGuitar("Schecter", "Solo-II Sgr", "HH", 24, "Mahogany");

		System.out.println("Saving the electric guitar...");
		electricGuitarDAO.save(theElectricGuitar);

		System.out.println("Electric guitar saved. Generated id: " + theElectricGuitar.getId());
	}


}
