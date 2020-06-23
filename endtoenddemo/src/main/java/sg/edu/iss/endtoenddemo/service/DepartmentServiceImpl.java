package sg.edu.iss.endtoenddemo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import sg.edu.iss.endtoenddemo.domain.Department;
import sg.edu.iss.endtoenddemo.repo.DepartmentRepository;

public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository drepo;

	@Override
	public ArrayList<Department> findAll() {
		    ArrayList<Department> list = (ArrayList<Department>) drepo.findAll();
			return list;
	}

	@Override
	public boolean createDepartment(Department dept) {
		if(drepo.save(dept)!=null) return true; else return false;
	}

	@Override
	public boolean editDepartment(Department dept) {
		if(drepo.save(dept)!=null) return true; else return false;
	}

	@Override
	public void deleteDepartment(Department dept) {
		drepo.delete(dept);
	}

	@Override
	public ArrayList<String> findAllDepartmentNames() {
		return drepo.findAllDepartmentNames();
	}

	@Override
	public Department findDepartmentByName(String name) {
		ArrayList<Department> list = (ArrayList<Department>) drepo.findByName(name);
		return list.get(0);
	}

}
