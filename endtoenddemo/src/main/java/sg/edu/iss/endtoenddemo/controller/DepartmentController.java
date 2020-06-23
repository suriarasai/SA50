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
import sg.edu.iss.endtoenddemo.service.DepartmentService;
import sg.edu.iss.endtoenddemo.service.DepartmentServiceImpl;

@Controller
@RequestMapping(value = "/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentService dservice;
	
	@Autowired
	public void setDepartmentService(DepartmentServiceImpl dserviceImpl) {
		this.dservice = dserviceImpl;
	}
    
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("dlist", dservice.findAll());
		return "department-list";
	}
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("department", new Department());
		return "department-form";
	}
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("department", dservice.findDepartmentById(id));
		return "department-form";
	}
	@RequestMapping(value = "/save")
	public String saveDepartment(@ModelAttribute("department") @Valid Department department, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "department-form";
		}
		dservice.saveDepartment(department);
		return "forward:/dept/list";
	}
	@RequestMapping(value = "/delete/{id}")
	public String deleteDepartment(@PathVariable("id") Integer id) {
		dservice.deleteDepartment(dservice.findDepartmentById(id));
		return "forward:/dept/list";
	}
	
}
