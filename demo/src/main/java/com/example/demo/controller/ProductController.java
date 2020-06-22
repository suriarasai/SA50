package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repo.ProductRepository;

@Controller
@RequestMapping("/product")
@SessionAttributes("user")
public class ProductController {
	
	@Autowired
	ProductRepository pRepo;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProductValidator());
		
	}

	@GetMapping("/list")
	public String listAll(Model model, User user) { 
		model.addAttribute("products", pRepo.findAll());
		user.setUserName("Dilbert");
		return "products";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "productform";
	}

	@GetMapping("/save")
	public String saveProduct(  @ModelAttribute("product") @Valid Product product, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "productform";
		}
		pRepo.save(product);
		return "forward:/product/list";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditForm(Model model, @PathVariable("id") Integer id) {	
		model.addAttribute("product", pRepo.findById(id).get());
		return "productform";
	}
	@GetMapping("/delete/{id}")
	public String deleteMethod(Model model, @PathVariable("id") Integer id) {
		Product product = pRepo.findById(id).get();
		pRepo.delete(product);
		return "forward:/product/list";
	}
}
