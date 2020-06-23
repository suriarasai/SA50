package sg.edu.iss.endtoenddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dept")
public class DepartmentController {
    
	@RequestMapping(value = "/list")
	public String list() {
		
		return "department-list";
	}
	@RequestMapping(value = "/add")
	public String addForm() {
		return "department-form";
	}
	@RequestMapping(value = "/edit")
	public String editForm() {
		return "department-form";
	}
	@RequestMapping(value = "/save")
	public String saveDepartment() {
		return "forward:/dept/list";
	}
	@RequestMapping(value = "/delete")
	public String deleteDepartment() {
		return "forward:/dept/list";
	}
	
}
