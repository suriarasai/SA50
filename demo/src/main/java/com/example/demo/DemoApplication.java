package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Employee;
import com.example.demo.model.ParkingSpace;
import com.example.demo.model.User;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.ParkingSpaceRepository;
import com.example.demo.repo.UserRepository;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
    UserRepository urepo;
	
	@Autowired
    EmployeeRepository erepo; 
	
	@Autowired
    ParkingSpaceRepository prepo; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	return args -> {
		
		/*
		 * User u1 = new User("Suria","Too Fast"); System.out.println(u1.toString());
		 * User u2 = new User("Chua Khiong Kiat","Pleasant");
		 * System.out.println(u2.toString()); User u3 = new
		 * User("Martin","Cheer Leader"); System.out.println(u3.toString()); User u4 =
		 * new User("Zhang","Builder"); System.out.println(u4.toString()); User u5 = new
		 * User("Rohan","Configuarator"); System.out.println(u5.toString()); User u6 =
		 * new User("Lim","Comparable"); System.out.println(u6.toString());
		 * 
		 * 
		 * urepo.save(u1); urepo.save(u2); urepo.save(u3); urepo.save(u4);
		 * urepo.save(u5); urepo.save(u6);
		 * 
		 * List<User> ulist = urepo.findAll(); for (Iterator<User> iterator =
		 * ulist.iterator(); iterator.hasNext();) { User user = (User) iterator.next();
		 * System.out.println(user.toString()); }
		 * 
		 * 
		 * Employee e1 = new Employee("Tin", 10000); Employee e2 = new
		 * Employee("Cher Wah", 12000); Employee e3 = new Employee("Suria", 1200);
		 * ParkingSpace ps1 = new ParkingSpace(1, "ISS", e1); ParkingSpace ps2 = new
		 * ParkingSpace(2, "ISS", e2); ParkingSpace ps3 = new ParkingSpace(3, "ISS",
		 * e3); e1.setpSpace(ps1);e2.setpSpace(ps2);e3.setpSpace(ps3);
		 * erepo.save(e1);erepo.save(e2);erepo.save(e3);
		 */
		
		List<User> userList1 = urepo.findByUserNameLike("C%");
		for (Iterator<User> iterator = userList1.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user.toString());
			
		}
		List<User> userList2 = urepo.findByNickNameLike("%Fast%");
		for (Iterator<User> iterator = userList2.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user.toString());
			
		}
		
	};
	
	}

}
