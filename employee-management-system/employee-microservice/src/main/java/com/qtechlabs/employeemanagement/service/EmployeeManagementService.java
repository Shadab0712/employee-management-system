package com.qtechlabs.employeemanagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qtechlabs.employeemanagement.dto.EmployeeDTO;
import com.qtechlabs.employeemanagement.model.Employee;
import com.qtechlabs.employeemanagement.repository.EmployeeManagementRepository;

@Service
public class EmployeeManagementService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeManagementRepository repository;

	public String createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		repository.save(employee);

		RestTemplate httpJavaClient = new RestTemplate();
		ResponseEntity<String> response = httpJavaClient.exchange("http://email-microservice-container:9096/api/v1/email/welcome",
				HttpMethod.GET, null, String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			return "Employee Registered successfully ";
		} else {
			return null;
		}
	}

	public EmployeeDTO getEmployee(Long employeeId) {
		Optional<Employee> employeeById = repository.findById(employeeId);
		if (employeeById.isPresent()) {
			Employee employeeInDatabase = employeeById.get();
			EmployeeDTO employeeDTO = modelMapper.map(employeeInDatabase, EmployeeDTO.class);
			return employeeDTO;
		}
		return null;
	}

	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
		Optional<Employee> employeeById = repository.findById(employeeId);
		if (employeeById.isPresent()) {
			Employee employeeInDatabase = employeeById.get();

			employeeInDatabase.setMobileNumber(employeeInDatabase.getMobileNumber());
			employeeInDatabase.setAddress(employeeInDatabase.getAddress());

			employeeInDatabase.setUpdatedAt(new Date());

			Employee updatedEmployee = repository.save(employeeInDatabase);
			EmployeeDTO updatedEmployeeDTO = modelMapper.map(updatedEmployee, EmployeeDTO.class);
			return updatedEmployeeDTO;
		}
		return null;
	}

	public boolean deleteEmployee(Long employeeId) {
		Optional<Employee> employeeById = repository.findById(employeeId);
		if (employeeById.isPresent()) {
			Employee employeeInDatabase = employeeById.get();
			employeeInDatabase.setDeletedAt(new Date()); // Set the deletedAt field
			repository.save(employeeInDatabase);
			return true;
		}
		return false;
	}

	public List<EmployeeDTO> getAllEmployees() {
		ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();
		Iterable<Employee> allEmployeesDetails = repository.findAll();
		for (Employee employees : allEmployeesDetails) {
			EmployeeDTO employeeDTO = modelMapper.map(employees, EmployeeDTO.class);
			allEmployees.add(employeeDTO);
		}
		return allEmployees;
	}

}
