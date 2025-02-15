package com.ems.EmployeeManagementSystem.Entity;

import java.time.LocalDate;

import org.springframework.boot.context.properties.bind.Name;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "employee_Info", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name cannot be blank")
	@Name("Name is Not Duplicates")
	private String name;

	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be blank")
	private String email;

	@NotBlank(message = "Department cannot be blank")
	private String department;

	@Positive(message = "Salary must be positive")
	private double salary;

	private LocalDate joiningDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + ", salary="
				+ salary + ", joiningDate=" + joiningDate + "]";
	}

	public Employee(Long id, @NotBlank(message = "Name cannot be blank") String name,
			@Email(message = "Invalid email format") @NotBlank(message = "Email cannot be blank") String email,
			@NotBlank(message = "Department cannot be blank") String department,
			@Positive(message = "Salary must be positive") double salary, LocalDate joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	public Employee() {
		super();
		
	}
	
	
	
	
	

}
