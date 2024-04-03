package com.qtechlabs.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qtechlabs.employeemanagement.dto.EmployeeDTO;
import com.qtechlabs.employeemanagement.service.EmployeeManagementService;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin
public class EmployeeManagementAPI {

	@Autowired
	private EmployeeManagementService service;

	// POST/CREATE/INSERT
	@PostMapping("/")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		service.createEmployee(employeeDTO);
		return new ResponseEntity<String>("Employee Created", HttpStatus.CREATED);
	}

	// GET/RETRIEVE/SELECT
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId) {
		EmployeeDTO employee = service.getEmployee(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	// GET ALL DETAILS OF EMPLOYEES
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> allEmployees = service.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}

	// PUT/UPDATE/UPDATE
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long employeeId,
			@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO updateEmployee = service.updateEmployee(employeeId, employeeDTO);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}

	// DELETE/DELETE/DELETE
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
		service.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
	}

}