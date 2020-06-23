package sg.edu.iss.endtoenddemo.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.endtoenddemo.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	List<Department> findByName(String name);
	
	@Query("Select d.name from Department d")
	ArrayList<String> findAllDepartmentNames();

}
