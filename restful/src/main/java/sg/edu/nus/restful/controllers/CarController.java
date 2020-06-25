package sg.edu.nus.restful.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.restful.domain.Car;
import sg.edu.nus.restful.domain.Owner;
import sg.edu.nus.restful.repo.CarRepository;
import sg.edu.nus.restful.repo.OwnerRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository carrepo;
	@Autowired
	private OwnerRepository ownrepo;
	
	@RequestMapping("/cars")
    public Iterable<Car> getCars() {
		return carrepo.findAll();
	}
	
	@RequestMapping("/owners")
    public Iterable<Owner> getOwners() {
		return ownrepo.findAll();
	}
    
	@RequestMapping("/cars/brands")
    public Iterable<Car> getBrands(String brand) {
		return carrepo.findByBrand(brand);
	}
	
}
