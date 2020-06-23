package sg.edu.iss.endtoenddemo.service;

import java.util.ArrayList;

import sg.edu.iss.endtoenddemo.domain.Department;

public interface DepartmentService {
	public ArrayList<Department> findAll();
	public boolean saveDepartment(Department dept);
	public void deleteDepartment(Department dept);
	public ArrayList<String> findAllDepartmentNames();
	public Department findDepartmentByName(String name);
	public Department findDepartmentById(Integer id);
}
