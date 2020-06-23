package sg.edu.iss.endtoenddemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.endtoenddemo.domain.Department;
import sg.edu.iss.endtoenddemo.domain.Employee;
import sg.edu.iss.endtoenddemo.service.DepartmentService;
import sg.edu.iss.endtoenddemo.service.DepartmentServiceImpl;
import sg.edu.iss.endtoenddemo.service.EmployeeService;
import sg.edu.iss.endtoenddemo.service.EmployeeServiceImpl;

@Controller
@RequestMapping(value = "/emp")
public class EmployeeController {
	
	@Autowired
	protected EmployeeService eservice ;
	
	@Autowired
	public void setEmployeeService(EmployeeServiceImpl serviceImpl) {
		this.eservice = serviceImpl;		
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("elist", eservice.findAll());
		return "employee-list";
	}
	
	@Autowired
	private DepartmentService dservice;
	
	@Autowired
	public void setDepartmentService(DepartmentServiceImpl dserviceImpl) {
		this.dservice = dserviceImpl;
	}
	
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("dnames",dservice.findAllDepartmentNames());
		return "employee-form";
	}
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		Employee emp = eservice.findEmployeeById(id);
		model.addAttribute("employee", emp);
		model.addAttribute("dnames",dservice.findAllDepartmentNames());
		return "employee-form";
	}
	@RequestMapping(value = "/save")
	public String saveEmployee(@ModelAttribute("employee") @Valid Employee emp, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("employee", emp);
			model.addAttribute("dnames",dservice.findAllDepartmentNames());
			return "employee-form";
		}
		Department d = dservice.findDepartmentByName(emp.getDepartment().getName());
		emp.setDepartment(d);
		eservice.saveEmployee(emp);
		return "forward:/emp/list";
	}
	@RequestMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		eservice.deleteEmployee(eservice.findEmployeeById(id));
		return "forward:/emp/list";
	}
}
