package sg.edu.iss.endtoenddemo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.endtoenddemo.domain.Employee;
import sg.edu.iss.endtoenddemo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository erepo;
	
	@Override
	public ArrayList<Employee> findAll() {
		return (ArrayList<Employee>)erepo.findAll();
	}

	@Override
	public boolean saveEmployee(Employee emp) {
		if (erepo.save(emp)!=null) return true; else return false;
	}

	@Override
	public void deleteEmployee(Employee emp) {
		erepo.delete(emp);
	}



	@Override
	public ArrayList<String> findAllEmployeeNames(String name) {
		ArrayList<String> names = new ArrayList<String>();
		List<Employee> emplist = erepo.findAllEmployeesByName(name);
		for (Iterator<Employee> iterator = emplist.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			names.add(employee.getName());
		}
		return names;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return erepo.findById(id).get();
	}

}
