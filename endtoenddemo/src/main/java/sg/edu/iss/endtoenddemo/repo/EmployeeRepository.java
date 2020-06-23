package sg.edu.iss.endtoenddemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.endtoenddemo.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllEmployeesByName(String name);

}
