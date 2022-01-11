package br.com.Lucas.resource;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.Lucas.entity.Employee;
import br.com.Lucas.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	
	private EmployeeService service;
	

	
	
	@GetMapping("/employeers")
	public List<Employee> list(){
		return service.listAll();
	}
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> get(@PathVariable Long id){
		try {
			Employee employee = service.get(id);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
			
		}catch(NoSuchElementException ex) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	
	
	@PutMapping("/employee/update/{id}")
	public ResponseEntity<?> update(@RequestBody Employee e, @PathVariable Long id){
	
	try {
		Employee employeeExist = service.get(id);
		service.save(e);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}catch (NoSuchElementException ex) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	}
}
