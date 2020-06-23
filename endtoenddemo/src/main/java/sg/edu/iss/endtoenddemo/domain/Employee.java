package sg.edu.iss.endtoenddemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String userId;
	@NotEmpty
	private String password;
	@ManyToOne	
	private Department department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, @NotEmpty String name, @NotEmpty String userId, @NotEmpty String password,
			Department department) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.department = department;
	}

	public Employee(@NotEmpty String name, @NotEmpty String userId, @NotEmpty String password, Department department) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", userId=" + userId + ", password=" + password + "]";
	}

}
