package sg.edu.nus.reactive.repo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import sg.edu.nus.reactive.domain.Employee;
import sg.edu.nus.reactive.domain.Role;


@SpringBootTest
public class EmployeeRepositoryTest {
	@Autowired
    private EmployeeRepository repository;
	
	private List<Employee> employees = Arrays.asList(
            new Employee(Role.STAFF, "Dilbert", "Geek"),
            new Employee(Role.STAFF, "Alice", "Nerd"),
            new Employee(Role.STAFF, "Wally", "Sneaky"),
            new Employee(Role.MANAGER, "Pointy", "Eggy"),
            new Employee(Role.ADMIN, "Catbert", "HR"));

    @BeforeEach
    public void setUp() {
        repository.deleteAll()
                  .thenMany(Flux.fromIterable(employees))
                  .flatMap(repository::save)
                  .doOnNext(System.out::println)
                  .blockLast();
    }

    @Test
    public void save() {
        Employee lorca = new Employee(Role.MANAGER, "Dogbert", "CEO");
        StepVerifier.create(repository.save(lorca))
                    .expectNextMatches(employee -> !employee.getId().equals(""))
                    .verifyComplete();
    }

    @Test
    public void findAll() {
        StepVerifier.create(repository.findAll())
                    .expectNextCount(5)
                    .verifyComplete();
    }

    @Test
    public void findById() {
        employees.stream()
                .map(Employee::getId)
                .forEach(id ->
                                 StepVerifier.create(repository.findById(id))
                                             .expectNextCount(1)
                                             .verifyComplete());
    }

    @Test
    public void findByIdNotExist() {
        StepVerifier.create(repository.findById("xyz"))
                    .verifyComplete();
    }

    @Test
    public void count() {
        StepVerifier.create(repository.count())
                    .expectNext(5L)
                    .verifyComplete();
    }

	/*
	 * @Test public void findByRole() { StepVerifier.create(
	 * repository.findByRole(Role.STAFF) .map(Employee::getRole) .distinct())
	 * .expectNextCount(1) .verifyComplete();
	 * 
	 * StepVerifier.create( repository.findByRole(Role.MANAGER)
	 * .map(Employee::getRole) .distinct()) .verifyComplete(); }
	 * 
	 * @Test public void findByLast() { employees.stream() .map(Employee::getLast)
	 * .forEach(lastName -> StepVerifier.create(repository.findByLast(lastName))
	 * .expectNextMatches(employee -> employee.getLast().equals(lastName))
	 * .verifyComplete()); }
	 */
}
