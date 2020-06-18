package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository pRepo;

	@GetMapping("/list")
	public String listAll(Model model) {
		model.addAttribute("products", pRepo.findAll());
		return "products";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "productform";
	}

	@GetMapping("/save")
	public String saveProduct( @ModelAttribute("product") Product product,  Model model) {
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
