package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long salary;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="PSPACE_ID")
	private ParkingSpace pSpace;
		
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public Employee(String name, long salary, ParkingSpace pSpace) {
		super();
		this.name = name;
		this.salary = salary;
		this.pSpace = pSpace;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public ParkingSpace getpSpace() {
		return pSpace;
	}
	public void setpSpace(ParkingSpace pSpace) {
		this.pSpace = pSpace;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", pSpace=" + pSpace + "]";
	}
	
	
	

}
