package com.ems.EmployeeManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.EmployeeManagementSystem.Entity.Employee;
import com.ems.EmployeeManagementSystem.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeerRepository;

	public Employee saveEmployee(Employee employee) {
		Employee save = employeerRepository.save(employee);
		if (employee != null) {
			employeerRepository.save(employee);
		System.out.println("Save Scuuessfully" + save);
		} else {
			System.out.println("Not Save Data");
		}
		return employee;

	}

	public List<Employee> getAllEmployees() {
		return employeerRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeerRepository.findById(id);
	}

	@Transactional
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Employee existingEmployee = employeerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));

		existingEmployee.setName(updatedEmployee.getName());
		existingEmployee.setEmail(updatedEmployee.getEmail());
		existingEmployee.setDepartment(updatedEmployee.getDepartment());
		existingEmployee.setSalary(updatedEmployee.getSalary());
		existingEmployee.setJoiningDate(updatedEmployee.getJoiningDate());

		return employeerRepository.save(existingEmployee);
	}

	@Transactional
	public void deleteEmployee(Long id) {
		employeerRepository.deleteById(id);
	}

}
