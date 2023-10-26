package com.jenncodes.rentalcarspringbootbackend;

import com.jenncodes.rentalcarspringbootbackend.model.RentalVehicle;
import com.jenncodes.rentalcarspringbootbackend.repository.RentalVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RentalcarSpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RentalcarSpringbootBackendApplication.class, args);
	}

	@Autowired
	private RentalVehicleRepository rentalVehicleRepository;

	@Override
	public void run(String... args) throws Exception{
		RentalVehicle rentalVehicle = new RentalVehicle();
		rentalVehicle.setColor("red");
		rentalVehicle.setVehicleType("Motorcycle");
		rentalVehicle.setMake("Kawasaki");
		rentalVehicle.setYear("2023");
		rentalVehicle.setMileage("1,100");
		rentalVehicle.setModel("Ninja 650");

		RentalVehicle rentalVehicle1 = new RentalVehicle();
		rentalVehicle1.setColor("black");
		rentalVehicle1.setVehicleType("Sedan");
		rentalVehicle1.setMake("Honda");
		rentalVehicle1.setYear("2023");
		rentalVehicle1.setMileage("5,003");
		rentalVehicle1.setModel("Civic");

		rentalVehicleRepository.save(rentalVehicle);
		rentalVehicleRepository.save(rentalVehicle1);
	}
}
