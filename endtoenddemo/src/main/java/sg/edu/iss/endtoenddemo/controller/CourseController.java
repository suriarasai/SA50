package sg.edu.iss.endtoenddemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class CourseController {

	@RequestMapping(value = "/list")
	public String list() {
		
		return "course-list";
	}
	@RequestMapping(value = "/add")
	public String addForm() {
		return "course-form";
	}
	@RequestMapping(value = "/edit")
	public String editForm() {
		return "course-form";
	}
	@RequestMapping(value = "/save")
	public String saveCourse() {
		return "forward:/course/list";
	}
	@RequestMapping(value = "/delete")
	public String deleteCourse() {
		return "forward:/course/list";
	}
}
