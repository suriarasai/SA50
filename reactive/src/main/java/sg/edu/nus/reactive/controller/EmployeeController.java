package sg.edu.nus.reactive.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sg.edu.nus.reactive.domain.Employee;
import sg.edu.nus.reactive.repo.EmployeeRepository;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	    private EmployeeRepository repository;

	    public EmployeeController(EmployeeRepository repository) {
	        this.repository = repository;
	    }

	    @GetMapping
	    public Flux<Employee> getAllEmployees() {
	        return repository.findAll();
	    }

	    @GetMapping("{id}")
	    public Mono<Employee> getEmployee(@PathVariable String id) {
	        return repository.findById(id);
	    }

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Mono<Employee> saveEmployee(@RequestBody Employee employee) {
	        return repository.save(employee);
	    }

	    @PutMapping("{id}")
	    public Mono<ResponseEntity<Employee>> updateEmployee(@PathVariable(value = "id") String id,
	                                                       @RequestBody Employee employee) {
	        return repository.findById(id)
	                         .flatMap(existingEmployee -> {
	                             existingEmployee.setRole(employee.getRole());
	                             existingEmployee.setFirst(employee.getFirst());
	                             existingEmployee.setLast(employee.getLast());
	                             return repository.save(existingEmployee);
	                         })
	                         .map(updateEmployee -> new ResponseEntity<>(updateEmployee, HttpStatus.OK))
	                         .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @DeleteMapping("{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public Mono<ResponseEntity<Object>> deleteEmployee(@PathVariable(value = "id") String id) {
	        return repository.deleteById(id)
	                         .then(Mono.just(ResponseEntity.noContent().build()))
	                         .defaultIfEmpty(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping
	    public Mono<Void> deleteAllEmployees() {
	        return repository.deleteAll();
	    }
}

