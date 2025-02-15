package com.ems.EmployeeManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.EmployeeManagementSystem.Entity.Employee;
import com.ems.EmployeeManagementSystem.Service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/saveEmp")
  @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}

	@GetMapping(path = "/showAll")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping(path = "/findById/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(path = "/updateEmp/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
	}

	@DeleteMapping(path = "/deleteById/{id}")
	 @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted successfully");
	}

}
