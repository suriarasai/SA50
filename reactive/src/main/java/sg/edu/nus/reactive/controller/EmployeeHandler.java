package sg.edu.nus.reactive.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import sg.edu.nus.reactive.domain.Employee;
import sg.edu.nus.reactive.repo.EmployeeRepository;

@Component
public class EmployeeHandler {
	
	private EmployeeRepository repository;

    public EmployeeHandler(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> listEmployees(ServerRequest request) {
        return ServerResponse.ok()
                             .contentType(APPLICATION_JSON)
                             .body(repository.findAll(), Employee.class);
    }

    public Mono<ServerResponse> createEmployee(ServerRequest request) {
        Mono<Employee> employeeMono = request.bodyToMono(Employee.class);
        return employeeMono.flatMap(employee ->
                                           ServerResponse.status(HttpStatus.CREATED)
                                                         .contentType(APPLICATION_JSON)
                                                         .body(repository.save(employee), Employee.class));
    }

    public Mono<ServerResponse> getEmployee(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Employee> personMono = this.repository.findById(id);
        return personMono
                .flatMap(person -> ServerResponse.ok()
                                                 .contentType(APPLICATION_JSON)
                                                 .body(fromObject(person)))
                .switchIfEmpty(notFound);
    }
}
