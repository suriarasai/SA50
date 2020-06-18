package com.example.demo.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Employee;
import com.example.demo.model.ParkingSpace;

@SpringBootTest
public class EmployeeRepositoryTests {

	@Autowired
	EmployeeRepository erepo;

	@Autowired
	ParkingSpaceRepository prepo;

	@Test
	public void createData() {
		Employee e1 = new Employee("Tin", 10000);
		Employee e2 = new Employee("Cher Wah", 12000);
		Employee e3 = new Employee("Suria", 1200);
		ParkingSpace ps1 = new ParkingSpace(1, "ISS", e1);
		ParkingSpace ps2 = new ParkingSpace(2, "ISS", e2);
		ParkingSpace ps3 = new ParkingSpace(3, "ISS", e3);
		e1.setParkingSpace(ps1);
		e2.setParkingSpace(ps2);
		e3.setParkingSpace(ps3);
		erepo.save(e1);
		erepo.save(e2);
		erepo.save(e3);
	}
}
