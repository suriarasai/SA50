package com.example.demo.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.model.Product;

public class ProductValidator implements Validator {

	
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if(product.getName().length() >20)
		{
			errors.rejectValue("name", "name is long");
		}
		

}

}
