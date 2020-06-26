package sg.edu.nus.reactive.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import sg.edu.nus.reactive.domain.Employee;
import sg.edu.nus.reactive.domain.Role;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
	Flux<Employee> findByRole(Role role);

	Flux<Employee> findByLast(String last);
}
