package com.example.demo.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Employee;
import com.example.demo.model.ParkingSpace;
import com.example.demo.model.User;

@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository urepo;
	

	@Test
	public void findByUserNameLikeTest() {
		List<User> userList1 = urepo.findByUserNameLike("C%");
		for (Iterator<User> iterator = userList1.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user.toString());
			assertEquals(user.getUserName().charAt(0), 'C');
		}
	}

	@Test
	public void findByNickNameLike() {
		List<User> userList2 = urepo.findByNickNameLike("%Fast%");
		for (Iterator<User> iterator = userList2.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user.toString());

		}
	}

	@Test
	public void createData() {

		User u1 = new User("Suria", "Too Fast");
		User u2 = new User("Chua Khiong Kiat", "Pleasant");
		User u3 = new User("Martin", "Cheer Leader");
		User u4 = new User("Zhang", "Builder");
		User u5 = new User("Rohan", "Configuarator");
		User u6 = new User("Lim", "Comparable");
		urepo.save(u1);
		urepo.save(u2);
		urepo.save(u3);
		urepo.save(u4);
		urepo.save(u5);
		urepo.save(u6);
	}

	@Test
	public void findAll() {

		List<User> ulist = urepo.findAll();
		for (Iterator<User> iterator = ulist.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user.toString());
		}
		
	}
	
	@Test
	public void finNamesTest() {
		
		List<String> namelist = urepo.findNames("Builder");
		for (Iterator<String> iterator = namelist.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			if (string.equalsIgnoreCase("Zhang")) System.out.println("Pass");
		}
	}

}
