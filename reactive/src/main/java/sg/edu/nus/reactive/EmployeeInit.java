package sg.edu.nus.reactive;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import sg.edu.nus.reactive.domain.Employee;
import sg.edu.nus.reactive.domain.Role;
import sg.edu.nus.reactive.repo.EmployeeRepository;

@Component
public class EmployeeInit implements ApplicationRunner {
	private EmployeeRepository erepo;

	public EmployeeInit(EmployeeRepository erepo) {
		this.erepo = erepo;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		erepo.deleteAll()
				.thenMany(Flux.just(new Employee(Role.STAFF, "Alice1", "Nerd1"),
						new Employee(Role.STAFF, "Wally1", "Sneaky1"), new Employee(Role.MANAGER, "Pointy1", "Eggy1")))
				.flatMap(erepo::save).thenMany(erepo.findAll()).subscribe(System.out::println);
	}
}
