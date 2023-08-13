package com.electricguitars.electricguitars;

import com.electricguitars.electricguitars.dao.ElectricGuitarDAO;
import com.electricguitars.electricguitars.entity.ElectricGuitar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ElectricguitarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricguitarsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ElectricGuitarDAO electricGuitarDAO) {
		return runner -> {
			//createElectricGuitar(electricGuitarDAO);
			//findElectricGuitar(electricGuitarDAO);
			//findAllElectricGuitars(electricGuitarDAO);
			//findElectricGuitarByBrand(electricGuitarDAO);
			changeElectricGuitar(electricGuitarDAO);
		};
	}

	private void changeElectricGuitar(ElectricGuitarDAO electricGuitarDAO) {
		Scanner scanner = new Scanner(System.in);

		findAllElectricGuitars(electricGuitarDAO);

		System.out.println("Enter the id of electric guitar to update: ");
		int idToUpdate = scanner.nextInt();

		ElectricGuitar theElectricGuitar = electricGuitarDAO.findById(idToUpdate);

		theElectricGuitar.setBrand("PRS");
		theElectricGuitar.setModel("Custom 24");
		theElectricGuitar.setPickup("HH");
		theElectricGuitar.setFretCount(24);
		theElectricGuitar.setWoodType("Rosewood");

		System.out.println("Updating electric guitar...");
		electricGuitarDAO.update(theElectricGuitar);

		System.out.println("Database updated. New electric guitars are: ");
		findAllElectricGuitars(electricGuitarDAO);

	}

	private void findElectricGuitarByBrand(ElectricGuitarDAO electricGuitarDAO) {
		String electricGuitarBrandToFind;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the brand of electric guitars that you want to retrieve: ");
		electricGuitarBrandToFind = scanner.nextLine();

		System.out.println(electricGuitarDAO.findByBrand(electricGuitarBrandToFind));
	}

	private void findAllElectricGuitars(ElectricGuitarDAO electricGuitarDAO) {
		System.out.println("Getting all electric guitars...");
		List<ElectricGuitar> allElectricGuitars = electricGuitarDAO.findAll();
		for(ElectricGuitar tempElectricGuitar : allElectricGuitars) {
			System.out.println(tempElectricGuitar);
		}
		return;
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
