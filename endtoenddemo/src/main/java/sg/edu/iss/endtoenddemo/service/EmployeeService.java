package sg.edu.iss.endtoenddemo.service;

import java.util.ArrayList;

import sg.edu.iss.endtoenddemo.domain.Employee;

public interface EmployeeService {
	public ArrayList<Employee> findAll();
	public boolean saveEmployee(Employee emp);
	public void deleteEmployee(Employee emp);
	public ArrayList<String> findAllEmployeeNames(String name);
	public Employee findEmployeeById(Integer id);
}
